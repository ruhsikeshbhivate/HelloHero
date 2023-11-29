package EMC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class colorReflectionBillableCancellation {

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
		Thread.sleep(8000);
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

		Select org = new Select(AddOrganization);
		org.selectByValue("343");

		Thread.sleep(5000);
		WebElement ScheduleType= driver.findElement(By.xpath("//select[@name=\"schedule_type_id\"]"));
		Select scheduletype = new Select(ScheduleType);
		scheduletype.selectByVisibleText("Assessment");

		Thread.sleep(4000);
		WebElement ScheduleSubType = driver.findElement(By.xpath("//select[@name=\"schedule_subtype_id\"]"));
		Select schedulesubtype = new Select(ScheduleSubType);
		schedulesubtype.selectByVisibleText("Eligibility Assessment");

		WebElement SelectSpecialty = driver.findElement(By.xpath("//select[@name=\"specialty_id\"]"));
		Select selectSpecialty = new Select(SelectSpecialty);
		selectSpecialty.selectByVisibleText("Occupational Therapist (OT)");

		WebElement VideoPlatform= driver.findElement(By.xpath("//select[@name=\"video_platform\"]"));
		Select videoPlatform = new Select(VideoPlatform);
		videoPlatform.selectByVisibleText("HelloHERO Video");

		Thread.sleep(2000);
		WebElement Participant = driver.findElement(By.xpath("//select[@name=\"participants\"]"));
		Select participant = new Select(Participant);
		participant.selectByVisibleText("Jimmy Carter");

		Thread.sleep(2000);
		WebElement AddParticipantButton= driver.findElement(By.xpath("//button[@id=\"add_participant\"]"));
		AddParticipantButton.click();

		Thread.sleep(2000);
		WebElement Owner = driver.findElement(By.xpath("//select[@id=\"ownerId\"]"));
		Select owner = new Select(Owner);
		owner.selectByVisibleText("Bhivate001 Therapist");
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
		WebElement eventInfo = driver.findElement(By.xpath("//span[text()='Eligibility Assessment with Jimmy Carter, Bhivate001 Therapist']"));
		JavascriptExecutor executor3 = ((JavascriptExecutor) driver);
		executor3.executeScript("arguments[0].scrollIntoView(true);", eventInfo);
		eventInfo.click();

		Thread.sleep(2000);
		WebElement startButton = driver.findElement(By.xpath("//a[text()='Start']"));
		startButton.click();

		WebElement selectEventStatus = driver.findElement(By.xpath("//select[@name=\"event_status_id[]\"]"));
		Select eventStatus = new Select(selectEventStatus);
		eventStatus.selectByVisibleText("Billable Cancellation");
		Thread.sleep(2000);

		WebElement TimeSpent = driver.findElement(By.xpath("//input[@id=\"session_length0\"]"));
		TimeSpent.sendKeys("20");
		Thread.sleep(1000);
		eventStatus.selectByVisibleText("Billable Cancellation");

		WebElement ConfirmStatusPopup = driver.findElement(By.xpath("//button[text()='Yes, please!']"));
		ConfirmStatusPopup.click();
		Thread.sleep(2000);

		WebElement statusReason = driver.findElement(By.xpath("//input[@class=\"swal2-input\"]"));
		statusReason.sendKeys("for automation test");
		
		WebElement ok = driver.findElement(By.xpath("//button[text()='OK']"));
		ok.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(5000);
		executor2.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		executor2.executeScript("window.scrollBy(0,-340)", "");
		Thread.sleep(2000);
		WebElement showColorHover = driver.findElement(By.xpath("//span[@id=\"showPopover\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(showColorHover).perform();
				
	}

}
