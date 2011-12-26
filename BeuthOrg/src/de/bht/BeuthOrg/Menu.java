package de.bht.BeuthOrg;

import de.bht.BeuthOrg.util.Common;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Menu extends Activity{
    /** Called when the activity is first created. */
    
    private Button AllgemeineUni;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        AllgemeineUni = (Button)findViewById(R.id.button1);
        AllgemeineUni.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v ==AllgemeineUni){
				    startActivity(new Intent(Common.DE_BHT_BEUTH_ORG+"AllgemeinUni"));
				}
				
			}
		});

    }

}