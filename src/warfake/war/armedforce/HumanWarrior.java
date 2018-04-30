package warfake.war.armedforce;

import warfake.war.armory.HumanWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;
import warfake.war.game.Game;

public class HumanWarrior extends Person implements Warrior{
	private float strikePower = 20;
	private static HumanWeapons broadsword = HumanWeapons.BROADSWORD;
	
	public HumanWarrior() {
		setName("Fillip");
	}
	
	@Override
	public void meleeStrike(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, strikePower, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), broadsword.getWeaponAction(), target, strikePower, accuracy);
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

	}

}
