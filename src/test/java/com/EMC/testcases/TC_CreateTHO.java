package com.EMC.testcases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.THOPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_CreateTHO extends BaseClass {

	Faker faker  = new Faker(new Locale("en-US"));

	@Test
	public void createTHO() throws InterruptedException, ParseException
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

		driver.findElement(UsersPage.userFirstName).sendKeys(faker.name().firstName());

		driver.findElement(UsersPage.userLastName).sendKeys(faker.name().lastName());
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
		String date1 = driver.findElement(By.xpath("//input[@id=\"search_end_date_tho\"]")).getAttribute("value");
		Date DATE1 = new SimpleDateFormat("MM/dd/yyyy").parse(date1);
		String THOENDDATE= new SimpleDateFormat("MM-dd-yyyy").format(DATE1);
		thoPage.saveTHO();

		thoPage.createSchedule();

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

		//eventPage.eventDate();
		eventPage.clickOnEventStartDate();
		String date = driver.findElement(By.xpath("//input[@name=\"event_start_date\"]")).getAttribute("value");
		Date DATE = new SimpleDateFormat("MM/dd/yyyy").parse(date);
		String StartDATE = new SimpleDateFormat("MM-dd-yyyy").format(DATE);
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		eventPage.enterSessionLength("2");	

		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmitEvent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("........Event Created Successfully.........");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("THO end date : " + THOENDDATE);
		System.out.println("----------------------------------------------------------------------");

		System.out.println("Event Date : " + StartDATE);
		System.out.println("----------------------------------------------------------------------");

		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo();

		calendar.clickOnStartButton();
		StartEventPage startEventPage = new StartEventPage(driver);
		startEventPage.viewUserProfile();

		thoPage.editTHO();
		
		try {
			
			thoPage.addSchedules();
			thoPage.updateTHO();
			String THOTableStartDate = driver.findElement(By.xpath("//table[@class=\"hellohero-tho-table\"]//tbody//tr[1]//td[2]")).getText();
			System.out.println("THO Tab - Event start date: " + THOTableStartDate);
			System.out.println("----------------------------------------------------------------------");

			System.out.println("Events have been reflected within the date range that have added to THO.");
			
		} catch (NoSuchElementException e) {
			
			System.out.println("Events have been reflected outside the date range that have added to THO.");
		}
		
		System.out.println("----------------------------------------------------------------------");
	}
}
