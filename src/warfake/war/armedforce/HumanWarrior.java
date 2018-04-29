package warfake.war.armedforce;

import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;
import warfake.war.game.Game;

public class HumanWarrior extends Person implements Warrior{
	private float strikePower = 20;
	
	public HumanWarrior() {
		setName("Fillip");
	}
	
	@Override
	public void meleeStrike(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, strikePower, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " strikes with a broadsword ", target, strikePower, accuracy);
	}

	public static void main(String[] args) {
//		HumanWarrior warrior = new HumanWarrior();
//		HumanWarrior warriro2 = new HumanWarrior();
//		warrior.broadSwordStrike(warriro2);
//		warrior.broadSwordStrike(warriro2);
//		warrior.broadSwordStrike(warriro2);
//		warrior.broadSwordStrike(warriro2);

	}

}
