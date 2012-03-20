package de.bht.beuthorg.mensafood;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HTTPContents {

	private static final String MENSA_TOMORRO_LINK = "http://www.studentenwerk-berlin.de/mensen/speiseplan/beuth/01.html";
	private static final String MENSA_TODAY_LINK = "http://www.studentenwerk-berlin.de/mensen/speiseplan/beuth/index.html";
	private static HttpClient hc = new DefaultHttpClient();
	private static String getResponse(String url) {

		
		HttpGet get = new HttpGet(url);

		try {
			HttpResponse r = hc.execute(get);
			InputStreamReader isr = new InputStreamReader(r.getEntity()
					.getContent());
			BufferedReader br = new BufferedReader(isr);

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
			url = new String(MENSA_TOMORRO_LINK);
		}

		String siteInformation = getResponse(url);
		if (siteInformation == null) {
			return new String("\n leer");
		}
		siteInformation = siteInformation.substring(
				siteInformation.indexOf("<div class=\"mensa_day\">"),
				siteInformation.lastIndexOf("<style type=\"text/css\">"));

		siteInformation = siteInformation.replaceAll("[^\\S]+\\s[^\\S]+", "");
		siteInformation = siteInformation.replaceAll("<.*?>", "|");
		siteInformation = siteInformation.replaceAll("\t{1,}", "\n");
		siteInformation = siteInformation.replaceAll("\\|{2,}[E]+[U]+[R]+",
				"\nEUR");
		siteInformation = siteInformation.replaceAll("\\|{3,}", "\n");

		return siteInformation;
	}
}
