package de.bht.beuthorg.util.datahandler;

import java.util.ArrayList;

import org.json.JSONObject;

import android.util.Log;

import de.bht.beuthorg.util.BeuthOrgApplication;
import de.bht.beuthorg.util.DataSaver;
import de.bht.beuthorg.util.control.BeuthOrgControl;
import de.bht.beuthorg.util.objects.ModulOrd;
import de.bht.beuthorg.util.objects.ProfData;
import de.bht.beuthorg.util.objects.StudienDoku;

/**
 * Diese Klasse regelt den Zugriff zur FakeApi
 * 
 * @author Claudia
 * 
 */
public class DataHandler {

	/**
	 * Überprüfung auf gültigem Login. Überprüft ob die eingegebenen Daten
	 * vorhanden sind
	 * 
	 * @param matrikel
	 * @param pw
	 * @return
	 */
	static public boolean isRegistered(String matrikel, String pw) {
		JSONObject json = ReadData.LogIn(matrikel, pw);

		if (json.has("ErrorCode")) {
			return false;
		}
		BeuthOrgControl.getInstance().setRegistredStudent(json);
		ReadData.setMatrikelnr(BeuthOrgControl.getInstance()
				.getRegistredStudent().getMatrikelnr());
		return true;
	}

	/**
	 * Methode greift auf das ModulOrd-Objekt zu und entnimmt die benötigten
	 * Daten aus der Fake-Api in Form eines Strings
	 * 
	 * @param String
	 *            ,Name des Moduls
	 * @return
	 */
	static public String getModulDescription(String modulname) {
		JSONObject json = ReadData.getModulDescriptionByStudOrd(BeuthOrgControl
				.getInstance().getRegistredStudent().getStudienOrdnung(),
				modulname);
		Log.d("Debug", "ModulOrd: " + json.toString());
		ModulOrd modulOrd = new ModulOrd(json);
		BeuthOrgControl.getInstance().setModulOrd(modulOrd);
		return modulOrd.getModuldescriptionOrd();
	}

	/**
	 * Diese Methode gibt die URL der Profwebsite des profs mit Namen name
	 * zurück
	 * 
	 * @param String, Profname
	 * @return
	 */
	static public String getProfWebsite(String name) {
		JSONObject json = ReadData.getProfDataByProfname(name);
		ProfData profdata = new ProfData(json);
		return profdata.getWebsite();

	}

	/**
	 * @author Enis
	 * Methode greift auf das StudienDoku-Objekt zu und entnimmt die benötigten
	 * Daten aus der Fake-Api in Form einer ArrayList von String-Arrays
	 */
	static public ArrayList<String[]> getStudienDoku() {
		JSONObject json = ReadData.getStudienDoku();
		StudienDoku studienDoku = new StudienDoku(json);
		return studienDoku.getEntities();
	}
}
