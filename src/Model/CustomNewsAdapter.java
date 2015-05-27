package Model;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newspotalsdemo.R;

public class CustomNewsAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<NewsItem> NewsItems = new ArrayList<NewsItem>();

	public CustomNewsAdapter(Context context, ArrayList<NewsItem> newsItems) {
		this.context = context;
		this.NewsItems = newsItems;
	}

	@Override
	public int getCount() {
		return NewsItems.size();
	}

	@Override
	public Object getItem(int position) {
		return NewsItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.news_list_patern, null);
		}
		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.news_icon);
		TextView txtTitle = (TextView) convertView.findViewById(R.id.news_title_style);
		imgIcon.setImageResource(NewsItems.get(position).getIcon());
		txtTitle.setText(NewsItems.get(position).getTitle());
		return convertView;
	}

}
