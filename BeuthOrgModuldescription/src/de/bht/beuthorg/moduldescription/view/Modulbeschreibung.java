package de.bht.beuthorg.moduldescription.view;
import de.bht.beuthorg.datahandler.DataHandler;
import de.bht.beuthorg.moduldescription.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;


public class Modulbeschreibung extends Activity {

	public static final int MODULBESCHREIBUNG_REQUEST_CODE = 233321999;

	public static final int MODULBESCHREIBUNG_SUCCESS_CODE = 234;
	
	private TextView moduldescriptionView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modulbeschreibung);
		String intentExtra=getIntent().getStringExtra("modul");
		Log.d("Debug","intentExtra at Modulbeschreibung "+ intentExtra.substring(0, intentExtra.indexOf("\n")));
		String descriptionText= DataHandler.getModulDescription(intentExtra.substring(0, intentExtra.indexOf("\n")));
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

	protected void returnToCallingActivity() {
		Intent intent = new Intent();
		setResult(Modulbeschreibung.MODULBESCHREIBUNG_SUCCESS_CODE, intent);
		finish();
	}

}
