package com.EMC.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EligibilityPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_addInsuranceAndCheckEligibility extends BaseClass{

	@Test
	public void addInsuranceAndCheckEligibility() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();
		
		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		UsersPage userpage = new UsersPage(driver);
	
		userpage.enterSearchName("Glenn Phillips");
		userpage.clickOnSearch();
		userpage.clickOnViewProfile();
		userpage.clickOnInsurance();
		userpage.clickOnAddInsurance();
		userpage.selectRelation("Child");
		userpage.selectInsuranceType("Primary");
		userpage.enterFirstName("Darren");
		userpage.enterlastName("Jacob");
		userpage.clickOnDOB();
		userpage.selectInsurancePayer("ActivHealthCare");
		userpage.enterMemberId("8956");
		userpage.clickOnSaveInsurance();
		userpage.clickOnCheckEligibility();

						
		EligibilityPage eligibility = new EligibilityPage(driver);

		eligibility.clickOnSubmitted();		
		eligibility.SelectUser("Glenn Phillips");
		eligibility.clickOnSearch();
		
	}
}
