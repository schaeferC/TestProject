package de.bht.beuthorg.beuthmenu.views;

import de.bht.beuthorg.beuthmenu.R;
import de.bht.beuthorg.util.BeuthOrgApplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Diese Klasse bildet die Darstellung des Hauptmenus im WithoutLogin-Bereich
 * 
 * @author Claudia
 * 
 */
public class WithoutLoginMenu extends Activity {

	/**
	 * The used Buttons. Initialization in {@link onClick}
	 */
	private Button uniWB;
	private Button fb6WB;
	private Button mensaWB;

	/**
	 * OnClickListener to handle the on Click event
	 */
	private OnClickListener ocl = new OnClickListener() {

		/**
		 * if-Bedingungen sorgen für Fallunterscheidung wann welche Activity
		 * aufgerufen wird, sobald auf ein bestimmten XML-Button geklickt wird.
		 */
		@Override
		public void onClick(View v) {
			if (v == uniWB) {
				startActivityForResult(
						new Intent(BeuthOrgApplication.getAppContext(),
								AllgemeinUni.class),
						AllgemeinUni.UNI_REQUEST_CODE);
			} else if (v == fb6WB) {
				startActivityForResult(
						new Intent(BeuthOrgApplication.getAppContext(),
								Fb6Selected.class),
						Fb6Selected.FB6SELECTED_REQUEST_CODE);
			} else if (v == mensaWB) {
				startActivityForResult(
						new Intent(BeuthOrgApplication.getAppContext(),
								MensaSelected.class),
						MensaSelected.MENSASELECTED_REQUEST_CODE);
			}

		}
	};

	/**
	 * betroffenes Layout wird mit Hilfe von setContentView-Methode mit Activity
	 * verknüpft, um auf die XML-Komponenten zugreifen zu können.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.withoutloginmenu);

		/**
		 * Variablen werden mit entsprechend vereinbarten ID's der
		 * XML-Komponenten versehen, um diese jeweils zu verknüpfen
		 */
		uniWB = (Button) findViewById(R.id.uniWB);
		uniWB.setOnClickListener(ocl);

		fb6WB = (Button) findViewById(R.id.fb6WB);
		fb6WB.setOnClickListener(ocl);

		mensaWB = (Button) findViewById(R.id.mensaWB);
		mensaWB.setOnClickListener(ocl);

	}
}
