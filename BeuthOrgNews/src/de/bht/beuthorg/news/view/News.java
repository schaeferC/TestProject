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
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * Activity zur Darstellung der Lehrkraftnews
 * 
 * @author Claudia
 * 
 */
public class News extends Activity implements OnItemClickListener {

	/**
	 * Constante mit der die Activity aufgerufen wird
	 */
	public static final int NEWS_REQUEST_CODE = 123321998;

	/**
	 * Result, dass die Activity zurückgibt nach erfolgreichem Abschluss
	 */
	public static final int NEWS_SUCCESS_CODE = 1;

	/**
	 * List in der die Lehrkraftnews angezeigt werden
	 */
	private ListView newsList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// zugrunde liegendes Layout
		setContentView(R.layout.news);
		// Zuweisung eines Items des zugrundeliegenden Layouts
		newsList = (ListView) findViewById(R.id.listNews);

		// Aufruf um Lehrkraftnews zu erhalten
		ArrayList<String> contentsNews = HTTPContentsNews.getLehrkraftNews();

		NewsArrayAdapter newsArrayAdapter = new NewsArrayAdapter(
				getApplicationContext(), R.layout.list_item_news, contentsNews);
		// Eigenschaften von newsList setzen
		newsList.setAdapter(newsArrayAdapter);
		newsList.setCacheColorHint(Color.TRANSPARENT);
		newsList.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		Intent myIntent = new Intent(view.getContext(), OneNews.class);
		myIntent.putExtra("news", parent.getItemAtPosition(position).toString());
		startActivity(myIntent);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			returnToCallingActivity();
		}
		return true;
	}

	/**
	 * Beendet die aktuelle Activity und gibt der aufrufenden Activity den
	 * SuccessCode zurück
	 */
	protected void returnToCallingActivity() {
		Intent intent = new Intent();
		setResult(News.NEWS_SUCCESS_CODE, intent);
		finish();
	}

}