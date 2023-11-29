package com.EMC.testcases;

import java.util.Locale;

import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.CaseNotDocument;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.ReferralPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.TherapistDashboardPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_CreateUser_CreateReferrralFromNewTherapyServices extends BaseClass {

	Faker faker = new Faker(new Locale("en-US"));

	@Test
	public void createUser_CreateReferralFromNewTheraoyServices() throws InterruptedException
	{
		driver.manage().window().maximize();

		// Login By Administrator....
		
		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();
		
		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		
		// Create User.....
		
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnAddUser();
		driver.findElement(UsersPage.userFirstName).sendKeys(faker.name().firstName());
		driver.findElement(UsersPage.userLastName).sendKeys(faker.name().lastName());
		usersPage.selectOrganization("Rushi_TestOrganization");
		usersPage.selectRole("Client");
		driver.findElement(UsersPage.username).sendKeys(faker.name().username());
		usersPage.enterCellPhone("7262957778");
		usersPage.enterUserPassword("RUshikesh@123");
		usersPage.enterConfirmPassword("RUshikesh@123");
		usersPage.clickOnCreateProfile();
		
		usersPage.SearchOranization("Rushi_TestOrganization");
		usersPage.clickOnSearch();
		
		//Create referral from new therapy service
		
		usersPage.newTherapyServices();
		ReferralPage referralPage = new ReferralPage(driver);
		referralPage.clickOnWithoutOutreach();
		referralPage.selectServiceRequested("Occupational Therapist (OT)");
		referralPage.selectScheduleType("Session");
		referralPage.selectScheduleSubType("General");
		referralPage.SessionLength1("10");
		referralPage.serviceStartDate();
		referralPage.serviceEndDate();
		referralPage.intervalInfo("Daily");
		referralPage.NoOfTimes("1");
		referralPage.clickOnAddService();
		referralPage.clickOnAddService();
		referralPage.clickOnSubmit();
		usersPage.clickOnViewProfile();
		usersPage.copyUserFirstName();
		usersPage.openReferralPage();
		
		referralPage.searchOrganization("Rushi_TestOrganization");
		referralPage.searchReferral();
		referralPage.dataTableFilter();
		usersPage.copyUserLastName();
		referralPage.dataTableFilter1();
		
		// Assign Therapist to the referral.....
		
		referralPage.clickOnAssign();
		referralPage.assignTherapist("Ward Lind");
		referralPage.UpdateTherapistToReferral();
		
		//SignOut....
		
		dashPage.clickONprofile();
		dashPage.clickOnSignOut();

		// Login by Therapist....
		
		login.enterUsername("sona.bahringer");
		login.enterPassword("RUshikesh@123");
		login.clickOnLoginButton();
		dashPage.clickOnUsers();
		dashPage.clickOnReferral();
		
		referralPage.searchReferral();
		referralPage.dataTableFilter1();

		// Create schedule from referral.....
		
		referralPage.clickOnAddSchedule();
		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnBuildSchedule();
		eventPage.clickOnEventButton();
		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();

		eventPage.enterSessionLength("2");
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmitEvent();
		
		TherapistDashboardPage DashPage = new TherapistDashboardPage(driver);
		DashPage.dashboard();
		DashPage.joinNow();
		//CalendarPage calendar = new CalendarPage(driver);
		//calendar.clickOnEventInfo();
		//calendar.clickOnStartButton();

		// Submit document.......
		
		StartEventPage startPage = new StartEventPage(driver);
		startPage.clickOnDocumentInternalLink();
		CaseNotDocument caseNotDocument = new CaseNotDocument(driver);
		caseNotDocument.clickOnIndividual();
		caseNotDocument.enterAdditionalInformation("Test");
		caseNotDocument.enterSignature();
		caseNotDocument.clickOnSubmitDocuement();
		caseNotDocument.clickOnNotRightNow();
		
		// Archive event....
		
		dashPage.clickOnScheduling();
		dashPage.clickOnEvents();

		eventPage.searchOrganization("Rushi_TestOrganization");
		eventPage.clickOnSearchStartDate();
		eventPage.searchScheduleType("Session");
		eventPage.clickOnSearchEvent();
		
		eventPage.clickONArchiveEventCheckobox();
		eventPage.selectScheduleAction("Archive Selected");
		eventPage.clickOnSubmitAction();
		eventPage.enterArchiveReason("Test");
		eventPage.clickOnSubmitArchiveSchedule();
		
	}
}
