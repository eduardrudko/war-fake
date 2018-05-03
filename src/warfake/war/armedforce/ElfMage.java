package warfake.war.armedforce;

import java.util.Random;

import warfake.exeptions.NoEnemiesException;
import warfake.exeptions.NoImprovableTargetsException;
import warfake.markers.Aliance;
import warfake.war.battlefield.ElfSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class ElfMage extends Person implements Mage, Aliance {
	private static final int HEAL_POWER = 20;
	private static final int ENHANCE_WARRIOR_POWER = 20;
	private static final int ENHANCE_ARCHER_POWER = 10;
	private static final int NUMBER_OF_SKILLS = 2;
	private static int id = 1;
	private int name = id++;

	public ElfMage() {
		setName("ElfMage " + name);
	}

	@Override
	public void useMagic(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int currentHealth = target.getHealth();
			if (currentHealth < getMaxHealth()) {
				target.setHealth((Math.min((Math.round((currentHealth + (getMaxHealth() * HEAL_POWER) / 100))),
						getMaxHealth())));
				logHealAction(getName(), target, currentHealth, HEAL_POWER);
			} else {
				System.out.println(
						"\"" + getName() + "\"" + " tries to use healing power but spell doesn't have any effect! "
								+ "\"" + target.getName() + "\"" + " is healthy!\n");
				Game.logs.append(
						"\"" + getName() + "\"" + " tries to use healing power but spell doesn't have any effect! "
								+ "\"" + target.getName() + "\"" + " is healthy!\n");
			}
		} catch (NoEnemiesException e) {
			logAlianceVictory();
			Game.gameProcess = false;
			Game.createResults();
			System.exit(0);
		}
	}

	@Override
	public void applyImprovement(Squad targets) {
		try {
			Person target = targets.getRandomImprovableTarget();
			if (target instanceof ElfArcher) {
				target.setIsImproved(true);
				target.setAccuracy(getAccuracy());
				target.setAccuracy(
						Math.min((target.getAccuracy() + (target.getMaxAccuracy() * ENHANCE_ARCHER_POWER) / 100),
								getMaxAccuracy()));
				logEnhanceActionForRangers(getName(), target, target.getAccuracy(), ENHANCE_ARCHER_POWER);
				targets.promotePerson(target);
			} else {
				target.setIsImproved(true);
				target.setStrikePower(
						(target.getStrikePower() + (target.getStrikePower() * ENHANCE_WARRIOR_POWER) / 100));
				logEnhanceActionForMelee(getName(), target, target.getStrikePower(), ENHANCE_WARRIOR_POWER);
				targets.promotePerson(target);
			}
		} catch (NoImprovableTargetsException e) {
			useMagic(targets);
		}

	}

	@Override
	public void performRandomAction(Squad aliance, Squad horde) {
		Random rnd = new Random();
		switch (rnd.nextInt(NUMBER_OF_SKILLS) + 1) {
		case 1:
			useMagic(aliance);
			break;
		case 2:
			applyImprovement(aliance);
			break;
		}
	}

	public static void main(String[] args) {
		Squad squad = ElfSquadFactory.generateElfSquad();
		System.out.println(squad.getRegularPersons().toString());
		ElfMage elf1 = new ElfMage();
		elf1.applyImprovement(squad);
		System.out.println(squad.getRegularPersons().toString());
		System.out.println(squad.getSuperPersons().toString());
	}
}
