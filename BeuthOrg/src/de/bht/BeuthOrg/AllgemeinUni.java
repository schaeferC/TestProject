package de.bht.BeuthOrg;

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

public class AllgemeinUni extends Activity implements OnClickListener{
    /** Called when the activity is first created. */

	private Button News;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allgemeinuni);
        
        News = (Button)findViewById(R.id.button1);
        News.setOnClickListener(this);

    }

	@Override
	public void onClick(View v) {
		if(v ==News){
		    startActivity(new Intent("de.bht.BeuthOrg.News"));
		}
	}
}