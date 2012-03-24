package de.bht.beuthorg.datahandler;

import org.json.JSONObject;

import de.bht.beuthorg.control.BeuthOrgControl;

public class DataHandler {

	static public boolean isRegistered(String matrikel, String pw){
		JSONObject json= ReadData.LogIn(matrikel, pw);
		
		if(json.has("ErrorCode")){
			return false;
		}
		BeuthOrgControl.getInstance().setRegistredStudent(json);
		return true;
	}
	
}
