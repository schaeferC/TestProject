package de.bht.beuthorg.moduldescription.view;
import de.bht.beuthorg.datahandler.DataHandler;
import de.bht.beuthorg.moduldescription.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class Modulbeschreibung extends Activity {

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

}
