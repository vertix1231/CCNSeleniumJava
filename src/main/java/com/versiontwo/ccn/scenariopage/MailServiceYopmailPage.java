package com.versiontwo.ccn.scenariopage;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.versiontwo.ccn.driver.DriverSingleton;
import com.versiontwo.ccn.utils.Constants;

public class MailServiceYopmailPage {
	private WebDriver driver;
	public MailServiceYopmailPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	private int waitResponse=1000;
	private int medResponse=5000;
	By txtSearch = By.cssSelector("input#login.ycptinput");
	By emailOnLists = By.xpath("//td[contains(.,'CUBEforall by CCN account email verification code')]");
	By emailVerification = By.xpath("//*[@id=\"mail\"]/div/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td[3]/table/tbody/tr/td/table/tbody/tr/td/div[2]/span");
	
	@FindBy(xpath="//*[@id=\"refresh\"]")
	@CacheLookup
	private WebElement refreshemail;
	
	private SearchContext shadowDomcpsubscribe() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(waitResponse);
		WebElement root = driver.findElement(By.tagName("cp-subscribe-button"));
		SearchContext shadowDomcpsubscribe = ( SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		return shadowDomcpsubscribe;
	}
	public void clickchckBoxComplimentarySubscribelfsfreetrial() throws Exception {
		Thread.sleep(waitResponse);
		WebElement chckBoxComplimentarySubscribee=shadowDomcpsubscribe().findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6566e1f8669e862c02256095"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("clickComplimentaryBtnSubsribe is display: "+chckBoxComplimentarySubscribee.isDisplayed());
		chckBoxComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		chckBoxComplimentarySubscribee.click();
	}
	public void getVerificationCode(){
		//*[@id="refresh"]
		driver.switchTo().frame("ifinbox");
		String getEmailText = driver.findElement(emailVerification).getText();
		Constants.VERIFICATION_CODE_SQPP = StringUtils.getDigits(getEmailText);
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
	
	@FindBy(xpath="//*[@id=\"login\"]")
	@CacheLookup
	private WebElement loginyopmail;
	
	@FindBy(xpath="//*[@id=\"refreshbut\"]/button")
	@CacheLookup
	private WebElement btnloginyopmail;
	
	@FindBy(xpath="//*[@class=\"m\"]/button/div[@class=\"lms\"]")
	@CacheLookup
	private List<WebElement> listemailyopmail;
	
	public void loginYopmail(String email) throws Exception{
		Thread.sleep(waitResponse);
		loginyopmail.sendKeys(email);
	}
	public void btnloginyopmail() throws Exception{
		Thread.sleep(waitResponse);
		btnloginyopmail.click();
	}
	public void selectemailtoopen() throws Exception{
		Thread.sleep(waitResponse);
		driver.switchTo().frame("ifinbox");
		Thread.sleep(waitResponse);
		listemailyopmail.get(3).click();
		driver.switchTo().defaultContent();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//*[@id=\"webmail\"]/div[1]/div/header/div/nav/div[2]/a[1]")).click();
		
	}
	public void selectemailtoopendetail(String content) throws Exception{
		Thread.sleep(medResponse);
		refreshemail.click();
		Thread.sleep(waitResponse);
		driver.switchTo().frame("ifinbox");
		Thread.sleep(waitResponse);
		for(WebElement i:listemailyopmail) {
			if(i.getText().contains(content)) {
				i.click();
				break;
			}
		}
//		sdriver.switchTo().defaultContent();
//		Thread.sleep(30000);
//		driver.findElement(By.xpath("//*[@id=\"webmail\"]/div[1]/div/header/div/nav/div[2]/a[1]")).click();
		
	}
	
}
