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

public class Bangla_news_Activity extends Activity {

	ListView banglaListView;

	String[] urlLink;
	String keyword = "keyValue";
	private String[] banglaNewsTitle;
	private TypedArray banglaNewsIcon;

	CustomNewsAdapter adapter;
	ArrayList<NewsItem> itemList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.bangla_news_activity);

		banglaListView = (ListView) findViewById(R.id.banglistView);

		banglaNewsTitle = getResources().getStringArray(
				R.array.bangla_news_title);
		banglaNewsIcon = getResources().obtainTypedArray(
				R.array.bangla_news_icon);
		itemList = new ArrayList<NewsItem>();

		for (int i = 0; i < banglaNewsTitle.length
				&& i < banglaNewsIcon.length(); i++) {
			NewsItem allnews = new NewsItem(banglaNewsTitle[i],
					banglaNewsIcon.getResourceId(i, -1));
			itemList.add(allnews);
		}

		banglaNewsIcon.recycle();
		adapter = new CustomNewsAdapter(getApplicationContext(), itemList);
		banglaListView.setAdapter(adapter);
		urlLink = getResources().getStringArray(R.array.bangla_news_url);
		banglaListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				for (int i = 0; i < banglaNewsTitle.length; i++) {
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

		getMenuInflater().inflate(R.menu.new_, menu);
		return true;
	}

}
