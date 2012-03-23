package de.bht.beuthorg.objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Modul {

	private String teacher;
	private String room;
	private String time;
	private String modulName;
	private String day;
	private String gueltigNStudienOrdnung;

	public Modul(JSONObject json) {
		super();
		try {
			this.teacher = json.getString("Teacher");

			this.room = json.getString("Room");
			this.time = json.getString("Time");
			this.modulName = json.getString("ModulName");
			this.day = json.getString("Day");
			this.gueltigNStudienOrdnung = json
					.getString("GueltigNStudienOrdnung");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTeacher() {
		return teacher;
	}

	public String getRoom() {
		return room;
	}

	public String getTime() {
		return time;
	}

	public String getModulName() {
		return modulName;
	}

	public String getDay() {
		return day;
	}

	public String getGueltigNStudienOrdnung() {
		return gueltigNStudienOrdnung;
	}

	@Override
	public String toString() {
		return "Modul [teacher=" + teacher + ", room=" + room + ", time="
				+ time + ", modulName=" + modulName + ", day=" + day
				+ ", gueltigNStudienOrdnung=" + gueltigNStudienOrdnung + "]";
	}

	
}
