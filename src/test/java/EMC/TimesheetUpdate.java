package EMC;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;

import io.reactivex.rxjava3.functions.Action;

public class TimesheetUpdate {

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
		selectSpecialty.selectByVisibleText("Speech Therapy");

		WebElement VideoPlatform= driver.findElement(By.xpath("//select[@name=\"video_platform\"]"));
		Select videoPlatform = new Select(VideoPlatform);
		videoPlatform.selectByVisibleText("HelloHERO Video");

		Thread.sleep(2000);
		WebElement Participant = driver.findElement(By.xpath("//select[@name=\"participants\"]"));
		Select participant = new Select(Participant);
		participant.selectByVisibleText("Jason Client");

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
		WebElement eventInfo = driver.findElement(By.xpath("//span[text()='Eligibility Assessment with Jason Client, Bhivate001 Therapist']"));
		JavascriptExecutor executor3 = ((JavascriptExecutor) driver);
		executor3.executeScript("arguments[0].scrollIntoView(true);", eventInfo);
		eventInfo.click();

		Thread.sleep(2000);
		WebElement startButton = driver.findElement(By.xpath("//a[text()='Start']"));
		startButton.click();

		WebElement selectEventStatus = driver.findElement(By.xpath("//select[@name=\"event_status_id[]\"]"));
		Select eventStatus = new Select(selectEventStatus);
		eventStatus.selectByVisibleText("No Show");
		Thread.sleep(2000);

		WebElement TimeSpent = driver.findElement(By.xpath("//input[@id=\"session_length0\"]"));
		TimeSpent.sendKeys("20");
		Thread.sleep(1000);
		eventStatus.selectByVisibleText("No Show");
		Thread.sleep(2000);
		
		WebElement ConfirmStatusPopup = driver.findElement(By.xpath("//button[text()='Yes, please!']"));
		ConfirmStatusPopup.click();
		Thread.sleep(5000);

		driver.navigate().refresh();
		Thread.sleep(3000);
		
		WebElement Finance = driver.findElement(By.xpath("//span[text()='Finance']"));
		Finance.click();
		Thread.sleep(4000);
		WebElement Timesheets = driver.findElement(By.xpath("//a[@href=\"https://stage.hellohero.com/timesheets\"]"));
		Timesheets.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement FinalReview = driver.findElement(By.xpath("//a[@href=\"#nav-finalreview\"]"));
		FinalReview.click();
		Thread.sleep(4000);
				
		WebElement date = driver.findElement(By.xpath("(//span[@class=\"checkmark-radio\"])[3]"));
		date.click();
		
		Thread.sleep(2000);

		WebElement startDate = driver.findElement(By.xpath("//input[@name=\"search_start_date\"]"));
		startDate.click();
		
		WebElement endDate = driver.findElement(By.xpath("//input[@name=\"search_end_date\"]"));
		endDate.click();
		
		Thread.sleep(2000);
		WebElement Search = driver.findElement(By.xpath("(//button[text()='Search'])[1]"));
		Search.click();
		Thread.sleep(4000);
		Search.click();
		JavascriptExecutor executor7 = (JavascriptExecutor)driver;
		executor7.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://stage.hellohero.com/users");
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		
		driver.switchTo().window(handles.get(1));
		
		
		WebElement userSearch = driver.findElement(By.xpath("//a[@href=\"https://stage.hellohero.com/users\"]"));
		userSearch.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement EnterName = driver.findElement(By.xpath("//input[@id=\"userSearchNameInput\"]"));
		EnterName.sendKeys("Bhivate001 Therapist");
	
		WebElement SearchButton = driver.findElement(By.xpath("//button[@id=\"btnFiterSubmitSearch\"]"));
		SearchButton.click();
		Thread.sleep(4000);
		
		WebElement viewProfile = driver.findElement(By.xpath("//a[text()='View Profile']"));
		viewProfile.click();
		Thread.sleep(4000);
		
		WebElement Attributes = driver.findElement(By.xpath("//span[text()='Attributes']"));
		Attributes.click();
		Thread.sleep(4000);
		
		WebElement PayType = driver.findElement(By.xpath("//select[@id=\"pay_type\"]"));
		Select type = new Select(PayType);
		type.selectByVisibleText("w2 Hourly");
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		
		driver.switchTo().window(handles.get(0));
	
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		Thread.sleep(3000);
		
		Search.click();
		Thread.sleep(2000);
		exe.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(3000);
		exe.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		
		Thread.sleep(2000);
		WebElement RMreview = driver.findElement(By.xpath("//a[@href=\"#nav-rmreview\"]"));
		
		RMreview.click();
		Thread.sleep(2000);
		FinalReview.click();
		Search.click();
		exe.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(3000);
		exe.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		Thread.sleep(3000);
		RMreview.click();
		Search.click();
		Thread.sleep(2000);
		JavascriptExecutor ex1= (JavascriptExecutor)driver;
		ex1.executeScript("scroll(0,450)");
		
	}

}
