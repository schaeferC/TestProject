package de.bht.beuthorg.profinfoweb.view;

import de.bht.beuthorg.datahandler.DataHandler;
import de.bht.beuthorg.profinfoweb.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class ProfInfo extends Activity {
	private WebView webview;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(de.bht.beuthorg.profinfoweb.R.layout.profinfo);
		webview = (WebView) findViewById(R.id.webview);
		webview.getSettings().setJavaScriptEnabled(true);
		String intentExtra = getIntent().getStringExtra("modul");
		Log.w("Dedug", "ProfInfo "+intentExtra.substring(intentExtra.lastIndexOf("\n")+1));
		String website = DataHandler.getProfWebsite(intentExtra.substring(intentExtra.lastIndexOf("\n")+1));
		webview.loadUrl(website);
	}

}
