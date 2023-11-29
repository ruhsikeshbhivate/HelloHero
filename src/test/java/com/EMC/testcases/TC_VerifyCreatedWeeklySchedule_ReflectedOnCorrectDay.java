package com.EMC.testcases;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_VerifyCreatedWeeklySchedule_ReflectedOnCorrectDay extends BaseClass{

	@Test
	public void VerifyCreatedWeeklySchedule_ReflectedOnCorrectDay() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();

		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
		
		dashPage.clickOnScheduling();
		dashPage.clickOnEvents();

		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Rushi_TestOrganization");

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("General");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		eventPage.selectParticipant("Darren Hall");
		eventPage.clickOnAddParticipant();
		eventPage.selectOwner("Andrew Phillpis");
		eventPage.clickOnAddOwnerButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnScheduleButton();
		WebElement day = driver.findElement(By.xpath("//input[@id=\"chk04\"]"));
		
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", day);
		//day.click();
		String Value = day.getAttribute("value");
		System.out.println(Value);
		
		eventPage.clickOnEventStartDate();
		WebElement EventEndDate = driver.findElement(By.xpath("//input[@id=\"EventEndDate\"]"));
		EventEndDate.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
		WebElement date = driver.findElement(By.xpath("(//td[text()=\"4\"])[12]"));
		date.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		WebElement StartTime = driver.findElement(By.xpath("//input[@id=\"EventStartTime\"]"));
		String eventStartTime = StartTime.getAttribute("value");
		System.out.println("Event Start Time : " + eventStartTime);
		eventPage.enterSessionLength("2");
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit();
		
		//String str = "fc-event-container";
		int NoOfRows = 1;
		int totalColumns = 1;

		for(int i=1;i<=NoOfRows;i++)
			
		{
			System.out.print(i+" : ");

			for(int j=1;j<=totalColumns;j++)
			{
				WebElement Value1 =driver.findElement(By.xpath("(//table//tbody//tr//td[5])[3]"));
				String Row1 = Value1.getAttribute("innerText");
				System.out.println(Row1);		

				WebElement Value2 =driver.findElement(By.xpath("(//table//tbody//tr//td[5])[6]"));
				String Row2 = Value2.getAttribute("innerText");
				System.out.println(Row2);	

				WebElement Value3 =driver.findElement(By.xpath("(//table//tbody//tr//td[5])[9]"));
				String Row3 = Value3.getAttribute("innerText");
				System.out.println(Row3);

				WebElement Value4 =driver.findElement(By.xpath("(//table//tbody//tr//td[5])[12]"));
				String Row4 = Value4.getAttribute("innerText");
				System.out.println(Row4);

				WebElement Value5 =driver.findElement(By.xpath("(//table//tbody//tr//td[5])[15]"));
				String Row5 = Value5.getAttribute("innerText");
				System.out.println(Row5);

				WebElement Value6 =driver.findElement(By.xpath("(//table//tbody//tr//td[5])[18]"));
				String Row6 = Value6.getAttribute("innerText");
				System.out.println(Row6);

				if (Row1.contains(eventStartTime) == true || Row2.contains(eventStartTime)==true || Row3.contains(eventStartTime)==true 
						|| Row4.contains(eventStartTime)==true || Row5.contains(eventStartTime)==true || Row6.contains(eventStartTime)==true)  {

					System.out.println("Result is getting correct.....");
				}

				else {
					System.out.println("Result is getting wrong.....");
				}
			}
		}
	}
}
