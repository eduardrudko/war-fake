package warefake.helpers.markers;

@SuppressWarnings("serial")
public class NoImprovableTargets extends Exception {

	public NoImprovableTargets() {
		
	}
	
	public NoImprovableTargets(String message)	{
		super(message);
	}
}
