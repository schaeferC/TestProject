package de.bht.BeuthOrg.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HTTPContentsNews {

	private static final String LEHRKRAFTNEWS_LINK = "http://fb6.beuth-hochschule.de/lehrkraftnews/news/";
	private static final String LINK_FIRST = "http://fb6.beuth-hochschule.de";
	private static JSONArray jsonArray = new JSONArray();
	private static ArrayList<String> contentsNews = new ArrayList<String>();
	
	private static ArrayList<String> makeRequestForNews(String url) {
		HttpClient hc = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		try {
			HttpResponse r = hc.execute(get);
			InputStreamReader isr = new InputStreamReader(r
					.getEntity().getContent());
			BufferedReader br = new BufferedReader(isr);
	
			String test = br.readLine();
	
			ArrayList<String> s = new ArrayList<String>();
			while (test != null) {
	
				if (test.matches(".*?Ansehen.*?")) {
					s.add(test);
				}
	
				test = br.readLine();
	
			}
			isr.close();
			br.close();
			return s;
		} catch (ClientProtocolException e1) {
			System.out.println("Fehler");
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("Fehler");
			e.printStackTrace();
		}
		return null;
	}

	private static String makeRequestForNewsContents(String url) {
		HttpClient hc = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		try {
			HttpResponse r = hc.execute(get);
			InputStreamReader isr = new InputStreamReader(r
					.getEntity().getContent());
			BufferedReader br = new BufferedReader(isr);
	
			String test = br.readLine();
	
			String s = new String("");
			while (test != null) {
	
				if (test.contains("<table id=\"singleNews\">")) {
	
					while (true) {
						String temp = br.readLine();
						s = s.concat(temp + " ");
						if (temp.contains("</table>")) {
							return s;
						}
					}
	
				}
	
				test = br.readLine();
	
			}
			isr.close();
			br.close();
			return s;
		} catch (ClientProtocolException e1) {
			System.out.println("Fehler");
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("Fehler");
			e.printStackTrace();
		}
		return null;
	}

	private static Map<String, String> makeJSONObjectFromNews(String s) {
		
		s = s.replaceFirst(".*?<b>", "");
		s = s.replaceAll("[^\\S]+\\s[^\\S]+", "|");
		s = s.replaceAll("<br/>+", " ");
		s = s.replaceAll("<.*?>", "");
	
		String[] toJson = s.split("\\|{4,}");
	
		Map<String, String> map = new HashMap<String, String>();
		map.put("from", toJson[0].split("\\|+")[1]);
		map.put("validTo", toJson[1].split("\\|+")[1]);
		map.put("content", toJson[2].split("\\|+")[1]);
	
		return map;
	}

	public static ArrayList<String> getLehrkraftNews() {
		Map<String, String> map = new HashMap<String, String>();
		ArrayList<String> stringArray = makeRequestForNews(LEHRKRAFTNEWS_LINK);
		for (String link : stringArray) {
			link = link.replaceFirst(".*?<a.*?=\"", "");
			link = LINK_FIRST + link.replaceAll("\">.*", "");
			map = makeJSONObjectFromNews(makeRequestForNewsContents(link));
			jsonArray.put(map);
			contentsNews.add("Von: "+map.get("from")+ " G&Uumlltigkeit: "+map.get("validTo"));
			// System.out.println(link);
		}
		
		
		JSONObject obj = new JSONObject();
		try {
			obj = new JSONObject("{\"Lehrkraftnews\":" + jsonArray.toString() + "}");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return contentsNews;
	
	
	 }

}
