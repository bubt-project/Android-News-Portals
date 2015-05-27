package com.example.newspotalsdemo;

import java.util.ArrayList;

import Model.CustomNewsAdapter;
import Model.NewsItem;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Sport_news_Activity extends Activity {

	ListView sportNewsView;

	String[] urlLink;
	String keyword = "keyValue";
	private String[] sportNewsTitle;
	private TypedArray sportNewsIcon;

	CustomNewsAdapter adapter;
	ArrayList<NewsItem> itemList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.sport_news_activity);

		sportNewsView = (ListView) findViewById(R.id.sport_news_ListView);

		sportNewsTitle = getResources()
				.getStringArray(R.array.sport_news_title);
		sportNewsIcon = getResources().obtainTypedArray(
				R.array.sport_news_icons);
		itemList = new ArrayList<NewsItem>();

		for (int i = 0; i < sportNewsTitle.length && i < sportNewsIcon.length(); i++) {
			NewsItem allNews = new NewsItem(sportNewsTitle[i],
					sportNewsIcon.getResourceId(i, -1));
			itemList.add(allNews);
		}

		sportNewsIcon.recycle();
		adapter = new CustomNewsAdapter(getApplicationContext(), itemList);
		sportNewsView.setAdapter(adapter);

		// set url business link
		urlLink = getResources().getStringArray(R.array.sport_news_url);

		sportNewsView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				for (int i = 0; i < sportNewsTitle.length; i++) {
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
		getMenuInflater().inflate(R.menu.sport_news_, menu);
		return true;
	}

}
