package de.bht.BeuthOrg.util;

import de.bht.BeuthOrg.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MensaArrayAdapter extends ArrayAdapter<String> {

	String[] contents;
	Resources res;
	public MensaArrayAdapter(Context context, int textViewResourceId,
			String[] objects, Resources res) {
		super(context, textViewResourceId, objects);
		this.contents = objects;
		this.res=res;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView v = (TextView) super.getView(position, convertView, parent);
		if(position>0){
				
			if(contents[position].startsWith("EUR")){
				v.setText(contents[position]);
				v.setGravity(Gravity.RIGHT);
			}else{
				v.setText(contents[position]);
				v.setGravity(Gravity.LEFT);
			}
			
			if (contents[position - 1].isEmpty()) {
				v.setText(contents[position]);
				v.setTextColor(res.getColor(R.color.beuthOrgOrange));
				Log.w("Adapter", "getView2");
			}else if(contents[position-1].matches(".*?")){
				v.setText(contents[position]);
				v.setTextColor(res.getColor(R.color.beuthOrgTextColor));
				Log.w("Adapter", "getView3");
			}
		}
		return v;
	}

}
