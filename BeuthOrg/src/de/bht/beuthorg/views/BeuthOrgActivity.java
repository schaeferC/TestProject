package de.bht.beuthorg.views;

import de.bht.beuthorg.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class BeuthOrgActivity extends Activity{
		   
	/** 
	 * XML-Komponenten als Variablen vereinbaren 
	 */
	private Button helloButton;
	
	/** 
	 * betroffenes Layout wird mit Hilfe von setContentView-Methode mit Activity verknüpft, 
	 * um auf die XML-Komponenten zugreifen zu können.
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
            
        /** 
		 * Variablen werden mit entsprechend vereinbarten ID's der XML-Komponenten versehen,
		 *  um diese jeweils zu verknüpfen  
		 */
        helloButton = (Button)findViewById(R.id.hello_button);
        helloButton.setOnClickListener(new OnClickListener() {
			
        	/**
    		 *  if-Bedingungen sorgen für Fallunterscheidung wann welche Activity aufgerufen wird,
    		 *  sobald auf ein bestimmten XML-Button geklickt wird. 
    		 */
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