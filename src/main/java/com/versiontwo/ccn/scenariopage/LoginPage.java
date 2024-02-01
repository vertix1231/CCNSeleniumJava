package com.versiontwo.ccn.scenariopage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.versiontwo.ccn.driver.DriverSingleton;
import com.versiontwo.ccn.utils.Constants;

public class LoginPage {

	private WebDriver driver;

	public LoginPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	private int waitResponse=30000;
//	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitResponse));
	@FindBy(xpath = "//button[@class='cmplz-btn cmplz-accept']")
	@CacheLookup
	private WebElement accepcookie;

	@FindBy(xpath = "//*[@id=\"toppage\"]/header/div[2]/div[2]/div[2]/div[2]/wc-login/div/button")
	@CacheLookup
	private WebElement lgnBtnInit;


	@FindBy(xpath = "//*[@id=\"signInName\"]")
	@CacheLookup
	private WebElement nameFormSignin;

	@FindBy(xpath = "//*[@id=\"password\"]")
	@CacheLookup
	private WebElement passwordFormSignin;

	@FindBy(xpath = "//button[@id=\"next\"]")
	@CacheLookup
	private WebElement btnInputSignin;
	private String initwindow ="";


	By btnAcceptCookie = By.xpath("(//button[normalize-space()='Accept'])[1]");
	//login
	By btnSignInOnTheHomepage = By.xpath("//button[@class='login-btn']");
	By txtEmailLogin = By.id("signInName");
	By txtPasswordLogin = By.id("password");
	By btnSignIn = By.id("next");

	public void pressSignInOnTheHomepage(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnSignInOnTheHomepage).isDisplayed();
		driver.findElement(btnSignInOnTheHomepage).click();
	}
	public void inputEmailLogin(String email){
		driver.findElement(txtEmailLogin).clear();
		driver.findElement(txtEmailLogin).sendKeys(email);
	}
	public void inputPasswordLogin(String password){
		driver.findElement(txtPasswordLogin).clear();
		driver.findElement(txtPasswordLogin).sendKeys(password);
	}
	public void pressSignIn(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnSignIn).click();
	}
	public void loginCubeforall(String email, String password){
		inputEmailLogin(email);
		inputPasswordLogin(password);
		pressSignIn();
	}
	public void pressAcceptCookies(){
		try{
			driver.findElement(btnAcceptCookie).isDisplayed();
			driver.findElement(btnAcceptCookie).click();
		}catch (Exception e){
			System.out.println("cookies not displayed "+e);
		}
	}
	public void pressAcceptCookiesS(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		accepcookie.isDisplayed();
		accepcookie.click();
	}
	public void pressBtnLoginInit(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		lgnBtnInit.isDisplayed();
		lgnBtnInit.click();
	}
	public void changeSigninWindow() {
		initwindow = driver.getWindowHandle();
		Set<String> loginwindows = driver.getWindowHandles();
		for (String windowHandle : loginwindows) {
			if(!initwindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	public void inputSignin() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitResponse));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		nameFormSignin.isDisplayed();
		nameFormSignin.sendKeys("test_071123_a1@yopmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		passwordFormSignin.isDisplayed();
		passwordFormSignin.sendKeys("p@55w0rd");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("btninputsignin is displaying : "+btnInputSignin.isDisplayed()+" and enabled : "+btnInputSignin.isEnabled());
		Thread.sleep(waitResponse);
		wait.until(ExpectedConditions.elementToBeClickable(btnInputSignin));
		btnInputSignin.click();

		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		//		nameFormSignin.isDisplayed();
		//		nameFormSignin.sendKeys("test_irsyad_0001@yopmail.com");
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		//		passwordFormSignin.isDisplayed();
		//		passwordFormSignin.sendKeys("Irsyad14129812");
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		//		btnInputSignin.isDisplayed();
		//		btnInputSignin.click();
	}

	public void inputSignin(String email,String password) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitResponse));
		Constants.FULL_EMAIL_AFTER_LOGIN=email;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		nameFormSignin.isDisplayed();
		nameFormSignin.sendKeys(email);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		passwordFormSignin.isDisplayed();
		passwordFormSignin.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("btninputsignin is displaying : "+btnInputSignin.isDisplayed()+" and enabled : "+btnInputSignin.isEnabled());
		Thread.sleep(waitResponse);
		wait.until(ExpectedConditions.elementToBeClickable(btnInputSignin));
		btnInputSignin.click();
	}

}
