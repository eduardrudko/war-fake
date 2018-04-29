package warfake.war.armedforce;

import java.util.ArrayList;
import java.util.Random;

import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class ElfMage extends Person implements Mage {
	private static final int HEAL_POWER = 20;
	private static final int ENHANCE_CROSSBOWMANS_POWER = 10;
	private static final int ENHANCE_WARRIOR_POWER = 20;
	private static final int ENHANCE_ARCHER_POWER = 10;
	private static final int ENHANCE_GOBLIN_POWER = 20;
	private static Random random = new Random();
	
	public ElfMage() {
		setName("ElfMage");
	}
	
	@Override
	public void useMagic(Person target) {
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
	
	public void applyImprovement(ArrayList<ElfArcher> archers, ArrayList<ElfArcher> superArchers) {
		int archerIndex = random.nextInt(Squad.getNumberOfArchers());
		ElfArcher archer = archers.get(archerIndex);
		if (archer.getAccuracy() != 100) {
			Game.numberOfTurns++;
			enhanceSkillRanger(archer, ENHANCE_ARCHER_POWER);
			logEnhanceActionForRangers(Game.numberOfTurns, getName(), archer, archer.getAccuracy(),
					ENHANCE_ARCHER_POWER);
			superArchers.add(archer);
			archers.remove(archer);
		} else {
			accuracyLimit(archer);
		}
		
	}

	public static void main(String[] args) {
		ElfMage elf = new ElfMage();
		ElfArcher elf2 = new ElfArcher();
		elf2.setHealth(1);
		elf.useMagic(elf2);
		elf.useMagic(elf2);
		elf.useMagic(elf2);
		elf.useMagic(elf2);
		elf.useMagic(elf2);
		elf.useMagic(elf2);
		elf.useMagic(elf2);
		elf.useMagic(elf2);
	}
}
