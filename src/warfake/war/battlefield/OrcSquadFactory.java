package warfake.war.battlefield;

import java.util.LinkedList;

import warfake.war.armedforce.OrcArcher;
import warfake.war.armedforce.OrcGoblin;
import warfake.war.armedforce.OrcShaman;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Warrior;

public class OrcSquadFactory extends Squad {

	public OrcSquadFactory(LinkedList<Mage> orcMages, LinkedList<Archer> orcArchers, LinkedList<Warrior> orcWarriors) {
		super(orcMages, orcArchers, orcWarriors);
	}
	
	public static OrcSquadFactory generateOrcSquad() {
		LinkedList<Mage> orcMages = new LinkedList<>();
		LinkedList<Archer> orcArchers = new LinkedList<>();
		LinkedList<Warrior> orcWarriors = new LinkedList<>();

		for (int i = 0; i < getNumberOfMages(); i++) {
			orcMages.add(new OrcShaman());
		}
		for (int i = 0; i < getNumberOfArchers(); i++) {
			orcArchers.add(new OrcArcher());
		}
		for (int i = 0; i < getNumberOfArchers(); i++) {
			orcWarriors.add(new OrcGoblin());
		}
		return new OrcSquadFactory(orcMages, orcArchers, orcWarriors);
	}
}
