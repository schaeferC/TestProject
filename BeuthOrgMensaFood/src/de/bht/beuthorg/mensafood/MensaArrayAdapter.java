package de.bht.beuthorg.mensafood;


import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
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
		this.res = res;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView v = (TextView) super.getView(position, convertView, parent);
		if (position > 0) {
			if (contents[position].startsWith("EUR")) {
				v.setText(contents[position]);
				v.setGravity(Gravity.RIGHT);
				v.setTextSize(10);

			} else {
				v.setText(contents[position]);
				v.setGravity(Gravity.LEFT);
				v.setTextSize(10);
			}

			if (contents[position - 1].isEmpty()) {
				v.setText(contents[position]);
				v.setTextColor(res.getColor(R.color.beuthorgOrange));
				v.setTextSize(12);

			} else if (contents[position - 1].matches(".*?")) {

				if (contents[position].matches(".*?\\|\\d+[\\|*\\d*]*")) {
					String first = contents[position].substring(0,
							contents[position].indexOf("|"));
					String last = contents[position]
							.substring(contents[position].indexOf("|") + 1);
					last = last.replaceAll("\\|\\|", " ");
					v.setText(Html.fromHtml(first + "<sup>" + last + "</sup>"));
					v.setTextColor(res.getColor(R.color.beuthorgTextColor));
					v.setTextSize(10);
					res.finishPreloading();
					return v;
				}
				
				v.setText(contents[position]);
				v.setTextColor(res.getColor(R.color.beuthorgTextColor));
				v.setTextSize(10);

			}
		}
		res.finishPreloading();
		return v;
	}

}
