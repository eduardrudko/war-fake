package warfake.war.armedforce;

import java.util.Random;

import warfake.exeptions.NoEnemiesException;
import warfake.markers.Horde;
import warfake.war.abstraction.Archer;
import warfake.war.abstraction.Person;
import warfake.war.armory.UndeadWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.game.Game;

public class UndeadArcher extends Person implements Archer, Horde {
	private static final float SHOT_POWER = 15;
	private static final float STAB_POWER = 2;
	private static UndeadWeapons boneBow = UndeadWeapons.BONE_BOW;
	private static UndeadWeapons knife = UndeadWeapons.KNIFE;
	private static final int NUMBER_OF_SKILLS = 2;
	private static int id = 1;
	private int name = id++;

	public UndeadArcher() {
		setName("Undead Archer " + name);
	}

	@Override
	public void archeryShot(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int accuracy = getRandomAccuracy();
			dealDamage(target, SHOT_POWER, accuracy);
			logCurrentBonuses(getAccuracy(), SHOT_POWER);
			logStrikeAction(getName(), boneBow.getWeaponAction(), target, SHOT_POWER, accuracy);
			if (target.isDead()) {
				targets.removePerson(target);
			}
		} catch (NoEnemiesException e) {
			logHordeVictory();
			Game.gameProcess = false;
			Game.createResults();
			System.exit(0);
		}

	}

	@Override
	public void meleeStab(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int accuracy = getMaxAccuracy();
			dealDamage(target, STAB_POWER, accuracy);
			logCurrentBonuses(getAccuracy(), STAB_POWER);
			logStrikeAction(getName(), knife.getWeaponAction(), target, STAB_POWER, accuracy);
			if (target.isDead()) {
				targets.removePerson(target);
			}
		} catch (NoEnemiesException e) {
			logHordeVictory();
			Game.createResults();
			Game.gameProcess = false;
			System.exit(0);
		}
	}

	@Override
	public void performRandomAction(Squad aliance, Squad horde) {
		Random rnd = new Random();
		switch (rnd.nextInt(NUMBER_OF_SKILLS) + 1) {
		case 1:
			archeryShot(aliance);
			break;
		case 2:
			meleeStab(aliance);
			break;
		}
	}
}
