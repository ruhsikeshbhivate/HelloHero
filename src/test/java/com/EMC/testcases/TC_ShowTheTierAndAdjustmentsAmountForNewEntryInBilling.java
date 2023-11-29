package com.EMC.testcases;

import java.time.Duration;
import java.util.Locale;

import org.testng.annotations.Test;

import com.EMC.PageObject.BillingPage;
import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.OrganizationPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.TimesheetsPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_ShowTheTierAndAdjustmentsAmountForNewEntryInBilling extends BaseClass{

	Faker faker = new Faker(new Locale("en-US"));

	@Test
	public void showTheTierAndAdjustmentsAmountForNewEntryInBilling() throws InterruptedException
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
		usersPage.selectOrganization("Acceleration_orgTest");
		usersPage.selectRole("Client");
		driver.findElement(UsersPage.username).sendKeys(faker.name().username());
		usersPage.enterCellPhone("7262957778");
		usersPage.enterUserPassword("RUshikesh@123");
		usersPage.enterConfirmPassword("RUshikesh@123");
		usersPage.clickOnCreateProfile();

		usersPage.SearchOranization("Acceleration_orgTest");
		usersPage.clickOnSearch();
		usersPage.Schedule();
		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnBuildSchedule();

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("General");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		
		eventPage.selectOwner("Malcum Marshal");
		eventPage.clickOnAddOwnerButton();
		eventPage.clickOnEventButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();

		eventPage.enterSessionLength("2");
		
		
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmitEvent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//schedulePage.checkNotifyToStudent();
		//eventPage.clickOnSubmit1();

		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo();

		calendar.clickOnStartButton();
		StartEventPage startEventPage = new StartEventPage(driver);
		//startEventPage.clickOnSchoolLoggingCheckbox();

		startEventPage.clickOnYes();
		startEventPage.selectStatus("Student attended the session");
		startEventPage.clickOnStatusSubmit();
		startEventPage.clickOnYesPlease1();

		BillingPage billingPage = new BillingPage(driver);
		billingPage.clickOnBilling();
		billingPage.selectBillingCategory("Direct Pay");
		billingPage.clickOnOrganizationDrop("Acceleration_orgTest");
		billingPage.search();
		billingPage.adjustments();
		dashPage.timesheets();
		TimesheetsPage timesheetsPage = new TimesheetsPage(driver);
		timesheetsPage.selectOrganization("Acceleration_orgTest");
		timesheetsPage.searchTherapy("Occupational Therapist (OT)");
		timesheetsPage.clickOnSearchEvent();
		
		dashPage.clickOnOrganization();

		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.selectOrganization1("Acceleration_orgTest");
		orgPage.clickOnUpdate();

		orgPage.selectTier("Tier 5");
		orgPage.SubmitButton();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();

		usersPage.SearchOranization("Acceleration_orgTest");
		usersPage.clickOnSearch();
		usersPage.Schedule();
		eventPage.clickOnBuildSchedule();
		

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("General");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");

		eventPage.selectOwner("Malcum Marshal");
		eventPage.clickOnAddOwnerButton();
		eventPage.clickOnEventButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();

		eventPage.enterSessionLength("2");
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmitEvent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//schedulePage.checkNotifyToStudent();
		//eventPage.clickOnSubmit1();

		calendar.clickOnEventInfo();
		calendar.clickOnStartButton();
		//startEventPage.clickOnSchoolLoggingCheckbox();

		startEventPage.clickOnYes();
		startEventPage.selectStatus("Student attended the session");
		startEventPage.clickOnStatusSubmit();
		startEventPage.clickOnYesPlease1();

		billingPage.clickOnBilling();
		billingPage.selectBillingCategory("Direct Pay");
		billingPage.clickOnOrganizationDrop("Acceleration_orgTest");
		billingPage.search();
		billingPage.adjustments();
		dashPage.timesheets();
		timesheetsPage.selectOrganization("Acceleration_orgTest");
		timesheetsPage.searchTherapy("Occupational Therapist (OT)");
		timesheetsPage.clickOnSearchEvent();

		dashPage.clickOnOrganization();
		orgPage.selectOrganization1("Acceleration_orgTest");
		orgPage.clickOnUpdate();
		orgPage.selectTier("Tier 2");
		orgPage.SubmitButton();
	}
}
