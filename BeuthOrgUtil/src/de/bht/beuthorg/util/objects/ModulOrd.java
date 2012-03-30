package de.bht.beuthorg.util.objects;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * Java Objekt der Module mit Modulordnung und -beschreibung
 * 
 * @author Claudia
 * 
 */
public class ModulOrd {
	/**
	 * Beschreibt die Ordnung des Moduls nach welcher Studienordnung dieses
	 * stattfindet
	 */
	private String modulNOrd;
	/**
	 * Beschreibung des Moduls
	 */
	private String moduldescriptionOrd;
	/**
	 * Name des Moduls
	 */
	private String modulNameOrd;

	/**
	 * Konstruktor
	 * 
	 * @param json
	 */
	public ModulOrd(JSONObject json) {
		String errorString = null;
		try {
			errorString = json.getString("ErrorCode");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (errorString.isEmpty()) {
			try {
				JSONObject obj = json.getJSONObject("ModulOrd");
				Log.d("Debug", "obj: " + obj.toString());
				this.modulNameOrd = obj.getString("ModulNameOrd");
				this.modulNOrd = obj.getString("ModulNOrd:");

				this.moduldescriptionOrd = obj
						.getString("ModulDescriptionOrd:");

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Log.w("ErrorCode", "ErrorMessage at ModulOrd: " + errorString);
		}
	}

	public String getModulNOrd() {
		return modulNOrd;
	}

	public String getModuldescriptionOrd() {
		return moduldescriptionOrd;
	}

	public String getModulNameOrd() {
		return modulNameOrd;
	}

}
