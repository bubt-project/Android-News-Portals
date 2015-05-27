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

public class Jobs_News_Activity extends Activity {

	ListView jobListView;

	String[] urlLink;
	String keyword = "keyValue";
	private String[] jobsNewsTitle;
	private TypedArray jobsNewsIcon;

	CustomNewsAdapter adapter;
	ArrayList<NewsItem> itemList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.jobs__news_activity);

		jobListView = (ListView) findViewById(R.id.jobs_news_ListView);

		jobsNewsTitle = getResources().getStringArray(R.array.jobs_news_title);
		jobsNewsIcon = getResources().obtainTypedArray(R.array.jobs_news_icons);
		itemList = new ArrayList<NewsItem>();

		itemList.add(new NewsItem(jobsNewsTitle[0], jobsNewsIcon.getResourceId(
				0, -1)));
		itemList.add(new NewsItem(jobsNewsTitle[1], jobsNewsIcon.getResourceId(
				1, -1)));
		itemList.add(new NewsItem(jobsNewsTitle[2], jobsNewsIcon.getResourceId(
				2, -1)));
		itemList.add(new NewsItem(jobsNewsTitle[3], jobsNewsIcon.getResourceId(
				3, -1)));

		jobsNewsIcon.recycle();
		adapter = new CustomNewsAdapter(getApplicationContext(), itemList);
		jobListView.setAdapter(adapter);

		// set url jobs link
		urlLink = getResources().getStringArray(R.array.jobs_news_url);

		jobListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				switch (position) {
				case 0:
					Intent bd_jobs = new Intent(Jobs_News_Activity.this,
							WebViewActivity.class);
					bd_jobs.putExtra(keyword, urlLink[0]);
					startActivity(bd_jobs);
					break;
				case 1:
					Intent prothom_alo_jobs = new Intent(
							Jobs_News_Activity.this, WebViewActivity.class);
					prothom_alo_jobs.putExtra(keyword, urlLink[1]);
					startActivity(prothom_alo_jobs);
					break;
				case 2:
					Intent noyadigonta_job_potals = new Intent(
							Jobs_News_Activity.this, WebViewActivity.class);
					noyadigonta_job_potals.putExtra(keyword, urlLink[1]);
					startActivity(noyadigonta_job_potals);
					break;
				case 3:
					Intent chakir_online = new Intent(Jobs_News_Activity.this,
							WebViewActivity.class);
					chakir_online.putExtra(keyword, urlLink[2]);
					startActivity(chakir_online);
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
		getMenuInflater().inflate(R.menu.jobs__news_, menu);
		return true;
	}

}
