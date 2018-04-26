package warfake.war.battlefield;

import java.util.ArrayList;

import warfake.war.armedforce.OrcArcher;
import warfake.war.armedforce.OrcGoblin;
import warfake.war.armedforce.OrcShaman;

public class OrcSquad extends Squad {
	private ArrayList<OrcShaman> orcShamans = new ArrayList<>();;
	private ArrayList<OrcArcher> orcArchers = new ArrayList<>();;
	private ArrayList<OrcGoblin> orcGoblins = new ArrayList<>();;

	public OrcSquad() {
		for (int i = 0; i < Squad.getNumberOfMages(); i++) {
			orcShamans.add(new OrcShaman());
		}
		for (int i = 0; i < Squad.getNumberOfArchers(); i++) {
			orcArchers.add(new OrcArcher());
		}
		for (int i = 0; i < Squad.getNumberOfWarriors(); i++) {
			orcGoblins.add(new OrcGoblin());
		}
	}

	public ArrayList<OrcShaman> getOrcShamans() {
		return orcShamans;
	}

	public ArrayList<OrcArcher> getOrcArchers() {
		return orcArchers;
	}

	public ArrayList<OrcGoblin> getOrcGoblins() {
		return orcGoblins;
	}
}
