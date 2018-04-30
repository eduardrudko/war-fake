package warfake.war.armedforce;

import java.util.Random;

import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;

public class UndeadZombie extends Person implements Warrior {
	private static final int NUMBER_OF_SKILLS = 1;
	
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
