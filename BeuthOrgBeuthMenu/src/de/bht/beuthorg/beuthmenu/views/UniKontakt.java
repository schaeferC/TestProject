package de.bht.beuthorg.beuthmenu.views;

import de.bht.beuthorg.beuthmenu.R;
import android.app.Activity;
import android.os.Bundle;


public class UniKontakt extends Activity {
	
	/** Codes zur Identifizierung bzw. zum Aufruf der Activity */
	
	public static final int UNIKONTAKT_REQUEST_CODE = 143821050;

	public static final int UNIKONTAKT_SUCCESS_CODE = 18;
	
	/** 
	 * betroffenes Layout wird mit Hilfe von setContentView-Methode mit Activity verknüpft, 
	 * um auf die XML-Komponenten zugreifen zu können.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.unikontakt);
		
		
	}
	
	
}
