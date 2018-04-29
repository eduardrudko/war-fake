package warfake.war.battlefield;

import java.util.LinkedList;

import warfake.war.armedforce.HumanCrossbowman;
import warfake.war.armedforce.HumanMage;
import warfake.war.armedforce.HumanWarrior;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Warrior;

public class HumanSquadFactory extends Squad {

	public HumanSquadFactory(LinkedList<Mage> humanMages, LinkedList<Archer> humanArchers, LinkedList<Warrior> humanWarriors) {
		super(humanMages, humanArchers, humanWarriors);
	}
	
	public static ElfSquadFactory generateHumanSquad() {
		LinkedList<Mage> humanMages = new LinkedList<>();
		LinkedList<Archer> humanArchers = new LinkedList<>();
		LinkedList<Warrior> humanWarriors = new LinkedList<>();

		for (int i = 0; i < getNumberOfMages(); i++) {
			humanMages.add(new HumanMage());
		}
		for (int i = 0; i < getNumberOfArchers(); i++) {
			humanArchers.add(new HumanCrossbowman());
		}
		for (int i = 0; i < getNumberOfArchers(); i++) {
			humanWarriors.add(new HumanWarrior());
		}
		return new ElfSquadFactory(humanMages, humanArchers, humanWarriors);
	}

}
