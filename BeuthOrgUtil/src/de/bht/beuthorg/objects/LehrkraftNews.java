package de.bht.beuthorg.objects;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LehrkraftNews {

	private Map<String, String[]> map;
	public LehrkraftNews(JSONObject json){
		try {
			JSONArray news = json.getJSONArray("Lehrkraftnews");
			for(int i = 0; i< news.length(); i++){
				//ArrayList<String> list = new
				this.map.put(news.getString(2), new String[]{news.getString(0),news.getString(1)});
				
			}
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] getLehrkraftnewsByKey(String key){
		return map.get(key);
	}
}
