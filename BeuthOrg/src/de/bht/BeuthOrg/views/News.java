package de.bht.BeuthOrg.views;

import de.bht.BeuthOrg.R;
import de.bht.BeuthOrg.util.Common;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class News extends Activity {
    /** Called when the activity is first created. */
    
    private Button Back;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        
        Back = (Button)findViewById(R.id.button1);
        Back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v ==Back){
				    startActivity(new Intent(Common.DE_BHT_BEUTH_ORG+"AllgemeinUni"));
				}
				
			}
		});

    }


}