package org.Bread297.minepedia;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.bukkit.Bukkit;

public class HttpRequester {
	
	private static final String path = Bukkit.getServer().getPluginManager().getPlugin("Minepedia").getDataFolder().getPath();
	
	public static int makeRequest(String URL) {
		try {
			URL url = new URL(URL);
			InputStream is = url.openStream();
			downloadHtml(is);
		} catch (MalformedURLException e) {
			return 1;
		} catch (IOException e) {
			return 2;
		}
		return 0;
	}
	
	private static void downloadHtml(InputStream is) {
		Bukkit.broadcastMessage(path + "\\index.html");
		try(BufferedInputStream input = new BufferedInputStream(is); FileOutputStream fileStream = new FileOutputStream(path + "\\index.html")) {
			byte buffer[] = new byte[1024];
			int alreadyRead;
			while((alreadyRead = is.read(buffer, 0, 1024)) != -1) {
				fileStream.write(buffer, 0 , alreadyRead);
			}
		} catch(IOException e) {
			return;
		}
	}
	
	
	
}
