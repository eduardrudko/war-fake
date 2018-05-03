package warfake.exeptions;

@SuppressWarnings("serial")
public class NoImprovableTargetsException extends Exception {

	public NoImprovableTargetsException() {
		
	}
	
	public NoImprovableTargetsException(String message)	{
		super(message);
	}
}
