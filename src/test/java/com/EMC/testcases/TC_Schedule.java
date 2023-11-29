package com.EMC.testcases;

import java.time.Duration;

import org.openqa.selenium.By;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.THOPage;

public class TC_Schedule extends BaseClass{

	
	public void createSchedule() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String THOName = driver.findElement(By.xpath("//p[@class=\"hellohero-group-card-title\"]")).getText();
		THOPage thoPage = new THOPage(driver);
		thoPage.createSchedule();
		
		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnBuildSchedule();

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("Make Up");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		
		eventPage.selectTHO(THOName);
		eventPage.selectOwner("Malcum Marshal");
		eventPage.clickOnAddOwnerButton();
		eventPage.clickOnEventButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//eventPage.chooseDate();

		//eventPage.eventDate();
		eventPage.clickOnEventStartDate();
		//eventPage.eventEndDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		eventPage.enterSessionLength("2");
		String sessionLength = eventPage.sessionLength.getAttribute("value");
		System.out.println();

		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmitEvent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("........Event Created Successfully.........");
		System.out.println("----------------------------------------------------------------------");

		CalendarPage calendar = new CalendarPage(driver);
		
		calendar.clickOnEventInfo();

		calendar.clickOnStartButton();
	}
}
