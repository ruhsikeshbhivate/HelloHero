package com.EMC.testcases;

import org.testng.annotations.Test;

import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_addConfidentialNotesToUser extends BaseClass{

	@Test
	public void addConfidentialNotes() throws InterruptedException
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
		
		userpage.clickOnNotes();
		userpage.clickOnAddNotes();
		userpage.clickOnConfidentialCheckbox();
		userpage.enterUserNotes("Developments From Previous Sessions.");
		userpage.clickOnSaveNote();
		
		userpage.loginAccountAdmin();
		userpage.clickOnClear();
		userpage.enterSearchName("Bhivate31 AccountAdmin");
		userpage.clickOnSearch();
		userpage.clickOnLoginAs();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		userpage.clickOnClear();
		userpage.enterSearchName("Glenn Phillips");
		userpage.clickOnSearch();
		userpage.clickOnViewProfile();
		userpage.clickOnNotes();
		userpage.selectConfidential("Confidential");

	}
}
