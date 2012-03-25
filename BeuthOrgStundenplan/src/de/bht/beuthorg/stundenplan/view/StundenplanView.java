package de.bht.beuthorg.stundenplan.view;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.bht.beuthorg.control.BeuthOrgControl;
import de.bht.beuthorg.moduldescription.view.Modulbeschreibung;
import de.bht.beuthorg.objects.Modul;
import de.bht.beuthorg.profinfoweb.view.ProfInfo;
import de.bht.beuthorg.raumplan.view.Raumplan;
import de.bht.beuthorg.stundenplan.R;
import de.bht.beuthorg.util.BeuthOrgApplication;

public class StundenplanView extends Activity {

	public static final int STUNDENPLAN_REQUEST_CODE = 15587999;

	public static final int STUNDENPLAN_SUCCESS_CODE = 789658;

	private Button mondayB;
	private Button tuesdayB;
	private Button wednesdayB;
	private Button thursdayB;
	private Button fridayB;
	private Button saturdayB;
	
	
	private OnClickListener blockButtonsClicked = new OnClickListener() {
		Button vb;
		@Override
		public void onClick(View v) {
			vb = (Button) v;
			final CharSequence[] items = {"Raumplan", "Modulbeschreibung", "zur Lehrkraftwebsite"};
			Builder builder = new AlertDialog.Builder(v.getContext());
			builder.setTitle("Select ");
			//builder.setCancelable(true);
			builder.setItems(items, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					if(which == 0){
						startActivityForResult(new Intent(BeuthOrgApplication.getAppContext(), Raumplan.class), Raumplan.RAUMPLAN_REQUEST_CODE);
					}else if (which == 1){
						Intent intent = new Intent(BeuthOrgApplication.getAppContext(), Modulbeschreibung.class);
						Log.d("Debug", vb.getText().toString());
						intent.putExtra("modul", vb.getText());
						startActivityForResult(intent, Modulbeschreibung.MODULBESCHREIBUNG_REQUEST_CODE);
					}else if(which == 2){
						Intent intent = new Intent(BeuthOrgApplication.getAppContext(), ProfInfo.class);
						intent.putExtra("modul", vb.getText());
						startActivityForResult(intent, ProfInfo.PROFINFO_REQUEST_CODE);
					}
					
				}
			});
			AlertDialog dialog = builder.create();
			dialog.show();
		}
	};


	private Map<String, Button> blockMap;
	private Modul[] module;
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.stundenplan);
		
		blockMap = new HashMap<String, Button>();
		module = BeuthOrgControl.getInstance().getRegistredStudent()
				.getStundenplan().getModul();

		mondayB = (Button) findViewById(R.id.mondayButton);
		tuesdayB = (Button) findViewById(R.id.tuesdayButton);
		wednesdayB = (Button) findViewById(R.id.wednesdayButton);
		thursdayB = (Button) findViewById(R.id.thursdayButton);
		fridayB = (Button) findViewById(R.id.fridayButton);
		saturdayB = (Button) findViewById(R.id.saturdayButton);

		blockMap.put("Mo8:00", (Button) findViewById(R.id.mondayBlock1Button));
		blockMap.put("Di8:00", (Button) findViewById(R.id.tuesdayBlock1Button));
		blockMap.put("Mi8:00",
				(Button) findViewById(R.id.wednesdayBlock1Button));
		blockMap.put("Do8:00", (Button) findViewById(R.id.thursdayBlock1Button));
		blockMap.put("Fr8:00", (Button) findViewById(R.id.fridayBlock1Button));
		blockMap.put("Sa8:00", (Button) findViewById(R.id.saturdayBlock1Button));

		blockMap.put("Mo10:00", (Button) findViewById(R.id.mondayBlock2Button));
		blockMap.put("Di10:00", (Button) findViewById(R.id.tuesdayBlock2Button));
		blockMap.put("Mi10:00",
				(Button) findViewById(R.id.wednesdayBlock2Button));
		blockMap.put("Do10:00",
				(Button) findViewById(R.id.thursdayBlock2Button));
		blockMap.put("Fr10:00", (Button) findViewById(R.id.fridayBlock2Button));
		blockMap.put("Sa10:00",
				(Button) findViewById(R.id.saturdayBlock2Button));

		blockMap.put("Mo12:15", (Button) findViewById(R.id.mondayBlock3Button));
		blockMap.put("Di12:15", (Button) findViewById(R.id.tuesdayBlock3Button));
		blockMap.put("Mi12:15",
				(Button) findViewById(R.id.wednesdayBlock3Button));
		blockMap.put("Do12:15",
				(Button) findViewById(R.id.thursdayBlock3Button));
		blockMap.put("Fr12:15", (Button) findViewById(R.id.fridayBlock3Button));
		blockMap.put("Sa12:15",
				(Button) findViewById(R.id.saturdayBlock3Button));

		blockMap.put("Mo14:15", (Button) findViewById(R.id.mondayBlock4Button));
		blockMap.put("Di14:15", (Button) findViewById(R.id.tuesdayBlock4Button));
		blockMap.put("Mi14:15",
				(Button) findViewById(R.id.wednesdayBlock4Button));
		blockMap.put("Do14:15",
				(Button) findViewById(R.id.thursdayBlock4Button));
		blockMap.put("Fr14:15", (Button) findViewById(R.id.fridayBlock4Button));
		blockMap.put("Sa14:15",
				(Button) findViewById(R.id.saturdayBlock4Button));

		blockMap.put("Mo16:00", (Button) findViewById(R.id.mondayBlock5Button));
		blockMap.put("Di16:00", (Button) findViewById(R.id.tuesdayBlock5Button));
		blockMap.put("Mi16:00",
				(Button) findViewById(R.id.wednesdayBlock5Button));
		blockMap.put("Do16:00",
				(Button) findViewById(R.id.thursdayBlock5Button));
		blockMap.put("Fr16:00", (Button) findViewById(R.id.fridayBlock5Button));
		blockMap.put("Sa16:00",
				(Button) findViewById(R.id.saturdayBlock5Button));

		blockMap.put("Mo17:45", (Button) findViewById(R.id.mondayBlock6Button));
		blockMap.put("Di17:45", (Button) findViewById(R.id.tuesdayBlock6Button));
		blockMap.put("Mi17:45",
				(Button) findViewById(R.id.wednesdayBlock6Button));
		blockMap.put("Do17:45",
				(Button) findViewById(R.id.thursdayBlock6Button));
		blockMap.put("Fr17:45", (Button) findViewById(R.id.fridayBlock6Button));
		blockMap.put("Sa17:45",
				(Button) findViewById(R.id.saturdayBlock6Button));

		blockMap.put("Mo19:30", (Button) findViewById(R.id.mondayBlock7Button));
		blockMap.put("Di19:30", (Button) findViewById(R.id.tuesdayBlock7Button));
		blockMap.put("Mi19:30",
				(Button) findViewById(R.id.wednesdayBlock7Button));
		blockMap.put("Do19:30",
				(Button) findViewById(R.id.thursdayBlock7Button));
		blockMap.put("Fr19:30", (Button) findViewById(R.id.fridayBlock7Button));
		blockMap.put("Sa19:30",
				(Button) findViewById(R.id.saturdayBlock7Button));

		for (int i = 0; i < module.length; i++) {
			Modul modul = module[i];
			String block = new String(modul.getDay() + modul.getTime());

			if (blockMap.containsKey(block)) {
				blockMap.get(block).setText(
						modul.getModulName() + "\n" + modul.getRoom()+"\n"+ modul.getTeacher());
				blockMap.get(block).setOnClickListener(blockButtonsClicked);
				
			}
		}

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
		setResult(StundenplanView.STUNDENPLAN_SUCCESS_CODE, intent);
		finish();
	}

}
