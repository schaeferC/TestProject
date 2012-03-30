package de.bht.beuthorg.stundenplan.view;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import de.bht.beuthorg.moduldescription.view.Modulbeschreibung;
import de.bht.beuthorg.profinfoweb.view.ProfInfo;
import de.bht.beuthorg.raumplan.view.Raumplan;
import de.bht.beuthorg.stundenplan.R;
import de.bht.beuthorg.util.BeuthOrgApplication;
import de.bht.beuthorg.util.control.BeuthOrgControl;
import de.bht.beuthorg.util.objects.Modul;

/**
 * Ist die Activity-Klasse zum Anzeigen des Stundenplans.
 * Darstellung des Stundenplans als TableLayout
 * 
 * @author Claudia
 * 
 */
public class StundenplanView extends Activity {

	/**
	 * Constante mit der die Activity aufgerufen wird
	 */
	public static final int STUNDENPLAN_REQUEST_CODE = 15587999;

	/**
	 * Result, dass die Activity zurückgibt nach erfolgreichem Abschluss
	 */
	public static final int STUNDENPLAN_SUCCESS_CODE = 789658;

	// Items für das PopUpMenu eines Moduls im Stundenplan
	private ListView menuforList;
	private Button cancelmodulmenuB;

	/**
	 * Das PopUpMenu
	 */
	private PopupWindow puwmodulmenu;

	/**
	 * Listener für die Module des Stundenplans zum Aufrufen des PopUpMenus
	 */
	private OnClickListener blockButtonsClicked = new OnClickListener() {

		/**
		 * Hilfsvariable um den Text von dem Parameter v der Methode onClick zu
		 * bekommen.
		 */
		Button vb;

		@Override
		public void onClick(View v) {
			// Zuweisung von vb
			vb = (Button) v;
			// Inflater um eine custom view aufzurufen
			LayoutInflater inflater = getLayoutInflater();
			// View erzeugen
			View view = inflater.inflate(R.layout.menuformodul,
					(ViewGroup) findViewById(R.id.menumodulroot));
			// Zuweisung Cancelbutton mit Eigenschaft das popup yu schließen
			cancelmodulmenuB = (Button) view
					.findViewById(R.id.modulmenucancelB);
			cancelmodulmenuB.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					puwmodulmenu.dismiss();

				}
			});
			//

			menuforList = (ListView) view
					.findViewById(R.id.menuformodulListView);

			final String[] items = { "Raumplan", "Modulbeschreibung",
					"Lehrkraftwebsite" };
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
					BeuthOrgApplication.getAppContext(),
					R.layout.list_item_modulmenu, items);

			menuforList.setAdapter(adapter);
			menuforList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					
					if (position == 0) {
						startActivityForResult(
								new Intent(BeuthOrgApplication.getAppContext(),
										Raumplan.class),
								Raumplan.RAUMPLAN_REQUEST_CODE);
					} else if (position == 1) {
						Intent intent = new Intent(BeuthOrgApplication
								.getAppContext(), Modulbeschreibung.class);
						Log.d("Debug", vb.getText().toString());
						intent.putExtra("modul", vb.getText());
						startActivityForResult(
								intent,
								Modulbeschreibung.MODULBESCHREIBUNG_REQUEST_CODE);
					} else if (position == 2) {
						Intent intent = new Intent(BeuthOrgApplication
								.getAppContext(), ProfInfo.class);
						intent.putExtra("modul", vb.getText());
						startActivityForResult(intent,
								ProfInfo.PROFINFO_REQUEST_CODE);
					}

				}
			});
			puwmodulmenu = new PopupWindow(view, 500, 500, true);
			puwmodulmenu.showAtLocation(view, Gravity.CENTER, 0, 0);

		}
	};

	/**
	 * Für die Buttons der Module des Stundenplans
	 */
	private Map<String, Button> blockMap;
	/**
	 * Module die dargestellt werden.
	 */
	private Modul[] module;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stundenplan);

		blockMap = new HashMap<String, Button>();
		
		//Aufruf um die Module des Stundenplans des registrierten Studenten zu bekommen
		module = BeuthOrgControl.getInstance().getRegistredStudent()
				.getStundenplan().getModul();

		// Vereinbarung der Buttons für die Module in die Map schreiben
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
			// jedem Modul wird sein richtiger Platz in der Table zugewiesen
			//und nur an diesem Platz(Button) werden Eigenschaften gesetzt
			
			Modul modul = module[i];
			String block = new String(modul.getDay() + modul.getTime());

			if (blockMap.containsKey(block)) {
				
				blockMap.get(block).setText(
						modul.getModulName() + "\n" + modul.getRoom() + "\n"
								+ modul.getTeacher());
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

	/**
	 * Beendet die aktuelle Activity und gibt der aufrufenden Activity den SuccessCode zurück
	 */
	protected void returnToCallingActivity() {
		Intent intent = new Intent();
		setResult(StundenplanView.STUNDENPLAN_SUCCESS_CODE, intent);
		finish();
	}

}
