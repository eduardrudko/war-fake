package warfake.war.classes;

import warfake.war.armedforce.ElfArcher;
import warfake.war.armedforce.ElfWarrior;
import warfake.war.armedforce.HumanCrossbowman;
import warfake.war.game.Game;

public abstract class Mage extends Person {
	private static final int ENHANCE_CROSSBOWMANS_POWER = 10;
	private static final int ENHANCE_WARRIOR_POWER = 20;
	private static final int ENHANCE_ARCHER_POWER = 10;
	
	public void enhanceSkill(ElfArcher archer) {
		if (archer.getAccuracy() != 100) {
			Game.numberOfTurns++;
			enhanceSkillRanger(archer, ENHANCE_ARCHER_POWER);
			logEnhanceActionForRangers(Game.numberOfTurns, getName(), archer, archer.getAccuracy(), ENHANCE_ARCHER_POWER);
		}
		else {
			accuracyLimit(archer);
		}
	}
	
	public void enhanceSkill(HumanCrossbowman crossbowman) {
		if (crossbowman.getAccuracy() != 100) {
			Game.numberOfTurns++;
			enhanceSkillRanger(crossbowman, ENHANCE_CROSSBOWMANS_POWER);
			logEnhanceActionForRangers(Game.numberOfTurns, getName(), crossbowman, crossbowman.getAccuracy(), ENHANCE_CROSSBOWMANS_POWER);
		}
		else {
			accuracyLimit(crossbowman);
		}
	}
	
	public void enhanceSkill(Person warrior) {
		Game.numberOfTurns++;
		enhanceSkillMelee(warrior, ENHANCE_WARRIOR_POWER);
		logEnhanceActionForMelee(Game.numberOfTurns, getName(), warrior, warrior.getSwordStrikePower(), ENHANCE_WARRIOR_POWER);
	}

	protected void enhanceSkillRanger(Person target, int enhancePower) {
		target.setAccuracy(Math.min((target.getAccuracy() + (target.getMaxAccuracy() * enhancePower) / 100), getMaxAccuracy()));
	}
	
	protected void enhanceSkillMelee(Person target, int enhancePower) {
		target.setSwordStrikePower((target.getSwordStrikePower() + (target.getSwordStrikePower() * enhancePower) / 100));
	}
	
	private void accuracyLimit(Person person) {
		Game.numberOfTurns++;
		System.out.println("[Move #" + Game.numberOfTurns + "] " + getName() + " trying to use enhancing power but spell doesn't have any effect! " + person.getName() + " has 100% accuracy and come as a precise shooter now!\n");
		Game.logs.append("[Move #" + Game.numberOfTurns + "] " + getName() + " trying to use enhancing power but spell doesn't have any effect! " + person.getName() + " 100% accuracy and come as a precise shooter now!\n");
	}
}
