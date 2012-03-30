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
import de.bht.beuthorg.mensafood.view.MensaFood;
import de.bht.beuthorg.util.BeuthOrgApplication;

/**
 * Diese Activity dient der Darstellung des Mensa-Bereiches.
 * 
 * @author Claudia
 * 
 */
public class MensaSelected extends Activity {

	/**
	 * Codes zur Identifizierung bzw. zum Aufruf der Activity
	 */
	public static final int MENSASELECTED_REQUEST_CODE = 123321001;

	public static final int MENSASELECTED_SUCCESS_CODE = 4;

	/**
	 * XML-Komponenten als Variablen vereinbaren
	 */
	private ImageView mensaWabe;
	private Button food;
	private Button mensabackB;
	private OnClickListener onClick = new OnClickListener() {

		/**
		 * if-Bedingungen sorgen für Fallunterscheidung wann welche Activity
		 * aufgerufen wird, sobald auf ein bestimmten XML-Button geklickt wird.
		 */
		@Override
		public void onClick(View v) {
			if (v == food) {

				ProgressTimerDialog.run(MensaSelected.this, "Lade Menuplan");
				startActivityForResult(
						new Intent(BeuthOrgApplication.getAppContext(),
								MensaFood.class),
						MensaFood.MENSAFOOD_REQUEST_CODE);
			} else if (v == mensabackB) {
				returnToCallingActivity();
			}

		}
	};

	/**
	 * betroffenes Layout wird mit Hilfe von setContentView-Methode mit Activity
	 * verknüpft, um auf die XML-Komponenten zugreifen zu können.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mensamenu);

		/**
		 * Variablen werden mit entsprechend vereinbarten ID's der
		 * XML-Komponenten versehen, um diese jeweils zu verknüpfen
		 */
		mensaWabe = (ImageView) findViewById(R.id.imageView1);
		food = (Button) findViewById(R.id.foodb);
		mensabackB = (Button) findViewById(R.id.mensabackB);
		food.setOnClickListener(onClick);
		mensabackB.setOnClickListener(onClick);

		/**
		 * Erstellen/Laden von Animationen
		 */
		Animation aScale = AnimationUtils.loadAnimation(this,
				R.anim.menubuttonsscale);
		Animation aAlpha = AnimationUtils.loadAnimation(this,
				R.anim.menubuttonsalpha);
		Animation aRotate = AnimationUtils.loadAnimation(this,
				R.anim.menubuttonsrotate);
		AnimationSet set = new AnimationSet(false);
		set.addAnimation(aRotate);
		set.addAnimation(aAlpha);

		/**
		 * XML-Komponenten mit Animationen versehen/verknüpfen
		 */
		mensaWabe.startAnimation(aScale);
		food.startAnimation(set);

	}

	@Override
	public void onBackPressed() {
		finishActivity(this.getTaskId());
		super.onBackPressed();
	}

	/**
	 * Methode sorgt dafür, dass beim Drücken der BACK-Taste des Smartphones die
	 * jeweilig vorherige Activity aufgerufen wird.
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
		setResult(MensaSelected.MENSASELECTED_SUCCESS_CODE, intent);
		finish();
	}

}
