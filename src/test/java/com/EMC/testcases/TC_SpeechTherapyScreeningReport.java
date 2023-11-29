package com.EMC.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.SpeechTherapyScreeningReport;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_SpeechTherapyScreeningReport extends BaseClass{

	@Test
	public void submitSpeechTherapyScreeningReport() throws InterruptedException
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
		eventPage.selectScheduleSubTypes("Speech Therapy Screening");
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
		eventPage.clickOnSubmit1();
		
		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnSpeechTherapyEventInfo();;
		calendar.clickOnStartButton();

		StartEventPage startPage = new StartEventPage(driver);
		startPage.clickOnDocumentInternalLink();
		
		SpeechTherapyScreeningReport speechTherapyScreeningReport = new SpeechTherapyScreeningReport(driver);
		speechTherapyScreeningReport.enterReasonForScreening("To identify communication strengths");
		speechTherapyScreeningReport.enterTeacherComments("Clear & Concise");
		speechTherapyScreeningReport.selectToolsUsed();
		speechTherapyScreeningReport.enterArticulation("Test");
		speechTherapyScreeningReport.enterFluency("Test");
		speechTherapyScreeningReport.enterExpressiveLanguage("Test");
		speechTherapyScreeningReport.enterReceptiveLanguage("Test");
		speechTherapyScreeningReport.clickOnCriteriaCheckbox();
		speechTherapyScreeningReport.enterSignature();
		speechTherapyScreeningReport.clickOnSubmitDocument();
		startPage.clickOnChangeDoucment();
		startPage.clickOnExternalDocumentLinks();
		startPage.clickOnEdit();
		
		speechTherapyScreeningReport.enterSignature();
		speechTherapyScreeningReport.clickOnSumbitDocumentFormExternalLink();
		startPage.clickOnDocumentDownload();
				
	}
}
