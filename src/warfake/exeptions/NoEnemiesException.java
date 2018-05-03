package warfake.exeptions;

@SuppressWarnings("serial")
public class NoEnemiesException extends Exception {
	
	public NoEnemiesException() {
		
	}
	
	public NoEnemiesException(String message) {
		super(message);
	}

}
