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


public class IchSelected extends Activity{
	
	public static final int ICHSELECTED_REQUEST_CODE = 1233210998;

	public static final int ICHSELECTED_SUCCESS_CODE = 10;
	
	private Button israumplanB;
	private Button isstudiendokuB;
	private Button isstundenplanB;
	private Button isbackB;
	private ImageView ichmenu;
	
	
	private OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == israumplanB) {

			} else if (v == isstudiendokuB) {

			} else if (v == isstundenplanB) {

			} else if (v == isbackB) {

			}

		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ichmenu);
		
		israumplanB = (Button)findViewById(R.id.israumplanB); 
		israumplanB.setOnClickListener(ocl);
		
		isstudiendokuB = (Button)findViewById(R.id.isstudiendokuB);
		isstudiendokuB.setOnClickListener(ocl);
		
		isstundenplanB = (Button)findViewById(R.id.isstundenplanB);
		isstundenplanB.setOnClickListener(ocl);
		
		isbackB = (Button)findViewById(R.id.isbackB);
		isbackB.setOnClickListener(ocl);
		
		ichmenu = (ImageView)findViewById(R.id.ichwabe);
		
        
        Animation aScale = AnimationUtils.loadAnimation(this,
				R.anim.menubuttonsscale);
        Animation aAlpha = AnimationUtils.loadAnimation(this,
				R.anim.menubuttonsalpha);
		Animation aRotate = AnimationUtils.loadAnimation(this, R.anim.menubuttonsrotate);
		AnimationSet set = new AnimationSet(false);
		set.addAnimation(aRotate);
		set.addAnimation(aAlpha);
		

		
		ichmenu.startAnimation(aScale);
		isstundenplanB.startAnimation(set);
		israumplanB.startAnimation(set);
		isstudiendokuB.startAnimation(set);
		
	}
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			returnToCallingActivity();
		}
		return true;
	}

	protected void returnToCallingActivity() {
		Intent intent = new Intent();
		setResult(IchSelected.ICHSELECTED_SUCCESS_CODE, intent);
		finish();
	}


}
