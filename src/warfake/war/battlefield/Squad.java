package warfake.war.battlefield;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import warefake.war.markers.Improvable;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;

public abstract class Squad {
	private static final short NUMBER_OF_MAGES = 1;
	private static final short NUMBER_OF_ARCHERS = 3;
	private static final short NUMBER_OF_WARRIORS = 4;
//	private LinkedList<Mage> mages = new LinkedList<>();
//	private LinkedList<Archer> archers = new LinkedList<>();
//	private LinkedList<Warrior> warriors = new LinkedList<>();
	private LinkedList<Person> regularPersons = new LinkedList<>();
	private LinkedList<Person> superPersons = new LinkedList<>();

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

	public void setSuperPersons(Person person) {
		superPersons.add(person);
	}
	
	public LinkedList<Person> getRegularPersons() {
		return regularPersons;
	}
	
	public void setRegularPerson(Person person) {
		regularPersons.add(person);
	}

	public void performActions(Squad aliance, Squad horde) {
		if (superPersons.size() != 0) {
			Collections.shuffle(superPersons);
			Collections.shuffle(regularPersons);
			for (Person value : superPersons) {
				value.performRandomAction(aliance, horde);
				superPersons.remove(value);
//				regularPersons.add(value); Œ¡€◊Õ€… œ≈–—ŒÕ¿∆ ’Œƒ»“ ƒ¬¿ –¿«€, Õ”∆ÕŒ »—œ–¿¬»“‹
			}
			for (Person value : regularPersons) {
				value.performRandomAction(aliance, horde);
			}
		} else {
			Collections.shuffle(regularPersons);
			for (Person value : regularPersons) {
				value.performRandomAction(aliance, horde);
			}

		}

	}

	public Person getRandomTarget() {
		LinkedList<Person> targetsPull = new LinkedList<>();
		Random random = new Random();
		gatherSquad(targetsPull);
		return targetsPull.get(random.nextInt(targetsPull.size()));
	}

	public Person getRandomImprovableTarget() {
		LinkedList<Person> improvableTargets = new LinkedList<>();
		Random random = new Random();
		for (Person value : regularPersons) {
			if (value instanceof Improvable) {
				improvableTargets.add(value);
			}
		}
		return improvableTargets.get(random.nextInt(improvableTargets.size()));
	}

	private void gatherSquad(LinkedList<Person> personPull) {
		for (Person value : regularPersons) {
			personPull.add((Person) value);
		}
		for (Person value : superPersons) {
			regularPersons.add((Person) value);
		}
	}
}
