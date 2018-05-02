package warefake.helpers.markers;

@SuppressWarnings("serial")
public class NoDeadBodiesException extends Exception {
	
	public NoDeadBodiesException()	{
		
	}
	
	public NoDeadBodiesException(String message) {
		super(message);
	}

}
