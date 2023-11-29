package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SecureAccessPage {

	WebDriver ldriver;
	
	public SecureAccessPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@id=\"first_name\"]")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@id=\"last_name\"]")
	WebElement LastName;
	
	@FindBy(xpath = "//button[@id=\"user_verification_form\"]")
	WebElement verify;
	
	@FindBy(xpath = "//a[@id=\"new_referral_btn\"]")
	WebElement newReferral;
	
	@FindBy(xpath = "//button[text()=\"Add Services to Existing Student\"]")
	WebElement existingStudent;
	
	@FindBy(xpath = "//a[text()=\"New Student\"]")
	WebElement newStudent;
	
	@FindBy(xpath = "//input[@id=\"student_first_name1\"]")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id=\"student_last_name1\"]")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id=\"student_dob1\"]")
	WebElement DOB;
	
	@FindBy(xpath = "//input[@id=\"student_school_id1\"]")
	WebElement schoolID;
	
	@FindBy(xpath = "//input[@id=\"main_contact_first_name1\"]")
	WebElement contactFirstName;
	
	@FindBy(xpath = "//input[@id=\"main_contact_last_name1\"]")
	WebElement contactLastName;
	
	@FindBy(xpath = "//input[@id=\"main_contact_phone1\"]")
	WebElement contactPhone;
	
	@FindBy(xpath = "//input[@id=\"main_contact_email1\"]")
	WebElement contactEmail;
	
	@FindBy(xpath = "//select[@id=\"main_contact_relationship1\"]")
	WebElement relationship;
	
	@FindBy(xpath = "//select[@id=\"service_requested1\"]")
	WebElement specialty;
	
	@FindBy(xpath = "//select[@id=\"schedule_type1\"]")
	WebElement scheduleType;
	
	@FindBy(xpath = "//select[@id=\"schedule_subtype1\"]")
	WebElement scheduleSubType;
	
	@FindBy(xpath = "//input[@id=\"session_length1\"]")
	WebElement sessionLength;
	
	@FindBy(xpath = "//input[@id=\"service_start_date1\"]")
	WebElement startDate;
	
	@FindBy(xpath = "//input[@id=\"service_end_date1\"]")
	WebElement endDate;
	
	@FindBy(xpath = "(//td[text()=\"30\"])[8]")
	WebElement date;
	
	@FindBy(xpath = "//select[@id=\"started_on1\"]")
	WebElement startOutreach;
	
	@FindBy(xpath = "//select[@id=\"intervalInfo1\"]")
	WebElement frequency;
	
	@FindBy(xpath = "//input[@id=\"numOfTime1\"]")
	WebElement noOfTimes;
	
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submit;
	
		
	public void enterFirstName(String Name)
	{
		FirstName.sendKeys(Name);
	}
	
	public void enterLastName(String Name)
	{
		LastName.sendKeys(Name);
	}
	
	public void clickOnVerify()
	{
		verify.click();
	}
	
	public void clickOnNewReferral()
	{
		newReferral.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		newStudent.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
		
	public void clickOnDOB()
	{
		DOB.click();
	}
	
		
	public void enterFirstName1(String name)
	{
		firstName.sendKeys(name);
	}
	
	public void enterLastName1(String name)
	{
		lastName.sendKeys(name);
	}
	
	public void enterSchoolId(String id)
	{
		schoolID.sendKeys(id);
	}
	
	public void enterContactFirstName(String name)
	{
		contactFirstName.sendKeys(name);
	}
	
	public void enterContactLastName(String name)
	{
		contactLastName.sendKeys(name);
	}
	
	public void enterContactPhone(String phone)
	{
		contactPhone.sendKeys(phone);
	}
	
	public void enterContactEmail(String email)
	{
		contactEmail.sendKeys(email);
	}
	
	public void selectRelationship(String Text)
	{
		Select select = new Select(relationship);
		select.selectByVisibleText(Text);
	}
	
	public void selectSpecialty(String Text)
	{
		Select select = new Select(specialty);
		select.selectByVisibleText(Text);
	}
	
	public void selectScheduleType(String Text) throws InterruptedException
	{
		Select select = new Select(scheduleType);
		select.selectByVisibleText(Text);
		Thread.sleep(3000);
	}
	
	public void selectScheduleSubType(String Text)
	{
		Select select = new Select(scheduleSubType);
		select.selectByVisibleText(Text);
	}
	
	public void selectFrequency(String Text)
	{
		Select select = new Select(frequency);
		select.selectByVisibleText(Text);
	}
	
	public void enterSessionLength(String Length)
	{
		sessionLength.sendKeys(Length);
	}
	
	public void enterNoOfTimes(String Times)
	{
		noOfTimes.sendKeys(Times);
	}
	
	public void clickOnStartDate()
	{
		startDate.click();
	}
	
	public void clickEndDate() throws InterruptedException
	{
		endDate.click();
		Thread.sleep(4000);
		date.click();
	}
	
	public void selectStartOutreach(String Text)
	{
		Select select = new Select(startOutreach);
		select.selectByVisibleText(Text);
	}
	public void clickSubmit() throws InterruptedException
	{
		submit.click();
	    Thread.sleep(5000);
		submit.click();
	}
	public void openSecureAccessPage()
	{
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/schools/securedaccess?token=60ZtNjYKe8WHgly7A3bxiEqaswM28604");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(4));
	}
}
