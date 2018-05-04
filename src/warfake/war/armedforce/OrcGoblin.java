package warfake.war.armedforce;

import java.util.Random;

import warfake.exeptions.NoEnemiesException;
import warfake.markers.Horde;
import warfake.markers.Improvable;
import warfake.war.abstraction.Person;
import warfake.war.abstraction.Warrior;
import warfake.war.armory.OrcWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.game.Game;

public class OrcGoblin extends Person implements Warrior, Horde, Improvable {
	private float strikePower = 11;
	private static OrcWeapons club = OrcWeapons.CLUB;
	private static final int NUMBER_OF_SKILLS = 1;
	private static int id = 1;
	private int name = id++;

	public OrcGoblin() {
		setName("Orc Goblin " + name);
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
				this.setStrikePower(getDefaultStrikePowerForWarriors());
			}
		} catch (NoEnemiesException e) {
			logHordeVictory();
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
			meleeStrike(aliance);
			break;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
