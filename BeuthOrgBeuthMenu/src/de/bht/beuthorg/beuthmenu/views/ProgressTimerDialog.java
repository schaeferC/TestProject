package de.bht.beuthorg.beuthmenu.views;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressTimerDialog {

	/**
	 * Timer und Logdauer werden auf Anfangswerte gesetzt 
	 */
	private static final int TIMER = 100;
	private static final int LOGTIME = 3000;

	
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
