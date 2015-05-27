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

public class Magazine_News_Activity extends Activity {

	ListView engListView;

	String[] urlLink;
	String keyword = "keyValue";
	private String[] magazineNewsTitle;
	private TypedArray magazineNewsIcon;

	CustomNewsAdapter adapter;
	ArrayList<NewsItem> itemList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.magazine__news_activity);

		engListView = (ListView) findViewById(R.id.magazinelistView);

		magazineNewsTitle = getResources().getStringArray(
				R.array.magazine_news_title);
		magazineNewsIcon = getResources().obtainTypedArray(
				R.array.magazine_news_icons);
		itemList = new ArrayList<NewsItem>();

		for (int i = 0; i < magazineNewsTitle.length
				&& i < magazineNewsIcon.length(); i++) {
			NewsItem allnews = new NewsItem(magazineNewsTitle[i],
					magazineNewsIcon.getResourceId(i, -1));
			itemList.add(allnews);
		}

		magazineNewsIcon.recycle();
		adapter = new CustomNewsAdapter(getApplicationContext(), itemList);
		engListView.setAdapter(adapter);
		urlLink = getResources().getStringArray(R.array.magazine_news_url);
		engListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				for (int i = 0; i < magazineNewsTitle.length; i++) {
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
		getMenuInflater().inflate(R.menu.magazine__news_, menu);
		return true;
	}

}
