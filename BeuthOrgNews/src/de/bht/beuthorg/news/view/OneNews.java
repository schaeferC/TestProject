package de.bht.beuthorg.news.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import de.bht.beuthorg.news.R;
import de.bht.beuthorg.objects.LehrkraftNews;
import de.bht.beuthorg.util.BeuthOrgApplication;
import de.bht.beuthorg.util.DataSaver;

public class OneNews extends Activity {

	TextView oneNewsV;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onenews);
		oneNewsV = (TextView) findViewById(R.id.oneNewsView);
		LehrkraftNews newsToShow = new LehrkraftNews(DataSaver.readSettings(BeuthOrgApplication.getAppContext(), "news.json"));
		String[] result = newsToShow.getLehrkraftnewsByKey(getIntent().getStringExtra("news"));
		oneNewsV.setText(result[0]+"\n"+result[1]+"\n"+result[2]);
	}

	
}