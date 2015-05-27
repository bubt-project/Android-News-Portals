package com.example.newspotalsdemo;

import java.util.ArrayList;

import Model.CustomNewsAdapter;
import Model.NewsItem;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Business_News_Activity extends Activity {

	ListView businessNewsList;

	String[] urlLink;
	String keyword = "keyValue";
	private String[] businessNewsTitle;
	private TypedArray businessNewsIcon;

	CustomNewsAdapter adapter;
	ArrayList<NewsItem> itemList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.business__news_activity);

		businessNewsList = (ListView) findViewById(R.id.business_news_ListView);

		businessNewsTitle = getResources().getStringArray(
				R.array.business_news_title);
		businessNewsIcon = getResources().obtainTypedArray(
				R.array.business_news_icons);
		itemList = new ArrayList<NewsItem>();

		for (int i = 0; i < businessNewsTitle.length
				&& i < businessNewsIcon.length(); i++) {
			NewsItem allBNews = new NewsItem(businessNewsTitle[i],
					businessNewsIcon.getResourceId(i, -1));
			itemList.add(allBNews);
		}

		businessNewsIcon.recycle();
		adapter = new CustomNewsAdapter(getApplicationContext(), itemList);
		businessNewsList.setAdapter(adapter);

		// set url business link
		urlLink = getResources().getStringArray(R.array.business_news_url);

		businessNewsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				switch (position) {
				case 0:
					Intent intent_0 = new Intent(Business_News_Activity.this,
							WebViewActivity.class);
					intent_0.putExtra(keyword, urlLink[0]);
					startActivity(intent_0);
					break;
				case 1:
					Intent intent_1 = new Intent(Business_News_Activity.this,
							WebViewActivity.class);
					intent_1.putExtra(keyword, urlLink[1]);
					startActivity(intent_1);
					break;
				case 2:
					Intent intent_2 = new Intent(Business_News_Activity.this,
							WebViewActivity.class);
					intent_2.putExtra(keyword, urlLink[2]);
					startActivity(intent_2);
					break;
				case 3:
					Intent intent_3 = new Intent(Business_News_Activity.this,
							WebViewActivity.class);
					intent_3.putExtra(keyword, urlLink[3]);
					startActivity(intent_3);
					break;
				case 4:
					Intent intent_4 = new Intent(Business_News_Activity.this,
							WebViewActivity.class);
					intent_4.putExtra(keyword, urlLink[4]);
					startActivity(intent_4);
					break;
				case 5:
					Intent intent_5 = new Intent(Business_News_Activity.this,
							WebViewActivity.class);
					intent_5.putExtra(keyword, urlLink[5]);
					startActivity(intent_5);
					break;
				case 6:
					Intent intent_6 = new Intent(Business_News_Activity.this,
							WebViewActivity.class);
					intent_6.putExtra(keyword, urlLink[6]);
					startActivity(intent_6);
					break;
				case 7:
					Intent intent_7 = new Intent(Business_News_Activity.this,
							WebViewActivity.class);
					intent_7.putExtra(keyword, urlLink[7]);
					startActivity(intent_7);
					break;
				case 8:
					Intent intent_8 = new Intent(Business_News_Activity.this,
							WebViewActivity.class);
					intent_8.putExtra(keyword, urlLink[8]);
					startActivity(intent_8);
					break;
				case 9:
					Intent intent_9 = new Intent(Business_News_Activity.this,
							WebViewActivity.class);
					intent_9.putExtra(keyword, urlLink[9]);
					startActivity(intent_9);
					break;

				default:
					break;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.business__news_, menu);
		return true;
	}

}
