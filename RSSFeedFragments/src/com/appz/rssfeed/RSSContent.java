package com.appz.rssfeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pkmmte.pkrss.PkRSS;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class RSSContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<RSSItem> ITEMS = new ArrayList<RSSItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<Integer, RSSItem> ITEM_MAP = new HashMap<Integer, RSSItem>();

	public static void addItem(RSSItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class RSSItem {
		public int id;
		public String author;
		public String content;
		public String url;

		public RSSItem(int id, String author, String content, String url) {
			this.id = id;
			this.author = author;
			this.content = content;
			this.url = url;
		}

		@Override
		public String toString() {
			return author;
		}
	}
}
