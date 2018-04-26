package warfake.war.battlefield;

import java.util.ArrayList;

import warfake.war.armedforce.ElfArcher;
import warfake.war.armedforce.ElfMage;
import warfake.war.armedforce.ElfWarrior;

public class ElfSquad extends Squad {
	private ArrayList<ElfMage> elfMages = new ArrayList<>();
	private ArrayList<ElfArcher> elfArchers = new ArrayList<>();
	private ArrayList<ElfWarrior> elfWarriors = new ArrayList<>();

	public ElfSquad() {
		for (int i = 0; i < Squad.getNumberOfMages(); i++) {
			elfMages.add(new ElfMage());
		}
		for (int i = 0; i < Squad.getNumberOfArchers(); i++) {
			elfArchers.add(new ElfArcher());
		}
		for (int i = 0; i < Squad.getNumberOfWarriors(); i++) {
			elfWarriors.add(new ElfWarrior());
		}
	}

	public ArrayList<ElfMage> getElfMages() {
		return elfMages;
	}

	public ArrayList<ElfArcher> getElfArchers() {
		return elfArchers;
	}

	public ArrayList<ElfWarrior> getElfWarriors() {
		return elfWarriors;
	}
}
