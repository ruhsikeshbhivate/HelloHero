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

public class TC_CreateTHO_UnknownStatus extends BaseClass{

	Faker faker  = new Faker(new Locale("en-US"));

	@Test(enabled = false)
	public void createTHO_UnknownStatus() throws InterruptedException
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
		//thoPage.thoStartDate();
		//thoPage.thoEndDate();
		/*thoPage.noOfVisits("2");

		String Visit = thoPage.NoOfVisit.getAttribute("value");
		int NoOfVisits = Integer.parseInt(Visit);
		System.out.println("NO of Visits : " + NoOfVisits);

		thoPage.units("5");
		String units = thoPage.Units.getAttribute("value");
		int UNITS = Integer.parseInt(units);
		System.out.println("Units : " + UNITS);
		 */
		thoPage.saveTHO();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String THOName = driver.findElement(By.xpath("//p[@class=\"hellohero-group-card-title\"]")).getText();

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

		eventPage.enterSessionLength("2");
		/*String eventLength = eventPage.sessionLength.getAttribute("value");
		int SessionLength = Integer.parseInt(eventLength);
		System.out.println("Session length of first Event : " + SessionLength);
		 */
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("........Event Created Successfully.........");
		System.out.println("----------------------------------------------------------------------");

		CalendarPage calendar = new CalendarPage(driver);

		calendar.clickOnEventInfo();
		calendar.clickOnStartButton();

		StartEventPage startEventPage = new StartEventPage(driver);
		startEventPage.viewUserProfile();
		thoPage.deleteTHO();


		CompliancePage compliancePage = new CompliancePage(driver);
		compliancePage.OpenCompliancePage1();

		compliancePage.enterStudentName(StudentFullName);
		compliancePage.search();
		compliancePage.getStatus1();

	}
	
	@Test
	public void createTHO_InvalidDate() throws InterruptedException
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
		String THOStartDate = thoPage.startDate.getAttribute("value");
		String[] values1 = THOStartDate.split("/");
		int month1 = Integer.parseInt(values1[0]);
		int day1 = Integer.parseInt(values1[1]);
		int Year1 = Integer.parseInt(values1[2]);
		System.out.println("THO start date : " + month1 + "/" + day1 + "/" + Year1);
		System.out.println("----------------------------------------------------------------------");
		thoPage.thoEndDate();
		thoPage.noOfVisits("2");

		thoPage.units("3");
				
		thoPage.saveTHO();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String THOName = driver.findElement(By.xpath("//p[@class=\"hellohero-group-card-title\"]")).getText();

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
		String eventStartDate = eventPage.EventStartDate.getAttribute("value");
		String[] values3 = eventStartDate.split("/");
		int month3 = Integer.parseInt(values3[0]);
		int day3 = Integer.parseInt(values3[1]);
		int Year3 = Integer.parseInt(values3[2]);
		
		System.out.println("Event start date : " + month3 + "/" + day3 + "/" + Year3);
		System.out.println("----------------------------------------------------------------------");

		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();

		eventPage.enterSessionLength("6");
		/*String eventLength = eventPage.sessionLength.getAttribute("value");
		int SessionLength = Integer.parseInt(eventLength);
		System.out.println("Session length of first Event : " + SessionLength);
		 */
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
		
		String Status = compliancePage.Status.getText();
		System.out.println("Event status in Compliance tab : " + Status);
		
		if ((day3<day1) && (month3<=month1) && (Year3<=Year1))
		{
			System.out.println("Status of event in conmpliance : " + Status);
			
		} else {
			System.out.println("Status is getting wrong");

		}
		System.out.println("----------------------------------------------------------------------");

		
		//compliancePage.getStatus1();

		
	}
}
