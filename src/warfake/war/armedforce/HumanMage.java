package warfake.war.armedforce;

import warfake.war.armory.HumanWeapons;
import warfake.war.battlefield.HumanSquadFactory;
import warfake.war.battlefield.OrcSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Mage;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class HumanMage extends Person implements Mage {
	private static final int MAGIC_POWER = 20;
	private static final int ENHANCE_WARRIOR_POWER = 20;
	private static final int ENHANCE_CROSSBOWMAN_POWER = 10;
	private static HumanWeapons fireBallSpell = HumanWeapons.FIREBALL;
	
	public HumanMage() {
		setName("Mage");
	}
	
	@Override
	public void useMagic(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, MAGIC_POWER, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), fireBallSpell.getWeaponAction(), target, MAGIC_POWER, accuracy);
	}
	
	@Override
	public void applyImprovement(Squad targets) {
		Person target = targets.getRandomImprovableTarget();
		if (target instanceof HumanCrossbowman) {
			Game.numberOfTurns++;
			target.setAccuracy(Math.min((target.getAccuracy() + (target.getMaxAccuracy() * ENHANCE_CROSSBOWMAN_POWER) / 100), getMaxAccuracy()));
			logEnhanceActionForRangers(Game.numberOfTurns, getName(), target, target.getAccuracy(),
					ENHANCE_CROSSBOWMAN_POWER);
			targets.getSuperArchers().add(target);
			targets.getArchers().remove(target);
		} else {
			Game.numberOfTurns++;
			target.setStrikePower((target.getStrikePower() + (target.getStrikePower() * ENHANCE_WARRIOR_POWER) / 100));
			logEnhanceActionForMelee(Game.numberOfTurns, getName(), target, target.getStrikePower(),
					ENHANCE_WARRIOR_POWER);
			targets.getSuperWarriors().add(target);
			targets.getWarriors().remove(target);
		}
	}

	public static void main(String[] args) {
		Squad squad = HumanSquadFactory.generateHumanSquad();
		Squad orcs = OrcSquadFactory.generateOrcSquad();
		System.out.println(squad.getArchers().toString());
		System.out.println(squad.getWarriors().toString());
		HumanMage mage = new HumanMage();
		mage.applyImprovement(squad);
		System.out.println(squad.getSuperArchers().toString());
		System.out.println(squad.getSuperWarriors().toString());
		mage.useMagic(orcs);
	}
}
