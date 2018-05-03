package warfake.war.armedforce;

import java.util.Random;

import warfake.exeptions.NoEnemiesException;
import warfake.markers.Horde;
import warfake.markers.Resurectable;
import warfake.war.armory.UndeadWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;
import warfake.war.game.Game;

public class UndeadZombie extends Person implements Warrior, Horde, Resurectable {
	private float strikePower;
	private static UndeadWeapons rottenFist = UndeadWeapons.ROTTEN_FIST;
	private static final int NUMBER_OF_SKILLS = 1;
	private static final int PRECENT_Of_WEAKNESS = 20;
	private static final int ZOMBIE_HEALTH = 80;
	private static int id = 1;
	private int name = id++;
	
	public UndeadZombie() {
		setName("Undead Zombie " + name);
		setStrikePower(getDefaultStrikePowerForWarriors() - (getDefaultStrikePowerForWarriors() * PRECENT_Of_WEAKNESS) / 100);
		setHealth(ZOMBIE_HEALTH);
	}
	
	public UndeadZombie(Person warrior) {
		setName("Resurected " + warrior.getName());
		setStrikePower(warrior.getStrikePower() - (warrior.getStrikePower() * PRECENT_Of_WEAKNESS) / 100);
		setHealth(ZOMBIE_HEALTH);
	}
	
	@Override
	public void meleeStrike(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int accuracy = getRandomAccuracy();
			dealDamage(target, strikePower, accuracy);
			logStrikeAction(getName(), rottenFist.getWeaponAction(), target, strikePower, accuracy);
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
			meleeStrike(aliance);
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
