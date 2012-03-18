package de.bht.BeuthOrg.views;

import de.bht.BeuthOrg.R;
import de.bht.BeuthOrg.util.HTTPContents;
import de.bht.BeuthOrg.util.NewsArrayAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class News extends Activity {
    /** Called when the activity is first created. */
    
//    private Button Back;
	private ListView newsList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.news);
        
        setContentView(R.layout.lehrkraftnews);
        
        newsList = (ListView) findViewById(R.id.listLehrkraft);
        
        String[] contentsNews = HTTPContents.getLehrkraftNews();
        //Log.w("news", contentsNews[2]);
        NewsArrayAdapter newsArrayAdapter = new NewsArrayAdapter(this, R.layout.list_item, contentsNews, getResources());
        
        newsList.setAdapter(newsArrayAdapter);
        newsList.setCacheColorHint(Color.TRANSPARENT);
        
//        Back = (Button)findViewById(R.id.button1);
//        Back.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				if(v ==Back){
//				    startActivity(new Intent(v.getContext(), AllgemeinUni.class));
//				}
//				
//			}
//		});

    }


    @Override
    public void onBackPressed() {
    	finish();
    	super.onBackPressed();
    	startActivity(new Intent(this, AllgemeinUni.class));
    }

}