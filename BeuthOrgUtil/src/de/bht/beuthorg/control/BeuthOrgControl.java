package de.bht.beuthorg.control;

import org.json.JSONObject;

import de.bht.beuthorg.objects.ModulOrd;
import de.bht.beuthorg.objects.Student;

public class BeuthOrgControl {
	
	private static BeuthOrgControl instance= null;
	private Student registredStudent;
	private ModulOrd modulOrd;
	private BeuthOrgControl(){
		
	}
	public synchronized static BeuthOrgControl getInstance(){
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
