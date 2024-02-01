package com.versiontwo.ccn.scenariopage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.versiontwo.ccn.driver.DriverSingleton;

public class SubscriptionBundlePage {
	private WebDriver driver;
	public SubscriptionBundlePage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath="//*[@id=\"menu-item-629\"]/span/a")
//	@CacheLookup
//	private WebElement productTab;
//	
//	public void clickProductTab() {
//		productTab.click();
//	}
}
