package warfake.war.armedforce;

import java.util.Random;

import warefake.helpers.markers.Aliance;
import warefake.helpers.markers.Improvable;
import warefake.helpers.markers.NoEnemiesException;
import warfake.war.armory.HumanWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;
import warfake.war.game.Game;

public class HumanWarrior extends Person implements Warrior, Aliance, Improvable {
	private float strikePower = 20;
	private static final float DEFAULT_STIKE_POWER = 20;
	private static HumanWeapons broadsword = HumanWeapons.BROADSWORD;
	private static final int NUMBER_OF_SKILLS = 1;
	private static int id = 1;
	private int name = id++;

	public HumanWarrior() {
		setName("Human Warrior " + name);
	}

	@Override
	public void meleeStrike(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int accuracy = getRandomAccuracy();
			dealDamage(target, strikePower, accuracy);
			logStrikeAction(getName(), broadsword.getWeaponAction(), target, strikePower, accuracy);
			if (target.isDead()) {
				targets.removePerson(target);
			}
			if (this.isImproved()) {
				this.setIsImproved(false);
				this.setStrikePower(DEFAULT_STIKE_POWER);
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

	public static void main(String[] args) {

	}
}
