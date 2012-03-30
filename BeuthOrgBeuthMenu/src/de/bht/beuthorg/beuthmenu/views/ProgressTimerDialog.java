package de.bht.beuthorg.beuthmenu.views;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Diese Klasse bildet eine eigene Implementierung des ProgressDialogs. Wenn
 * Inhalte länger zum Laden brauchen wird diese Klasse aufgerufen.
 * 
 * @author Claudia
 * 
 */
public class ProgressTimerDialog {

	/**
	 * Timer und Logdauer werden auf Anfangswerte gesetzt
	 */
	private static final int TIMER = 100;
	private static final int LOGTIME = 3000;

	/**
	 * Diese Methode bildet die Basis des Dialoges. Hier werden Dauer der
	 * Ansicht sowie die Message gesetzt.
	 * 
	 * @param context
	 *            Context, in welchem Zusammenhang
	 * @param message
	 *            String, was als Text auf dem Dialog erscheinen soll
	 */
	public static void run(Context context, String message) {
		final ProgressDialog pd = new ProgressDialog(context);
		pd.setMessage(message);
		pd.show();
		Thread logThread = new Thread() {
			@Override
			public void run() {

				try {
					int waited = 0;
					while (waited < LOGTIME) {
						sleep(TIMER);
						waited += TIMER;
					}
					pd.cancel();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		logThread.start();
	}

}
