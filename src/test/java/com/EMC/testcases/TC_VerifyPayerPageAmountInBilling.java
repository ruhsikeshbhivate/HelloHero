package com.EMC.testcases;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.EMC.PageObject.BillingPage;
import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_VerifyPayerPageAmountInBilling extends BaseClass{

	Faker faker = new Faker(new Locale("en-US"));
	@Test(enabled=false)
	public void verifyPayerPageAmountInBilling_FlatRate() throws InterruptedException
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

		BillingPage billingPage = new BillingPage(driver);
		billingPage.clickOnBilling();
		billingPage.selectBillingCategory("Direct Pay");
		billingPage.clickOnOrganizationDrop("Acceleration_orgTest");
		WebElement SearchUserId =driver.findElement(By.xpath("//input[@id=\"billing_userid\"]"));
		SearchUserId.sendKeys(USERID);
		Thread.sleep(2000);
		billingPage.search2();

		System.out.println("------------------------------------------------------------");

		WebElement FirstRow =driver.findElement(By.xpath("//table[@id=\"review_table\"]//tbody//tr[1]//td[3]"));
		String ClientName = FirstRow.getText();
		System.out.println("Billing - Client Name: " + ClientName);		

		System.out.println("------------------------------------------------------------");

		if (ClientName.contentEquals(StudentFullName) == true )  {

			System.out.println("Created event is being reflected correctly.....");
		}

		else {
			System.out.println("Created event is not being reflected correctly.....");
		}

		System.out.println("------------------------------------------------------------");

		billingPage.missing_Payer_Page();
		billingPage.paymentType("Direct Pay");
		billingPage.selectRate("Flat Rate");
		WebElement Amount = driver.findElement(By.xpath("//input[@id=\"amount\"]"));
		Amount.sendKeys("30");
		Thread.sleep(2000);

		String PayerAmount = "$" + Amount.getAttribute("value");
		System.out.println("Payer Page Amount : " + PayerAmount);
		System.out.println("------------------------------------------------------------");

		billingPage.addPayerPage();
		billingPage.selectBillingCategory("Direct Pay");
		billingPage.clickOnOrganizationDrop("Acceleration_orgTest");
		WebElement SearchUserId1 =driver.findElement(By.xpath("//input[@id=\"billing_userid\"]"));
		SearchUserId1.sendKeys(USERID);
		Thread.sleep(1000);
		billingPage.search2();
		Thread.sleep(3000);

		WebElement BillingAmount =driver.findElement(By.xpath("//table[@id=\"review_table\"]//tbody//tr[1]//td[14]"));
		String original_Amount = BillingAmount.getText();

		System.out.println("Billing Original Amount : " + original_Amount);		
		System.out.println("------------------------------------------------------------");

		if (original_Amount.contentEquals(PayerAmount) == true )  {

			System.out.println("Payer page amount is being calculated correctly......");
		}

		else {
			System.out.println("Payer page amount is not being calculated correctly.....");
		}

		System.out.println("------------------------------------------------------------");

		billingPage.search_Type("Session");
		billingPage.search_SubType("General");
		billingPage.search_Therapy("Occupational Therapist (OT)");
		billingPage.search_Status("Completed Successfully");
		billingPage.filterPayerPage();
		billingPage.deletePayerPage();
		System.out.println("...........Payer Page Deleted Successfully..........");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void verifyPayerPageAmountInBilling_ByMinute() throws InterruptedException
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
		eventPage.enterSessionLength("3");

		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmitEvent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("------------------------------------------------------------");
		System.out.println("........Event Created Successfully.........");

		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo();

		calendar.clickOnStartButton();
		StartEventPage startEventPage = new StartEventPage(driver);

		startEventPage.clickOnYes();
		startEventPage.selectStatus("Student attended the session");
		startEventPage.clickOnStatusSubmit();
		startEventPage.clickOnYesPlease1();

		BillingPage billingPage = new BillingPage(driver);
		billingPage.clickOnBilling();
		billingPage.selectBillingCategory("Direct Pay");
		billingPage.clickOnOrganizationDrop("Acceleration_orgTest");
		WebElement SearchUserId =driver.findElement(By.xpath("//input[@id=\"billing_userid\"]"));
		SearchUserId.sendKeys(USERID);
		Thread.sleep(2000);
		billingPage.search2();

		System.out.println("------------------------------------------------------------");

		WebElement FirstRow =driver.findElement(By.xpath("//table[@id=\"review_table\"]//tbody//tr[1]//td[3]"));
		String ClientName = FirstRow.getText();
		System.out.println("Billing - Client Name: " + ClientName);		
		System.out.println("------------------------------------------------------------");
		
		WebElement Minutes =driver.findElement(By.xpath("//table[@id=\"review_table\"]//tbody//tr[1]//td[12]"));
		String Completion_Minutes = Minutes.getText();
		int A=Integer.parseInt(Completion_Minutes);  
		System.out.println("Completion Minutes : " + A);

		System.out.println("------------------------------------------------------------");

		if (ClientName.contentEquals(StudentFullName) == true )  {

			System.out.println("Created event is being reflected correctly.....");
		}

		else {
			System.out.println("Created event is not being reflected correctly.....");
		}

		System.out.println("------------------------------------------------------------");

		billingPage.missing_Payer_Page();
		billingPage.paymentType("Direct Pay");
		billingPage.selectRate("By Minute");
		billingPage.selectMinutes("1");
		WebElement Amount = driver.findElement(By.xpath("//input[@id=\"amount\"]"));
		Amount.sendKeys("30");
		Thread.sleep(2000);

		String PayerAmount = Amount.getAttribute("value");
		int B=Integer.parseInt(PayerAmount);  

		System.out.println("Payer Page Amount For Per Minute : " + B);
		System.out.println("------------------------------------------------------------");

		billingPage.addPayerPage();
		billingPage.selectBillingCategory("Direct Pay");
		billingPage.clickOnOrganizationDrop("Acceleration_orgTest");
		WebElement SearchUserId1 =driver.findElement(By.xpath("//input[@id=\"billing_userid\"]"));
		SearchUserId1.sendKeys(USERID);
		Thread.sleep(2000);
		billingPage.search2();
		Thread.sleep(3000);

		int C = A*B;
		String Total_Amount= "$" + Integer.toString(C);
		System.out.println("Total Amount= Session Length * Payer Page Amount : " + Total_Amount);
		System.out.println("------------------------------------------------------------");

		WebElement BillingAmount =driver.findElement(By.xpath("//table[@id=\"review_table\"]//tbody//tr[1]//td[14]"));
		String original_Amount = BillingAmount.getText();

		System.out.println("Billing Original Amount : " + original_Amount);		
		System.out.println("------------------------------------------------------------");

		if (original_Amount.contentEquals(Total_Amount) == true )  {

			System.out.println("Payer page amount is being calculated correctly......");
		}

		else {
			System.out.println("Payer page amount is not being calculated correctly.....");
		}

		System.out.println("------------------------------------------------------------");

		billingPage.search_Type("Session");
		billingPage.search_SubType("General");
		billingPage.search_Therapy("Occupational Therapist (OT)");
		billingPage.search_Status("Completed Successfully");
		billingPage.filterPayerPage();
		billingPage.deletePayerPage();
		System.out.println("...........Payer Page Deleted Successfully..........");
		System.out.println("------------------------------------------------------------");


	}
}
