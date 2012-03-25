package de.bht.beuthorg.objects;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Java Objekt eines Studenten
 * @author Claudia
 *
 */
public class Student {
	/**
	 * Studienordnung nach der ein Student studiert,
	 */
	private String studienOrdnung;

	/**
	 * Name des Studenten
	 */
	private String name;

	/**
	 * Der Fachbereich zu dem der Student gehört
	 */
	private String fb;

	/**
	 * Semester in dem der Student sich befindet
	 */
	private String semester;

	/**
	 * Matrikelnummer des Studenten
	 */
	private String matrikelnr;

	/**
	 * Vorname des Studenten
	 */
	private String firstName;

	/**
	 * Aktueller Stundenplan des Studenten
	 */
	private StundenPlan stundenplan;

	/**
	 * Studienfach des Studenten
	 */
	private String degreeCourse;

	/**
	 * Konstruktor
	 * @param json
	 */
	public Student(JSONObject json) {
		super();
		try {
			this.studienOrdnung = json.getString("StudienOrdnung");

			this.name = json.getString("Name");
			this.fb = json.getString("Fachbereich");
			this.semester = json.getString("Semester");
			this.matrikelnr = json.getString("Matrikelnr");
			this.firstName = json.getString("FirstName");
			this.stundenplan = new StundenPlan(
					json.getJSONObject("Stundenplan"));
			this.degreeCourse = json.getString("DegreeCourse");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getStudienOrdnung() {
		return studienOrdnung;
	}

	public String getName() {
		return name;
	}

	public String getFb() {
		return fb;
	}

	public String getSemester() {
		return semester;
	}

	public String getMatrikelnr() {
		return matrikelnr;
	}

	public String getFirstName() {
		return firstName;
	}

	public StundenPlan getStundenplan() {
		return stundenplan;
	}

	public String getDegreeCourse() {
		return degreeCourse;
	}

	@Override
	public String toString() {
		return "Student [studienOrdnung=" + studienOrdnung + ", name=" + name
				+ ", fb=" + fb + ", semester=" + semester + ", matrikelnr="
				+ matrikelnr + ", firstName=" + firstName + ", stundenplan="
				+ stundenplan + ", degreeCourse=" + degreeCourse + "]";
	}

	
}
