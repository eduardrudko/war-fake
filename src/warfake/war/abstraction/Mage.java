package warfake.war.abstraction;

import warfake.war.battlefield.Squad;
/**
 * Mage interface describes the Mage profession behaviour
 */
public interface Mage {
	/**
	 * The declaration of the improvement spell that all magelike-types should implement
	 * Produces damage to a target and marks it as dead if its health gets below 0
	 * @param targets a spell could be done on;
	 */
	void applyImprovement(Squad targets);
	/**
	 * The declaration of the magic spell that all magelike-types should implement
	 * Produces damage to a target and marks it as dead if its health gets below 0
	 * @param targets a spell could be done on;
	 */
	void useMagic(Squad targets);
}
