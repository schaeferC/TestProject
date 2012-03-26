package de.bht.beuthorg.beuthmenu.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import de.bht.beuthorg.beuthmenu.R;
import de.bht.beuthorg.raumplan.view.Raumplan;
import de.bht.beuthorg.stundenplan.view.StundenplanView;
import de.bht.beuthorg.util.BeuthOrgApplication;


public class IchSelected extends Activity{
	
	/** Codes zur Identifizierung bzw. zum Aufruf der Activity */
	
	public static final int ICHSELECTED_REQUEST_CODE = 1233210998;

	public static final int ICHSELECTED_SUCCESS_CODE = 10;
	
	/** 
	 * XML-Komponenten als Variablen vereinbaren 
	 */
	private Button israumplanB;
	private Button isstudiendokuB;
	private Button isstundenplanB;
	private Button isbackB;
	private ImageView ichmenu;
	
	
	private OnClickListener ocl = new OnClickListener() {

		/**
		 *  if-Bedingungen sorgen für Fallunterscheidung wann welche Activity aufgerufen wird,
		 *  sobald auf ein bestimmten XML-Button geklickt wird. 
		 */
		@Override
		public void onClick(View v) {
			if (v == israumplanB) {
				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), Raumplan.class), Raumplan.RAUMPLAN_REQUEST_CODE);
			} else if (v == isstudiendokuB) {
				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), StudienDokuView.class), StudienDokuView.STUDIENDOKU_REQUEST_CODE);
			} else if (v == isstundenplanB) {
				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), StundenplanView.class), StundenplanView.STUNDENPLAN_REQUEST_CODE);
			} else if (v == isbackB) {
				returnToCallingActivity();
			}

		}
	};
	
	/** 
	 * betroffenes Layout wird mit Hilfe von setContentView-Methode mit Activity verknüpft, 
	 * um auf die XML-Komponenten zugreifen zu können.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ichmenu);
		
		/** 
		 * Variablen werden mit entsprechend vereinbarten ID's der XML-Komponenten versehen,
		 *  um diese jeweils zu verknüpfen  
		 */
		israumplanB = (Button)findViewById(R.id.israumplanB); 
		israumplanB.setOnClickListener(ocl);
		
		isstudiendokuB = (Button)findViewById(R.id.isstudiendokuB);
		isstudiendokuB.setOnClickListener(ocl);
		
		isstundenplanB = (Button)findViewById(R.id.isstundenplanB);
		isstundenplanB.setOnClickListener(ocl);
		
		isbackB = (Button)findViewById(R.id.isbackB);
		isbackB.setOnClickListener(ocl);
		
		ichmenu = (ImageView)findViewById(R.id.ichwabe);
		
		/** 
		 * Erstellen/Laden von Animationen 
		 */
        Animation aScale = AnimationUtils.loadAnimation(this,
				R.anim.menubuttonsscale);
        Animation aAlpha = AnimationUtils.loadAnimation(this,
				R.anim.menubuttonsalpha);
		Animation aRotate = AnimationUtils.loadAnimation(this, R.anim.menubuttonsrotate);
		AnimationSet set = new AnimationSet(false);
		set.addAnimation(aRotate);
		set.addAnimation(aAlpha);
		

		/** 
		 * XML-Komponenten mit Animationen versehen/verknüpfen
		 */
		ichmenu.startAnimation(aScale);
		isstundenplanB.startAnimation(set);
		israumplanB.startAnimation(set);
		isstudiendokuB.startAnimation(set);
		
	}
	
	/** 
	 * Methode sorgt dafür, dass beim Drücken der BACK-Taste des Smartphones
	 * die jeweilig vorherige Activity aufgerufen wird. 
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			returnToCallingActivity();
		}
		return true;
	}

	/**
	 * Beendet die aktuelle Activity und gibt der aufrufenden Activity den
	 * SuccessCode zurück
	 */
	protected void returnToCallingActivity() {
		Intent intent = new Intent();
		setResult(IchSelected.ICHSELECTED_SUCCESS_CODE, intent);
		finish();
	}


}
