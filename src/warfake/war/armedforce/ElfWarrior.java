package warfake.war.armedforce;

import java.util.Random;

import warefake.war.markers.Aliance;
import warefake.war.markers.Improvable;
import warfake.war.armory.ElfWeapons;
import warfake.war.battlefield.ElfSquadFactory;
import warfake.war.battlefield.OrcSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;

public class ElfWarrior extends Person implements Warrior, Aliance, Improvable {
	private float strikePower = 20;
	private static ElfWeapons longSword = ElfWeapons.ELVEN_LONGSWORD;
	private static final int NUMBER_OF_SKILLS = 1;
	private static int id = 1;
	private int name = id++;
	
	public ElfWarrior() {
		setName("Elf Warrior " + name);
	}
	
	@Override
	public void meleeStrike(Squad targets) {
		Person target = targets.getRandomTarget();
		int accuracy = getRandomAccuracy();
		dealDamage(target, strikePower, accuracy);
		logStrikeAction(getName(), longSword.getWeaponAction(), target, strikePower, accuracy);
	}

	@Override
	public float getStrikePower() {
		return strikePower;
	}

	@Override
	public void setStrikePower(float strikePower) {
		this.strikePower = strikePower;
	}
	
	@Override
	public void performRandomAction(Squad aliance, Squad horde) {
		Random rnd = new Random();
		switch (rnd.nextInt(NUMBER_OF_SKILLS) + 1) {
		case 1:
			meleeStrike(horde);
			break;
		}
	}

	public static void main(String[] args) {
		Squad squad = OrcSquadFactory.generateOrcSquad();
		Squad squad1 = ElfSquadFactory.generateElfSquad();
		ElfWarrior elf1 = new ElfWarrior();
		elf1.performRandomAction(squad, squad1);
		elf1.performRandomAction(squad, squad1);
		elf1.performRandomAction(squad, squad1);
		elf1.performRandomAction(squad, squad1);
	}
}
