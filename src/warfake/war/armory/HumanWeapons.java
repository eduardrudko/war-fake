package warfake.war.armory;

public enum HumanWeapons {
	CROSSBOW(" shoots a sharp bolt in "),
	SWORD(" strikes with a sword "),
	BROADSWORD(" strikes with a broadsword "),
	FIREBALL(" casts a fireball in ");
	
	private String weaponAction;
	
	private HumanWeapons(String weaponAction) {
		this.weaponAction = weaponAction;
	}
	
	public String getWeaponAction() {
		return weaponAction;
	}
}
