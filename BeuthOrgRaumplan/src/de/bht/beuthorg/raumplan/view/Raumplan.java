package de.bht.beuthorg.raumplan.view;

import de.bht.beuthorg.raumplan.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Dient der Darstellung des Raumplanes
 * 
 * @author Enis
 * 
 */
public class Raumplan extends Activity {

	/**
	 * Codes zur Identifizierung bzw. zum Aufruf der Activity
	 */
	public static final int RAUMPLAN_REQUEST_CODE = 523399;

	public static final int RAUMPLAN_SUCCESS_CODE = 8852;

	/**
	 * betroffenes Layout wird mit Hilfe von setContentView-Methode mit Activity
	 * verknüpft, um auf die XML-Komponenten zugreifen zu können.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.raumplan);
	}

	/**
	 * Methode sorgt dafür, dass beim Drücken der BACK-Taste des Smartphones die
	 * jeweilig vorherige Activity aufgerufen wird.
	 */
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
		setResult(Raumplan.RAUMPLAN_SUCCESS_CODE, intent);
		finish();
	}

}
