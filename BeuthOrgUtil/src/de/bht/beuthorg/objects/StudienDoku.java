package de.bht.beuthorg.objects;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StudienDoku {

	private JSONArray sdoku;
	public ArrayList<String[]> entities;

	public StudienDoku(JSONObject json) {
		try {
			this.sdoku = json.getJSONArray("StudienDoku");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String[]> getEntities() {
		String[] temp = new String[6];
		for (int i = 0; i < sdoku.length(); i++) {

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

			entities.add(temp);
		}

		return entities;
	}

}
