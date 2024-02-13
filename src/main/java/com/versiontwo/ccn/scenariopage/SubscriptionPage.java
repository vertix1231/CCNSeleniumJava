package com.versiontwo.ccn.scenariopage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.versiontwo.ccn.driver.DriverSingleton;

public class SubscriptionPage {
	private WebDriver driver;

	public SubscriptionPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	private int waitResponse = 3000;
	private int longwaitResponse = 15000;
	@FindBy(xpath = "//*[@id=\"menu-item-629\"]/span/a")
	@CacheLookup
	private WebElement productTab;
	
	@FindBy(xpath = "//a[contains(@href, 'sandbox.cubeforall.com/freight-forwarder/freight-operations-management/')]")
	@CacheLookup
	private WebElement productTabFromManageSubscribtion;

	@FindBy(xpath = "//*[@id=\"nav\"]/ul/li[11]/a")
	@CacheLookup
	private WebElement bundlecompanylevelaWBConciergeLFS;
	// @FindBy(xpath="//*[@id=\"freight\"]/div/div[2]/article/div[3]/div/div/cp-subscribe-button//div/div/div[2]/div[1]/input")
	// @CacheLookup
	// private WebElement inputCheckboxSubscribe;

	@FindBy(xpath = "//*[@id=\"enableStripePass\"]")
	@CacheLookup
	private WebElement clickchckEnableStripePass;

	@FindBy(css = "div > div > div.cube-subscribe-tnc-container > div.cube-subscribe-checkbox-container > #cube-subscribe-btn-checkbox-655da5ac0b5c91406fe80257")
	@CacheLookup
	private WebElement inputCheckboxSubscribe;
	@FindBy(xpath = "//*[@id=\"freight\"]/div/div[2]/article/div[3]/div/div/cp-subscribe-button//div/div/div[3]/div/div/input")
	@CacheLookup
	private WebElement inputUser;
	@FindBy(xpath = "//*[@id=\"cardNumber\"]")
	@CacheLookup
	private WebElement inputCardNumberformpayment;
	@FindBy(xpath = "//*[@id=\"search-phoneNumber\"]")
	@CacheLookup
	private WebElement inputserachphonenumberformpayment;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/main/div/div[2]/form/div[2]/div/div[2]/button")
	@CacheLookup
	private WebElement SubmitButtoncompleteformpaymentStripe;

	@FindBy(xpath = "//*[@id=\"phoneNumber\"]")
	@CacheLookup
	private WebElement inputphoneNumberformpayment;
	@FindBy(xpath = "//*[@id=\"cardExpiry\"]")
	@CacheLookup
	private WebElement inputcardExpiryformpayment;
	@FindBy(xpath = "//*[@id=\"cardCvc\"]")
	@CacheLookup
	private WebElement inputVcaCardNumberformpayment;
	@FindBy(xpath = "//*[@id=\"billingName\"]")
	@CacheLookup
	private WebElement inputFullNameCardNumberformpayment;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/form/div[2]/div/div[2]/button/div[3]")
	@CacheLookup
	private WebElement btnSubmitSubscribea;
	@FindBy(xpath = "//*[@id=\"toppage\"]/header/div[2]/div[2]/div[2]/div[2]/wc-login/div/div/div")
	@CacheLookup
	private WebElement accounticon;
	@FindBy(xpath = "//*[@id=\"toppage\"]/header/div[2]/div[2]/div[2]/div[2]/wc-login/div/div/div[2]/div[2]/div[3]/a")
	@CacheLookup
	private WebElement iconMenuMysubscription;

	// Product
	@FindBy(xpath = "//*[@id=\"nav\"]/ul/li")
	@CacheLookup
	private List<WebElement> lsPlanProduct;
	
	// Product
	@FindBy(xpath = "//a[text()='Lead Freight Solutions']")
	@CacheLookup
	private WebElement lfsProduct;

	@FindBy(xpath = "//*[@id=\"cube-subscribe-modal-btn-6566e1f8669e862c02256095\"]")
	@CacheLookup
	private WebElement btnSuccesSubscribeLFSTrial;
	
	
	@FindBy(xpath = "//input[@id='cube-subscribe-btn-checkbox-6389c85e089c75ff462d9911']")
	@CacheLookup
	private WebElement inputCheckboxSubscribeMulti;
	
	@FindBy(xpath = "//a[@href='https://sandbox.cubeforall.com/portal/manage-subscription']")
	@CacheLookup
	private WebElement backfrompayment;
	
	
	private SearchContext shadowDomcpsubscribe() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(waitResponse);
		WebElement root = driver.findElement(By.tagName("cp-subscribe-button"));
		SearchContext shadowDomcpsubscribe = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		return shadowDomcpsubscribe;
	}
	private SearchContext shadowDomcpsubscribesecond() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(waitResponse);
		WebElement root = driver.findElement(By.xpath("(//cp-subscribe-button[@cp_service_id='2ccbe74c-493b-47a4-8dee-80bdb147e895'])[2]"));
//		SearchContext shadowDomcpsubscribe = (SearchContext) js.executeScript("return arguments[1].shadowRoot", root);
		SearchContext shadowDomcpsubscribe = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
		return shadowDomcpsubscribe;
	}
	
//	private SearchContext backfromsubscribelfsmulti() throws Exception {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		Thread.sleep(waitResponse);
//		WebElement root = driver.findElement(By.tagName("cp-subscribe-button"));
////		SearchContext shadowDomcpsubscribe = (SearchContext) js.executeScript("return arguments[1].shadowRoot", root);
//		SearchContext shadowDomcpsubscribe = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
//		return shadowDomcpsubscribe;
//	}

	private void subscribelfstrianonedayplan() throws Exception {
		clickchckBoxComplimentarySubscribelfsfreetrial();
		clickBtnComplimentarySubsribelfsfreetrial();
		clickBtnConfirmComplimentarySubsribelfsfreetrial();

	}

	// LFS FREE TRIAL
	public void clickchckBoxComplimentarySubscribelfsfreetrial() throws Exception {
		Thread.sleep(waitResponse);
		WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6566e1f8669e862c02256095"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
		chckBoxComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		chckBoxComplimentarySubscribee.click();
	}

	public void clickBtnComplimentarySubsribelfsfreetrial() throws Exception {
		Thread.sleep(waitResponse);
		WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("button#cube-subscribe-btn-6566e1f8669e862c02256095"));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
		btnComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnComplimentarySubscribee.click();
	}

	public void clickBtnConfirmComplimentarySubsribelfsfreetrial() throws Exception {
		Thread.sleep(waitResponse);
		WebElement element = shadowDomcpsubscribe()
				.findElement(By.cssSelector("div#cube-subscribe-modal-btn-6566e1f8669e862c02256095"));
		System.out.println("element is display: " + element.isDisplayed());
		element.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		element.click();
	}

	// Bundle (LFS BC) Company Level

	private void subscribebundlelfsbc() throws Exception {
		clickchckBoxComplimentarySubscribebccompany();
		clickBtnComplimentarySubsribebccompany();
		inputComplimentarySubsribebccompany();

	}

	public void clickchckBoxComplimentarySubscribebccompany() throws Exception {
		Thread.sleep(waitResponse);
		WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-657c09640cc0f27d570a3db8"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
		chckBoxComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		chckBoxComplimentarySubscribee.click();
	}

	public void clickBtnComplimentarySubsribebccompany() throws Exception {
		Thread.sleep(waitResponse);
		WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("button#cube-subscribe-btn-657c09640cc0f27d570a3db8"));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
		btnComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnComplimentarySubscribee.click();
	}

	public void inputComplimentarySubsribebccompany() throws Exception {
		Thread.sleep(waitResponse);
		WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("input#cube-subscribe-btn-input-657c09640cc0f27d570a3db8"));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
		btnComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnComplimentarySubscribee.sendKeys("3");
		;
	}

	// bc non company level
	private void subscribebundleawbbcplan() throws Exception {
		clickchckBoxComplimentarySubscribebcnoncompany();
		clickBtnComplimentarySubsribebcnoncompany();
		inputComplimentarySubsribebcnoncompany();

	}

	public void clickchckBoxComplimentarySubscribebcnoncompany() throws Exception {
		Thread.sleep(waitResponse);
		WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-657c08880cc0f27d570a3ac8"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
		chckBoxComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		chckBoxComplimentarySubscribee.click();
	}

	public void clickBtnComplimentarySubsribebcnoncompany() throws Exception {
		Thread.sleep(waitResponse);
		WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("button#cube-subscribe-btn-657c08880cc0f27d570a3ac8"));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
		btnComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnComplimentarySubscribee.click();
	}

	public void inputComplimentarySubsribebcnoncompany() throws Exception {
		Thread.sleep(waitResponse);
		WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("input#cube-subscribe-btn-input-657c08880cc0f27d570a3ac8"));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
		btnComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnComplimentarySubscribee.sendKeys("3");
		;
	}

	public void clickBtnConfirmComplimentarySubsribebcnoncompany() throws Exception {
		Thread.sleep(waitResponse);
		WebElement element = shadowDomcpsubscribe()
				.findElement(By.cssSelector("div#cube-subscribe-modal-btn-657c08880cc0f27d570a3ac8"));
		System.out.println("element is display: " + element.isDisplayed());
		element.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		element.click();
	}

	// moaah starter plan
//	moaahstarterplan
	private void subscribemoaahstarterplan() throws Exception {
		clickchckBoxmoaahstarterplan();
		clickBtnSubscribemoaahstarterplan();
		inputCompleteFillSubscriberPayment();
		

	}

	public void clickchckBoxmoaahstarterplan() throws Exception {
		Thread.sleep(waitResponse);
		WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-652d04d9512779db0acdce08"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
		chckBoxComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		chckBoxComplimentarySubscribee.click();
	}

	public void clickBtnSubscribemoaahstarterplan() throws Exception {
		Thread.sleep(waitResponse);
		WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("button#cube-subscribe-btn-652d04d9512779db0acdce08"));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
		btnComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnComplimentarySubscribee.click();
	}
	
	
	//offline payment
	public void clickBtnConfirmmoaahstarterplan() throws Exception {
		Thread.sleep(waitResponse);
		WebElement element = shadowDomcpsubscribe()
				.findElement(By.cssSelector("div#cube-subscribe-modal-btn-657c08880cc0f27d570a3ac8"));
		System.out.println("element is display: " + element.isDisplayed());
		element.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		element.click();
	}
	// moaah premium plan
//		moaahspremiumplan
		private void subscribemoaahspremiumplan() throws Exception {
			clickchckBoxmoaahspremiumplan();
			clickBtnSubscribemoaahspremiumplan();
			inputCompleteFillSubscriberPayment();

		}

		public void clickchckBoxmoaahspremiumplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
					.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-652d04d9512779db0acdce0c"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
			chckBoxComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			chckBoxComplimentarySubscribee.click();
		}

		public void clickBtnSubscribemoaahspremiumplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
					.findElement(By.cssSelector("button#cube-subscribe-btn-652d04d9512779db0acdce0c"));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
			btnComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			btnComplimentarySubscribee.click();
		}
		
		
		//offline payment
		public void clickBtnConfirmmoaahspremiumplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement element = shadowDomcpsubscribe()
					.findElement(By.cssSelector("div#cube-subscribe-modal-btn-657c08880cc0f27d570a3ac8"));
			System.out.println("element is display: " + element.isDisplayed());
			element.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			element.click();
		}
		
//		quotationproposalplan
		private void subscribequotationproposalplanplan() throws Exception {
			clickchckBoxquotationproposalplan();
			clickBtnSubscribequotationproposalplan();
			clickBtnConfirmquotationproposalplan();// offline payment

		}

		public void clickchckBoxquotationproposalplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
					.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6389b9e2089c75ff462d9843"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
			chckBoxComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			chckBoxComplimentarySubscribee.click();
		}

		public void clickBtnSubscribequotationproposalplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
					.findElement(By.cssSelector("button#cube-subscribe-btn-6389b9e2089c75ff462d9843"));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
			btnComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			btnComplimentarySubscribee.click();
		}
		
		
		//offline payment
		public void clickBtnConfirmquotationproposalplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement element = shadowDomcpsubscribe()
					.findElement(By.cssSelector("div#cube-subscribe-modal-btn-6389b9e2089c75ff462d9843"));
			System.out.println("element is display: " + element.isDisplayed());
			element.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			element.click();
		}
		
//		bookingqueueplan();
		
		private void subscribebookingqueueplan() throws Exception {
			clickchckBoxquotationproposalplan();
			clickBtnSubscribequotationproposalplan();
			clickBtnConfirmquotationproposalplan();// offline payment

		}

		public void clickchckBoxbookingqueueplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
					.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6389b4af089c75ff462d9825"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
			chckBoxComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			chckBoxComplimentarySubscribee.click();
		}

		public void clickBtnSubscribebookingqueueplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
					.findElement(By.cssSelector("button#cube-subscribe-btn-6389b4af089c75ff462d9825"));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
			btnComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			btnComplimentarySubscribee.click();
		}
		
		
		//offline payment
		public void clickBtnConfirmbookingqueueplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement element = shadowDomcpsubscribe()
					.findElement(By.cssSelector("div#cube-subscribe-modal-btn-6389b4af089c75ff462d9825"));
			System.out.println("element is display: " + element.isDisplayed());
			element.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			element.click();
		}
		
//		subscribe quotation requestplan();
		
		private void subscribequotationrequestplan() throws Exception {
			clickchckBoxquotationrequestplan();
			clickBtnSubscribequotationrequestplan();
			clickBtnConfirmquotationrequestplan();// offline payment

		}

		public void clickchckBoxquotationrequestplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
					.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-65601eced5561491b24a8182"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
			chckBoxComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			chckBoxComplimentarySubscribee.click();
		}

		public void clickBtnSubscribequotationrequestplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
					.findElement(By.cssSelector("button#cube-subscribe-btn-65601eced5561491b24a8182"));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
			btnComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			btnComplimentarySubscribee.click();
		}
		
		
		//offline payment
		public void clickBtnConfirmquotationrequestplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement element = shadowDomcpsubscribe()
					.findElement(By.cssSelector("div#cube-subscribe-modal-btn-65601eced5561491b24a8182"));
			System.out.println("element is display: " + element.isDisplayed());
			element.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			element.click();
		}
		
//		Freight Management System - LFS Trial
		
		private void subscribelfstrialplan() throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			js.executeScript("window.scrollBy(0,500)", "");
			clickchckBoxlfstrialplan();
			inputlfstrialplan();
			clickBtnSubscribelfstrialplan();
			clickBtnConfirmlfstrialplan();// offline payment

		}

		public void clickchckBoxlfstrialplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
					.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-648965bf80066b3396b8c06f"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
			chckBoxComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			chckBoxComplimentarySubscribee.click();
		}

		public void clickBtnSubscribelfstrialplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
					.findElement(By.cssSelector("button#cube-subscribe-btn-648965bf80066b3396b8c06f"));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
			btnComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			btnComplimentarySubscribee.click();
		}
		public void inputlfstrialplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
					.findElement(By.cssSelector("input#cube-subscribe-btn-input-648965bf80066b3396b8c06f"));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
			btnComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			btnComplimentarySubscribee.sendKeys("3");
			;
		}
		
		//offline payment
		public void clickBtnConfirmlfstrialplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement element = shadowDomcpsubscribe()
					.findElement(By.cssSelector("div#cube-subscribe-modal-btn-648965bf80066b3396b8c06f"));
			System.out.println("element is display: " + element.isDisplayed());
			element.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			element.click();
		}
		
//		Freight Management System - LFS Multi
		
		private void subscribelfsmultiplan() throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			js.executeScript("window.scrollBy(0,900)", "");
			clickchckBoxlfsmultiplan();
			inputlfsmultiplan();
			clickBtnSubscribelfsmultiplan();
			inputCompleteFillSubscriberPayment();
		}
		
		private void subscribelfsmultiplanupgrade() throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			js.executeScript("window.scrollBy(0,900)", "");
			clickchckBoxlfsmultiplan();
			inputlfsmultiplan();
			clickBtnSubscribelfsmultiplan();
			Thread.sleep(3000);
//			clickBtnBackSubscribelfsmultiplan();
		}
		
		private void subscribelfsmultiplandowngrade() throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			js.executeScript("window.scrollBy(0,900)", "");
			clickchckBoxlfsmultiplan();
			inputlfsmultiplandowngrade();
			clickBtnSubscribelfsmultiplan();
			Thread.sleep(3000);
//			clickBtnBackSubscribelfsmultiplan();
		}
		
		

		public void clickchckBoxlfsmultiplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
					.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6389c85e089c75ff462d9911"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
			chckBoxComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			chckBoxComplimentarySubscribee.click();
		}

		public void clickBtnSubscribelfsmultiplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
					.findElement(By.cssSelector("button#cube-subscribe-btn-6389c85e089c75ff462d9911"));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
			btnComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			btnComplimentarySubscribee.click();
		}
		
//		public void clickBtnBackSubscribelfsmultiplan() throws Exception {
//			Thread.sleep(waitResponse);
//			WebElement btnComplimentarySubscribee = backfromsubscribelfsmulti()
//					.findElement(By.cssSelector("h1.Header-businessLink-name.Text.Text-color--gray800.Text-fontSize--14.Text-fontWeight--500.Text--truncate"));
//			System.out.println("clickBtnBackSubscribelfsmultiplan is display: " + btnComplimentarySubscribee.isDisplayed());
//			btnComplimentarySubscribee.isDisplayed();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//			btnComplimentarySubscribee.click();
//		}
		
		public void inputlfsmultiplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
					.findElement(By.cssSelector("input#cube-subscribe-btn-input-6389c85e089c75ff462d9911"));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
			btnComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			btnComplimentarySubscribee.sendKeys("25");
			;
		}
		
		public void inputlfsmultiplandowngrade() throws Exception {
			Thread.sleep(waitResponse);
			WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
					.findElement(By.cssSelector("input#cube-subscribe-btn-input-6389c85e089c75ff462d9911"));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
			btnComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			btnComplimentarySubscribee.sendKeys("13");
			;
		}
		
		//subscribe booking concierge
		private void subscribebookingconcierge() throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			js.executeScript("window.scrollBy(0,900)", "");
			clickchckBoxbookingconciergeplan();
			clickBtnSubscribebookingconciergeplan();
//			inputCompleteFillSubscriberPayment();
			

		}

		public void clickchckBoxbookingconciergeplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
					.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6389af2c089c75ff462d97c7"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
			chckBoxComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			chckBoxComplimentarySubscribee.click();
		}

		public void clickBtnSubscribebookingconciergeplan() throws Exception {
			Thread.sleep(waitResponse);
			WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
					.findElement(By.cssSelector("button#cube-subscribe-btn-6389af2c089c75ff462d97c7"));
			System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
			btnComplimentarySubscribee.isDisplayed();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			btnComplimentarySubscribee.click();
		}
		
		//subscribe awb concierge
				private void subscribeawbconcierge() throws Exception {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					js.executeScript("window.scrollBy(0,900)", "");
					clickchckBoxawbconciergeplan();
					clickBtnSubscribeawbconciergeplan();
//					inputCompleteFillSubscriberPayment();
					

				}

				public void clickchckBoxawbconciergeplan() throws Exception {
					Thread.sleep(waitResponse);
					WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
							.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6389ae2e089c75ff462d97b7"));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
					chckBoxComplimentarySubscribee.isDisplayed();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					chckBoxComplimentarySubscribee.click();
				}

				public void clickBtnSubscribeawbconciergeplan() throws Exception {
					Thread.sleep(waitResponse);
					WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
							.findElement(By.cssSelector("button#cube-subscribe-btn-6389ae2e089c75ff462d97b7"));
					System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
					btnComplimentarySubscribee.isDisplayed();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					btnComplimentarySubscribee.click();
				}
				//subscribe awb editor
				private void subscribeawbeditor() throws Exception {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					js.executeScript("window.scrollBy(0,900)", "");
					clickchckBoxawbeditorplan();
					clickBtnSubscribeawbeditorplan();
					inputCompleteFillSubscriberPayment();
					

				}

				public void clickchckBoxawbeditorplan() throws Exception {
					Thread.sleep(waitResponse);
					WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
							.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-656d4735a1c0c617986d3386"));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
					chckBoxComplimentarySubscribee.isDisplayed();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					chckBoxComplimentarySubscribee.click();
				}

				public void clickBtnSubscribeawbeditorplan() throws Exception {
					Thread.sleep(waitResponse);
					WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
							.findElement(By.cssSelector("button#cube-subscribe-btn-656d4735a1c0c617986d3386"));
					System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
					btnComplimentarySubscribee.isDisplayed();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					btnComplimentarySubscribee.click();
				}
				//subscribe dgoffice
				private void subscribedgoffice() throws Exception {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					js.executeScript("window.scrollBy(0,900)", "");
					clickchckBoxdgofficeplan();
					clickBtnSubscribedgofficeplan();
					inputCompleteFillSubscriberPayment();
					

				}

				public void clickchckBoxdgofficeplan() throws Exception {
					Thread.sleep(waitResponse);
					WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
							.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6509c7e3af6683e10dbbb6ca"));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
					chckBoxComplimentarySubscribee.isDisplayed();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					chckBoxComplimentarySubscribee.click();
				}

				public void clickBtnSubscribedgofficeplan() throws Exception {
					Thread.sleep(waitResponse);
					WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
							.findElement(By.cssSelector("button#cube-subscribe-btn-6509c7e3af6683e10dbbb6ca"));
					System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
					btnComplimentarySubscribee.isDisplayed();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					btnComplimentarySubscribee.click();
				}
				
				//subscribe air line tariff query
				private void subscribeairlinetariffquery() throws Exception {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					js.executeScript("window.scrollBy(0,900)", "");
					clickchckBoxairlinetariffqueryplan();
					clickBtnSubscribeairlinetariffqueryplan();
//					inputCompleteFillSubscriberPayment();
					

				}

				public void clickchckBoxairlinetariffqueryplan() throws Exception {
					Thread.sleep(waitResponse);
					WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
							.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-64dc7ecd0b3820a326527906"));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
					chckBoxComplimentarySubscribee.isDisplayed();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					chckBoxComplimentarySubscribee.click();
				}

				public void clickBtnSubscribeairlinetariffqueryplan() throws Exception {
					Thread.sleep(waitResponse);
					WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
							.findElement(By.cssSelector("button#cube-subscribe-btn-64dc7ecd0b3820a326527906"));
					System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
					btnComplimentarySubscribee.isDisplayed();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
					btnComplimentarySubscribee.click();
				}
				
		
	// cargoai

	public void subscribecargomartai() throws Exception {
		clickchckBoxComplimentarySubscribecargoai();
		clickBtnComplimentarySubsribecargoai();
		clickBtnConfirmComplimentarySubsribecargoai();
	}

	public void clickchckBoxComplimentarySubscribecargoai() throws Exception {
		Thread.sleep(waitResponse);
		WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-649172dede5affa0b247a4bb"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
		chckBoxComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		chckBoxComplimentarySubscribee.click();
	}

	public void clickBtnComplimentarySubsribecargoai() throws Exception {
		Thread.sleep(waitResponse);
		WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
				.findElement(By.cssSelector("button#cube-subscribe-btn-649172dede5affa0b247a4bb"));
		System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
		btnComplimentarySubscribee.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnComplimentarySubscribee.click();
	}

	public void clickBtnConfirmComplimentarySubsribecargoai() throws Exception {
		Thread.sleep(waitResponse);
		WebElement element = shadowDomcpsubscribe()
				.findElement(By.cssSelector("div#cube-subscribe-modal-btn-649172dede5affa0b247a4bb"));
		System.out.println("element is display: " + element.isDisplayed());
		element.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		element.click();
	}

	// ==============

	public void subscribeComplimentarySubsriptionPlanProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,300)", "");
	}

	public void selectPlanPoduct(String product) throws Exception {
		Thread.sleep(waitResponse);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,215)", "");
		// js.executeScript("arguments[0].scrollIntoView();",
		// bundlecompanylevelaWBConciergeLFS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		switch (product) {
		case "Booking Concierge":
			lsPlanProduct.get(0).click();
			break;
		case "Test PnCLL ( paid non company level licensed )":
//			lsPlanProduct.get(1).click();
			break;
		case "Booking Queue":
			lsPlanProduct.get(1).click();
			break;
		case "Cargo Insurance":
			lsPlanProduct.get(2).click();
			break;
		case "CargoMart by CargoAi":
			lsPlanProduct.get(3).click();
			break;
		case "Freight Management System - LFS Trial":
			lsPlanProduct.get(4).click();
			break;
		case "Freight Management System - LFS Multi":
			lsPlanProduct.get(4).click();
			break;
		case "Freight Management System - LFS Multi Upgrade":
			lsPlanProduct.get(4).click();
			break;
		case "Quotation Request":
			lsPlanProduct.get(5).click();
			break;
		case "Quotation Proposal":
			lsPlanProduct.get(6).click();
			break;
		case "Moaah Starter":
//			lsPlanProduct.get(8).click();
			break;
		case "Moaah Premium":
//			lsPlanProduct.get(8).click();
			break;
		case "Welcome Product (Sample App)":
//			lsPlanProduct.get(9).click();
			break;
		case "Bundle (LFS BC) Company Level":
//			lsPlanProduct.get(10).click();
			break;
		case "Bundle (AWB, BC) Non Company":
//			lsPlanProduct.get(11).click();
			break;
		case "LFS Trial 1 day":
//			lsPlanProduct.get(12).click();
			break;
		case "AWB Concierge":
			driver.get("https://sandbox.cubeforall.com/products/compliance-and-documentation/awb-concierge/");
//			driver.get("https://cubeforall.com/products/compliance-and-documentation/awb-concierge/");
			break;
		case "AWB Editor":
			driver.get("https://sandbox.cubeforall.com/products/compliance-and-documentation/awb-editor/");
//			driver.get("https://cubeforall.com/products/compliance-and-documentation/awb-editor/");
			break;
		case "DGOffice":
			driver.get("https://sandbox.cubeforall.com/products/compliance-and-documentation/dgoffice/");
//			driver.get("https://cubeforall.com/products/compliance-and-documentation/dgoffice/");
			break;
		case "Air Line Tariff Query":
			driver.get("https://sandbox.cubeforall.com/products/compliance-and-documentation/airline-tariff-query/");
//			driver.get("https://cubeforall.com/products/compliance-and-documentation/airline-tariff-query/");
			break;
		default:
			break;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		js.executeScript("window.scrollBy(0,300)", "");
	}
	
	public void selectPlanProduct(String productB) throws Exception {
		Thread.sleep(waitResponse);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,215)", "");
		// js.executeScript("arguments[0].scrollIntoView();",
		// bundlecompanylevelaWBConciergeLFS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		switch (productB) {
		case "Freight Management System - LFS Multi Downgrade":
			lfsProduct.click();
			break;
		default:
			break;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		js.executeScript("window.scrollBy(0,300)", "");
	}

	public void subscribeplan(String product) throws Exception {
		switch (product) {
		case "Booking Concierge":
			subscribebookingconcierge();
			break;
		case "Test PnCLL ( paid non company level licensed )":

			break;
		case "Cargo Insurance":

			break;
		case "CargoMart by CargoAi":
			subscribecargomartai();
			break;
		case "Freight Management System - LFS Trial":
			subscribelfstrialplan();
			break;
		case "Freight Management System - LFS Multi":
			subscribelfsmultiplan();
			break;
		case "Quotation Request":
			subscribequotationrequestplan();
			break;
		case "Booking Queue":
			subscribebookingqueueplan();
			break;
		case "Quotation Proposal":
			subscribequotationproposalplanplan();
			break;
		case "Moaah Starter":
			subscribemoaahstarterplan();
//			inputCompleteFillSubscriberPayment();
			break;
		case "Moaah Premium":
			subscribemoaahspremiumplan();
//			inputCompleteFillSubscriberPayment();
			break;
		case "Welcome Product (Sample App)":

			break;
		case "Bundle (LFS BC) Company Level":
			subscribebundlelfsbc();
			break;
		case "Bundle (AWB, BC) Non Company":
			subscribebundleawbbcplan();
			break;
		case "LFS Trial 1 day":
			subscribelfstrianonedayplan();
			break;
		case "AWB Concierge":
			subscribeawbconcierge();
			break;
		case "AWB Editor":
			subscribeawbeditor();
			break;
		case "DGOffice":
			subscribedgoffice();
			break;
		case "Air Line Tariff Query":
			subscribeairlinetariffquery();
			break;
		case "Freight Management System - LFS Multi Upgrade":
			subscribelfsmultiplanupgrade();
			break;
		default:
			break;
		}
	}
	
	public void subscribesecondplan(String productB) throws Exception {
		switch (productB) {
		case "Freight Management System - LFS Multi Downgrade":
			subscribelfsmultiplandowngrade();
			break;
		default:
			break;
		}
	}

	@FindBy(xpath = "//*[@id=\"cube-plan-list\"]/tbody/tr/td[2]/p")
	@CacheLookup
	private List<WebElement> lsproductnamesubscription;

	@FindBy(xpath = "//*[@id=\"cube-plan-list\"]/tbody/tr/td[3]")
	@CacheLookup
	private List<WebElement> lsplannamesubscription;

	@FindBy(xpath = "//*[@id=\"cube-plan-list\"]/tbody/tr/td[4]/div/div")
	@CacheLookup
	private List<WebElement> lsdescnamesubscription;

	@FindBy(xpath = "//*[@id=\"cube-plan-list\"]/tbody/tr/td[5]/p")
	@CacheLookup
	private List<WebElement> lsusercountsubscription;

	@FindBy(xpath = "//*[@id=\"cube-plan-list\"]/tbody/tr/td[7]")
	@CacheLookup
	private List<WebElement> lstatussubscription;

	@FindBy(xpath = "//*[@id=\"cube-plan-list\"]/tbody/tr[2]/td[6]/div/div/div/text()[1]")
	@CacheLookup
	private WebElement startsubscriptiondate;

	@FindBy(xpath = "//*[@id=\"cube-plan-list\"]/tbody/tr[2]/td[6]/div/div/div/text()[3]")
	@CacheLookup
	private WebElement endsubscriptiondate;

	// remove button subscription

	@FindBy(xpath = "//*[local-name()='svg' and @fill='#70757A']")
	@CacheLookup
	private List<WebElement> btnsvglsremoveproductsubscription;

	public Boolean verifytableProductSubscription(String condition) throws Exception {
		Thread.sleep(waitResponse);
		Boolean result = false;
		for (int i = 0; i < lsproductnamesubscription.size(); i++) {
			System.out.println(lsproductnamesubscription.get(i).getText());
			System.out.println(condition);
			if (lsproductnamesubscription.get(i).getText().contains(condition)) {
				result = true;
			}

			if (result == true) {
				break;
			}

		}
		return result;
	}

	public Boolean verifytablePlanSubscription(String conditionone, String conditiontwo) throws Exception {
		Thread.sleep(waitResponse);
		Boolean result = false;
		for (int i = 0; i < lsproductnamesubscription.size(); i++) {
			System.out.println(lsproductnamesubscription.get(i).getText());
			System.out.println(conditionone);
			System.out.println(conditiontwo);
			if (lsproductnamesubscription.get(i).getText().contains(conditionone)
					&& lsplannamesubscription.get(i).getText().contains(conditiontwo)) {
				result = true;
			}

			if (result == true) {
				break;
			}
		}
		return result;
	}

	public Boolean verifytableDescSubscription(String conditionone, String conditiontwo) throws Exception {
		Thread.sleep(waitResponse);
		Boolean result = false;
		for (int i = 0; i < lsproductnamesubscription.size(); i++) {
			System.out.println(lsproductnamesubscription.get(i).getText());
			System.out.println(conditionone);
			System.out.println(conditiontwo);
			if (lsproductnamesubscription.get(i).getText().contains(conditionone)
					&& lsdescnamesubscription.get(i).getText().contains(conditiontwo)) {
				result = true;
			}

			if (result == true) {
				break;
			}
		}
		return result;
	}

	public Boolean verifytableUserCountSubscription(String conditionone, String conditiontwo) throws Exception {
		Thread.sleep(waitResponse);
		Boolean result = false;
		for (int i = 0; i < lsproductnamesubscription.size(); i++) {
			System.out.println(lsproductnamesubscription.get(i).getText());
			System.out.println(lsusercountsubscription.get(i).getText());
			System.out.println(conditionone);
			System.out.println(conditiontwo);
			if (lsproductnamesubscription.get(i).getText().toLowerCase().contains(conditionone.toLowerCase())
					&& lsusercountsubscription.get(i).getText().contains(conditiontwo)) {

				result = true;
			}

			if (result == true) {
				break;
			}
		}
		return result;
	}

	public Boolean verifytableStatusSubscription(String conditionone, String conditiontwo) throws Exception {
		Thread.sleep(waitResponse);
		Boolean result = false;
		for (int i = 0; i < lsproductnamesubscription.size(); i++) {
			System.out.println(lsproductnamesubscription.get(i).getText());
			System.out.println(conditionone);
			System.out.println(conditiontwo);
			if (lsproductnamesubscription.get(i).getText().contains(conditionone)
					&& lstatussubscription.get(i).getText().contains(conditiontwo)) {
				result = true;
			}

			if (result == true) {
				break;
			}

		}
		return result;
	}

	public Boolean verifytableBcycleSubscription(String conditionone, String startdate, String enddate)
			throws Exception {
		Thread.sleep(waitResponse);
		Boolean result = false;
		for (int i = 0; i < lsproductnamesubscription.size(); i++) {
			System.out.println(lsproductnamesubscription.get(i).getText());
			System.out.println(conditionone);
			System.out.println(startsubscriptiondate.getText());
			System.out.println(endsubscriptiondate.getText());
			if (lsproductnamesubscription.get(i).getText().contains(conditionone)
					&& startsubscriptiondate.getText().contains(startdate)
					&& endsubscriptiondate.getText().contains(enddate)) {
				result = true;
			}
			if (result == true) {
				break;
			}
		}
		return result;
	}

	public void clickRemoveSubscription(String conditionone) throws Exception {
		Thread.sleep(waitResponse);
		Boolean result = false;
		for (int i = 0; i < lsproductnamesubscription.size(); i++) {
			System.out.println(lsproductnamesubscription.get(i).getText());
			System.out.println(conditionone);
			if (lsproductnamesubscription.get(i).getText().contains(conditionone)) {
				btnsvglsremoveproductsubscription.get(i).click();
				result = true;
			}

			if (result == true) {
				break;
			}
		}
	}

	// s3 1874
	public void clickTabMenuMySubscription() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		iconMenuMysubscription.click();
	}

	public void clickAcccountIcon() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		accounticon.click();
	}

	public void clickProductTab() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.switchTo().defaultContent();
		Thread.sleep(longwaitResponse);
		productTab.click();
	}
	
	public void clickProductTabFromManageSubscribtion() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.switchTo().defaultContent();
		Thread.sleep(waitResponse);
		productTabFromManageSubscribtion.click();
	}

	public void inputCompleteFillSubscriberPayment() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		enterInputCardNumber();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		enterinputcardExpiryformpayment();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		enterinputVcaCardNumberformpayment();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		enterinputFullNameCardNumberformpayment();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		clickbtncompleteformpaymentStripe();
	}

	public void inputserachphonenumberformpayment() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		inputserachphonenumberformpayment.sendKeys("081234567891");
		Thread.sleep(1000);
	}

	public void clickenableStripePass() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		clickchckEnableStripePass.click();
	}

	public void enterInputCardNumber() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		inputCardNumberformpayment.sendKeys("4242424242424242");
	}

	public void enterinputcardExpiryformpayment() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		inputcardExpiryformpayment.sendKeys("424");
	}

	public void enterinputVcaCardNumberformpayment() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		inputVcaCardNumberformpayment.sendKeys("424");
	}

	public void enterinputFullNameCardNumberformpayment() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		inputFullNameCardNumberformpayment.sendKeys("Testerccn");
	}

	public void clickbtncompleteformpaymentStripe() throws Exception {
		Thread.sleep(waitResponse);
		SubmitButtoncompleteformpaymentStripe.click();
	}

	public void clickProductbundlecompanylevelaWBConciergeLFS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,215)", "");
		// js.executeScript("arguments[0].scrollIntoView();",
		// bundlecompanylevelaWBConciergeLFS);
		bundlecompanylevelaWBConciergeLFS.isDisplayed();
		bundlecompanylevelaWBConciergeLFS.click();
	}

	public void validateprodcutprice() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,300)", "");

	}

	public void clickInputCheckboxSubscribe() {
		System.out.println("clickInputCheckboxSubscribe is display: " + inputCheckboxSubscribe.isDisplayed());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		inputCheckboxSubscribe.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		inputCheckboxSubscribe.click();

	}

	public void enterInputNumberOfUser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("enterInputNumberOfUser is display: " + inputUser.isDisplayed());
		inputUser.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		inputUser.sendKeys("3");

	}

	// 2238 separate notification for manual & auto subscribe / unsubscribe.
	@FindBy(xpath = "//*[@id=\"freight\"]/ul/li/a")
	@CacheLookup
	private List<WebElement> lsFreightForwarderMenu;

	@FindBy(xpath = "//*[@id=\"nav\"]/ul/li/a")
	@CacheLookup
	private List<WebElement> lsCompliencenDoc;

	public void clickCompianceAndDocumentationMenu() throws Exception {
		Thread.sleep(waitResponse);
		lsFreightForwarderMenu.get(1).click();
	}

	public void clickAWBEditor() throws Exception {
		Thread.sleep(waitResponse);
		lsCompliencenDoc.get(1).click();
	}

	public void clickchckboxSubscribeAwbeditor() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		js.executeScript("window.scrollBy(0,300)", "");
	}
	
    public void backtoCubeforallfrompayment() throws Exception{
    	Thread.sleep(waitResponse);
    	backfrompayment.click();
    }

}
