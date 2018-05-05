package warfake.war.abstraction;

import warfake.war.battlefield.Squad;
import warfake.war.game.Game;


public abstract class Person {
	private String name;
	private int HP = 100;
	private static final int MAX_HP = 100;
	private int accuracy;
	private static final int MAX_ACCURACY = 100;
	private static final float DEFAULT_STIKE_POWER = 20;
	private float strikePower;
	private boolean isDead;
	private boolean isImproved;
	private boolean isCursed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return HP;
	}

	public int getMaxHealth() {
		return MAX_HP;
	}

	public void setHealth(int health) {
		HP = health;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public int getMaxAccuracy() {
		return MAX_ACCURACY;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public float getStrikePower() {
		return strikePower;
	}

	public void setStrikePower(float strikePower) {
		this.strikePower = strikePower;
	}

	public float getDefaultStrikePower() {
		return DEFAULT_STIKE_POWER;
	}

	public boolean isImproved() {
		return isImproved;
	}

	public void setIsImproved(boolean state) {
		isImproved = state;
	}
	
	public boolean isCursed() {
		return isCursed;
	}
	
	public void setIsCursed(boolean state) {
		isCursed = state;
	}

	/**
	 * Method that is used to mark a character as dead
	 * 
	 * @return true if a character is dead and false if character is still alive
	 */
	public boolean isDead() {
		if (HP == 0) {
			isDead = true;
			return isDead;
		} else {
			return isDead;
		}
	}

	/**
	 * Method that chooses the correct target and performs a random available action
	 * for particular character realization
	 * 
	 * @param aliance
	 *            to perform an action on
	 * @param horde
	 *            to perform an action
	 */
	public abstract void performRandomAction(Squad aliance, Squad horde);

	/**
	 * The engine of producing damage to a character. Calculates the damage based on
	 * current power and given accuracy and subtracts it for the current health
	 * level but not less than 0. Assigns the updated health level to the target.
	 * 
	 * @param target
	 *            damage that have to be dealt on
	 * @param power
	 *            the given attack power
	 * @param accuracy
	 *            the given accuracy
	 */
	protected void dealDamage(Person target, float power, int accuracy) {
		target.setHealth(Math.max((target.getHealth() - Math.round((power * accuracy) / 100)), 0));
	}
/**
 * Directs the logs produced during melee strike action to the standard output
 * and writes them to the global log String Builder
 * @param attackerName of the attacker
 * @param actionType string implementation of the action
 * @param target the action has been performed on
 * @param strikePower on the moment of striking
 * @param accuracy on the moment of striking
 */
	protected void logStrikeAction(String attackerName, String actionType, Person target, float strikePower,
			int accuracy) {
		System.out.println(
				"\"" + attackerName + "\"" + actionType + "\"" + target.getName() + "\"" + " with the accuracy of "
						+ accuracy + "%" + " and deal " + Math.round((strikePower * accuracy) / 100) + " damage!");
		Game.logs.append("\"" + attackerName + "\"" + actionType + target.getName() + " with the accuracy of "
				+ accuracy + "%" + " and deal " + Math.round((strikePower * accuracy) / 100) + " damage!\n");
		System.out.println("\"" + target.getName() + "\"" + " has " + "[" + target.getHealth() + "/"
				+ target.getMaxHealth() + "]" + " HP left!\n");
		Game.logs.append("\"" + target.getName() + "\"" + " has " + "[" + target.getHealth() + "/"
				+ target.getMaxHealth() + "]" + " HP left!\n");
	}
	/**
	 * Directs the logs produced during Heal spell to the standard output
	 * and writes them to the global log String Builder
	 * @param name of the caster
	 * @param target of the spell
	 * @param currentHealth on the moment of spell casting
	 * @param healPower of the caster
	 */
	protected void logHealAction(String name, Person target, float currentHealth, float healPower) {
		System.out.println("\"" + name + "\"" + " lays healing power upon " + "\"" + target.getName() + "\""
				+ " and heals " + ((MAX_HP * healPower) / 100) + " HP!");
		Game.logs.append("\"" + name + "\"" + " lays healing power upon " + "\"" + target.getName() + "\""
				+ " and heals " + ((MAX_HP * healPower) / 100) + " HP!\n");
		System.out.println(target.getName() + " has " + "[" + target.getHealth() + "/" + target.getMaxHealth() + "]"
				+ " HP now!\n");
		Game.logs.append(target.getName() + " has " + "[" + target.getHealth() + "/" + target.getMaxHealth() + "]"
				+ " HP now!\n");
	}
	/**
	 * Directs the logs produced during failed Heal spell to the standard output
	 * and writes them to the global log String Builder
	 * @param name of the caster
	 * @param target of the spell
	 */
	protected void logFailedHealAction(String name, Person target) {
		System.out.println("\"" + name + "\"" + " tries to use healing power but spell doesn't have any effect! " + "\""
				+ target.getName() + "\"" + " is healthy!\n");
		Game.logs.append("\"" + name + "\"" + " tries to use healing power but spell doesn't have any effect! " + "\""
				+ target.getName() + "\"" + " is healthy!\n");
	}
	/**
	 * Directs the logs produced during enhancing rangers accuracy to the standard output
	 * and writes them to the global log String Builder
	 * @param name of the caster
	 * @param target of the spell
	 * @param currentAccuracy on the moment of spell casting
	 * @param enhancePower of the caster
	 */
	protected void logEnhanceActionForRangers(String name, Person target, int currentAccuracy, int enhancePower) {
		System.out.println("\"" + name + "\"" + " lays enhancing power upon " + "\"" + target.getName() + "\""
				+ " and increaces accuracy by " + enhancePower + "%!");
		Game.logs.append("\"" + name + "\"" + " lays enhancing power upon " + target.getName()
				+ " and increaces accuracy by " + enhancePower + "%!");
		System.out.println(
				"\"" + target.getName() + "\"" + " will have +" + target.getAccuracy() + "% accuracy passive bonus for the next turn!\n");
		Game.logs.append(
				"\"" + target.getName() + "\"" + " will have +" + target.getAccuracy() + "% accuracy passive bonus for the next turn!\n");
	}
	/**
	 * Directs the logs produced during enhancing meeles power attack to the standard output
	 * and writes them to the global log String Builder
	 * @param name of the caster
	 * @param target of the spell
	 * @param currentPower on the moment of spell casting
	 * @param enhancePower of the caster
	 */
	protected void logEnhanceActionForMelee(String name, Person target, float currentPower, int enhancePower) {
		System.out.println("\"" + name + "\"" + " lays enhancing power upon " + "\"" + target.getName() + "\""
				+ " and increaces melee power by " + enhancePower + "%");
		Game.logs.append("\"" + name + "\"" + " lays enhancing power upon " + "\"" + target.getName() + "\""
				+ " and increaces melee power by " + enhancePower + "%");
		System.out.println("\"" + target.getName() + "\"" + " will have " + target.getStrikePower() + " attack power for the next turn!\n");
		Game.logs.append("\"" + target.getName() + "\"" + " will have " + target.getStrikePower() + " attack power for the next turn\n");
	}
	/**
	 * Directs the logs produced during curse spell to the standard output
	 * and writes them to the global log String Builder
	 * @param name of the caster
	 * @param target of the spell
	 */
	protected void logCurseAction(String name, Person target) {
		System.out.println("\"" + name + "\"" + " curses the " + "\"" + target.getName() + "\""
				+ " and absorb all status bonuses for the next turn!\n");
		Game.logs.append("\"" + name + "\"" + " curses the " + "\"" + target.getName() + "\""
				+ " and absorb all status bonuses for the next turn!\n");
	}
	/**
	 * Directs the logs produced during failed curse spell to the standard output
	 * and writes them to the global log String Builder
	 * @param name of the caster
	 */
	protected void logFailedCurseAction(String name) {
		System.out.println(
				"\"" + name + "\"" + " tries to use shamany curse but it's failed! There are no improved enemies!\n");
		Game.logs.append(
				"\"" + name + "\"" + " tries to use shamany curse but it's failed! There are no improved enemies!\n");
	}
	/**
	 * Directs the logs produced during resurrection spell to the standard output
	 * and writes them to the global log String Builder
	 * @param name of the caster
	 * @param target of the spell
	 */
	protected void logResurrection(String name, Person target) {
		System.out.println("\"" + name + "\"" + " use resurrection spell on " + "\"" + target.getName() + "\""
				+ " and rises it as a zombie!\n");
		Game.logs.append("\"" + name + "\"" + " use resurrection spell on " + "\"" + target.getName() + "\""
				+ " and rises it as a zombie!\n");
	}
	/**
	 * Directs the logs produced during failed resurrection spell to the standard output
	 * and writes them to the global log String Builder
	 * @param name of the caster
	 */
	protected void logFailedUndeadResurraction(String name) {
		System.out.println("\"" + name + "\""
				+ " tries to use black magic to rise a dead but it's failed! There are no dead bodies around!\n");
		Game.logs.append("\"" + name + "\""
				+ " tries to use black magic to rise a dead but it's failed! There are no dead bodies around!\n");
	}
	/**
	 * Directs the logs produced of the end of the game to the standard output
	 * and writes them to the global log String Builder. States that the game is end and displays the winner is Aliance.
	 */
	protected void logAlianceVictory() {
		System.out.println("No enemies left!");
		Game.logs.append("No enemies left!");
		System.out.println("Aliance won!");
		Game.logs.append("Aliance won!");
	}
	/**
	 * Directs the logs produced of the end of the game to the standard output
	 * and writes them to the global log String Builder. States that the game is end and displays the winner is Horde.
	 */
	protected void logHordeVictory() {
		System.out.println("No enemies left!");
		Game.logs.append("No enemies left!\n");
		System.out.println("Horde won!");
		Game.logs.append("Horde won!");
	}
	/**
	 * Each person is able to get its own accuracy value before performing an action
	 */
	protected int getRandomAccuracy() {
		System.out.println("Accuracy bonus: " + getAccuracy());
		return (int) (Math.min((Math.random() * getMaxAccuracy() + getAccuracy()), 100));
	}
}
