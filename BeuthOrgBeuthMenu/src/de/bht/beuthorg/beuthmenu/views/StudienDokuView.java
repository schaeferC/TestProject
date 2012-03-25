package de.bht.beuthorg.beuthmenu.views;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;
import de.bht.beuthorg.datahandler.DataHandler;
import de.bht.beuthorg.news.NewsArrayAdapter;
import de.bht.beuthorg.news.R;

public class StudienDokuView extends Activity {
	
	public static final int STUDIENDOKU_REQUEST_CODE = 123329998;

	public static final int STUDIENDOKU_SUCCESS_CODE = 20;
	
	private ListView studiendokulist;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studiendoku);
		studiendokulist = (ListView) findViewById(R.id.listNews);
		
		DataHandler data = new DataHandler();
		ArrayList<String[]> contentsStudienDoku = DataHandler.getStudienDoku();


	}

}
