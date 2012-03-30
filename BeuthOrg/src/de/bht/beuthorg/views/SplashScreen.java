package de.bht.beuthorg.views;

import de.bht.beuthorg.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Activity f�r den ersten Screen
 *
 */
public class SplashScreen extends Activity {
    // Variablen f�r Dauer und Activit�t des SplashScreens
	private boolean active = true;
    private static final int TIMER = 5000;
    
    /** 
	 * betroffenes Layout wird mit Hilfe von setContentView-Methode mit Activity verkn�pft, 
	 * um auf die XML-Komponenten zugreifen zu k�nnen.
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);
        
        // thread for displaying the SplashScreen
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while(active && (waited < TIMER)) {
                        sleep(100);
                        if(active) {
                            waited += 100;
                        }
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
                    startActivity(new Intent(getApplicationContext(),Login.class));
                    
                }
            }
        };
        splashTread.start();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            active = false;
        }
        return true;
    }
}