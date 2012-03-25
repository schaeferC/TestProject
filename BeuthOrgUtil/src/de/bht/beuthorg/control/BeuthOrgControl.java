package de.bht.beuthorg.control;

import org.json.JSONObject;

import de.bht.beuthorg.objects.ModulOrd;
import de.bht.beuthorg.objects.Student;

/**
 * Diese Klasse dient als Control-Klasse um bestimmte Inhalte zu setzen und
 * verteilen. Aufbau als Singleton,
 * 
 * @author Claudia
 * 
 */
public class BeuthOrgControl {

	/**
	 * Instanz der Klasse
	 */
	private static BeuthOrgControl instance = null;
	/**
	 * der aktuell registrierte Student
	 */
	private Student registredStudent;
	/**
	 * aktuelle modulOrdnung
	 */
	private ModulOrd modulOrd;

	/**
	 * Privater Konstruktor
	 */
	private BeuthOrgControl() {

	}

	/**
	 * Typisch für einen Singleton . Damit die Methoden nicht gleichzeitig
	 * aufgerufen werden können wird diese Methode gebraucht zum Aufruf und
	 * regelt das synchronisiert.
	 * 
	 * @return
	 */
	public synchronized static BeuthOrgControl getInstance() {
		if (instance == null) {
			instance = new BeuthOrgControl();
		}
		return instance;
	}

	public Student getRegistredStudent() {
		return registredStudent;
	}

	public void setRegistredStudent(JSONObject registredStudent) {
		this.registredStudent = new Student(registredStudent);
	}

	public ModulOrd getModulOrd() {
		return modulOrd;
	}

	public void setModulOrd(ModulOrd modulOrd) {
		this.modulOrd = modulOrd;
	}

}
