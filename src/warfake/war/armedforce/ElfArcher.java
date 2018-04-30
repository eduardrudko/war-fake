package warfake.war.armedforce;

import warfake.war.armory.ElfWeapons;
import warfake.war.battlefield.OrcSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class ElfArcher extends Person implements Archer {
	private static final float SHOT_POWER = 15;
	private static final float STAB_POWER = 2;
	private static ElfWeapons elvenBow = ElfWeapons.ELVEN_BOW;
	private static ElfWeapons elvenDagger = ElfWeapons.ELVEN_DAGGER;

	public ElfArcher() {
		setName("ElfArcher one");
	}
	
	@Override
	public void archeryShot(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, SHOT_POWER, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), elvenBow.getWeaponAction(), target, SHOT_POWER, accuracy);
	}

	@Override
	public void meleeStab(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = 100;
		dealDamage(target, STAB_POWER,accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), elvenDagger.getWeaponAction(), target, STAB_POWER, accuracy);
	}

	public static void main(String[] args) {
		Squad squad = OrcSquadFactory.generateOrcSquad();
		ElfArcher elf1 = new ElfArcher();
		elf1.archeryShot(squad);
		elf1.archeryShot(squad);
		elf1.archeryShot(squad);
		elf1.archeryShot(squad);
		elf1.meleeStab(squad);
		elf1.meleeStab(squad);
		elf1.meleeStab(squad);
		elf1.meleeStab(squad);
	}
}
