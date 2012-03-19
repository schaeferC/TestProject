package de.bht.beuthorganizer.views;

import java.util.ArrayList;

import de.bht.beuthorganizer.R;
import de.bht.beuthorganizer.util.HTTPContentsNews;
import de.bht.beuthorganizer.util.NewsArrayAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
        
        ArrayList<String> contentsNews = HTTPContentsNews.getLehrkraftNews();
        //Log.w("news", contentsNews[2]);
        NewsArrayAdapter newsArrayAdapter = new NewsArrayAdapter(this, R.layout.list_item_news, contentsNews);
        
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
    	finishActivity(this.getTaskId());
    	super.onBackPressed();
    	startActivity(new Intent(this, AllgemeinUni.class));
    }

}