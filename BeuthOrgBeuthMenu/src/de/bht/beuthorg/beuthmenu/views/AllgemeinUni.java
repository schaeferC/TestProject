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
   
	public static final int UNI_REQUEST_CODE = 123321000;

	public static final int UNI_SUCCESS_CODE = 3;
	/** Called when the activity is first created. */

	private Button aunewsB;
	private Button auinfoB;
	private Button aukontaktB;
	private Button aubackB;
	
	private OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == aunewsB) {
				finish();
				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), News.class), News.NEWS_REQUEST_CODE);
			} else if (v == auinfoB) {
//				finish();
//				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), Fb6Selected.class), Fb6Selected.UNI_REQUEST_CODE);
			} else if (v == aukontaktB) {
//				finish();
//				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), IchSelected.class), IchSelected.UNI_REQUEST_CODE);
			} else if (v == aubackB) {
//				finish();
//				startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), BeuthMenu.class), BeuthMenu.MENSASELECTED_REQUEST_CODE);
			}

		}
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unimenu);
        
        aunewsB = (Button)findViewById(R.id.aunewsB);
        aunewsB.setOnClickListener(ocl);
        
        auinfoB = (Button)findViewById(R.id.auinfoB);
        auinfoB.setOnClickListener(ocl);
        
        aukontaktB = (Button)findViewById(R.id.aukonB);
        aukontaktB.setOnClickListener(ocl);
        
        aubackB = (Button)findViewById(R.id.aubackB);
        aubackB.setOnClickListener(ocl);
        
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
		

		aukontaktB.startAnimation(set);
		aunewsB.startAnimation(set);
		auinfoB.startAnimation(set);

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
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			returnToCallingActivity();
		}
		return true;
	}

	protected void returnToCallingActivity() {
		Intent intent = new Intent();
		setResult(AllgemeinUni.UNI_SUCCESS_CODE, intent);
		finish();
	}

}