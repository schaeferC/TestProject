package de.bht.beuthorg.util;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class BeuthOrgApplication extends Application {

	private static BeuthOrgApplication application;

	@Override
	public void onCreate() {
		super.onCreate();
		application = this;
		Log.w("Debug", "Application started");
	}

	public static Context getAppContext() {
		if (application.getApplicationContext() != null) {
			Log.w("Debug", "ApplicationContext exists");
		}
		return application.getApplicationContext();
	}
}
