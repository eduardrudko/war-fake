package warfake.war.armedforce;

import warfake.war.armory.UndeadWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class UndeadArcher extends Person implements Archer {
	private static final float SHOT_POWER = 15;
	private static final float STRIKE_POWER = 2;
	private static UndeadWeapons boneBow = UndeadWeapons.BONE_BOW;
	private static UndeadWeapons knife = UndeadWeapons.KNIFE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void archeryShot(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, SHOT_POWER, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), boneBow.getWeaponAction(), target, SHOT_POWER, accuracy);
		
	}

	@Override
	public void meleeStab(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = 100;
		dealDamage(target, STRIKE_POWER,accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), knife.getWeaponAction(), target, STRIKE_POWER, accuracy);
		
	}

}
