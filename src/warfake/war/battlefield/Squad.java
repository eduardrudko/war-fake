package warfake.war.battlefield;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import warefake.helpers.markers.Aliance;
import warefake.helpers.markers.Improvable;
import warefake.helpers.markers.NoEnemiesException;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;
import warfake.war.game.Game;

public abstract class Squad {
	private static final short NUMBER_OF_MAGES = 1;
	private static final short NUMBER_OF_ARCHERS = 3;
	private static final short NUMBER_OF_WARRIORS = 4;
	private LinkedList<Person> regularPersons = new LinkedList<>();
	private LinkedList<Person> superPersons = new LinkedList<>();
	private LinkedList<Person> deadCorpses = new LinkedList<>();

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

	public LinkedList<Person> getDeadCorpes() {
		return deadCorpses;
	}

	public int getNumberOfSoldiers() {
		return this.regularPersons.size() + this.superPersons.size();
	}

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

	public static void performActions(Squad aliance, Squad horde) {
		System.out.println("[Move #" + ++Game.numberOfTurns + "]");
		ArrayList<Person> generalSuperPersonsPull = gatherSuperPersons(aliance, horde);
		ArrayList<Person> generalRegularPersonsPull = gatherRegularPersons(aliance, horde);
		if (generalSuperPersonsPull.size() != 0) {
			Collections.shuffle(generalSuperPersonsPull);
			System.out.println("Super characters are move first:");
			for (int i = 0; i < generalSuperPersonsPull.size(); i++) {
				Person person = generalSuperPersonsPull.get(i);
				if (person.isDead()) {
					continue;
				} else {
					person.performRandomAction(aliance, horde);
				}
				if (person instanceof Aliance) {
					aliance.superPersons.remove(person);
					aliance.regularPersons.add(person);
				} else {
					horde.superPersons.remove(person);
					horde.superPersons.add(person);
				}
			}
			performRegularActions(generalRegularPersonsPull, aliance, horde);
		} else {
			performRegularActions(generalRegularPersonsPull, aliance, horde);
		}
	}


	public Person getRandomTarget() throws NoEnemiesException {
		LinkedList<Person> targetsPull = new LinkedList<>();
		Random random = new Random();
		gatherSquad(targetsPull);
		if (targetsPull.size() != 0) {
			return targetsPull.get(random.nextInt(targetsPull.size()));
		}
		throw new NoEnemiesException();
	}

	public void swapPersons(Person person) {
		this.regularPersons.remove(person);
		this.superPersons.add(person);
	}

	public Person getRandomImprovableTarget() {
		LinkedList<Person> improvableTargets = new LinkedList<>();
		Random random = new Random();
		for (Person value : regularPersons) {
			if (value instanceof Improvable) {
				improvableTargets.add(value);
			}
		}
		return improvableTargets.get(random.nextInt(improvableTargets.size())); // bug is here IllegalArgumentException
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
		Collections.shuffle(generalRegularPersonsPull);
		System.out.println("Regular character moves:");
		for (int i = 0; i < generalRegularPersonsPull.size(); i++) {
			Person person = generalRegularPersonsPull.get(i);
			if (person.isDead()) {
				continue;
			} else {
				person.performRandomAction(aliance, horde);
			}
		}
	}
}
