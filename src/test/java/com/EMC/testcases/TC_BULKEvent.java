package com.EMC.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.EMC.PageObject.AddBulkEventPage;
import com.EMC.PageObject.Schedule_SubtypesPage;
import com.EMC.PageObject.TherapistClientsPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_BULKEvent extends BaseClass{

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

		AddBulkEventPage addBulkEventPage = new AddBulkEventPage(driver);
		addBulkEventPage.addBulkEventTab();
		addBulkEventPage.selectOrganization("Acceleration_orgTest");
		addBulkEventPage.selectTherapist("Martin Therapist");
		addBulkEventPage.dateDue();
		addBulkEventPage.timeDue();
		addBulkEventPage.next();

		TherapistClientsPage therapistClientsPage = new TherapistClientsPage(driver);
		therapistClientsPage.openTherapist_ClientPage();
		therapistClientsPage.searchOrganization("Acceleration_orgTest");
		therapistClientsPage.selectTherapist("Martin Therapist");
		therapistClientsPage.search();

	//	System.out.println("Name of User's those are attached to the Therapist : ");
		
		List<WebElement> ClientName = driver.findElements(By.xpath("//table[@id=\"activeStudentTable\"]//tbody//tr"));
		int NoOfRows = ClientName.size();

		for(int j=1; j<=NoOfRows;j++)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String Name1 =driver.findElement(By.xpath("//table[@id=\"activeStudentTable\"]//tbody//tr["+j+"]//td[3]")).getText();
			System.out.println("Name of user in therapist-client tab : " +Name1);
			
			addBulkEventPage.tab0();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			List<WebElement> ClientName1 = driver.findElements(By.xpath("//table[@id=\"bulkEventTable\"]//tbody//tr"));
			int NoOfRows1 = ClientName1.size();

			for(int i=1;i<=NoOfRows1;i++)
			{

				String clientName =driver.findElement(By.xpath("//table[@id=\"bulkEventTable\"]//tbody//tr["+i+"]//td[3]")).getText();

				if(clientName.contentEquals(Name1) == true )
				{
					System.out.println("Name of user in Add Bulk Event tab : " +clientName);
				}

			}
			
			System.out.println();
			addBulkEventPage.tab1();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}

		addBulkEventPage.tab0();
		addBulkEventPage.uncheckUser1();
		
		addBulkEventPage.compareUncheckUserInEventList();

	}
}
