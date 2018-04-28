package warfake.war.armedforce;

import warfake.war.classes.Mage;
import warfake.war.classes.Person;
import warfake.war.game.Game;

public class ElfMage extends Mage {
	private final String name;
	private final int healPower = 20;
	public int mana = 100;
	private final int enhanceArcherPower = 10;
	private final int enhanceWarriorPower = 20;

	public ElfMage() {
		name = "ElfMage";
	}

	public void heal(Person target) {
		if (mana != 0) {
			Game.numberOfTurns++;
			float currentHealth = target.getHealth();
			target.setHealth((Math.round((currentHealth + (currentHealth * healPower) / 100))));
			mana -= healPower;
			logHealAction(Game.numberOfTurns, name, target, currentHealth, healPower, mana);
		} else {
			Game.numberOfTurns++;
			System.out.println(Game.numberOfTurns + ". " + name + " doesn't have enough mana for this spell! " + name + " prepares for the next turn ...");
			Game.logs.append(Game.numberOfTurns + ". " + name + " doesn't have enough mana for this spell! " + name + " prepares for the next turn ...");
		}
	}

	public void enhanceSkill(ElfArcher archer) {
		enhanceSkill(archer, enhanceArcherPower);
	}

	public void enhanceSkill(ElfWarrior warrior) {
		enhanceSkill(warrior, enhanceWarriorPower);
	}

	public static void main(String[] args) {
		ElfMage elf = new ElfMage();
		ElfArcher elf2 = new ElfArcher();
		elf2.setHealth(50);
		elf.heal(elf2);
		elf.heal(elf2);
		elf.heal(elf2);
		elf.heal(elf2);
		elf.heal(elf2);
		elf.heal(elf2);
		elf.heal(elf2);
		elf.heal(elf2);
		

	}
}
