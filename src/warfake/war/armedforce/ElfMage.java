package warfake.war.armedforce;

import java.util.Random;

import warfake.war.battlefield.ElfSquadFactory;
import warfake.war.battlefield.OrcSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class ElfMage extends Person implements Mage {
	private static final int HEAL_POWER = 20;
	private static final int ENHANCE_WARRIOR_POWER = 20;
	private static final int ENHANCE_ARCHER_POWER = 10;
	private static Random random = new Random();
	
	public ElfMage() {
		setName("ElfMage");
	}
	
	@Override
	public void useMagic(Squad targets) {
		Person target = targets.getRandomTarget();
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
	@Override
	public void applyImprovement(Squad targets) {
		Person target = targets.getRandomImprovableTarget();
		if (target instanceof ElfArcher) {
			Game.numberOfTurns++;
			target.setAccuracy(Math.min((target.getAccuracy() + (target.getMaxAccuracy() * ENHANCE_ARCHER_POWER) / 100), getMaxAccuracy()));
			logEnhanceActionForRangers(Game.numberOfTurns, getName(), target, target.getAccuracy(),
					ENHANCE_ARCHER_POWER);
			targets.getSuperArchers().add(target);
			targets.getArchers().remove(target);
		} else {
			Game.numberOfTurns++;
			target.setStrikePower((target.getStrikePower() + (target.getStrikePower() * ENHANCE_WARRIOR_POWER) / 100));
			logEnhanceActionForMelee(Game.numberOfTurns, getName(), target, target.getStrikePower(),
					ENHANCE_WARRIOR_POWER);
			targets.getSuperWarriors().add(target);
			targets.getWarriors().remove(target);
		}
		
	}

	public static void main(String[] args) {
		Squad squad = ElfSquadFactory.generateElfSquad();
		System.out.println(squad.getArchers().toString());
		System.out.println(squad.getWarriors().toString());
		ElfMage elf1 = new ElfMage();
		elf1.applyImprovement(squad);
		System.out.println(squad.getSuperArchers().toString());
		System.out.println(squad.getSuperWarriors().toString());

	}
}
