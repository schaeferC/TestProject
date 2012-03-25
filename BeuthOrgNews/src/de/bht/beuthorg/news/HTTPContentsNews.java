package de.bht.beuthorg.news;

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

import de.bht.beuthorg.util.BeuthOrgApplication;
import de.bht.beuthorg.util.DataSaver;

/**
 * Diese Klasse besorgt die Lehrkraftnews aus HTML-Websiten.
 * 
 * @author Claudia
 * 
 */
public class HTTPContentsNews {

	/**
	 * Website der Lehrkraftnews
	 */
	private static final String LEHRKRAFTNEWS_LINK = "http://fb6.beuth-hochschule.de/lehrkraftnews/news/";
	/**
	 * Erster Teil eines Links für den Aufruf der Website, die die gesammte
	 * Nachricht enthält
	 */
	private static final String LINK_FIRST = "http://fb6.beuth-hochschule.de";

	/**
	 * Objekt in dem die News gespeichert werden, um sie später als json-Datei
	 * zu speichern
	 */
	private static JSONArray jsonArray = new JSONArray();

	/**
	 * Enthält den Content der Lehrkraftnews
	 */
	private static ArrayList<String> contentsNews = new ArrayList<String>();
	/**
	 * Client um die Anfrage auf die Website auszufürhen
	 */
	private static HttpClient hc = new DefaultHttpClient();

	/**
	 * Hier wird die Lehrkraftnews Website aufgerufen in der sich alle news
	 * befinden. Da die News auf der Seite nicht vollständig sind, sondern um
	 * die vollständigen Nachrichten zu erhalten ein Link angegeben ist, werden
	 * diese für alle News extrahiert sodass, die gesamten <a>-tags
	 * zurückgegeben werden.
	 * 
	 * @param url
	 *            String, aufzurufene URL
	 * @return
	 */
	private static ArrayList<String> makeRequestForNews(String url) {

		HttpGet get = new HttpGet(url);
		try {
			// Ausführen des Seitenaufrufes um den Content zu erhalten
			HttpResponse r = hc.execute(get);
			// Umwandeln des benötigten Contents, um diesen einzulesen
			InputStreamReader isr = new InputStreamReader(r.getEntity()
					.getContent());
			BufferedReader br = new BufferedReader(isr);

			// einlesen der ersten Zeile
			String test = br.readLine();

			// ArrayList, welche später die Tags enthält
			ArrayList<String> s = new ArrayList<String>();

			// einlesen des gesamten Contents
			while (test != null) {

				if (test.matches(".*?Ansehen.*?")) {

					s.add(test);
				}

				test = br.readLine();

			}
			// Schließen der Reader
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

	/**
	 * In dieser Methode werden die benötigten Inhalte, der News Website
	 * eingelesen und zurückgegeben.
	 * 
	 * @param url
	 *            String, aufzurufene URL
	 * @return
	 */
	/**
	 * @param url
	 * @return
	 */
	private static String makeRequestForNewsContents(String url) {

		HttpGet get = new HttpGet(url);
		try {
			// ausfürhren des Websiteaufrufs um Content zu erhalten
			HttpResponse r = hc.execute(get);
			// Umwandeln des benötigten Contents um diesen einzulesen
			InputStreamReader isr = new InputStreamReader(r.getEntity()
					.getContent());
			BufferedReader br = new BufferedReader(isr);

			// eerste Zeile einlesen
			String test = br.readLine();

			// Enthält später den benötigten Content
			String s = new String("");
			while (test != null) {

				if (test.contains("<table id=\"singleNews\">")) {
					// es sollen nur Daten zurückgegeben werden die zw. den
					// jeweiligen Tags liegen, da nur diese die Nachricht/News
					// entahlten
					while (true) {

						String temp = br.readLine();
						s = s.concat(temp + " ");

						if (temp.contains("</table>")) {
							isr.close();
							br.close();
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

	/**
	 * Diese Methode generiert eine Map für ein JSONObject aus einem String welcher die News enthält
	 * @param s
	 * 		String, aus dem contents gelesen werden
	 * @return
	 */
	private static Map<String, String> makeJSONObjectFromNews(String s) {

		s = s.replaceFirst(".*?<b>", ""); // der erste Teil des Strings der entfernt werden kann
		s = s.replaceAll("[^\\S]+\\s[^\\S]+", "|"); //alle whitespaces ersetzen die nicht zwischen nicht-whitespaces stehen
		s = s.replaceAll("<br/>+", " "); //alle Linebreaks ersetzen mit Leerzeichen
		s = s.replaceAll("<.*?>", ""); // alle Tags entfernen
		s = s.replaceAll("\"", "'"); //alle Anfürhungszeichen mit  ' ersetzen

		String[] toJson = s.split("\\|{4,}"); // split bei mind. 4|

		Map<String, String> map = new HashMap<String, String>();
		// map befüllen mit den bestimmten teilen der Nachricht
		map.put("\"from\"", "\"" + toJson[0].split("\\|+")[1] + "\"");
		map.put("\"validTo\"", "\"" + toJson[1].split("\\|+")[1] + "\"");
		map.put("\"content\"", "\"" + toJson[2].split("\\|+")[1] + "\"");

		return map;
	}

	/**
	 * Diese Methode gibt je einen bestimmten Teil der News zurück
	 * @return
	 */
	public static ArrayList<String> getLehrkraftNews() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		// benötigten Teil des Links für News bekommen
		ArrayList<String> stringArray = makeRequestForNews(LEHRKRAFTNEWS_LINK);
		for (String link : stringArray) {
			link = link.replaceFirst(".*?<a.*?=\"", "");// alles bis " entfernen
			link = LINK_FIRST + link.replaceAll("\">.*", ""); // Ende der tags entfernen
			
			map = makeJSONObjectFromNews(makeRequestForNewsContents(link));
			
			//zum späterem speichern
			jsonArray.put(map);
			//für die Rückgabe
			contentsNews.add(map.get("\"validTo\""));
		}

		//Erzeugung des JSONObjects
		JSONObject obj = new JSONObject();
		try {
			obj = new JSONObject("{\"Lehrkraftnews\":" + jsonArray.toString()
					+ "}");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		//Speichern des JSONObjects in news.json
		DataSaver.writeData(BeuthOrgApplication.getAppContext(), "news.json",
				obj.toString());

		return contentsNews;

	}

}
