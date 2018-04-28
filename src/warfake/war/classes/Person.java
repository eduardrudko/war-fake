package warfake.war.classes;

import warfake.war.game.Game;

public abstract class Person {
	private String name;
	private float HP = 100;
	private static final float MAX_HP = 100;
	private int accuracy = 100;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHealth() {
		return HP;
	}

	public float getMaxHealth() {
		return MAX_HP;
	}

	public void setHealth(float health) {
		this.HP = health;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	protected void dealDamage(Person target, float power) {
		int currentAccuracy = getAccuracy();
		float currentTargetHealth = target.getHealth();
		target.setHealth(currentTargetHealth - Math.round((power * currentAccuracy) / 100));
	}
	
	protected void logStrikeAction(int turnId, String attackerName, String actionType,  Person target, float shotPower, int accuracy) {
		System.out.println(turnId + ". " + attackerName + actionType + target.getName() + " with "
				+ Math.round((shotPower * accuracy) / 100) + " damage! ");
		Game.logs.append(turnId + ". " + attackerName + actionType + target.getName() + " with "
				+ Math.round((shotPower * accuracy) / 100) + " damage! ");
		System.out.println(target.getName() + " has " + target.getHealth() + " HP left!");
		Game.logs.append(target.getName() + " has " + target.getHealth() + " HP left!");
	}
	
	protected void logHealAction(int turnId, String name, Person target, float currentHealth, float healPower, int mana) {
		System.out.println(turnId + ". " + name + " lays a healing power upon " + target.getName() + " and heals " + ((currentHealth * healPower) / 100) + " HP!");
		Game.logs.append(turnId + ". " + name + " lays a healing power upon " + target.getName() + " and heals " + ((currentHealth * healPower) / 100) + " HP!");
		System.out.println(name + " has " + mana + " magic power left.");
		Game.logs.append(name + " has " + mana + " magic power left.");
		System.out.println(target.getName() + " has " + target.getHealth() + " HP now!");
		Game.logs.append(target.getName() + " has " + target.getHealth() + " HP now!");
	}
}
