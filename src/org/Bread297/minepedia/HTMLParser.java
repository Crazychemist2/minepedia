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
			Elements results = doc.getElementsByTag("a");
			for(Element result : results) {
				String resultText = result.attr("title");
				Bukkit.broadcastMessage(resultText);
			}
		} catch (IOException e) {
			return;
		}
		
		
		
		
	}
	
	
}
