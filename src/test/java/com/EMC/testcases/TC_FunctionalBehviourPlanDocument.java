package com.EMC.testcases;

import java.time.Duration;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.TherapistDashboardPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_FunctionalBehviourPlanDocument extends BaseClass {

	public void submitFuctionalBehaviourDocument_TherapistLogin() throws InterruptedException
	{

		driver.manage().window().maximize();
		loginPage login = new loginPage(driver);
		login.enterUsername("will1234");
		login.enterPassword("RUshikesh@123");
		login.clickOnLoginButton();
		
		dashboardPage dashpage = new dashboardPage(driver);
		dashpage.clickOnScheduling();
		dashpage.clickOnEvents();

		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Rushi_TestOrganization");

		eventPage.selectscheduleTypes("Assessment");
		eventPage.selectScheduleSubTypes("Functional Behavior Assessment (FBA)");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		eventPage.selectParticipant("Drake Wisler");
		eventPage.clickOnAddParticipant();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickONStartEventDate2();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		
		eventPage.enterSessionLength("2");
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		eventPage.clickOnSubmitEmailPopup();
		
		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnDailyTeachinfEventInfo();
		calendar.clickOnStartButton();

		StartEventPage startPage = new StartEventPage(driver);
		startPage.clickOnDocumentInternalLink();
	}
}
