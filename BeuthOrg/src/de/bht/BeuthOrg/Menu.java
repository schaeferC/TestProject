package de.bht.BeuthOrg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Menu extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    
    private Button AllgemeineUni;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        AllgemeineUni = (Button)findViewById(R.id.button1);
        AllgemeineUni.setOnClickListener(this);

    }

	@Override
	public void onClick(View v) {
	if(v ==AllgemeineUni){
	    startActivity(new Intent("de.bht.BeuthOrg.AllgemeinUni"));
	}
		
		
	}
}