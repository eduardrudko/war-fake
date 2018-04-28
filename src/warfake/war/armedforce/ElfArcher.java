package warfake.war.armedforce;

import warfake.war.classes.Person;
import warfake.war.game.Game;

public class ElfArcher extends Person {
	private final float shotPower = 15;
	private final float strikePower = 2;

	public ElfArcher() {
		setName("ElfArcher one");
	}

	public void bowShot(Person target) {
		Game.numberOfTurns++;
		dealDamage(target, shotPower);
		logStrikeAction(Game.numberOfTurns, getName(), " shoot an arrow in ", target, shotPower, getAccuracy());
	}

	public void strike(Person target) {
		Game.numberOfTurns++;
		dealDamage(target, strikePower);
		logStrikeAction(Game.numberOfTurns, getName(), " strikes  ", target, strikePower, getAccuracy());
	}

	public static void main(String[] args) {
		ElfArcher elf1 = new ElfArcher();
		ElfArcher elf2 = new ElfArcher();
		elf1.bowShot(elf2);
		elf2.strike(elf1);
		elf2.strike(elf1);
		elf2.strike(elf1);
	}
}
