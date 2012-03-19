package de.bht.beuthorganizer.objects;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StundenPlan {
	private Modul[] modul;

	private String stundenPlanName;

	public StundenPlan(JSONObject json) {
		super();
		try {
			JSONArray jsonArray = json.getJSONArray("Modul");
			this.modul = new Modul[jsonArray.length()];
			for (int i = 0; i < jsonArray.length(); i++) {
				this.modul[i] = new Modul(jsonArray.getJSONObject(i));
			}

			this.stundenPlanName = json.getString("StundenplanName");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Modul[] getModul() {
		return modul;
	}

	public String getStundenPlanName() {
		return stundenPlanName;
	}

	@Override
	public String toString() {
		return "StundenPlan [modul=" + Arrays.toString(modul)
				+ ", stundenPlanName=" + stundenPlanName + "]";
	}
	
	

}
