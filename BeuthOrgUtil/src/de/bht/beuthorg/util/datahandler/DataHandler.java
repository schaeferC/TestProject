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
 * @author Claudia
 *
 */
public class DataHandler {

	/**
<<<<<<< HEAD
	 * Überprüfung auf gültigem Login 
=======
	 * Überprüft ob die eingegebenen Daten vorhanden sind
	 * @param matrikel
	 * @param pw
	 * @return
>>>>>>> acc30d6431e8e0524a7306887c616b86ca93f1d3
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
<<<<<<< HEAD
	 * Methode greift auf das ModulOrd-Objekt zu und entnimmt
	 * die benötigten Daten aus der Fake-Api in Form eines Strings 
=======
	 * @param modulname
	 * @return
>>>>>>> acc30d6431e8e0524a7306887c616b86ca93f1d3
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

	static public String getProfWebsite(String name) {
		JSONObject json = ReadData.getProfDataByProfname(name);
		ProfData profdata = new ProfData(json);
		return profdata.getWebsite();

	}

	/**
	 * Methode greift auf das StudienDoku-Objekt zu und entnimmt
	 * die benötigten Daten aus der Fake-Api in Form einer ArrayList 
	 * von String-Arrays 
	 */
	static public ArrayList<String[]> getStudienDoku() {
		JSONObject json = ReadData.getStudienDoku();
		StudienDoku studienDoku = new StudienDoku(json);
		return studienDoku.getEntities();
	}
}
