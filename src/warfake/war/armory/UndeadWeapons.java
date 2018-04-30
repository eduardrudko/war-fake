package warfake.war.armory;

public enum UndeadWeapons {
	BONE_BOW(" shoots a spiky arrow in "),
	KNIFE(" stabs with an knife ");
	
	private String weaponAction;
	
	private UndeadWeapons(String weaponAction) {
		this.weaponAction = weaponAction;
	}
	
	public String getWeaponAction() {
		return weaponAction;
	}

}
