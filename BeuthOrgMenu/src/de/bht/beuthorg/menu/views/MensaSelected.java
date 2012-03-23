package de.bht.beuthorg.menu.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import de.bht.beuthorg.mensafood.view.MensaFood;
import de.bht.beuthorg.menu.R;
import de.bht.beuthorg.util.BeuthOrgApplication;

public class MensaSelected extends Activity {

	private ImageView mensaWabe;
	private Button food;
	private OnClickListener onClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == food) {
				Log.w("click", "food clicked");
				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(),MensaFood.class), MensaFood.MENSAFOOD_REQUEST_CODE);
				
			}
			

		}
	};;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mensamenu);
		
		mensaWabe = (ImageView) findViewById(R.id.imageView1);
		food = (Button) findViewById(R.id.foodb);
		food.setOnClickListener(onClick);
		
		Animation aScale = AnimationUtils.loadAnimation(this,
				R.anim.menubuttonsscale);
		Animation aAlpha = AnimationUtils.loadAnimation(this,
				R.anim.menubuttonsalpha);
		Animation aRotate = AnimationUtils.loadAnimation(this, R.anim.menubuttonsrotate);
		AnimationSet set = new AnimationSet(false);
		set.addAnimation(aRotate);
		set.addAnimation(aAlpha);
		
//		Animation aSet = AnimationUtils.loadAnimation(this,
//				R.anim.set);
		
		mensaWabe.startAnimation(aScale);
		food.startAnimation(set);
		
//		
//
//		food = (Button) findViewById(R.id.foodb);
//		food.bringToFront();
		
	}

	@Override
	public void onBackPressed() {
		finishActivity(this.getTaskId());
		super.onBackPressed();
		startActivity(new Intent(this, BeuthMenu.class));
	}

}
