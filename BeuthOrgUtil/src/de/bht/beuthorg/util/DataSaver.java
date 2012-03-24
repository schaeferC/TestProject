package de.bht.beuthorg.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.content.Context;

public class DataSaver {

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
	
	public String readSettings(Context context, String filename) {

        FileInputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String data = null;

        try {

            fIn = context.openFileInput(filename);
            isr = new InputStreamReader(fIn);
            br = new BufferedReader(isr);
            data = new String(br.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
