package de.bht.BeuthOrg.views;

import de.bht.BeuthOrg.R;
import de.bht.BeuthOrg.util.Common;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Menu extends Activity {
	/** Called when the activity is first created. */

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
				startActivity(new Intent(v.getContext(), AllgemeinUni.class));
			} else if (v == fb6B) {

			} else if (v == ichB) {

			} else if (v == mensaB) {

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