package com.versiontwo.ccn.scenariopage;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.versiontwo.ccn.driver.DriverSingleton;
import com.versiontwo.ccn.utils.Constants;

public class MailServiceMailinatorPage {
	private WebDriver driver;
	public MailServiceMailinatorPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	By txtSearch = By.id("search");
	By emailOnLists = By.xpath("//td[contains(.,'CUBEforall by CCN account email verification code')]");
	By emailVerification = By.xpath("//span[@id='BodyPlaceholder_UserVerificationEmailBodySentence2']");
	
	public void getVerificationCode(){
		// search mail on mailinator
		driver.findElement(txtSearch).clear();
		driver.findElement(txtSearch).sendKeys(Constants.FULL_EMAIL, Keys.ENTER);
		// press or expand the email
		driver.findElement(emailOnLists).isDisplayed();
		driver.findElement(emailOnLists).click();
		// get text email verification and extract the verification code
		driver.switchTo().frame("html_msg_body");
		String getEmailText = driver.findElement(emailVerification).getText();
		Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
	}
	public void getVerificationCodelogin(){
		// search mail on mailinator
		driver.findElement(txtSearch).clear();
		driver.findElement(txtSearch).sendKeys(Constants.FULL_EMAIL_AFTER_LOGIN, Keys.ENTER);
		// press or expand the email
		driver.findElement(emailOnLists).isDisplayed();
		driver.findElement(emailOnLists).click();
		// get text email verification and extract the verification code
		driver.switchTo().frame("html_msg_body");
		String getEmailText = driver.findElement(emailVerification).getText();
		Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
	}
	public void getVerificationCodesg(){
		// search mail on mailinator
		driver.findElement(txtSearch).clear();
		driver.findElement(txtSearch).sendKeys(Constants.FULL_EMAIL_SG, Keys.ENTER);
		// press or expand the email
		driver.findElement(emailOnLists).isDisplayed();
		driver.findElement(emailOnLists).click();
		// get text email verification and extract the verification code
		driver.switchTo().frame("html_msg_body");
		String getEmailText = driver.findElement(emailVerification).getText();
		Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
	}
	
    public void getVerificationCodemy(){
	// search mail on mailinator
	driver.findElement(txtSearch).clear();
	driver.findElement(txtSearch).sendKeys(Constants.FULL_EMAIL_MY, Keys.ENTER);
	// press or expand the email
	driver.findElement(emailOnLists).isDisplayed();
	driver.findElement(emailOnLists).click();
	// get text email verification and extract the verification code
	driver.switchTo().frame("html_msg_body");
	String getEmailText = driver.findElement(emailVerification).getText();
	Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
}

public void getVerificationCodeuae(){
	// search mail on mailinator
	driver.findElement(txtSearch).clear();
	driver.findElement(txtSearch).sendKeys(Constants.FULL_EMAIL_UAE, Keys.ENTER);
	// press or expand the email
	driver.findElement(emailOnLists).isDisplayed();
	driver.findElement(emailOnLists).click();
	// get text email verification and extract the verification code
	driver.switchTo().frame("html_msg_body");
	String getEmailText = driver.findElement(emailVerification).getText();
	Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
}
	public void getVerificationCodech(){
		// search mail on mailinator
		driver.findElement(txtSearch).clear();
		driver.findElement(txtSearch).sendKeys(Constants.FULL_EMAIL_CH, Keys.ENTER);
		// press or expand the email
		driver.findElement(emailOnLists).isDisplayed();
		driver.findElement(emailOnLists).click();
		// get text email verification and extract the verification code
		driver.switchTo().frame("html_msg_body");
		String getEmailText = driver.findElement(emailVerification).getText();
		Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
	}
	public void getVerificationCode(String email){
		// search mail on mailinator
		driver.findElement(txtSearch).clear();
		driver.findElement(txtSearch).sendKeys(email, Keys.ENTER);
		// press or expand the email
		driver.findElement(emailOnLists).isDisplayed();
		driver.findElement(emailOnLists).click();
		// get text email verification and extract the verification code
		driver.switchTo().frame("html_msg_body");
		String getEmailText = driver.findElement(emailVerification).getText();
		Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
	}

	//	    public static void main(String[] args) {
	//	        String a = "code 44 verification was 123211";
	//	        String getDigit = StringUtils.getDigits(a);
	//	        System.out.println(getDigit);
	//	    }
}
