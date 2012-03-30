package de.bht.beuthorg.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import de.bht.beuthorg.R;
import de.bht.beuthorg.beuthmenu.views.BeuthMenu;
import de.bht.beuthorg.beuthmenu.views.WithoutLoginMenu;
import de.bht.beuthorg.util.BeuthOrgApplication;
import de.bht.beuthorg.util.datahandler.DataHandler;

/**
 * Diese Klasse stellt den Loginbereich da. Dazu gehört die auswahl mit oder
 * ohne Login und ein Popup zum Anmelden.
 * 
 * @author Claudia
 * 
 */
public class Login extends Activity implements OnClickListener {

	// Objekte vom MainMenu
	private Button login;
	private Button withoutLogin;

	// Objekte von LoginPopUp
	private TextView nameLabel;
	private TextView passphraseLabel;

	private EditText nameText;
	private EditText passphraseText;
	private PopupWindow puw;
	private View view;

	private Button cancel;
	private Button enterLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		login = (Button) findViewById(R.id.login);
		login.setOnClickListener(this);
		withoutLogin = (Button) findViewById(R.id.withoutLogin);
		withoutLogin.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		if (v == login) {
			DataHandler.isRegistered("000041", "1234");

			view = findViewById(R.id.loginPopUp);
			// Zum Laden und darstellen der LoginPopUpView
			LayoutInflater inflater = this.getLayoutInflater();
			View view = inflater.inflate(R.layout.loginpopup,
					(ViewGroup) findViewById(R.id.loginPopUp));

			nameLabel = (TextView) view.findViewById(R.id.nameLabel);
			passphraseLabel = (TextView) view
					.findViewById(R.id.passphraseLabel);
			nameText = (EditText) view.findViewById(R.id.nameTextField);
			passphraseText = (EditText) view
					.findViewById(R.id.passphraseTextField);

			cancel = (Button) view.findViewById(R.id.cancelLog);
			cancel.setOnClickListener(this);
			enterLogin = (Button) view.findViewById(R.id.EnterLog);
			enterLogin.setOnClickListener(this);

			puw = new PopupWindow(view, 500, 500, true);
			puw.showAtLocation(view, Gravity.CENTER, 0, 0);

		} else if (v == cancel) {
			// LoginPopUp schließen
			puw.dismiss();
		} else if (v == enterLogin) {
			// Überprüfen ob Person registriert mit Matrikelnr und Passwort
			boolean registered = DataHandler.isRegistered(nameText.getText()
					.toString(), passphraseText.getText().toString());
			if (registered) {

				startActivity(new Intent(BeuthOrgApplication.getAppContext(),
						BeuthMenu.class));
			} else {
				Toast.makeText(BeuthOrgApplication.getAppContext(),
						"Keine validen Daten vorhanden", Toast.LENGTH_LONG)
						.show();
			}

		} else if (v == withoutLogin) {
			startActivity(new Intent(BeuthOrgApplication.getAppContext(),
					WithoutLoginMenu.class));
		}

	}

}