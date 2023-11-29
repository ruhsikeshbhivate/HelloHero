package com.EMC.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.FunctionalBehaviorPlanDocument;
import com.EMC.PageObject.SpeechTherapyScreeningReport;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_ShowFunctionalBehviourPlanDocumentByTherapistLogin extends BaseClass {

	@Test
	public void submitFunctionalPlanDocument() throws InterruptedException
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

		eventPage.selectscheduleTypes("Documentation");
		eventPage.selectScheduleSubTypes("Behavior Plan");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		eventPage.selectParticipant("Drake Wisler");
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
		calendar.clickOnBehaviorPlanDocumentEventInfo();
		calendar.clickOnStartButton();

		StartEventPage startPage = new StartEventPage(driver);
		startPage.clickOnDocumentInternalLink();
		
		FunctionalBehaviorPlanDocument functionalBehaviorPlanDocument = new FunctionalBehaviorPlanDocument(driver);
		functionalBehaviorPlanDocument.enterAgeOfStudent("18");
		functionalBehaviorPlanDocument.enterGrade("A");
		functionalBehaviorPlanDocument.enterfunctionalBehaviorStatement("Reading");
		functionalBehaviorPlanDocument.clICKOnRequestHelp();
		functionalBehaviorPlanDocument.clICKOnrequestAnItem();
		functionalBehaviorPlanDocument.clICKOnGreetOthers();
		functionalBehaviorPlanDocument.clICKOnChoiceMaking();
		functionalBehaviorPlanDocument.enterSummary("Test");
		functionalBehaviorPlanDocument.enterSignature();
		functionalBehaviorPlanDocument.clickOnSubmitDocument();
	
		startPage.clickOnChangeDoucment();
		startPage.clickOnExternalDocumentLinks();
		startPage.clickOnEdit();
				
		functionalBehaviorPlanDocument.enterSignature();
		functionalBehaviorPlanDocument.clickOnSubmitDocumentFromExternalLink();
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
		eventPage.searchScheduleType("Documentation");
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
