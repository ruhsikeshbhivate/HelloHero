package com.EMC.testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.ClassroomPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

import io.ous.jtoml.impl.SymbolToken;

public class TC_CheckTheTherapistIsReflectedInClassroomListForDailyTeachingEvent extends BaseClass{

	@Test
	public void CheckTheTherapistIsReflectedInClassroomListForDailyTeachingEvent() throws InterruptedException
	{
		driver.manage().window().maximize();
		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();


		dashboardPage dashpage = new dashboardPage(driver);
		dashpage.clickOnCloseButton();
		dashpage.clickOnScheduling();
		dashpage.clickOnEvents();

		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Rushi_TestOrganization");

		eventPage.selectscheduleTypes("Meeting");
		eventPage.selectScheduleSubTypes("Daily Teaching");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");

		eventPage.selectOwner("Mathew Short");
		eventPage.clickOnAddOwnerButton();
		eventPage.clickOnEventButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		eventPage.enterSessionLength("2");

		eventPage.enterGeneralNotes("This event is created by automation");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		eventPage.clickOnSubmit5();
		System.out.println("........Event Created Successfully.........");
		System.out.println("---------------------------------------------------------------------------------");
		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo();

		calendar.clickOnStartButton();
		dashpage.classroom();

		ClassroomPage classroomPage = new ClassroomPage(driver);
		classroomPage.SelectOrganization("Rushi_TestOrganization");
		classroomPage.selectOwner("Mathew Short");
		classroomPage.search();

		classroomPage.ManageStudent();
		List<WebElement> StudentName = driver.findElements(By.xpath("//table[@class=\"table table-hover activeStudentDatatable dataTable no-footer\"]//tbody//tr"));
		int NoOfRows = StudentName.size();
		classroomPage.ManageStudent();
		
		String clientName = driver.findElement(By.xpath("//table[@class=\"table table-hover activeStudentDatatable dataTable no-footer\"]//tbody//tr[1]//td[1]")).getText();
		System.out.println("Archived Student Name : " + clientName);
		System.out.println("---------------------------------------------------------------------------------");

		for(int i=1;i<=NoOfRows;i++)
		{

			System.out.print(i+" : ");

			WebElement Value =driver.findElement(By.xpath("//table[@class=\"table table-hover activeStudentDatatable dataTable no-footer\"]//tbody//tr["+i+"]//td[1]"));
			String Name1 = Value.getText();
			System.out.println(Name1);
		}

		classroomPage.archiveStudent();
		classroomPage.submitReason();

		dashpage.clickOnScheduling();
		dashpage.clickOnEvents();

		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Rushi_TestOrganization");

		eventPage.selectscheduleTypes("Meeting");
		eventPage.selectScheduleSubTypes("Daily Teaching");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		System.out.println("---------------------------------------------------------------------------------");

		eventPage.selectOwner("Mathew Short");
		eventPage.clickOnAddOwnerButton();
		eventPage.clickOnEventButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		eventPage.enterSessionLength("2");

		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit5();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		calendar.clickOnEventInfo();
		calendar.clickOnStartButton1();

		try {

			WebElement studentName1 = driver.findElement(By.xpath("//a[text()=\"Alexander McCall\"]"));

			boolean display = studentName1.isDisplayed();

			if(display) 
			{
				System.out.println("Student is reflected after archived from classroom List...");
			} 
		} 
		catch (NoSuchElementException e) {

			System.out.println("Student is not reflected after archived from classroom List...");
		}
		
		System.out.println("---------------------------------------------------------------------------------");

		dashpage.classroom();

		classroomPage.SelectOrganization("Rushi_TestOrganization");
		classroomPage.selectOwner("Mathew Short");
		classroomPage.search();
		classroomPage.ManageStudent();
		classroomPage.archiveStudentlist();
		classroomPage.unarchive();

	}
}
