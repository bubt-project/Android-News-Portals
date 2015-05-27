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

public class Public_Unversity_List extends Fragment {
	ListView publicLV;

	String[] urlLink;
	String keyword = "keyValue";
	private String[] universityNameList;

	ArrayAdapter<String> adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.public__unversity__list,
				container, false);
		universityNameList = getResources().getStringArray(
				R.array.public_university_list);

		// set url

		urlLink = getResources().getStringArray(R.array.public_university_url);

		publicLV = (ListView) view
				.findViewById(R.id.public_university_ListView);

		adapter = new ArrayAdapter<String>(getActivity(),
				R.layout.university_list_pattern, R.id.uvname,
				universityNameList);
		publicLV.setAdapter(adapter);

		publicLV.setOnItemClickListener(new OnItemClickListener() {

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

		return view;
	}

}
