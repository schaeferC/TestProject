package de.bht.beuthorg.mensafood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Diese Klasse besorgt die Inhalte für das MensaEssen von der mensa-website
 * 
 * @author Claudia
 * 
 */
public class HTTPContents {

	/**
	 * Link für den nächsten Tag
	 */
	private static final String MENSA_TOMORROW_LINK = "http://www.studentenwerk-berlin.de/mensen/speiseplan/beuth/01.html";
	/**
	 * Link für den aktuellen Tag
	 */
	private static final String MENSA_TODAY_LINK = "http://www.studentenwerk-berlin.de/mensen/speiseplan/beuth/index.html";
	/**
	 * Client um die Anfrage auf die Website auszufürhen
	 */
	private static HttpClient hc = new DefaultHttpClient();

	/**
	 * Diese Methode führt den Aufruf der Website aus und gibt den benötigten
	 * Content zurück
	 * 
	 * @param url
	 *            String, aufgerufene URL
	 * @return
	 */
	private static String getResponse(String url) {

		HttpGet get = new HttpGet(url);

		try {
			// Ausfüuhrung des Aufrufs, um Content zu erhalten
			HttpResponse r = hc.execute(get);
			// umwandeln des benötigten Contents, um diesen einzulesen
			InputStreamReader isr = new InputStreamReader(r.getEntity()
					.getContent());
			BufferedReader br = new BufferedReader(isr);
			// erste Zeile einlesen
			String temp = br.readLine();

			String siteInformation = new String("");
			while (temp != null) {

				siteInformation = siteInformation.concat(temp + " ");
				temp = br.readLine();
			}

			isr.close();
			br.close();
			return siteInformation;
		} catch (ClientProtocolException e1) {

			e1.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;

	}

	public static String mensaGetContents(String day) {

		String url;

		if (day.contains("today")) {
			url = new String(MENSA_TODAY_LINK);
		} else {
			url = new String(MENSA_TOMORROW_LINK);
		}

		String siteInformation = getResponse(url);
		if (siteInformation == null) {
			return new String("\n leer");
		}
		// rausscheißen der nicht benötigten Inhalte
		siteInformation = siteInformation.substring(
				siteInformation.indexOf("<div class=\"mensa_day\">"),
				siteInformation.lastIndexOf("<style type=\"text/css\">"));

		siteInformation = siteInformation.replaceAll("[^\\S]+\\s[^\\S]+", ""); // alle
																				// whitespaces
																				// ersetzen
																				// die
																				// nicht
																				// zwischen
																				// nicht-whitespaces
																				// stehen
		siteInformation = siteInformation.replaceAll("<.*?>", "|");// alle Tags
																	// entfernen
		siteInformation = siteInformation.replaceAll("\t{1,}", "\n"); // da wo
																		// mind.
																		// ein
																		// Tab
																		// ist
																		// einen
																		// Zeilenwechsel
																		// machen
		siteInformation = siteInformation.replaceAll("\\|{2,}[E]+[U]+[R]+",
				"\nEUR"); // wo mind. 2 | stehen und dahinter EUR mit
							// Zeilenwechsel und EUR ersetzen
		siteInformation = siteInformation.replaceAll("\\|{3,}", "\n");// wo
																		// mind.
																		// 3 |
																		// stehen
																		// Zeilenwechsel
																		// einsetzen

		return siteInformation;
	}
}
