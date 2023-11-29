package com.EMC.PageObject;

import static org.testng.Assert.assertSame;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.model.Log;

public class ReferralPage {

	WebDriver ldriver;
	public ReferralPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@id=\"referralModal\"]")
	WebElement addReferral;

	@FindBy(xpath = "//select[@id=\"referralSearchOrgSelect2\"]")
	WebElement SelectOrganization;

	@FindBy(xpath = "//select[@id=\"search_user_id\"]")
	WebElement SelectStudent;

	@FindBy(xpath = "//button[@id=\"goToNext\"]")
	WebElement Next;

	@FindBy(xpath = "//select[@id=\"service_requested\"]")
	WebElement ServiceRequested;

	@FindBy(xpath = "//select[@id=\"schedule_type\"]")
	WebElement ScheduleType;

	@FindBy(xpath = "//select[@id=\"schedule_subtype\"]")
	WebElement ScheduleSubType;

	@FindBy(xpath = "//button[@id=\"btn_service_add\"]")
	WebElement addService;

	@FindBy(xpath = "//*[@id=\"nextBtn\"]/button")
	WebElement Submit;

	@FindBy(xpath = "//select[@id=\"referralSearchOrgSelect\"]")
	WebElement SearchOrganization;

	@FindBy(xpath = "//select[@id=\"referralStudent\"]")
	WebElement SearchStudent;

	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement search;

	@FindBy(xpath = "(//a[text()=\"Outreach\"])[1]")
	WebElement outreach;

	@FindBy(xpath = "//input[@name=\"outreach_start_date[]\"]")
	WebElement StartDate;

	@FindBy(xpath = "//input[@name=\"outreach_end_date[]\"]")
	WebElement EndDate;

	@FindBy(xpath = "(//td[text()=\"28\"])[4]")
	WebElement date;

	@FindBy(xpath = "//input[@name=\"outreach_session_lenth[]\"]")
	WebElement SessionLength;

	@FindBy(xpath = "//select[@id=\"intervalInfo0\"]")
	WebElement SelectInterval;

	@FindBy(xpath = "//input[@id=\"numOfTime0\"]")
	WebElement NumberOfTime;

	@FindBy(xpath = "//select[@name=\"started_on[]\"]")
	WebElement StartOutreach;

	@FindBy(xpath = "//button[text()=\"+ Save\"]")
	WebElement Save;

	@FindBy(xpath = "//button[text()=\"Ok\"]")
	WebElement OK;

	@FindBy(xpath = "(//a[text()=\"Outreach Link\"])[1]")
	WebElement outreachLink;

	@FindBy(xpath = "//input[@id=\"first_name\"]")
	WebElement studentFirstName;

	@FindBy(xpath = "//input[@id=\"last_name\"]")
	WebElement studentLastName;

	@FindBy(xpath = "//button[@id=\"user_verification_form\"]")
	WebElement enter;

	@FindBy(xpath = "//a[@id=\"outreach-confirm\"]")
	WebElement Confirm;

	@FindBy(xpath = "//button[@id=\"user_verification_form\"]")
	WebElement next;

	@FindBy(xpath = "//a[@href=\"#TherapistDiv29103\"]")
	WebElement option1;

	@FindBy(xpath = "//*[@id=\"data-table\"]/tbody/tr[2]/td/div[2]")
	WebElement timeslots;

	@FindBy(xpath = "//button[@id=\"create_outreach_schedule\"]")
	WebElement createOutreachSchedule;

	@FindBy(xpath = "//a[@id=\"getReferralDeleteId\"]")
	WebElement ArchiveReferral;

	@FindBy(xpath = "//button[text()=\"Yes, Please!\"]")
	WebElement YesPlease;

	@FindBy(xpath = "//textarea[@id=\"archived_reason\"]")
	WebElement archivedReason;

	@FindBy(xpath = "//button[@id=\"SubmitDeleteForm\"]")
	WebElement submitReason;

	public void clickOnAddReferral() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",addReferral);
		Thread.sleep(1000);
	}

	public void selectOrganization(String org) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SelectOrganization);
		select.selectByVisibleText(org);
		Thread.sleep(3000);
	}

	public void selectStudent(String student)
	{
		Select select = new Select(SelectStudent);
		select.selectByVisibleText(student);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void clickOnNext()
	{
		Next.click();
	}

	public void selectServiceRequested(String Service)
	{   
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(ServiceRequested);
		select.selectByVisibleText(Service);

	}

	public void selectScheduleType(String Type) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(ScheduleType);
		select.selectByVisibleText(Type);
		Thread.sleep(4000);
	}

	public void selectScheduleSubType(String SubType)
	{
		Select select = new Select(ScheduleSubType);
		select.selectByVisibleText(SubType);
	}

	public void clickOnAddService() throws InterruptedException
	{
		addService.click();
		Thread.sleep(3000);
	}

	public void clickOnSubmit() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",Submit);
		Thread.sleep(4000);
	}

	public void searchOrganization(String org)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SearchOrganization);
		select.selectByVisibleText(org);
	}

	public void searchStudent(String student) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SearchStudent);
		select.selectByVisibleText(student);

	}

	public void clickOnSearch()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",search);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void clickOnOutreach()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",outreach);
		//outreach.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void clickOnStartDate() throws InterruptedException
	{	
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",StartDate);
		Thread.sleep(2000);
	}

	public void clickEndDate() throws InterruptedException
	{
		EndDate.click();
		Thread.sleep(2000);
		date.click();
	}

	public void enterSessionLength(String length)
	{
		SessionLength.sendKeys(length);
	}

	public void selectInterval(String interval)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SelectInterval);
		select.selectByVisibleText(interval);
	}

	public void enterNumberOfTimes(String Number)
	{
		NumberOfTime.sendKeys(Number);
	}

	public void selectStartOutreach(String startOutreach)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(StartOutreach);																																										
		select.selectByVisibleText(startOutreach);
	}

	public void clickOnSave()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Save.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		OK.click();
	}

	public void clickOnOutreachLink() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollBy(0,200)", "");
		executor.executeScript("arguments[0].scrollIntoView();",outreachLink);
		outreachLink.click();
		Thread.sleep(3000);
		Set<String>st =ldriver.getWindowHandles();
		List<String>lst =new ArrayList<String>();
		lst.addAll(st);
		ldriver.switchTo().window(lst.get(1));

	}

	public void enterStudentFirstName(String name)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		studentFirstName.sendKeys(name);
	}

	public void enterStudentLasttName(String name)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		studentLastName.sendKeys(name);
	}

	public void clickOnEnter()
	{
		enter.click();
	}

	public void clickOnConfirm()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Confirm.click();
	}

	public void clickOnNext1()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		next.click();
	}

	public void clickOnOption()
	{
		option1.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void clickOnTimeslot()
	{
		timeslots.click();
	}

	public void clickOnSchedule() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",createOutreachSchedule);

		Thread.sleep(5000);
		ldriver.close();
		Thread.sleep(1000);
		Set<String>st =ldriver.getWindowHandles();
		List<String>lst =new ArrayList<String>();
		lst.addAll(st);
		ldriver.switchTo().window(lst.get(0));
		ldriver.navigate().refresh();
	}

	public void clickOnArchiveReferral()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",ArchiveReferral);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}

	public void clickOnYesPlease()
	{
		YesPlease.click();
	}

	public void enterArchivedReason(String reason)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		archivedReason.sendKeys(reason);;
	}

	public void clickOnSubmitReason() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",submitReason);
		Thread.sleep(4000);
	}

	public void clickOnSearchReferral()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",search);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@FindBy(xpath = "//button[text()=\"Without outreach\"]")
	WebElement WithoutOutreach;

	public void clickOnWithoutOutreach() throws InterruptedException
	{
		WithoutOutreach.click();

		Thread.sleep(3000);
	}

	@FindBy(xpath = "//a[text()=\"Add Schedule\"]")
	WebElement AddSchedule;

	public void clickOnAddSchedule()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",AddSchedule);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		AddSchedule.click();
	}

	@FindBy(xpath = "//a[@id=\"find-schedule\"]")
	WebElement UseAutoSchedule;

	public void useAutoSchedule()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		UseAutoSchedule.click();
	}

	@FindBy(xpath = "//select[@id=\"schedule_therapist\"]")
	WebElement ScheduleTherapist;

	public void scheduleTherapist(String Therapist)
	{
		Select select = new Select(ScheduleTherapist);
		select.selectByVisibleText(Therapist);
	}

	@FindBy(xpath = "//input[@name=\"outreach_start_time\"]")
	WebElement OutreachStartTime;

	@FindBy(xpath = "(//span[@class=\"timepicker-hour\"])[1]")
	WebElement TimePicker;

	@FindBy(xpath = "(//td[@class=\"hour\"])[1]")
	WebElement Time;

	public void outreachStartTime()
	{
		OutreachStartTime.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		TimePicker.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Time.click();
	}

	@FindBy(xpath = "//input[@id=\"outreachEndTime\"]")
	WebElement OutreachEndTime;

	@FindBy(xpath = "(//span[@class=\"timepicker-hour\"])[2]")
	WebElement EndTimePicker;

	@FindBy(xpath = "(//td[@class=\"hour\"])[17]")
	WebElement Time1;

	public void outreachEndTime()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		OutreachEndTime.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		EndTimePicker.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Time1.click();
	}

	@FindBy(xpath = "//select[@id=\"intervalInfo\"]")
	WebElement IntervalInfo;

	public void intervalInfo(String info)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(IntervalInfo);
		select.selectByVisibleText(info);
	}

	@FindBy(xpath = "//button[@id=\"get_therapists\"]")
	WebElement Next_GetTherapist;

	public void next_GetTherapist()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Next_GetTherapist.click();
	}

	@FindBy(xpath = "//span[text()=\"03:00 PM - 03:20 PM\"]")
	WebElement SelectTimeslot;

	@FindBy(xpath = "//button[@id=\"create_find_schedule\"]")
	WebElement createSchedule;

	public void selectTimeslot()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",createSchedule);

		SelectTimeslot.click();
	}

	public void clickOnCreateSchedule() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		createSchedule.click();

	}

	@FindBy(xpath = "/html/body/div[14]/div/div[3]/button[1]")
	WebElement WelcomeEmailPopup;

	public void welecomeEmailPopup() throws InterruptedException
	{		
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WelcomeEmailPopup.click();
		Thread.sleep(4000);
		JavascriptExecutor  executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/referrals");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
	}

	@FindBy(xpath = "//input[@id=\"outreachStart\"]")
	WebElement OutreachStartDate;

	public void outreachStartDate() throws InterruptedException
	{		
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		OutreachStartDate.click();
	}

	@FindBy(xpath = "//input[@id=\"outreachEnd\"]")
	WebElement OutreachEndDate;

	@FindBy(xpath = "(//td[text()=\"30\"])[4]")
	WebElement date2;

	public void outreachEndDate() throws InterruptedException
	{		
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		OutreachEndDate.click();
		Thread.sleep(1000);
		date2.click();
	}

	@FindBy(xpath = "//input[@id=\"outreachSessionLength\"]")
	WebElement OutreachSessionLength;

	public void outreachSessionLength(String length) throws InterruptedException
	{		
		OutreachSessionLength.clear();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		OutreachSessionLength.sendKeys(length);
		Thread.sleep(1000);
	}

	@FindBy(xpath = "//input[@id=\"numOfTime\"]")
	WebElement SessionPerDay;

	public void sessionPerDay(String id) throws InterruptedException
	{		
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SessionPerDay.sendKeys(id);
		Thread.sleep(1000);
	}

	@FindBy(xpath = "//*[@id=\"data-table_filter\"]/label/input")
	WebElement DataTableFilter;

	public void DataTableReferralFilter(String Text) throws InterruptedException
	{
		DataTableFilter.sendKeys(Text);
		Thread.sleep(3000);
	}
	public void searchReferral()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",search);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		executor.executeScript("arguments[0].scrollIntoView();",DataTableFilter);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void dataTableFilter() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		DataTableFilter.click();
		DataTableFilter.sendKeys(Keys.CONTROL,"V");
		DataTableFilter.sendKeys(Keys.SPACE);
		Thread.sleep(1000);
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(0));
		Thread.sleep(1000);
	}

	public void dataTableFilter1() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		DataTableFilter.click();
		DataTableFilter.sendKeys(Keys.CONTROL,"V");
		Thread.sleep(2000);
	}

	@FindBy(xpath = "(//a[text()=\"Assign\"])[1]")
	WebElement Assign;

	public void clickOnAssign() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		executor.executeScript("arguments[0].scrollIntoView();",Assign);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		executor.executeScript("arguments[0].click();",Assign);

		Thread.sleep(3000);
		AssignTherapist.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "(//a[text()=\"Reassign\"])[1]")
	WebElement Reassign;
	
	public void clickOnReassign() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		executor.executeScript("arguments[0].scrollIntoView();",Reassign);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		executor.executeScript("arguments[0].click();",Reassign);

		Thread.sleep(3000);
		AssignTherapist.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//span[@title=\"-Select Therapist-\"]")
	WebElement AssignTherapist;

	@FindBy(xpath = "/html/body/span/span/span[1]/input")
	WebElement enterTherapistName;

	public void assignTherapist(String Therapist) throws InterruptedException
	{
		enterTherapistName.sendKeys(Therapist);
		Actions actions = new Actions(ldriver);
		actions.sendKeys(enterTherapistName,Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//button[@id=\"SubmitReferralForm\"]")
	WebElement UpdateTherapistToReferral;

	public void UpdateTherapistToReferral() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		UpdateTherapistToReferral.click();
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//select[@id=\"referralSchedule\"]")
	WebElement SearchUnscheduleReferral;

	public void searchUnscheduleReferral(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SearchUnscheduleReferral);
		select.selectByVisibleText(Text);

	}
	
	@FindBy(xpath = "//input[@id=\"session_length\"]")
	 WebElement SessionLength1;
	
	public void SessionLength1(String Length)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SessionLength1.sendKeys(Length);
	}
	
	@FindBy(xpath = "//input[@id=\"service_start_date\"]")
	WebElement ServiceStarDate;
	
	public void serviceStartDate()
	{
		ServiceStarDate.click();
	}
	
	@FindBy(xpath = "//input[@id=\"service_end_date\"]")
	WebElement ServiceEndDate;
	
	@FindBy(xpath = "(//table[@class=\"table-condensed\"])[10]//tbody//tr[5]//td[5]")
	WebElement Date2;
	
	public void serviceEndDate()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ServiceEndDate.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		date2.click();
	}
	
	@FindBy(xpath = "//input[@id=\"numOfTime\"]")
	WebElement NoOfTimes;
	
	public void NoOfTimes(String Length)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		NoOfTimes.sendKeys(Length);
	}
	
	public void Verify() {
		int NoOfRows = 1;
		int totalColumns = 1;
		
		for(int i=1;i<=NoOfRows;i++)
		{
						
			System.out.print(i+" : ");

			for(int j=1;j<=totalColumns;j++)
			{
				WebElement Value =ldriver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[5]"));
				String Student = Value.getText();
				System.out.println(Student);		

				WebElement Value1 =ldriver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[6]"));
				String Organization = Value1.getText();
				System.out.println(Organization);	
				
				WebElement Value2 =ldriver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[8]"));
				String Discipline = Value2.getText();
				System.out.println(Discipline);
				
				WebElement Value3 =ldriver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[9]"));
				String Service = Value3.getText();
				System.out.println(Service);
				
				WebElement Value4 =ldriver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[10]"));
				String Subtype = Value4.getText();
				System.out.println(Subtype);
				
				WebElement Value5 =ldriver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[12]"));
			    String SessionLength = Value5.getText();
				System.out.println(SessionLength);
				
				if (Student.contentEquals("Luke Wright") == true  && Organization.contentEquals("Rushi_TestOrganization")
						&& Discipline.contentEquals("Occupational Therapist (OT)") && Service.contentEquals("Assessment")
						 && Subtype.contentEquals("Standard Assessment") && SessionLength.contentEquals("10")) {

					System.out.println("Result is getting correct.....");
				}

				else {
					System.out.println("Result is getting wrong.....");
				}
			}
					
		}
	}
		
	
}
