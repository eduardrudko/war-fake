package warfake.war.armedforce;

import java.util.Random;

import warefake.war.markers.Improvable;
import warfake.war.armory.OrcWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;
import warfake.war.game.Game;

public class OrcGoblin extends Person implements Warrior, Improvable {
	private float strikePower = 20;
	private static OrcWeapons club = OrcWeapons.CLUB;
	private static final int NUMBER_OF_SKILLS = 1;
	
	public OrcGoblin() {
		setName("Durachok");
	}
	
	@Override
	public void meleeStrike(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, strikePower, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), club.getWeaponAction(), target, strikePower, accuracy);
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
