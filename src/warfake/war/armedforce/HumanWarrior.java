package warfake.war.armedforce;

import java.util.Random;

import warefake.war.markers.Aliance;
import warefake.war.markers.Improvable;
import warfake.war.armory.HumanWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;

public class HumanWarrior extends Person implements Warrior, Aliance, Improvable {
	private float strikePower = 20;
	private static HumanWeapons broadsword = HumanWeapons.BROADSWORD;
	private static final int NUMBER_OF_SKILLS = 1;
	
	public HumanWarrior() {
		setName("Fillip");
	}
	
	@Override
	public void meleeStrike(Squad targets) {
		Person target = targets.getRandomTarget();
		int accuracy = getRandomAccuracy();
		dealDamage(target, strikePower, accuracy);
		logStrikeAction(getName(), broadsword.getWeaponAction(), target, strikePower, accuracy);
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
