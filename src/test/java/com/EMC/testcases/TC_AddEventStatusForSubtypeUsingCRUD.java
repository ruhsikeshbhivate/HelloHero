package com.EMC.testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.ManageEventStatuses;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_AddEventStatusForSubtypeUsingCRUD extends BaseClass{


	@Test
	public void addStatusForSubtypeUsingCRUD() throws InterruptedException
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
		//eventPage.clickOnSubmit1();

		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo();
		calendar.clickOnStartButton();
		
		StartEventPage startPage = new StartEventPage(driver);
		startPage.clickOnSelectStatus();
		driver.navigate().refresh();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://stage.hellohero.com/manage_event_statuses");
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		driver.switchTo().window(handles.get(1));
		driver.manage().window().maximize();
		
		ManageEventStatuses manageStatus = new ManageEventStatuses(driver);
		manageStatus.clickOnAddEventStatuses();
		manageStatus.selectScheduleType("Assessment");
		manageStatus.selectScheduleSubType("Eligibility Assessment");
		manageStatus.selectEventStatuses("Completed Asynchronously");
		manageStatus.clickOnsubmit();
		
		driver.switchTo().window(handles.get(0));
		driver.navigate().refresh();
		startPage.SelectEventStatus("Completed Asynchronously");
		startPage.enterSessionLength("3");
		startPage.SelectEventStatus("Completed Asynchronously");
		startPage.clickOnYesPlease();
		
		
	}

}
