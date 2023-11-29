package com.EMC.testcases;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.CompliancePage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.THOPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_CreateTHOAndCheckCompletion_Future_ExpectedMinutes_InComplianceTab extends BaseClass{
	
	Faker faker  = new Faker(new Locale("en-US"));

	@Test(enabled = false)
	public void CreateTHOAndCheckCompletion_Future_ExpectedMinutes_InComplianceTab() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();

		dashboardPage dashPage = new dashboardPage(driver);

		dashPage.clickOnCloseButton();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
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
		usersPage.clickOnViewProfile();

		THOPage thoPage = new THOPage(driver);
		thoPage.newTHO();
		thoPage.selectOrganization("Acceleration_orgTest");
		thoPage.selectType("IEP");
		thoPage.selectSpecialty("Occupational Therapist (OT)");
		thoPage.thoStartDate();
		thoPage.thoEndDate();
		thoPage.noOfVisits("2");
		
		String Visit = thoPage.NoOfVisit.getAttribute("value");
		int NoOfVisits = Integer.parseInt(Visit);
		System.out.println("NO of Visits : " + NoOfVisits);
		
		thoPage.units("5");
		String units = thoPage.Units.getAttribute("value");
		int UNITS = Integer.parseInt(units);
		System.out.println("Units : " + UNITS);
		
		thoPage.saveTHO();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String THOName = driver.findElement(By.xpath("//p[@class=\"hellohero-group-card-title\"]")).getText();
		System.out.println("----------------------------------------------------------------------");

		dashPage.clickOnScheduling();
		dashPage.clickOnEvents();

		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Acceleration_orgTest");

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("Make Up");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		
		eventPage.selectParticipant(StudentFullName);
		eventPage.clickOnAddParticipant();
		eventPage.selectTHO(THOName);

		eventPage.selectOwner("Malcum Marshal");
		eventPage.clickOnAddOwnerButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		
		eventPage.enterSessionLength("5");
		String eventLength = eventPage.sessionLength.getAttribute("value");
		int SessionLength = Integer.parseInt(eventLength);
		System.out.println("Session length of first Event : " + SessionLength);
		
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("........Event Created Successfully.........");
		System.out.println("----------------------------------------------------------------------");

		CalendarPage calendar = new CalendarPage(driver);
		
		calendar.clickOnEventInfo();

		calendar.clickOnStartButton();
		
		dashPage.clickOnScheduling();
		dashPage.clickOnEvents();

		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Acceleration_orgTest");

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("Make Up");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		
		eventPage.selectParticipant(StudentFullName);
		eventPage.clickOnAddParticipant();
		eventPage.selectTHO(THOName);

		eventPage.selectOwner("Malcum Marshal");
		eventPage.clickOnAddOwnerButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		eventPage.clickOnIncreaseStartTime();

		eventPage.enterSessionLength("3");
		String eventLength1 = eventPage.sessionLength.getAttribute("value");
		int SessionLength1 = Integer.parseInt(eventLength1);
		System.out.println("Session length of second event : " + SessionLength1);
		
		eventPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		calendar.clickOnEventInfo();
		calendar.clickOnStartButton();
		dashPage.clickOnScheduling();
		dashPage.clickOnEvents();

		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Acceleration_orgTest");

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("Make Up");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		
		eventPage.selectParticipant(StudentFullName);
		eventPage.clickOnAddParticipant();
		eventPage.selectTHO(THOName);

		eventPage.selectOwner("Malcum Marshal");
		eventPage.clickOnAddOwnerButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		eventPage.clickOnIncreaseStartTime();
		eventPage.clickOnIncreaseStartTime();

		eventPage.enterSessionLength("2");
		String eventLength2 = eventPage.sessionLength.getAttribute("value");
		int SessionLength2 = Integer.parseInt(eventLength2);
		System.out.println("Session length of completion event : " + SessionLength2);
		
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		calendar.clickOnEventInfo();

		calendar.clickOnStartButton();
		int TotalSessionLength = SessionLength + SessionLength1 + SessionLength2;
		System.out.println("Total Session Length : " + TotalSessionLength);
		
		CompliancePage compliancePage = new CompliancePage(driver);
		compliancePage.OpenCompliancePage();
		
		compliancePage.enterStudentName(StudentFullName);
		compliancePage.search();
		
		int EXPECTED_MINUTES = NoOfVisits*UNITS;
		System.out.println("Expected Minutes = NoOfVisits * Units : " + EXPECTED_MINUTES);
		System.out.println("---------------------------------------------------------------------");

		String futureMinutes = driver.findElement(By.xpath("//table[@id=\"compliance_datatable\"]//tbody//tr[1]//td[8]")).getText();
		int FutureMinutes = Integer.parseInt(futureMinutes);
		System.out.println("Future Minutes in Compliance tab : " + FutureMinutes);
		
		String expectedMinutes = driver.findElement(By.xpath("//table[@id=\"compliance_datatable\"]//tbody//tr[1]//td[9]")).getText();
		int ExpectedMinutes = Integer.parseInt(expectedMinutes);
		System.out.println("Expected minutes in compliance tab : " + ExpectedMinutes);
		
		if (ExpectedMinutes==EXPECTED_MINUTES && FutureMinutes==TotalSessionLength) {
		
			System.out.println("Future minutes is calculated correctly ...");
			System.out.println("Expected minutes is calculated correctly");
		} else {

			System.out.println("Future minutes is not calculated correctly ...");
			System.out.println("Expected minutes is not calculated correctly");
		}
		System.out.println("---------------------------------------------------------------------");

		compliancePage.getStatus();
		System.out.println("---------------------------------------------------------------------");

		StartEventPage startEventPage = new StartEventPage(driver);
		startEventPage.tab1();
		startEventPage.clickOnYes();
		startEventPage.selectStatus("Student attended the session");
		startEventPage.clickOnStatusSubmit();
		startEventPage.clickOnYesPlease1();
		startEventPage.tab2();
		compliancePage.search();
		
		int Completion_Minutes = FutureMinutes - (SessionLength + SessionLength1);
		System.out.println("Completion minutes : " + Completion_Minutes);
		
		String completionMinutes = driver.findElement(By.xpath("//table[@id=\"compliance_datatable\"]//tbody//tr[1]//td[7]")).getText();
		int COMPLETIONMintues = Integer.parseInt(completionMinutes);
		System.out.println("Completion minutes in compliance tab : " + COMPLETIONMintues);
		
		if (Completion_Minutes==COMPLETIONMintues) {
		
			System.out.println("Completion minutes is reflected correctly ...");
			
		} else {

			System.out.println("Completion minutes is  not reflected correctly ...");
			
		}
		System.out.println("---------------------------------------------------------------------");

		if (ExpectedMinutes == TotalSessionLength) {
			
			System.out.println("Status of event : On Track ");
		}
		else if (ExpectedMinutes > TotalSessionLength) {
			
			System.out.println("Status of event : Over Booked ");

		}
		else if (ExpectedMinutes < TotalSessionLength) {
			
			System.out.println("Status of event : Under Booked ");
		}
		else if (COMPLETIONMintues == ExpectedMinutes) {
			
			System.out.println("Status of event : Complete ");

		}
		System.out.println("---------------------------------------------------------------------");

	}
	
	@Test
	public void CreateTHOAndCheckCompletion_Future_ExpectedMinutes_InComplianceTab_CompleteStatus() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();

		dashboardPage dashPage = new dashboardPage(driver);

		dashPage.clickOnCloseButton();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
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
		usersPage.clickOnViewProfile();

		THOPage thoPage = new THOPage(driver);
		thoPage.newTHO();
		thoPage.selectOrganization("Acceleration_orgTest");
		thoPage.selectType("IEP");
		thoPage.selectSpecialty("Occupational Therapist (OT)");
		thoPage.thoStartDate();
		thoPage.thoEndDate();
		thoPage.noOfVisits("2");
		
		String Visit = thoPage.NoOfVisit.getAttribute("value");
		int NoOfVisits = Integer.parseInt(Visit);
		System.out.println("NO of Visits : " + NoOfVisits);
		
		thoPage.units("5");
		String units = thoPage.Units.getAttribute("value");
		int UNITS = Integer.parseInt(units);
		System.out.println("Units : " + UNITS);
		
		thoPage.saveTHO();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String THOName = driver.findElement(By.xpath("//p[@class=\"hellohero-group-card-title\"]")).getText();
		System.out.println("----------------------------------------------------------------------");

		dashPage.clickOnScheduling();
		dashPage.clickOnEvents();

		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Acceleration_orgTest");

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("Make Up");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		
		eventPage.selectParticipant(StudentFullName);
		eventPage.clickOnAddParticipant();
		eventPage.selectTHO(THOName);

		eventPage.selectOwner("Malcum Marshal");
		eventPage.clickOnAddOwnerButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		
		eventPage.enterSessionLength("5");
		String eventLength = eventPage.sessionLength.getAttribute("value");
		int SessionLength = Integer.parseInt(eventLength);
		System.out.println("Session length of first Event : " + SessionLength);
		
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("........Event Created Successfully.........");
		System.out.println("----------------------------------------------------------------------");

		CalendarPage calendar = new CalendarPage(driver);
		
		calendar.clickOnEventInfo();
		calendar.clickOnStartButton();
		
		CompliancePage compliancePage = new CompliancePage(driver);
		compliancePage.OpenCompliancePage();
		compliancePage.enterStudentName(StudentFullName);
		compliancePage.search();
		compliancePage.getStatus();
		
		StartEventPage startEventPage= new StartEventPage(driver);
		startEventPage.tab1();
		
		dashPage.clickOnScheduling(); 
		dashPage.clickOnEvents();

		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Acceleration_orgTest");

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("Make Up");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		
		eventPage.selectParticipant(StudentFullName);
		eventPage.clickOnAddParticipant();
		eventPage.selectTHO(THOName);

		eventPage.selectOwner("Malcum Marshal");
		eventPage.clickOnAddOwnerButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		eventPage.clickOnIncreaseStartTime();

		eventPage.enterSessionLength("3");
		String eventLength1 = eventPage.sessionLength.getAttribute("value");
		int SessionLength1 = Integer.parseInt(eventLength1);
		System.out.println("Session length of second event : " + SessionLength1);
		
		eventPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		calendar.clickOnEventInfo();

		calendar.clickOnStartButton();
	
		dashPage.clickOnScheduling();
		dashPage.clickOnEvents();

		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Acceleration_orgTest");

		eventPage.selectscheduleTypes("Session");
		eventPage.selectScheduleSubTypes("Make Up");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		
		eventPage.selectParticipant(StudentFullName);
		eventPage.clickOnAddParticipant();
		eventPage.selectTHO(THOName);

		eventPage.selectOwner("Malcum Marshal");
		eventPage.clickOnAddOwnerButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		eventPage.clickOnIncreaseStartTime();
		eventPage.clickOnIncreaseStartTime();

		eventPage.enterSessionLength("2");
		String eventLength2 = eventPage.sessionLength.getAttribute("value");
		int SessionLength2 = Integer.parseInt(eventLength2);
		System.out.println("Session length of completion event : " + SessionLength2);
		
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		calendar.clickOnEventInfo();

		calendar.clickOnStartButton();
		int TotalSessionLength = SessionLength + SessionLength1 + SessionLength2;
		System.out.println("Total Session Length : " + TotalSessionLength);
		
		compliancePage.OpenCompliancePage();
		
		compliancePage.enterStudentName(StudentFullName);
		compliancePage.search();
		
		int EXPECTED_MINUTES = NoOfVisits*UNITS;
		System.out.println("Expected Minutes = NoOfVisits * Units : " + EXPECTED_MINUTES);
		System.out.println("---------------------------------------------------------------------");

		String futureMinutes = driver.findElement(By.xpath("//table[@id=\"compliance_datatable\"]//tbody//tr[1]//td[8]")).getText();
		int FutureMinutes = Integer.parseInt(futureMinutes);
		System.out.println("Future Minutes in Compliance tab : " + FutureMinutes);
		
		String expectedMinutes = driver.findElement(By.xpath("//table[@id=\"compliance_datatable\"]//tbody//tr[1]//td[9]")).getText();
		int ExpectedMinutes = Integer.parseInt(expectedMinutes);
		System.out.println("Expected minutes in compliance tab : " + ExpectedMinutes);
		
		if (ExpectedMinutes==EXPECTED_MINUTES && FutureMinutes==TotalSessionLength) {
		
			System.out.println("Future minutes is calculated correctly ...");
			System.out.println("Expected minutes is calculated correctly");
		} else {

			System.out.println("Future minutes is not calculated correctly ...");
			System.out.println("Expected minutes is not calculated correctly");
		}
		System.out.println("---------------------------------------------------------------------");

		compliancePage.getStatus();
		System.out.println("---------------------------------------------------------------------");

		startEventPage.tab1();
		startEventPage.clickOnYes();
		startEventPage.selectStatus("Student attended the session");
		startEventPage.clickOnStatusSubmit();
		startEventPage.clickOnYesPlease1();
		startEventPage.tab2();
		compliancePage.search();
		
		int Completion_Minutes = FutureMinutes - (SessionLength + SessionLength1);
		System.out.println("Completion minutes : " + Completion_Minutes);
		
		String completionMinutes = driver.findElement(By.xpath("//table[@id=\"compliance_datatable\"]//tbody//tr[1]//td[7]")).getText();
		int COMPLETIONMintues = Integer.parseInt(completionMinutes);
		System.out.println("Completion minutes in compliance tab : " + COMPLETIONMintues);
		
		if (Completion_Minutes==COMPLETIONMintues) {
		
			System.out.println("Completion minutes is reflected correctly ...");
			
		} else {

			System.out.println("Completion minutes is  not reflected correctly ...");
			
		}
		System.out.println("---------------------------------------------------------------------");


		if (ExpectedMinutes == TotalSessionLength) {
			
			System.out.println("Status of event : On Track ");
		}
		else if (ExpectedMinutes > TotalSessionLength) {
			
			System.out.println("Status of event : Over Booked ");

		}
		else if (ExpectedMinutes < TotalSessionLength) {
			
			System.out.println("Status of event : Under Booked ");
		}
		else if (COMPLETIONMintues == ExpectedMinutes) {
			
			System.out.println("Status of event : Complete ");

		}
		System.out.println("---------------------------------------------------------------------");

	}
}
