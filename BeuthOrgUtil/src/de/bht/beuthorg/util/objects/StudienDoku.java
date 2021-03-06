package de.bht.beuthorg.util.objects;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * Java-Objekt einer Studiendoku
 * 
 * @author Enis G�rmen
 * 
 */
public class StudienDoku {

	/**
	 * Studiendoku als JSONArray
	 */
	private JSONArray sdoku;

	/**
	 * Inhalt der Studiendoku in Form einer ArrayList
	 */
	public ArrayList<String[]> entities;

	/**
	 * Initialisierung der ArrayList
	 */
	public StudienDoku(JSONObject json) {
		entities = new ArrayList<String[]>();
		try {
			this.sdoku = json.getJSONArray("StudienDoku");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Ordnet den Inhalt der Studiendoku den entsprechenden Tags zu
	 */
	public ArrayList<String[]> getEntities() {

		for (int i = 0; i < sdoku.length(); i++) {
			String[] temp = new String[6];
			try {
				temp[0] = sdoku.getJSONObject(i).getString("DokuVersuch");
				temp[1] = sdoku.getJSONObject(i).getString("DokuTeacher");
				temp[2] = sdoku.getJSONObject(i).getString("DokuNote");
				temp[3] = sdoku.getJSONObject(i).getString("DokuCredits");
				temp[4] = sdoku.getJSONObject(i).getString("DokuBelegung");
				temp[5] = sdoku.getJSONObject(i).getString("DokuModul");

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (String s : temp) {
				Log.w("Debug", "StudiendokuKlasse: " + s);
			}
			entities.add(temp);
		}

		return entities;
	}

}
