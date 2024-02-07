package com.versiontwo.ccn.scenariopage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;
import com.versiontwo.ccn.driver.DriverSingleton;

public class CompanyPage {
	private WebDriver driver;
	public CompanyPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	public static String name = "";
	public static int index;
	private int waitResponse =10000;
	//Information section
	By btnInformationOnMyCompany = By.id("cube-information");
	By btnLeaveCompany = By.id("cube-leave-company"); //admin & user
	By btnSetupPayment = By.id("cube-setup-payment"); //admin from SG country & not setup payment yet, can see this

	public void pressInformationOnMyCompany(){
		driver.findElement(btnInformationOnMyCompany).isDisplayed();
		driver.findElement(btnInformationOnMyCompany).click();
	}
	public void pressLeaveCompany(){
		driver.findElement(btnLeaveCompany).isDisplayed();
		driver.findElement(btnLeaveCompany).click();
	}
	public void pressSetupPaymentCompany(){
		driver.findElement(btnSetupPayment).isDisplayed();
		driver.findElement(btnSetupPayment).click();
	}
	

	//Members section
	By btnMembersOnMyCompany = By.id("cube-members");
	By btnInviteUserToCompany = By.id("cube-invite-users"); //admin
	By btnRemoveUsersFromAdmin = By.xpath("//*[@id=\"cube-members\"]/tbody/tr[1]/td[5]/div/div/div[2]/div[3]/p"); //admin
	By btnApproveUsersFromAdmin = By.id("cube-approve"); //admin
	
//	By txtInviteEmailUsers = By.xpath("//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[1]/div[3]/div/div/div[1]/div[2]/div/input"); //admin
	By txtInviteEmailUsers = By.xpath("//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[2]/div[3]/div/div/div[1]/div[2]/div/input"); //admin
	
	By btn3dot = By.id("cube-open-action-["+index+"]"); //Conditionally
	By btnAcceptPendingApprovalPerUsers = By.id("cube-accept-request-["+index+"]"); //Conditionally
	By btnRemovePerUsers = By.id("cube-remove-user-["+index+"]"); //Conditionally
	By checkboxUsersOnMembers = By.id("checkbox-["+index+"]"); //Conditionally
	By txtSearchUser = By.xpath("//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[1]/div[4]/div[2]/div/div/div/input");
	//	By dropdownFilterUsersOnMembers = By.id("cube-filter-users");

	//	By tblMemberLists = By.xpath("//*[@id=\"cube-members\"]/tbody/tr/td[4]");
	@FindBy(xpath="//*[@id=\"cube-members\"]/tbody/tr/td[4]")
	@CacheLookup
	private List<WebElement> tblMemberLists;
	@FindBy(xpath="//*[@id=\"cube-members\"]/tbody/tr/td[1]/label/span")
	@CacheLookup
	private List<WebElement> lschckboxMember;

	@FindBy(xpath="//*[@id=\"cube-sort-checkbox\"]/div/div[2]/div")
	@CacheLookup
	private WebElement dropdownFilterUsersOnMembers;
	@FindBy(xpath="//*[@id=\"cube-sort-checkbox\"]/div/div[2]/div/div[2]/div")
	@CacheLookup
	private List<WebElement> lsFilterUsersOnMembers;

	@FindBy(xpath="//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[2]/div/div/div[1]/div[2]/p")
	@CacheLookup
	private WebElement txtValidateAlreadyinCompany;
	@FindBy(xpath="//*[@id=\"cube-confirm-error\"]")
	@CacheLookup
	private WebElement btnValidateAlreadyinCompany;
	
	
	
	@FindBy(xpath="//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[3]/div/div/div[1]/div[2]/p")
	@CacheLookup
	private WebElement txtemailValidateAlreadyinCompany;
//	@FindBy(xpath="//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[2]/div/div/div[1]/div[2]/ul/li")
//	@CacheLookup
//	private WebElement txtemailValidateAlreadyinCompany;
	
	@FindBy(xpath="//button[@id=\"cube-confirm-add-users\"]")
	@CacheLookup
	private WebElement btnValidateNotYetInCompany;
	@FindBy(xpath="//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[1]/div[2]/div/div/div[1]/p")
	@CacheLookup
	private WebElement txtValidateNotYetInCompanyAndSuccesAddMember;

	@FindBy(xpath="//*[@id=\"cube-members\"]/tbody/tr/td[5]")
	@CacheLookup
	private List<WebElement> lsthreedoteoptionmembermostleftside;

//	@FindBy(xpath="//*[@id=\"cube-confirm-remove\"]")
//	@CacheLookup
//	private WebElement btnRemoveUserConfirmMember;

	public void btnValidateNotYetInCompany() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnValidateNotYetInCompany.click();
	}
	public WebElement txtValidateNotYetInCompanyAndSuccesAddMember() {
		return txtValidateNotYetInCompanyAndSuccesAddMember;
	}

	public WebElement btnValidateAlreadyinCompany() {
		return btnValidateAlreadyinCompany;
	}
	public WebElement txtValidateAlreadyinCompany() {
		return txtValidateAlreadyinCompany;
	}
	public WebElement txtemailValidateAlreadyinCompany() {
		return txtemailValidateAlreadyinCompany;
	}
	public void pressMembersOnMyCompany() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitResponse));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnMembersOnMyCompany).isDisplayed();
		Thread.sleep(waitResponse);
		wait.until(ExpectedConditions.elementToBeClickable(btnMembersOnMyCompany));
		driver.findElement(btnMembersOnMyCompany).click();
	}
	public void pressInviteUserToCompany() throws Exception{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-150)", "");
		Thread.sleep(waitResponse);
		driver.findElement(btnInviteUserToCompany).isDisplayed();
		driver.findElement(btnInviteUserToCompany).click();
	}
	//	}lsThreeDotsOptionAdminOnMember
	public void pressRemoveUserFromCompanyByAdmin() throws Exception{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		lsthreedoteoptionmembermostleftside.get(0).isDisplayed();
		lsthreedoteoptionmembermostleftside.get(0).isEnabled();
		lsthreedoteoptionmembermostleftside.get(0).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnRemoveUsersFromAdmin).isDisplayed();
		driver.findElement(btnRemoveUsersFromAdmin).click();
		confirmpressRemoveUserFromCompanyByAdmin();
//		
//		pressRemovePerUserOnMemberByAdmin();
	}
	public void pressbtnRemoveUsersFromAdmin() throws Exception{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnRemoveUsersFromAdmin).isDisplayed();
		driver.findElement(btnRemoveUsersFromAdmin).click();
		confirmpressRemoveUserFromCompanyByAdmin();
	}
	public void pressthreedotsRemoveUserFromCompanyByAdminPendingAccept() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));

		lsthreedoteoptionmembermostleftside.get(0).isDisplayed();
		lsthreedoteoptionmembermostleftside.get(0).isEnabled();
		lsthreedoteoptionmembermostleftside.get(0).click();
	}
	public void confirmpressRemoveUserFromCompanyByAdmin() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnConfirmRemoveMember.isDisplayed();
		btnConfirmRemoveMember.isEnabled();
		btnConfirmRemoveMember.click();
	}
	public void pressApproveUserByAdmin(){
		driver.findElement(btnApproveUsersFromAdmin).isDisplayed();
		driver.findElement(btnApproveUsersFromAdmin).click();
	}
	public void inputSearchUsersOnMembers(String search){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(txtSearchUser).clear();
		driver.findElement(txtSearchUser).sendKeys(search);
	}
	public void inputInviteUsersOnMembersByAdmin(String email){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(txtInviteEmailUsers).clear();
		driver.findElement(txtInviteEmailUsers).sendKeys(email);
	}
	public void press3DotOnMembers(int indexing){
		index = indexing;
		driver.findElement(btn3dot).isDisplayed();
		driver.findElement(btn3dot).click();
	}
	//	public void pressAcceptRequestPerUserOnMemberByAdmin(int indexing){
	//		index = indexing;
	//		driver.findElement(btnAcceptPendingApprovalPerUsers).isDisplayed();
	//		driver.findElement(btnAcceptPendingApprovalPerUsers).click();
	//	}
	public WebElement acceptRequestPerUserOnMemberByAdmin(int indexing){
		index = indexing;
		return driver.findElement(btnAcceptPendingApprovalPerUsers);
	}
	//	public void pressRemovePerUserOnMemberByAdmin(int indexing){
	//		index = indexing;
	//		driver.findElement(btnRemovePerUsers).isDisplayed();
	//		driver.findElement(btnRemovePerUsers).click();
	//	}
	                //*[@id="cube-members"]/tbody/tr[3]/td[5]/div/div/div[2]/div[3]
	@FindBy(xpath="//*[@id=\"cube-members\"]/tbody/tr[1]/td[5]/div/div/div[2]/div")//*[@id="cube-members"]/tbody/tr[1]/td[5]/div/div/div[2]/div
	@CacheLookup
	private List<WebElement> lsThreeDotsOptionAdminOnMember;
	@FindBy(xpath="//*[@id=\"cube-confirm-remove-confirmation\"]")
	@CacheLookup
	private WebElement btnConfirmRemoveMember;
	@FindBy(xpath="//*[@id=\"cube-later\"]")
	@CacheLookup
	private WebElement btnConfirmCancelRemoveMember;
	@FindBy(xpath="")
	@CacheLookup
	private WebElement btnConfirmAcceptMember;
	@FindBy(xpath="")
	@CacheLookup
	private WebElement btnConfirmCancelAcceptMember;//*[@id="cube-members"]/tbody/tr[5]/td[5]/div/div/div[2]/div[1]/div[2]/div
	@FindBy(xpath="//*[@id=\"cube-members\"]/tbody/tr[1]/td[5]/div/div/div[2]/div[1]/div[2]/div")
	@CacheLookup
	private List<WebElement> lsOptionChangeRole;
	@FindBy(xpath="//*[@id=\"cube-confirm-error\"]")
	@CacheLookup
	private WebElement btnErrorChangeRole;
	@FindBy(xpath="//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[2]/div/div/div[1]/p")
	@CacheLookup
	private WebElement txtErrorChangeRole;
//	"User still not accepted or still not approved by admin"
	@FindBy(xpath="//*[@id=\"cube-confirm-change-status\"]")
	@CacheLookup
	private WebElement btnConfirmChangeRoleSucces;
	@FindBy(xpath="//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[1]/div[2]/div/div/div[1]/p")
	@CacheLookup
	private WebElement txtConfirmChangeRoleSucces;
	
	//*[@id="cube-confirm-remove"]
	
//	The user�s role has been changed successfully. User will be notified via email of this change.
	
	//	By btnChangeRolePerUsers = By.id("cube-change-role-["+index+"]"); //Conditionally


	public void pressthreedotsFromCompanyByAdmin() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("lsthreedoteoptionmembermostleftside display: "+lsthreedoteoptionmembermostleftside.get(0).isDisplayed());
		System.out.println("lsthreedoteoptionmembermostleftside enabled: "+lsthreedoteoptionmembermostleftside.get(0).isEnabled());
		lsthreedoteoptionmembermostleftside.get(0).click();
	}

	public void changeRolePerUserOnMemberByAdmin(String role) throws Exception{
		//		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//		act.moveToElement(lsthreedoteoptionmembermostleftside.get(0)).click().perform();
		
		System.out.println("lsThreeDotsOptionAdminOnMember display: "+lsThreeDotsOptionAdminOnMember.get(1).isDisplayed());
		System.out.println("lsThreeDotsOptionAdminOnMember enabled: "+lsThreeDotsOptionAdminOnMember.get(1).isEnabled());
		//		js.executeScript("arguments[0].scrollIntoView();", lsThreeDotsOptionAdminOnMember.get(0).click());
		//		lsThreeDotsOptionAdminOnMember.get(0).click();
//		act.moveToElement(lsthreedoteoptionmembermostleftside.get(0)).moveToElement(lsThreeDotsOptionAdminOnMember.get(0)).perform();
		
//		act.moveToElement(lsThreeDotsOptionAdminOnMember.get(0)).moveToElement(lsOptionChangeRole.get(0)).perform();
		act.moveToElement(lsThreeDotsOptionAdminOnMember.get(1)).perform();
		Thread.sleep(waitResponse);
		//		act.moveToElement(lsThreeDotsOptionAdminOnMember.get(0));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		//list option change role
		switch (role) {
		case "admin":
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			act.moveToElement(lsOptionChangeRole.get(0)).click().perform();
			//			lsOptionChangeRole.get(0).click();
			break;
		case "user":
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			act.moveToElement(lsOptionChangeRole.get(1)).click().perform();
			//			lsOptionChangeRole.get(1).click();
			break;
		default:
			break;
		}

		//change role success gettext
		//*[@id="toppage"]/main/div[3]/wc-company/div/div[1]/div[2]/div/div/div[1]/p
		//				The user�s role has been changed successfully. User will be notified via email of this change.
		//				The user�s role has been changed successfully. User will be notified via email of this change.
		// button confirm change status
		//*[@id="cube-confirm-change-status"]


		//		index = indexing;
		//		return driver.findElement(btnChangeRolePerUsers);

	}

	public void pressAcceptRequestPerUserOnMemberByAdmin() throws Exception{
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		lsThreeDotsOptionAdminOnMember.get(1).isEnabled();
		lsThreeDotsOptionAdminOnMember.get(1).isDisplayed();
		lsThreeDotsOptionAdminOnMember.get(1).click();
		//		Thread.sleep(waitResponse);
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		//		btnConfirmAcceptMember.isEnabled();
		//		btnConfirmAcceptMember.isDisplayed();
		//		btnConfirmAcceptMember.click();
	}

	public void pressRemovePerUserOnMemberByAdmin() throws Exception{
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		lsThreeDotsOptionAdminOnMember.get(2).isEnabled();
		lsThreeDotsOptionAdminOnMember.get(2).isDisplayed();
		lsThreeDotsOptionAdminOnMember.get(2).click();
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnConfirmRemoveMember.isEnabled();
		btnConfirmRemoveMember.isDisplayed();
		btnConfirmRemoveMember.click();
		//list option admin to request member join company

	}
	public void pressCancelRemovePerUserOnMemberByAdmin() throws Exception{
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		lsThreeDotsOptionAdminOnMember.get(1).isEnabled();
		lsThreeDotsOptionAdminOnMember.get(1).isDisplayed();
		lsThreeDotsOptionAdminOnMember.get(1).click();
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnConfirmCancelRemoveMember.isEnabled();
		btnConfirmCancelRemoveMember.isDisplayed();
		btnConfirmCancelRemoveMember.click();
		//list option admin to request member join company

		//list option change role
		//*[@id="cube-members"]/tbody/tr[2]/td[5]/div/div/div[2]/div[1]/div[2]/div
		//change role success gettext
		//*[@id="toppage"]/main/div[3]/wc-company/div/div[1]/div[2]/div/div/div[1]/p
		//		The user�s role has been changed successfully. User will be notified via email of this change.
		//		The user�s role has been changed successfully. User will be notified via email of this change.
		// button confirm change status
		//*[@id="cube-confirm-change-status"]

		// pop up remove member

	}

	public WebElement removePerUserOnMemberByAdmin(int indexing){
		index = indexing;
		return driver.findElement(btnRemovePerUsers);
	}
	//	public WebElement changeRolePerUserOnMemberByAdmin(int indexing){
	//		index = indexing;
	//		return driver.findElement(btnChangeRolePerUsers);
	//	}

	public List<String> memberListTable(){
		List<String> data = new ArrayList<>();
		for(WebElement w:tblMemberLists) {
			data.add(w.getText());
		}
		return data;
	}

	public void selectStatusMember() {
		//*[@id="cube-members"]/tbody/tr/td[1]/label/span
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		//		lschckboxMember
	}

	//Application status
	By txtCompanyName = By.id("cube-company-name");
	By txtCompanyRegNo = By.id("cube-company-registration-no");
	By btnSearchCompany = By.id("cube-search-companies"); // appears when application status rejected
	By btnCreateCompany = By.id("create-company"); // new or old users without company
	By btnWithdrawApplication = By.id("cube-withdraw-application"); // user who already request join to the company can withdraw
	By btnRejectApplicationFromUser = By.id("cube-reject"); // user who already invited by admin to company can reject the application
	By btnAcceptApplicationFromUser = By.id("cube-accept"); // user who already invited by admin to company can accept the application
	By lblApplicationStatus = By.xpath("//div[@id='cube-status']"); // application status for validation data
	By btnPaginationLeftArrow = By.id("cube-prev");
	By btnPaginationRightArrow = By.id("cube-next");

	//	By tblCompanyList = By.xpath("//*[@id=\"cube-company-setup-table\"]");
	@FindBy(xpath="//*[@id=\"cube-company-setup-table\"]//tbody//tr")
	@CacheLookup
	private List<WebElement> tblCompanyList;

	//	By btnJoinCompany = By.id("cube-join"); // probably need some index to get the element
	@FindBy(xpath="//button[@id=\"cube-join-company\"]")
	@CacheLookup
	private List<WebElement> lsBtnJoinCompany;

	//	By dropdownCompanyType = By.id("company-type");
	@FindBy(xpath="//*[@id=\"company-type-item\"]")
	@CacheLookup
	private List<WebElement> dropdownCompanyType;
	@FindBy(xpath="//*[@id=\"company-type\"]/div[1]/input")
	@CacheLookup
	private WebElement dropdownMenuCompanytype;


	//	By dropdownCountry = By.id("country");
	@FindBy(xpath="//*[@id=\"country\"]/div[1]/input")
	@CacheLookup
	private WebElement dropdownMenuCountry;
	
	@FindBy(xpath="//*[@id=\"country-item\"]")
	@CacheLookup
	private List<WebElement> dropdownCountry;

	//	By dropdownCity = By.id("cube-city");
	@FindBy(xpath="//*[@id=\"city\"]/div[1]/input")
	private WebElement dropdownMenuCity;
	
	@FindBy(xpath="//*[@id=\"city-item\"]")
	@CacheLookup
	private List<WebElement> dropdownCity;

	@FindBy(xpath="//div[@class='circle-initial letter-avatar bg-orange']")
	@CacheLookup
	private WebElement accountCircleIcon;
	
	@FindBy(xpath="//*[@id=\"toppage\"]/header/div[2]/div[2]/div[2]/div[2]/wc-login/div/div/div[2]/div[2]/div")
	@CacheLookup
	private List<WebElement> lsMenuAccount;
	
	@FindBy(xpath="//div[@id=\"toppage\"]/header/div[2]/div[2]/div[2]/div[2]/wc-login/div/div/div[2]/div[2]/div")
	@CacheLookup
	private WebElement ClickMenuAccount;
	
	@FindBy(xpath="//a[@href='/portal/manage-subscription/']/span")
	@CacheLookup
	private WebElement ClickSubscribe;
	
	@FindBy(xpath="//*[@id=\"cube-plan-list\"]/tbody/tr[1]/td[8]")
	@CacheLookup
	private WebElement ClickUnSubscribe;
	
	public void inputCompanyNameOnMyCompany(String companyName) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitResponse));
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		js.executeScript("window.scrollBy(0,150)", "");
		//		js.executeScript("arguments[0].scrollIntoView();", bundlecompanylevelaWBConciergeLFS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Thread.sleep(waitResponse);
		wait.until(ExpectedConditions.elementToBeClickable(txtCompanyName));
		driver.findElement(txtCompanyName).clear();
//		registerPage.inputEmailRegister("sgccn-qa-"+ RandomStringUtils.randomNumeric(6)+"@mailinator.com");
//		RandomStringUtils.randomNumeric(6);
//		RandomStringUtils.random(4);
		String company = RandomStringUtils.randomNumeric(4)+"-"+companyName;
		System.out.println(company);
		driver.findElement(txtCompanyName).sendKeys(company);
	}
	public void searchinputCompanyNameOnMyCompany(String companyName) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitResponse));
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		js.executeScript("window.scrollBy(0,150)", "");
		//		js.executeScript("arguments[0].scrollIntoView();", bundlecompanylevelaWBConciergeLFS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Thread.sleep(waitResponse);
		wait.until(ExpectedConditions.elementToBeClickable(txtCompanyName));
		driver.findElement(txtCompanyName).clear();
//		registerPage.inputEmailRegister("sgccn-qa-"+ RandomStringUtils.randomNumeric(6)+"@mailinator.com");
//		RandomStringUtils.randomNumeric(6);
//		RandomStringUtils.random(4);
		String company = companyName;
		System.out.println(company);
		driver.findElement(txtCompanyName).sendKeys(company);
	}
	public void inputCompanyRegNoOnMyCompany(String companyName){
		driver.findElement(txtCompanyRegNo).clear();
		driver.findElement(txtCompanyRegNo).sendKeys(companyName);
	}
	//	public void selectCompanyType(String companyType){
	//		Select selectCompanyType = new Select(driver.findElement(dropdownCompanyType));
	//		selectCompanyType.selectByVisibleText(companyType);
	//	}
	public void selectCompanyType(String companyType){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("company type selected is enabled : "+dropdownMenuCompanytype.isEnabled()+" company type selected is displaying : "+dropdownMenuCompanytype.isDisplayed());
		dropdownMenuCompanytype.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("company type selected is enabled : "+dropdownCompanyType.get(1).isEnabled()+" company type selected is displaying : "+dropdownCompanyType.get(1).isDisplayed());
		dropdownCompanyType.get(1).click();
	}
	//	public void selectCountry(String country){
	//		Select selectCountry = new Select(driver.findElement(dropdownCountry));
	//		selectCountry.selectByVisibleText(country);
	//	}
	public void selectCountry(String country){
		//		System.out.println("selec");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		dropdownMenuCountry.click();
		for(WebElement i:dropdownCountry) {
			if(i.getText().contains(country)) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
				i.click();
				break;
			}
		}


	}


	//	public void selectCity(String city){
	//		Select selectCity = new Select(driver.findElement(dropdownCity));
	//		selectCity.selectByVisibleText(city);
	//	}

	public void selectCity(String city) throws Exception{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Thread.sleep(waitResponse);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50)", "");
		dropdownMenuCity.click();
		dropdownMenuCity.sendKeys(city);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println(dropdownCity.get(0).getText()+" same as city selected: "+city);
		dropdownCity.get(0).click();;
		//		for(WebElement i:dropdownCity) {
		//			if(i.getText().contains(city)) {
		//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		//				i.click();
		//				break;
		//			}
		//		}
	}

	public void pressSearchCompany(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnSearchCompany).isDisplayed();
		driver.findElement(btnSearchCompany).click();
	}
	
	private void clickAccountCircleIcon() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("accountCircleIcon is display-enable : "+accountCircleIcon.isDisplayed()+" - "+accountCircleIcon.isEnabled());
		accountCircleIcon.click();
	}
	
	public void myMenuAccount(String menu) throws Exception {
		Thread.sleep(waitResponse);
//		driver.get("https://sandbox.cubeforall.com/portal/manage-subscription/");
		clickAccountCircleIcon();
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		switch (menu) {
		case "My Portal":
			lsMenuAccount.get(0).click();
			break;
		case "My Company":
			lsMenuAccount.get(1).click();
			break;
		case "My Subscriptions":
			lsMenuAccount.get(2).click();
//			driver.get("https://sandbox.cubeforall.com/portal/manage-subscription/");
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
	
	public void clickCircleMenuAccount() throws Exception {
		Thread.sleep(waitResponse);
//		driver.get("https://sandbox.cubeforall.com/portal/manage-subscription/");
		clickAccountCircleIcon();
		Thread.sleep(waitResponse);
		ClickMenuAccount.click();
		Thread.sleep(waitResponse);
		ClickSubscribe.click();
		Thread.sleep(waitResponse);
		
		}
	
	public void clickUnsubscribeAWBConcierge() throws Exception {
		
		}
		
	public void pressJoinCompany(int position) throws Exception{
		//		driver.findElements(btnJoinCompany).isDisplayed();

		//		driver.findElement(btnJoinCompany).isDisplayed();
		//		driver.findElement(btnJoinCompany).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		Thread.sleep(waitResponse);

		lsBtnJoinCompany.get(position).isDisplayed();
		lsBtnJoinCompany.get(position).click();
	}
	public void pressCreateNewCompany(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnCreateCompany).isDisplayed();
		driver.findElement(btnCreateCompany).click();
	}
	public WebElement createNewCompany(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)", "");
		return driver.findElement(btnCreateCompany);
	}
	public void pressWithdrawApplication() throws Exception{
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnWithdrawApplication).isDisplayed();
		driver.findElement(btnWithdrawApplication).click();
	}
	public void pressRejectApplicationFromCompanyByUser(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnRejectApplicationFromUser).isDisplayed();
		driver.findElement(btnRejectApplicationFromUser).click();
	}
	public void pressAcceptApplicationFromCompanyByUser(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnAcceptApplicationFromUser).isDisplayed();
		driver.findElement(btnAcceptApplicationFromUser).click();
	}
	public void pressPreviousPageOnCompanyLists(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnPaginationLeftArrow).isDisplayed();
		driver.findElement(btnPaginationLeftArrow).click();
	}
	public void pressNextPageOnCompanyLists(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnPaginationRightArrow).isDisplayed();
		driver.findElement(btnPaginationRightArrow).click();
	}
	public void selectFilterUsersOnMembers(String filter) throws Exception{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));

		//		Select selectFilter = new Select(dropdownFilterUsersOnMembers);
		//		selectFilter.selectByVisibleText(filter);
		Thread.sleep(waitResponse);
		dropdownFilterUsersOnMembers.click();
		Thread.sleep(waitResponse);
		switch (filter) {
		case "All":
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			lsFilterUsersOnMembers.get(0).click();
			break;
		case "Pending Accept":
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			lsFilterUsersOnMembers.get(1).click();
			break;
		case "Pending Approve":
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			lsFilterUsersOnMembers.get(2).click();
			break;
		case "Active":
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
			lsFilterUsersOnMembers.get(3).click();
			break;
		default:
			break;
		}

		//		Select selectFilter = new Select(driver.findElement(dropdownFilterUsersOnMembers));
		//		selectFilter.selectByVisibleText(filter);
	}
	public WebElement applicationStatusLabel(){
		return driver.findElement(lblApplicationStatus);
	}
	public String companyListsTable(){
		//		return (WebElement) driver.findElements(tblCompanyList);
		String result="";
		if(tblCompanyList==null) {
			result="system didnt found the suggested company matched";

		}else {
			result="system found the suggested company matched";
		}
		return result;
	}


	//Modals
	By btnCancelOnModal = By.id("cube-cancel");
	By btnInviteOnModal = By.xpath("//button[@id=\"cube-confirm-add-user\"]");
	By btnLaterOnModal = By.id("cube-later");
	By btnSetupNowOnModal = By.id("cube-setup-now");

	//	By btnConfirmOnModal = By.id("cube-confirm");
	@FindBy(xpath="//*[@id=\"cube-confirm-application-status\"]")//*[@id="cube-confirm-join"]
	@CacheLookup
	private WebElement btnConfirmOnConfirmWithdraw;
	@FindBy(xpath="//*[@id=\"cube-later\"]")
	@CacheLookup
	private WebElement btnCancelConfirmOnConfirmWithdraw;

	@FindBy(xpath="//*[@id=\"cube-confirm-join\"]")
	@CacheLookup
	private WebElement btnConfirmOnJoinRquest;
	@FindBy(xpath="")
	@CacheLookup
	private WebElement btnCancelConfirmOnJoinRquest;




	public void pressCancelOnModalMyCompany(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnCancelOnModal).isDisplayed();
		driver.findElement(btnCancelOnModal).click();
	}
	//	public void pressConfirmOnModalMyCompany() throws Exception{
	//		Thread.sleep(waitResponse);
	//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
	//		//		driver.findElement(btnConfirmOnModal).isDisplayed();
	//		//		driver.findElement(btnConfirmOnModal).click();
	//		btnConfirmOnModal.isDisplayed();
	//		btnConfirmOnModal.click();
	//	}
	public void pressConfirmWithdrwawRquestCompany() throws Exception{
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		//		driver.findElement(btnConfirmOnModal).isDisplayed();
		//		driver.findElement(btnConfirmOnModal).click();
		btnConfirmOnConfirmWithdraw.isDisplayed();
		btnConfirmOnConfirmWithdraw.click();
	}
	public void pressConfirmRequestCompany() throws Exception{
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		//		driver.findElement(btnConfirmOnModal).isDisplayed();
		//		driver.findElement(btnConfirmOnModal).click();
		btnConfirmOnJoinRquest.isDisplayed();
		btnConfirmOnJoinRquest.click();
	}
	public void pressInviteOnModalMyCompany(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnInviteOnModal).isDisplayed();
		driver.findElement(btnInviteOnModal).click();
	}
	public void pressLaterOnModalMyCompany(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnLaterOnModal).isDisplayed();
		driver.findElement(btnLaterOnModal).click();
	}
	public void pressSetupNowOnModalMyCompany(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(btnSetupNowOnModal).isDisplayed();
		driver.findElement(btnSetupNowOnModal).click();
	}
	public WebElement setupNowOnModalMyCompany(){
		return driver.findElement(btnSetupNowOnModal);
	}

	// Setup company (Company Details)
	By txtAddress = By.id("cube-address");
	By txtPostCode = By.id("cube-postcode");
	By txtIataMembershipNo = By.id("cube-iata-code");
	By txtCassNo = By.id("cube-cass-code");
	@FindBy(xpath="//*[@id=\"cube-cube-company-email\"]")
	@CacheLookup
	private WebElement txtCompanyemail;
	@FindBy(xpath="//*[@id=\"cube-cube-company-mobile-no\"]")
	@CacheLookup
	private WebElement txtMobileNumberMobileDetails;

	// Setup company (Admin Contact Details)
	By txtContactName = By.id("cube-username");
	By txtDesignation = By.id("cube-designation");
	By txtMobileNo = By.id("cube-cube-mobile-no");
	By txtEmail = By.id("cube-email");
	//	@FindBy(xpath="//*[@id=\"cube-undefined\"]")
	//	@CacheLookup
	//	private WebElement domainNumber;
	@FindBy(xpath="//*[@id=\"cube-undefined\"]")
	@CacheLookup
	private List<WebElement> domainNumber;
	@FindBy(xpath="//*[@id=\"cube-form-create-company\"]/div[8]/div[2]/div[3]/ul/li")
	@CacheLookup
	private List<WebElement> selectDomainNumberCounty;

	// Mailing Address
	@FindBy(xpath="//*[@id=\"cube-form-create-company\"]/div[5]/div[2]/label/span")
	@CacheLookup
	private WebElement checkBoxSameAsRegisterAddress;

	//Button Cancel And Submit
	@FindBy(xpath="//button[@id=\"cube-submit\"]")
	@CacheLookup
	private WebElement btnSubmit;
	@FindBy(xpath="//*[@id=\"cube-cancel\"]")
	@CacheLookup
	private WebElement btnCancel;

	// pop up after submit create company
	@FindBy(xpath="//button[@id=\"cube-confirm\"]")
	@CacheLookup
	private WebElement btnProceedConfirmationCreateCompany;
	
	@FindBy(xpath="//*[@id=\"cube-later\"]")
	@CacheLookup
	private WebElement btnLaterConfirmationCreateCompany;

	// post payment
	
	@FindBy(xpath="//button[@id=\"cube-confirm\"]")
	@CacheLookup
	private WebElement btnPostpaymentCreateCompany;

	public WebElement clickbtnPostpaymentCreateCompany() {
		return btnPostpaymentCreateCompany;
	}

	public void clickbtnProceedConfirmationCreateCompany() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitResponse));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		wait.until(ExpectedConditions.elementToBeClickable(btnProceedConfirmationCreateCompany));
		btnProceedConfirmationCreateCompany.click();
	}

	public void clickbtnLaterConfirmationCreateCompany() {
		btnLaterConfirmationCreateCompany.click();
	}

	public void clickCheckBoxRegisterSameMailing() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		checkBoxSameAsRegisterAddress.isDisplayed();
		checkBoxSameAsRegisterAddress.click();
	}
	public void clickButtonSubmitCompany() throws Exception {
		Thread.sleep(waitResponse);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		System.out.println("btnSubmit company is displaying: "+btnSubmit.isDisplayed()+" also enabled: "+btnSubmit.isEnabled());
		btnSubmit.click();
	}
	public void inputCompanyMobileNumberCompanyDetails(String contactNo){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		txtMobileNumberMobileDetails.clear();
		txtMobileNumberMobileDetails.sendKeys(contactNo);
	}

	public void inputContactNameSetupCompany(String contactName){

		driver.findElement(txtContactName).clear();
		driver.findElement(txtContactName).sendKeys(contactName);
	}
	public void inputDesignationSetupCompany(String designation){
		driver.findElement(txtDesignation).clear();
		driver.findElement(txtDesignation).sendKeys(designation);
	}
	public void inputCompanyEmailSetupCompanyDetails(String companyemail){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		txtCompanyemail.clear();
		txtCompanyemail.sendKeys(companyemail);
	}
	public void inputMobileNoSetupCompany(String mobileNo){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		domainNumber.get(1).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		selectDomainNumberCounty.get(0).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(txtMobileNo).clear();
		driver.findElement(txtMobileNo).sendKeys(mobileNo);
	}
	public void inputEmailSetupCompany(String email){
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(email);
	}
	public void inputIataMembershipNoSetupCompany(String iataMemberNo){
		driver.findElement(txtIataMembershipNo).clear();
		driver.findElement(txtIataMembershipNo).sendKeys(iataMemberNo);
	}
	public void inputCassNoSetupCompany(String cassNo){
		driver.findElement(txtCassNo).clear();
		driver.findElement(txtCassNo).sendKeys(cassNo);
	}
	public void inputAddress(String address){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		driver.findElement(txtAddress).clear();
		driver.findElement(txtAddress).sendKeys(address);
	}
	public void inputPostCode(String postCode){
		driver.findElement(txtPostCode).clear();
		driver.findElement(txtPostCode).sendKeys(postCode);
	}
	public void pressSubmitCreateCompany(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
		btnSubmit.isDisplayed();
		btnSubmit.click();
	}

	//sort
	By sorting = By.id("cube-sort-["+name+"]");
	public void selectSorting(String nameSort){
		name = nameSort;
		driver.findElement(sorting).isDisplayed();
		driver.findElement(sorting).click();
	}
}
