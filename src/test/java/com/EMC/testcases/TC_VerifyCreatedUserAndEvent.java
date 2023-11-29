package com.EMC.testcases;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_VerifyCreatedUserAndEvent extends BaseClass {

	Faker faker = new Faker(new Locale("en-US"));
	@Test
	public void verifyCreatedUserAndEvent() throws InterruptedException
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
		//System.out.println("Student First Name : " + StudentFirstName);

		WebElement LastName=driver.findElement(By.xpath("//input[@name=\"last_name\"]"));
		LastName.sendKeys(faker.name().lastName());
		String StudentLastName = LastName.getAttribute("value");
		//System.out.println("Student Last Name : " + StudentLastName);

		String StudentFullName = StudentFirstName + " " + StudentLastName;
		System.out.println("Student Full Name: " + StudentFullName);
		WebElement Organization=driver.findElement(By.xpath("//select[@id=\"orgInput\"]"));
		Select select = new Select(Organization);
		select.selectByVisibleText("Rushi_TestOrganization");

		WebElement Role=driver.findElement(By.xpath("//select[@id=\"roleId\"]"));
		Select select1 = new Select(Role);
		select1.selectByVisibleText("Client");

		WebElement UserName=driver.findElement(By.xpath("//input[@id=\"username\"]"));
		UserName.sendKeys(faker.name().username());

		WebElement CellPhone=driver.findElement(By.xpath("//input[@id=\"mobile_phone\"]"));
		CellPhone.sendKeys("Rushikesh@123");

		WebElement Password=driver.findElement(By.xpath("//input[@id=\"psw\"]"));
		Password.sendKeys("Rushikesh@123");

		WebElement ConfirmedPassword=driver.findElement(By.xpath("//input[@id=\"cPass\"]"));
		ConfirmedPassword.sendKeys("Rushikesh@123");

		usersPage.clickOnCreateProfile();
		usersPage.clickOnSearch();
		
		int NoOfRows = 1;
		int totalColumns = 1;

		for(int i=1;i<=NoOfRows;i++)
		{

			System.out.print(i+" : ");

			for(int j=1;j<=totalColumns;j++)
			{
				WebElement Value =driver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[2]"));
				String Student = Value.getText();
				System.out.println(Student);		
					
				if (Student.contains(StudentFullName) == true )  {

					System.out.println("Result is getting correct.....");
				}

				else {
					System.out.println("Result is getting wrong.....");
				}
			}
		}
		
		usersPage.clickOnViewProfile();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement CreateSchedule=driver.findElement(By.xpath("//a[text()=\"+ Create Schedule\"]"));
		CreateSchedule.click();
		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnBuildSchedule();

		eventPage.selectscheduleTypes("Session");
		WebElement ScheduleType = driver.findElement(By.xpath("//select[@name=\"schedule_type_id\"]"));
		String scheduleTypeName = ScheduleType.getAttribute("value");
		System.out.println("Schedule Type : " + scheduleTypeName);
		
		eventPage.selectScheduleSubTypes("General");
		WebElement ScheduleSubType = driver.findElement(By.xpath("//select[@name=\"schedule_subtype_id\"]"));
		String scheduleSubTypeName = ScheduleSubType.getAttribute("value");
		System.out.println("Schedule Sub Type : " + scheduleSubTypeName);
		
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");

		eventPage.selectOwner("Malcum Marshal");
		eventPage.clickOnAddOwnerButton();
		eventPage.clickOnEventButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		WebElement StartDate = driver.findElement(By.xpath("//input[@id=\"EventStartDate\"]"));
		String eventStartDate = StartDate.getAttribute("value");
		System.out.println("Event Start Date : " + eventStartDate);
		
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		
		WebElement StartTime = driver.findElement(By.xpath("//input[@id=\"EventStartTime\"]"));
		String eventStartTime = StartTime.getAttribute("value");
		System.out.println("Event Start Time : " + eventStartTime);
		eventPage.enterSessionLength("2");

		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmitEvent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo();

		dashPage.clickOnEvents();
		eventPage.searchOrganization("Rushi_TestOrganization");

		eventPage.searchTherapist("Malcum Marshal");

		eventPage.clickOnSearchStartDate();
		eventPage.clickOnsearchEndDate();

		eventPage.clickOnSearchEvent();

		/*String  StudentName = FirstName.getAttribute("value");
		System.out.println(StudentName);

		String  StudentName1 = LastName.getAttribute("value");
		System.out.println(StudentName1);*/


		int NoOfRows1 = 1;
		int totalColumns1 = 1;

		for(int i=1;i<=NoOfRows1;i++)
		{

			System.out.println(i+" : ");

			for(int j=1;j<=totalColumns1;j++)
			{
				WebElement Value =driver.findElement(By.xpath("//table[@id=\"liveEventsTable\"]/tbody/tr["+i+"]/td[10]"));
				String Student = Value.getText();
				System.out.println(Student);		

				WebElement Value2 =driver.findElement(By.xpath("//table[@id=\"liveEventsTable\"]/tbody/tr["+i+"]/td[7]"));
				String StartDate2 = Value2.getText();
				System.out.println(StartDate2);

				WebElement Value3 =driver.findElement(By.xpath("//table[@id=\"liveEventsTable\"]/tbody/tr["+i+"]/td[4]"));
				String scheduleType = Value3.getText();
				System.out.println(scheduleType);

				WebElement Value4 =driver.findElement(By.xpath("//table[@id=\"liveEventsTable\"]/tbody/tr["+i+"]/td[5]"));
				String Subtype = Value4.getText();
				System.out.println(Subtype);
				
				if (Student.contains(StudentFirstName) == true &&  StartDate2.contains(eventStartTime) == true)  {

					System.out.println("Result is getting correct.....");
				}

				else {
					System.out.println("Result is getting wrong.....");
				}
			}
		}
		
		
		
	}
}
