package EMC;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.EMC.PageObject.LandingPage;
import com.github.javafaker.Faker;

public class checkCountOutreachNotSetUp {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://stage.hellohero.com/login");

		driver.manage().window().maximize();

		WebElement Username = driver.findElement(By.xpath("//input[@id=\"login\"]"));
		Username.sendKeys("sagar_admin");

		WebElement Password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		Password.sendKeys("SagarAdmin@123");

		WebElement LoginButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
		LoginButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://stage.hellohero.com/");
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
				
		driver.switchTo().window(handles.get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		WebElement OutreachNotSetUp = driver.findElement(By.xpath("//a[@title=\"Outreach With Not set up\"]"));
		OutreachNotSetUp.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement AddReferral= driver.findElement(By.xpath("//a[@id=\"referralModal\"]"));
		AddReferral.click();
		
		WebElement SelectOrganization = driver.findElement(By.xpath("//select[@id=\"referralSearchOrgSelect2\"]"));
		Select org = new Select(SelectOrganization);
		org.selectByVisibleText("Rushi_TestOrganization");
		
		WebElement selectStudent = driver.findElement(By.xpath("//select[@id=\"search_user_id\"]"));
		Select student = new Select(selectStudent);
		student.selectByVisibleText("Jason Client");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement next = driver.findElement(By.xpath("//button[@id=\"goToNext\"]"));
		next.click();
		
		WebElement selectService = driver.findElement(By.xpath("//select[@id=\"service_requested\"]"));
		Select service = new Select(selectService);
		service.selectByVisibleText("Occupational Therapist (OT)");
		
		WebElement ScheduleType = driver.findElement(By.xpath("//select[@id=\"schedule_type\"]"));
		Select schedultype= new Select(ScheduleType);
		schedultype.selectByVisibleText("Meeting");
	
		WebElement ScheduleSubType = driver.findElement(By.xpath("//select[@id=\"schedule_subtype\"]"));
		Select subType= new Select(ScheduleSubType);
		subType.selectByVisibleText("IEP Meeting");
		
		WebElement addService = driver.findElement(By.xpath("//button[@id=\"btn_service_add\"]"));
		addService.click();
		Thread.sleep(3000);
		WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"nextBtn\"]/button"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", submitButton);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		submitButton.click();
		Thread.sleep(3000);
		driver.switchTo().window(handles.get(0));
		driver.navigate().refresh();
	}

}
