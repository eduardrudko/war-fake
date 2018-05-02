package warfake.war.armedforce;

import java.util.Random;

import warefake.helpers.markers.Horde;
import warefake.helpers.markers.NoEnemiesException;
import warefake.helpers.markers.NoImprovableTargetsException;
import warfake.war.armory.UndeadWeapons;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class UndeadNecromant extends Person implements Mage, Horde {
	private static final float POKE_POWER = 5;
	private static final int NUMBER_OF_SKILLS = 2;
	private static UndeadWeapons boneStuff = UndeadWeapons.BONE_STUFF;
	private static int id = 1;
	private int name = id++;
	
	public UndeadNecromant() {
		setName("Undead Necromant " + name);
	}
	
	@Override
	public void useMagic(Squad targets) {
		try {
			Person target = targets.getRandomTarget();
			int accuracy = getMaxAccuracy();
			dealDamage(target, POKE_POWER, accuracy);
			logStrikeAction(getName(), boneStuff.getWeaponAction(), target, POKE_POWER, accuracy);
		} catch (NoEnemiesException e) {
			logAlianceVictory();
			Game.gameProcess = false;
			Game.createResults();
			System.exit(0);
		}

	}

//	@Override
//	public void applyImprovement(Squad targets) {
//		try {
//			Person target = targets.getRandomDeadTarget();
//			if (target instanceof HumanCrossbowman) {
//				target.setIsImproved(true);
//				target.setAccuracy(getAccuracy());
//				target.setAccuracy(Math.min((target.getAccuracy() + (target.getMaxAccuracy() * ENHANCE_CROSSBOWMAN_POWER) / 100),
//						getMaxAccuracy()));
//				logEnhanceActionForRangers(getName(), target, target.getAccuracy(), ENHANCE_CROSSBOWMAN_POWER);
//				targets.promotePerson(target);
//			} else {
//				target.setIsImproved(true);
//				target.setStrikePower((target.getStrikePower() + (target.getStrikePower() * ENHANCE_WARRIOR_POWER) / 100));
//				logEnhanceActionForMelee(getName(), target, target.getStrikePower(), ENHANCE_WARRIOR_POWER);
//				targets.promotePerson(target);
//			}
//		}
//		catch(NoImprovableTargetsException e) {
//			useMagic(targets);
//		}
//		
//	}
	
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
		// TODO Auto-generated method stub

	}
}
