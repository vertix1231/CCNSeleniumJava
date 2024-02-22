package com.versiontwo.ccn.scenariopage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.versiontwo.ccn.driver.DriverSingleton;

public class RegisterPage {
	private WebDriver driver;
	
	public RegisterPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	private int waitResponse =15000;
    //register
    By linkSignUpNow = By.xpath("//*[@id=\"createAccount\"]");
    By txtEmailRegister = By.id("email");
    By btnSendVerificationCodeRegister = By.id("email_ver_but_send");
    By txtVerificationCodeRegister = By.id("email_ver_input");
    By btnVerificationCodeRegister = By.id("extension_TermsOfUseConsented_AgreeToTermsOfUseConsentYes");
    By btnResendVerificationCodeRegister = By.id("email_ver_but_resend");
    
    By txtNewPasswordRegister = By.xpath("//input[@id=\"newPassword\"]");
    By txtConfirmNewPasswordRegister = By.xpath("//input[@id=\"reenterPassword\"]");
    
    By txtDisplayNameRegister = By.id("displayName");
    By txtCompanyNameRegister = By.id("cube-company-name");
    By txtContactNumberRegister = By.id("extension_ContactNo");
    By dropdownCityRegister = By.id("city");
    By dropdownCountryRegister = By.id("extension_CountryCode");
    By btnCreateRegister = By.id("continue");
    


    public void pressSignUpNow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signUpLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='createAccount']")));
        signUpLink.click();
    
//    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//        driver.findElement(linkSignUpNow).isDisplayed();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//        driver.findElement(linkSignUpNow).click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
    }

    public void inputEmailRegister(String email){
        driver.findElement(txtEmailRegister).clear();
        driver.findElement(txtEmailRegister).sendKeys(email);
    }
    public void pressSendVerificationCodeRegister(){
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
        driver.findElement(btnSendVerificationCodeRegister).click();
    }
    public void inputVerificationCodeRegister(String verificationCode){
        driver.findElement(txtVerificationCodeRegister).isDisplayed();
        driver.findElement(txtVerificationCodeRegister).clear();
        driver.findElement(txtVerificationCodeRegister).sendKeys(verificationCode);
    }
    public void pressVerificationCodeRegister(){
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
        driver.findElement(btnVerificationCodeRegister).click();
    }
    public void inputNewPasswordRegister(String password){
        driver.findElement(txtNewPasswordRegister).clear();
        driver.findElement(txtNewPasswordRegister).sendKeys(password);
    }
    public void inputConfirmNewPasswordRegister(String password){
        driver.findElement(txtConfirmNewPasswordRegister).clear();
        driver.findElement(txtConfirmNewPasswordRegister).sendKeys(password);
    }
    public void inputDisplayNameRegister(String displayName){
        driver.findElement(txtDisplayNameRegister).clear();
        driver.findElement(txtDisplayNameRegister).sendKeys(displayName);
    }
    public void inputCompanyNameRegister(String companyName){
        driver.findElement(txtCompanyNameRegister).clear();
        driver.findElement(txtCompanyNameRegister).sendKeys(companyName);
    }
    public void inputContactNumberRegister(String contactNumber){
        driver.findElement(txtContactNumberRegister).clear();
        driver.findElement(txtContactNumberRegister).sendKeys(contactNumber);
    }
    public void selectCityRegister(String city){
        Select selectCity = new Select(driver.findElement(dropdownCityRegister));
        selectCity.selectByVisibleText(city);
    }
    public void selectCountryRegister(String country){
        Select selectCountry = new Select(driver.findElement(dropdownCountryRegister));
        selectCountry.selectByVisibleText(country);
    }
    public void pressCreateAccountRegister() throws Exception{
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
        driver.findElement(btnCreateRegister).isEnabled();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
        Thread.sleep(waitResponse);
        driver.findElement(btnCreateRegister).click();
    }
    public void registerCubeforall(String email,
                                   String password,
                                   String displayName,
                                   String contactNumber,
                                   String city,
                                   String country,
                                   String verificationCode) throws Exception{
        inputEmailRegister(email);
        pressSendVerificationCodeRegister();
        inputNewPasswordRegister(password);
        inputConfirmNewPasswordRegister(password);
        inputDisplayNameRegister(displayName);
        inputContactNumberRegister(contactNumber);
        selectCityRegister(city);
        selectCountryRegister(country);
        inputVerificationCodeRegister(verificationCode);
        pressVerificationCodeRegister();
        pressCreateAccountRegister();
    }
	
}
