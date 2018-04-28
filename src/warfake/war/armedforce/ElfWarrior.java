package warfake.war.armedforce;

import warfake.war.classes.Person;

public class ElfWarrior extends Person {
	private final float strikePower = 20;
	
	public void swordStrike(Person target) {
		dealDamage(target, strikePower);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
