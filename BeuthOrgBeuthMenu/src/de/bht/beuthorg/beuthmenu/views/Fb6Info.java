package de.bht.beuthorg.beuthmenu.views;

import de.bht.beuthorg.beuthmenu.R;
import android.app.Activity;
import android.os.Bundle;

/**
 * Activity f�r die Darstellung der Info-Seite vom Fachbereich 6
 * 
 * @author Enis G�rmen
 * 
 */
public class Fb6Info extends Activity {
	
	/** Codes zur Identifizierung bzw. zum Aufruf der Activity */
	
	public static final int FB6INFO_REQUEST_CODE = 123821750;

	public static final int FB6INFO_SUCCESS_CODE = 19;
	
	
	/** jeweiliges Layout XML wird mit der Activity verkn�pft */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fb6info);
		
		
	}
}
