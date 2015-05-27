package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.newspotalsdemo.R;

public class InternationalAdapter extends BaseAdapter {

	LayoutInflater inflater;
	private Context mcontext;
	private List<InNewItem> allList = null;
	private ArrayList<InNewItem> newsItems = new ArrayList<InNewItem>();

	public InternationalAdapter(Context context, ArrayList<InNewItem> newslist) {
		mcontext = context;
		this.allList = newslist;
		inflater = LayoutInflater.from(mcontext);
		this.newsItems.addAll(newslist);
	}

	public class ViewHolder {
		TextView title;
		TextView state;
	}

	@Override
	public int getCount() {
		return allList.size();
	}

	@Override
	public InNewItem getItem(int position) {
		return allList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.international_news_patern,
					null);
			holder.title = (TextView) convertView.findViewById(R.id.text_title);
			holder.state = (TextView) convertView.findViewById(R.id.text_state);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.title.setText(allList.get(position).getTitle());
		holder.state.setText(allList.get(position).getState());

		return convertView;
	}

	// Filter Class
	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		allList.clear();
		if (charText.length() == 0) {
			allList.addAll(newsItems);
		} else {
			for (InNewItem wp : newsItems) {
				if (wp.getTitle().toLowerCase(Locale.getDefault())
						.contains(charText)) {
					allList.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}
	// Filter Class

}
