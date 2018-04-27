package warfake.war.game;

import java.util.Random;

import warfake.war.battlefield.ElfSquad;
import warfake.war.battlefield.HumanSquad;
import warfake.war.battlefield.OrcSquad;
import warfake.war.battlefield.UndeadSquad;
import warfake.war.race.Elf;

public class Game {

	public static void main(String[] args) {
		Game game = new Game();
		game.spawnAlianceSquad();
		game.spawnHordeSquad();
		
	}

	private static final short NUMBER_OF_ALIANCE_SQUADS = 2;
	private static final short NUMBER_OF_HORDE_SQUADS = 2;
	private ElfSquad elfSquad;
	private HumanSquad humanSquad;
	private OrcSquad orcSquad;
	private UndeadSquad undeadSquad;

	public void spawnAlianceSquad() {
		Random random = new Random();
		switch (random.nextInt(NUMBER_OF_ALIANCE_SQUADS) + 1) {
		case 1:
			elfSquad = new ElfSquad();
			break;
		case 2:
			humanSquad = new HumanSquad();
			break;
		}
	}

	public void spawnHordeSquad() {
		Random random = new Random();
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