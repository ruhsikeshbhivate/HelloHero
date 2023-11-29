package EMC;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.EMC.testcases.BaseClass;
import com.github.javafaker.Faker;


public class createdoctor extends BaseClass {

	Faker faker = new Faker(new Locale("en-IND"));
	@Test(invocationCount = 1)
	public void creatDoctor() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("http://hospital-management-system.s3-website-us-east-1.amazonaws.com/logIn");
		WebElement Username = driver.findElement(By.xpath("//input[@name=\"email\"]"));
		Username.sendKeys("rushi.bhivate@anveshak.com");

		WebElement Password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		Password.sendKeys("12345");

		WebElement LoginButton = driver.findElement(By.xpath("//button[text()=\"Login\"]"));
		LoginButton.click();
		
		WebElement gotoDashboard = driver.findElement(By.xpath("//button[text()=\"Go to dashboard\"]"));
		gotoDashboard.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement dashboard = driver.findElement(By.xpath("//span[text()=\"Dashboard\"]"));
		dashboard.click();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement Users = driver.findElement(By.xpath("//span[text()=\"Users\"]"));
		executor.executeScript("arguments[0].click();", Users);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement Doctor = driver.findElement(By.xpath("//span[text()=\"Doctor\"]"));
		executor.executeScript("arguments[0].click();", Doctor);
	
		WebElement AddDoctor = driver.findElement(By.xpath("//button[text()=\"Add Doctor\"]"));
		executor.executeScript("arguments[0].click();", AddDoctor);
		Thread.sleep(1000);
		
		WebElement FirstName=driver.findElement(By.xpath("//input[@name=\"fName\"]"));
		FirstName.sendKeys(faker.name().firstName());
	
		WebElement LastName=driver.findElement(By.xpath("//input[@name=\"lName\"]"));
		LastName.sendKeys(faker.name().lastName());
		
		WebElement MobileNumber=driver.findElement(By.xpath("//input[@name=\"mobileNo\"]"));
		MobileNumber.sendKeys(faker.phoneNumber().phoneNumber());
		String number = MobileNumber.getAttribute("value");
		System.out.println(number);
		
		WebElement submit = driver.findElement(By.xpath("//button[text()=\"Submit\"]"));
		executor.executeScript("arguments[0].scrollIntoView();", submit);
		Thread.sleep(1000);
		
		WebElement Education = driver.findElement(By.xpath("//input[@name=\"education\"]"));
		Education.sendKeys("BAMS");
		
		WebElement certificateNumber = driver.findElement(By.xpath("//input[@name=\"registrationNo\"]"));
		certificateNumber.sendKeys(faker.phoneNumber().cellPhone());
		
		Thread.sleep(1000);
		WebElement Speciality = driver.findElement(By.xpath("//*[@id=\"mui-component-select-speciality\"]"));
		Speciality.click();
		Thread.sleep(1000);
			
		WebElement Speciality1 = driver.findElement(By.xpath("(//li[@role=\"option\"])[1]"));
		executor.executeScript("arguments[0].click();", Speciality1);
		Thread.sleep(1000);
		
		WebElement PASSWORD = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		PASSWORD.sendKeys("12345");
		
		WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@name=\"confirmPassword\"]"));
		ConfirmPassword.sendKeys("12345");
		
		executor.executeScript("arguments[0].click();", submit);
		
		WebElement Ok = driver.findElement(By.xpath("//button[text()=\"Ok\"]"));
		executor.executeScript("arguments[0].click();", Ok);
		
		WebElement logout = driver.findElement(By.xpath("(//div[@role=\"button\"])[5]"));
		executor.executeScript("arguments[0].click();", logout);

	}
}
