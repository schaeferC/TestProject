package de.bht.beuthorg.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.json.JSONObject;

import android.content.Context;

/**
 * Diese Klasse speichert und liest Dateien die auf der SD-Karte.
 * @author Claudia
 *
 */
public class DataSaver {

	/**
	 * Schreibt die Datei filename mit dem Inhalt data für context.
	 * @param context
	 * 		Context, context
	 * @param filename
	 * 		String, unter welchem Namen gespeichert wird
	 * @param data
	 * 		String, Inhalt der Datei
	 */
	public static void writeData(Context context, String filename, String data){
		
        FileOutputStream fOut = null;
        OutputStreamWriter osw = null;
        
        try {

            fOut = context.openFileOutput(filename, Context.MODE_PRIVATE);
            osw = new OutputStreamWriter(fOut);
            osw.write(data);
            osw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                osw.close();
                fOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	/**
	 * Liest die Daten aus filname für den context
	 * @param context
	 * 		Context, context
	 * @param filename
	 * 		String, Name der Datei
	 * @return
	 */
	public static JSONObject readSettings(Context context, String filename) {

        FileInputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        JSONObject data = null;

        try {

            fIn = context.openFileInput(filename);
            isr = new InputStreamReader(fIn);
            br = new BufferedReader(isr);
            data = new JSONObject(br.readLine());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
