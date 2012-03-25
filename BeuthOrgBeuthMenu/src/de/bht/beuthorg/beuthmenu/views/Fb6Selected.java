package de.bht.beuthorg.beuthmenu.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import de.bht.beuthorg.beuthmenu.R;

public class Fb6Selected extends Activity{
	
	public static final int FB6SELECTED_REQUEST_CODE = 1233218998;

	public static final int FB6SELECTED_SUCCESS_CODE = 11;
	
	private ImageView fbwabe;
	private Button fsinfoB;
	private Button fsbackB;

	private OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == fsinfoB) {

			} else if (v == fsbackB) {

		}
	}
	};

	
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.fbmenu);
			
			fsinfoB = (Button)findViewById(R.id.fsinfoB);
			fsinfoB.setOnClickListener(ocl);
			
			fbwabe = (ImageView) findViewById(R.id.fbwabe);
			
			fsbackB = (Button)findViewById(R.id.fsbackB);
			fsbackB.setOnClickListener(ocl);
			
			
        
        Animation aScale = AnimationUtils.loadAnimation(this,
				R.anim.menubuttonsscale);
        Animation aAlpha = AnimationUtils.loadAnimation(this,
				R.anim.menubuttonsalpha);
		Animation aRotate = AnimationUtils.loadAnimation(this, R.anim.menubuttonsrotate);
		AnimationSet set = new AnimationSet(false);
		set.addAnimation(aRotate);
		set.addAnimation(aAlpha);
		

		
		fbwabe.startAnimation(aScale);
		fsinfoB.startAnimation(set);
		
		
	}

}

