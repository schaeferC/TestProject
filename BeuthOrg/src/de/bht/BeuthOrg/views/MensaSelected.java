package de.bht.BeuthOrg.views;

import de.bht.BeuthOrg.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MensaSelected extends Activity {
	ImageView mensaWabe;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mensamenu);
		mensaWabe = (ImageView) findViewById(R.id.imageView1);
		Animation a = AnimationUtils.loadAnimation(this, R.anim.menubuttonsscale);
		mensaWabe.startAnimation(a);
	}



}
