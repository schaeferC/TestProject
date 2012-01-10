package de.bht.BeuthOrg.views;

import de.bht.BeuthOrg.R;
import de.bht.BeuthOrg.util.Common;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Menu extends Activity{
    /** Called when the activity is first created. */
    
    private Button uniB;
    private Button fb6B;
    private Button ichB;
    private Button mensaB;
    
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        uniB = (Button)findViewById(R.id.uniB);
        uniB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				    startActivity(new Intent(Common.DE_BHT_BEUTH_ORG+"AllgemeinUni"));
				
			}
		});

        fb6B = (Button)findViewById(R.id.fb6B);
        fb6B.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				
			}
		});

        ichB = (Button)findViewById(R.id.ichB);
        ichB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {


				
			}
		});

        mensaB = (Button)findViewById(R.id.mensaB);
        mensaB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});

    }

}