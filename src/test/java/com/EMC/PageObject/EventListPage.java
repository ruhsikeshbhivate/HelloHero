package com.EMC.PageObject;

import java.time.Duration;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EventListPage {

	WebDriver ldriver;

	public EventListPage(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//button[text()='+ Add Event']")
	WebElement AddEventButton;
	
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
	public WebElement EventStartDate;
	
	@FindBy(xpath = "//input[@name=\"event_start_time\"]")
	WebElement eventStartTime;
	
	@FindBy(xpath = "(//span[@class=\"glyphicon glyphicon-chevron-up\"])[1]")
	WebElement increaseStartTime;
	
	@FindBy(xpath = "//input[@name=\"schedule_session_length\"]")
	public WebElement sessionLength;
	
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
	
	@FindBy(xpath = "//input[@id=\"chk01\"]")
	WebElement monday;
	
	@FindBy(xpath = "//input[@id=\"chk02\"]")
	WebElement tuesday;
	
	@FindBy(xpath = "//input[@id=\"chk03\"]")
	WebElement wednesday;
	
	@FindBy(xpath = "//input[@id=\"chk04\"]")
	WebElement Thursday;
	
	@FindBy(xpath = "//input[@id=\"chk05\"]")
	WebElement friday;
	
	@FindBy(xpath = "//input[@id=\"chk06\"]")
	WebElement saturday;
	
	@FindBy(xpath = "//input[@id=\"chk07\"]")
	WebElement sunday;
	
	@FindBy(xpath = "//input[@name=\"event_end_date\"]")
	WebElement eventEndDate;
	
	@FindBy(xpath = "//a[@class=\"phpdebugbar-close-btn\"]")
	WebElement closeButton;
	
	public void clickOnAddEventButton()
	{
		JavascriptExecutor executor2 = ((JavascriptExecutor) ldriver);
		executor2.executeScript("arguments[0].click();", AddEventButton);
		
	}
	
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
		
	}
	
	public void selectParticipant(String participantId) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select participant = new Select(Participant);
		participant.selectByVisibleText(participantId);
		
	}
	
	public void clickOnAddParticipant() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		AddParticipantButton.click();
		Thread.sleep(2000);
	}
	
	public void selectTherapist(String TherapistId)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Select therapist = new Select(Therapist);
		therapist.selectByVisibleText(TherapistId);
	}
	public void selectOwner(String Id)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Select OwnerId = new Select(owner);
		OwnerId.selectByVisibleText(Id);
	}
	
	public void clickOnAddOwnerButton() throws InterruptedException
	{
		AddOwnerButton.click();
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",eventButton);
	}
	
	@FindBy(xpath = "(//div[@class=\"datepicker-days\"])[3]//tbody//tr[3]//td[6]")
	WebElement date2;
	
	public void clickOnEventStartDate() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",SubmitButton);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		EventStartDate.click();
		Thread.sleep(1000);
		//date2.click();
		Thread.sleep(2000);
		
	}
	
	public void clickOnEventStartTime() throws InterruptedException
	{
		eventStartTime.click();
		Thread.sleep(1000);
	}
	
	public void clickOnIncreaseStartTime() throws InterruptedException
	{
		increaseStartTime.click();
		increaseStartTime.click();
		Thread.sleep(2000);
	}
	
	public void enterSessionLength(String length) throws InterruptedException
	{
		sessionLength.sendKeys(length);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void enterGeneralNotes(String Notes) throws InterruptedException
	{
		GeneralNotes.sendKeys(Notes);
		
	}
	
	public void clickOnScheduleButton() throws InterruptedException
	{
		JavascriptExecutor executor2 = ((JavascriptExecutor) ldriver);
		executor2.executeScript("arguments[0].scrollIntoView();", SubmitButton);
		ScheduleButton.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void clickOnEventButton()
	{	
		eventButton.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",SubmitButton);
	
	}
	
	@FindBy(xpath = "/html/body/div[22]/div/div[3]/button[1]")
	WebElement Submit3;
	
	public void clickOnSubmit() throws InterruptedException
	{
			
		try {
			JavascriptExecutor executor2 = ((JavascriptExecutor) ldriver);
			executor2.executeScript("arguments[0].click();",SubmitButton);
			ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) ldriver;
		    js.executeScript("arguments[0].click();", Submit);
			Thread.sleep(4000);
			
		} catch (Exception nosuchElementException) {
			System.out.println("No matching event found for this date");
			JavascriptExecutor executor2 = ((JavascriptExecutor) ldriver);
			executor2.executeScript("arguments[0].scrollIntoView();",SubmitButton);
			SubmitButton.click();
			ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			JavascriptExecutor js = (JavascriptExecutor) ldriver;
		    js.executeScript("arguments[0].click();", Submit);
			Thread.sleep(4000);
		}
	}
		
	public void checkNotifyToStudent()
	{
		nofifyToStudent.click();
	}
	
	public void clickOnSubmit1() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
	    js.executeScript("arguments[0].click();", Submit);
		Thread.sleep(4000);
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
	
	public void clickONStartEventDate2() throws InterruptedException
	{
			JavascriptExecutor executor = (JavascriptExecutor)ldriver;
			executor.executeScript("arguments[0].scrollIntoView();",SubmitButton);
			ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			EventStartDate.click();
			Thread.sleep(2000);
		
	}
	
	@FindBy(xpath = "/html/body/div[15]/div/div[3]/button[1]")
	WebElement submitEmailPopup;
	
	public void clickOnSubmitEmailPopup() throws InterruptedException
	{
		submitEmailPopup.click();
		Thread.sleep(4000);
	}
	
	@FindBy(xpath = "//select[@id=\"search_org_id\"]")
	WebElement SearchOrganization;
	
	public void searchOrganization(String org) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select participant = new Select(SearchOrganization);
		participant.selectByVisibleText(org);
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//input[@placeholder=\"Select Therapist\"]")
	WebElement SearchTherapist;
	
	public void searchTherapist(String ID) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SearchTherapist.sendKeys(ID);
		Thread.sleep(2000);
		Actions actions = new Actions(ldriver);
		actions.sendKeys(SearchTherapist,Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

		//actions.sendKeys(SearchTherapist,Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);

	}
	
	@FindBy(xpath = "//input[@placeholder=\"Select Participant\"]")
	WebElement SearchParticipant;
	
	public void searchParticipant(String Participant) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SearchParticipant.sendKeys(Participant);
		Actions actions = new Actions(ldriver);
		actions.sendKeys(SearchParticipant,Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys(SearchParticipant,Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//input[@name=\"search_start_date\"]")
	WebElement searchStarDate;
	
	public void clickOnSearchStartDate()
	{	
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		searchStarDate.click();
	}
	
	@FindBy(xpath = "//input[@name=\"search_end_date\"]")
	WebElement searchEndDate;
	
	public void clickOnsearchEndDate() throws InterruptedException
	{	
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		searchEndDate.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement SearchEvent;
	
	public void clickOnSearchEvent() throws InterruptedException
	{	
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", SearchEvent);
		Thread.sleep(3000);
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
	
	
	@FindBy(xpath = "//a[text()=\" Start\"]")
	WebElement Start;
	
	@FindBy(xpath = "//a[text()=\"Next\"]")
	WebElement NextButton;
	
	public void clickOnStart() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",NextButton);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		executor.executeScript("arguments[0].click();",Start);
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//input[@class=\"eventarchive\"]")
	WebElement ArchiveEventCheckbox;
	
	
	public void clickONArchiveEventCheckobox()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",ArchiveEventCheckbox);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ArchiveEventCheckbox.click();
	}
	
	@FindBy(xpath = "//select[@id=\"submit_schedule_action\"]")
	WebElement ScheduleAction;
	
	public void selectScheduleAction(String id)
	{
		Select select = new Select(ScheduleAction);
		select.selectByVisibleText(id);
	}
	
	@FindBy(xpath = "//button[@id=\"submitBtnRev\"]")
	WebElement SubmitAction;
	
	public void clickOnSubmitAction()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SubmitAction.click();
	}
	
	@FindBy(xpath = "//textarea[@name=\"reason\"]")
	WebElement arhiveReason;
	
	public void enterArchiveReason(String reason)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		arhiveReason.sendKeys(reason);
	}
	
	@FindBy(xpath = "(//button[text()=\"Submit\"])[2]")
	WebElement SubmitArchiveSchedule;
	
	public void clickOnSubmitArchiveSchedule() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SubmitArchiveSchedule.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//select[@id=\"search_type_id\"]")
	WebElement SearchScheduleType;
	
	public void searchScheduleType(String org) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select participant = new Select(SearchScheduleType);
		participant.selectByVisibleText(org);
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//a[text()=\"Assigned Referral \"]")
	WebElement AssignReferral;
	
	public void assignReferral() throws InterruptedException
	{
		Thread.sleep(1000);
		AssignReferral.click();
	}
	
	public void clickOnSubmitEvent() throws InterruptedException
	{
		JavascriptExecutor executor2 = ((JavascriptExecutor) ldriver);
		executor2.executeScript("arguments[0].click();",SubmitButton);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		executor2.executeScript("arguments[0].click();", Submit3);
		Thread.sleep(4000);
		
		String url = ldriver.getCurrentUrl();
			
		if (url == "https://stage.hellohero.com/event") {
			
			System.out.println("EventCreated Successfully");
			
		} else {

			System.out.println("No matching event found for this date range, please change the date range");
			executor2.executeScript("arguments[0].click();",SubmitButton);
			ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			executor2.executeScript("arguments[0].click();", Submit3);
			Thread.sleep(4000);
		}
	}
	
	public void clickOnSubmitEvent1() throws InterruptedException
	{
		JavascriptExecutor executor2 = ((JavascriptExecutor) ldriver);
		executor2.executeScript("arguments[0].click();",SubmitButton);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		executor2.executeScript("arguments[0].click();", Submit3);
		Thread.sleep(2000);
		executor2.executeScript("arguments[0].click();", Submit3);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		executor2.executeScript("arguments[0].click();",SubmitButton);

		Thread.sleep(4000);
		
	}
	@FindBy(xpath = "//select[@name=\"participant_group_id[]\"]")
	WebElement SelectTHO;
	
	public void selectTHO(String type)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SelectTHO);
		select.selectByVisibleText(type);
	}
	
	@FindBy(xpath = "(//div[@class=\"datepicker-days\"])[3]//table//tbody//tr[3]//td[6]")
	WebElement DATE;
	
	public void eventDate() throws InterruptedException
	{
		EventStartDate.click();
		Thread.sleep(1000);
		DATE.click();
		Thread.sleep(1000);
	}
	

	@FindBy(xpath = "//span[@class=\"fc-title\"]")
	WebElement eventInfo;
	
	public void clickOnSubmit5() throws InterruptedException
	{
		try {
			JavascriptExecutor executor2 = ((JavascriptExecutor) ldriver);
			executor2.executeScript("arguments[0].scrollIntoView();",SubmitButton);
			SubmitButton.click();
			Thread.sleep(4000);
			executor2.executeScript("arguments[0].scrollIntoView();",eventInfo);
			Thread.sleep(1000);

			
		} catch (Exception nosuchElementException) {
			System.out.println("No matching event found for this date");
			JavascriptExecutor executor2 = ((JavascriptExecutor) ldriver);
			executor2.executeScript("arguments[0].scrollIntoView();",SubmitButton);
			executor2.executeScript("arguments[0].click();",SubmitButton);
			
			Thread.sleep(4000);

		}
	}
	
	public void chooseDate()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wednesday.click();
		Thursday.click();
		friday.click();

	}
	
	@FindBy(xpath = "/html/body/div[10]/div/div[1]/table//tbody//tr[3]//td[3]")
	WebElement Date;

	public void eventEndDate() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		eventEndDate.click();
		Thread.sleep(1000);
		Date.click();	
	}
	
	public void verifyEvent()
	{
		
	}
}

