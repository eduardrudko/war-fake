package warfake.war.armedforce;

import java.util.Random;

import warefake.helpers.markers.Horde;
import warefake.helpers.markers.NoEnemiesException;
import warfake.war.armory.ElfWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;
import warfake.war.game.Game;

public class UndeadZombie extends Person implements Warrior, Horde {
	private float strikePower;
	private static ElfWeapons rottenFist = ElfWeapons.ELVEN_LONGSWORD;
	private static final int NUMBER_OF_SKILLS = 1;
	private static final int PRECENT_Of_WEAKNESS = 20;
	private static int id = 1;
	private int name = id++;
	
	public UndeadZombie() {
		setName("Undead Zombie " + name);
	}
	
	public UndeadZombie(Person warrior) {
		setName("Undead Zombie " + name);
		setStrikePower(warrior.getStrikePower() - (warrior.getStrikePower() * PRECENT_Of_WEAKNESS) / 100);
		setHealth(warrior.getMaxHealth() - (warrior.getMaxHealth() * PRECENT_Of_WEAKNESS) / 100);
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
