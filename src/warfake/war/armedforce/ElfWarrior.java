package warfake.war.armedforce;

import java.util.Random;

import warefake.war.markers.Improvable;
import warfake.war.armory.ElfWeapons;
import warfake.war.battlefield.OrcSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;
import warfake.war.game.Game;

public class ElfWarrior extends Person implements Warrior, Improvable {
	private float strikePower = 20;
	private static ElfWeapons longSword = ElfWeapons.ELVEN_LONGSWORD;
	private static final int NUMBER_OF_SKILLS = 1;
	
	public ElfWarrior() {
		setName("Fillip");
	}
	
	@Override
	public void meleeStrike(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, strikePower, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), longSword.getWeaponAction(), target, strikePower, accuracy);
	}

	public float getStrikePower() {
		return strikePower;
	}

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
		ElfWarrior elf1 = new ElfWarrior();
		elf1.meleeStrike(squad);
		elf1.meleeStrike(squad);
		elf1.meleeStrike(squad);
		elf1.meleeStrike(squad);
		elf1.meleeStrike(squad);
		elf1.meleeStrike(squad);
		elf1.meleeStrike(squad);
		elf1.meleeStrike(squad);
		elf1.meleeStrike(squad);
		elf1.meleeStrike(squad);
		elf1.meleeStrike(squad);
		elf1.meleeStrike(squad);
	}
}
