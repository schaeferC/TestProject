package de.bht.BeuthOrg.objects;

import com.google.gson.annotations.SerializedName;

public class StundenPlan {
	private Modul[] modul;
	
	@SerializedName("StundenplanName")
	private String stundenPlanName;

	public Modul[] getModul() {
		return modul;
	}

	public String getStundenPlanName() {
		return stundenPlanName;
	}
	
	
}
