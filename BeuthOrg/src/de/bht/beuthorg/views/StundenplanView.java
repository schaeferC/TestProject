package de.bht.beuthorg.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.bht.beuthorg.R;
import de.bht.beuthorg.control.BeuthOrgControl;
import de.bht.beuthorg.objects.Modul;
import de.bht.beuthorg.util.BeuthOrgApplication;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class StundenplanView extends Activity {

	private Button mondayB;
	private Button tuesdayB;
	private Button wednesdayB;
	private Button thursdayB;
	private Button fridayB;
	private Button saturdayB;
	
	private ArrayList<Modul> moduleMonday;
	private ArrayList<Modul> moduleTuesday;
	private ArrayList<Modul> moduleWednesday;
	private ArrayList<Modul> moduleThursday;
	private ArrayList<Modul> moduleFriday;
	private ArrayList<Modul> moduleSaturday;
	
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
						startActivity(new Intent(BeuthOrgApplication.getAppContext(), Raumplan.class));
					}else if (which == 1){
						Intent intent = new Intent(BeuthOrgApplication.getAppContext(), Modulbeschreibung.class);
						Log.d("Debug", vb.getText().toString());
						intent.putExtra("modul", vb.getText());
						startActivity(intent);
					}else if(which == 2){
						Intent intent = new Intent(BeuthOrgApplication.getAppContext(), ProfInfo.class);
						intent.putExtra("modul", vb.getText());
						startActivity(intent);
					}
					
				}
			});
			AlertDialog dialog = builder.create();
			dialog.show();
			
			

		}
	};


	// private Button mondayBlock1B;
	// private Button tuesdayBlock1B;
	// private Button wednesdayBlock1B;
	// private Button thursdayBlock1B;
	// private Button fridayBlock1B;
	// private Button saturdayBlock1B;
	//
	// private Button mondayBlock2B;
	// private Button tuesdayBlock2B;
	// private Button wednesdayBlock2B;
	// private Button thursdayBlock2B;
	// private Button fridayBlock2B;
	// private Button saturdayBlock2B;
	//
	// private Button mondayBlock3B;
	// private Button tuesdayBlock3B;
	// private Button wednesdayBlock3B;
	// private Button thursdayBlock3B;
	// private Button fridayBlock3B;
	// private Button saturdayBlock3B;
	//
	// private Button mondayBlock4B;
	// private Button tuesdayBlock4B;
	// private Button wednesdayBlock4B;
	// private Button thursdayBlock4B;
	// private Button fridayBlock4B;
	// private Button saturdayBlock4B;
	//
	// private Button mondayBlock5B;
	// private Button tuesdayBlock5B;
	// private Button wednesdayBlock5B;
	// private Button thursdayBlock5B;
	// private Button fridayBlock5B;
	// private Button saturdayBlock5B;
	//
	// private Button mondayBlock6B;
	// private Button tuesdayBlock6B;
	// private Button wednesdayBlock6B;
	// private Button thursdayBlock6B;
	// private Button fridayBlock6B;
	// private Button saturdayBlock6B;
	//
	// private Button mondayBlock7B;
	// private Button tuesdayBlock7B;
	// private Button wednesdayBlock7B;
	// private Button thursdayBlock7B;
	// private Button fridayBlock7B;
	// private Button saturdayBlock7B;
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

}
