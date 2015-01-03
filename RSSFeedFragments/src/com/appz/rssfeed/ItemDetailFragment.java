package com.appz.rssfeed;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * A fragment representing a single Item detail screen. This fragment is either
 * contained in a {@link ItemListActivity} in two-pane mode (on tablets) or a
 * {@link ItemDetailActivity} on handsets.
 */
public class ItemDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	protected static final String TAG = "ItemDetailFragment>";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private RSSContent.RSSItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ItemDetailFragment() {
		
		
	}

	private WebView webView;
	TextView text;
	ProgressBar progress;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = RSSContent.ITEM_MAP.get(getArguments().getInt(
					ARG_ITEM_ID));
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_item_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			text = (TextView) rootView.findViewById(R.id.item_detail);
			text.setText(mItem.author + ": " + mItem.content);
			progress = (ProgressBar) rootView.findViewById(R.id.progress);
			webView = (WebView) rootView.findViewById(R.id.webview);
			loadWebViewMap(mItem.url);
		}

		return rootView;
	}
	
	@Override
	public void onDestroyView(){
		webView.stopLoading();
		super.onDestroyView();
	}


	/*
	 * 
	 * 
	 * 
	 */
	private void loadWebViewMap(String url) {

		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

		webView.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				Log.i(TAG, "Processing webview url ...");
				view.loadUrl(url);
				return true;
			}

			public void onPageFinished(WebView view, String url) {
				Log.i(TAG, "Finished loading URL: " + url);
				text.setVisibility(View.GONE);
				progress.setVisibility(View.GONE);
				webView.setVisibility(View.VISIBLE);
				//slideToTop(webView);
			}

			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Log.e(TAG, "Error: " + description);
			}
		});
		webView.loadUrl(url);

	}
}
