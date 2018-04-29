package warfake.war.armedforce;

import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;
import warfake.war.game.Game;

public class OrcGoblin extends Person implements Warrior {
	private float strikePower = 20;
	
	public OrcGoblin() {
		setName("Durachok");
	}
	
	@Override
	public void meleeStrike(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, strikePower, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " strikes with a club ", target, strikePower, accuracy);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
