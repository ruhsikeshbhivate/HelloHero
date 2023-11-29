package com.EMC.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;

import com.EMC.PageObject.ScheduleListPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_CreateEventFromCalendarPage extends BaseClass{

	@Test
	public void createEventFromCalendarPage() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();
		
		dashboardPage dashpage = new dashboardPage(driver);
		dashpage.clickOnScheduling();
		dashpage.clickOnCalendar();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		CalendarPage calendarPage = new CalendarPage(driver);
		calendarPage.clickOnCreateEventButton();
		
		ScheduleListPage schedulePage = new ScheduleListPage(driver);
		
		schedulePage.clickOnBuildSchedule();
		schedulePage.selectOrganization("Rushi_TestOrganization");
		
		schedulePage.selectscheduleTypes("Assessment");
		schedulePage.selectScheduleSubTypes("Eligibility Assessment");
		schedulePage.selectSpecialty("Physical Therapist (PT)");
		schedulePage.selectVideoPlatform("HelloHERO Video");
		schedulePage.selectParticipant("Pawan TestUser");
		schedulePage.clickOnAddParticipant();
		schedulePage.selectOwner("Pawan Therapist");
		schedulePage.clickOnAddOwnerButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		schedulePage.clickOnDays();
		schedulePage.clickOnEventStartDate();
		schedulePage.clickOnEventStartTime();
		schedulePage.clickOnIncreaseStartTime();
		
		schedulePage.enterSessionLength("2");
		schedulePage.enterGeneralNotes("This event is created by automation");
		schedulePage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//schedulePage.checkNotifyToStudent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		schedulePage.clickOnSubmit1();
		
		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo();
		
		
	}
}
