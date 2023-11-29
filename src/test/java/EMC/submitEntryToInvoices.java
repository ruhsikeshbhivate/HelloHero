package EMC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class submitEntryToInvoices {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://stage.hellohero.com/login");

		driver.manage().window().maximize();

		WebElement Username = driver.findElement(By.xpath("//input[@id=\"login\"]"));
		Username.sendKeys("sagar_admin");

		WebElement Password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		Password.sendKeys("Sagar@Admin3343");

		WebElement LoginButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
		LoginButton.click();
		Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement Schedulling = driver.findElement(By.xpath("//span[text()='Scheduling']"));
		Schedulling.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement Events = driver.findElement(By.xpath("(//a[@href=\"https://stage.hellohero.com/event-list\"])[1]"));
		Events.click();
		Thread.sleep(3000);

		WebElement AddEventButton = driver.findElement(By.xpath("//button[text()='+ Add Event']"));
		AddEventButton.click();

		WebElement BuildSchedule = driver.findElement(By.xpath("//a[text()='Build a schedule']"));
		BuildSchedule.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement AddOrganization = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name=\"organization_id\"]")));
		//AddOrganization.click();
		/*WebElement AddOrganization = driver.findElement(By.xpath("//select[@name=\"organization_id\"]"));*/
		Select org = new Select(AddOrganization);
		org.selectByValue("295");

		Thread.sleep(3000);
		WebElement ScheduleType= driver.findElement(By.xpath("//select[@name=\"schedule_type_id\"]"));
		Select scheduletype = new Select(ScheduleType);
		scheduletype.selectByVisibleText("Assessment");

		Thread.sleep(3000);
		WebElement ScheduleSubType = driver.findElement(By.xpath("//select[@name=\"schedule_subtype_id\"]"));
		Select schedulesubtype = new Select(ScheduleSubType);
		schedulesubtype.selectByVisibleText("Eligibility Assessment");

		WebElement SelectSpecialty = driver.findElement(By.xpath("//select[@name=\"specialty_id\"]"));
		Select selectSpecialty = new Select(SelectSpecialty);
		selectSpecialty.selectByVisibleText("Physical Therapist ()");

		WebElement VideoPlatform= driver.findElement(By.xpath("//select[@name=\"video_platform\"]"));
		Select videoPlatform = new Select(VideoPlatform);
		videoPlatform.selectByVisibleText("HelloHERO Video");

		Thread.sleep(2000);
		WebElement Participant = driver.findElement(By.xpath("//select[@name=\"participants\"]"));
		Select participant = new Select(Participant);
		participant.selectByVisibleText("97 refferal tarak");

		Thread.sleep(2000);
		WebElement AddParticipantButton= driver.findElement(By.xpath("//button[@id=\"add_participant\"]"));
		AddParticipantButton.click();

		Thread.sleep(2000);
		WebElement Owner = driver.findElement(By.xpath("//select[@id=\"ownerId\"]"));
		Select owner = new Select(Owner);
		owner.selectByVisibleText("Therapisttony Stark");
		Thread.sleep(2000);

		WebElement AddOwnerButton = driver.findElement(By.xpath("//button[@id=\"add_owner\"]"));
		AddOwnerButton.click();

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement submitButton = driver.findElement(By.xpath("//button[@id=\"create_event_btn\"]"));

		executor.executeScript("arguments[0].scrollIntoView();",submitButton);

		Thread.sleep(2000);
		WebElement StartEventDate= driver.findElement(By.xpath("//input[@name=\"event_start_date\"]"));
		StartEventDate.click();
		Thread.sleep(2000);

		WebElement StartEventTime= driver.findElement(By.xpath("//input[@name=\"event_start_time\"]"));
		StartEventTime.click();

		Thread.sleep(2000);
		WebElement IncreaseStartTime= driver.findElement(By.xpath("(//span[@class=\"glyphicon glyphicon-chevron-up\"])[1]"));
		IncreaseStartTime.click();

		WebElement SessionLength = driver.findElement(By.xpath("//input[@name=\"schedule_session_length\"]"));
		SessionLength.sendKeys("2");
		Thread.sleep(2000);

		WebElement GeneralScheduleNotes = driver.findElement(By.xpath("//textarea[@id=\"event_description\"]"));
		GeneralScheduleNotes.sendKeys("This Event created by automation script");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		WebElement SubmitButton = driver.findElement(By.xpath("//button[@id=\"create_event_btn\"]"));
		JavascriptExecutor executor2 = ((JavascriptExecutor) driver);
		executor2.executeScript("arguments[0].scrollIntoView(true);", SubmitButton);
		SubmitButton.click();

		Thread.sleep(5000);
		WebElement eventInfo = driver.findElement(By.xpath("//span[text()='Eligibility Assessment with 97 refferal tarak, Therapisttony Stark']"));
		JavascriptExecutor executor3 = ((JavascriptExecutor) driver);
		executor3.executeScript("arguments[0].scrollIntoView(true);", eventInfo);
		eventInfo.click();

		Thread.sleep(2000);
		WebElement startButton = driver.findElement(By.xpath("//a[text()='Start']"));
		startButton.click();

		WebElement selectEventStatus = driver.findElement(By.xpath("//select[@name=\"event_status_id[]\"]"));
		Select eventStatus = new Select(selectEventStatus);
		eventStatus.selectByVisibleText("Non-Billable Cancellation");
		Thread.sleep(2000);

		WebElement ConfirmStatusPopup = driver.findElement(By.xpath("//button[text()='Yes, please!']"));
		ConfirmStatusPopup.click();
		Thread.sleep(5000);

		driver.navigate().refresh();
		Thread.sleep(3000);

		WebElement Finance = driver.findElement(By.xpath("//span[text()='Finance']"));
		Finance.click();
		Thread.sleep(4000);
		WebElement Billing = driver.findElement(By.xpath("//a[@href=\"https://stage.hellohero.com/billing\"]"));
		Billing.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(130));

		WebElement billingCategory = driver.findElement(By.xpath("//select[@name=\"billing_category\"]"));
		Select category = new Select(billingCategory);
		category.selectByVisibleText("Direct Pay");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement ReadyForInvoice = driver.findElement(By.xpath("//a[@href=\"#nav-invoice\"]"));
		ReadyForInvoice.click();
		Thread.sleep(3000);

		WebElement OrganizationDrop = driver.findElement(By.xpath("//select[@id=\"organization_id\"]"));
		Select org1 = new Select(OrganizationDrop);
		org1.selectByVisibleText("Test_Organization");
		Thread.sleep(2000);

		WebElement searchTherapist = driver.findElement(By.xpath("//select[@name=\"search_therapist\"]"));
		Select SearchTherapist = new Select(searchTherapist);
		SearchTherapist.selectByVisibleText("Therapisttony Stark");

		Thread.sleep(2000);
		WebElement SearchClient = driver.findElement(By.xpath("//select[@name=\"search_student\"]"));
		Select searchclient= new Select(SearchClient);
		searchclient.selectByVisibleText("97 refferal tarak");

		Thread.sleep(2000);
		WebElement SearchFilterButton = driver.findElement(By.xpath("//button[@id=\"btnFiterSubmitSearch\"]"));
		SearchFilterButton.click();
		Thread.sleep(5000);

		WebElement checkbox = driver.findElement(By.xpath("(//input[@class=\"ids invoice\"])[1]"));
		JavascriptExecutor executor4 = ((JavascriptExecutor) driver);
		executor4.executeScript("arguments[0].scrollIntoView(true);", checkbox);
		Thread.sleep(3000);
		checkbox.click();

		Thread.sleep(2000);
		WebElement SubmitActionDrop = driver.findElement(By.xpath("//select[@id=\"submit_action_invoice\"]"));
		/*JavascriptExecutor executor5 = ((JavascriptExecutor) driver);
		executor5.executeScript("arguments[0].scrollIntoView(true);", SubmitActionDrop);
		Thread.sleep(2000);*/
		Select submitAction = new Select(SubmitActionDrop);
		submitAction.selectByVisibleText("Send to Invoicing");

		Thread.sleep(2000);
		WebElement SUBMIT = driver.findElement(By.xpath("//button[@onclick=\"submitOption(6)\"]"));
		JavascriptExecutor executor6 = ((JavascriptExecutor) driver);
		executor6.executeScript("arguments[0].scrollIntoView(true);", SUBMIT);
		SUBMIT.click();

		Thread.sleep(2000);
		WebElement OkPopup = driver.findElement(By.xpath("//button[text()='OK']"));
		OkPopup.click();
		driver.navigate().refresh();
		Thread.sleep(3000);
		WebElement Invoices = driver.findElement(By.xpath("//a[@href=\"https://stage.hellohero.com/invoices\"]"));
		Invoices.click();

		Thread.sleep(4000);
		WebElement StartDate = driver.findElement(By.xpath("//input[@id=\"search_start_date\"]"));
		StartDate.click();

		Thread.sleep(2000);
		WebElement SelectUsers = driver.findElement(By.xpath("//select[@id=\"search_user_id\"]"));
		Select selectusers = new Select(SelectUsers);
		selectusers.selectByVisibleText("97 refferal tarak");
		Thread.sleep(3000);

		WebElement userId = driver.findElement(By.xpath("//input[@id=\"userid\"]"));
		userId.click();
		Thread.sleep(2000);
		WebElement searchButton = driver.findElement(By.xpath("//button[@id=\"search_submit\"]"));
		searchButton.click();

		Thread.sleep(3000);
		JavascriptExecutor executor7 = (JavascriptExecutor)driver;
		executor7.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
}
