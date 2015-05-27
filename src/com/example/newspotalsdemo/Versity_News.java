package com.example.newspotalsdemo;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Versity_News extends Activity {

	ActionBar actionBar;
	Public_Unversity_List public_university;
	Private_University_List private_university;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.versity__news);

		setTab();
	}

	public void setTab() {
		public_university = new Public_Unversity_List();
		private_university = new Private_University_List();
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		ActionBar.Tab first = actionBar.newTab();
		ActionBar.Tab second = actionBar.newTab();

		first.setText("Private");
		second.setText("Public");

		first.setTabListener(new MytabListener());
		second.setTabListener(new MytabListener());

		actionBar.addTab(first);
		actionBar.addTab(second);
	}

	class MytabListener implements TabListener {

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			if (tab.getPosition() == 0) {
				ft.replace(android.R.id.content, private_university);
			} else if (tab.getPosition() == 1) {
				ft.replace(android.R.id.content, public_university);
			}
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}

	}

	

}
