package de.bht.BeuthOrg.views;

import javax.xml.datatype.Duration;

import de.bht.BeuthOrg.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MensaSelected extends Activity {

	private ImageView mensaWabe;
	private Button food;
	private OnClickListener onClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == food) {
				Log.w("click", "food clicked");

				startActivity(new Intent(v.getContext(), MensaFood.class));
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
//		Animation aSet = AnimationUtils.loadAnimation(this,
//				R.anim.set);
		
		mensaWabe.startAnimation(aScale);
		food.startAnimation(aAlpha);
		
//		
//
//		food = (Button) findViewById(R.id.foodb);
//		food.bringToFront();
		
	}

}
