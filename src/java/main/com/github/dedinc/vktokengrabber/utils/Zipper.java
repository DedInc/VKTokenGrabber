package com.github.dedinc.vktokengrabber.utils;

import net.lingala.zip4j.ZipFile;

public class Zipper {
	public static void unzip(String zip, String dest) {
	    try {
	         ZipFile zipFile = new ZipFile(zip);
	         zipFile.extractAll(dest);
	       } catch (Exception e) {
        }
    }
}
