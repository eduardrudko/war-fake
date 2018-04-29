package warfake.war.armedforce;

import warfake.war.classes.and.races.Person;
import warfake.war.classes.and.races.Warrior;
import warfake.war.game.Game;

public class ElfWarrior extends Person implements Warrior{
	
	public ElfWarrior() {
		setName("Fillip");
	}
	
	public void longSwordStrike(Person target) {
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, getSwordStrikePower(), accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " strikes with an elven longsword ", target, getSwordStrikePower(), accuracy);
	}

	public static void main(String[] args) {
		ElfWarrior elf1 = new ElfWarrior();
		ElfWarrior elf2 = new ElfWarrior();
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		System.out.println();
		ElfMage elf3 = new ElfMage();
		elf3.enhanceSkill(elf1);
		elf3.enhanceSkill(elf1);
		elf3.enhanceSkill(elf1);
		elf3.enhanceSkill(elf1);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		elf1.longSwordStrike(elf2);
		
		

	}

}
