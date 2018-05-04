package warfake.war.armedforce;

import java.util.Random;

import warfake.exeptions.NoEnemiesException;
import warfake.exeptions.NoImprovableTargetsException;
import warfake.markers.Aliance;
import warfake.war.abstraction.Mage;
import warfake.war.abstraction.Person;
import warfake.war.armory.HumanWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.game.Game;

public class HumanMage extends Person implements Mage, Aliance {
	private static final int MAGIC_POWER = 20;
	private static final int ENHANCE_WARRIOR_POWER = 20;
	private static final int ENHANCE_CROSSBOWMAN_POWER = 10;
	private static HumanWeapons fireBallSpell = HumanWeapons.FIREBALL;
	private static final int NUMBER_OF_SKILLS = 2;
	private static int id = 1;
	private int name = id++;

	public HumanMage() {
		setName("Human Mage " + name);
	}

	@Override
	public void useMagic(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int accuracy = getRandomAccuracy();
			dealDamage(target, MAGIC_POWER, accuracy);
			logStrikeAction(getName(), fireBallSpell.getWeaponAction(), target, MAGIC_POWER, accuracy);
			if (target.isDead()) {
				targets.removePerson(target);
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
			if (target instanceof HumanCrossbowman) {
				target.setAccuracy(getAccuracy());
				target.setAccuracy(Math.min((target.getAccuracy() + (target.getMaxAccuracy() * ENHANCE_CROSSBOWMAN_POWER) / 100),
						getMaxAccuracy()));
				logEnhanceActionForRangers(getName(), target, target.getAccuracy(), ENHANCE_CROSSBOWMAN_POWER);
				targets.promotePerson(target);
			} else {
				target.setIsImproved(true);
				target.setStrikePower((target.getStrikePower() + (target.getStrikePower() * ENHANCE_WARRIOR_POWER) / 100));
				logEnhanceActionForMelee(getName(), target, target.getStrikePower(), ENHANCE_WARRIOR_POWER);
				targets.promotePerson(target);
			}
		}
		catch(NoImprovableTargetsException e) {
			useMagic(targets);
		}
		
	}

	@Override
	public void performRandomAction(Squad aliance, Squad horde) {
		Random rnd = new Random();
		switch (rnd.nextInt(NUMBER_OF_SKILLS) + 1) {
		case 1:
			useMagic(horde);
			break;
		case 2:
			applyImprovement(aliance);
			break;
		}
	}
}
