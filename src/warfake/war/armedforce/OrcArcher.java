package warfake.war.armedforce;

import warfake.war.armory.OrcWeapons;
import warfake.war.battlefield.ElfSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class OrcArcher extends Person implements Archer {
	private static final float SHOT_POWER = 17;
	private static final float STRIKE_POWER = 2;
	private static OrcWeapons bow = OrcWeapons.BOW;
	private static OrcWeapons axe = OrcWeapons.AXE;


	@Override
	public void archeryShot(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, SHOT_POWER, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), bow.getWeaponAction(), target, SHOT_POWER, accuracy);
		
	}

	@Override
	public void meleeStab(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = 100;
		dealDamage(target, STRIKE_POWER,accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), axe.getWeaponAction(), target, STRIKE_POWER, accuracy);
		
	}
	
	public static void main(String[] args) {
		Squad squad = ElfSquadFactory.generateElfSquad();
		OrcArcher orc = new OrcArcher();
		orc.archeryShot(squad);
		orc.archeryShot(squad);
		orc.archeryShot(squad);
		orc.archeryShot(squad);
		orc.meleeStab(squad);
		orc.meleeStab(squad);
		orc.meleeStab(squad);
		orc.meleeStab(squad);
	}
}
