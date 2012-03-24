package de.bht.beuthorg.datahandler;

import org.json.JSONObject;

import android.util.Log;


import de.bht.beuthorg.objects.Student;

public class DataHandler {

	private Student student;
	
	static public boolean isRegistered(String matrikel, String pw){
		JSONObject json= ReadData.LogIn(matrikel, pw);
		
		if(json.has("ErrorCode")){
			return false;
		}
		return true;
	}
	
}
