package de.bht.beuthorg.studiendokumentation;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Dient der Darstellung der Inhalte der List-Items
 * 
 * @author Enis, Claudia
 * 
 */
public class ArrayAdapterStudiendoku extends ArrayAdapter<String> {

	/**
	 * Inhalte die dargestellt werden
	 */
	private String[] contents;

	public ArrayAdapterStudiendoku(Context context, int textViewResourceId,
			String[] objects) {
		super(context, textViewResourceId, objects);
		this.contents = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		TextView v = (TextView) super.getView(position, convertView, parent);

		String[] s = contents[position].split("\\|");

		v.setText(Html
				.fromHtml(s[0] + "<br><font color=\"#2A3E59\" size=\"10\">"
						+ s[1] + "</font>"));

		return v;
	}

}
