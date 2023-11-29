package com.EMC.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.OrganizationPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.TimesheetsPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_SchoolLogging extends BaseClass{
	
	@Test
	public void schoolLogging() throws InterruptedException
	{
		
		driver.manage().window().maximize();
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();
		
		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnOrganization();
		
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.selectOrganization1("Acceleration_orgTest");
		orgPage.clickOnUpdate();
		
		orgPage.clickOnLoggingRequiredCheckBox();
		orgPage.clickOnSubmitButton();
		
		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Acceleration_orgTest");
		
		eventPage.selectscheduleTypes("Assessment");
		eventPage.selectScheduleSubTypes("Eligibility Evaluation");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		eventPage.selectParticipant("Kyle Jamieson");
		eventPage.clickOnAddParticipant();
		eventPage.selectOwner("Malcum Marshal");
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
		eventPage.clickOnSubmit1();
		
		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo();
		
		calendar.clickOnStartButton();
		StartEventPage startEventPage = new StartEventPage(driver);
		startEventPage.clickOnSchoolLoggingCheckbox();
		
		startEventPage.clickOnYes();
		startEventPage.selectStatus("NO - Evaluation Completed");
		startEventPage.clickOnStatusSubmit();
		startEventPage.enterTimeSpent("20");
		startEventPage.clickOnYes();
		startEventPage.selectStatus1("NO - Evaluation Completed");
		startEventPage.clickOnStatusSubmit();
		startEventPage.clickOnYesPlease();
		
		TimesheetsPage timesheetsPage = new TimesheetsPage(driver);
		timesheetsPage.selectOrganization("Acceleration_orgTest");
		timesheetsPage.clickOnSearch();
		startEventPage.goToStartEventPage();

		startEventPage.clickOnSchoolLoggingCheckbox();
		timesheetsPage.refreshTimesheetPage();	
		timesheetsPage.clickOnSearch();
		
		dashPage.loggingNotCompleted();

		orgPage.refreshDashboardPage();
		
		orgPage.clickOnUpdate();
		orgPage.clickOnLoggingRequiredCheckBox();
		orgPage.clickOnSubmitButton();

		startEventPage.refreshStartEventPage();
	}

}
