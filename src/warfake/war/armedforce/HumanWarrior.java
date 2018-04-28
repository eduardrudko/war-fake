package warfake.war.armedforce;

import warfake.war.classes.Person;
import warfake.war.game.Game;

public class HumanWarrior extends Person {
	
	public HumanWarrior() {
		setName("Fillip");
	}
	
	public void broadSwordStrike(Person target) {
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, getSwordStrikePower(), accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " strikes with a broadsword ", target, getSwordStrikePower(), accuracy);
	}

	public static void main(String[] args) {
		HumanWarrior warrior = new HumanWarrior();
		HumanWarrior warriro2 = new HumanWarrior();
		warrior.broadSwordStrike(warriro2);
		warrior.broadSwordStrike(warriro2);
		warrior.broadSwordStrike(warriro2);
		warrior.broadSwordStrike(warriro2);

	}

}
