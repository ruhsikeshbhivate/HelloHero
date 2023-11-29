package com.EMC.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.EMC.PageObject.TherapistDashboardPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_DenyDetachUserRequest extends BaseClass{

	@Test
	public void deniedDetachUserRequest() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("malcum89303");
		login.enterPassword("RUshikesh@123");
		login.clickOnLoginButton();
		
		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		
		UsersPage usersPage = new UsersPage(driver);
		usersPage.SearchOranization("Acceleration_orgTest");
		usersPage.clickOnSearch();
		
		WebElement  Name = driver.findElement(By.xpath("//table//tbody//tr[1]//td[2]"));
		String ClientName = Name.getText();
		System.out.println("Therapist login-Client Name : " + ClientName);
		
		usersPage.detachUser();
		usersPage.detachUserReason("For Comparing userRequest...");
		usersPage.submitReason();

		TherapistDashboardPage dashpage = new TherapistDashboardPage(driver);
		dashpage.therapistProfileThumb();
		dashpage.clickOnSignOut();
		
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();
		
		dashPage.deatchUserRequestTab();
		dashPage.searchUserBytherapist("Malcum Marshal");
		dashPage.searchStudent(ClientName);
		dashPage.searchUserRequest();
		
		System.out.println("------------------------------------------------------------");
		WebElement Name2 = driver.findElement(By.xpath("//table[@id=\"data-table\"]//tr//td[3]"));
		String StudentName = Name2.getText();
		System.out.println("Admin login-ClientName :  " + StudentName);
		System.out.println("------------------------------------------------------------");

		if (ClientName.contentEquals(StudentName)==true) {
			
			System.out.println("=> Deatch user request appears Correct");
			
		} else {
			
			System.out.println("Deatch user request appears Incorrect");

		}
		
		dashPage.denyRequest();

		dashPage.clickONprofile();
		dashPage.clickOnSignOut();
		login.enterUsername("malcum89303");
		login.enterPassword("RUshikesh@123");
		login.clickOnLoginButton();
		
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		
		usersPage.enterStudentName(ClientName);
		usersPage.clickOnSearch();

		System.out.println("------------------------------------------------------------");

		WebElement Value3 = driver.findElement(By.xpath("//table[@id=\"data-table\"]//tbody//tr[1]//td[2]"));
		String TableValue = Value3.getText();
		System.out.println("Search Detach User: " + TableValue);
		System.out.println("------------------------------------------------------------");

		if (TableValue.contentEquals(ClientName)==true) {

			System.out.println("=>Detach user request has Denied.......");

		}
		else {
			System.out.println("Detach user request has Appoved.......");
		}
		System.out.println("------------------------------------------------------------");

	}
}
