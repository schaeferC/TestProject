package de.bht.beuthorg.raumplan.view;

import de.bht.beuthorg.raumplan.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;


public class Raumplan extends Activity {

	public static final int RAUMPLAN_REQUEST_CODE = 523399;

	public static final int RAUMPLAN_SUCCESS_CODE = 8852;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.raumplan);
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
		setResult(Raumplan.RAUMPLAN_SUCCESS_CODE, intent);
		finish();
	}

}
