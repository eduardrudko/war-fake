package warfake.war.armedforce;

import java.util.Random;

import warefake.war.markers.Aliance;
import warefake.war.markers.Improvable;
import warfake.war.armory.HumanWeapons;
import warfake.war.battlefield.ElfSquadFactory;
import warfake.war.battlefield.OrcSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Person;

public class HumanCrossbowman extends Person implements Archer, Aliance, Improvable {
	private static final float SHOT_POWER = 15;
	private static final float STRIKE_POWER = 5;
	private static HumanWeapons sword = HumanWeapons.SWORD;
	private static HumanWeapons broadsword = HumanWeapons.BROADSWORD;
	private static final int NUMBER_OF_SKILLS = 2;
	private static int id = 1;
	private int name = id++;
	
	public HumanCrossbowman() {
		setName("Human crossbowman");
	}
	
	@Override
	public void archeryShot(Squad targets) {
		Person target = targets.getRandomTarget();
		int accuracy = getRandomAccuracy();
		dealDamage(target, SHOT_POWER, accuracy);
		logStrikeAction(getName(), sword.getWeaponAction(), target, SHOT_POWER, accuracy);
	}

	@Override
	public void meleeStab(Squad targets) {
		Person target = targets.getRandomTarget();
		int accuracy = 100;
		dealDamage(target, STRIKE_POWER,accuracy);
		logStrikeAction(getName(), broadsword.getWeaponAction(), target, STRIKE_POWER, accuracy);
	}
	
	@Override
	public void performRandomAction(Squad aliance, Squad horde) {
		Random rnd = new Random();
		switch (rnd.nextInt(NUMBER_OF_SKILLS) + 1) {
		case 1:
			archeryShot(horde);
			break;
		case 2:
			meleeStab(horde);
			break;
		}
	}

	public static void main(String[] args) {
		Squad squad = OrcSquadFactory.generateOrcSquad();
		Squad squad1 = ElfSquadFactory.generateElfSquad();
		HumanCrossbowman elf1 = new HumanCrossbowman();
		elf1.performRandomAction(squad, squad1);
		elf1.performRandomAction(squad, squad1);
		elf1.performRandomAction(squad, squad1);
		elf1.performRandomAction(squad, squad1);

	}
}
