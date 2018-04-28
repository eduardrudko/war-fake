package warfake.war.armedforce;

import warfake.war.classes.Mage;
import warfake.war.classes.Person;
import warfake.war.game.Game;

public class ElfMage extends Mage {
	private static final int HEAL_POWER = 20;

	public ElfMage() {
		setName("ElfMage");
	}

	public void heal(Person target) {
		int currentHealth = target.getHealth();
		if (currentHealth < getMaxHealth()) {
			Game.numberOfTurns++;
			target.setHealth((Math.min((Math.round((currentHealth + (getMaxHealth() * HEAL_POWER) / 100))), getMaxHealth())));
			logHealAction(Game.numberOfTurns, getName(), target, currentHealth, HEAL_POWER);
		} else {
			Game.numberOfTurns++;
			System.out.println("[Move #" + Game.numberOfTurns + "] " + getName() + " tries to use healing power but spell doesn't have any effect! " + target.getName() + " is healthy!\n");
			Game.logs.append("[Move #" + Game.numberOfTurns + "] " + getName() + " tries to use healing power but spell doesn't have any effect! " + target.getName() + " is healthy!\n");
		}
	}

	public static void main(String[] args) {
		ElfMage elf = new ElfMage();
		ElfArcher elf2 = new ElfArcher();
		elf2.setHealth(1);
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
