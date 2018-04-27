package warfake.war.armedforce;

import warfake.war.race.Elf;
import warfake.war.race.Person;

public class ElfArcher extends Elf {
	private final float shotPower = 15;
	private final float strikePower = 2;
	
	public void bowShot(Person target) {
		dealDamage(target, shotPower);
	}
	
	public void strike(Person target) {
		dealDamage(target, strikePower);
	}
	
	private void dealDamage(Person target, float power) {
		int currentAccuracy = getAccuracy();
		float currentTargetHealth = target.getHealth();
		target.setHealth(currentTargetHealth - Math.round((power * currentAccuracy) / 100));
	}
	
	public static void main(String[] args) {

	}
}
