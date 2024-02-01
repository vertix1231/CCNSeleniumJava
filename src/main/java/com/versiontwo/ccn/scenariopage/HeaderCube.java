package com.versiontwo.ccn.scenariopage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.versiontwo.ccn.driver.DriverSingleton;

public class HeaderCube {
	private WebDriver driver;
	public  HeaderCube() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	private int waitResponse =20000;
	
	@FindBy(xpath="//*[@id=\"toppage\"]/header/div[2]/div[2]/div[2]/div[2]/wc-login/div/div/div")
	@CacheLookup
	private WebElement accountCircleIcon;
	@FindBy(xpath="//div[@id=\"toppage\"]/header/div[2]/div[2]/div[2]/div[2]/wc-login/div/div/div[2]/div[2]/div")
	@CacheLookup
	private List<WebElement> lsMenuAccount;
	
	private void clickAccountCircleIcon() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		accountCircleIcon.click();
	}
	
	public void myMenuAccount(String menu) throws Exception {
		clickAccountCircleIcon();
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		switch (menu) {
		case "My Portal":
			lsMenuAccount.get(0).click();
			break;
		case "My Company":
			lsMenuAccount.get(1).click();
			break;
		case "My Subscriptions":
			lsMenuAccount.get(2).click();
			break;
		case "Coloaders":
			lsMenuAccount.get(3).click();
			break;
		case "Sign Out":
			lsMenuAccount.get(4).click();
			break;

		default:
			break;
		}
	}
}
