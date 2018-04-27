package warfake.war.battlefield;

public abstract class Squad {
	private static final short NUMBER_OF_MAGES = 1;
	private static final short NUMBER_OF_ARCHERS = 3;
	private static final short NUMBER_OF_WARRIORS = 4;

	protected static short getNumberOfMages() {
		return NUMBER_OF_MAGES;
	}

	protected static short getNumberOfArchers() {
		return NUMBER_OF_ARCHERS;
	}

	protected static short getNumberOfWarriors() {
		return NUMBER_OF_WARRIORS;
	}
}
