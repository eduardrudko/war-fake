package warfake.war.armedforce;

import warfake.war.classes.Person;
import warfake.war.game.Game;

public class ElfArcher extends Person {
	private static final float SHOT_POWER = 15;
	private static final float STRIKE_POWER = 2;

	public ElfArcher() {
		setName("ElfArcher one");
	}

	public void bowShot(Person target) {
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, SHOT_POWER, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " shoot an arrow in ", target, SHOT_POWER, accuracy);
	}

	public void strike(Person target) {
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, STRIKE_POWER,accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " strikes ", target, STRIKE_POWER, accuracy);
	}

	public static void main(String[] args) {
		ElfArcher elf1 = new ElfArcher();
		ElfArcher elf2 = new ElfArcher();
		ElfMage mage = new ElfMage();
		elf1.bowShot(elf2);
		elf2.strike(elf1);
		elf2.strike(elf1);
		mage.enhanceSkill(elf2);
		elf2.strike(elf1);
		elf1.bowShot(elf2);
		elf1.bowShot(elf2);
		mage.enhanceSkill(elf1);
		elf1.bowShot(elf2);
		elf1.bowShot(elf2);
		elf1.bowShot(elf2);
		mage.enhanceSkill(elf1);
		mage.enhanceSkill(elf1);
		mage.enhanceSkill(elf1);
		mage.enhanceSkill(elf1);
		mage.enhanceSkill(elf1);
		mage.enhanceSkill(elf1);
		mage.enhanceSkill(elf1);
		mage.enhanceSkill(elf1);
		mage.enhanceSkill(elf1);
		mage.enhanceSkill(elf1);
		elf1.bowShot(elf2);
		elf1.bowShot(elf2);
		elf1.bowShot(elf2);
		elf1.bowShot(elf2);
	}
}
