package warfake.war.classes.and.races;

import warfake.war.battlefield.Squad;
import warfake.war.game.Game;

public abstract class Person implements Mage, Archer, Warrior {
	private String name;
	private int HP = 100;
	private static final int MAX_HP = 100;
	private int accuracy;
	private static final int MAX_ACCURACY = 100;
	private float strikePower;
	private boolean isDead;
	private boolean isImproved;

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

	@Override
	public void applyImprovement(Squad targets) {
		
	}

	@Override
	public void useMagic(Squad targets) {
		
	}
	
	@Override
	public void archeryShot(Squad targets) {
		
	}
	
	@Override
	public void meleeStab(Squad targets) {
		
	}
	
	@Override
	public void meleeStrike(Squad targets) {
		
	}
	
	public boolean isImproved() {
		return isImproved;
	}
	
	public void setIsImproved(boolean state) {
		isImproved = state;
	}
	
	public boolean isDead() {
		if (HP == 0) {
			isDead = true;
			return isDead;
		}
		else {
			return isDead;
		}
	}
	
	public abstract void performRandomAction(Squad aliance, Squad horde);

	protected void dealDamage(Person target, float power, int accuracy) {
		target.setHealth(Math.max((target.getHealth() - Math.round((power * accuracy) / 100)), 0));
	}
	
	protected void logStrikeAction(String attackerName, String actionType,  Person target, float strikePowerr, int accuracy) {
		System.out.println("\"" + attackerName + "\"" + actionType + "\"" + target.getName() + "\"" + " with the accuracy of " + accuracy + "%" + " and deal "
				+ Math.round((strikePowerr * accuracy) / 100) + " damage!");
		Game.logs.append("\"" + attackerName + "\"" + actionType + target.getName() + " with the accuracy of " + accuracy + "%" + " and deal "
				+ Math.round((strikePowerr * accuracy) / 100) + " damage!\n");
		System.out.println("\"" + target.getName() + "\"" + " has " + "[" + target.getHealth() + "/" + target.getMaxHealth() + "]" + " HP left!\n");
		Game.logs.append("\"" + target.getName() + "\"" + " has " + "[" + target.getHealth() + "/" + target.getMaxHealth() + "]" + " HP left!\n");
	}
	
	protected void logHealAction(String name, Person target, float currentHealth, float healPower) {
		System.out.println("\"" + name + "\"" + " lays healing power upon " + "\"" + target.getName() + "\"" + " and heals " + ((MAX_HP * healPower) / 100) + " HP!");
		Game.logs.append("\"" + name + "\"" + " lays healing power upon " + "\"" + target.getName() + "\"" + " and heals " + ((MAX_HP * healPower) / 100) + " HP!\n");
		System.out.println(target.getName() + " has " + "[" + target.getHealth() + "/" + target.getMaxHealth() + "]" + " HP now!\n");
		Game.logs.append(target.getName() + " has " + "[" + target.getHealth() + "/" + target.getMaxHealth() + "]" + " HP now!\n");
	}
	
	protected void logEnhanceActionForRangers(String name, Person target, int currentAccuracy, int enhancePower) {
		System.out.println("\"" + name + "\"" + " lays enhancing power upon " + "\"" + target.getName() + "\"" + " and increaces accuracy by " + enhancePower +  "%");
		Game.logs.append("\"" + name + "\"" + " lays enhancing power upon " + target.getName() + " and increaces accuracy by " + enhancePower +  "%");
		System.out.println("\"" + target.getName() + "\"" + " has +" + target.getAccuracy() + "% accuracy passive bonus now!\n");
		Game.logs.append("\"" + target.getName() + "\"" + " has +" + target.getAccuracy() + "% accuracy passive bonus now!\n");
	}
	
	protected void logEnhanceActionForMelee(String name, Person target, float currentPower, int enhancePower) {
		System.out.println("\"" + name + "\"" + " lays enhancing power upon " + "\"" + target.getName() + "\"" + " and increaces melee power by " + enhancePower +  "%");
		Game.logs.append("\"" + name + "\"" + " lays enhancing power upon " + "\"" + target.getName() + "\"" + " and increaces melee power by " + enhancePower +  "%");
		System.out.println("\"" + target.getName() + "\"" + " has " + target.getStrikePower() + " attack power now!\n");
		Game.logs.append("\"" + target.getName() + "\"" + " has " + target.getStrikePower() + " attack power now!\n");
	}
	
	protected void logAlianceVictory() {
		System.out.println("No enemies left!");
		Game.logs.append("No enemies left!");
		System.out.println("Aliance won!");
		Game.logs.append("Aliance won!");
	}
	
	
	protected void logHordeVictory() {
		System.out.println("No enemies left!");
		Game.logs.append("No enemies left!");
		System.out.println("Horde won!");
		Game.logs.append("Horde won!");
	}
	
	protected int getRandomAccuracy() {
		return (int)(Math.min((Math.random() * getMaxAccuracy() + getAccuracy()), 100));
	}
}
