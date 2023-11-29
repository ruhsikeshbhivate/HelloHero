package com.EMC.testcases;

import java.time.Duration;
import java.util.Locale;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.MissingPayoutMapping;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.TimesheetsPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_VerifyPayoutMappingAmountInTimesheets extends BaseClass {

	Faker faker = new Faker(new Locale("en-US"));
	
	@Test(enabled = false)
	public void verifyPayoutMappingAmountForFlatRate_Timesheets() throws InterruptedException
	{
		driver.manage().window().maximize();

		// Login By Administrator....

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();

		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
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

		WebElement FirstRow =driver.findElement(By.xpath("//table[@id=\"Review_table\"]//tbody//tr[1]//td[4]"));
		String ClientName = FirstRow.getText();
		System.out.println("TimeSheets - Client Name: " + ClientName);		

		System.out.println("------------------------------------------------------------");

		if (ClientName.contentEquals(StudentFullName) == true )  {

			System.out.println("Created event is being reflected correctly.....");
		}

		else {
			System.out.println("Created event is not being reflected correctly.....");
		}

		System.out.println("------------------------------------------------------------");

		timesheetsPage.missing_Payout_Mapping();
		MissingPayoutMapping missingPayoutMapping = new MissingPayoutMapping(driver);
		missingPayoutMapping.selectRate("Flat Rate");
				
		WebElement Amount = driver.findElement(By.xpath("//input[@id=\"amount\"]"));
		Amount.sendKeys("40");
		Thread.sleep(2000);

		String PayerAmount = "$" + Amount.getAttribute("value");
		System.out.println("Payout Mapping Amount : " + PayerAmount);
		System.out.println("------------------------------------------------------------");
		
		missingPayoutMapping.AddPayout();
		missingPayoutMapping.SearchPayout("General");
		missingPayoutMapping.refreshTimeSheetsPage();

		timesheetsPage.selectOrganization("Acceleration_orgTest");
		timesheetsPage.clickOnSearch();
		
		WebElement Timesheets_Amount =driver.findElement(By.xpath("//table[@id=\"Review_table\"]//tbody//tr[1]//td[18]"));
		String TimeSheets_Amount = Timesheets_Amount.getText();

		System.out.println("Timesheets Original Amount : " + TimeSheets_Amount);		
		System.out.println("------------------------------------------------------------");

		if (TimeSheets_Amount.contentEquals(PayerAmount) == true )  {

			System.out.println("Payout Mapping amount is being calculated correctly......");
		}

		else {
			System.out.println("Payout Mapping amount is not being calculated correctly.....");
		}

		System.out.println("------------------------------------------------------------");
		
		missingPayoutMapping.refreshPayoutPage();
		missingPayoutMapping.SearchPayout("General");
		missingPayoutMapping.deletePayout();
		missingPayoutMapping.SearchPayout("General");
 
		System.out.println("...........Payout Mapping Deleted Successfully..........");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void verifyPayoutMappingAmountForByMinute_Timesheets() throws InterruptedException
	{
		driver.manage().window().maximize();

		// Login By Administrator....

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();

		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
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

		WebElement FirstRow =driver.findElement(By.xpath("//table[@id=\"Review_table\"]//tbody//tr[1]//td[4]"));
		String ClientName = FirstRow.getText();
		System.out.println("TimeSheets - Client Name: " + ClientName);
		System.out.println("------------------------------------------------------------");

		WebElement Minutes =driver.findElement(By.xpath("//table[@id=\"Review_table\"]//tbody//tr[1]//td[15]"));
		String Completion_Minutes = Minutes.getText();
		int A=Integer.parseInt(Completion_Minutes);  
		System.out.println("Session Length : " + A);

		System.out.println("------------------------------------------------------------");

		if (ClientName.contentEquals(StudentFullName) == true )  {

			System.out.println("Created event is being reflected correctly.....");
		}

		else {
			System.out.println("Created event is not being reflected correctly.....");
		}

		System.out.println("------------------------------------------------------------");

		timesheetsPage.missing_Payout_Mapping();
		MissingPayoutMapping missingPayoutMapping = new MissingPayoutMapping(driver);
		missingPayoutMapping.selectRate("By Minute");
			
		missingPayoutMapping.selectMinute("1");
		WebElement Amount = driver.findElement(By.xpath("//input[@id=\"amount\"]"));
		Amount.sendKeys("40");
		Thread.sleep(2000);

		String PayerAmount = Amount.getAttribute("value");
		int B=Integer.parseInt(PayerAmount);  

		System.out.println("Payout Mapping Amount : " + B);

		System.out.println("------------------------------------------------------------");
		
		missingPayoutMapping.AddPayout();
		missingPayoutMapping.SearchPayout("General");
		WebElement Minutes1 =driver.findElement(By.xpath("//table[@id=\"payoutTable\"]//tr[1]//td[8]"));
		String SELECTEDMinutes = Minutes1.getText();
		int C=Integer.parseInt(SELECTEDMinutes);  
		System.out.println("Selected Minutes : " + C);
		System.out.println("------------------------------------------------------------");
		
		int D = B/C * A;
		String Total_Amount= "$" + Integer.toString(D);
		System.out.println("Total Amount= Payer Amount/Selected Minutes * Session Length  : " + Total_Amount);
		System.out.println("------------------------------------------------------------");

		missingPayoutMapping.refreshTimeSheetsPage();
		timesheetsPage.selectOrganization("Acceleration_orgTest");
		timesheetsPage.clickOnSearch();
		
		WebElement Timesheets_Amount =driver.findElement(By.xpath("//table[@id=\"Review_table\"]//tbody//tr[1]//td[18]"));
		String TimeSheets_OriginalAmount = Timesheets_Amount.getText();

		System.out.println("Timesheets Original Amount : " + TimeSheets_OriginalAmount);		
		System.out.println("------------------------------------------------------------");

		if (TimeSheets_OriginalAmount.contentEquals(Total_Amount) == true )  {

			System.out.println("Payout Mapping amount is being calculated correctly......");
		}

		else {
			System.out.println("Payout Mapping amount is not being calculated correctly.....");
		}

		System.out.println("------------------------------------------------------------");
		
		missingPayoutMapping.refreshPayoutPage();
		missingPayoutMapping.SearchPayout("General");
		missingPayoutMapping.deletePayout();
		missingPayoutMapping.SearchPayout("General");

		System.out.println("...........Payout Mapping Deleted Successfully..........");
		System.out.println("------------------------------------------------------------");
	}
}
