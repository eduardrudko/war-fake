package warfake.war.armedforce;

import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class OrcArcher extends Person implements Archer {
	private static final float SHOT_POWER = 17;
	private static final float STRIKE_POWER = 2;


	@Override
	public void archeryShot(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, SHOT_POWER, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " shoots a fire arrow in ", target, SHOT_POWER, accuracy);
		
	}

	@Override
	public void meleeStab(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = 100;
		dealDamage(target, STRIKE_POWER,accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " stabs with axe ", target, STRIKE_POWER, accuracy);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
