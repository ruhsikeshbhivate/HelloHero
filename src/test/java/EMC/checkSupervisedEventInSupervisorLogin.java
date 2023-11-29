package EMC;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkSupervisedEventInSupervisorLogin {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement users = driver.findElement(By.xpath("//span[text()='Users']"));
		users.click();
		
		WebElement userSearch = driver.findElement(By.xpath("//a[@href=\"https://stage.hellohero.com/users\"]"));
		userSearch.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement addUser = driver.findElement(By.xpath("//a[@href=\"https://stage.hellohero.com/users/create\"]"));
		addUser.click();

		WebElement firstName = driver.findElement(By.xpath("//input[@name=\"first_name\"]"));
		firstName.sendKeys("Rohan1238");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@name=\"last_name\"]"));
		lastName.sendKeys("Supervisor");

		WebElement SelectOrganization = driver.findElement(By.xpath("//select[@id=\"orgInput\"]"));
		Select org = new Select(SelectOrganization);
		org.selectByVisibleText("Rushi_TestOrganization");
		
		WebElement SelectRole = driver.findElement(By.xpath("//select[@id=\"roleId\"]"));
		Select Role = new Select(SelectRole);
		Role.selectByVisibleText("Therapist");

		WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		username.sendKeys("Rohan123245602");

		WebElement CellPhone = driver.findElement(By.xpath("//input[@name=\"mobile_phone\"]"));
		CellPhone.sendKeys("9087654321");

		JavascriptExecutor execute = (JavascriptExecutor)driver;
		execute.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		password.sendKeys("Rushi@123");
		
		WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@name=\"confirm-password\"]"));
		ConfirmPassword.sendKeys("Rushi@123");
		
		WebElement createProfile = driver.findElement(By.xpath("//button[@id=\"create_profile\"]"));
		createProfile.click();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://stage.hellohero.com/supervisors");
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		driver.switchTo().window(handles.get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement addSupervisor = driver.findElement(By.xpath("//a[@href=\"https://stage.hellohero.com/supervisors/create\"]"));
		addSupervisor.click();
		
		WebElement selectorganization = driver.findElement(By.xpath("//select[@id=\"organization_id\"]"));
		Select org1 = new Select(selectorganization);
		org1.selectByVisibleText("Rushi_TestOrganization");
		
		WebElement supervisor = driver.findElement(By.xpath("//select[@id=\"supervisor_id\"]"));
		Select Supervisor = new Select(supervisor);
		Supervisor.selectByVisibleText("Rohan1238 Supervisor");
		
		WebElement Therapist = driver.findElement(By.xpath("//select[@id=\"therapist_id\"]"));
		Select therapist = new Select(Therapist);
		therapist.selectByVisibleText("virat Therapist");
		
		WebElement selectClient = driver.findElement(By.xpath("(//input[@class=\"ids\"])[1]"));
		selectClient.click();
		execute.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		WebElement submitButton = driver.findElement(By.xpath("//button[text()=\"Submit\"]"));
		submitButton.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement Schedulling = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Scheduling']")));
		Schedulling.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement Events = driver.findElement(By.xpath("(//a[@href=\"https://stage.hellohero.com/event-list\"])[1]"));
        Events.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement AddEventButton = driver.findElement(By.xpath("//button[text()='+ Add Event']"));
        AddEventButton.click();
        
        WebElement BuildSchedule = driver.findElement(By.xpath("//a[text()='Build a schedule']"));
        BuildSchedule.click();
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement AddOrganization = driver.findElement(By.xpath("//select[@name=\"organization_id\"]"));
        Select org2 = new Select(AddOrganization);
        org2.selectByValue("343");
        Thread.sleep(3000);
		WebElement ScheduleType= driver.findElement(By.xpath("//select[@name=\"schedule_type_id\"]"));
		Select scheduletype = new Select(ScheduleType);
		scheduletype.selectByVisibleText("Assessment");

		Thread.sleep(2000);
		WebElement ScheduleSubType = driver.findElement(By.xpath("//select[@name=\"schedule_subtype_id\"]"));
		Select schedulesubtype = new Select(ScheduleSubType);
		schedulesubtype.selectByVisibleText("Eligibility Assessment");

		WebElement SelectSpecialty = driver.findElement(By.xpath("//select[@name=\"specialty_id\"]"));
		Select selectSpecialty = new Select(SelectSpecialty);
		selectSpecialty.selectByVisibleText("Occupational Therapist (OT)");

		WebElement VideoPlatform= driver.findElement(By.xpath("//select[@name=\"video_platform\"]"));
		Select videoPlatform = new Select(VideoPlatform);
		videoPlatform.selectByVisibleText("HelloHERO Video");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement Participant = driver.findElement(By.xpath("//select[@name=\"participants\"]"));
		Select participant = new Select(Participant);
		participant.selectByVisibleText("Rushikesh Client");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement AddParticipantButton= driver.findElement(By.xpath("//button[@id=\"add_participant\"]"));
		AddParticipantButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement Owner = driver.findElement(By.xpath("//select[@id=\"ownerId\"]"));
		Select owner = new Select(Owner);
		owner.selectByVisibleText("virat Therapist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement AddOwnerButton = driver.findElement(By.xpath("//button[@id=\"add_owner\"]"));
		AddOwnerButton.click();

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement submitButton1 = driver.findElement(By.xpath("//button[@id=\"create_event_btn\"]"));

		executor.executeScript("arguments[0].scrollIntoView();",submitButton1);

		Thread.sleep(2000);
		WebElement StartEventDate= driver.findElement(By.xpath("//input[@name=\"event_start_date\"]"));
		StartEventDate.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement StartEventTime= driver.findElement(By.xpath("//input[@name=\"event_start_time\"]"));
		StartEventTime.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement IncreaseStartTime= driver.findElement(By.xpath("(//span[@class=\"glyphicon glyphicon-chevron-up\"])[1]"));
		IncreaseStartTime.click();

		WebElement SessionLength = driver.findElement(By.xpath("//input[@name=\"schedule_session_length\"]"));
		SessionLength.sendKeys("2");
		
		WebElement GeneralScheduleNotes = driver.findElement(By.xpath("//textarea[@id=\"event_description\"]"));
		GeneralScheduleNotes.sendKeys("This Event created by automation script");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement SubmitButton = driver.findElement(By.xpath("//button[@id=\"create_event_btn\"]"));
		JavascriptExecutor executor2 = ((JavascriptExecutor) driver);
		executor2.executeScript("arguments[0].scrollIntoView(true);", SubmitButton);
		
		WebElement cancel = driver.findElement(By.xpath("//a[@class=\"phpdebugbar-close-btn\"]"));
		cancel.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		SubmitButton.click();
		Thread.sleep(5000);
		SubmitButton.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement eventInfo = driver.findElement(By.xpath("//span[text()='Eligibility Assessment with Rushikesh Client, virat Therapist']"));
		
		execute.executeScript("arguments[0].scrollIntoView(true);", eventInfo);
		eventInfo.click();
		Thread.sleep(2000);
		driver.switchTo().window(handles.get(0));
		WebElement searchUser = driver.findElement(By.xpath("//input[@id=\"userSearchNameInput\"]"));
		searchUser.sendKeys("Rohan1238 Supervisor");
	
		WebElement searchUserButton= driver.findElement(By.xpath("//button[@id=\"btnFiterSubmitSearch\"]"));
		searchUserButton.click();
		Thread.sleep(2000);
		driver.navigate().refresh();

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		execute.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement loginAs = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='login as']")));
		loginAs.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement users1 = driver.findElement(By.xpath("//span[text()='Users']"));
		users1.click();
		
		WebElement userSearch1 = driver.findElement(By.xpath("//a[@href=\"https://stage.hellohero.com/users\"]"));
		userSearch1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement viewProfile = driver.findElement(By.xpath("//a[text()='View Profile']"));
		viewProfile.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement schedules = driver.findElement(By.xpath("(//a[@href=\"#nav-schedules\"])[1]"));
		schedules.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement date= driver.findElement(By.xpath("(//td[text()='30'])[1]"));
		date.click();
	}
	

}
