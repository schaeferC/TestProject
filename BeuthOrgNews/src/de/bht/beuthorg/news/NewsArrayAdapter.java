package de.bht.beuthorg.news;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsArrayAdapter extends ArrayAdapter<String> {

	ArrayList<String> contents;
	
	public NewsArrayAdapter(Context context, int resource,
			List<String> contentsNews) {
		super(context, resource, contentsNews);
		this.contents = (ArrayList<String>) contentsNews;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		TextView v = (TextView) super.getView(position, convertView, parent);

		v.setText(Html.fromHtml(contents.get(position)));
		return v;
	}

	
}
