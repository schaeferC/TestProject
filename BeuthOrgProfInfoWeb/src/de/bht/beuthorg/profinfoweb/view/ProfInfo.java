package de.bht.beuthorg.profinfoweb.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import de.bht.beuthorg.datahandler.DataHandler;
import de.bht.beuthorg.profinfoweb.R;

public class ProfInfo extends Activity {
	
	public static final int PROFINFO_REQUEST_CODE = 321900;

	public static final int PROFINFO_SUCCESS_CODE = 257;
	
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

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			returnToCallingActivity();
		}
		return true;
	}

	protected void returnToCallingActivity() {
		Intent intent = new Intent();
		setResult(ProfInfo.PROFINFO_SUCCESS_CODE, intent);
		finish();
	}
}
