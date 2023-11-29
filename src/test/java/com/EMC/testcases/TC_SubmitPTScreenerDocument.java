package com.EMC.testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_SubmitPTScreenerDocument extends BaseClass{

	@Test
	public void submitPTScreenerDocument() throws InterruptedException
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
		eventPage.selectScheduleSubTypes("Physical Therapy Screening");
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
		calendar.clickOnEventInfo1();
		calendar.clickOnStartButton();

		StartEventPage startPage = new StartEventPage(driver);
		startPage.clickOnDocumentInternalLink();
		startPage.enterReasonForScreen("Failed in last screening");
		startPage.enterTeacherComments("Most likely he is trying to build up your "
				+ "damaged self-esteem and boost your confidence that "
				+ "was lost somewhere along the line");
		startPage.clickOnToolsUsed();
		startPage.enterFineMotor("Turning doorknobs, keys, and locks");
		startPage.enterGrossMotor("Walking smoothly, starting to run, and using stairs without support");
		startPage.clickOnRecommendations();
		startPage.clickOnSignature();
		startPage.clickOnSubmitDocument();

		startPage.clickOnChangeDoucment();
		startPage.clickOnExternalDocumentLinks();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		driver.switchTo().window(handles.get(1));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		startPage.clickOnEdit();
		startPage.clickOnSignature();
		startPage.clickSubmitDocument1();
		driver.switchTo().window(handles.get(0));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		startPage.clickOnDocumentDownload();


	}
}
