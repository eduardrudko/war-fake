package warfake.war.battlefield;

import java.util.ArrayList;

import warfake.war.armedforce.HumanCrossbowman;
import warfake.war.armedforce.HumanMage;
import warfake.war.armedforce.HumanWarrior;

public class HumanSquad extends Squad {
	private ArrayList<HumanMage> humanMages = new ArrayList<>();;
	private ArrayList<HumanCrossbowman> humanCrossbowmans = new ArrayList<>();;
	private ArrayList<HumanWarrior> humanWarriors = new ArrayList<>();;

	public HumanSquad() {
		for (int i = 0; i < Squad.getNumberOfMages(); i++) {
			humanMages.add(new HumanMage());
		}
		for (int i = 0; i < Squad.getNumberOfArchers(); i++) {
			humanCrossbowmans.add(new HumanCrossbowman());
		}
		for (int i = 0; i < Squad.getNumberOfWarriors(); i++) {
			humanWarriors.add(new HumanWarrior());
		}
	}

	public ArrayList<HumanMage> getHumanMages() {
		return humanMages;
	}

	public ArrayList<HumanCrossbowman> getHumanCrossbowmans() {
		return humanCrossbowmans;
	}

	public ArrayList<HumanWarrior> getHumanWarriors() {
		return humanWarriors;
	}
	
}
