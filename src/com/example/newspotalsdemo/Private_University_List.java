package com.example.newspotalsdemo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Private_University_List extends Fragment {

	ListView PrList;

	String[] urlLink;
	String keyword = "keyValue";
	private String[] universityNameList;

	ArrayAdapter<String> adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.private__university_, container,
				false);
		universityNameList = getResources().getStringArray(
				R.array.private_university_list);
		// set url jobs link
		urlLink = getResources().getStringArray(R.array.private_university_url);
		PrList = (ListView) v.findViewById(R.id.private_university_ListView);

		adapter = new ArrayAdapter<String>(getActivity(),
				R.layout.university_list_pattern, R.id.uvname,
				universityNameList);
		PrList.setAdapter(adapter);

		PrList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				for (int i = 0; i < universityNameList.length; i++) {
					if (position == i) {
						Intent intent = new Intent(getActivity(),
								WebViewActivity.class);
						intent.putExtra(keyword, urlLink[i]);
						startActivity(intent);
					}
				}

			}
		});
		return v;
	}
}
