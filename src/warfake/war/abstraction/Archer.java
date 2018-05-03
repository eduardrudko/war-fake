package warfake.war.abstraction;

import warfake.war.battlefield.Squad;

public interface Archer {
	void archeryShot(Squad targets);
	void meleeStab(Squad targets);
}
