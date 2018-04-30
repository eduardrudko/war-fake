package warfake.war.armedforce;

import java.util.Random;

import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Person;

public class UndeadNecromant extends Person implements Mage {
	private static final int NUMBER_OF_SKILLS = 2;
	
	@Override
	public void performRandomAction(Squad aliance, Squad horde) {
		Random rnd = new Random();
		switch (rnd.nextInt(NUMBER_OF_SKILLS) + 1) {
		case 1:
			useMagic(aliance);
			break;
		case 2:
			applyImprovement(horde);
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
