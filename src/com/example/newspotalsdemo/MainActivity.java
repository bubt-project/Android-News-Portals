package com.example.newspotalsdemo;

import java.util.ArrayList;

import Model.NavDrawerItem;
import Model.NavDrawerListAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

@SuppressLint("Recycle")
public class MainActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDraListView;
	String keyword = "keyValue";
	String[] url;
	// nav drawer title
	private CharSequence mDrawerTitle;

	private CharSequence mTitle;

	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ActionBarDrawerToggle mActionBarDrawerToggle;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		setContentView(R.layout.activity_main);

		mTitle = mDrawerTitle = getTitle();
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDraListView = (ListView) findViewById(R.id.list_slidermenu);
		navDrawerItems = new ArrayList<NavDrawerItem>();

		url = getResources().getStringArray(R.array.home_url);

		for (int i = 0; i < navMenuTitles.length && i < navMenuIcons.length(); i++) {
			NavDrawerItem allItems = new NavDrawerItem(navMenuTitles[i],
					navMenuIcons.getResourceId(i, -1));
			navDrawerItems.add(allItems);
		}

		navMenuIcons.recycle();
		mDraListView.setOnItemClickListener(new SliderMenuClickListener());
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDraListView.setAdapter(adapter);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {
			public void onDrawerClosed(View v) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View v) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
		if (savedInstanceState == null) {
			displayView(0);
		}
	}

	private class SliderMenuClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			displayView(position);
		}

	}

	private void displayView(int position) {
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new Home();
			break;
		case 1:
			Intent bangla = new Intent(MainActivity.this,
					Bangla_news_Activity.class);
			startActivity(bangla);
			break;
		case 2:
			Intent english = new Intent(MainActivity.this,
					English_news_Activity.class);
			startActivity(english);
			break;
		case 3:
			Intent magazine = new Intent(MainActivity.this,
					Magazine_News_Activity.class);
			startActivity(magazine);
			break;
		case 4:
			Intent jobs = new Intent(MainActivity.this,
					Jobs_News_Activity.class);
			startActivity(jobs);
			break;
		case 5:
			Intent sport = new Intent(MainActivity.this,
					Sport_news_Activity.class);
			startActivity(sport);
			break;
		case 6:
			Intent business = new Intent(MainActivity.this,
					Business_News_Activity.class);
			startActivity(business);
			break;
		case 7:
			Intent versity = new Intent(MainActivity.this, Versity_News.class);
			startActivity(versity);
			break;
		case 8:
			Intent international = new Intent(MainActivity.this,
					Interntaional_News_Activity.class);
			startActivity(international);
			break;
		case 9:
			Intent about = new Intent(MainActivity.this, AboutActivity.class);
			startActivity(about);
		default:
			break;
		}
		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();
			mDraListView.setItemChecked(position, true);
			mDraListView.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDraListView);

		} else {
			Log.e("MainActivity", "Error in create fragment");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		case R.id.menu_facebook:
			Intent fb = new Intent(getApplicationContext(),
					WebViewActivity.class);
			fb.putExtra(keyword, url[0]);
			startActivity(fb);
		case R.id.menu_twitter:
			Intent tw = new Intent(getApplicationContext(),
					WebViewActivity.class);
			tw.putExtra(keyword, url[1]);
			startActivity(tw);
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDraListView);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mActionBarDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mActionBarDrawerToggle.onConfigurationChanged(newConfig);
	}

}
