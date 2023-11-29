package com.EMC.testcases;


import java.util.List;

import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SourceType;
import org.testng.annotations.Test;

import com.EMC.PageObject.AddBulkEventPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.Schedule_SubtypesPage;
import com.EMC.PageObject.TherapistClientsPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_AddBulkEvent extends BaseClass {

	@Test
	public void addBulkEvent() throws InterruptedException 
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();

		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();

		Schedule_SubtypesPage schedule_SubtypesPage = new Schedule_SubtypesPage(driver);
		schedule_SubtypesPage.schedule_SubtypesTab();
		schedule_SubtypesPage.searchSchedule_Subtypes("Quarterly Progress Report");
		schedule_SubtypesPage.update();
		schedule_SubtypesPage.addBulkCreationCheckbox();

		TherapistClientsPage therapistClientsPage = new TherapistClientsPage(driver);
		therapistClientsPage.Therapist_ClientsTab();
		therapistClientsPage.searchOrganization("Acceleration_orgTest");
		therapistClientsPage.selectTherapist("Martin Therapist");
		therapistClientsPage.search();

		System.out.println("Name of User's those are attached to the Therapist : ");

		String Name1 =driver.findElement(By.xpath("//table[@id=\"activeStudentTable\"]//tbody//tr[1]//td[3]")).getText();
		System.out.println(Name1);

		String Name2 =driver.findElement(By.xpath("//table[@id=\"activeStudentTable\"]//tbody//tr[2]//td[3]")).getText();
		System.out.println(Name2);

		String Name3 =driver.findElement(By.xpath("//table[@id=\"activeStudentTable\"]//tbody//tr[3]//td[3]")).getText();
		System.out.println(Name3);

		System.out.println("------------------------------------------------------------------");
		System.out.println("Name of user's in Add bulk event tab : ");
		AddBulkEventPage addBulkEventPage = new AddBulkEventPage(driver);
		addBulkEventPage.addBulkEventTab();
		addBulkEventPage.selectOrganization("Acceleration_orgTest");
		addBulkEventPage.selectTherapist("Martin Therapist");
		addBulkEventPage.dateDue();
		addBulkEventPage.timeDue();
		addBulkEventPage.next();

		List<WebElement> ClientName = driver.findElements(By.xpath("//table[@id=\"bulkEventTable\"]//tbody//tr"));
		int NoOfRows = ClientName.size();

		for(int i=1;i<=NoOfRows;i++)
		{

			System.out.print(i+" : ");

			String clientName =driver.findElement(By.xpath("//table[@id=\"bulkEventTable\"]//tbody//tr["+i+"]//td[3]")).getText();

			if(clientName.contentEquals(Name1) == true || clientName.contentEquals(Name2)==true 
					|| clientName.contentEquals(Name3)==true)
			{
				System.out.println(clientName);
			}

			else {
				System.out.println("Unassigned user is reflected..." + clientName);
			}
		}

		addBulkEventPage.uncheckUser();
		
		addBulkEventPage.compareUncheckUserInEventList();

	}
}
