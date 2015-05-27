package com.example.newspotalsdemo;

import java.util.ArrayList;

import Model.CustomNewsAdapter;
import Model.NewsItem;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class English_news_Activity extends Activity {

	ListView engListView;

	String[] urlLink;
	String keyword = "keyValue";
	private String[] englishNewsTitle;
	private TypedArray englishNewsIcon;

	CustomNewsAdapter adapter;
	ArrayList<NewsItem> itemList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.english_news_activity);

		engListView = (ListView) findViewById(R.id.englishlistView);

		englishNewsTitle = getResources().getStringArray(
				R.array.english_news_title);
		englishNewsIcon = getResources().obtainTypedArray(
				R.array.english_news_icons);
		itemList = new ArrayList<NewsItem>();

		for (int i = 0; i < englishNewsTitle.length
				&& i < englishNewsIcon.length(); i++) {
			NewsItem allNews = new NewsItem(englishNewsTitle[i],
					englishNewsIcon.getResourceId(i, -1));
			itemList.add(allNews);
		}

		englishNewsIcon.recycle();
		adapter = new CustomNewsAdapter(getApplicationContext(), itemList);
		engListView.setAdapter(adapter);
		urlLink = getResources().getStringArray(R.array.english_news_url);
		engListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				for (int i = 0; i < englishNewsTitle.length; i++) {
					if (position == i) {
						Intent intent = new Intent(getApplicationContext(),
								WebViewActivity.class);
						intent.putExtra(keyword, urlLink[i]);
						startActivity(intent);
					}
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.english_news_, menu);
		return true;
	}

}
