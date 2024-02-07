package com.versiontwo.ccn.scenariopage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.versiontwo.ccn.driver.DriverSingleton;

public class Sqpp {
	private WebDriver driver;
	public  Sqpp() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	private int waitResponse =1000;
	
	@FindBy(xpath="//*[@id=\"pageHeader\"]/div/div/div[3]/div/div[2]/wc-login/div/button")
	@CacheLookup
	private WebElement loginsqpp;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/button[3]")
	@CacheLookup
	private WebElement acceptcookiesqpp;
	
	public void loginsqpp() throws Exception {
		Thread.sleep(waitResponse);
		loginsqpp.click();
	}
	
}
