package warfake.war.armedforce;

import java.util.Random;

import warfake.exeptions.NoEnemiesException;
import warfake.markers.Aliance;
import warfake.markers.Improvable;
import warfake.markers.Resurectable;
import warfake.war.abstraction.Person;
import warfake.war.abstraction.Warrior;
import warfake.war.armory.ElfWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.game.Game;

public class ElfWarrior extends Person implements Warrior, Aliance, Improvable, Resurectable {
	private float strikePower = 20;
	private static ElfWeapons longSword = ElfWeapons.ELVEN_LONGSWORD;
	private static final int NUMBER_OF_SKILLS = 1;
	private static int id = 1;
	private int name = id++;

	public ElfWarrior() {
		setName("Elf Warrior " + name);
	}

	@Override
	public void meleeStrike(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int accuracy = getRandomAccuracy();
			dealDamage(target, strikePower, accuracy);
			logStrikeAction(getName(), longSword.getWeaponAction(), target, strikePower, accuracy);
			if (target.isDead()) {
				targets.removePerson(target);
			}
			if (this.isImproved()) {
				this.setIsImproved(false);
				this.setStrikePower(getDefaultStrikePowerForWarriors());
			}
		} catch (NoEnemiesException e) {
			logAlianceVictory();
			Game.gameProcess = false;
			Game.createResults();
			System.exit(0);
		}
	}

	@Override
	public float getStrikePower() {
		return strikePower;
	}

	@Override
	public void setStrikePower(float strikePower) {
		this.strikePower = strikePower;
	}

	@Override
	public void performRandomAction(Squad aliance, Squad horde) {
		Random rnd = new Random();
		switch (rnd.nextInt(NUMBER_OF_SKILLS) + 1) {
		case 1:
			meleeStrike(horde);
			break;
		}
	}
}
