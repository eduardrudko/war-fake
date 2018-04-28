package warfake.war.classes;

public abstract class Mage extends Person {

	protected void enhanceSkillRanger(Person target, int enhancePower) {
		target.setAccuracy(Math.min((target.getAccuracy() + (target.getMaxAccuracy() * enhancePower) / 100), getMaxAccuracy()));
	}
	
	protected void enhanceSkillMelee(Person target, int enhancePower) {
		target.setSwordStrikePower((target.getSwordStrikePower() + (target.getSwordStrikePower() * enhancePower) / 100));
	}
}
