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

public class checkCountOfTherapistSpecialtyOnDashboard {

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
		
		JavascriptExecutor execute = (JavascriptExecutor)driver;
		execute.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://stage.hellohero.com/");
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
				
		driver.switchTo().window(handles.get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		execute.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		WebElement therapistAvaibility = driver.findElement(By.xpath("//a[@href=\"https://stage.hellohero.com/unfilled-specialty\"]"));
		therapistAvaibility.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement Add = driver.findElement(By.xpath("(//a[text()=\"Add\"])[1]"));
		Add.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement state = driver.findElement(By.xpath("//select[@id=\"specialty_states_dropdown\"]"));
		Select States = new Select(state);
		States.selectByVisibleText("Alabama");
		
		WebElement addButton = driver.findElement(By.xpath("//button[text()='+Add']"));
		addButton.click();
		
		driver.switchTo().window(handles.get(0));
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

}
