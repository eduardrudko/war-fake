package warfake.war.armedforce;

import java.util.Random;

import warfake.exeptions.NoEnemiesException;
import warfake.markers.Aliance;
import warfake.markers.Improvable;
import warfake.war.abstraction.Archer;
import warfake.war.abstraction.Person;
import warfake.war.armory.ElfWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.game.Game;

public class ElfArcher extends Person implements Archer, Aliance, Improvable {
	private static final float SHOT_POWER = 15;
	private static final float STAB_POWER = 2;
	private static ElfWeapons elvenBow = ElfWeapons.ELVEN_BOW;
	private static ElfWeapons elvenDagger = ElfWeapons.ELVEN_DAGGER;
	private static final int NUMBER_OF_SKILLS = 2;
	private static int id = 1;
	private int name = id++;

	public ElfArcher() {
		setName("Elf Archer " + name);
	}

	@Override
	public void archeryShot(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int accuracy = getRandomAccuracy();
			dealDamage(target, SHOT_POWER, accuracy);
			System.out.println("Accuracy " + accuracy);
			logStrikeAction(getName(), elvenBow.getWeaponAction(), target, SHOT_POWER, accuracy);
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
	public void meleeStab(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int accuracy = getMaxAccuracy();
			dealDamage(target, STAB_POWER, accuracy);
			logStrikeAction(getName(), elvenDagger.getWeaponAction(), target, STAB_POWER, accuracy);
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
	public void performRandomAction(Squad aliance, Squad horde) {
		Random rnd = new Random();
		switch (rnd.nextInt(NUMBER_OF_SKILLS) + 1) {
		case 1:
			archeryShot(horde);
			break;
		case 2:
			meleeStab(horde);
			break;
		}
	}
}
