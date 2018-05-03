package warfake.war.armedforce;

import java.util.Random;

import warfake.exeptions.NoDeadBodiesException;
import warfake.exeptions.NoEnemiesException;
import warfake.markers.Horde;
import warfake.war.abstraction.Mage;
import warfake.war.abstraction.Person;
import warfake.war.armory.UndeadWeapons;
import warfake.war.battlefield.Squad;
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
			if (target.isDead()) {
				targets.removePerson(target);
			}
		} catch (NoEnemiesException e) {
			logAlianceVictory();
			Game.gameProcess = false;
			Game.createResults();
			System.exit(0);
		}

	}

	@Override
	public void applyImprovement(Squad targets) {
		try {
			Person target = Squad.useRandomDeadTarget();
			targets.addNewZombie(target);
			logResurrection(getName(), target);
		}
		catch(NoDeadBodiesException e) {
			logFailedUndeadResurraction(getName());
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
}
