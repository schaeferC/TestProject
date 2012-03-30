package de.bht.beuthorg.news.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import de.bht.beuthorg.news.R;
import de.bht.beuthorg.util.BeuthOrgApplication;
import de.bht.beuthorg.util.DataSaver;
import de.bht.beuthorg.util.objects.LehrkraftNews;

/**
 * Activity zur Darstellung einer LehrkraftNews
 * @author Claudia
 *
 */
public class OneNews extends Activity {

	/**
	 * Stellt die News dar
	 */
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
