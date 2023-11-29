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

public class TC_VerifyCreatedReferral extends BaseClass{
	
	Faker faker = new Faker(new Locale("en-US"));

	@Test
	public void verifyCreatedReferral() throws InterruptedException
	{
		
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();
		
		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
		dashPage.clickOnUsers();
		dashPage.clickOnReferral();

		ReferralPage referralPage = new ReferralPage(driver);
		referralPage.clickOnAddReferral();
		referralPage.clickOnWithoutOutreach();
		referralPage.selectOrganization("Rushi_TestOrganization");
		referralPage.selectStudent("Luke Wright");
		referralPage.clickOnNext();

		referralPage.selectServiceRequested("Occupational Therapist (OT)");
		referralPage.selectScheduleType("Assessment");
		referralPage.selectScheduleSubType("Standard Assessment");
		referralPage.SessionLength1("10");
		referralPage.clickOnAddService();
		referralPage.clickOnSubmit();
		referralPage.searchReferral();
		referralPage.Verify();
			
	}
}

