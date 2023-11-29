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

public class createEvent {

	public static void main(String[] args) throws InterruptedException {
		
		
			   WebDriver driver = new ChromeDriver();
		        driver.get("https://stage.hellohero.com/login");
		        driver.manage().window().maximize();
		        WebElement Username = driver.findElement(By.xpath("//input[@id=\"login\"]"));
		        Username.sendKeys("Shraddha_admin");
		        WebElement Password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		        Password.sendKeys("HelloHero@123");
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
		        org.selectByValue("112");
		        Thread.sleep(5000);
		        WebElement ScheduleType= driver.findElement(By.xpath("//select[@name=\"schedule_type_id\"]"));
		        Select scheduletype = new Select(ScheduleType);
		        scheduletype.selectByVisibleText("Assessment");
		        Thread.sleep(4000);
		        WebElement ScheduleSubType = driver.findElement(By.xpath("//select[@name=\"schedule_subtype_id\"]"));
		        Select schedulesubtype = new Select(ScheduleSubType);
		        schedulesubtype.selectByVisibleText("Standard Assessment");
		        WebElement SelectSpecialty = driver.findElement(By.xpath("//select[@name=\"specialty_id\"]"));
		        Select selectSpecialty = new Select(SelectSpecialty);
		        selectSpecialty.selectByVisibleText("Physical Therapist (PT)");
		        WebElement VideoPlatform= driver.findElement(By.xpath("//select[@name=\"video_platform\"]"));
		        Select videoPlatform = new Select(VideoPlatform);
		        videoPlatform.selectByVisibleText("HelloHERO Video");
		        Thread.sleep(4000);
		        WebElement Participant = driver.findElement(By.xpath("//select[@name=\"participants\"]"));
		        Select participant = new Select(Participant);
		        participant.selectByVisibleText("shraddha002 T");
		        Thread.sleep(2000);
		        WebElement AddParticipantButton= driver.findElement(By.xpath("//button[@id=\"add_participant\"]"));
		        AddParticipantButton.click();
		        Thread.sleep(10000);
		        WebElement Owner = driver.findElement(By.xpath("//select[@id=\"ownerId\"]"));
		        Select owner = new Select(Owner);
		        owner.selectByVisibleText("shraddhatherapist003 T");
		        Thread.sleep(4000);
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
		        GeneralScheduleNotes.sendKeys("test123");
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		        WebElement SubmitButton = driver.findElement(By.xpath("//button[@id=\"create_event_btn\"]"));
		        JavascriptExecutor executor2 = ((JavascriptExecutor) driver);
		        Thread.sleep(4000);
		        executor2.executeScript("arguments[0].scrollIntoView(true);", SubmitButton);
		        SubmitButton.click();
		     /* WebElement conflictElement =driver.findElement(By.xpath("//input[@id=\"is_force1create_event\"]"));
		      conflictElement.click();
		      WebElement savElement=driver.findElement(By.xpath("(//button[@type=\"submit\"])[5]"));
		      savElement.click();*/
		        Thread.sleep(10000);
		        WebElement eventElement = driver.findElement(By.xpath("//a[@class=\"fc-day-grid-event fc-h-event fc-event fc-start fc-end\"]"));
		        JavascriptExecutor java1= (JavascriptExecutor)driver;
		        java1.executeScript("arguments[0].scrollIntoView();",eventElement);
		        Thread.sleep(4000);
		        driver.switchTo().newWindow(WindowType.TAB);
					
				driver.get("https://stage.hellohero.com/event");
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> handles = new ArrayList<String>();
				handles.addAll(windowHandles);
				driver.switchTo().window(handles.get(1));
				driver.navigate().refresh();
				Thread.sleep(4000);
				WebElement calendarschedulElement=driver.findElement(By.xpath("//button[@id=\"create_event\"]"));
				//calendarschedulElement.click();
				JavascriptExecutor s1= (JavascriptExecutor)driver;
				s1.executeScript("arguments[0].click()",calendarschedulElement);
				WebElement schedulElement = driver.findElement(By.xpath("//a[text()='Build a schedule']"));
				schedulElement.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		        WebElement AddOrganization1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name=\"organization_id\"]")));
		        Select org1 = new Select(AddOrganization1);
		        org1.selectByValue("112");
		        Thread.sleep(5000);
		        WebElement ScheduleType1= driver.findElement(By.xpath("//select[@name=\"schedule_type_id\"]"));
		        Select scheduletype1 = new Select(ScheduleType1);
		        scheduletype1.selectByVisibleText("Assessment");
		        Thread.sleep(4000);
		        WebElement ScheduleSubType1 = driver.findElement(By.xpath("//select[@name=\"schedule_subtype_id\"]"));
		        Select schedulesubtype1 = new Select(ScheduleSubType1);
		        schedulesubtype1.selectByVisibleText("Standard Assessment");
		        WebElement SelectSpecialty1 = driver.findElement(By.xpath("//select[@name=\"specialty_id\"]"));
		        Select selectSpecialty2 = new Select(SelectSpecialty1);
		        selectSpecialty2.selectByVisibleText("Physical Therapist (PT)");
		        WebElement VideoPlatform1= driver.findElement(By.xpath("//select[@name=\"video_platform\"]"));
		        Select videoPlatform2 = new Select(VideoPlatform1);
		        videoPlatform2.selectByVisibleText("HelloHERO Video");
		        Thread.sleep(4000);
		        WebElement Participant1 = driver.findElement(By.xpath("//select[@name=\"participants\"]"));
		        Select participant2 = new Select(Participant1);
		        participant2.selectByVisibleText("shraddha002 T");
		        Thread.sleep(2000);
		        WebElement AddParticipantButton1= driver.findElement(By.xpath("//button[@id=\"add_participant\"]"));
		        AddParticipantButton1.click();
		        Thread.sleep(10000);
		        WebElement Owner1 = driver.findElement(By.xpath("//select[@id=\"ownerId\"]"));
		        Select owner2 = new Select(Owner1);
		        owner2.selectByVisibleText("shraddhatherapist003 T");
		        Thread.sleep(4000);
		        WebElement AddOwnerButton1 = driver.findElement(By.xpath("//button[@id=\"add_owner\"]"));
		        AddOwnerButton1.click();
		        Thread.sleep(4000);
		        WebElement event = driver.findElement(By.xpath("//input[@data-id=\"event\"]"));
				//event.click();
				JavascriptExecutor ex4= (JavascriptExecutor)driver;
				ex4.executeScript("arguments[0].click()",event);
				
		        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		        WebElement submitButton1 = driver.findElement(By.xpath("//button[@id=\"create_event_btn\"]"));
		        executor1.executeScript("arguments[0].scrollIntoView();",submitButton1);
		        Thread.sleep(2000);
		        WebElement StartEventDate1= driver.findElement(By.xpath("//input[@name=\"event_start_date\"]"));
		        StartEventDate1.click();
		        Thread.sleep(2000);
		        WebElement StartEventTime1= driver.findElement(By.xpath("//input[@name=\"event_start_time\"]"));
		        StartEventTime1.click();
		        Thread.sleep(2000);
		        WebElement IncreaseStartTime1= driver.findElement(By.xpath("(//span[@class=\"glyphicon glyphicon-chevron-up\"])[1]"));
		        IncreaseStartTime1.click();
		        WebElement SessionLength1 = driver.findElement(By.xpath("//input[@name=\"schedule_session_length\"]"));
		        SessionLength1.sendKeys("2");
		        Thread.sleep(2000);
		        WebElement GeneralScheduleNotes1 = driver.findElement(By.xpath("//textarea[@id=\"event_description\"]"));
		        GeneralScheduleNotes1.sendKeys("test123");
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		        WebElement SubmitButton1 = driver.findElement(By.xpath("//button[@id=\"create_event_btn\"]"));
		        JavascriptExecutor executor21 = ((JavascriptExecutor) driver);
		        Thread.sleep(4000);
		        executor21.executeScript("arguments[0].scrollIntoView(true);", SubmitButton1);
		        SubmitButton1.click();
				
		}
	}
	
