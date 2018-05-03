package warfake.war.abstraction;

import warfake.war.battlefield.Squad;
/**
 * Archer interface describes the Archer profession behaviour
 */
public interface Archer {
	/**
	 * The declaration of the archery shot skill that all archerlike-types should implement
	 * Produces damage to a target and marks it as dead if its health gets below 0
	 * @param targets a shot could be done on;
	 */
	void archeryShot(Squad targets);
	/**
	 * The declaration of the archery melee skill that all archerlike-types should implement
	 * Produces damage to a target and marks it as dead if its health gets below 0
	 * @param targets a stab could be done on;
	 */
	void meleeStab(Squad targets);
}
