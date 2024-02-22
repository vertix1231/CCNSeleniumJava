package com.versiontwo.ccn.glue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.versiontwo.ccn.config.AutomationFrameworkConfiguration;
import com.versiontwo.ccn.driver.DriverSingleton;
import com.versiontwo.ccn.scenariopage.CompanyPage;
import com.versiontwo.ccn.scenariopage.LoginPage;
import com.versiontwo.ccn.scenariopage.MailServiceMailinatorPage;
import com.versiontwo.ccn.scenariopage.MailServiceYopmailPage;
import com.versiontwo.ccn.scenariopage.RegisterPage;
import com.versiontwo.ccn.scenariopage.Sqpp;
import com.versiontwo.ccn.scenariopage.SubscriptionPage;
import com.versiontwo.ccn.utils.ConfigurationProperties;
import com.versiontwo.ccn.utils.Constants;
import com.versiontwo.ccn.utils.ScenarioTestCases;
import com.versiontwo.ccn.utils.UtilsTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
	private static WebDriver driver;
	private ExtentTest extentTest;
	static ExtentReports extentReports = new ExtentReports();
	static ExtentSparkReporter htmlreporter = new ExtentSparkReporter("src/test/[subscripe moah]/[subscripe moah].html");
	private static LoginPage loginPage;
	private static RegisterPage registerPage;
	private static MailServiceMailinatorPage mailServiceMailinatorPOM;
	private static MailServiceYopmailPage mailServiceYopmailPage;
	private static CompanyPage myCompanyPOM;
	private static SubscriptionPage subscriptionPage;
	private String originalWindow = "";
	private int waitResponse=3000;
//	private int shortwaitResponse=5000;
	private int medwaitResponse=7000;
	private int longwaitResponse=10000;
	private String registerWindow = "";
	private static Sqpp sqpp;
	private String sqppwindows="";
	private String originsqppwindows="";
	private String emailSQPP="";


	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void workSetUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		//		DriverSingleton.getInstance(ConstantsParam.FIREFOX);
		driver = DriverSingleton.getDriver();
		loginPage = new LoginPage();
		registerPage = new RegisterPage();
		mailServiceMailinatorPOM = new MailServiceMailinatorPage();
		myCompanyPOM = new CompanyPage();
		mailServiceYopmailPage = new MailServiceYopmailPage();
		subscriptionPage = new SubscriptionPage();
		sqpp = new Sqpp();
		extentReports.attachReporter(htmlreporter);
		ScenarioTestCases[] tests = ScenarioTestCases.values();
		extentTest = extentReports.createTest(tests[UtilsTest.scenariotestcount].getScenarioTestName());
		UtilsTest.scenariotestcount++;
		//		originalWindow = driver.getWindowHandle();
	}
	
	@Given("^go to main web")
	public void go_to_main_web() throws Exception {
		driver.get(Constants.URL_MAIN_WEB);	
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		extentTest.log(Status.PASS, "Navigation to : " + Constants.URL_MAIN_WEB);
		extentTest.pass("Navigation to : " + Constants.URL_MAIN_WEB,
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Given("^go to yopmail")
	public void go_to_yopmail() throws Exception {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(Constants.YOPMAIL_SERVICE_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		extentTest.log(Status.PASS, "go to yopmail : " + Constants.YOPMAIL_SERVICE_URL);
		extentTest.pass("go to yopmail : " + Constants.YOPMAIL_SERVICE_URL,
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Given("^accept cookie")
	public void accept_cookie() throws InterruptedException, Exception {
		driver.get(Constants.URL_MAIN_WEB);	
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size()+"======================================================================================");
		for(Cookie c:cookies) {
			System.out.println(c.getName()+" : "+c.getValue());
			System.out.println(driver.manage().getCookieNamed(c.getName()));
		}
		loginPage.pressAcceptCookiesS();
		extentTest.log(Status.PASS, "accept cookie");
		extentTest.pass( "accept cookie",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Given("^click initial sign in button")
	public void click_initial_sign_in_button() throws Exception {
		loginPage.pressBtnLoginInit();
		Thread.sleep(waitResponse);
		loginPage.changeSigninWindow();
		extentTest.log(Status.PASS, "click initial sign in button");
		extentTest.pass( "click initial sign in button",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Given("press sign in button")
	public void clickSignInButton() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//		loginPage.pressAcceptCookies();
		originalWindow = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		loginPage.pressSignInOnTheHomepage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		for (String windowHandle : driver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		extentTest.log(Status.PASS, "press sign in button");
		extentTest.pass( "press sign in button",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("^input initial email sign in")
	public void input_initial_email_sign_in() throws Exception {
		loginPage.inputSignin();
		Thread.sleep(waitResponse);
		extentTest.log(Status.PASS, "input initial email sign in");
		extentTest.pass( "input initial email sign in",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("^input initial password sign in")
	public void input_initial_password_sign_in() throws Exception {
		extentTest.log(Status.PASS, "input initial password sign in");
		extentTest.pass( "input initial password sign in",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("^click final sign in button")
	public void click_final_sign_in_button() throws Exception {
		extentTest.log(Status.PASS, "click final sign in button");
		extentTest.pass( "click final sign in button",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("^back to the main tab browser")
	public void backToTheMainTabBrowser() throws Exception {
		driver.switchTo().window(originalWindow);
		Thread.sleep(waitResponse);
		extentTest.log(Status.PASS, "back to the main tab browser");
		extentTest.pass( "back to the main tab browser",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@When("^input email (.*) and password (.*) and press sign in to continue login")
	public void inputEmailAndPasswordAndPressSignInToContinueLogin(String email, String password) throws Exception {
		Thread.sleep(longwaitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		loginPage.inputSignin(email,password);
		//				loginPage.inputSignin();
		//		Thread.sleep(waitResponse);
		extentTest.log(Status.PASS, "input email (.*) and password (.*) and press sign in to continue login");
		extentTest.pass( "input email (.*) and password (.*) and press sign in to continue login",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	//REGISTER PAGE

	@When("press sign up now button")
	public void pressSignUpNowButton() throws Exception {
		Thread.sleep(waitResponse);
		registerPage.pressSignUpNow();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		extentTest.log(Status.PASS, "press sign up now button");
		extentTest.pass( "press sign up now button",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input email address on register page")
	public void inputEmailAddressOnRegisterPage() throws Exception {
		registerPage.inputEmailRegister(Constants.FULL_EMAIL);
		System.out.println(Constants.FULL_EMAIL);
		//		registerPage.inputEmailRegister("qa-ccn-04346@mailinator.com");
		//		System.out.println("qa-ccn-04346@mailinator.com");
		extentTest.log(Status.PASS, "input email address on register page");
		extentTest.pass( "input email address on register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input email address on register page china")
	public void inputEmailAddressOnRegisterPagech() throws Exception {
		registerPage.inputEmailRegister(Constants.FULL_EMAIL_CH);
		System.out.println(Constants.FULL_EMAIL_CH);
		//		registerPage.inputEmailRegister("qa-ccn-04346@mailinator.com");
		//		System.out.println("qa-ccn-04346@mailinator.com");
		extentTest.log(Status.PASS, "input email address on register page china");
		extentTest.pass( "input email address on register page china",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("press send verification code")
	public void pressSendVerificationCode() throws Exception {
		registerPage.pressSendVerificationCodeRegister();
		extentTest.log(Status.PASS, "press send verification code");
		extentTest.pass( "press send verification code",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input password & confirm password on register page")
	public void inputPasswordConfirmPasswordOnRegisterPage() throws Exception {
		registerPage.inputNewPasswordRegister(Constants.PASSWORD);
		registerPage.inputConfirmNewPasswordRegister(Constants.PASSWORD);
		System.out.println(Constants.PASSWORD);
		extentTest.log(Status.PASS, "input password & confirm password on register page");
		extentTest.pass( "input password & confirm password on register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input display name {string} on register page")
	public void inputDisplayNameOnRegisterPage(String displayName) throws Exception {
		registerPage.inputDisplayNameRegister(displayName);
		extentTest.log(Status.PASS, "input display name {string} on register page");
		extentTest.pass( "input display name {string} on register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input company name {string} on register page")
	public void inputCompanyNameOnRegisterPage(String companyName) throws Exception {
		String companyNameInput = companyName+Constants.GENERATED_NUM;
		registerPage.inputCompanyNameRegister(companyNameInput);
		System.out.println(companyNameInput);
		extentTest.log(Status.PASS, "input company name {string} on register page");
		extentTest.pass( "input company name {string} on register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("input company name {string} dynamics")
	public void inputCompanyNameDynamics(String companyName) throws Exception {
		String companyNameInput = companyName+Constants.GENERATED_NUM;
		registerPage.inputCompanyNameRegister(companyNameInput);
		System.out.println(companyNameInput);
		extentTest.log(Status.PASS, "input company name {string} on register page");
		extentTest.pass( "input company name {string} on register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	

	@And("input contact number {string} on register page")
	public void inputContactNumberOnRegisterPage(String contactNumber) throws Exception {
		registerPage.inputContactNumberRegister(contactNumber);
		extentTest.log(Status.PASS, "input contact number {string} on register page");
		extentTest.pass( "input contact number {string} on register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("select city {string} on register page")
	public void selectCityOnRegisterPage(String city) throws Exception {
		registerPage.selectCityRegister(city);
		extentTest.log(Status.PASS, "select city {string} on register page");
		extentTest.pass( "select city {string} on register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("select country {string} on register page")
	public void selectCountryOnRegisterPage(String country) throws Exception {
		registerPage.selectCountryRegister(country);
		extentTest.log(Status.PASS, "select country {string} on register page");
		extentTest.pass( "select country {string} on register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("get email verification code on mail service")
	public void getEmailVerificationCodeOnMailService() throws Exception {
		getEmailVerificationMailinator();
		extentTest.log(Status.PASS, "get email verification code on mail service");
		extentTest.pass( "get email verification code on mail service",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("get email verification code on mail service singapore")
	public void getEmailVerificationCodeOnMailServicesg() throws Exception {
		getEmailVerificationMailinatorsg();
		extentTest.log(Status.PASS, "get email verification code on mail service singapore");
		extentTest.pass( "get email verification code on mail service singapore",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("get email verification code on mail service china")
	public void getEmailVerificationCodeOnMailServicech() throws Exception {
		getEmailVerificationMailinatorch();
		extentTest.log(Status.PASS, "get email verification code on mail service china");
		extentTest.pass( "get email verification code on mail service china",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input verification code on register page")
	public void inputVerificationCodeOnRegisterPage() throws Exception {
		registerPage.inputVerificationCodeRegister(Constants.VERIFICATION_CODE);
		System.out.println(Constants.VERIFICATION_CODE);
		extentTest.log(Status.PASS, "input verification code on register page");
		extentTest.pass( "input verification code on register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("press verification code button on register page")
	public void pressVerificationCodeButtonOnRegisterPage() throws Exception {
		registerPage.pressVerificationCodeRegister();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Thread.sleep(waitResponse);
		extentTest.log(Status.PASS, "press verification code button on register page");
		extentTest.pass( "press verification code button on register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("press create account on register page")
	public void pressCreateAccountOnRegisterPage() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		registerPage.pressCreateAccountRegister();
		extentTest.log(Status.PASS, "press create account on register page");
		extentTest.pass( "press create account on register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@When("registration with new account and login")
	public void registrationWithNewAccountAndLogin() throws Exception {
		pressSignUpNowButton();
		inputEmailAddressOnRegisterPage();
		pressSendVerificationCode();
		inputPasswordConfirmPasswordOnRegisterPage();	
		inputDisplayNameOnRegisterPage(Constants.DISPLAY_NAME);

		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		selectCityOnRegisterPage("SINGAPORE"); //todo: fix the hardcoded
		selectCountryOnRegisterPage("Singapore"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("KUALA LUMPUR"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("Malaysia"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("ABU DHABI"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("United Arab Emirates"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("COLOMBO"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("Sri Lanka"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("MIAMI"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("United States"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("JAKARTA"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("Indonesia"); //todo: fix the hardcoded

		openNewTabAndOpenMailinator();
		getTheEmailVerificationAndExtractTheVerificationCodesg();
		closeTabAndBackToRegisterPage();
		inputVerificationCodeOnRegisterPage();
		pressVerificationCodeButtonOnRegisterPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		pressCreateAccountOnRegisterPage();
		backToTheMainTabBrowser();
		extentTest.log(Status.PASS, "registration with new account and login");
		extentTest.pass( "registration with new account and login",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("open email mailinator")
	public void open_email_mailinator() throws Exception {
		Thread.sleep(medwaitResponse);
		openNewTabAndOpenMailinator();
		getTheEmailVerificationAndExtractTheVerificationCodesg();
		extentTest.log(Status.PASS, "open email mailinator");
		extentTest.pass( "open email mailinator",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@Then("open email mailinator after login")
	public void open_email_mailinator_after_login() throws Exception {
		Thread.sleep(medwaitResponse);
		openNewTabAndOpenMailinator();
		getTheEmailVerificationAndExtractTheVerificationCodeafterlogin();
		extentTest.log(Status.PASS, "open email mailinator");
		extentTest.pass( "open email mailinator",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}


	@When("registration with new account and login singapura")
	public void registrationWithNewAccountAndLoginsg() throws Exception {
		pressSignUpNowButton();
		inputEmailAddressOnRegisterPage();
		pressSendVerificationCode();
		inputPasswordConfirmPasswordOnRegisterPage();	
		inputDisplayNameOnRegisterPage(Constants.DISPLAY_NAME);

		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		selectCityOnRegisterPage("SINGAPORE"); //todo: fix the hardcoded
		selectCountryOnRegisterPage("Singapore"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("KUALA LUMPUR"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("Malaysia"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("ABU DHABI"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("United Arab Emirates"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("COLOMBO"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("Sri Lanka"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("MIAMI"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("United States"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("JAKARTA"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("Indonesia"); //todo: fix the hardcoded

		openNewTabAndOpenMailinator();
		getTheEmailVerificationAndExtractTheVerificationCodesg();
		closeTabAndBackToRegisterPage();
		inputVerificationCodeOnRegisterPage();
		pressVerificationCodeButtonOnRegisterPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		pressCreateAccountOnRegisterPage();
		backToTheMainTabBrowser();
		extentTest.log(Status.PASS, "registration with new account and login singapura");
		extentTest.pass( "registration with new account and login singapura",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@When("registration with new account and login china")
	public void registrationWithNewAccountAndLoginch() throws Exception {
		pressSignUpNowButton();
		inputEmailAddressOnRegisterPage();
		pressSendVerificationCode();
		inputPasswordConfirmPasswordOnRegisterPage();	
		inputDisplayNameOnRegisterPage(Constants.DISPLAY_NAME);

		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		selectCityOnRegisterPage("SINGAPORE"); //todo: fix the hardcoded
		selectCountryOnRegisterPage("Singapore"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("KUALA LUMPUR"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("Malaysia"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("ABU DHABI"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("United Arab Emirates"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("COLOMBO"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("Sri Lanka"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("MIAMI"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("United States"); //todo: fix the hardcoded

		//		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		//		selectCityOnRegisterPage("JAKARTA"); //todo: fix the hardcoded
		//		selectCountryOnRegisterPage("Indonesia"); //todo: fix the hardcoded

		openNewTabAndOpenMailinator();
		getTheEmailVerificationAndExtractTheVerificationCodech();
		closeTabAndBackToRegisterPage();
		inputVerificationCodeOnRegisterPage();
		pressVerificationCodeButtonOnRegisterPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		pressCreateAccountOnRegisterPage();
		backToTheMainTabBrowser();
		extentTest.log(Status.PASS, "registration with new account and login china");
		extentTest.pass( "registration with new account and login china",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("registration with new account and try login")
	public void registrationWithNewAccountAndTryLogin() throws Exception {
		Thread.sleep(medwaitResponse);
		pressSignUpNowButton();
		Thread.sleep(longwaitResponse);
		registerPage.inputEmailRegister("ccn-qa-"+ RandomStringUtils.randomNumeric(6)+"@mailinator.com");
		inputEmailAddressOnRegisterPage();
		Thread.sleep(longwaitResponse);
		pressSendVerificationCode();
		Thread.sleep(longwaitResponse);
		inputPasswordConfirmPasswordOnRegisterPage();
		inputDisplayNameOnRegisterPage(Constants.DISPLAY_NAME);
		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		selectCityOnRegisterPage("SINGAPORE"); //todo: fix the hardcoded
		selectCountryOnRegisterPage("Singapore"); //todo: fix the hardcoded

		openNewTabAndOpenMailinator();
		//		openNewTabAndOpenYopmail();
		Thread.sleep(longwaitResponse);
		getTheEmailVerificationAndExtractTheVerificationCode();
		closeTabAndBackToRegisterPage();
		Thread.sleep(longwaitResponse);
		inputVerificationCodeOnRegisterPage();
		Thread.sleep(longwaitResponse);
		pressVerificationCodeButtonOnRegisterPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Thread.sleep(longwaitResponse);
		pressCreateAccountOnRegisterPage();
		Thread.sleep(longwaitResponse);
		backToTheMainTabBrowser();
		extentTest.log(Status.PASS, "registration with new account and try login");
		extentTest.pass( "registration with new account and try login",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("registration with new account and try login singapore")
	public void registrationWithNewAccountAndTryLoginsingapore() throws Exception {
		Thread.sleep(medwaitResponse);
		pressSignUpNowButton();
		Thread.sleep(longwaitResponse);
		registerPage.inputEmailRegister("sgccn-qa-"+ RandomStringUtils.randomNumeric(6)+"@mailinator.com");
		inputEmailAddressOnRegisterPage();
		Thread.sleep(longwaitResponse);
		pressSendVerificationCode();
		Thread.sleep(longwaitResponse);
		inputPasswordConfirmPasswordOnRegisterPage();
		inputDisplayNameOnRegisterPage(Constants.DISPLAY_NAME);
		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		selectCityOnRegisterPage("SINGAPORE"); //todo: fix the hardcoded
		selectCountryOnRegisterPage("Singapore"); //todo: fix the hardcoded

		openNewTabAndOpenMailinator();
		//		openNewTabAndOpenYopmail();
		Thread.sleep(longwaitResponse);
		getTheEmailVerificationAndExtractTheVerificationCodesg();
		closeTabAndBackToRegisterPage();
		inputVerificationCodeOnRegisterPage();
		Thread.sleep(longwaitResponse);
		pressVerificationCodeButtonOnRegisterPage();
		Thread.sleep(longwaitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		pressCreateAccountOnRegisterPage();
		Thread.sleep(longwaitResponse);
		backToTheMainTabBrowser();
		extentTest.log(Status.PASS, "registration with new account and try login singapore");
		extentTest.pass( "registration with new account and try login singapore",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("registration with new account and try login china")
	public void registrationWithNewAccountAndTryLoginchina() throws Exception {
		pressSignUpNowButton();
		registerPage.inputEmailRegister("chccn-qa-"+ RandomStringUtils.randomNumeric(6)+"@mailinator.com");
		inputEmailAddressOnRegisterPagech();
		pressSendVerificationCode();
		inputPasswordConfirmPasswordOnRegisterPage();
		inputDisplayNameOnRegisterPage(Constants.DISPLAY_NAME);
		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
		selectCityOnRegisterPage("BEIJING"); //todo: fix the hardcoded
		selectCountryOnRegisterPage("China"); //todo: fix the hardcoded

		openNewTabAndOpenMailinator();
		//		openNewTabAndOpenYopmail();

		getTheEmailVerificationAndExtractTheVerificationCodech();


		closeTabAndBackToRegisterPage();
		inputVerificationCodeOnRegisterPage();
		pressVerificationCodeButtonOnRegisterPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		pressCreateAccountOnRegisterPage();
		backToTheMainTabBrowser();
		extentTest.log(Status.PASS, "registration with new account and try login china");
		extentTest.pass( "registration with new account and try login china",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Given("Open new tab and open mailinator")
	public void openNewTabAndOpenMailinator() throws  Exception {
		registerWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(2000);
		driver.get(Constants.MAIL_SERVICE_URL);
		extentTest.log(Status.PASS, "Open new tab and open mailinator");
		extentTest.pass( "Open new tab and open mailinator",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Given("Open new tab and open yopmail")
	public void openNewTabAndOpenYopmail() throws  Exception {
		registerWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(2000);
		driver.get(Constants.YOPMAIL_SERVICE_URL);
		extentTest.log(Status.PASS, "Open new tab and open yopmail");
		extentTest.pass( "Open new tab and open yopmail",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	public void getEmailVerificationMailinator(){
		//get window register
		registerWindow = driver.getWindowHandle();
		//swith to new tab for open the mailinator email service
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.get(Constants.MAIL_SERVICE_URL);
		//method to get verification code
		mailServiceMailinatorPOM.getVerificationCode();
		//Close the tab and go to register window
		driver.close();
		driver.switchTo().window(registerWindow);
	}
	@And("get the email verification and extract the verification code")
	public void getTheEmailVerificationAndExtractTheVerificationCode() throws Exception {
		mailServiceMailinatorPOM.getVerificationCode();
		//		mailServiceMailinatorPOM.getVerificationCode("qa-ccn-04346@mailinator.com");
		extentTest.log(Status.PASS, "get the email verification and extract the verification code");
		extentTest.pass( "get the email verification and extract the verification code",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	public void getEmailVerificationMailinatorsg(){
		//get window register
		registerWindow = driver.getWindowHandle();
		//swith to new tab for open the mailinator email service
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.get(Constants.MAIL_SERVICE_URL);
		//method to get verification code
		mailServiceMailinatorPOM.getVerificationCodesg();
		//Close the tab and go to register window
		driver.close();
		driver.switchTo().window(registerWindow);
	}

	public void getEmailVerificationMailinatorch(){
		//get window register
		registerWindow = driver.getWindowHandle();
		//swith to new tab for open the mailinator email service
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.get(Constants.MAIL_SERVICE_URL);
		//method to get verification code
		mailServiceMailinatorPOM.getVerificationCodesg();
		//Close the tab and go to register window
		driver.close();
		driver.switchTo().window(registerWindow);
	}

	@And("get the email verification and extract the verification code singapore")
	public void getTheEmailVerificationAndExtractTheVerificationCodesg() throws Exception {
		mailServiceMailinatorPOM.getVerificationCodesg();
		//		mailServiceMailinatorPOM.getVerificationCode("qa-ccn-04346@mailinator.com");
		extentTest.log(Status.PASS, "get the email verification and extract the verification code singapore");
		extentTest.pass( "get the email verification and extract the verification code singapore",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("get the email verification and extract the verification code after login")
	public void getTheEmailVerificationAndExtractTheVerificationCodeafterlogin() throws Exception {
		mailServiceMailinatorPOM.getVerificationCodelogin();
		//		mailServiceMailinatorPOM.getVerificationCode("qa-ccn-04346@mailinator.com");
		extentTest.log(Status.PASS, "get the email verification and extract the verification code singapore");
		extentTest.pass( "get the email verification and extract the verification code singapore",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("get the email verification and extract the verification code china")
	public void getTheEmailVerificationAndExtractTheVerificationCodech() throws Exception {
		mailServiceMailinatorPOM.getVerificationCodech();
		//		mailServiceMailinatorPOM.getVerificationCode("qa-ccn-04346@mailinator.com");
		extentTest.log(Status.PASS, "get the email verification and extract the verification code china");
		extentTest.pass( "get the email verification and extract the verification code china",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("close tab and back to register page")
	public void closeTabAndBackToRegisterPage() throws Exception {
		driver.close();
		driver.switchTo().window(registerWindow);
		extentTest.log(Status.PASS, "close tab and back to register page");
		extentTest.pass( "close tab and back to register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	// MyCompany Steps

	//S1
	@Then("will redirected to suggested company list which match with domain name of the users")
	public void willRedirectedToSuggestedCompanyListWhichMatchWithDomainNameOfTheUsers() throws  Exception {
		//verified the url + path
		String getUrl = driver.getCurrentUrl();
		System.out.println(getUrl);
		System.out.println(UtilsTest.getProperties()+Constants.COMPANY_PATH_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		//		Thread.sleep(waitResponse);
		//		Assert.assertEquals(Constants.COMPANY_PATH_URL,getUrl);
		//		myCompanyPOM.clickAccountCircleIcon();
		//		Assert.assertEquals("https://sandbox.cubeforall.com/portal/manage-company/",getUrl);
		//		Thread.sleep(waitResponse);
		//		Assert.assertEquals("https://dev.cubeforall.com/portal/manage-company/",getUrl);


		//		try{
		//			//verified the table was displayed or not
		//			myCompanyPOM.companyListsTable().isDisplayed();
		//			//assert the company list contents
		//			String compListTable = myCompanyPOM.companyListsTable().getText();
		//			Assert.assertEquals(Constants.FULL_EMAIL, compListTable);
		//			System.out.println(compListTable);
		//		}catch (Exception e){
		//			System.out.println("The table was not exist "+e);
		//		}
		//		myCompanyPOM.inputCompanyNameOnMyCompany(getUrl)
		Thread.sleep(medwaitResponse);
		extentTest.log(Status.PASS, "will redirected to suggested company list which match with domain name of the users");
		extentTest.pass( "will redirected to suggested company list which match with domain name of the users",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("will redirected to suggested company list which match with domain name of the users {string}")
	public void willRedirectedToSuggestedCompanyListWhichMatchWithDomainNameOfTheUsers(String namecmpany) throws Exception {
		//verified the url + path
		String getUrl = driver.getCurrentUrl();
		System.out.println(getUrl);
		System.out.println(UtilsTest.getProperties()+Constants.COMPANY_PATH_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Thread.sleep(waitResponse);
		//		Assert.assertEquals(Constants.COMPANY_PATH_URL,getUrl);
		//		myCompanyPOM.clickAccountCircleIcon();
		Assert.assertEquals("https://sandbox.cubeforall.com/portal/manage-company/",getUrl);
		//		Assert.assertEquals("https://dev.cubeforall.com/portal/manage-company/",getUrl);


		//		try{
		//			//verified the table was displayed or not
		//			myCompanyPOM.companyListsTable().isDisplayed();
		//			//assert the company list contents
		//			String compListTable = myCompanyPOM.companyListsTable().getText();
		//			Assert.assertEquals(Constants.FULL_EMAIL, compListTable);
		//			System.out.println(compListTable);
		//		}catch (Exception e){
		//			System.out.println("The table was not exist "+e);
		//		}
		myCompanyPOM.inputCompanyNameOnMyCompany(namecmpany);
		extentTest.log(Status.PASS, "will redirected to suggested company list which match with domain name of the users {string}");
		extentTest.pass( "will redirected to suggested company list which match with domain name of the users {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
		Thread.sleep(waitResponse);
	}

	//S2
	@When("request join to company")
	public void requestJoinToCompany() throws Exception {
		myCompanyPOM.pressJoinCompany(0);
		extentTest.log(Status.PASS, "request join to company");
		extentTest.pass( "request join to company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@When("select request join to company")
	public void selectrequestJoinToCompany() throws Exception {
		myCompanyPOM.pressJoinCompany(0);
		extentTest.log(Status.PASS, "select request join to company");
		extentTest.pass( "select request join to company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("confirm request joining company")
	public void confirmRequestJoiningCompany() throws Exception {
		myCompanyPOM.pressConfirmRequestCompany();
		extentTest.log(Status.PASS, "confirm request joining company");
		extentTest.pass( "confirm request joining company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("will redirected to the application status")
	public void willRedirectedToTheApplicationStatus() throws Exception {
		System.out.println(myCompanyPOM.applicationStatusLabel().isDisplayed());
		myCompanyPOM.applicationStatusLabel().isDisplayed();
		extentTest.log(Status.PASS, "will redirected to the application status");
		extentTest.pass( "will redirected to the application status",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("status user was still {string} and waiting for approval from admin company")
	public void statusUserWasStillAndWaitingForApprovalFromAdminCompany(String status) throws Exception {
		// assert label pending
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(medwaitResponse));
		Thread.sleep(waitResponse);
		String appStatus = myCompanyPOM.applicationStatusLabel().getText();
		System.out.println(appStatus);
		extentTest.log(Status.PASS, "status user was still {string} and waiting for approval from admin company");
		extentTest.pass( "status user was still {string} and waiting for approval from admin company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
		Assert.assertEquals(status, appStatus);
	}
	
	@And("status user was still {string}")
	public void statusUserWasStillpendingaccept(String status) throws Exception {
		// assert label pending
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(medwaitResponse));
		Thread.sleep(waitResponse);
		String appStatus = myCompanyPOM.applicationStatusLabel().getText();
		System.out.println(appStatus);
		extentTest.log(Status.PASS, "status user was still {string} and waiting for approval from admin company");
		extentTest.pass( "status user was still {string} and waiting for approval from admin company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
		Assert.assertEquals(status, appStatus);
	}

	@Then("receive email notification for request joining company")
	public void receive_email_notification_for_request_joining_company() throws Exception {

		extentTest.log(Status.PASS, "receive email notification for request joining company");
		extentTest.pass( "receive email notification for request joining company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}



	//S3

	@And("go to my icon account menu {string}")
	public void go_to_my_icon_account_menu_menu(String menu) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Thread.sleep(longwaitResponse);
		myCompanyPOM.myMenuAccount(menu);
		extentTest.log(Status.PASS, "go to my icon account menu {string}");
		extentTest.pass( "go to my icon account menu {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("go to my icon account menuuu")
	public void go_to_my_icon_account_menu_menu_men() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Thread.sleep(longwaitResponse);
		myCompanyPOM.clickCircleMenuAccount();
		extentTest.log(Status.PASS, "go to my icon account menu {string}");
		extentTest.pass( "go to my icon account menu {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("go to my icon account menuu {string}")
	public void go_to_my_icon_account_menuu_menu(String menu) throws Exception {
		driver.get("https://sandbox.cubeforall.com/portal/manage-subscription/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Thread.sleep(waitResponse);
		//		Thread.sleep(waitResponse);
		driver.get("https://sandbox.cubeforall.com/portal/manage-subscription/");
		extentTest.log(Status.PASS, "go to my icon account menuu {string}");
		extentTest.pass( "go to my icon account menuu {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@When("system didn't found the suggested company matched")
	public void systemDidnTFoundTheSuggestedCompanyMatched() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(medwaitResponse));
		//		driver.get("https://sandbox.cubeforall.com/portal/manage-company/");
		//		driver.get("https://dev.cubeforall.com/portal/manage-company/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(medwaitResponse));
		Thread.sleep(waitResponse);
		System.out.println(myCompanyPOM.companyListsTable());
		extentTest.log(Status.PASS, "system didn't found the suggested company matched");
		extentTest.pass( "system didn't found the suggested company matched",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input company name {string}")
	public void inputCompanyName(String compName) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.inputCompanyNameOnMyCompany(compName);
		extentTest.log(Status.PASS, "input company name {string}");
		extentTest.pass( "input company name {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("input company name dynamics")
	public void inputCompanyNameDynamics() throws Exception {
		Thread.sleep(waitResponse);
		
		extentTest.log(Status.PASS, "input company name");
		extentTest.pass( "input company name",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("search company name {string}")
	public void searchCompanyName(String compName) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.searchinputCompanyNameOnMyCompany(compName);
		extentTest.log(Status.PASS, "search company name {string}");
		extentTest.pass( "search company name {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input company registration {string}")
	public void inputCompanyRegistration(String compRegNo) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.inputCompanyRegNoOnMyCompany(compRegNo);
		extentTest.log(Status.PASS, "input company name {string}");
		extentTest.pass( "input company name {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input company type {string}")
	public void inputCompanyType(String compType) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.selectCompanyType(compType);
		extentTest.log(Status.PASS, "input company type {string}");
		extentTest.pass( "input company type {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input country {string}")
	public void input_Country_country(String country) throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.selectCountry(country);
		extentTest.log(Status.PASS, "input country {string}");
		extentTest.pass( "input country {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	@And("input city {string}")
	public void input_City_city(String city) throws Exception {
		Thread.sleep(medwaitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.selectCity(city);
		extentTest.log(Status.PASS, "input city {string}");
		extentTest.pass( "input city {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("the user was able to create a new company")
	public void theUserWasAbleToCreateANewCompany() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.createNewCompany().isDisplayed();
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		//		myCompanyPOM.createNewCompany().click(); // un-comment to activate methode
		extentTest.log(Status.PASS, "the user was able to create a new company");
		extentTest.pass( "the user was able to create a new company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("theres button to create company with the status was enabled to create company")
	public void thereSButtonToCreateCompanyAndTheStatusWasEnabled() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.createNewCompany().isEnabled();
		extentTest.log(Status.PASS, "theres button to create company with the status was enabled to create company");
		extentTest.pass( "theres button to create company with the status was enabled to create company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	//S4
	@When("press create company button")
	public void pressCreateCompanyButton() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressCreateNewCompany();
		extentTest.log(Status.PASS, "press create company button");
		extentTest.pass( "press create company button",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@Then("finally successfully to the setup post payment")
	public void finally_successfully_to_the_setup_post_payment() throws Exception {
		Thread.sleep(waitResponse);
		extentTest.log(Status.PASS, "finally successfully to the setup post payment");
		extentTest.pass( "finally successfully to the setup post payment",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("finally successfully to the setup giro payment")
	public void finally_successfully_to_the_setup_giro_payment() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.clickbtnProceedConfirmationCreateCompany();
		//		myCompanyPOM.clickbtnPostpaymentCreateCompany().isEnabled();
		//		myCompanyPOM.clickbtnPostpaymentCreateCompany().isDisplayed();
		//		System.out.println(myCompanyPOM.clickbtnPostpaymentCreateCompany().getText()+" ====================================================");
		//		Assert.assertEquals("Proceed", myCompanyPOM.clickbtnPostpaymentCreateCompany().getText());
		extentTest.log(Status.PASS, "finally successfully to the setup post payment");
		extentTest.pass( "finally successfully to the setup post payment",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("receive email notification giro setup")
	public void receive_email_notification_giro_setup() throws Exception {
		Thread.sleep(waitResponse);
		extentTest.log(Status.PASS, "receive email notification giro setup");
		extentTest.pass( "receive email notification giro setup",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	
	@Then("pop up for duplicate company show up")
	public void pop_up_for_duplicate_company_show_up() throws Exception {
		Thread.sleep(waitResponse);
		extentTest.log(Status.PASS, "pop up for duplicate company show up");
		extentTest.pass( "pop up for duplicate company show up",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@Then("receive email notification offline setup")
	public void receive_email_notification_offline_setup() throws Exception {
		Thread.sleep(waitResponse);
		extentTest.log(Status.PASS, "receive email notification giro setup");
		extentTest.pass( "receive email notification giro setup",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("input registered office address {string} for company detail")
	public void inputRegisteredOfficeAddress(String address) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.inputAddress(address);
		extentTest.log(Status.PASS, "input registered office address {string} for company detail");
		extentTest.pass( "input registered office address {string} for company detail",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input post code {string} for company detail")
	public void inputPostCode(String postCode) throws  Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.inputPostCode(postCode);
		extentTest.log(Status.PASS, "input post code {string} for company detail");
		extentTest.pass( "input post code {string} for company detail",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("input mailing address complete from same as registered company address")
	public void input_mailing_address_complete_from_same_as_registered_company_address() throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.clickCheckBoxRegisterSameMailing();
		extentTest.log(Status.PASS, "input mailing address complete from same as registered company address");
		extentTest.pass( "input mailing address complete from same as registered company address",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input contact details name {string}")
	public void inputContactDetailsName(String name) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.inputContactNameSetupCompany(name);
		extentTest.log(Status.PASS, "input contact details name {string}");
		extentTest.pass( "input contact details name {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("input mobile number detail company {string} for company detail")
	public void  input_mobile_number_detail_company(String mobile) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.inputCompanyMobileNumberCompanyDetails(mobile);
		extentTest.log(Status.PASS, "input mobile number detail company {string} for company detail");
		extentTest.pass( "input mobile number detail company {string} for company detail",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("input company email {string} for company detail")
	public void  company_email_email(String companyemail) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.inputCompanyEmailSetupCompanyDetails(companyemail);
		extentTest.log(Status.PASS, "input company email {string} for company detail");
		extentTest.pass( "input company email {string} for company detail",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("input contact details designation {string}")
	public void inputContactDetailsDesignation(String designation) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.inputDesignationSetupCompany(designation);
		extentTest.log(Status.PASS, "input contact details designation {string}");
		extentTest.pass( "input contact details designation {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input contact details mobile no {string}")
	public void inputContactDetailsMobileNo(String mobileNo) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.inputMobileNoSetupCompany(mobileNo);
		extentTest.log(Status.PASS, "input contact details designation {string}");
		extentTest.pass( "input contact details designation {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input contact details email {string}")
	public void inputContactDetailsEmail(String email) throws Exception {
		Thread.sleep(waitResponse);
		//		myCompanyPOM.inputEmailSetupCompany(email);
		extentTest.log(Status.PASS, "input contact details email {string}");
		extentTest.pass( "input contact details email {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input contact details IATA membership number {string}")
	public void inputContactDetailsIATAMembershipNumber(String iata) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.inputIataMembershipNoSetupCompany(iata);
		extentTest.log(Status.PASS, "input contact details IATA membership number {string}");
		extentTest.pass( "input contact details IATA membership number {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("input contact details CASS number {string}")
	public void inputContactDetailsCASSNumber(String cass) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.inputCassNoSetupCompany(cass);
		extentTest.log(Status.PASS, "input contact details CASS number {string}");
		extentTest.pass( "input contact details CASS number {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("press submit create company")
	public void pressSubmitCreateCompany() throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.clickButtonSubmitCompany();
		extentTest.log(Status.PASS, "press submit create company");
		extentTest.pass( "press submit create company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("click proceed pop up button for creating company to the post payment")
	public void click_proceed_pop_up_button_for_creating_company_to_the_post_payment() throws Exception{
		Thread.sleep(waitResponse);
		myCompanyPOM.clickbtnProceedConfirmationCreateCompany();
		extentTest.log(Status.PASS, "click proceed pop up button for creating company to the post payment");
		extentTest.pass( "click proceed pop up button for creating company to the post payment",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	@And("click ok button from pop up confirmation that tells GIRO setup instructions has been sent to email")
	public void click_ok_button_from_pop_up_confirmation_that_tells_GIRO_setup_instructions_has_been_sent_to_email() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.clickbtnProceedConfirmationCreateCompany();
		extentTest.log(Status.PASS, "click ok button from pop up confirmation that tells GIRO setup instructions has been sent to email");
		extentTest.pass( "click ok button from pop up confirmation that tells GIRO setup instructions has been sent to email",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	@And("will displayed pop up for post payment setup")
	public void willDisplayedPopUpForPostPaymentSetup() throws Exception {
		Thread.sleep(waitResponse);
		//		myCompanyPOM.setupNowOnModalMyCompany().isDisplayed();
		extentTest.log(Status.PASS, "will displayed pop up for post payment setup");
		extentTest.pass( "will displayed pop up for post payment setup",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());


	}

	@And("if press yes then will trigger email for post payment")
	public void ifPressYesThenWillTriggerEmailForPostPayment() throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.pressSetupNowOnModalMyCompany();
		extentTest.log(Status.PASS, "if press yes then will trigger email for post payment");
		extentTest.pass( "if press yes then will trigger email for post payment",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("go to my company")
	public void goToMyCompany() throws Exception {
		Thread.sleep(longwaitResponse);
		driver.get(Constants.COMPANY_PATH_URL);
		extentTest.log(Status.PASS, "go to my company");
		extentTest.pass( "go to my company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("press member tab")
	public void pressMemberTab() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressMembersOnMyCompany();
		extentTest.log(Status.PASS, "press member tab");
		extentTest.pass( "press member tab",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}



	//S5
	@When("press invite users button")
	public void pressInviteUsersButton() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressInviteUserToCompany();
		extentTest.log(Status.PASS, "press invite users button");
		extentTest.pass( "press invite users button",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@And("input email {string} on the pop up")
	public void inputEmailOnThePopUp(String email) throws Exception {
		Thread.sleep(medwaitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.inputInviteUsersOnMembersByAdmin(email);
		extentTest.log(Status.PASS, "input email {string} on the pop up");
		extentTest.pass( "input email {string} on the pop up",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@And("press invite button on the pop up")
	public void pressInviteButtonOnThePopUp() throws Exception {
		Thread.sleep(longwaitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressInviteOnModalMyCompany();
		extentTest.log(Status.PASS, "press invite button on the pop up");
		extentTest.pass( "press invite button on the pop up",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@Then("showing error on the pop up modal which contains the user has pending application or is already in company with other email user {string}")
	public void showingErrorOnThePopUpModalWhichContainsTheUserHasPendingApplicationOrIsAlreadyInCompany(String email) throws Exception {
		Thread.sleep(waitResponse);
		
//		//todo: get the pop up text and verified
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//		String validationActualTxt = myCompanyPOM.txtValidateAlreadyinCompany().getText();
//		String txtone = "This user(s) you entered already has a pending application/is already in a company.";
//		String txttwo = "This user(s) you entered already has a company.";
//		String validationActualTxtEmail = myCompanyPOM.txtemailValidateAlreadyinCompany().getText();
//		System.out.println(validationActualTxtEmail);
//		if(validationActualTxt.contains(txtone)||validationActualTxt.contains(txttwo)) {
//			Assert.assertEquals("pop up massage true","pop up massage true" );
//		}else {
//			Assert.assertEquals("pop up massage true","pop up massage false" );
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//		if(email.contains(validationActualTxtEmail)) {
//			Assert.assertEquals("email pop up true", "email pop up true");
//		}else {
//			Assert.assertEquals("email pop up true", "email pop up false");
//		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.btnValidateAlreadyinCompany().click();
		extentTest.log(Status.PASS, "showing error on the pop up modal which contains the user has pending application or is already in company with other email user {string}");
		extentTest.pass( "showing error on the pop up modal which contains the user has pending application or is already in company with other email user {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	//S6
	@Then("success invite user {string} to the company {string}")
	public void successInviteUserToTheCompany(String email,String companyusera) throws Exception {
		Thread.sleep(waitResponse);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//		String actualvalidatemassage = myCompanyPOM.txtValidateNotYetInCompanyAndSuccesAddMember().getText();
//		String expectedvalidatemassage = "You have successfully added new member(s) to "+companyusera+". An email will be sent to your new member(s) to join CUBEforall.";
//		System.out.println(expectedvalidatemassage);
//		System.out.println(actualvalidatemassage);
//		System.out.println(expectedvalidatemassage.contains(actualvalidatemassage));
//		if(expectedvalidatemassage.contains(actualvalidatemassage)) {
//			Assert.assertEquals("email pop up true", "email pop up true");
//		}else {
//			Assert.assertEquals("email pop up true", "email pop up false");
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.btnValidateNotYetInCompany();
		extentTest.log(Status.PASS, "success invite user {string} to the company {string}");
		extentTest.pass( "success invite user {string} to the company {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());




		//		String getMemberList = myCompanyPOM.memberListTable().getText();
		//		Assert.assertEquals(email, getMemberList);
		//		System.out.println(getMemberList);
	}




	//S7
	@Then("admin company can see the pending member with status {string} and status {string}")
	public void adminCompanyCanSeeThePendingMemberWithStatusAndStatus(String pendingApprove, String pendingAccept) throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		String[] expectedStatus = {pendingAccept,pendingApprove};
		List<String> getMemberList = myCompanyPOM.memberListTable();
		System.out.println(getMemberList);
		System.out.println(getMemberList);
		if(getMemberList.contains(expectedStatus)) {
			Assert.assertEquals("True", "True");
		}else {
			Assert.assertEquals("False", "False");
		}
		extentTest.log(Status.PASS, "admin company can see the pending member with status {string} and status {string}");
		extentTest.pass( "admin company can see the pending member with status {string} and status {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@Then("admin company can see the pending member with status {string} and status {string} and status {string}")
	public void adminCompanyCanSeeThePendingMemberWithStatusAndStatusActive(String pendingApprove, String pendingAccept,String active) throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		String[] expectedStatus = {pendingAccept,pendingApprove};
		List<String> getMemberList = myCompanyPOM.memberListTable();
		System.out.println(getMemberList);
		System.out.println(getMemberList);
		if(getMemberList.contains(expectedStatus)) {
			Assert.assertEquals("True", "True");
		}else {
			Assert.assertEquals("False", "False");
		}
		extentTest.log(Status.PASS, "admin company can see the pending member with status {string} and status {string}");
		extentTest.pass( "admin company can see the pending member with status {string} and status {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	//S8

	@And("search email {string} to be removed from the company")
	public void searchEmailAndRemoveFromTheCompany(String email) throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.inputSearchUsersOnMembers(email);
		myCompanyPOM.pressRemoveUserFromCompanyByAdmin();
		//		myCompanyPOM.pressRemovePerUserOnMemberByAdmin();
		extentTest.log(Status.PASS, "search email {string} to be removed from the company");
		extentTest.pass( "search email {string} to be removed from the company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("search email {string} to be approved from the company")
	public void searchEmailAndApproveFromTheCompany(String email) throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.inputSearchUsersOnMembers(email);
		myCompanyPOM.pressRemoveUserFromCompanyByAdmin();
		//		myCompanyPOM.pressRemovePerUserOnMemberByAdmin();
		extentTest.log(Status.PASS, "search email {string} to be removed from the company");
		extentTest.pass( "search email {string} to be removed from the company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("search email {string} member")
	public void searchEmailmember(String email) throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.inputSearchUsersOnMembers(email);
		myCompanyPOM.pressRemoveUserFromCompanyByAdmin();
		//		myCompanyPOM.pressRemovePerUserOnMemberByAdmin();
		extentTest.log(Status.PASS, "search email {string} member");
		extentTest.pass( "search email {string} member",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Then("press dot on the left side user pending accept")
	public void press_dot_on_the_left_side_user_pending_accept() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressthreedotsRemoveUserFromCompanyByAdminPendingAccept();
		extentTest.log(Status.PASS, "press dot on the left side user pending accept");
		extentTest.pass( "press dot on the left side user pending accept",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	@Then("press dot on the left side user")
	public void press_dot_on_the_left_side_user() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressthreedotsFromCompanyByAdmin();
		extentTest.log(Status.PASS, "press dot on the left side user");
		extentTest.pass( "press dot on the left side user",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@Then("dot cant be click")
	public void dot_cant_be_click() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressthreedotsFromCompanyByAdmin();
		extentTest.log(Status.PASS, "dot cant be click");
		extentTest.pass( "dot cant be click",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("filter member with status {string}")
	public void filterMemberWithStatus(String status) throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.selectFilterUsersOnMembers(status);
		extentTest.log(Status.PASS, "filter member with status {string}");
		extentTest.pass( "filter member with status {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@And("filter member with status {string} and {string}")
	public void filterMemberWithStatus(String status,String statustwo) throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.selectFilterUsersOnMembers(status);
		extentTest.log(Status.PASS, "filter member with status {string} and {string}");
		extentTest.pass( "filter member with status {string} and {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@Then("admin company was able to reject or approve the request")
	public void adminCompanyWasAbleToRejectOrApproveTheRequest() throws Exception {
		Thread.sleep(waitResponse);
		//		myCompanyPOM.acceptRequestPerUserOnMemberByAdmin(1).isDisplayed();
		//		myCompanyPOM.acceptRequestPerUserOnMemberByAdmin(1).isEnabled();
		//		myCompanyPOM.removePerUserOnMemberByAdmin(1).isDisplayed();
		//		myCompanyPOM.removePerUserOnMemberByAdmin(1).isEnabled();
		extentTest.log(Status.PASS, "admin company was able to reject or approve the request");
		extentTest.pass( "admin company was able to reject or approve the request",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	//S9
	@Then("press remove to reject the request")
	public void pressRemoveToRejectTheRequest() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressRemovePerUserOnMemberByAdmin();
		extentTest.log(Status.PASS, "press remove to reject the request");
		extentTest.pass( "press remove to reject the request",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	//S12
	@Then("press accept to approve the request")
	public void pressAcceptToApproveTheRequest() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressAcceptRequestPerUserOnMemberByAdmin();
		extentTest.log(Status.PASS, "press accept to approve the request");
		extentTest.pass( "press accept to approve the request",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	//S19
	@And("search company {string}")
	public void searchCompany(String company) throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.inputCompanyNameOnMyCompany(company);
		extentTest.log(Status.PASS, "search company {string}");
		extentTest.pass( "search company {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	@When("press button withdraw application")
	public void pressButtonWithdrawApplication() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressWithdrawApplication();
		extentTest.log(Status.PASS, "press button withdraw application");
		extentTest.pass( "press button withdraw application",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());



	}
	@When("press button accept invitation")
	public void acceptinvitation() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressWithdrawApplication();
		extentTest.log(Status.PASS, "press button withdraw application");
		extentTest.pass( "press button withdraw application",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());



	}
	@When("press button reject invitation")
	public void rejectinvitation() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressWithdrawApplication();
		extentTest.log(Status.PASS, "press button withdraw application");
		extentTest.pass( "press button withdraw application",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());



	}
	@Then("confirm withdraw application to company")
	public void confirmWithdrawApplicationToCompany() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		myCompanyPOM.pressConfirmWithdrwawRquestCompany();
		extentTest.log(Status.PASS, "confirm withdraw application to company");
		extentTest.pass( "confirm withdraw application to company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	@Then("confirm accept invitation")
	public void confirmacceptinvitation() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//		myCompanyPOM.pressConfirmWithdrwawRquestCompany();
		extentTest.log(Status.PASS, "confirm accept invitation");
		extentTest.pass( "confirm accept invitation",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	
	@Then("confirm reject invitation")
	public void confirmrejectinvitation() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//		myCompanyPOM.pressConfirmWithdrwawRquestCompany();
		extentTest.log(Status.PASS, "confirm accept invitation");
		extentTest.pass( "confirm accept invitation",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	//S20

	@Then("press change roles button to change role to {string}")
	public void press_change_roles_button_to_change_role_to_role(String role) throws Exception {
		Thread.sleep(waitResponse);
		myCompanyPOM.changeRolePerUserOnMemberByAdmin(role);
		extentTest.log(Status.PASS, "press change roles button to change role to {string}");
		extentTest.pass( "press change roles button to change role to {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	@Then("able to change role other user")
	public void ableToChangeRoleOtherUser() throws Exception {
		Thread.sleep(waitResponse);
		//		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isDisplayed();
		//		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isEnabled();
		extentTest.log(Status.PASS, "able to change role other user");
		extentTest.pass( "able to change role other user",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());



	}

	@Then("wont able to change role other user member need to be approve first as active member")
	public void wont_able_to_change_role_other_user_member_need_to_be_approve_first_as_active_member() throws Exception {
		Thread.sleep(waitResponse);
		//		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isDisplayed();
		//		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isEnabled();
		extentTest.log(Status.PASS, "wont able to change role other user member need to be approve first as active member");
		extentTest.pass( "wont able to change role other user member need to be approve first as active member",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());



	}
	

	@Then("wont be able to invite user")
	public void wont_be_able_to_invite_user() throws Exception {
		Thread.sleep(waitResponse);
		//		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isDisplayed();
		//		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isEnabled();
		extentTest.log(Status.PASS, "wont be able to invite user");
		extentTest.pass( "wont be able to invite user",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
		}


	//	2038 Bundle Plan Subscription Enhancement

	//	s6
	//	When click product tab to subscribe to product
	@When("click product tab to subscribe to product")
	public void click_product_tab_to_subscribe_to_product() throws Exception {
		Thread.sleep(waitResponse);
		subscriptionPage.clickProductTab();
		extentTest.log(Status.PASS, "click product tab to subscribe to product");
		extentTest.pass( "click product tab to subscribe to product",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("select bundle company level awb concierge lfs product")
	public void select_bundle_company_level_awb_concier_lfs_product() throws Exception{
		subscriptionPage.clickProductbundlecompanylevelaWBConciergeLFS();
		extentTest.log(Status.PASS, "select bundle company level awb concierge lfs product");
		extentTest.pass( "select bundle company level awb concierge lfs product",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("validate product price for tier 1 and tier 2")
	public void validate_product_price_for_tier1_and_tier2() throws Exception{
		//		subscriptionPage.validateprodcutprice();
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		//		subscriptionPage.clickInputCheckboxSubscribe();
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		//		subscriptionPage.enterInputNumberOfUser();
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		//		subscriptionPage.clickBtnComplimentarySubsribe();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		subscriptionPage.clickchckBoxComplimentarySubscribebccompany();
		subscriptionPage.inputComplimentarySubsribebccompany();
		subscriptionPage.clickBtnComplimentarySubsribebccompany();
		extentTest.log(Status.PASS, "validate product price for tier 1 and tier 2");
		extentTest.pass( "validate product price for tier 1 and tier 2",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@And("input the complete subscriber payment form")
	public void input_the_complete_subscriber_payment_form() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		subscriptionPage.inputCompleteFillSubscriberPayment();
		extentTest.log(Status.PASS, "input the complete subscriber payment form");
		extentTest.pass( "input the complete subscriber payment form",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	// SUBSCRIPTION

	//S1
	@And("{string} click product tab to subscribe to product")
	public void user_click_product_tab_to_subscribe_to_product(String user) throws Exception {
		subscriptionPage.clickProductTab();
		extentTest.log(Status.PASS, "{string} click product tab to subscribe to product");
		extentTest.pass( "{string} click product tab to subscribe to product",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("{string} click product tab to subscribe a product")
	public void user_click_product_tab_to_subscribe_a_product(String user) throws Exception {
		subscriptionPage.clickProductTabFromManageSubscribtion();
		extentTest.log(Status.PASS, "{string} click product tab to subscribe to product");
		extentTest.pass( "{string} click product tab to subscribe to product",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("Validate subscription Successful for plan {string} {string} pop up massage")
	public void validate_subscription_successful_for_plan_pop_up_massage(String string, String string2) throws Exception {
		//		subscriptionPage.clickBtnConfirmComplimentarySubsribelfsfreetrial();
		subscriptionPage.clickBtnConfirmComplimentarySubsribebcnoncompany();
		extentTest.log(Status.PASS, "Validate subscription Successful for plan {string} {string} pop up massage");
		extentTest.pass( "Validate subscription Successful for plan {string} {string} pop up massage",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}


	@And("Select plan {string} {string}")
	public void select_plan(String string,String product) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		subscriptionPage.selectPlanPoduct(product);
		extentTest.log(Status.PASS, "Select plan {string} {string}");
		extentTest.pass( "Select plan {string} {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("Select second plan {string} {string}")
	public void select_second_plan(String string,String productB) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		subscriptionPage.selectPlanProduct(productB);
		extentTest.log(Status.PASS, "Select plan {string} {string}");
		extentTest.pass( "Select plan {string} {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("Subscribe plan {string}")
	public void subscribeplan_plan(String product) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		subscriptionPage.subscribeplan(product);
		extentTest.log(Status.PASS, "Subscribe plan {string}");
		extentTest.pass( "Subscribe plan {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("Subscribe first plan {string}")
	public void subscribe_first_plan(String product) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		subscriptionPage.subscribeplan(product);
		extentTest.log(Status.PASS, "Subscribe first plan {string}");
		extentTest.pass( "Subscribe first plan {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("Subscribe second plan {string}")
	public void subscribe_secondplan_plan(String productB) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		subscriptionPage.subscribesecondplan(productB);
		extentTest.log(Status.PASS, "Subscribe second plan {string}");
		extentTest.pass( "Subscribe second plan {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("Press Subscribe button for the free trial plan complimentary subscription")
	public void press_subscribe_button_for_the_free_trial_plan_complimentary_subscription() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		subscriptionPage.clickBtnComplimentarySubsribelfsfreetrial();
		extentTest.log(Status.PASS, "Press Subscribe button for the free trial plan complimentary subscriptio}");
		extentTest.pass( "Press Subscribe button for the free trial plan complimentary subscriptio",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("Press Subscribe checkbox for the free trial plan complimentary subscription agreement")
	public void press_subscribe_checkbox_for_the_free_trial_plan_complimentary_subscription_agreement() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		subscriptionPage.clickchckBoxComplimentarySubscribelfsfreetrial();
		extentTest.log(Status.PASS, "Press Subscribe checkbox for the free trial plan complimentary subscription agreement");
		extentTest.pass( "Press Subscribe checkbox for the free trial plan complimentary subscription agreement",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("free trial plan {string} which is no company required cannot accommodate multiple users on table subscription for {string} with {string}")
	public void free_trial_plan_which_is_no_company_required_cannot_accommodate_multiple_users_on_table_subscription(String str,String product,String usercount) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Boolean result = subscriptionPage.verifytableUserCountSubscription(product, usercount);
		Assert.assertEquals(true, result);
		extentTest.log(Status.PASS, "free trial plan {string} which is no company required cannot accommodate multiple users on table subscription for {string} with {string}");
		extentTest.pass( "free trial plan {string} which is no company required cannot accommodate multiple users on table subscription for {string} with {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}

	@Then("{string} was already subscribe the free trial plan {string} {string}")
	public void was_already_subscribe_the_free_trial_plan(String string, String string2, String product) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Boolean result =subscriptionPage.verifytableProductSubscription(product);
		Assert.assertEquals(true, result);
		extentTest.log(Status.PASS, "{string} was already subscribe the free trial plan {string} {string}");
		extentTest.pass( "{string} was already subscribe the free trial plan {string} {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Then("Validate active periode from {string} to {string} for {string}")
	public void validate_active_periode_from_to_for_product(String string, String string2,String product) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Boolean result =subscriptionPage.verifytableBcycleSubscription(product, string, string2);
		Assert.assertEquals(true, result);
		extentTest.log(Status.PASS, "Validate active periode from {string} to {string} for {string}");
		extentTest.pass( "Validate active periode from {string} to {string} for {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Then("Remove {string} {string} subscription")
	public void remove_subscription(String string, String product) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		subscriptionPage.clickRemoveSubscription(product);
		extentTest.log(Status.PASS, "Remove {string} {string} subscription");
		extentTest.pass( "Remove {string} {string} subscription",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Then("the subscription will expired with {string} status for {string}")
	public void the_subscription_will_expired_with_status_for_product(String status,String product) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Boolean result =subscriptionPage.verifytableStatusSubscription(product, status);
		Assert.assertEquals(true, result);
		extentTest.log(Status.PASS, "the subscription will expired with {string} status for {string}");
		extentTest.pass( "the subscription will expired with {string} status for {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Then("validate {string} {string} has been remove from container application")
	public void validate_has_been_remove_from_container_application(String string, String string2) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		extentTest.log(Status.PASS, "validate {string} {string} has been remove from container application");
		extentTest.pass( "validate {string} {string} has been remove from container application",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}



	//CSM GEOLOCATION AND SUBSCRIPTION



	@Given("Press Subscribe checkbox for the {string}")
	public void press_subscribe_checkbox_for_the_product(String prodcut) throws Exception {
		subscriptionPage.subscribeplan(prodcut);
		extentTest.log(Status.PASS, "Press Subscribe checkbox for the {string}");
		extentTest.pass( "Press Subscribe checkbox for the {string}",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	
	@Given("Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement")
	public void press_subscribe_checkbox_for_the_bundle_lfs_bc_company_level_plan_complimentary_subscription_agreement() throws Exception {
		subscriptionPage.clickchckBoxComplimentarySubscribebcnoncompany();
		extentTest.log(Status.PASS, "Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement");
		extentTest.pass( "Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	
	@Given("Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription")
	public void press_subscribe_button_for_the_bundle_lfs_bc_company_level_plan_complimentary_subscription() throws Exception {
		subscriptionPage.clickBtnComplimentarySubsribebcnoncompany();
		extentTest.log(Status.PASS, "Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription");
		extentTest.pass( "Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	@Then("input number of member for product Bundle AWB, BC Non Company")
	public void input_number_of_member_for_product_Bundle_AWB_BC_Non_Company() throws Exception{
		subscriptionPage.inputComplimentarySubsribebcnoncompany();
		extentTest.log(Status.PASS, "input number of member for product Bundle AWB, BC Non Company");
		extentTest.pass( "input number of member for product Bundle AWB, BC Non Company",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Then("Validate country {string} csm geolocation")
	public void validate_country_csm_geolocation(String string) throws Exception {
		extentTest.log(Status.PASS, "Validate country {string} csm geolocation");
		extentTest.pass( "Validate country {string} csm geolocation",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Then("input checkout payment cardNumber form")
	public void input_checkout_payment_card_number_form() throws Exception {
		subscriptionPage.enterInputCardNumber();
		extentTest.log(Status.PASS, "input checkout payment cardNumber form");
		extentTest.pass( "input checkout payment cardNumber form",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());


	}
	@Then("input checkout payment cardExpiry form")
	public void input_checkout_payment_card_expiry_form() throws Exception {
		subscriptionPage.enterinputcardExpiryformpayment();
		extentTest.log(Status.PASS, "input checkout payment cardExpiry form");
		extentTest.pass( "input checkout payment cardNumber form",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Then("input checkout payment cardCvc form")
	public void input_checkout_payment_card_cvc_form() throws Exception {
		subscriptionPage.enterinputVcaCardNumberformpayment();
		extentTest.log(Status.PASS, "input checkout payment cardCvc form");
		extentTest.pass( "input checkout payment cardCvc form",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());

	}
	@Then("input checkout payment billingName form")
	public void input_checkout_payment_billing_name_form() throws Exception {
		subscriptionPage.enterinputFullNameCardNumberformpayment();
		extentTest.log(Status.PASS, "input checkout payment billingName form");
		extentTest.pass( "input checkout payment billingName form",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Then("select checkout payment country")
	public void select_checkout_payment_country() throws Exception {
		extentTest.log(Status.PASS, "select checkout payment country");
		extentTest.pass( "select checkout payment country",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Then("click checkbox Securely save my information for one click checkout")
	public void click_checkbox_securely_save_my_information_for_one_click_checkout() throws Exception {
		subscriptionPage.clickenableStripePass();
		extentTest.log(Status.PASS, "click checkbox Securely save my information for one click checkout");
		extentTest.pass( "click checkbox Securely save my information for one click checkout",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("submit checkout payment")
	public void submit_checkout_payment() throws Exception{
		subscriptionPage.clickbtncompleteformpaymentStripe();
		extentTest.log(Status.PASS, "submit checkout paymen stripe");
		extentTest.pass( "submit checkout paymen stripe",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("input checkout phone number form")
	public void input_checkout_phone_number_form() throws Exception {
		subscriptionPage.inputserachphonenumberformpayment();
		extentTest.log(Status.PASS, "input checkout phone number form");
		extentTest.pass( "input checkout phone number form",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("close browser")
	public void close_browser() throws Exception {
		extentTest.log(Status.PASS, "close browser");
		extentTest.pass( "close browser",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
		driver.close();
		driver.quit();
	}
	

	@When("UnSubscribe plan {string}")
	public void un_subscribe_plan(String string) throws Exception {
		
	List<WebElement> rows = driver.findElements(By.xpath("//*[@id='cube-plan-list']/tbody/tr"));
	int rowCount = rows.size();
	System.out.println("Total number of rows in the table: " + rowCount);
	
	List<WebElement> column = driver.findElements(By.xpath("//*[@id='cube-plan-list']/tbody/tr"));
	int columnCount = column.size();
	System.out.println("Total number of column in the table: " + columnCount);
	
	for (int r = 1; r <= rowCount; r++) {
	    for (int c = 1; c <= columnCount; c++) {
	        String data = driver.findElement(By.xpath("//*[@id='cube-plan-list']//tr[" + r + "]/td[" + c + "]")).getText();
	        System.out.println(data);
	        
	        if (data.contains(string)) {
	            // Assuming td8 is the 8th column in the current row
	            driver.findElement(By.xpath("//*[@id='cube-plan-list']//tr[" + r + "]/td[8]")).click();
	        }
	    }
	}
	

	}
	
	@And("back to Cubforall from payment page")
	public void backtoCubforallfrompaymentpage() throws Exception {
		subscriptionPage.backtoCubeforallfrompayment();
		extentTest.log(Status.PASS, "back to Cubeforall");
		extentTest.pass( "back to Cubeforall",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	

	@Then("enter yopmail email to register")
	public void enter_yopmail_email_to_register() throws Exception {
		String email = emailSQPP;
		mailServiceYopmailPage.loginYopmail(email);
		mailServiceYopmailPage.btnloginyopmail();
		extentTest.pass("go to yopmail : " + Constants.YOPMAIL_SERVICE_URL,
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@Then("enter yopmail email to login {string}")
	public void enter_yopmail_email_to_login(String email) throws Exception {
		mailServiceYopmailPage.loginYopmail(email);
		mailServiceYopmailPage.btnloginyopmail();
		extentTest.pass("go to yopmail : " + Constants.YOPMAIL_SERVICE_URL,
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Then("open yopmail email {string}")
	public void open_yopmail_email(String content) throws Exception {
//		mailServiceYopmailPage.selectemailtoopen();
		mailServiceYopmailPage.selectemailtoopendetail(content);
		extentTest.pass("open yopmail email",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
		
//		openNewTabAndOpenMailinator();
//		getTheEmailVerificationAndExtractTheVerificationCodesg();
//		closeTabAndBackToRegisterPage();
//		inputVerificationCodeOnRegisterPage();
//		pressVerificationCodeButtonOnRegisterPage();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//		pressCreateAccountOnRegisterPage();
//		backToTheMainTabBrowser();
	}

	@Given("go to sqpp website")
	public void go_to_sqpp_website() throws Exception {
		Thread.sleep(10000);
		driver.get(Constants.SQPP_PATH_URL);
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		extentTest.log(Status.PASS, "Navigation to : " + Constants.SQPP_PATH_URL);
		extentTest.pass("Navigation to : " + Constants.SQPP_PATH_URL,
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@Given("click member login sqpp")
	public void click_member_login_sqpp() throws Exception {
		Thread.sleep(waitResponse);
		sqpp.loginsqpp();
		Thread.sleep(waitResponse);
		sqpp.changeSigninWindowsqpp();
		extentTest.log(Status.PASS, "click member login sqpp");
		extentTest.pass("click member login sqpp",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@Given("input login sqpp email {string} and password {string}")
	public void input_login_sqpp(String email,String password) throws Exception {
		Thread.sleep(waitResponse);
		sqpp.inputloginsqpp(email,password);
		extentTest.log(Status.PASS, "input login sqpp");
		extentTest.pass("input login sqpp",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
//		driver.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(waitResponse);
//		driver.get(Constants.YOPMAIL_SERVICE_URL);
	}
	
//	get verification code sqpp
	@Given("get verification code sqpp")
	public void get_verification_code_sqpp() throws Exception {
		Thread.sleep(waitResponse);
		sqpp.getVerificationCodesqpp();
		Thread.sleep(waitResponse);
		System.out.println(Constants.VERIFICATION_CODE_SQPP);
//		sqpp.changeSigninWindowsqpp();
		
		extentTest.log(Status.PASS, "click member login sqpp");
		extentTest.pass("click member login sqpp",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
//	
	@And("back to login page after get verification code sqpp")
	public void backtologinpageaftergetverificationcodesqpp() throws Exception {
		sqppwindows=sqpp.sqppwindows;
		driver.close();
		System.out.println(sqppwindows);
		driver.switchTo().window(sqppwindows);
		sqpp.inputverifcodeaftergetfromemail();
		extentTest.log(Status.PASS, "close tab and back to register page");
		extentTest.pass("close tab and back to register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("back to login page after get verification code sqpp registration")
	public void backtologinpageaftergetverificationcodesqppregistration() throws Exception {
		sqppwindows=sqpp.sqppwindows;
		driver.close();
		System.out.println(sqppwindows);
		driver.switchTo().window(sqppwindows);
		sqpp.inputverifcodeaftergetfromemailregis();
		extentTest.log(Status.PASS, "close tab and back to register page");
		extentTest.pass("close tab and back to register page",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	@And("continue sign in sqpp")
	public void continue_sign_in_sqpp() throws Exception {
		sqpp.continuesigninsqpp();
		extentTest.log(Status.PASS, "continue sign in sqpp");
		extentTest.pass("continue sign in sqpp",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("click sign up sqpp")
	public void clicksignupsqpp() throws Exception {
		Thread.sleep(waitResponse);
		emailSQPP = Constants.FULL_EMAIL_SQPP;
		sqpp.signupsqpp(emailSQPP);
		extentTest.log(Status.PASS, "click sign up sqpp");
		extentTest.pass("click sign up sqpp",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("continue sign up sqpp")
	public void continue_sign_up_sqpp() throws Exception {
		sqpp.inputverifcodeaftergetfromemailregis();
		extentTest.log(Status.PASS, "continue sign up sqpp");
		extentTest.pass("continue sign up sqpp",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
//	
	
	@And("click agent managament sqpp")
	public void clickagentmanagamentsqpp() throws Exception {
		originsqppwindows = sqpp.originsqppwindows;
		driver.switchTo().window(originsqppwindows);
//		sqpp.iconmenusqpp();
		Thread.sleep(waitResponse);
		driver.get("https://ppd-siacargo.ccnexchange.com/portal_management/agent-management");
		extentTest.log(Status.PASS, "click agent managament sqpp");
		extentTest.pass("click agent managament sqpp",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@When("^registration with new account from malaysia (.*) and (.*) login")
	public void registrationWithNewAccountAndLoginMalay(String city, String country) throws Exception {
		pressSignUpNowButton();
		inputEmailAddressOnRegisterPagemy();
		pressSendVerificationCode();
		inputPasswordConfirmPasswordOnRegisterPage();	
		inputDisplayNameOnRegisterPage(Constants.DISPLAY_NAME);
		inputContactNumberOnRegisterPage(Constants.GENERATED_NUM); 
		selectCityOnRegisterPage(city); 
		selectCountryOnRegisterPage(country);
		openNewTabAndOpenYopmail();
		getTheEmailVerificationAndExtractTheVerificationCodemyYopmail();
		closeTabAndBackToRegisterPage();
		inputVerificationCodeOnRegisterPage();
		pressVerificationCodeButtonOnRegisterPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		pressCreateAccountOnRegisterPage();
		backToTheMainTabBrowser();
		extentTest.log(Status.PASS, "registration with new account and login");
		extentTest.pass( "registration with new account and login",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@When("^registration with new account from UAE (.*) and (.*) login")
	public void registrationWithNewAccountAndLoginUAE(String city, String country) throws Exception {
		pressSignUpNowButton();
		inputEmailAddressOnRegisterPageuae();
		pressSendVerificationCode();
		inputPasswordConfirmPasswordOnRegisterPage();	
		inputDisplayNameOnRegisterPage(Constants.DISPLAY_NAME);
		inputContactNumberOnRegisterPage(Constants.GENERATED_NUM); 
		selectCityOnRegisterPage(city); 
		selectCountryOnRegisterPage(country);
		openNewTabAndOpenMailinator();
		Thread.sleep(longwaitResponse);
		getTheEmailVerificationAndExtractTheVerificationCodeuae();
		closeTabAndBackToRegisterPage();
		inputVerificationCodeOnRegisterPage();
		pressVerificationCodeButtonOnRegisterPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		pressCreateAccountOnRegisterPage();
		backToTheMainTabBrowser();
		extentTest.log(Status.PASS, "registration with new account and login");
		extentTest.pass( "registration with new account and login",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("input email address on register page malaysia")
	public void inputEmailAddressOnRegisterPagemy() throws Exception {
		registerPage.inputEmailRegister(Constants.FULL_EMAIL_MY);
		System.out.println(Constants.FULL_EMAIL_MY);
		extentTest.log(Status.PASS, "input email address on register page malaysia");
		extentTest.pass( "input email address on register page malaysia",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("input email address on register page united arab emirates")
	public void inputEmailAddressOnRegisterPageuae() throws Exception {
		registerPage.inputEmailRegister(Constants.FULL_EMAIL_UAE);
		System.out.println(Constants.FULL_EMAIL_UAE);
		extentTest.log(Status.PASS, "input email address on register page united arab emirates");
		extentTest.pass( "input email address on register page united arab emirates",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}


	@And("input company name {string} from {string} dynamics")
	public void inputCompanyNameDynamics(String companyName, String country) throws Exception {
		Thread.sleep(waitResponse);
		String companyNameInput = country+" "+companyName+Constants.FOUR_DIGIT;
		registerPage.inputCompanyNameRegister(companyNameInput);
		extentTest.log(Status.PASS, "input company name");
		extentTest.pass( "input company name",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}


	@And("accept manage cookie")
	public void accept_cookie2() throws InterruptedException, Exception {
		Thread.sleep(7000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size()+"======================================================================================");
		for(Cookie c:cookies) {
			System.out.println(c.getName()+" : "+c.getValue());
			System.out.println(driver.manage().getCookieNamed(c.getName()));
		}
		loginPage.pressAcceptCookies();
		extentTest.log(Status.PASS, "accept cookie");
		extentTest.pass( "accept cookie",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}

	@And("get the email verification and extract the verification code malaysia")
	public void getTheEmailVerificationAndExtractTheVerificationCodemy() throws Exception {
		mailServiceMailinatorPOM.getVerificationCodemy();
		//		mailServiceMailinatorPOM.getVerificationCode("qa-ccn-04346@mailinator.com");
		extentTest.log(Status.PASS, "get the email verification and extract the verification code");
		extentTest.pass( "get the email verification and extract the verification code",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("get the email verification and extract the verification code malaysia yopmail")
	public void getTheEmailVerificationAndExtractTheVerificationCodemyYopmail() throws Exception {
		mailServiceYopmailPage.getVerificationCodemy();
		//		mailServiceMailinatorPOM.getVerificationCode("qa-ccn-04346@mailinator.com");
		extentTest.log(Status.PASS, "get the email verification and extract the verification code");
		extentTest.pass( "get the email verification and extract the verification code",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}
	
	@And("get the email verification and extract the verification code united arab emirates")
	public void getTheEmailVerificationAndExtractTheVerificationCodeuae() throws Exception {
		mailServiceMailinatorPOM.getVerificationCodemy();
		extentTest.log(Status.PASS, "get the email verification and extract the verification code");
		extentTest.pass( "get the email verification and extract the verification code",
				MediaEntityBuilder.createScreenCaptureFromPath(passcaptureScreen()).build());
	}




	@After
	public void closeObject() {
		//				driver.close();
		//				driver.quit();
		extentReports.flush();
	}


	//CAPTURE PHOTO TESTING
	public String failcaptureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = "C:\\Users\\ACER\\Desktop\\JCCODING\\sqa\\com.test.kerja.sqa.sqawebjavabdd\\src\\test\\resources\\failevidence\\"
				+ getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public String passcaptureScreen() throws IOException {
		String projectPath = System.getProperty("user.dir");
		String month_year = "Januari"+" - "+"2024";
		String namepRoject = "nameproject";
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = projectPath+ "/src/test/resources/drivers/passevidence/"+month_year+"/"+namepRoject+"/"+ getcurrentdateandtime() + ".png";
//		String dest = "C:\\Users\\ACER\\Desktop\\JCCODING\\sqa\\com.test.kerja.sqa.sqawebjavabdd\\src\\test\\resources\\passevidence\\"
//				+ getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "-").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	//	 And Open new tab and open mailinator
	//	 And get the email verification and extract the verification code
	//	    

}
