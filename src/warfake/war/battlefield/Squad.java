package warfake.war.battlefield;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;

public abstract class Squad {
	private static final short NUMBER_OF_MAGES = 1;
	private static final short NUMBER_OF_ARCHERS = 3;
	private static final short NUMBER_OF_WARRIORS = 4;
	private LinkedList<Mage> mages = new LinkedList<>();
	private LinkedList<Mage> superMages = new LinkedList<>();
	private LinkedList<Archer> archers = new LinkedList<>();
	private LinkedList<Archer> superArchers = new LinkedList<>();
	private LinkedList<Warrior> warriors = new LinkedList<>();
	private LinkedList<Warrior> superWarriors = new LinkedList<>();

	public Squad(LinkedList<Mage> mages, LinkedList<Archer> archers, LinkedList<Warrior> warriors) {
		for (int i = 0; i < NUMBER_OF_MAGES; i++) {
			this.mages.add(mages.get(i));
		}
		for (int i = 0; i < NUMBER_OF_ARCHERS; i++) {
			this.archers.add(archers.get(i));
		}
		for (int i = 0; i < NUMBER_OF_WARRIORS; i++) {
			this.warriors.add(warriors.get(i));
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

	public LinkedList<Mage> getMages() {
		return mages;
	}

	public void setMage(Mage mage) {
		mages.add(mage);
	}

	public LinkedList<Mage> getSuperMages() {
		return superMages;
	}

	public void setSuperMage(Mage mage) {
		superMages.add(mage);
	}

	public LinkedList<Archer> getArchers() {
		return archers;
	}

	public void setArcher(Archer archer) {
		archers.add(archer);
	}

	public LinkedList<Archer> getSuperArchers() {
		return superArchers;
	}

	public void setSuperArcher(Archer archer) {
		superArchers.add(archer);
	}

	public LinkedList<Warrior> getWarriors() {
		return warriors;
	}

	public void setWarrior(Warrior warrior) {
		warriors.add(warrior);
	}

	public LinkedList<Warrior> getSuperWarriors() {
		return superWarriors;
	}

	public void setSuperWarrior(Warrior warrior) {
		superWarriors.add(warrior);
	}

	// public void performActions() {
	// тут все персонажы выполн€ют рендомное действие в рандомном пор€дке. —начала
	// идут супер персонажы, а потом обычные
	//
	// }

	public Person getRandomTarget() {
		ArrayList<Person> targetsPull = new ArrayList<>();
		Random random = new Random();
		for (Mage value : mages) {
			targetsPull.add((Person) value);
		}
		for (Mage value : superMages) {
			targetsPull.add((Person) value);
		}
		for (Archer value : archers) {
			targetsPull.add((Person) value);
		}
		for (Archer value : superArchers) {
			targetsPull.add((Person) value);
		}
		for (Warrior value : warriors) {
			targetsPull.add((Person) value);
		}
		for (Warrior value : superWarriors) {
			targetsPull.add((Person) value);
		}
		return targetsPull.get(random.nextInt(targetsPull.size()));
	}

	public Person getRandomImprovableTarget() {
		ArrayList<Person> targetsPull = new ArrayList<>();
		Random random = new Random();
		for (Archer value : archers) {
			targetsPull.add((Person) value);
		}
		for (Warrior value : warriors) {
			targetsPull.add((Person) value);
		}
		return targetsPull.get(random.nextInt(targetsPull.size()));
	}
}
