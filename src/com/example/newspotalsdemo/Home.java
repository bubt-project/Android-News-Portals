package com.example.newspotalsdemo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Home extends Fragment implements OnTouchListener {

	Button btnBanglaNews, btnEnglishNews, btnMagazine, btnJobNews,
			btnSportNews, btnBusinessNews, btnVersityNews, btnInternationNews;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.home_fragment, container, false);
		btnBanglaNews = (Button) v.findViewById(R.id.btn_bangla_news);
		btnEnglishNews = (Button) v.findViewById(R.id.btn_english_news);
		btnMagazine = (Button) v.findViewById(R.id.btn_magazine_news);
		btnJobNews = (Button) v.findViewById(R.id.btn_jobs_news);
		btnSportNews = (Button) v.findViewById(R.id.btn_sport_news);
		btnBusinessNews = (Button) v.findViewById(R.id.btn_business_news);
		btnVersityNews = (Button) v.findViewById(R.id.btn_university_news);
		btnInternationNews = (Button) v
				.findViewById(R.id.btn_international_news);

		btnBanglaNews.setOnTouchListener(this);
		btnEnglishNews.setOnTouchListener(this);
		btnMagazine.setOnTouchListener(this);
		btnJobNews.setOnTouchListener(this);
		btnSportNews.setOnTouchListener(this);
		btnBusinessNews.setOnTouchListener(this);

		btnVersityNews.setOnTouchListener(this);
		btnInternationNews.setOnTouchListener(this);

		return v;

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (v.getId()) {
		case R.id.btn_bangla_news:
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				btnBanglaNews.getBackground().setAlpha(100);
				break;
			case MotionEvent.ACTION_UP:
				Intent bangla_news_intent = new Intent(getActivity(),
						Bangla_news_Activity.class);
				startActivity(bangla_news_intent);
				btnBanglaNews.getBackground().setAlpha(255);
				break;
			default:
				break;
			}

			break;
		case R.id.btn_english_news:
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				btnEnglishNews.getBackground().setAlpha(100);
				break;
			case MotionEvent.ACTION_UP:
				Intent english_news_intent = new Intent(getActivity(),
						English_news_Activity.class);
				startActivity(english_news_intent);
				btnEnglishNews.getBackground().setAlpha(255);
				break;
			default:
				break;
			}

			break;
		case R.id.btn_magazine_news:
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				btnMagazine.getBackground().setAlpha(100);
				break;
			case MotionEvent.ACTION_UP:
				Intent magazine_intent = new Intent(getActivity(),
						Magazine_News_Activity.class);
				startActivity(magazine_intent);
				btnMagazine.getBackground().setAlpha(255);
				break;
			default:
				break;
			}

			break;
		case R.id.btn_jobs_news:
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				btnJobNews.getBackground().setAlpha(100);
				break;
			case MotionEvent.ACTION_UP:
				Intent jobs_news_intent = new Intent(getActivity(),
						Jobs_News_Activity.class);
				startActivity(jobs_news_intent);
				btnJobNews.getBackground().setAlpha(255);
				break;
			default:
				break;
			}

			break;
		case R.id.btn_sport_news:
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				btnSportNews.getBackground().setAlpha(100);
				break;
			case MotionEvent.ACTION_UP:
				Intent sport_news_intent = new Intent(getActivity(),
						Sport_news_Activity.class);
				startActivity(sport_news_intent);
				btnSportNews.getBackground().setAlpha(255);
				break;
			default:
				break;
			}

			break;
		case R.id.btn_business_news:

			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				btnBusinessNews.getBackground().setAlpha(100);
				break;
			case MotionEvent.ACTION_UP:
				Intent business_news_intent = new Intent(getActivity(),
						Business_News_Activity.class);
				startActivity(business_news_intent);
				btnBusinessNews.getBackground().setAlpha(255);
				break;
			default:
				break;
			}

			break;
		case R.id.btn_university_news:
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				btnVersityNews.getBackground().setAlpha(100);
				break;
			case MotionEvent.ACTION_UP:
				Intent university = new Intent(getActivity(),
						Versity_News.class);
				startActivity(university);
				btnVersityNews.getBackground().setAlpha(255);
				break;
			default:
				break;
			}

			break;
		case R.id.btn_international_news:
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				btnInternationNews.getBackground().setAlpha(100);
				break;
			case MotionEvent.ACTION_UP:
				Intent international_news = new Intent(getActivity(),
						Interntaional_News_Activity.class);
				startActivity(international_news);
				btnInternationNews.getBackground().setAlpha(255);
				break;
			default:
				break;
			}

			break;

		default:
			break;
		}
		return false;
	}
	
	

}
