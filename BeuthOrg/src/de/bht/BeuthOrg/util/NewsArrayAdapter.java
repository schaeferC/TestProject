package de.bht.BeuthOrg.util;

import java.util.ArrayList;
import java.util.List;

import de.bht.BeuthOrg.R;
import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsArrayAdapter extends ArrayAdapter<String> {

	ArrayList<String> contents;
	Resources res;
	
	public NewsArrayAdapter(Context context, int resource,
			List<String> contentsNews, Resources resources) {
		super(context, resource, contentsNews);
		this.contents = (ArrayList<String>) contentsNews;
		this.res = resources;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		TextView v = (TextView) super.getView(position, convertView, parent);
//		String head= contents.get(position);
//		String title = new String();
//		String content = new String();
//		
//		if(head.matches(".*\\|+.*\\||.*") && !head.matches("\\s*|\n*")){
//			content = head.replaceAll("\\|+.*", "");
//			content = content.substring(head.lastIndexOf("<br/>"));
//			title = head.substring(0, head.indexOf("<br/>"));
//		}
//	
		v.setText(Html.fromHtml(contents.get(position)));
		v.setTextColor(res.getColor(R.color.beuthOrgOrange));
		res.finishPreloading();
		return v;
	}

	
}
