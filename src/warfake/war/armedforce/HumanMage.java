package warfake.war.armedforce;

import java.util.Random;

import warefake.war.markers.Aliance;
import warfake.war.armory.HumanWeapons;
import warfake.war.battlefield.HumanSquadFactory;
import warfake.war.battlefield.OrcSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Person;

public class HumanMage extends Person implements Mage, Aliance {
	private static final int MAGIC_POWER = 20;
	private static final int ENHANCE_WARRIOR_POWER = 20;
	private static final int ENHANCE_CROSSBOWMAN_POWER = 10;
	private static HumanWeapons fireBallSpell = HumanWeapons.FIREBALL;
	private static final int NUMBER_OF_SKILLS = 2;
	
	public HumanMage() {
		setName("Mage");
	}
	
	@Override
	public void useMagic(Squad targets) {
		Person target = targets.getRandomTarget();
		int accuracy = getRandomAccuracy();
		dealDamage(target, MAGIC_POWER, accuracy);
		logStrikeAction(getName(), fireBallSpell.getWeaponAction(), target, MAGIC_POWER, accuracy);
	}
	
	@Override
	public void applyImprovement(Squad targets) {
		Person target = targets.getRandomImprovableTarget();
		if (target instanceof HumanCrossbowman) {
			target.setAccuracy(Math.min((target.getAccuracy() + (target.getMaxAccuracy() * ENHANCE_CROSSBOWMAN_POWER) / 100), getMaxAccuracy()));
			logEnhanceActionForRangers(getName(), target, target.getAccuracy(),
					ENHANCE_CROSSBOWMAN_POWER);
			targets.getSuperPersons().add(target);
			targets.getRegularPersons().remove(target);
		} else {
			target.setStrikePower((target.getStrikePower() + (target.getStrikePower() * ENHANCE_WARRIOR_POWER) / 100));
			logEnhanceActionForMelee(getName(), target, target.getStrikePower(),
					ENHANCE_WARRIOR_POWER);
			targets.getSuperPersons().add(target);
			targets.getRegularPersons().remove(target);
		}
	}
	
	@Override
	public void performRandomAction(Squad aliance, Squad horde) {
		Random rnd = new Random();
		switch (rnd.nextInt(NUMBER_OF_SKILLS) + 1) {
		case 1:
			useMagic(horde);
			break;
		case 2:
			applyImprovement(aliance);
			break;
		}
	}

	public static void main(String[] args) {
		Squad squad = HumanSquadFactory.generateHumanSquad();
		Squad orcs = OrcSquadFactory.generateOrcSquad();
		System.out.println(squad.getRegularPersons().toString());
		HumanMage mage = new HumanMage();
		mage.applyImprovement(squad);
		System.out.println(squad.getRegularPersons().toString());
		System.out.println(squad.getSuperPersons().toString());
		mage.useMagic(orcs);
	}
}
