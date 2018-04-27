package warfake.war.armedforce;

import warfake.war.game.Game;
import warfake.war.race.Elf;
import warfake.war.race.Person;

public class ElfMage extends Elf {
	private String name;
	private final int healPower = 20;
	public int mana = 100;
	private final int enhanceArcherPower = 10;
	private final int enhanceWarriorPower = 20;

	public ElfMage() {
		name = "ElfMage";
	}

	public void heal(Person target) {
		if (mana != 0) {
			int currentHealth = target.getHealth();
			target.setHealth(currentHealth + ((currentHealth * healPower) / 100));
			mana -= healPower;
		} else {
			System.out.println(name + " can't heal anymore! " + name + " prepares for the next turn ...");
			Game.logs.append(name + " can't heal anymore! " + name + " prepares for the next turn ...");
		}
	}

	public void enhanceSkill(ElfArcher archer) {
		int currentAccuracy = archer.getAccuracy();
		archer.setAccuracy(currentAccuracy + ((currentAccuracy * enhanceArcherPower)) / 100);
	}

	public void enhanceSkill(ElfWarrior warrior) {
		int currentAccuracy = warrior.getAccuracy();
		warrior.setAccuracy(currentAccuracy + ((currentAccuracy * enhanceWarriorPower)) / 100);
	}

	public static void main(String[] args) {

	}
}
