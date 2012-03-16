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
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

public class MensaFood extends Activity{
	
	ListView mealList;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensafood);
        mealList = (ListView)findViewById(R.id.list);
        String[] siteContents=setContents();
        
        MensaArrayAdapter adapter=new MensaArrayAdapter(this, R.layout.list_item, siteContents, getResources());
        
        mealList.setAdapter(adapter);
        mealList.setCacheColorHint(Color.TRANSPARENT);

    }
    
    private String[] setContents(){
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
			siteInformation = siteInformation.replaceAll("\t{1,}", "\n");
			siteInformation = siteInformation.replaceAll("\\|{3,}", "\n");
			
			return siteInformation.split("\n");


			
		} catch (ClientProtocolException e1) {

			e1.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return new String[]{"leer"};
    }
}
