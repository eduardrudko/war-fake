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
			float currentHealth = target.getHealth();
			target.setHealth(currentHealth + ((currentHealth * healPower) / 100));
			mana -= healPower;
		} else {
			System.out.println(name + " can't heal anymore! " + name + " prepares for the next turn ...");
			Game.logs.append(name + " can't heal anymore! " + name + " prepares for the next turn ...");
		}
	}

	public void enhanceSkill(ElfArcher archer) {
		enhanceSkill(archer, enhanceArcherPower);
	}

	public void enhanceSkill(ElfWarrior warrior) {
		enhanceSkill(warrior, enhanceWarriorPower);
	}
	
	private void enhanceSkill(Person target, int enhancePower) {
		int currentAccuracy = target.getAccuracy();
		target.setAccuracy(currentAccuracy + ((currentAccuracy * enhancePower)) / 100);
	}

	public static void main(String[] args) {
		ElfMage elf = new ElfMage();
		ElfArcher elf2 = new ElfArcher();
		elf2.setHealth(5);
		System.out.println(elf2.getHealth());
		elf.heal(elf2);
		System.out.println(elf2.getHealth());
		
		System.out.println();
		System.out.println(elf2.getAccuracy());
		

	}
}
