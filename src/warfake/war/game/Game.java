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
		System.out.println("Let the game begin!");
		logs.append("Let the game begin!");
		System.out.println("************************");
		System.out.println();
		game.spawnSquads();
		System.out.println();
		System.out.println("************************");
		game.beginWar(aliance, horde);
	}

	private static final short NUMBER_OF_ALIANCE_SQUADS = 1; // change after debug on 2
	private static final short NUMBER_OF_HORDE_SQUADS = 1; // change after debug on 2
	private static Random random = new Random();
	public static StringBuilder logs = new StringBuilder();
	public static int numberOfTurns = 0;
	public static boolean gameProcess = true;
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
			System.out.print("Elfs fighting against");
			logs.append("Elfs fighting against");
			aliance = ElfSquadFactory.generateElfSquad();
			break;
		case 2:
			System.out.print("Humans againsts ");
			logs.append("Human againsts ");
			aliance = HumanSquadFactory.generateHumanSquad();
			break;
		}
		switch (random.nextInt(NUMBER_OF_HORDE_SQUADS) + 1) {
		case 1:
			System.out.println(" Orcs!");
			logs.append(" Orcs!");
			horde = OrcSquadFactory.generateOrcSquad();
			break;
		case 2:
			System.out.print(" Undeads!");
			logs.append(" Undeads!");
			horde = UndeadSquadFactory.generateUndeadSquad();
			break;
		}
	}

	public void beginWar(Squad aliance, Squad horde) {
		do {
			Squad.performActions(aliance, horde);
		} while (gameProcess);
	}
}
