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
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MensaFood extends Activity{
	
	TableLayout mealTab;
	TableRow salads;
	TextView saladsText;
	TableRow actionstand;
	TextView actionstandText;
	TableRow food;
	TextView foodText;
	TableRow foodfixings;
	TextView foodfixingsText;
	TableRow desserts;
	TextView dessertsText;
	TableRow tagging;
	TextView taggingText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensaessen);
        
        mealTab = (TableLayout) findViewById(R.id.mealtable);
        salads = (TableRow) findViewById(R.id.salads);
        saladsText = (TextView) findViewById(R.id.saladstext);
        
        actionstand = (TableRow) findViewById(R.id.actionstand);
        actionstandText = (TextView) findViewById(R.id.actionstandtext);
        
        food = (TableRow) findViewById(R.id.food);
        foodText = (TextView) findViewById(R.id.foodtext);
        
        foodfixings = (TableRow) findViewById(R.id.foodfixings);
        foodfixingsText = (TextView) findViewById(R.id.foodfixingstext);
        
        desserts = (TableRow) findViewById(R.id.desserts);
        dessertsText = (TextView) findViewById(R.id.dessertstext);
        
        tagging = (TableRow) findViewById(R.id.tagging);
        taggingText = (TextView) findViewById(R.id.taggingtext);
        
        setContents();
    }
    
    private void setContents(){
		String url = new String("http://www.studentenwerk-berlin.de/mensen/speiseplan/beuth/index.html");

		HttpClient hc = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		
		try {
			HttpResponse r = hc.execute(get);

			BufferedReader br = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));
			
			String temp = br.readLine();

			String siteInformation = new String("");
			while (temp != null) {

				siteInformation= siteInformation.concat(temp + " ");
				temp = br.readLine();
			}

			siteInformation = siteInformation.substring(siteInformation.indexOf("<div class=\"mensa_day\">"),siteInformation.lastIndexOf("<style type=\"text/css\">"));

			siteInformation = siteInformation.replaceAll("[^\\S]+\\s[^\\S]+", "");
			siteInformation = siteInformation.replaceAll("<.*?>","|");
			siteInformation = siteInformation.replaceAll("\\|{3,}", "\n");
			
			String[] siteContents=siteInformation.split("\n");
			
			for(String s: siteContents){
				if(s.contains("salate")){
					
				}
			}
//			System.out.println(s);
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			System.out.println("Fehler");
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Fehler");
			e.printStackTrace();
		}
    }
}
