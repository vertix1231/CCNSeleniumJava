package com.versiontwo.ccn.scenariopage;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.versiontwo.ccn.driver.DriverSingleton;
import com.versiontwo.ccn.utils.Constants;

public class Sqpp {
	private WebDriver driver;

	public Sqpp() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	private int waitResponse = 2000;
	public String sqppwindows = "";
	public String originsqppwindows = "";

	@FindBy(xpath = "//*[@id=\"pageHeader\"]/div/div/div[3]/div/div[2]/wc-login/div/button")
	@CacheLookup
	private WebElement loginsqpp;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/button[3]")
	@CacheLookup
	private WebElement acceptcookiesqpp;

	// login
	@FindBy(xpath = "//*[@id=\"signInName\"]")
	@CacheLookup
	private WebElement emailsignin;

	@FindBy(xpath = "//*[@id=\"password\"]")
	@CacheLookup
	private WebElement passwordsignin;

	@FindBy(xpath = "//*[@id=\"next\"]")
	@CacheLookup
	private WebElement nextsigninone;

	@FindBy(xpath = "//*[@id=\"readOnlyEmail_ver_but_send\"]")
	@CacheLookup
	private WebElement sendverifcode;

	@FindBy(xpath = "//*[@id=\"readOnlyEmail_ver_input\"]")
	@CacheLookup
	private WebElement inputverifcode;
	
	@FindBy(xpath = "//*[@id=\"readOnlyEmail_ver_but_verify\"]")
	@CacheLookup
	private WebElement verifycode;
	
	@FindBy(xpath = "//*[@id=\"email_ver_but_verify\"]")
	@CacheLookup
	private WebElement verifycoderegis;

	@FindBy(xpath = "//*[@id=\"continue\"]")
	@CacheLookup
	private WebElement continuesignin;

	// accces sqpp
	// *[@id="pageHeader"]/div/div/div[3]/div/div[2]/wc-login/div/div/div icon menu
	// *[@id="pageHeader"]/div/div/div[3]/div/div[2]/wc-login/div/div/div[2]/div[2]/div/a/span
	// list icon menu except sign out
	// *[@id="wrapper"]/div/section/div/div/agent-management//div/div/div/div[2]/div/div/div[2]/div/form/div/input
	// search agent code in agent management

	public void loginsqpp() throws Exception {
		Thread.sleep(waitResponse);
		acceptcookiesqpp.click();
		Thread.sleep(waitResponse);
		loginsqpp.click();
		Thread.sleep(waitResponse);

	}

	public void changeSigninWindowsqpp() {
		originsqppwindows = driver.getWindowHandle();
		sqppwindows = driver.getWindowHandle();
		Set<String> loginwindows = driver.getWindowHandles();
		for (String windowHandle : loginwindows) {
			if (!sqppwindows.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				sqppwindows = windowHandle;
				break;
			}
		}
	}

	public void inputloginsqpp(String email, String password) throws Exception {
		Thread.sleep(waitResponse);
//		emailsignin.sendKeys("testbrancha_member_12@yopmail.com");
		emailsignin.sendKeys(email);
		Thread.sleep(waitResponse);
//		passwordsignin.sendKeys("P@55w0rd");
		passwordsignin.sendKeys(password);
		Thread.sleep(waitResponse);
		nextsigninone.click();
		Thread.sleep(waitResponse);
		sendverifcode.click();

	}

	By emailVerification = By.xpath(
			"//*[@id=\"mail\"]/div/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td[3]/table/tbody/tr/td/table/tbody/tr/td/div[2]/span");

	public void getVerificationCodesqpp() {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("ifmail");
		String getEmailText = driver.findElement(emailVerification).getText();
		Constants.VERIFICATION_CODE_SQPP = StringUtils.getDigits(getEmailText);
//		driver.close();
//		driver.switchTo().window(sqppwindows);
	}

	public void inputverifcodeaftergetfromemail() throws Exception {
		Thread.sleep(waitResponse);
		inputverifcode.sendKeys(Constants.VERIFICATION_CODE_SQPP);
		Thread.sleep(waitResponse);
		verifycode.click();
	}

	public void continuesigninsqpp() throws Exception {
		Thread.sleep(waitResponse);
		continuesignin.click();
	}

	@FindBy(xpath = "//*[@id=\"createAccount\"]")
	@CacheLookup
	private WebElement signupsqpp;

	@FindBy(xpath = "//*[@id=\"email\"]")
	@CacheLookup
	private WebElement inputemailsqpp;

	@FindBy(xpath = "//*[@id=\"email_ver_but_send\"]")
	@CacheLookup
	private WebElement sendverifcoderegister;

	@FindBy(xpath = "//*[@id=\"email_ver_input\"]")
	@CacheLookup
	private WebElement inputverifcodesqppregister;

	@FindBy(xpath = "//*[@id=\"newPassword\"]")
	@CacheLookup
	private WebElement passwordregis;

	@FindBy(xpath = "//*[@id=\"reenterPassword\"]")
	@CacheLookup
	private WebElement confirmpasswordregis;

	@FindBy(xpath = "//*[@id=\"displayName\"]")
	@CacheLookup
	private WebElement displayname;

	@FindBy(xpath = "//*[@id=\"extension_AgentCode\"]")
	@CacheLookup
	private WebElement agentcode;

	@FindBy(xpath = "//*[@id=\"city\"]")
	@CacheLookup
	private WebElement selectelementforcity;

	@FindBy(xpath = "//*[@id=\"extension_CountryCode\"]")
	@CacheLookup
	private WebElement selectelementforcountry;

	@FindBy(xpath = "//*[@id=\"extension_TermsOfUseConsented_AgreeToTermsOfUseConsentYes\"]")
	@CacheLookup
	private WebElement checkboxregissqpp;

	@FindBy(xpath = "//*[@id=\"continue\"]")
	@CacheLookup
	private WebElement contiunueregis;
	
	

	@FindBy(xpath = "//*[@id=\"pageHeader\"]/div/div/div[3]/div/div[2]/wc-login/div/div/div")
	@CacheLookup
	private WebElement iconmenusqpp;

	public void signupsqpp(String email) throws Exception {
		Thread.sleep(waitResponse);
		signupsqpp.click();
		inputemailsqpp.sendKeys(email);
		sendverifcoderegister.click();
	}

	public void inputverifcodeaftergetfromemailregis() throws Exception {
		Thread.sleep(waitResponse);
		inputverifcodesqppregister.sendKeys(Constants.VERIFICATION_CODE_SQPP);
		Thread.sleep(waitResponse);
		verifycoderegis.click();
		Thread.sleep(waitResponse);
		passwordregis.sendKeys(Constants.PASSWORD);
		
		Thread.sleep(waitResponse);
		confirmpasswordregis.sendKeys(Constants.PASSWORD);
		
		Thread.sleep(waitResponse);
		displayname.sendKeys(Constants.DISPLAY_NAME);
		
		Thread.sleep(waitResponse);
		agentcode.sendKeys("325364645");
		
		Thread.sleep(waitResponse);

		Select selectcity = new Select(selectelementforcity);
		selectcity.selectByVisibleText("SINGAPORE");

		Thread.sleep(waitResponse);

		Select selectCountry = new Select(selectelementforcountry);
		selectCountry.selectByVisibleText("Singapore");

		Thread.sleep(waitResponse);
		checkboxregissqpp.click();
		Thread.sleep(waitResponse);
		contiunueregis.click();
		Thread.sleep(waitResponse);
	}
	
	public void iconmenusqpp() throws Exception {
		Thread.sleep(waitResponse);
		iconmenusqpp.click();
	}
}
