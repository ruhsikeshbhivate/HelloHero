package com.EMC.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.DigitalHearingScreeningReport;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_ShowDigitalhearingDocumentByTherapistLogin extends BaseClass{

	@Test
	public void showDigitalHearingDoucmentByTherapistLogin() throws InterruptedException
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
		eventPage.selectScheduleSubTypes("Hearing Screening");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		eventPage.selectParticipant("Dominic Young");
		eventPage.clickOnAddParticipant();
		eventPage.selectOwner("Jason Henry");
		eventPage.clickOnAddOwnerButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();

		eventPage.enterSessionLength("2");
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//eventPage.clickOnSubmit1();

		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnHearingScreeningEventInfo();;
		calendar.clickOnStartButton();

		StartEventPage startPage = new StartEventPage(driver);
		startPage.clickOnDocumentInternalLink();

		DigitalHearingScreeningReport digitalHearingScreeningReport = new DigitalHearingScreeningReport(driver);
		digitalHearingScreeningReport.enterObservations("Test");
		digitalHearingScreeningReport.clickOnRightEarPass();
		digitalHearingScreeningReport.clickOnLeftEarPass();
		digitalHearingScreeningReport.clickOnResults();
		digitalHearingScreeningReport.enterSignature();
		digitalHearingScreeningReport.clickOnSubmitDocument();
		startPage.clickOnChangeDoucment();
		startPage.clickOnExternalDocumentLinks();
		startPage.clickOnEdit();
		digitalHearingScreeningReport.clickOnRightEarFail();
		digitalHearingScreeningReport.enterSignature();
		digitalHearingScreeningReport.clickOnSubmitDocumentFromExternalLink();

		dashpage.clickONprofile();
		dashpage.clickOnSignOut();

		login.enterUsername("jason2893");
		login.enterPassword("RUshikesh@123");
		login.clickOnLoginButton();

		dashboardPage DashBoardPage = new dashboardPage(driver);
		DashBoardPage.clickOnScheduling();
		DashBoardPage.clickOnEvents();

		eventPage.searchOrganization("Rushi_TestOrganization");
		eventPage.clickOnSearchStartDate();
		eventPage.searchScheduleType("Assessment");
		eventPage.clickOnSearchEvent();

		eventPage.clickOnStart();
		startPage.clickOnChangeDoucment();
		startPage.clickOnDocumentInternalLink();
		startPage.clickOnCloseForm();
		startPage.clickOnOk();
		eventPage.clickONArchiveEventCheckobox();
		eventPage.selectScheduleAction("Archive Selected");
		eventPage.clickOnSubmitAction();
		eventPage.enterArchiveReason("Test");
		eventPage.clickOnSubmitArchiveSchedule();
	}
}
