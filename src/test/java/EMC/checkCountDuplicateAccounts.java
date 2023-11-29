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
import org.openqa.selenium.support.ui.Select;

public class checkCountDuplicateAccounts {

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
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://stage.hellohero.com/users");
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
				
		driver.switchTo().window(handles.get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement addUser = driver.findElement(By.xpath("//a[@href=\"https://stage.hellohero.com/users/create\"]"));
		addUser.click();
		WebElement firstName = driver.findElement(By.xpath("//input[@name=\"first_name\"]"));
		firstName.sendKeys("Sagar");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@name=\"last_name\"]"));
		lastName.sendKeys("Client");

		WebElement SelectOrganization = driver.findElement(By.xpath("//select[@id=\"orgInput\"]"));
		Select org = new Select(SelectOrganization);
		org.selectByVisibleText("Rushi_TestOrganization");
		
		WebElement SelectRole = driver.findElement(By.xpath("//select[@id=\"roleId\"]"));
		Select Role = new Select(SelectRole);
		Role.selectByVisibleText("Client");

		WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		username.sendKeys("henry1042");

		WebElement CellPhone = driver.findElement(By.xpath("//input[@name=\"mobile_phone\"]"));
		CellPhone.sendKeys("9087654321");

		JavascriptExecutor execute = (JavascriptExecutor)driver;
		execute.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		password.sendKeys("Henry@123");
		
		WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@name=\"confirm-password\"]"));
		ConfirmPassword.sendKeys("Henry@123");
		
		WebElement createProfile = driver.findElement(By.xpath("//button[@id=\"create_profile\"]"));
		createProfile.click();
		
		WebElement YesCreatePopup = driver.findElement(By.xpath("//button[text()='Yes, create this user']"));
		YesCreatePopup.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().refresh();

	    addUser.click();
	    driver.navigate().refresh();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		firstName.sendKeys("Sagar");
		
		lastName.sendKeys("Client");

		org.selectByVisibleText("Rushi_TestOrganization");
		
		Role.selectByVisibleText("Client");

		username.sendKeys("henry1041");

		CellPhone.sendKeys("9087654321");

		execute.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		password.sendKeys("Henry@123");
		
		ConfirmPassword.sendKeys("Henry@123");
		
		createProfile.click();
		YesCreatePopup.click();
		Thread.sleep(2000);
		
		driver.switchTo().window(handles.get(0));
		driver.navigate().refresh();
	}

}
