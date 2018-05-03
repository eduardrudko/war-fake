package warfake.war.armory;

public enum UndeadWeapons {
	BONE_BOW(" shoots a spiky arrow in "),
	KNIFE(" stabs with a knife "),
	BONE_STUFF(" pokes with a stuff "),
	ROTTEN_FIST(" slams with a rotten arm ");
	
	private String weaponAction;
	
	private UndeadWeapons(String weaponAction) {
		this.weaponAction = weaponAction;
	}
	
	public String getWeaponAction() {
		return weaponAction;
	}

}
