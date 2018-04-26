package warfake.war.battlefield;

import java.util.ArrayList;

import warfake.war.armedforce.UndeadArcher;
import warfake.war.armedforce.UndeadNecromant;
import warfake.war.armedforce.UndeadZombie;

public class UndeadSquad extends Squad {
	private ArrayList<UndeadNecromant> undeadNecromants = new ArrayList<>();;
	private ArrayList<UndeadArcher> undeadArchers = new ArrayList<>();;
	private ArrayList<UndeadZombie> undeadZombies = new ArrayList<>();;

	public UndeadSquad() {
		for (int i = 0; i < Squad.getNumberOfMages(); i++) {
			undeadNecromants.add(new UndeadNecromant());
		}
		for (int i = 0; i < Squad.getNumberOfArchers(); i++) {
			undeadArchers.add(new UndeadArcher());
		}
		for (int i = 0; i < Squad.getNumberOfWarriors(); i++) {
			undeadZombies.add(new UndeadZombie());
		}
	}

	public ArrayList<UndeadNecromant> getUndeadNecromants() {
		return undeadNecromants;
	}

	public ArrayList<UndeadArcher> getUndeadArchers() {
		return undeadArchers;
	}

	public ArrayList<UndeadZombie> getUndeadZombies() {
		return undeadZombies;
	}
}
