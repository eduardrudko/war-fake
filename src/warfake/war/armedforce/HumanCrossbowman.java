package warfake.war.armedforce;

import warfake.war.battlefield.OrcSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.classes.and.races.Archer;
import warfake.war.classes.and.races.Person;
import warfake.war.game.Game;

public class HumanCrossbowman extends Person implements Archer {
	private static final float SHOT_POWER = 15;
	private static final float STRIKE_POWER = 5;
	
	public HumanCrossbowman() {
		setName("Human cross bow man");
	}
	
	@Override
	public void archeryShot(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = getRandomAccuracy();
		dealDamage(target, SHOT_POWER, accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " shoots a sharp bolt in ", target, SHOT_POWER, accuracy);
	}

	@Override
	public void meleeStab(Squad targets) {
		Person target = targets.getRandomTarget();
		Game.numberOfTurns++;
		int accuracy = 100;
		dealDamage(target, STRIKE_POWER,accuracy);
		logStrikeAction(Game.numberOfTurns, getName(), " strikes with a sword ", target, STRIKE_POWER, accuracy);
	}

	public static void main(String[] args) {
		Squad squad = OrcSquadFactory.generateOrcSquad();
		HumanCrossbowman human1 = new HumanCrossbowman();
		human1.archeryShot(squad);
		human1.archeryShot(squad);
		human1.archeryShot(squad);
		human1.meleeStab(squad);
		human1.meleeStab(squad);
		human1.meleeStab(squad);
		human1.meleeStab(squad);

	}

}
