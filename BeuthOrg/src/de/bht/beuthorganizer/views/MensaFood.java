package de.bht.beuthorganizer.views;

import de.bht.beuthorganizer.R;
import de.bht.beuthorganizer.util.HTTPContents;
import de.bht.beuthorganizer.util.MensaArrayAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MensaFood extends Activity {

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
	public void onBackPressed() {
		finishActivity(this.getTaskId());
		super.onBackPressed();
		startActivity(new Intent(this, MensaSelected.class));
	}

}
