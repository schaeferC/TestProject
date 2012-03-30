package de.bht.beuthorg.beuthmenu.views;

import de.bht.beuthorg.beuthmenu.R;
import android.app.Activity;
import android.os.Bundle;

/**
 * Activity für die Darstellung der Info-Seite des Uni-Bereichs
 * 
 * @author Enis Gürmen
 * 
 */
public class UniInfo extends Activity {
	
	/** Codes zur Identifizierung bzw. zum Aufruf der Activity */
	
	public static final int UNIINFO_REQUEST_CODE = 123821050;

	public static final int UNIINFO_SUCCESS_CODE = 17;
	
	/** 
	 * betroffenes Layout wird mit Hilfe von setContentView-Methode mit Activity verknüpft, 
	 * um auf die XML-Komponenten zugreifen zu können.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.uniinfo);
		
		
	}
	
	
}
