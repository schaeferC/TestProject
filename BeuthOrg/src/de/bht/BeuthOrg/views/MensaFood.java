package de.bht.BeuthOrg.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import de.bht.BeuthOrg.R;
import de.bht.BeuthOrg.util.MensaArrayAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MensaFood extends Activity {

	private static final String TOMORRO_LINK = "http://www.studentenwerk-berlin.de/mensen/speiseplan/beuth/01.html";
	private static final String TODAY_LINK = "http://www.studentenwerk-berlin.de/mensen/speiseplan/beuth/index.html";
	
	ListView mealList;
	Button dayB;
	String day;
	Bundle savedInstanceState;
	String bottomContents;
	TextView bottomContentsView;

	private OnClickListener onClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == dayB) {

				changeDay();
			}

		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mensafood);
		this.savedInstanceState = savedInstanceState;

		mealList = (ListView) findViewById(R.id.list);
		dayB = (Button) findViewById(R.id.dayB);
		bottomContentsView = (TextView) findViewById(R.id.bottomContent);
		
		if (day != null) {
			if (day.contains("today")) {
				day = new String("tomorrow");
				dayB.setText("heute");
			} else {
				day = new String("today");
				dayB.setText("morgen");
			}
		} else {
			day = new String("today");
			dayB.setText("morgen");
		}
		dayB.setOnClickListener(onClick);

		String[] siteContents = setContents();
		bottomContentsView.setText(bottomContents);
		MensaArrayAdapter adapter = new MensaArrayAdapter(this,
				R.layout.list_item, siteContents, getResources());

		mealList.setAdapter(adapter);
		mealList.setCacheColorHint(Color.TRANSPARENT);

	}

	private String[] setContents() {
		String url;

		if (day.contains("today")) {
			url = new String(TODAY_LINK);
		} else {
			url = new String(TOMORRO_LINK);
		}

		HttpClient hc = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);

		try {
			HttpResponse r = hc.execute(get);

			BufferedReader br = new BufferedReader(new InputStreamReader(r
					.getEntity().getContent()));

			String temp = br.readLine();

			String siteInformation = new String("");
			while (temp != null) {

				siteInformation = siteInformation.concat(temp + " ");
				temp = br.readLine();
			}

			siteInformation = siteInformation.substring(
					siteInformation.indexOf("<div class=\"mensa_day\">"),
					siteInformation.lastIndexOf("<style type=\"text/css\">"));

			siteInformation = siteInformation.replaceAll("[^\\S]+\\s[^\\S]+",
					"");
			siteInformation = siteInformation.replaceAll("<.*?>", "|");
			siteInformation = siteInformation.replaceAll("\t{1,}", "\n");
			siteInformation = siteInformation.replaceAll("\\|{3,}", "\n");
			bottomContents = siteInformation.substring(siteInformation.indexOf("Kennzeichnung"));

			return siteInformation.split("\n");

		} catch (ClientProtocolException e1) {

			e1.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return new String[] { "leer" };
	}

	private void changeDay() {

		this.onCreate(savedInstanceState);
	}
}
