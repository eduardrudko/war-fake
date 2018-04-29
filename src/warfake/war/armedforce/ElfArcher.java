package warfake.war.armedforce;

import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class ElfArcher extends Person implements Archer {
	private static final float SHOT_POWER = 15;
	private static final float STRIKE_POWER = 2;

	public ElfArcher() {
		setName("ElfArcher one");
	}
	
	@Override
	public void archeryShot(Person target) {
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, SHOT_POWER, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " shoots a poisonous arrow in ", target, SHOT_POWER, accuracy);
	}

	@Override
	public void meleeStab(Person target) {
		Game.numberOfTurns++;
		int accuracy = 100;
		dealDamage(target, STRIKE_POWER,accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " stabs with an elven dagger ", target, STRIKE_POWER, accuracy);
	}

	public static void main(String[] args) {
		ElfArcher elf1 = new ElfArcher();
		OrcShaman sham = new OrcShaman();
		elf1.archeryShot(sham);
		elf1.archeryShot(sham);
		elf1.archeryShot(sham);
		elf1.archeryShot(sham);
		
		
	}
}
