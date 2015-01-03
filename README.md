RSSFeedFragments
==================

RSS Feed Client uses Fragments Android sample

Features
* Pkrss - RSS feed manager for Android
* WebView



![](https://github.com/app-z/RSSFeedFragments/blob/master/RSSFeedFragments/images/device-2015-01-03-113639.png)


Code loads the specified URL asynchronously

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		PkRSS.with(getActivity()).load(url).callback(this).async();
		...	

	}



For showing progress indicator when list is loading used setListShown(false)

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
      ...
	    setListShown(false);
	}

![](https://github.com/app-z/RSSFeedFragments/blob/master/RSSFeedFragments/images/device-2015-01-03-113553.png)

When list was loaded send notifyDataSetChanged() and call setListShown(true) in UI Thread

    @Override
    public void run() {
    	listFragmentAdapter.notifyDataSetChanged();
	    setListShown(true);
    }
  

![](https://github.com/app-z/RSSFeedFragments/blob/master/RSSFeedFragments/images/device-2015-01-03-113614.png)

Click on Item and load detail through using WebView

![](https://github.com/app-z/RSSFeedFragments/blob/master/RSSFeedFragments/images/device-2015-01-03-113630.png)

=================

The MIT License

Copyright (c) 2014 Appz (http://app-z.net)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
