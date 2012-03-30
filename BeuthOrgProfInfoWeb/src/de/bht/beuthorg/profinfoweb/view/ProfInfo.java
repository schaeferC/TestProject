package de.bht.beuthorg.profinfoweb.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import de.bht.beuthorg.profinfoweb.R;
import de.bht.beuthorg.util.datahandler.DataHandler;

/**
 * Activity für die Darstellung der Website des Profs
 * 
 * @author Claudia
 * 
 */
public class ProfInfo extends Activity {

	/**
	 * Constante mit der die Activity aufgerufen wird
	 */
	public static final int PROFINFO_REQUEST_CODE = 321900;
	/**
	 * Result, dass die Activity zurückgibt nach erfolgreichem Abschluss
	 */
	public static final int PROFINFO_SUCCESS_CODE = 257;

	/**
	 * Objekt welches die Website anzeigt
	 */
	private WebView webview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// zugrundeliegendes Layout
		setContentView(de.bht.beuthorg.profinfoweb.R.layout.profinfo);

		// Zuweisung aus dem zugrundeliegendem Layout
		webview = (WebView) findViewById(R.id.webview);
		webview.getSettings().setJavaScriptEnabled(true);
		// get benötigte Inhalte für die URL
		String intentExtra = getIntent().getStringExtra("modul");
		String website = DataHandler.getProfWebsite(intentExtra
				.substring(intentExtra.lastIndexOf("\n") + 1));
		// Website aufrufen
		webview.loadUrl(website);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			returnToCallingActivity();
		}
		return true;
	}

	/**
	 * Beendet die aktuelle Activity und gibt der aufrufenden Activity den
	 * SuccessCode zurück
	 */
	protected void returnToCallingActivity() {
		Intent intent = new Intent();
		setResult(ProfInfo.PROFINFO_SUCCESS_CODE, intent);
		finish();
	}
}
