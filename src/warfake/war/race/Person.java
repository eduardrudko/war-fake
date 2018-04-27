package warfake.war.race;

public abstract class Person {
	private float HP = 100;
	private static final float MAX_HP = 100;
	private int accuracy = 100;

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
}
