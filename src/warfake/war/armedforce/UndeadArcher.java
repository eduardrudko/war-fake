package warfake.war.armedforce;

import java.util.Random;

import warefake.helpers.markers.Horde;
import warefake.helpers.markers.NoEnemiesException;
import warfake.war.armory.UndeadWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class UndeadArcher extends Person implements Archer, Horde {
	private static final float SHOT_POWER = 15;
	private static final float STRIKE_POWER = 2;
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
			logStrikeAction(getName(), boneBow.getWeaponAction(), target, SHOT_POWER, accuracy);
		} catch (NoEnemiesException e) {
			logUndeadWin();
			Game.gameProcess = false;
		}

	}

	@Override
	public void meleeStab(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int accuracy = 100;
			dealDamage(target, STRIKE_POWER, accuracy);
			logStrikeAction(getName(), knife.getWeaponAction(), target, STRIKE_POWER, accuracy);
		} catch (NoEnemiesException e) {
			logUndeadWin();
			Game.gameProcess = false;
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
