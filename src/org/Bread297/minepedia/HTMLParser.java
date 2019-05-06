package org.Bread297.minepedia;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser {
	
	public static void getSearchResults() {
		File input = new File("\\plugins\\Minepedia\\index.html");
			try {
				Document doc = Jsoup.parse(input, "UTF-8");
				Element body = doc.body();
				Elements globalWrapper = body.select("div#global-wrapper");
				Elements pageWrapper = globalWrapper.select("div#page-wrapper");
				Elements content = pageWrapper.select("div#content");
				Elements bodyContent = content.select("div#bodyContent");
				Elements contentText = bodyContent.select("div#mw-content-text");
				Elements searchResults = contentText.select("div.searchresults");
				Elements ulResults = searchResults.select("ul.mw-search-results");
				Elements liList = ulResults.select("li");
				Elements resultHeading = liList.select("div.mw-search-result-heading");
				Elements aList = resultHeading.select("a");
				int i = 0;
				String[] results = null;
				for(Element a : aList) {
					
				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
		
		
		
		
	}
	
	
}
