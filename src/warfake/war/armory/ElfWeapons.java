package warfake.war.armory;

public enum ElfWeapons {
	ELVEN_BOW(" shoots a poisonous arrow in "),
	ELVEN_DAGGER(" stabs with an elven dagger "),
	ELVEN_LONGSWORD(" strikes with an elven longsword ");
	
	private String weaponAction;
	
	private ElfWeapons(String weaponAction) {
		this.weaponAction = weaponAction;
	}
	
	public String getWeaponAction() {
		return weaponAction;
	}
}
