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
import de.bht.beuthorg.beuthmenu.R;
import de.bht.beuthorg.news.view.News;
import de.bht.beuthorg.util.BeuthOrgApplication;

public class AllgemeinUni extends Activity{
   
	/**
	 * Codes zur Identifizierung bzw. zum Aufruf der Activity 
	 */
	public static final int UNI_REQUEST_CODE = 123321000;

	public static final int UNI_SUCCESS_CODE = 3;
	/** Called when the activity is first created. */
	
	/** 
	 * XML-Komponenten als Variablen vereinbaren 
	 */
	private Button aunewsB;
	private Button auinfoB;
	private Button aukontaktB;
	private Button aubackB;
	private Button ausurvivalB;
	
	private OnClickListener ocl = new OnClickListener() {

		/**
		 *  if-Bedingungen sorgen für Fallunterscheidung wann welche Activity aufgerufen wird,
		 *  sobald auf ein bestimmten XML-Button geklickt wird. 
		 */
		@Override
		public void onClick(View v) {
			if (v == aunewsB) {
				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), News.class), News.NEWS_REQUEST_CODE);
			} else if (v == auinfoB) {
				
				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), UniInfo.class), UniInfo.UNIINFO_REQUEST_CODE);
			} else if (v == aukontaktB) {
				
				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), UniKontakt.class), UniKontakt.UNIKONTAKT_REQUEST_CODE);
			} else if (v == aubackB) {
				returnToCallingActivity();
			}
			else if (v == ausurvivalB) {
				
				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), Survival.class), Survival.SURVIVAL_REQUEST_CODE);
			}
			

		}
	};
	
	/** 
	 * betroffenes Layout wird mit Hilfe von setContentView-Methode mit Activity verknüpft, 
	 * um auf die XML-Komponenten zugreifen zu können.
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unimenu);
        
        /** 
		 * Variablen werden mit entsprechend vereinbarten ID's der XML-Komponenten versehen,
		 *  um diese jeweils zu verknüpfen  
		 */
        aunewsB = (Button)findViewById(R.id.aunewsB);
        aunewsB.setOnClickListener(ocl);
        
        auinfoB = (Button)findViewById(R.id.auinfoB);
        auinfoB.setOnClickListener(ocl);
        
        aukontaktB = (Button)findViewById(R.id.aukonB);
        aukontaktB.setOnClickListener(ocl);
        
        aubackB = (Button)findViewById(R.id.aubackB);
        aubackB.setOnClickListener(ocl);
        
        ausurvivalB = (Button)findViewById(R.id.ausurvivalB);
        ausurvivalB.setOnClickListener(ocl);
        
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
		aukontaktB.startAnimation(set);
		aunewsB.startAnimation(set);
		auinfoB.startAnimation(set);
		ausurvivalB.startAnimation(set);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
	@Override
	public void onBackPressed() {
		finishActivity(this.getTaskId());
		super.onBackPressed();
		
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
		setResult(AllgemeinUni.UNI_SUCCESS_CODE, intent);
		finish();
	}

}