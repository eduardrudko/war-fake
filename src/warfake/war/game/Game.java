package warfake.war.game;

import java.util.Random;

import warfake.war.battlefield.ElfSquad;
import warfake.war.battlefield.HumanSquad;
import warfake.war.battlefield.OrcSquad;
import warfake.war.battlefield.UndeadSquad;

public class Game {

	public static void main(String[] args) {
		Game game = new Game();
		game.spawnSquads();

	}

	private static final short NUMBER_OF_ALIANCE_SQUADS = 2;
	private static final short NUMBER_OF_HORDE_SQUADS = 2;
	private static Random random = new Random();
	public static StringBuilder logs = new StringBuilder();
	public static int numberOfTurns = 0;
	private ElfSquad elfSquad;
	private HumanSquad humanSquad;
	private OrcSquad orcSquad;
	private UndeadSquad undeadSquad;

	public StringBuilder getStringBuilder() {
		return logs;
	}

	public void spawnSquads() {
		switch (random.nextInt(NUMBER_OF_ALIANCE_SQUADS) + 1) {
		case 1:
			elfSquad = new ElfSquad();
			break;
		case 2:
			humanSquad = new HumanSquad();
			break;
		}
		switch (random.nextInt(NUMBER_OF_HORDE_SQUADS) + 1) {
		case 1:
			orcSquad = new OrcSquad();
			break;
		case 2:
			undeadSquad = new UndeadSquad();
			break;
		}
	}
}
