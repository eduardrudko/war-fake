package warfake.war.armedforce;

import java.util.Random;

import warefake.helpers.markers.Horde;
import warefake.helpers.markers.NoImprovableTargetsException;
import warefake.helpers.markers.NoImprovedTargetsException;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Person;

public class OrcShaman extends Person implements Mage, Horde {
	private static final int ENHANCE_GOBLIN_POWER = 20;
	private static final int ENHANCE_ARCHER_POWER = 10;
	private static final int NUMBER_OF_SKILLS = 2;
	private static int id = 1;
	private int name = id++;

	public OrcShaman() {
		setName("Orc Shaman" + name);
	}

	@Override
	public void useMagic(Squad targets) {
		try {
			Person target = targets.getRandomImprovedTarget();
			targets.demotePerson(target);
			logCurseAction(getName(), target);
		} 
		catch (NoImprovedTargetsException e) {
			logFailedCurseAction(getName());
		}
	}

	@Override
	public void applyImprovement(Squad targets) {
		try {
			Person target = targets.getRandomImprovableTarget();
			if (target instanceof OrcArcher) {
				target.setAccuracy(getAccuracy());
				target.setAccuracy(
						Math.min((target.getAccuracy() + (target.getMaxAccuracy() * ENHANCE_ARCHER_POWER) / 100),
								getMaxAccuracy()));
				logEnhanceActionForRangers(getName(), target, target.getAccuracy(), ENHANCE_ARCHER_POWER);
				targets.promotePerson(target);
			} else {
				target.setIsImproved(true);
				target.setStrikePower(
						(target.getStrikePower() + (target.getStrikePower() * ENHANCE_GOBLIN_POWER) / 100));
				logEnhanceActionForMelee(getName(), target, target.getStrikePower(), ENHANCE_GOBLIN_POWER);
				targets.promotePerson(target);
			}
		} catch (NoImprovableTargetsException e) {
			useMagic(targets);
		}

	}

	@Override
	public void performRandomAction(Squad aliance, Squad horde) {
		Random rnd = new Random();
		switch (rnd.nextInt(NUMBER_OF_SKILLS) + 1) {
		case 1:
			useMagic(aliance);
			break;
		case 2:
			applyImprovement(horde);
			break;
		}
	}

	public static void main(String[] args) {

	}
}
