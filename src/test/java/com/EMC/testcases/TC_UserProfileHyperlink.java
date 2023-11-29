package com.EMC.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_UserProfileHyperlink extends BaseClass{

	@Test
	public void userProfileHyperlink() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();
		
		dashboardPage dashpage = new dashboardPage(driver);
		dashpage.clickOnScheduling();
		dashpage.clickOnEvents();
		
		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Rushi_TestOrganization");
		
		eventPage.selectscheduleTypes("Assessment");
		eventPage.selectScheduleSubTypes("Eligibility Assessment");
		eventPage.selectSpecialty("Physical Therapist (PT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		eventPage.selectParticipant("Pawan TestUser");
		eventPage.clickOnAddParticipant();
		eventPage.selectOwner("Pawan Therapist");
		eventPage.clickOnAddOwnerButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		
		eventPage.enterSessionLength("2");
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//schedulePage.checkNotifyToStudent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		eventPage.clickOnSubmit1();
		
		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo();
		calendar.clickOnStartButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		StartEventPage startEventPage = new StartEventPage(driver);
		startEventPage.clickOnViewProfile();
				
	}
}
