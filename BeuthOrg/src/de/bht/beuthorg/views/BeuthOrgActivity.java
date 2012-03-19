package de.bht.beuthorg.views;

import de.bht.beuthorg.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class BeuthOrgActivity extends Activity{

	/** Called when the activity is first created. */
		   
	private Button helloButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                
        helloButton = (Button)findViewById(R.id.hello_button);
        helloButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (v == helloButton){
					finish();
					 startActivity(new Intent(v.getContext(), Login.class));
				}	
				
			}
		});
    }

}