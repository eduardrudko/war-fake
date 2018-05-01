package warfake.war.armedforce;

import java.util.Random;

import warefake.helpers.markers.Horde;
import warefake.helpers.markers.Improvable;
import warefake.helpers.markers.NoEnemiesException;
import warfake.war.armory.OrcWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;
import warfake.war.game.Game;

public class OrcGoblin extends Person implements Warrior, Horde, Improvable {
	private float strikePower = 20;
	private static final float DEFAULT_STIKE_POWER = 20;
	private static OrcWeapons club = OrcWeapons.CLUB;
	private static final int NUMBER_OF_SKILLS = 1;
	private static int id = 1;
	private int name = id++;

	public OrcGoblin() {
		setName("Orc Goblin" + name);
	}

	@Override
	public void meleeStrike(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int accuracy = getRandomAccuracy();
			dealDamage(target, strikePower, accuracy);
			logStrikeAction(getName(), club.getWeaponAction(), target, strikePower, accuracy);
			if (target.isDead()) {
				targets.removePerson(target);
			}
			if (this.isImproved()) {
				this.setIsImproved(false);
				this.setStrikePower(DEFAULT_STIKE_POWER);
			}
		} catch (NoEnemiesException e) {
			logOrcsWin();
			Game.gameProcess = false;
			System.exit(0);
		}
	}

	@Override
	public void performRandomAction(Squad aliance, Squad horde) {
		Random rnd = new Random();
		switch (rnd.nextInt(NUMBER_OF_SKILLS) + 1) {
		case 1:
			meleeStrike(aliance);
			break;
		}
	}

	public float getDefaultStrikePower() {
		return DEFAULT_STIKE_POWER;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
