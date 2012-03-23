package de.bht.beuthorg.datahandler;

import org.json.JSONObject;

import android.util.Log;


import de.bht.beuthorg.objects.Student;

public class DataHandler {

	private Student student;
	
	static public boolean isRegistered(String matrikel, String pw){
		JSONObject json= ReadData.LogIn(matrikel, pw);
		Student student= new Student(json);
		
		if(student!=null){
			Log.d("DEBUG", student.toString());
			return true;
		}
//        Gson gson = new Gson();
//        gson.fromJson(reader, Student.class);
//		student = ReadData.LogIn(matrikel, pw);
		return false;
	}
	
}
