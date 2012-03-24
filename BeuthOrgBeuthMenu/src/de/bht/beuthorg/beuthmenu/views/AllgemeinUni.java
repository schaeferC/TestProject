package de.bht.beuthorg.beuthmenu.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.bht.beuthorg.beuthmenu.R;
import de.bht.beuthorg.news.view.News;
import de.bht.beuthorg.util.BeuthOrgApplication;

public class AllgemeinUni extends Activity{
   
	public static final int UNI_REQUEST_CODE = 123321000;

	public static final int UNI_SUCCESS_CODE = 3;
	/** Called when the activity is first created. */

	private Button newsB;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allgemeinuni);
        
        newsB = (Button)findViewById(R.id.newsButton);
        newsB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v ==newsB){
					
				    startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(),News.class), News.NEWS_REQUEST_CODE);
				}
				
			}
		});

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