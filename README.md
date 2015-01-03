RSSFeedFragments
==================

RSS Feed Client uses Fragments Android sample

![](https://github.com/app-z/RSSFeedFragments/blob/master/RSSFeedFragments/images/device-2015-01-03-113630.png)


For showing indicator loading list items use method setListShown(false)

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
      ...
	    setListShown(false);

	}

![](https://github.com/app-z/RSSFeedFragments/blob/master/RSSFeedFragments/images/device-2015-01-03-113553.png)

After load list items send notifyDataSetChanged() and call setListShown(true) in UI Thread

  listFragmentAdapter.notifyDataSetChanged();
  setListShown(true);

