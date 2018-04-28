package warfake.war.armedforce;

import warfake.war.classes.Mage;
import warfake.war.classes.Person;
import warfake.war.game.Game;

public class ElfMage extends Mage {
	private static final int HEAL_POWER = 20;
	private static final int ENHANCE_ARCHER_POWER = 10;
	private static final int ENHANCE_WARRIOR_POWER = 20;

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
			System.out.println("Move #" + Game.numberOfTurns + ". " + getName() + " trying to use healing power but spell doesn't have any effect! " + target.getName() + " is healthy!");
			Game.logs.append("Move #" + Game.numberOfTurns + ". " + getName() + " trying to use healing power but spell doesn't have any effect! " + target.getName() + " is healthy!");
		}
	}

	public void enhanceSkill(ElfArcher archer) {
		if (archer.getAccuracy() != 100) {
			Game.numberOfTurns++;
			enhanceSkillRanger(archer, ENHANCE_ARCHER_POWER);
			logEnhanceActionForRangers(Game.numberOfTurns, getName(), archer, archer.getAccuracy(), ENHANCE_ARCHER_POWER);
		}
		else {
			Game.numberOfTurns++;
			System.out.println("Move #" + Game.numberOfTurns + ". " + getName() + " trying to use enhancing power but spell doesn't have any effect! " + archer.getName() + " has 100% accuracy and come as a precise shooter now!");
			Game.logs.append("Move #" + Game.numberOfTurns + ". " + getName() + " trying to use enhancing power but spell doesn't have any effect! " + archer.getName() + " has 100% accuracy has 100% accuracy and come as a precise shooter now!");
		}
	}

	public void enhanceSkill(ElfWarrior warrior) {
		Game.numberOfTurns++;
		enhanceSkillMelee(warrior, ENHANCE_WARRIOR_POWER);
		logEnhanceActionForMelee(Game.numberOfTurns, getName(), warrior, warrior.getSwordStrikePower(), ENHANCE_WARRIOR_POWER);
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
