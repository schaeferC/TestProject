package de.bht.beuthorg.menu.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.bht.beuthorg.menu.R;
import de.bht.beuthorg.util.BeuthOrgApplication;

public class BeuthMenu extends Activity {
	

	/**
	 * The used Buttons. Initialization in {@link onClick}
	 */
	private Button uniB;
	private Button fb6B;
	private Button ichB;
	private Button mensaB;

	/**
	 * OnClickListener to handle the on Click event
	 */
	private OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == uniB) {
				finish();
				startActivity(new Intent(BeuthOrgApplication.getAppContext(), AllgemeinUni.class));
			} else if (v == fb6B) {

			} else if (v == ichB) {

			} else if (v == mensaB) {
				finish();
				startActivity(new Intent(BeuthOrgApplication.getAppContext(), MensaSelected.class));
			}

		}
	};

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		uniB = (Button) findViewById(R.id.uniB);
		uniB.setOnClickListener(ocl);

		fb6B = (Button) findViewById(R.id.fb6B);
		fb6B.setOnClickListener(ocl);

		ichB = (Button) findViewById(R.id.ichB);
		ichB.setOnClickListener(ocl);

		mensaB = (Button) findViewById(R.id.mensaB);
		mensaB.setOnClickListener(ocl);

	}
	
}