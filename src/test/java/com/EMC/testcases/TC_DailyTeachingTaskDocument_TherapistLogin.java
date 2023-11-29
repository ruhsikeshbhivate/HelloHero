package com.EMC.testcases;

import java.time.Duration;

import org.bouncycastle.jcajce.provider.asymmetric.Dilithium;
import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.DailyTeachingTaskDocument;
import com.EMC.PageObject.DigitalHearingScreeningReport;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.TherapistDashboardPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_DailyTeachingTaskDocument_TherapistLogin extends BaseClass{

	@Test
	public void submitDailyTeachingTaskDocument() throws InterruptedException
	{
		driver.manage().window().maximize();
		loginPage login = new loginPage(driver);
		login.enterUsername("jason2893");
		login.enterPassword("RUshikesh@123");
		login.clickOnLoginButton();

		TherapistDashboardPage dashpage = new TherapistDashboardPage(driver);
		dashpage.clickOnMeeting();
		EventListPage eventPage = new EventListPage(driver);
		
		eventPage.selectOrganization("Rushi_TestOrganization");

		eventPage.selectScheduleSubTypes("Eligibility Meeting");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		eventPage.selectParticipant("Dawson Ragle");
		eventPage.clickOnAddParticipant();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickONStartEventDate2();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		
		eventPage.enterSessionLength("2");
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//eventPage.clickOnSubmitEmailPopup();
		
		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnDailyTeachinfEventInfo();
		calendar.clickOnStartButton();

		StartEventPage startPage = new StartEventPage(driver);
		startPage.clickOnDocumentInternalLink();
		
		DailyTeachingTaskDocument dailyTeachingTaskDocument = new DailyTeachingTaskDocument(driver);
		dailyTeachingTaskDocument.clickOnIepMeeting();
		dailyTeachingTaskDocument.clickOnClassrromMaterialPrep();
		dailyTeachingTaskDocument.enterOtherInformation("TEST");
		dailyTeachingTaskDocument.enterSignature();
		dailyTeachingTaskDocument.clickOnSubmitDocument();
		startPage.clickOnChangeDoucment();
		startPage.clickOnExternalDocumentLinks();
		startPage.clickOnEdit();
		dailyTeachingTaskDocument.clickOnDocumentationForSchool();
		dailyTeachingTaskDocument.clickOnLessionPlanning();
		dailyTeachingTaskDocument.enterSignature();
		dailyTeachingTaskDocument.clickOnsubmitDocumentFromExternalLink();
		
		dashpage.clickOnProfileName();
		dashpage.clickOnSignOut();
		
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();
		
		dashboardPage DashBoardPage = new dashboardPage(driver);
		DashBoardPage.clickOnScheduling();
		DashBoardPage.clickOnEvents();
		
		eventPage.searchOrganization("Rushi_TestOrganization");

		eventPage.searchTherapist("Jason Henry");
		
		eventPage.clickOnSearchStartDate();
		

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
