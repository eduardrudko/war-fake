package warfake.war.game;

import java.util.Random;

import warfake.war.battlefield.ElfSquad;
import warfake.war.battlefield.HumanSquad;
import warfake.war.battlefield.Squad;

public class Game {

	public static void main(String[] args) {
		Game game = new Game();
		game.spawnFirstSquad();
		game.spawnSecondSquad();

	}

	private static final short NUMBER_OF_ALIANCE_SQUADS = 2;
	private static final short NUMBER_OF_HORDE_SQUADS = 2;
	Squad aliance;
	Squad horde;

	public void spawnFirstSquad() {
		Random random = new Random();
		switch (random.nextInt(NUMBER_OF_ALIANCE_SQUADS) + 1) {
		case 1:
			aliance = new ElfSquad();
			break;
		case 2:
			aliance = new HumanSquad();
			break;
		}
	}

	public void spawnSecondSquad() {
		Random random = new Random();
		switch (random.nextInt(NUMBER_OF_HORDE_SQUADS) + 1) {
		case 1:
			horde = new ElfSquad();
			break;
		case 2:
			horde = new HumanSquad();
			break;
		}
	}
}
