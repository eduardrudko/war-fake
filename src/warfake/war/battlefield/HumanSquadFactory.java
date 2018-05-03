package warfake.war.battlefield;

import java.util.LinkedList;

import warfake.war.abstraction.Archer;
import warfake.war.abstraction.Mage;
import warfake.war.abstraction.Warrior;
import warfake.war.armedforce.HumanCrossbowman;
import warfake.war.armedforce.HumanMage;
import warfake.war.armedforce.HumanWarrior;

public class HumanSquadFactory extends Squad {

	private HumanSquadFactory(LinkedList<Mage> humanMages, LinkedList<Archer> humanArchers, LinkedList<Warrior> humanWarriors) {
		super(humanMages, humanArchers, humanWarriors);
	}
	
	public static HumanSquadFactory generateHumanSquad() {
		LinkedList<Mage> humanMages = new LinkedList<>();
		LinkedList<Archer> humanArchers = new LinkedList<>();
		LinkedList<Warrior> humanWarriors = new LinkedList<>();

		for (int i = 0; i < getNumberOfMages(); i++) {
			humanMages.add(new HumanMage());
		}
		for (int i = 0; i < getNumberOfArchers(); i++) {
			humanArchers.add(new HumanCrossbowman());
		}
		for (int i = 0; i < getNumberOfWarriors(); i++) {
			humanWarriors.add(new HumanWarrior());
		}
		return new HumanSquadFactory(humanMages, humanArchers, humanWarriors);
	}

}
