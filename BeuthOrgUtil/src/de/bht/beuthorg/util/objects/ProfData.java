package de.bht.beuthorg.util.objects;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * Java Objekt für die Daten die zu einem Prof gehören
 * 
 * @author Claudia
 * 
 */
public class ProfData {

	/**
	 * Name des Profs
	 */
	private String profName;
	/**
	 * Website des Profs
	 */
	private String website;

	public ProfData(JSONObject json) {
		String errorString = null;
		try {
			errorString = json.getString("ErrorCode");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (errorString.isEmpty()) {
			try {
				JSONObject obj = json.getJSONObject("ProfData");
				Log.d("Debug", "obj: " + obj.toString());
				this.website = obj.getString("Website");
				this.profName = obj.getString("ProfName");

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Log.w("ErrorCode", "ErrorMessage at ProfData: " + errorString);
		}

	}

	public String getProfName() {
		return profName;
	}

	public String getWebsite() {
		return website;
	}

}
