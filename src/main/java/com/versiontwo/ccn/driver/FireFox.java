package com.versiontwo.ccn.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox implements DriverStrategy {

	public WebDriver setStrategy() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver",projectPath+ "/src/test/resources/drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
