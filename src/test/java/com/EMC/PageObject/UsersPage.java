package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;


public class UsersPage {

	WebDriver ldriver;

	public UsersPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/users/create\"]")
	WebElement addUser;


	Faker faker = new Faker(new Locale("en-US"));
	
	public static By userFirstName = By.xpath("//input[@id=\"first_name\"]");
	
	public void UserFirstName()
	{
		((WebElement) userFirstName).sendKeys(faker.name().firstName());

	}

	public static By userLastName = By.xpath("//input[@id=\"last_name\"]");
	
	public void UserLastName()
	{
		((WebElement) userLastName).sendKeys(faker.name().lastName());

	}

	public static By username = By.xpath("//input[@id=\"username\"]");
	
	public void UserName()
	{
		((WebElement) username).sendKeys(faker.name().username());
	}

	@FindBy(xpath = "//input[@name=\"first_name\"]")
	WebElement UserFirstName;

	@FindBy(xpath = "//input[@name=\"last_name\"]")
	WebElement UserLastName;

	@FindBy(xpath = "//input[@id=\"userSearchNameInput\"]")
	WebElement searchName;

	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement SearchButton;

	@FindBy(xpath = "//a[text()=\"Next\"]")
	WebElement Next;

	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/login/linked-user/30133\"]")
	WebElement loginAsTherapist;

	@FindBy(xpath = "(//a[text()=\"View Profile\"])[1]")
	WebElement ViewProfile;

	@FindBy(xpath = "(//a[text()=\"View Profile\"])[1]")
	WebElement viewProfile1;

	@FindBy(xpath = "//span[text()=\"Documents\"]")
	WebElement Documents;

	@FindBy(xpath = "//span[text()=\"Insurance\"]")
	WebElement Insurance;

	@FindBy(xpath = "//button[@onclick=\"addInsurance()\"]")
	WebElement addInsurance;

	@FindBy(xpath = "//select[@id=\"insurance_relation\"]")
	WebElement SelectRelation;

	@FindBy(xpath = "//select[@id=\"insurance_priority\"]")
	WebElement InsurancType;

	@FindBy(xpath = "//input[@id=\"first_name\"]")
	WebElement firstName;

	@FindBy(xpath = "//input[@id=\"last_name\"]")
	WebElement lastName;

	@FindBy(xpath = "//input[@id=\"insured_dob\"]")
	WebElement DOB;

	@FindBy(xpath = "//select[@id=\"payer_id\"]")
	WebElement InsurancePayer;

	@FindBy(xpath = "//input[@id=\"member_id\"]")
	WebElement memberId;

	@FindBy(xpath = "//button[text()='Save Insurance']")
	WebElement saveInsurance;

	@FindBy(xpath = "//a[@title=\"Clinical\"]")
	WebElement Clinical;

	@FindBy(xpath = "//button[@onclick=\"getModal(1)\"]")
	WebElement Upload;

	@FindBy(xpath = "(//input[@name=\"folder_name\"])[1]")
	WebElement FolderName;

	@FindBy(xpath = "//input[@id=\"fileUpload\"]")
	WebElement ChooseFile;

	@FindBy(xpath = "//button[text()=\"Upload\"]")
	WebElement UploadButton;

	@FindBy(xpath = "//a[@title=\"Rushikesh\"]")
	WebElement RushikeshFiles;

	@FindBy(xpath = "//a[@class=\"phpdebugbar-close-btn\"]")
	WebElement cancel;

	@FindBy(xpath = "//a[@onclick=\"EnablePassFields()\"]")
	WebElement EditPassword;

	@FindBy(xpath = "(//i[@class=\"fas fa-eye-slash\"])[1]")
	WebElement viewPassword;

	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;

	@FindBy(xpath = "//i[@class=\"fas fa-eye-slash\"]")
	WebElement viewConfirmPassword;

	@FindBy(xpath = "//input[@name=\"confirm-password\"]")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@id=\"save_profile\"]")
	WebElement saveProfile;

	@FindBy(xpath = "//*[@id=\"insurance_tableId\"]/tbody/tr/td[6]/a[3]")
	WebElement checkEligibilty;

	@FindBy(xpath = "//span[text()='Notes']")
	WebElement Notes;

	@FindBy(xpath = "//button[@id=\"newUser_notes\"]")
	WebElement addNote;

	@FindBy(xpath = "(//span[@class=\"checkmark\"])[9]")
	WebElement ConfidentialCheckbox;

	@FindBy(xpath = "//textarea[@id=\"note\"]")
	WebElement userNotes;

	@FindBy(xpath = "//button[@id=\"btn_Add_Notes\"]")
	WebElement SaveNote;

	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/login/linked-user/28691\"]")
	WebElement loginAs;

	@FindBy(xpath = "//select[@id=\"notes_serach_type\"]")
	WebElement SelectConfidential;

	@FindBy(xpath = "//button[@id=\"btnFiterResetSearch\"]")
	WebElement clear;

	@FindBy(xpath = "//select[@id=\"orgInput\"]")
	WebElement orgaization;

	@FindBy(xpath = "//select[@id=\"roleId\"]")
	WebElement role;

	@FindBy(xpath = "//input[@id=\"mobile_phone\"]")
	WebElement CellPhone;

	@FindBy(xpath = "//input[@id=\"psw\"]")
	WebElement UserPassword;

	@FindBy(xpath = "//input[@id=\"cPass\"]")
	WebElement UserconfirmPassword;

	@FindBy(xpath = "//button[@id=\"create_profile\"]")
	WebElement createProfile;

	public static By Address = By.xpath("//input[@id=\"p_add\"]");

	@FindBy(xpath = "//input[@id=\"p_city\"]")
	WebElement city;

	@FindBy(xpath = "//select[@id=\"state_dropdown\"]")
	WebElement state;

	@FindBy(xpath = "//input[@id=\"zip_code\"]")
	WebElement zipCode;

	@FindBy(xpath = "//span[@class=\"checkmark\"]")
	WebElement physicalAddressCheckbox;

	@FindBy(xpath = "name=\"credential_ids[]\"")
	WebElement credientials;

	@FindBy(xpath = "//select[@id=\"userSearchRolesSelect\"]")
	WebElement searchUserRole;

	public void SearchUserRole(String type)
	{
		Select select = new Select(searchUserRole);
		select.selectByVisibleText(type);
	}

	public void LoginAsTherapist()
	{
		loginAsTherapist.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void selectCredientials(String type)
	{
		Select select = new Select(credientials);
		select.selectByVisibleText(type);
	}
	public void enterUserFirstName(Keys control)
	{
		UserFirstName.sendKeys(control);
	}

	public void enterUserFirstName1(String control)
	{
		UserFirstName.sendKeys(control);
	}

	public void enterUsersLastName(Keys control)
	{
		UserLastName.sendKeys(control);
	}

	public void selectState(String type)
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",state);
		Select select = new Select(state);
		select.selectByVisibleText(type);
	}

	public void enterZipCode(String zip)
	{
		zipCode.sendKeys(zip);
	}

	public void enterCellPhone(String Phone)
	{
		CellPhone.sendKeys(Phone);
	}

	public void enterUserPassword(String pass)
	{
		UserPassword.sendKeys(pass);
	}

	public void enterUserConfirmPassword(String pass)
	{
		UserconfirmPassword.sendKeys(pass);
	}

	public void clickOnCreateProfile() throws InterruptedException
	{
		createProfile.click();
		Thread.sleep(8000);
	}

	public void selectOrganization(String type)
	{
		Select select = new Select(orgaization);
		select.selectByVisibleText(type);
	}

	public void selectRole(String type) throws InterruptedException
	{
		Select select = new Select(role);
		select.selectByVisibleText(type);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",createProfile);
		Thread.sleep(2000);
	}

	public void clickOnClear() throws InterruptedException
	{
		clear.click();
		Thread.sleep(5000);
	}
	public void clickOnSaveNote() throws InterruptedException
	{
		SaveNote.click();
		Thread.sleep(5000);
	}
	public void enterUserNotes(String note)
	{
		userNotes.sendKeys(note);
	}
	public void clickOnNotes() throws InterruptedException
	{
		Notes.click();
		Thread.sleep(2000);
	}

	public void clickOnAddNotes() throws InterruptedException
	{
		addNote.click();
		Thread.sleep(2000);
	}

	public void clickOnConfidentialCheckbox() throws InterruptedException
	{
		ConfidentialCheckbox.click();
		Thread.sleep(2000);
	}

	public void clickOnCheckEligibility()
	{
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", checkEligibilty);
	}

	public void enterSearchName(String Name)
	{
		searchName.sendKeys(Name);
	}

	public void clickOnUsers() throws InterruptedException
	{
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/users");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(2));
		Thread.sleep(4000);
		viewProfile1.click();
	}
	/*public void enterUserFirstName(String Name)
	{
		userFirstName.sendKeys(Name);
	}

	public void enterUserLastName(String Name)
	{
		userLastName.sendKeys(Name);
	}*/
	public void clickOnEditPassword()
	{
		EditPassword.click();
	}

	public void clickOnAddUser() throws InterruptedException
	{
		addUser.click();
		Thread.sleep(2000);
	}

	public void enterCity(String text)
	{
		city.sendKeys(text);
	}
	public void clickOnSaveProfile() throws InterruptedException
	{
		physicalAddressCheckbox.click();
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",saveProfile);
		Thread.sleep(2000);
		saveProfile.click();
		Thread.sleep(4000);
	}

	public void clickOnSearch() throws InterruptedException
	{
		SearchButton.click();
		Thread.sleep(3000);
	}

	public void enterPassword(String pass) throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollBy(0, 400)");
		Thread.sleep(2000);
		viewPassword.click();
		password.sendKeys(pass);
		Thread.sleep(1000);
	}

	public void enterConfirmPassword(String pass) throws InterruptedException
	{
		viewConfirmPassword.click();
		confirmPassword.sendKeys(pass);
	}

	public void clickOnViewProfile() throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor Execute = (JavascriptExecutor)ldriver;
		Execute.executeScript("arguments[0].click();",ViewProfile);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		
	
	}

	public void clickOnDocuments() throws InterruptedException
	{
		Documents.click();
		Thread.sleep(3000);
	}

	public void clickOnInsurance() throws InterruptedException
	{
		Insurance.click();
		Thread.sleep(3000);
	}

	public void clickOnAddInsurance() throws InterruptedException
	{
		addInsurance.click();
		Thread.sleep(2000);
	}

	public void selectRelation(String relation)
	{
		Select select = new Select(SelectRelation);
		select.selectByVisibleText(relation);
	}

	public void selectInsuranceType(String type)
	{
		Select select = new Select(InsurancType);
		select.selectByVisibleText(type);
	}

	public void selectInsurancePayer(String payer)
	{
		Select select = new Select(InsurancePayer);
		select.selectByVisibleText(payer);
	}

	public void clickOnDOB() 
	{
		DOB.click();
	}

	public void clickOnSaveInsurance() throws InterruptedException 
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",saveInsurance);
		Thread.sleep(2000);
		saveInsurance.click();
		Thread.sleep(2000);
	}
	public void enterMemberId(String Id)
	{
		memberId.sendKeys(Id);
	}

	public void enterlastName(String Name)
	{
		lastName.sendKeys(Name);
	}

	public void enterFirstName(String Name)
	{
		firstName.sendKeys(Name);
	}
	public void clickOnClinical() throws InterruptedException
	{
		Clinical.click();
		Thread.sleep(3000);
	}

	public void clickOnUpload() throws InterruptedException
	{
		Upload.click();
		Thread.sleep(2000);
	}

	public void enterFolderName(String Name2)
	{
		FolderName.sendKeys(Name2);
	}

	public void clickOnChooseFile(String Name1)
	{

		ChooseFile.sendKeys(Name1);
	}

	public void clickOnUploadButton()
	{
		UploadButton.click();
	}

	public void clickOnRushikeshFiles() throws InterruptedException
	{
		cancel.click();
		Thread.sleep(2000);
		RushikeshFiles.click();
	}

	public void loginAccountAdmin() throws InterruptedException
	{
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/users");
		Thread.sleep(3000);
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
	}

	public void clickOnLoginAs() throws InterruptedException
	{
		loginAs.click();
		Thread.sleep(5000);
	}

	public void selectConfidential(String text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SelectConfidential);
		select.selectByVisibleText(text);
	}

	@FindBy(xpath = "//select[@id=\"userSearchTitleSelect\"]")
	WebElement SearchOrganization;

	public void SearchOranization(String Org) throws InterruptedException
	{	
		ldriver.navigate().refresh();
		Thread.sleep(3000);
		Select select = new Select(SearchOrganization);
		select.selectByVisibleText(Org);
	}

	@FindBy(xpath = "(//a[text()=\"New Therapy Services\"])[1]")
	WebElement NewTherapyServices;

	public void newTherapyServices()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		NewTherapyServices.click();
	}
	
	public void openReferralPage()
	{
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/referrals");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
	}
	
	@FindBy(xpath = "//input[@name=\"first_name\"]")
	WebElement FirstName;
	
	public void copyUserFirstName() throws InterruptedException
	{
		FirstName.sendKeys(Keys.CONTROL,"A");
		FirstName.sendKeys(Keys.CONTROL,"C");
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//input[@name=\"last_name\"]")
	WebElement LastName;
	
	public void copyUserLastName() throws InterruptedException
	{
		LastName.sendKeys(Keys.CONTROL,"A");
		LastName.sendKeys(Keys.CONTROL,"C");
		Thread.sleep(1000);
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "(//a[text()=\"Schedule\"])[1]")
	WebElement Schedule;

	public void Schedule()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Schedule.click();
	}
	
	@FindBy(xpath = "//*[@id=\"data-table_filter\"]/label/input")
	WebElement UsersDataTableFilter;
	
	public void usersDataTablefilter(String Text)
	{
		UsersDataTableFilter.sendKeys(Text);
		
	}
	
	@FindBy(xpath = "(//a[text()=\"Detach\"])[1]")
	WebElement DetachUser;
	
	public void detachUser()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",DetachUser);
		
	}
	
	@FindBy(xpath = "//textarea[@name=\"detach_reason\"]")
	WebElement DetachUserReason;
	
	public void detachUserReason(String Text)
	{
		DetachUserReason.sendKeys(Text);
		
	}
	
	@FindBy(xpath = "//button[@id=\"detachSubmit\"]")
	WebElement SubmitReason;
	
	public void submitReason() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",SubmitReason);
		Thread.sleep(2000);
	}
		

	@FindBy(xpath = "//input[@id=\"userSearchNameInput\"]")
	WebElement EnterStudentName;
	
	public void enterStudentName(String Text) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		EnterStudentName.sendKeys(Text);
		Thread.sleep(1000);
		EnterStudentName.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

	}
	
}
