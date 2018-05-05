package warfake.war.battlefield;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import warfake.exeptions.NoDeadBodiesException;
import warfake.exeptions.NoEnemiesException;
import warfake.exeptions.NoImprovableTargetsException;
import warfake.exeptions.NoImprovedTargetsException;
import warfake.markers.Aliance;
import warfake.markers.Improvable;
import warfake.markers.Resurectable;
import warfake.war.abstraction.Archer;
import warfake.war.abstraction.Mage;
import warfake.war.abstraction.Person;
import warfake.war.abstraction.Warrior;
import warfake.war.armedforce.UndeadZombie;
import warfake.war.game.Game;

public abstract class Squad {
	private static final short NUMBER_OF_MAGES = 1;
	private static final short NUMBER_OF_ARCHERS = 3;
	private static final short NUMBER_OF_WARRIORS = 4;
	private LinkedList<Person> regularPersons = new LinkedList<>();
	private LinkedList<Person> superPersons = new LinkedList<>();
	private static LinkedList<Person> deadCorpses = new LinkedList<>();

	public Squad(LinkedList<Mage> mages, LinkedList<Archer> archers, LinkedList<Warrior> warriors) {
		for (int i = 0; i < NUMBER_OF_MAGES; i++) {
			this.regularPersons.add((Person) mages.get(i));
		}
		for (int i = 0; i < NUMBER_OF_ARCHERS; i++) {
			this.regularPersons.add((Person) archers.get(i));
		}
		for (int i = 0; i < NUMBER_OF_WARRIORS; i++) {
			this.regularPersons.add((Person) warriors.get(i));
		}
	}

	public static short getNumberOfMages() {
		return NUMBER_OF_MAGES;
	}

	public static short getNumberOfArchers() {
		return NUMBER_OF_ARCHERS;
	}

	public static short getNumberOfWarriors() {
		return NUMBER_OF_WARRIORS;
	}

	public LinkedList<Person> getSuperPersons() {
		return superPersons;
	}

	public LinkedList<Person> getRegularPersons() {
		return regularPersons;
	}

	public static LinkedList<Person> getDeadCorpes() {
		return deadCorpses;
	}

	public int getNumberOfSoldiers() {
		return this.regularPersons.size() + this.superPersons.size();
	}
	/**
	 * Removes a character from the active list either super list or regular list
	 * add a dead body to the appropriate character list and writes the logs
	 * @param person that has to be removed
	 */
	public void removePerson(Person person) {
		if (superPersons.contains(person)) {
			superPersons.remove(person);
			deadCorpses.add(person);
		} else {
			regularPersons.remove(person);
			deadCorpses.add(person);
		}
		System.out.println("\"" + person.getName() + "\"" + " is dead!\n");
		Game.logs.append("\"" + person.getName() + "\"" + " is dead!\n");
	}
	
	public void resurectPerson(Person person) {
		deadCorpses.remove(person);
	}
	/**
	 * Main algorithm which produce game moves
	 * 1. Checks if there are soldiers from the both side
	 * 2. Creates regular and super pulls from both squads
	 * 3. Takes a random character from super pull and performs random action
	 * 4. Resets stats if character was improved
	 * 5. Takes a random character from regular pull and performs random action
	 * 6. Distributes characters to the relevant list of characters after performing an action
	 * @param aliance squad of elfs or humans
	 * @param horde squad of orcs or undeads
	 */
	public static void performActions(Squad aliance, Squad horde) {
		if (aliance.getNumberOfSoldiers() != 0 && horde.getNumberOfSoldiers() != 0) {
			System.out.println("[Move #" + ++Game.numberOfTurns + "]\n");
			Game.logs.append("[Move #" + Game.numberOfTurns + "]\n");
		}
		ArrayList<Person> generalSuperPersonsPull = gatherSuperPersons(aliance, horde);
		ArrayList<Person> generalRegularPersonsPull = gatherRegularPersons(aliance, horde);
		if (generalSuperPersonsPull.size() != 0) {
			if (aliance.getNumberOfSoldiers() != 0 && horde.getNumberOfSoldiers() != 0) {
				System.out.println("Improved characters are moving first\n");
				Game.logs.append("Improved characters are moving first\n");
			}
			Collections.shuffle(generalSuperPersonsPull);
			for (int i = 0; i < generalSuperPersonsPull.size(); i++) {
				Person person = generalSuperPersonsPull.get(i);
				if (person.isDead()) {
					continue;
				}
				else if (person.isImproved()) {
					person.performRandomAction(aliance, horde);
					person.setStrikePower(person.getDefaultStrikePower());
					person.setAccuracy(0);
					person.setIsImproved(false);
				}
				if (person instanceof Aliance) {
					aliance.superPersons.remove(person);
					aliance.regularPersons.add(person);
				} else {
					horde.superPersons.remove(person);
					horde.regularPersons.add(person);
				}
			}
			performRegularActions(generalRegularPersonsPull, aliance, horde);
		} else {
			performRegularActions(generalRegularPersonsPull, aliance, horde);
		}
	}

	/**
	 * Produces for characters a random target from a pull
	 * @return a random person
	 * @throws NoEnemiesException
	 */
	public Person getRandomTarget() throws NoEnemiesException {
		LinkedList<Person> targetsPull = new LinkedList<>();
		Random random = new Random();
		gatherSquad(targetsPull);
		if (targetsPull.size() != 0) {
			return targetsPull.get(random.nextInt(targetsPull.size()));
		}
		throw new NoEnemiesException();
	}

	public void promotePerson(Person person) {
		this.regularPersons.remove(person);
		this.superPersons.add(person);
	}
	
	public void demotePerson(Person person) {
		this.superPersons.remove(person);
		this.regularPersons.add(person);
	}

	/**
	 * Produces for characters a random improvable target
	 * @return random improvable target
	 * @throws NoImprovableTargetsException
	 */
	public Person getRandomImprovableTarget() throws NoImprovableTargetsException {
		LinkedList<Person> improvableTargets = new LinkedList<>();
		Random random = new Random();
		for (Person value : regularPersons) {
			if (value instanceof Improvable) {
				improvableTargets.add(value);
			}
		}
		if (improvableTargets.size() != 0) {
			return improvableTargets.get(random.nextInt(improvableTargets.size())); // bug is here IllegalArgumentException
		}
		else {
			throw new NoImprovableTargetsException();
		}
	}
	/**
	 * Produces for characters a random improved character
	 * @return improved character
	 * @throws NoImprovedTargetsException
	 */
	public Person getRandomImprovedTarget() throws NoImprovedTargetsException {
		LinkedList<Person> improvedTargets = new LinkedList<>();
		Random random = new Random();
		if (superPersons.size() != 0) {
			for (Person value: this.superPersons) {
				improvedTargets.add(value);
			}
			return improvedTargets.get(random.nextInt(improvedTargets.size()));
		}
		else {
			throw new NoImprovedTargetsException();
		}
	}
	/**
	 * Produces for characters a random dead body
	 * @return random dead body
	 * @throws NoDeadBodiesException
	 */
	public static Person useRandomDeadTarget() throws NoDeadBodiesException {
		LinkedList<Person> deadCorpsesPull = new LinkedList<>();
		Random random = new Random();
		if (deadCorpses.size() != 0) {
			for (Person value: deadCorpses) {
				if(value instanceof Resurectable) {
					deadCorpsesPull.add(value);
				}
			}
			if (deadCorpsesPull.size() != 0) {
				Person target = deadCorpsesPull.get(random.nextInt(deadCorpsesPull.size()));
				deadCorpses.remove(target);
				return target;
			}
			else {
				throw new NoDeadBodiesException();
			}
		}
		else {
			throw new NoDeadBodiesException();
		}
	}
	
	public void addNewZombie(Person person) {
		regularPersons.add(new UndeadZombie(person));
	}

	private void gatherSquad(LinkedList<Person> personPull) {
		for (Person value : regularPersons) {
			personPull.add(value);
		}
		for (Person value : superPersons) {
			personPull.add(value);
		}
	}

	private static ArrayList<Person> gatherSuperPersons(Squad aliance, Squad horde) {
		ArrayList<Person> temp = new ArrayList<>();
		for (Person value : aliance.superPersons) {
			temp.add(value);
		}
		for (Person value : horde.superPersons) {
			temp.add(value);
		}
		return temp;
	}

	private static ArrayList<Person> gatherRegularPersons(Squad aliance, Squad horde) {
		ArrayList<Person> temp = new ArrayList<>();
		for (Person value : aliance.regularPersons) {
			temp.add(value);
		}
		for (Person value : horde.regularPersons) {
			temp.add(value);
		}
		return temp;
	}

	private static void performRegularActions(ArrayList<Person> generalRegularPersonsPull, Squad aliance,
			Squad horde) {
		if (aliance.getNumberOfSoldiers() != 0 && horde.getNumberOfSoldiers() != 0) {
			System.out.println("Regular characters are moving: \n");
			Game.logs.append("Regular characters are moving:\n");
		}
		Collections.shuffle(generalRegularPersonsPull);
		for (int i = 0; i < generalRegularPersonsPull.size(); i++) {
			Person person = generalRegularPersonsPull.get(i);
			if (person.isDead()) {
				continue;
			}
			else if (person.isCursed()) {
				person.setStrikePower(person.getDefaultStrikePower());
				person.setAccuracy(0);
				person.setIsCursed(false);
				person.performRandomAction(aliance, horde);
			}
			else if (person.isImproved()) {
				float tempPower = person.getStrikePower();
				int tempAccuracy = person.getAccuracy();
				person.setStrikePower(person.getDefaultStrikePower());
				person.setAccuracy(0);
				person.performRandomAction(aliance, horde);
				person.setStrikePower(tempPower);
				person.setAccuracy(tempAccuracy);
			}
			else {
				person.performRandomAction(aliance, horde);
			}
		}
	}
}
