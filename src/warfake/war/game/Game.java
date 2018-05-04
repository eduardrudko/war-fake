package warfake.war.game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import warfake.war.battlefield.ElfSquadFactory;
import warfake.war.battlefield.HumanSquadFactory;
import warfake.war.battlefield.OrcSquadFactory;
import warfake.war.battlefield.Squad;
import warfake.war.battlefield.UndeadSquadFactory;

/**
 * The main Game entry point
 *
 * @author Eduard Rudko
 * @version 1.0
 * @since 03-05-2018
 */
public class Game {

	public static void main(String[] args) {
		Game game = new Game();
		System.out.println("Let the game begin!");
		logs.append("Let the game begin!\n");
		System.out.println("******************************************");
		System.out.println();
		game.spawnSquads();
		System.out.println();
		System.out.println("******************************************");
		System.out.println();
		game.beginWar(aliance, horde);
	}

	private static final short NUMBER_OF_ALIANCE_SQUADS = 2;
	private static final short NUMBER_OF_HORDE_SQUADS = 2;
	private static Random random = new Random();
	public static StringBuilder logs = new StringBuilder("");
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

	/**
	 * This method randomly generates 2 squads of representatives of particular race
	 */
	private void spawnSquads() {
		switch (random.nextInt(NUMBER_OF_ALIANCE_SQUADS) + 1) {
		case 1:
			System.out.print("Elfs fight against");
			logs.append("Elfs fight against");
			aliance = ElfSquadFactory.generateElfSquad();
			break;
		case 2:
			System.out.print("Humans fight against");
			logs.append("Human fight against");
			aliance = HumanSquadFactory.generateHumanSquad();
			break;
		}
		switch (random.nextInt(NUMBER_OF_HORDE_SQUADS) + 1) {
		case 1:
			System.out.println(" Orcs!");
			logs.append(" Orcs!\n");
			horde = OrcSquadFactory.generateOrcSquad();
			break;
		case 2:
			System.out.println(" Undeads!");
			logs.append(" Undeads!\n");
			horde = UndeadSquadFactory.generateUndeadSquad();
			break;
		}
	}

	/**
	 * The main method that starts the process of game prototype
	 * 
	 * @param aliance
	 *            the first side of the conflict
	 * @param horde
	 *            the second side of the conflict
	 */
	private void beginWar(Squad aliance, Squad horde) {
		do {
			Squad.performActions(aliance, horde);
		} while (gameProcess);
	}

	/**
	 * Method createResults creates the .txt file which contains all the logs were
	 * produced during game process
	 */
	public static void createResults() {
		File results = new File("results.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(results))) {
			bw.write(logs.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
