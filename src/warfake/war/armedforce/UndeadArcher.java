package warfake.war.armedforce;

import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class UndeadArcher extends Person implements Archer {
	private static final float SHOT_POWER = 15;
	private static final float STRIKE_POWER = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void archeryShot(Person target) {
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, SHOT_POWER, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " shoots a spiky arrow in ", target, SHOT_POWER, accuracy);
		
	}

	@Override
	public void meleeStab(Person target) {
		Game.numberOfTurns++;
		int accuracy = 100;
		dealDamage(target, STRIKE_POWER,accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " stabs with an knife ", target, STRIKE_POWER, accuracy);
		
	}

}
