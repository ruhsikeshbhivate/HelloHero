package EMC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlockSpeechEdgeDriver {
	
	WebDriver driver = null;
	
	@Parameters("BrowserName")
	@BeforeTest
	public void setup(String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Eclipse Workspace\\MyJavaProject\\OTS Portal\\EMC1\\Drivers\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "C:\\Eclipse Workspace\\MyJavaProject\\OTS Portal\\EMC1\\Drivers\\Firefoxdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if(BrowserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Eclipse Workspace\\MyJavaProject\\OTS Portal\\EMC1\\Drivers\\EdgeDriver\\msedgedriver.exe");
			
			WebDriverManager manager = WebDriverManager.edgedriver();
			manager.config().setEdgeDriverVersion("113.0.1774.42");
			manager.setup();
			EdgeOptions options = new EdgeOptions();
			driver = new EdgeDriver(options);
		}

	}

	@Test
	public void blockSpeech() throws InterruptedException{

		driver.manage().window().maximize();
		
		driver.get("https://stage.hellohero.com/login");

		WebElement Username = driver.findElement(By.xpath("//input[@id=\"login\"]"));
		Username.sendKeys("sagar_admin");

		WebElement Password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		Password.sendKeys("Sagar@Admin3343");

		WebElement LoginButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
		LoginButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement Schedulling = driver.findElement(By.xpath("//span[text()='Scheduling']"));
		Schedulling.click();
		Thread.sleep(3000);
		

		WebElement Events = driver.findElement(By.xpath("(//a[@href=\"https://stage.hellohero.com/event-list\"])[1]"));
		Events.click();
		Thread.sleep(3000);

		WebElement AddEventButton = driver.findElement(By.xpath("//button[text()='+ Add Event']"));
		AddEventButton.click();

		WebElement BuildSchedule = driver.findElement(By.xpath("//a[text()='Build a schedule']"));
		BuildSchedule.click();

		Thread.sleep(2000);
		WebElement AddOrganization = driver.findElement(By.xpath("//select[@name=\"organization_id\"]"));
		Select org = new Select(AddOrganization);
		org.selectByValue("343");

		Thread.sleep(3000);
		WebElement ScheduleType= driver.findElement(By.xpath("//select[@name=\"schedule_type_id\"]"));
		Select scheduletype = new Select(ScheduleType);
		scheduletype.selectByVisibleText("Meeting");

		Thread.sleep(3000);
		WebElement ScheduleSubType = driver.findElement(By.xpath("//select[@name=\"schedule_subtype_id\"]"));
		Select schedulesubtype = new Select(ScheduleSubType);
		schedulesubtype.selectByVisibleText("Block Speech");

		WebElement SelectSpecialty = driver.findElement(By.xpath("//select[@name=\"specialty_id\"]"));
		Select selectSpecialty = new Select(SelectSpecialty);
		selectSpecialty.selectByVisibleText("Speech Therapy");

		WebElement VideoPlatform= driver.findElement(By.xpath("//select[@name=\"video_platform\"]"));
		Select videoPlatform = new Select(VideoPlatform);
		videoPlatform.selectByVisibleText("HelloHERO Video");

		WebElement Owner = driver.findElement(By.xpath("//select[@id=\"ownerId\"]"));
		Select owner = new Select(Owner);
		owner.selectByVisibleText("Therapist 123T");
		Thread.sleep(2000);

		WebElement AddOwnerButton = driver.findElement(By.xpath("//button[@id=\"add_owner\"]"));
		AddOwnerButton.click();

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
		SessionLength.sendKeys("1");
		Thread.sleep(2000);

		WebElement GeneralScheduleNotes = driver.findElement(By.xpath("//textarea[@id=\"event_description\"]"));
		GeneralScheduleNotes.sendKeys("This Event created by automation script");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement SubmitButton = driver.findElement(By.xpath("//button[@id=\"create_event_btn\"]"));
		JavascriptExecutor executor2 = ((JavascriptExecutor) driver);
		executor2.executeScript("arguments[0].scrollIntoView(true);", SubmitButton);
		SubmitButton.click();

		Thread.sleep(5000);
		WebElement eventInfo = driver.findElement(By.xpath("//span[text()='Block Speech with Therapist 123T']"));
		JavascriptExecutor executor3 = ((JavascriptExecutor) driver);
		executor3.executeScript("arguments[0].scrollIntoView(true);", eventInfo);
		eventInfo.click();

		Thread.sleep(2000);
		WebElement startButton = driver.findElement(By.xpath("//a[text()='Start']"));
		startButton.click();

		Thread.sleep(5000);
		WebElement SelectStatus1 =driver.findElement(By.xpath("(//select[@name=\"event_status_id[]\"])[1]"));
		Select status1 = new Select(SelectStatus1);
		status1.selectByVisibleText("Present");

		WebElement YesPleasePopup = driver.findElement(By.xpath("//button[text()='Yes, please!']"));
		YesPleasePopup.click();
		Thread.sleep(2000);
		WebElement SelectStatus2 =driver.findElement(By.xpath("(//select[@name=\"event_status_id[]\"])[2]"));
		Select status2 = new Select(SelectStatus2);
		status2.selectByVisibleText("Present");

		Thread.sleep(2000);
		WebElement SelectStatus3 =driver.findElement(By.xpath("(//select[@name=\"event_status_id[]\"])[3]"));
		JavascriptExecutor executor4 = ((JavascriptExecutor) driver);
		executor4.executeScript("arguments[0].scrollIntoView(true);", SelectStatus3);
		Select status3 = new Select(SelectStatus3);
		status3.selectByVisibleText("Absent");

		JavascriptExecutor executor7 = (JavascriptExecutor)driver;
		executor7.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(2000);
		WebElement SelectStatus4 =driver.findElement(By.xpath("(//select[@name=\"event_status_id[]\"])[4]"));
		Select status4 = new Select(SelectStatus4);
		status4.selectByVisibleText("Absent");

		Thread.sleep(2000);
		WebElement SelectStatus5 =driver.findElement(By.xpath("(//select[@name=\"event_status_id[]\"])[5]"));
		Select status5 = new Select(SelectStatus5);
		status5.selectByVisibleText("Not Scheduled");

		Thread.sleep(2000);
		WebElement SelectStatus6 =driver.findElement(By.xpath("(//select[@name=\"event_status_id[]\"])[6]"));
		Select status6 = new Select(SelectStatus6);
		status6.selectByVisibleText("Present");

	}
}
