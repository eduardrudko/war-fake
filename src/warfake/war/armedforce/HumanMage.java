package warfake.war.armedforce;

import warfake.war.classes.Mage;
import warfake.war.classes.Person;
import warfake.war.game.Game;

public class HumanMage extends Mage {
	private static final int MAGIC_POWER = 20;
	
	public HumanMage() {
		setName("Mage");
	}
	
	public void fireballCast(Person target) {
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, MAGIC_POWER, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " casts a fireball in ", target, MAGIC_POWER, accuracy);
	}

	public static void main(String[] args) {
		HumanMage mage = new HumanMage();
		HumanMage mage2 = new HumanMage();
		mage.fireballCast(mage2);
		mage.fireballCast(mage2);
	}
}
