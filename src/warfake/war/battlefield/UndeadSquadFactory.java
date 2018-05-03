package warfake.war.battlefield;

import java.util.LinkedList;

import warfake.war.abstraction.Archer;
import warfake.war.abstraction.Mage;
import warfake.war.abstraction.Warrior;
import warfake.war.armedforce.UndeadArcher;
import warfake.war.armedforce.UndeadNecromant;
import warfake.war.armedforce.UndeadZombie;

public class UndeadSquadFactory extends Squad {
	
	private UndeadSquadFactory(LinkedList<Mage> undeadMages, LinkedList<Archer> undeadArchers, LinkedList<Warrior> undeadWarriors) {
		super(undeadMages, undeadArchers, undeadWarriors);
	}

	public static UndeadSquadFactory generateUndeadSquad() {
		LinkedList<Mage> undeadMages = new LinkedList<>();
		LinkedList<Archer> undeadArchers = new LinkedList<>();
		LinkedList<Warrior> undeadWarriors = new LinkedList<>();

		for (int i = 0; i < getNumberOfMages(); i++) {
			undeadMages.add(new UndeadNecromant());
		}
		for (int i = 0; i < getNumberOfArchers(); i++) {
			undeadArchers.add(new UndeadArcher());
		}
		for (int i = 0; i < getNumberOfWarriors(); i++) {
			undeadWarriors.add(new UndeadZombie());
		}
		return new UndeadSquadFactory(undeadMages, undeadArchers, undeadWarriors);
	}
}
