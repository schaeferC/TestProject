package de.bht.beuthorg.objects;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Java Objekt der Lehrkraftnews
 * @author Claudia
 *
 */
public class LehrkraftNews {

	/**
	 * Enthält die gesamten Lehrkraftnews
	 */
	private JSONArray news; 
	
	/**
	 * Konstruktor
	 * @param json
	 */
	public LehrkraftNews(JSONObject json){
		try {
			this.news = json.getJSONArray("Lehrkraftnews");

		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Gibt eine bestimmte LehrkraftNews zurück.
	 * @param key
	 * 		String, Schlüssel für die Nachricht.
	 * @return
	 */
	public String[] getLehrkraftnewsByKey(String key){
		for(int i = 0; i< news.length(); i++){
			//ArrayList<String> list = new
			JSONObject jsonobj = null;
			try {
				jsonobj = new JSONObject(news.getString(i));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(key.contains(jsonobj.getString("validTo")))
					return new String[]{jsonobj.getString("from"),jsonobj.getString("validTo"),jsonobj.getString("content")};
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
