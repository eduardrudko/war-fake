package warfake.war.armedforce;

import warfake.war.battlefield.OrcSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class ElfArcher extends Person implements Archer {
	private static final float SHOT_POWER = 15;
	private static final float STAB_POWER = 2;

	public ElfArcher() {
		setName("ElfArcher one");
	}
	
	@Override
	public void archeryShot(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, SHOT_POWER, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " shoots a poisonous arrow in ", target, SHOT_POWER, accuracy);
	}

	@Override
	public void meleeStab(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = 100;
		dealDamage(target, STAB_POWER,accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " stabs with an elven dagger ", target, STAB_POWER, accuracy);
	}

	public static void main(String[] args) {
		Squad squad = OrcSquadFactory.generateOrcSquad();
		ElfArcher elf1 = new ElfArcher();
		elf1.archeryShot(squad);
		elf1.archeryShot(squad);
		elf1.archeryShot(squad);
		elf1.archeryShot(squad);
		
		
	}
}
