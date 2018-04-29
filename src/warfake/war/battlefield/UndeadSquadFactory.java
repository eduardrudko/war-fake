package warfake.war.battlefield;

import java.util.LinkedList;

import warfake.war.armedforce.OrcArcher;
import warfake.war.armedforce.OrcGoblin;
import warfake.war.armedforce.OrcShaman;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Warrior;

public class UndeadSquadFactory extends Squad {
	
	public UndeadSquadFactory(LinkedList<Mage> undeadMages, LinkedList<Archer> undeadArchers, LinkedList<Warrior> undeadWarriors) {
		super(undeadMages, undeadArchers, undeadWarriors);
	}

	public static UndeadSquadFactory generateUndeadSquad() {
		LinkedList<Mage> undeadMages = new LinkedList<>();
		LinkedList<Archer> undeadArchers = new LinkedList<>();
		LinkedList<Warrior> undeadWarriors = new LinkedList<>();

		for (int i = 0; i < getNumberOfMages(); i++) {
			undeadMages.add(new OrcShaman());
		}
		for (int i = 0; i < getNumberOfArchers(); i++) {
			undeadArchers.add(new OrcArcher());
		}
		for (int i = 0; i < getNumberOfArchers(); i++) {
			undeadWarriors.add(new OrcGoblin());
		}
		return new UndeadSquadFactory(undeadMages, undeadArchers, undeadWarriors);
	}
}
