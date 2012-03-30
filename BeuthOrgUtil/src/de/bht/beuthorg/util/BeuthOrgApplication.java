package de.bht.beuthorg.util;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Diese Klasse ist als Singleton aufgebaut und dient der gesamten Klassen um
 * �berall den root Context zu �bermittel
 * 
 * @author Claudia
 * 
 */
public class BeuthOrgApplication extends Application {

	private static BeuthOrgApplication application;

	@Override
	public void onCreate() {
		super.onCreate();
		application = this;
		Log.w("Debug", "Application started");
	}

	/**
	 * Hier wird der Context zur�ckgegeben.
	 * 
	 * @return
	 */
	public static Context getAppContext() {
		if (application.getApplicationContext() != null) {
			Log.w("Debug", "ApplicationContext exists");
		}
		return application.getApplicationContext();
	}
}
