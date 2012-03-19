package de.bht.beuthorganizer.views;

import de.bht.beuthorganizer.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AllgemeinUni extends Activity{
    /** Called when the activity is first created. */

	private Button News;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allgemeinuni);
        
        News = (Button)findViewById(R.id.button1);
        News.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v ==News){
					finish();
				    startActivity(new Intent(v.getContext(),News.class));
				}
				
			}
		});

    }
	@Override
	public void onBackPressed() {
		finishActivity(this.getTaskId());
		super.onBackPressed();
		startActivity(new Intent(this,Menu.class));
	}
    

}