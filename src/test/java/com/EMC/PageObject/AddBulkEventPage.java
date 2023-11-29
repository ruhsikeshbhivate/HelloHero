package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import EMC.createEvent;

public class AddBulkEventPage {

	WebDriver driver;

	public  AddBulkEventPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addBulkEventTab()
	{
		driver.get("https://stage.hellohero.com/add-bulk-events");
	}

	@FindBy(xpath = "//select[@id=\"organizations\"]")
	WebElement organization;

	public void selectOrganization(String org) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(organization);
		select.selectByVisibleText(org);
		Thread.sleep(4000);
	}

	@FindBy(xpath = "//select[@id=\"therapist_id\"]")
	WebElement Therapist;

	public void selectTherapist(String therapist)
	{
		Select select = new Select(Therapist);
		select.selectByVisibleText(therapist);
	}

	@FindBy(xpath = "//input[@id=\"event_start_date\"]")
	WebElement DateDue;

	public void dateDue()
	{
		DateDue.click();
	}

	@FindBy(xpath = "//input[@id=\"event_start_time\"]")
	WebElement TimeDue;

	public void timeDue()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		TimeDue.click();
	}

	@FindBy(xpath = "//button[@id=\"get_participants\"]")
	WebElement Next;

	public void next() throws InterruptedException
	{
		Next.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//button[@id=\"bulkeventSave\"]")
	WebElement CreateEvents;

	public void createEvents() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", CreateEvents);
		CreateEvents.click();
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//input[@id=\"cbx_1\"]")
	WebElement UncheckUser;

	public void uncheckUser() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", UncheckUser);
		Thread.sleep(1000);
	}

	
	public void compareAttachedUser()
	{
		System.out.println("------------------------------------------------------------------");
		String Name1 = driver.findElement(By.xpath("//table[@id=\"activeStudentTable\"]//tbody//tr[1]//td[3]")).getText();
		String Name2 = driver.findElement(By.xpath("//table[@id=\"activeStudentTable\"]//tbody//tr[2]//td[3]")).getText();
		String Name3 = driver.findElement(By.xpath("//table[@id=\"activeStudentTable\"]//tbody//tr[3]//td[3]")).getText();

		System.out.println(Name1);
		System.out.println(Name2);
		System.out.println(Name3);

		List<WebElement> ClientName = driver.findElements(By.xpath("//table[@id=\"bulkEventTable\"]//tbody//tr"));
		int NoOfRows = ClientName.size();

		for(int i=1;i<=NoOfRows;i++)
		{

			System.out.print(i+" : ");

			String clientName =driver.findElement(By.xpath("//table[@id=\"bulkEventTable\"]//tbody//tr["+i+"]//td[3]")).getText();
			//System.out.println(clientName);

			if(clientName.contentEquals(Name1) == true || clientName.contentEquals(Name2)==true 
					|| clientName.contentEquals(Name3)==true)
			{
				System.out.println(clientName);
			}

			else {
				System.out.println("Unassigned user is reflected..." + clientName);
			}
		}
	}
	
	
	public void uncheckUser1() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", UncheckUser);
		Thread.sleep(1000);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"bulkEventTable\"]//tbody//tr"));
		int NoofRows = rows.size();
		
		for(int k=1; k<=NoofRows; k++)
		{
			System.out.print(k+" : ");

			WebElement checkbox =driver.findElement(By.xpath("//table[@id=\"bulkEventTable\"]//tbody//tr["+k+"]//input[@type=\"checkbox\"]"));
			String User =driver.findElement(By.xpath("//table[@id=\"bulkEventTable\"]//tbody//tr["+k+"]//td[3]")).getText();

			if(checkbox.isSelected()) {
				
				System.out.println("Checkbox is checked for user : " + User);
			}
			else {
				System.out.println("Checkbox is unchecked for user : " + User);

			}
		}
	}
	public void compareUncheckUserInEventList() throws InterruptedException
	{
		String User =driver.findElement(By.xpath("//table[@id=\"bulkEventTable\"]//tbody//tr[2]//td[3]")).getText();
		System.out.println("The name of the user whose checkbox is unchecked : " + User);
		System.out.println("------------------------------------------------------------------");
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", CreateEvents);
		CreateEvents.click();
		Thread.sleep(2000);
		
		List<WebElement> usersNameInEventList = driver.findElements(By.xpath("//table[@id=\"liveEventsTable\"]//tbody//tr"));
		int NoOfRows1 = usersNameInEventList.size();
		
		for(int i=1;i<=NoOfRows1;i++)
		{
			System.out.print(i+" : ");

			String clientName1 =driver.findElement(By.xpath("//table[@id=\"liveEventsTable\"]//tbody//tr["+i+"]//td[10]")).getText();
			System.out.println("Name of User in event list : " + clientName1 );

			if(clientName1.contentEquals(User) == true )
			{
				System.out.println("Event is created for Uncheck user...");
			}

			else {
				System.out.println("Event is not created for Uncheck user...");
			}
			
			System.out.println();
		}
		
	}
	
	
	public void openAddBulkEventPage() throws InterruptedException
	{
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://stage.hellohero.com/schedule-subtypes");
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		driver.switchTo().window(handles.get(1));
		Thread.sleep(3000);
	}
	public void tab0() throws InterruptedException
	{
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		driver.switchTo().window(handles.get(0));
	}
	
	public void tab1() throws InterruptedException
	{
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		driver.switchTo().window(handles.get(1));
	}
}
