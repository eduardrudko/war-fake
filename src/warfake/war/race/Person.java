package warfake.war.race;

public abstract class Person {
	private int HP = 100;
	private static final int MAX_HP = 100;
	private int accuracy = 100;

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

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
}
