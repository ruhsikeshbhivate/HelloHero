
package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {

	WebDriver ldriver;
	public LandingPage(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@id=\"new_referral_btn\"]")
	WebElement newReferral;
	
	@FindBy(xpath = "//input[@id=\"your_email\"]")
	WebElement yourEmail;
	
	public static By FirstName = By.xpath("//input[@id=\"student_first_name1\"]");
	
	public static By LastName = By.xpath("//input[@id=\"student_last_name1\"]");

		
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
	
	@FindBy(xpath = "(//td[text()=\"24\"])[4]")
	WebElement date;
	
	@FindBy(xpath = "//select[@id=\"intervalInfo1\"]")
	WebElement frequency;
	
	@FindBy(xpath = "//input[@id=\"numOfTime1\"]")
	WebElement noOfTimes;
	
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submit;
	
	@FindBy(xpath = "//h1[text()='Hello Hero & Rushi_TestOrganization']")
	WebElement getOrganizationText;
	
	@FindBy(xpath = "//button[@id=\"multi_referral_button\"]")
	WebElement multiStudentReferral;
	
	@FindBy(xpath = "//input[@name=\"files[]\"]")
	WebElement csvFile;
	
	@FindBy(xpath = "//button[text()='Upload']")
	WebElement uploadButton;
	
	@FindBy(xpath = "//select[@id=\"parent_state_dropdown1\"]")
	WebElement State;
	
	@FindBy(xpath = "//input[@id=\"student_zipcode1\"]")
	WebElement zipCode;
	
	@FindBy(xpath = "//select[@id=\"started_on1\"]")
	WebElement StartOutreach;
	
	public void selectStartOutreach(String status)
	{
		Select select = new Select(StartOutreach);
		select.selectByVisibleText(status);
	}
	
	public void selectState(String text)
	{
		Select select = new Select(State);
		select.selectByVisibleText(text);
	}
	
	public void enterZipCode(String zip)
	{
		zipCode.sendKeys(zip);
	}
	
	public String GetOrganizationText()
	{
		String text = getOrganizationText.getText();
		return text;
	}
	
	public void clickOnNewReferral()
	{
		newReferral.click();
	}
	
	public void clickOnDOB()
	{
		DOB.click();
	}
	
	public void enterYourEmail(String email)
	{
		yourEmail.sendKeys(email);
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
	
	public void enterContactEmail(String email) throws InterruptedException
	{
		contactEmail.sendKeys(email);
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		date.click();
	}
	
	public void clickSubmit() throws InterruptedException
	{
		submit.click();
	    Thread.sleep(6000);
		submit.click();
		Thread.sleep(3000);
	}
	
	public void clickOnMultiStudentReferral() throws InterruptedException
	{
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/schools/landingpage?token=GNYX35uJOzqs3yBLvLJjWDPc52dJo7pvndWIMOh6TW7P4AZKUaIECY1gkVFK4FY6cS2MF8bJEYTn7vzPRgOnNRyGVFMPIcbJmS40");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(3));
		multiStudentReferral.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void selectcsvFile(String file) throws InterruptedException
	{
		csvFile.sendKeys(file);
		Thread.sleep(1000);
	}
	
	public void clickOnUpload() throws InterruptedException
	{
		uploadButton.click();
		Thread.sleep(3000);
	}
}
