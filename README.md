RSSFeedFragments
==================

RSS Feed Client uses Fragments Android sample

![](https://github.com/app-z/RSSFeedFragments/blob/master/RSSFeedFragments/images/device-2015-01-03-113630.png)


For showing progress indicator when list is loading used setListShown(false)

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
      ...
	    setListShown(false);

	}

![](https://github.com/app-z/RSSFeedFragments/blob/master/RSSFeedFragments/images/device-2015-01-03-113553.png)

When list was loaded send notifyDataSetChanged() and call setListShown(true) in UI Thread

  listFragmentAdapter.notifyDataSetChanged();
  setListShown(true);

![](https://github.com/app-z/RSSFeedFragments/blob/master/RSSFeedFragments/images/device-2015-01-03-113614.png)

Click on Item and load detail through using WebView

![](https://github.com/app-z/RSSFeedFragments/blob/master/RSSFeedFragments/images/device-2015-01-03-113630.png)
