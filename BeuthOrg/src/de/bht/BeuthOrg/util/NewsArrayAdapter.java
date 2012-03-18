package de.bht.BeuthOrg.util;

import de.bht.BeuthOrg.R;
import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsArrayAdapter extends ArrayAdapter<String> {

	private final String LINK_FIRST = "http://fb6.beuth-hochschule.de";
	
	String[] contents;
	Resources res;
	
	public NewsArrayAdapter(Context context, int resource,
			String[] contentsNews, Resources resources) {
		super(context, resource, contentsNews);
		this.contents = contentsNews;
		this.res = resources;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		TextView v = (TextView) super.getView(position, convertView, parent);
		TextView headV = new TextView(getContext());
		String head= contents[position].replaceFirst("[a-zA-Z\\s]+", "ab: ");
		String linklast = new String();
		String title = new String();
		String content = new String();
		
		head = head.replace("MEZ\">", " bis: ");
		head = head.replaceFirst("\\|+", " von: ");
		head = head.replaceAll("\">.*", "");
		head = head.replaceAll("<a.*=\"", "LinkNews");
		head = head.replaceFirst("\\|+", "</br>");
		
		
		
		if(head.matches(".*\\|+.*\\||.*") && !head.matches("\\s*|\n*")){
			content = head.replaceAll("\\|+.*", "");
			content = content.substring(head.lastIndexOf("</br>"));
			linklast = head.substring(head.lastIndexOf("LinkNews"));
			Log.w("news", "content " + content);
			title = head.substring(0, head.indexOf("</br>"));
			Log.w("news", "title " + title);
		}
		
		
		//Log.w("news", head);
//		if(linklast == null){
//			v.setText(Html.fromHtml(head));
//			return v;
//		}
		v.setText(Html.fromHtml("<font color=\"#ffa60a\">"+ title+ "</font> "+ content));
		v.setTextColor(res.getColor(R.color.beuthOrgTextColor));
		
		return v;
	}

	
}
