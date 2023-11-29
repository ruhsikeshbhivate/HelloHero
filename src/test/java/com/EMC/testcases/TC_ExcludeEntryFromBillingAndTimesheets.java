package com.EMC.testcases;

import java.time.Duration;
import java.util.Locale;
import com.EMC.PageObject.BillingPage;
import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.Schedule_SubtypesPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.TimesheetsPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.EMC.testcases.BaseClass;
import com.github.javafaker.Faker;

public class TC_ExcludeEntryFromBillingAndTimesheets extends BaseClass{

	Faker faker = new Faker(new Locale("en-US"));
	@Test
	public void excludeEventEntryFromBilling() throws InterruptedException
	{
		driver.manage().window().maximize();

		// Login By Administrator....

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();

		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
		Schedule_SubtypesPage schedule_SubtypesPage = new Schedule_SubtypesPage(driver);
		schedule_SubtypesPage.openSchedule_SubtypesPage();
		schedule_SubtypesPage.searchSchedule_Subtypes("Make Up");
		schedule_SubtypesPage.update();
		schedule_SubtypesPage.excludeFromBillingCheckbox();
		schedule_SubtypesPage.submit();
		
		schedule_SubtypesPage.tab1();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();

		// Create User.....

		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnAddUser();

		WebElement FirstName=driver.findElement(By.xpath("//input[@name=\"first_name\"]"));
		FirstName.sendKeys(faker.name().firstName());
		String StudentFirstName = FirstName.getAttribute("value");

		WebElement LastName=driver.findElement(By.xpath("//input[@name=\"last_name\"]"));
		LastName.sendKeys(faker.name().lastName());
		
		String StudentLastName = LastName.getAttribute("value");
		String StudentFullName = StudentFirstName + " " + StudentLastName;
		System.out.println("Student Full Name: " + StudentFullName);	
		System.out.println("------------------------------------------------------------");

		usersPage.selectOrganization("Acceleration_orgTest");
		usersPage.selectRole("Client");
		driver.findElement(UsersPage.username).sendKeys(faker.name().username());
		usersPage.enterCellPhone("7262957778");
		usersPage.enterUserPassword("RUshikesh@123");
		usersPage.enterConfirmPassword("RUshikesh@123");
		usersPage.clickOnCreateProfile();

		usersPage.SearchOranization("Acceleration_orgTest");
		usersPage.clickOnSearch();
		Thread.sleep(1000);
		WebElement UserId =driver.findElement(By.xpath("//table[@id=\"data-table\"]//tr[1]//td[1]"));
		String USERID = UserId.getText();

		usersPage.Schedule();
		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnBuildSchedule();

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("Make Up");
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
		System.out.println("........Event Created Successfully.........");

		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo();

		calendar.clickOnStartButton();
		StartEventPage startEventPage = new StartEventPage(driver);

		startEventPage.clickOnYes();
		startEventPage.selectStatus("Student attended the session");
		startEventPage.clickOnStatusSubmit();
		startEventPage.clickOnYesPlease1();

		dashPage.timesheets();
		TimesheetsPage timesheetsPage = new TimesheetsPage(driver);
		timesheetsPage.selectOrganization("Acceleration_orgTest");
		timesheetsPage.clickOnSearch();

		System.out.println("------------------------------------------------------------");
		System.out.println("Exclude from Timesheets checkbox is unchecked...");	
		System.out.println("Exclude from Billing checkbox is checked...");		
		WebElement FirstRow =driver.findElement(By.xpath("//table[@id=\"Review_table\"]//tbody//tr[1]//td[4]"));
		String ClientName = FirstRow.getText();
		System.out.println("TimeSheets - Client Name: " + ClientName);		

		if (ClientName.contentEquals(StudentFullName) == true )  {

			System.out.println("Exclude From Timesheets - No");
			System.out.println("Event entry is reflected in timesheets.");

		}

		else {
			System.out.println("Exclude From Timesheets - Yes");
			System.out.println("Event entry is not reflected in timesheets.");		}

		System.out.println("------------------------------------------------------------");
		
		BillingPage billingPage = new BillingPage(driver);
		billingPage.clickOnBilling();
		billingPage.selectBillingCategory("Direct Pay");
		billingPage.clickOnOrganizationDrop("Acceleration_orgTest");
		WebElement SearchUserId =driver.findElement(By.xpath("//input[@id=\"billing_userid\"]"));
		SearchUserId.sendKeys(USERID);
		Thread.sleep(2000);
		billingPage.search3();

		String str = "No data available in table";

		WebElement Value3 = driver.findElement(By.xpath("//table[@id=\"review_table\"]//tbody//td[text()=\"No data available in table\"]"));
		String TableValue = Value3.getAttribute("innerText");
		System.out.println("Search User in Billing : " + TableValue);

		if (TableValue.contentEquals(str)==true) {

			System.out.println("Exclude from Billing - Yes.....");
			System.out.println("Event is not Reflected in Billing.");

		}
		else {
			System.out.println("Exclude from Billing - No....");
			System.out.println("Event is Reflected in Billing.");

		}
		System.out.println("===============================================================================");
		schedule_SubtypesPage.tab2();
	}

	@Test
	public void excludeEventEntryFromTimesheets() throws InterruptedException
	{
		
		dashboardPage dashPage = new dashboardPage(driver);
		
		Schedule_SubtypesPage schedule_SubtypesPage = new Schedule_SubtypesPage(driver);
		schedule_SubtypesPage.searchSchedule_Subtypes("Make Up");
		schedule_SubtypesPage.update();
		schedule_SubtypesPage.excludeFromBillingCheckbox();
		schedule_SubtypesPage.excludeFromTimesheetsCheckbox();
		schedule_SubtypesPage.submit();
				
		schedule_SubtypesPage.tab1();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();

		// Create User.....

		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnAddUser();

		WebElement FirstName=driver.findElement(By.xpath("//input[@name=\"first_name\"]"));
		FirstName.sendKeys(faker.name().firstName());
		String StudentFirstName = FirstName.getAttribute("value");

		WebElement LastName=driver.findElement(By.xpath("//input[@name=\"last_name\"]"));
		LastName.sendKeys(faker.name().lastName());
		String StudentLastName = LastName.getAttribute("value");
		String StudentFullName = StudentFirstName + " " + StudentLastName;
		System.out.println("Student Full Name: " + StudentFullName);	
		System.out.println("------------------------------------------------------------");

		usersPage.selectOrganization("Acceleration_orgTest");
		usersPage.selectRole("Client");
		driver.findElement(UsersPage.username).sendKeys(faker.name().username());
		usersPage.enterCellPhone("7262957778");
		usersPage.enterUserPassword("RUshikesh@123");
		usersPage.enterConfirmPassword("RUshikesh@123");
		usersPage.clickOnCreateProfile();

		usersPage.SearchOranization("Acceleration_orgTest");
		usersPage.clickOnSearch();
		Thread.sleep(1000);
		WebElement UserId =driver.findElement(By.xpath("//table[@id=\"data-table\"]//tr[1]//td[1]"));
		String USERID = UserId.getText();

		usersPage.Schedule();
		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnBuildSchedule();

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("Make Up");
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
		eventPage.clickOnSubmitEvent1();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("........Event Created Successfully.........");

		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo();

		calendar.clickOnStartButton();
		StartEventPage startEventPage = new StartEventPage(driver);

		startEventPage.clickOnYes();
		startEventPage.selectStatus("Student attended the session");
		startEventPage.clickOnStatusSubmit();
		startEventPage.clickOnYesPlease1();

		dashPage.timesheets();
		TimesheetsPage timesheetsPage = new TimesheetsPage(driver);
		timesheetsPage.selectOrganization("Acceleration_orgTest");
		timesheetsPage.clickOnSearch();

		System.out.println("------------------------------------------------------------");
		System.out.println("Exclude from Timesheets checkbox is checked...");	
		System.out.println("Exclude from Billing checkbox is unchecked...");
		
		WebElement FirstRow =driver.findElement(By.xpath("//table[@id=\"Review_table\"]//tbody//tr[1]//td[4]"));
		String ClientName = FirstRow.getText();
		System.out.println("TimeSheets - Client Name: " + ClientName);		

		if (ClientName.contentEquals(StudentFullName) == true )  {

			System.out.println("Exclude From Timesheets - No");
			System.out.println("Event entry is reflected in timesheets.");

		}

		else {
			System.out.println("Exclude From Timesheets - Yes");
			System.out.println("Event entry is not reflected in timesheets.");		}

		System.out.println("------------------------------------------------");
		
		BillingPage billingPage = new BillingPage(driver);
		billingPage.clickOnBilling();
		billingPage.selectBillingCategory("Direct Pay");
		billingPage.clickOnOrganizationDrop("Acceleration_orgTest");
		WebElement SearchUserId =driver.findElement(By.xpath("//input[@id=\"billing_userid\"]"));
		SearchUserId.sendKeys(USERID);
		Thread.sleep(2000);
		billingPage.search2();
		WebElement FirstRow1 =driver.findElement(By.xpath("//table[@id=\"review_table\"]//tbody//tr[1]//td[3]"));
		String ClientName1 = FirstRow1.getText();
		System.out.println("Billing - Client Name: " + ClientName1);	
		
		if (ClientName1.contentEquals(StudentFullName)==true) {

			System.out.println("Exclude from Billing - No.....");
			System.out.println("Event is Reflected in Billing.");

		}
		else {
			System.out.println("Exclude from Billing - Yes....");
			System.out.println("Event is not Reflected in Billing.");

		}
		System.out.println("------------------------------------------------------------");
		
		schedule_SubtypesPage.tab2();
		schedule_SubtypesPage.searchSchedule_Subtypes("Make Up");
		schedule_SubtypesPage.update();
		schedule_SubtypesPage.excludeFromTimesheetsCheckbox();
		schedule_SubtypesPage.submit();
		
		
	}

	
}
