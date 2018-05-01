package warfake.war.game;

import java.util.Random;

import warfake.war.battlefield.ElfSquadFactory;
import warfake.war.battlefield.HumanSquadFactory;
import warfake.war.battlefield.OrcSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.battlefield.UndeadSquadFactory;

public class Game {

	public static void main(String[] args) {
		Game game = new Game();
		game.spawnSquads();
		System.out.println("[Move #" + ++numberOfTurns);
		Squad.performActions(aliance, horde);
		System.out.println("[Move #" + ++numberOfTurns);
		Squad.performActions(aliance, horde);
		System.out.println("[Move #" + ++numberOfTurns);
		Squad.performActions(aliance, horde);
		System.out.println("[Move #" + ++numberOfTurns);
		Squad.performActions(aliance, horde);
		System.out.println("[Move #" + ++numberOfTurns);
		Squad.performActions(aliance, horde);
		System.out.println("[Move #" + ++numberOfTurns);
		Squad.performActions(aliance, horde);
		System.out.println("[Move #" + ++numberOfTurns);
		Squad.performActions(aliance, horde);
		System.out.println("[Move #" + ++numberOfTurns);
		Squad.performActions(aliance, horde);
		System.out.println("[Move #" + ++numberOfTurns);
		Squad.performActions(aliance, horde);
		System.out.println("[Move #" + ++numberOfTurns);
		Squad.performActions(aliance, horde);
	}

	private static final short NUMBER_OF_ALIANCE_SQUADS = 1; // change after debug on 2
	private static final short NUMBER_OF_HORDE_SQUADS = 1; // change after debug on 2
	private static Random random = new Random();
	public static StringBuilder logs = new StringBuilder();
	public static int numberOfTurns = 0;
	private static Squad aliance;
	private static Squad horde;

	public Squad getAlianceSquad() {
		return aliance;
	}

	public Squad getHordeSquad() {
		return horde;
	}

	public void spawnSquads() {
		switch (random.nextInt(NUMBER_OF_ALIANCE_SQUADS) + 1) {
		case 1:
			aliance = ElfSquadFactory.generateElfSquad();
			break;
		case 2:
			aliance = HumanSquadFactory.generateHumanSquad();
			break;
		}
		switch (random.nextInt(NUMBER_OF_HORDE_SQUADS) + 1) {
		case 1:
			horde = OrcSquadFactory.generateOrcSquad();
			break;
		case 2:
			horde = UndeadSquadFactory.generateUndeadSquad();
			break;
		}
	}
	
	public void startGame(Squad aliance, Squad horde) {
		while (aliance.getNumberOfSoldiers(aliance) != 0 || horde.getNumberOfSoldiers(horde) != 0) {
			System.out.println("[Move #" + ++numberOfTurns);
			Squad.performActions(aliance, horde);
		}
	}
}
