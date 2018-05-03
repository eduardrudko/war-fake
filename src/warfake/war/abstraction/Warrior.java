package warfake.war.abstraction;

import warfake.war.battlefield.Squad;
/**
 * Warrior interface describes the Mage profession behaviour
 */
public interface Warrior {
	/**
	 * The declaration of the melee strike that all warriorlike-types should implement
	 * Produces damage to a target and marks it as dead if its health gets below 0
	 * @param targets a spell could be done on;
	 */
	void meleeStrike(Squad targets);
}
