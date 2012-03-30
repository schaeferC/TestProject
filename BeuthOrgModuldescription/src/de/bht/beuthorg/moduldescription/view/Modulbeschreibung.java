package de.bht.beuthorg.moduldescription.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import de.bht.beuthorg.moduldescription.R;
import de.bht.beuthorg.util.datahandler.DataHandler;

/**
 * Diese Klasse stellt die Activity der Modulbeschreibung dar
 * 
 * @author Claudia
 * 
 */
public class Modulbeschreibung extends Activity {

	/**
	 * Constante mit der die Activity aufgerufen wird
	 */
	public static final int MODULBESCHREIBUNG_REQUEST_CODE = 233321999;
	/**
	 * Result, dass die Activity zurückgibt nach erfolgreichem Abschluss
	 */
	public static final int MODULBESCHREIBUNG_SUCCESS_CODE = 234;

	/**
	 * View des Textes der Modulbeschreibung
	 */
	private TextView moduldescriptionView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modulbeschreibung);
		String intentExtra = getIntent().getStringExtra("modul");

		// Text zur Modulbeschreibung bekommen
		String descriptionText = DataHandler.getModulDescription(intentExtra
				.substring(0, intentExtra.indexOf("\n")));

		moduldescriptionView = (TextView) findViewById(R.id.modulbeschreibungTextView);
		moduldescriptionView.setText(descriptionText);
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
		setResult(Modulbeschreibung.MODULBESCHREIBUNG_SUCCESS_CODE, intent);
		finish();
	}

}
