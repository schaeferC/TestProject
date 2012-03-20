package de.bht.beuthorg.mensafood.view;

import de.bht.beuthorg.mensafood.HTTPContents;
import de.bht.beuthorg.mensafood.MensaArrayAdapter;
import de.bht.beuthorg.mensafood.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MensaFood extends Activity {

	public static final int MENSAFOOD_REQUEST_CODE = 123321999;

	public static final int MENSAFOOD_SUCCESS_CODE = 2;
	
	private ListView mealList;
	private Button dayB;
	private TextView dayA;
	private String day;
	private Bundle savedInstanceState;
	private String bottomContents;
	private TextView bottomContentsView;

	private OnClickListener onClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == dayB) {
				changeDay();
			}
		}
	};

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.mensafood);
		this.savedInstanceState = savedInstanceState;

		mealList = (ListView) findViewById(R.id.list);
		dayB = (Button) findViewById(R.id.dayB);
		dayA = (TextView) findViewById(R.id.dayA);
		bottomContentsView = (TextView) findViewById(R.id.bottomContent);

		if (day != null) {
			if (day.contains("today")) {
				day = new String("tomorrow");
				dayB.setText("heute");
				dayA.setText("morgen");
			} else {
				day = new String("today");
				dayB.setText("morgen");
				dayA.setText("heute");
			}
		} else {
			day = new String("today");
			dayB.setText("morgen");
			dayA.setText("heute");
		}

		dayB.setOnClickListener(onClick);

		String siteContent = HTTPContents.mensaGetContents(day);
		bottomContents = siteContent.substring(siteContent
				.indexOf("Kennzeichnung"));
		String[] siteContents = siteContent.split("\n");

		bottomContentsView.setText(bottomContents);
		MensaArrayAdapter adapter = new MensaArrayAdapter(this,
				R.layout.list_item, siteContents, getResources());

		mealList.setAdapter(adapter);
		mealList.setCacheColorHint(Color.TRANSPARENT);


	}

	private void changeDay() {

		this.onCreate(savedInstanceState);
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
		setResult(MensaFood.MENSAFOOD_SUCCESS_CODE, intent);
		finish();
	}


}