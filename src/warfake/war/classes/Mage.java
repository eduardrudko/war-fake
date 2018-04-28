package warfake.war.classes;

public abstract class Mage extends Person {

	protected void enhanceSkill(Person target, int enhancePower) {
		int currentAccuracy = target.getAccuracy();
		target.setAccuracy(currentAccuracy + ((currentAccuracy * enhancePower)) / 100);
	}
}
