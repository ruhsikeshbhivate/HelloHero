package com.EMC.PageObject;

import java.time.Duration;

import org.apache.poi.hssf.record.UserSViewBegin;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ScheduleListPage {

	WebDriver ldriver;
	
	public ScheduleListPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//button[text()='+ Add Schedule']")
	WebElement addSchedule;
	
	@FindBy(xpath = "//a[text()='Build a schedule']")
	WebElement BuildSchedule;
	
	@FindBy(xpath = "//select[@name=\"organization_id\"]")
	WebElement AddOrganization;
	
	@FindBy(xpath = "//select[@name=\"schedule_type_id\"]")
	WebElement scheduleTypes;
	
	@FindBy(xpath = "//select[@name=\"schedule_subtype_id\"]")
	WebElement scheduleSubTypes;
	
	@FindBy(xpath = "//select[@name=\"specialty_id\"]")
	WebElement scheduleSpecialty;
	
	@FindBy(xpath = "//select[@name=\"video_platform\"]")
	WebElement videoPlatfom; 
	
	@FindBy(xpath = "//select[@name=\"participants\"]")
	WebElement  Participant;
	
	@FindBy(xpath = "//button[@id=\"add_participant\"]")
	WebElement AddParticipantButton;
	
	@FindBy(xpath = "//select[@id=\"rolesId\"]")
	WebElement Therapist;
	
	@FindBy(xpath = "//select[@id=\"ownerId\"]")
	WebElement owner;
	
	@FindBy(xpath = "//button[@id=\"add_owner\"]")
	WebElement AddOwnerButton;
	
	@FindBy(xpath = "//input[@name=\"event_start_date\"]")
	WebElement EventStartDate;
	
	@FindBy(xpath = "//input[@name=\"event_start_time\"]")
	WebElement eventStartTime;
	
	@FindBy(xpath = "(//span[@class=\"glyphicon glyphicon-chevron-up\"])[1]")
	WebElement increaseStartTime;
	
	@FindBy(xpath = "//input[@name=\"schedule_session_length\"]")
	WebElement sessionLength;
	
	@FindBy(xpath = "//textarea[@id=\"event_description\"]")
	WebElement GeneralNotes;
	
	@FindBy(xpath = "//button[@id=\"create_event_btn\"]")
	WebElement SubmitButton;
	
	@FindBy(xpath = "//input[@value=\"schedule\"]")
	WebElement ScheduleButton;
	
	@FindBy(xpath = "//input[@value=\"event\"]")
	WebElement eventButton;
	
	@FindBy(xpath = "//input[@value=\"notifyStudent\"]")
	WebElement nofifyToStudent;
	
	@FindBy(xpath = "(//button[text()='Submit'])[3]")
	WebElement Submit;
	
	@FindBy(xpath = "//label[text()='Monday']")
	WebElement monday;
	
	@FindBy(xpath = "//label[text()='Tuesday']")
	WebElement tuesday;
	
	@FindBy(xpath = "//label[text()='Wednesday']")
	WebElement wednesday;
	
	@FindBy(xpath = "//label[text()='Thursday']")
	WebElement Thursday;
	
	@FindBy(xpath = "//label[text()='Friday']")
	WebElement friday;
	
	@FindBy(xpath = "//label[text()='Saturday']")
	WebElement saturday;
	
	@FindBy(xpath = "//label[text()='Sunday']")
	WebElement sunday;
	
	@FindBy(xpath = "//input[@name=\"event_end_date\"]")
	WebElement eventEndDate;
	
	
	public void clickOnBuildSchedule() throws InterruptedException
	{
		BuildSchedule.click();
		Thread.sleep(3000);
	}
	
	public void selectOrganization(String Text) throws InterruptedException
	{
		Select org = new Select(AddOrganization);
		org.selectByVisibleText(Text);
		Thread.sleep(3000);
	}
	
	public void selectscheduleTypes(String scheduleId) throws InterruptedException
	{
		Select schedule = new Select(scheduleTypes);
		schedule.selectByVisibleText(scheduleId);
		Thread.sleep(3000);
	}
	
	public void selectScheduleSubTypes(String subTypes)
	{
		Select subId = new Select(scheduleSubTypes);
		subId.selectByVisibleText(subTypes);
	}
	
	public void selectSpecialty(String Specialty)
	{
		Select specialId = new Select(scheduleSpecialty);
		specialId.selectByVisibleText(Specialty);
	}
	
	public void selectVideoPlatform(String platform) throws InterruptedException
	{
		Select Platform = new Select(videoPlatfom);
		Platform.selectByVisibleText(platform);
		Thread.sleep(2000);
	}
	
	public void selectParticipant(String participantId) throws InterruptedException
	{
		Select participant = new Select(Participant);
		participant.selectByVisibleText(participantId);
		Thread.sleep(3000);
	}
	
	public void clickOnAddParticipant() throws InterruptedException
	{
		AddParticipantButton.click();
		Thread.sleep(2000);
	}
	
	public void selectTherapist(String TherapistId)
	{
		Select therapist = new Select(Therapist);
		therapist.selectByVisibleText(TherapistId);
	}
	public void selectOwner(String Id)
	{
		Select OwnerId = new Select(owner);
		OwnerId.selectByVisibleText(Id);
	}
	
	public void clickOnAddOwnerButton() throws InterruptedException
	{
		AddOwnerButton.click();
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",SubmitButton);
	}
	
	public void clickOnEventStartDate() throws InterruptedException
	{
		EventStartDate.click();
		Thread.sleep(2000);
		eventEndDate.click();
	}
	
	public void clickOnEventStartTime() throws InterruptedException
	{
		eventStartTime.click();
		Thread.sleep(2000);
	}
	
	public void clickOnIncreaseStartTime() throws InterruptedException
	{
		increaseStartTime.click();
		Thread.sleep(2000);
	}
	
	public void enterSessionLength(String length) throws InterruptedException
	{
		sessionLength.sendKeys(length);
		Thread.sleep(2000);
	}
	
	public void enterGeneralNotes(String Notes) throws InterruptedException
	{
		GeneralNotes.sendKeys(Notes);
		Thread.sleep(2000);
	}
	
	public void clickOnScheduleButton() throws InterruptedException
	{
		JavascriptExecutor executor2 = ((JavascriptExecutor) ldriver);
		executor2.executeScript("arguments[0].scrollIntoView(true);", SubmitButton);
		SubmitButton.click();
		Thread.sleep(5000);
	}
	
	public void clickOnEventButton()
	{
		eventButton.click();
	}
	
	public void clickOnSubmit() throws InterruptedException
	{
		JavascriptExecutor executor2 = ((JavascriptExecutor) ldriver);
		executor2.executeScript("arguments[0].scrollIntoView(true);", SubmitButton);
		Thread.sleep(2000);
		SubmitButton.click();
	}
	
	public void checkNotifyToStudent()
	{
		nofifyToStudent.click();
	}
	
	public void clickOnSubmit1() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
	    js.executeScript("arguments[0].click();", Submit);
		Thread.sleep(5000);
	}
	
	public void clickOnDays() throws InterruptedException
	{
		monday.click();
		tuesday.click();
		wednesday.click();
		Thursday.click();
		friday.click();
		saturday.click();
		sunday.click();
		Thread.sleep(2000);
	}
	
	public  void  clickOnAddSchedule()
	{
		addSchedule.click();
	}
	
	@FindBy(xpath = "//i[@class=\"fas fa-times-circle icon_size\"]")
	WebElement archiveSchedule;
	
	public void clickOnArchiveSchedule()
	{
		archiveSchedule.click();
	}
	
	@FindBy(xpath = "//button[text()=\"Yes, please!\"]")
	WebElement YesPlease;
	
	public void clickOnYesPlease()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		YesPlease.click();
	}
	
	@FindBy(xpath = "//textarea[@name=\"reason\"]")
	WebElement archiveReason;
	

	public void enterArchiveReason(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		archiveReason.sendKeys(Text);
	}
	
	@FindBy(xpath = "(//button[text()=\"Submit\"])[2]")
	WebElement SubmitArchiveSchedule;
	
	public void clickOnSubmitArchiveSchedule() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SubmitArchiveSchedule.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//*[@id=\"search_form\"]/div[2]/div[3]/span/span[1]/span/ul/li/input")
	WebElement SearchTherapist;
	
	public void searchTherapist(String ID) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SearchTherapist.sendKeys(ID);
		Actions actions = new Actions(ldriver);
		actions.sendKeys(SearchTherapist,Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

		actions.sendKeys(SearchTherapist,Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//select[@id=\"search_org_id\"]")
	WebElement SearchOrganization;
	
	public void SearchOrganization(String TherapistId)
	{
		Select therapist = new Select(SearchOrganization);
		therapist.selectByVisibleText(TherapistId);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
}
