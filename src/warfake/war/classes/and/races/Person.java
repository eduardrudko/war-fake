package warfake.war.classes.and.races;

import warfake.war.game.Game;

public abstract class Person {
	private String name;
	private int HP = 100;
	private static final int MAX_HP = 100;
	private int accuracy;
	private static final int MAX_ACCURACY = 100;
	private int swordStrikePower = 20;

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
		this.HP = health;
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
	
	public int getSwordStrikePower() {
		return swordStrikePower;
	}
	
	public void setSwordStrikePower(int power) {
		this.swordStrikePower = power;
	}

	protected void dealDamage(Person target, float power, int accuracy) {
		target.setHealth(Math.max((target.getHealth() - Math.round((power * accuracy) / 100)), 0));
	}
	
	protected void logStrikeAction(int turnId, String attackerName, String actionType,  Person target, float strikePowerr, int accuracy) {
		System.out.println("[Move #" + turnId + "] " + attackerName + actionType + target.getName() + " with the " + accuracy + "% accuracy" + " and deal "
				+ Math.round((strikePowerr * accuracy) / 100) + " damage!");
		Game.logs.append("[Move #" + turnId + "] " + attackerName + actionType + target.getName() + " with the " + accuracy + "% accuracy" + " and deal "
				+ Math.round((strikePowerr * accuracy) / 100) + " damage!");
		System.out.println(target.getName() + " has " + target.getHealth() + " HP left!\n");
		Game.logs.append(target.getName() + " has " + target.getHealth() + " HP left!");
	}
	
	protected void logHealAction(int turnId, String name, Person target, float currentHealth, float healPower) {
		System.out.println("[Move #" + turnId + "] " + name + " lays a healing power upon " + target.getName() + " and heals " + ((MAX_HP * healPower) / 100) + " HP!");
		Game.logs.append("[Move #" + turnId + "] " + name + " lays a healing power upon " + target.getName() + " and heals " + ((MAX_HP * healPower) / 100) + " HP!");
		System.out.println(target.getName() + " has " + target.getHealth() + " HP now!\n");
		Game.logs.append(target.getName() + " has " + target.getHealth() + " HP now!");
	}
	
	protected void logEnhanceActionForRangers(int turnId, String name, Person target, int currentAccuracy, int enhancePower) {
		System.out.println("[Move #" + turnId + "] " + name + " lays an enhancing power upon " + target.getName() + " and increaces accuracy by " + enhancePower +  "%");
		Game.logs.append("[Move #" + turnId + "] " + name + " lays an enhancing power upon " + target.getName() + " and increaces accuracy by " + enhancePower +  "%");
		System.out.println(target.getName() + " has +" + target.getAccuracy() + "% accuracy passive bonus now!\n");
		Game.logs.append(target.getName() + " has +" + target.getAccuracy() + "% accuracy passive bonus now!");
	}
	
	protected void logEnhanceActionForMelee(int turnId, String name, Person target, int currentPower, int enhancePower) {
		System.out.println("[Move #" + turnId + "] " + name + " lays an enhancing power upon " + target.getName() + " and increaces melee power by " + enhancePower +  "%");
		Game.logs.append("[Move #" + turnId + "] " + name + " lays an enhancing power upon " + target.getName() + " and increaces melee power by " + enhancePower +  "%");
		System.out.println(target.getName() + " has " + target.getSwordStrikePower() + " attack power now!\n");
		Game.logs.append(target.getName() + " has " + target.getSwordStrikePower() + " attack power now!");
	}
	
	protected int getRandomAccuracy() {
		return (int)(Math.min((Math.random() * getMaxAccuracy() + getAccuracy()), 100));
	}
}
