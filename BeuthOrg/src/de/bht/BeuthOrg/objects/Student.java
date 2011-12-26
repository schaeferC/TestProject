package de.bht.BeuthOrg.objects;

import com.google.gson.annotations.SerializedName;

public class Student {
	@SerializedName("StudienOrdnung")
	private String studienOrdnung;
	
	@SerializedName("Name")
	private String name;

	@SerializedName("Fachbereich")
	private String fb;
	
	@SerializedName("Semester")
	private String semester;
	
	@SerializedName("Matrikelnr")
	private String matrikelnr;
	
	@SerializedName("FirstName")
	private String firstName;
	
	private StundenPlan stundenplan;
	
	@SerializedName("DegreeCourse")
	private String degreeCourse;

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
	
	





}
