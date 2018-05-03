package warfake.war.abstraction;

import warfake.war.battlefield.Squad;

public interface Mage {
	void applyImprovement(Squad targets);
	void useMagic(Squad targets);
}
