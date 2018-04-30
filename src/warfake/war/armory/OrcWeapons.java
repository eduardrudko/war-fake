package warfake.war.armory;

public enum OrcWeapons {
	BOW(" shoots a fire arrow in "),
	AXE(" chops with an axe "),
	CLUB(" strikes with a club ");
	
	private String weaponAction;
	
	private OrcWeapons(String weaponAction) {
		this.weaponAction = weaponAction;
	}
	
	public String getWeaponAction() {
		return weaponAction;
	}
}
