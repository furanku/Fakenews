package com.watashiwa.furanku.fakenews.controller.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.watashiwa.furanku.fakenews.R;

public class WebviewActivity extends AppCompatActivity {

	/**
	 * this Webview allows to show the html content
	 */
	private WebView mWebView;

	/**
	 * to get the content from the list
	 */
	private static final String HTML_CONTENT="htmlContent";

	/**
	 * to get the title from the list
	 */
	private static final String TITLE = "title";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);

		/**
		 * getting the title from the list in ListAdapter
		 * @see com.watashiwa.furanku.fakenews.controller.main.ListAdapter
		 */
		String title = getIntent().getStringExtra(TITLE);
		/**
		 * setting the title of each new webview in the toolBar
		 */
		setTitle(title);

		/**
		 * reference the webview with its unique id
		 */
		mWebView = findViewById(R.id.activity_web_view);

		/**
		 * getting the content from the list in ListAdapter
		 * @see ListAdapter
		 */
		String htmlContent = getIntent().getStringExtra(HTML_CONTENT);
		/**
		 * load the specific content in the webwiew
		 */
		mWebView.loadData(htmlContent, "text/html; charset=UTF-8", null);

		/**
		 * this allow to see all the links directly on the webview
		 * need the internet permission
		 */
		mWebView.setWebViewClient(new WebViewClient());

		/**
		 * allow the javascripts on the webview
		 */
		mWebView.getSettings().setJavaScriptEnabled(true);
		}
	}

