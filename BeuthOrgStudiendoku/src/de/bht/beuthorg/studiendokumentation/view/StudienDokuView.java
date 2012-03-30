package de.bht.beuthorg.studiendokumentation.view;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ListView;
import de.bht.beuthorg.studiendokumentation.ArrayAdapterStudiendoku;
import de.bht.beuthorg.studiendokumentation.R;
import de.bht.beuthorg.util.datahandler.DataHandler;

/**
 * Darstellungsactivity der Studiendokumentation eines registrierten Studenten
 * 
 * @author Enis, Claudia
 * 
 */
public class StudienDokuView extends Activity {

	/** Codes zur Identifizierung bzw. zum Aufruf der Activity */
	public static final int STUDIENDOKU_REQUEST_CODE = 123329998;

	public static final int STUDIENDOKU_SUCCESS_CODE = 20;

	/**
	 * XML-Komponenten als Variablen vereinbaren
	 */
	private ListView studiendokulist;

	/**
	 * betroffenes Layout wird mit Hilfe von setContentView-Methode mit Activity
	 * verknüpft, um auf die XML-Komponenten zugreifen zu können.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studiendoku);
		studiendokulist = (ListView) findViewById(R.id.studiendokuList);

		/**
		 * ArrayList wird mit Inhalt der Studiendoku aus der Fake-Api gefüllt
		 */
		ArrayList<String[]> contentsStudienDoku = DataHandler.getStudienDoku();
		String[] doku = new String[contentsStudienDoku.size()];
		for (int i = 0; i < contentsStudienDoku.size(); i++) {
			for (String s : contentsStudienDoku.get(i)) {
				Log.w("Debug", "StudiendokuView: " + s);
			}
			String[] temp = contentsStudienDoku.get(i);
			// doku[i-1] = new String("Modul: "+ temp[5]);
			doku[i] = new String("Modul: " + temp[5]
					+ "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;"
					+ temp[3] + " Credits|" + "Lehrkraft: " + temp[1]
					+ "<br>Note:  " + temp[2] + "<br>Belegung: " + temp[4]);
		}
		ArrayAdapterStudiendoku adapter = new ArrayAdapterStudiendoku(this,
				R.layout.list_item_doku, doku);

		studiendokulist.setAdapter(adapter);
		studiendokulist.setCacheColorHint(Color.TRANSPARENT);

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
		setResult(StudienDokuView.STUDIENDOKU_SUCCESS_CODE, intent);
		finish();
	}

}
