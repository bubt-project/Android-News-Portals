package com.example.newspotalsdemo;

import Model.ConnectDetect;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends Activity {

	private WebView webView;
	String keyword = "keyValue";
	String getUrl;
	WebClientCreate webClientCreate;

	String TAG = "this is website";

	ConnectDetect connectDetect;
	boolean connection = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_web_view);
		connectDetect = new ConnectDetect(getApplicationContext());
		Log.i(TAG, "Create");
		webView = (WebView) findViewById(R.id.webView);
		getUrl = getIntent().getStringExtra(keyword);
		webView.getSettings().setSupportZoom(true);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		webView.setPadding(0, 0, 0, 0);

		connection = connectDetect.isNetworkAvailable();

		if (connection) {
			webClientCreate = new WebClientCreate();
			webClientCreate.startWebview(getUrl);

		} else {
			Toast.makeText(getApplicationContext(), "no internect connection",
					Toast.LENGTH_LONG).show();
		}

	}

	class WebClientCreate extends WebViewClient {
		@SuppressLint("SetJavaScriptEnabled")
		private void startWebview(String url) {
			webView.setWebViewClient(new WebViewClient() {
				ProgressDialog pDialog;

				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					view.loadUrl(url);
					return true;
				}

				public void onLoadResource(WebView view, String url) {
					if (pDialog == null) {
						pDialog = new ProgressDialog(WebViewActivity.this);
						pDialog.setMessage("Loading.......");
						pDialog.show();
					}
				}

				public void onPageFinished(WebView v, String url) {
					try {
						if (pDialog.isShowing()) {
							pDialog.dismiss();
							pDialog = null;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

			webView.getSettings().setJavaScriptEnabled(true);
			webView.loadUrl(url);

		}

	}

	@Override
	public void onBackPressed() {
		if (webView.canGoBack()) {
			webView.goBack();
		} else {
			super.onBackPressed();
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart");
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		webView.saveState(outState);
		Log.i(TAG, "onSaveInstanceState");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		webView.restoreState(savedInstanceState);
		Log.i(TAG, "onRestoreInstanceState");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.home:
			Intent intent = new Intent(WebViewActivity.this, MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;

		}
		return true;
	}

}
