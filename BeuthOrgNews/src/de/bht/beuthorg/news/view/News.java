package de.bht.beuthorg.news.view;

import java.util.ArrayList;

import de.bht.beuthorg.news.HTTPContentsNews;
import de.bht.beuthorg.news.NewsArrayAdapter;
import de.bht.beuthorg.news.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ListView;

public class News extends Activity {
	/** Called when the activity is first created. */
	public static final int NEWS_REQUEST_CODE = 123321998;

	public static final int NEWS_SUCCESS_CODE = 1;
	// private Button Back;
	private ListView newsList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.news);

		setContentView(R.layout.news);
		Context co = getApplicationContext();
		if (co != null) {
			Log.w("Debug", "Context exist");
		}
		newsList = (ListView) findViewById(R.id.listNews);

		ArrayList<String> contentsNews = HTTPContentsNews.getLehrkraftNews();
		// Log.w("news", contentsNews[2]);
		NewsArrayAdapter newsArrayAdapter = new NewsArrayAdapter(
				getApplicationContext(), R.layout.list_item_news, contentsNews);
		Log.w("news", newsArrayAdapter.getItem(0));
		Context c = getApplicationContext();
		if (c != null) {
			Log.w("Debug", "Context exist");
		}
		newsList.setAdapter(newsArrayAdapter);
		newsList.setCacheColorHint(Color.TRANSPARENT);

		// Back = (Button)findViewById(R.id.button1);
		// Back.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// if(v ==Back){
		// startActivity(new Intent(v.getContext(), AllgemeinUni.class));
		// }
		//
		// }
		// });

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			returnToCallingActivity();
		}
		return true;
	}

	protected void returnToCallingActivity() {
		Intent intent = new Intent();
		setResult(News.NEWS_SUCCESS_CODE, intent);
		finish();
	}

	// @Override
	// public void onBackPressed() {
	// finishActivity(this.getTaskId());
	// super.onBackPressed();
	// startActivity(new Intent(this, AllgemeinUni.class));
	// }

}