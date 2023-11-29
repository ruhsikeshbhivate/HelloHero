package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompliancePage {

	WebDriver driver;
	
	public CompliancePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void OpenCompliancePage() throws InterruptedException
	{
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://stage.hellohero.com/compliance");
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		driver.switchTo().window(handles.get(1));
		Thread.sleep(2000);
	}
	
	public void OpenCompliancePage1() throws InterruptedException
	{
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://stage.hellohero.com/compliance");
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		driver.switchTo().window(handles.get(2));
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//span[@id=\"select2-search_student-container\"]")
	WebElement SelectStudent;
	
	@FindBy(xpath = "//input[@role=\"searchbox\"]")
	WebElement studentName;
	
	public void selectStudent(String name) throws InterruptedException
	{		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SelectStudent.click();
		Thread.sleep(1000);
		studentName.sendKeys(name);
		Actions actions = new Actions(driver);
		actions.sendKeys(studentName,Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(8000);
	}
	
	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement Search;
	
	public void search() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Search);
		Thread.sleep(11000);
	}
	
	@FindBy(xpath = "//table[@id=\"compliance_datatable\"]//tbody//tr[1]//td[10]")
	public WebElement Status;
	
	public void getStatus()
	{
		String status = Status.getText();
		System.out.println("Status of THO Event : " + status);
	}
	
	public void getStatus1()
	{
		String status = Status.getText();
		if(status.contentEquals("Unknown"))
		{
			System.out.println("Event status in complinace tab : " + status); 
		}
		else {
			System.out.println("Event status in complinace tab : " + status); 

		}
	}
	public void enterStudentName(String text) throws InterruptedException {	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SelectStudent.click();
		Thread.sleep(1000);
		
		for(int i=0;i<text.length();i++) {
			String a = Character.toString(text.charAt(i));
			studentName.sendKeys(a);			
		}
		Thread.sleep(4000);		
		Actions actions = new Actions(driver);
		actions.sendKeys(studentName, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
}
