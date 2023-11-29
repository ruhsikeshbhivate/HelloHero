package com.EMC.testcases;

import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.EMC.PageObject.ReferralPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_ReassignTherapist extends BaseClass{

	Faker faker = new Faker(new Locale("en-US"));
	
	@Test
	public void reassignTherapistAndCheckInUserListByTherapistLogin() throws InterruptedException
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

		usersPage.selectOrganization("Rushi_TestOrganization");
		usersPage.selectRole("Client");
		driver.findElement(UsersPage.username).sendKeys(faker.name().username());
		usersPage.enterCellPhone("7262957778");
		usersPage.enterUserPassword("RUshikesh@123");
		usersPage.enterConfirmPassword("RUshikesh@123");
		usersPage.clickOnCreateProfile();
		
		usersPage.SearchOranization("Rushi_TestOrganization");
		usersPage.clickOnSearch();
		
		//Create referral from new therapy service
		
		usersPage.newTherapyServices();
		ReferralPage referralPage = new ReferralPage(driver);
		referralPage.clickOnWithoutOutreach();
		referralPage.selectServiceRequested("Occupational Therapist (OT)");
		referralPage.selectScheduleType("Session");
		referralPage.selectScheduleSubType("General");
		referralPage.SessionLength1("10");
		referralPage.serviceStartDate();
		referralPage.serviceEndDate();
		referralPage.intervalInfo("Daily");
		referralPage.NoOfTimes("1");
		referralPage.clickOnAddService();
		referralPage.clickOnSubmit();

		dashPage.clickOnReferral();
		referralPage.searchOrganization("Rushi_TestOrganization");
		referralPage.searchReferral();
		referralPage.DataTableReferralFilter(StudentFullName);
			
		// Assign Therapist to the referral.....
		
		referralPage.clickOnAssign();
		referralPage.assignTherapist("Ward Lind");
		referralPage.UpdateTherapistToReferral();
		
		//SignOut....
		
		dashPage.clickONprofile();
		dashPage.clickOnSignOut();

		// Login by Therapist....
		
		login.enterUsername("sona.bahringer");
		login.enterPassword("RUshikesh@123");
		login.clickOnLoginButton();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		usersPage.clickOnSearch();

		String ClientName = driver.findElement(By.xpath("//table[@id=\"data-table\"]//tr//td[2]")).getText();
		System.out.println("Therapist Login Client Name: " + ClientName);

		if (ClientName.contentEquals(StudentFullName)==true) {
			
			System.out.println("Assign Therapist Login => User is reflected in user list.");
			
		} else {
			
			System.out.println("Assign Therapist Login => User is not reflected in user list.");
		}
		System.out.println("------------------------------------------------------------");

		dashPage.clickONprofile();
		dashPage.clickOnSignOut();
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();
		
		dashPage.clickOnUsers();
		dashPage.clickOnReferral();
		referralPage.searchOrganization("Rushi_TestOrganization");
		referralPage.searchReferral();
		referralPage.DataTableReferralFilter(StudentFullName);
		referralPage.clickOnReassign();
		referralPage.assignTherapist("Travis Head");
		referralPage.UpdateTherapistToReferral();
		
		//SignOut....
		
		dashPage.clickONprofile();
		dashPage.clickOnSignOut();
		login.enterUsername("sona.bahringer");
		login.enterPassword("RUshikesh@123");
		login.clickOnLoginButton();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		usersPage.clickOnSearch();

		String ClientName1 = driver.findElement(By.xpath("//table[@id=\"data-table\"]//tr//td[2]")).getText();
		System.out.println("Therapist Login - Client Name : " + ClientName1);

		
		if (ClientName1.contentEquals(StudentFullName)==true) {
			
			System.out.println("Therapist Login After Reassign=> User is reflected in user list.");
			
		} else {
			
			System.out.println("Therapist Login After Reassign => User is not reflected in user list.");
		}
		System.out.println("-----------------------------------------------------------------");

		dashPage.clickONprofile();
		dashPage.clickOnSignOut();
		
		//Login By Reassign Therapist..........
		
		login.enterUsername("travis7890");
		login.enterPassword("RUshikesh@123");
		login.clickOnLoginButton();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		usersPage.clickOnSearch();

		String ClientName2 = driver.findElement(By.xpath("//table[@id=\"data-table\"]//tr//td[2]")).getText();
		System.out.println("Reassign Therapist Login - Client Name : " + ClientName2);

		if (ClientName2.contentEquals(StudentFullName)==true) {
			
			System.out.println("Reassign Therapist Login => User is reflected in user list.");
			
		} else {
			
			System.out.println("Reassign Therapist Login => User is not reflected in user list.");
		}
		System.out.println("-----------------------------------------------------------------");

	}
}
