package com.EMC.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.DigitalHearingScreeningReport;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_DigitalHearingScreeningReport extends BaseClass {

	@Test
	public void submitDigitalHearingScreeningReport() throws InterruptedException
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
		eventPage.selectParticipant("Dawson Ragle");
		eventPage.clickOnAddParticipant();
		eventPage.selectOwner("Dane Cleaver");
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
		calendar.clickOnEventInfo();;
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
		
	}
}
