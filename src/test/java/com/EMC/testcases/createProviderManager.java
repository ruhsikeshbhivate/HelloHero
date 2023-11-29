package com.EMC.testcases;

import org.testng.annotations.Test;

import com.EMC.PageObject.ProviderManagerPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class createProviderManager extends BaseClass{
	
	@Test
	public void create_providerManager() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();
		
		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
		
		dashPage.clickOnUsers();
		ProviderManagerPage providerManagerPage = new ProviderManagerPage(driver);
		providerManagerPage.clickOnProviderManager();
		providerManagerPage.clickOnNewManager();
		providerManagerPage.SelectTherapist("Malculm Marshall");
		providerManagerPage.clickOnAddProviderManager();
		providerManagerPage.clickOnManagers_ProvidersTab();
		providerManagerPage.clickOnAttachManager();
		providerManagerPage.selectProviderManager("Malculm Marshall");
		providerManagerPage.selectAttachTherapist("Kyle Jamieson");
		providerManagerPage.clickOnAdd();
		driver.navigate().refresh();
		providerManagerPage.searchProviderManager("Malculm Marshall");
		providerManagerPage.clickOnSearch();
		
		UsersPage userPage = new UsersPage(driver);
		userPage.enterSearchName("Malculm Marshall");
		userPage.SearchUserRole("Provider Manager");
		userPage.clickOnSearch();
		
		
	}

}
