package com.EMC.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.EMC.PageObject.ClientDashboardPage;
import com.EMC.PageObject.MyProfilePage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_ChangeUserPassword extends BaseClass {

	@Test(priority = 0)
	public void changePasswordFromUserUpdate() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();
		
		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		
		UsersPage userPage = new UsersPage(driver);
		userPage.enterSearchName("Rushikesh Client");
		userPage.clickOnSearch();
		userPage.clickOnViewProfile();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		userPage.clickOnEditPassword();
		userPage.enterPassword("Rushikesh@123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		userPage.enterConfirmPassword("Rushikesh@123");
		userPage.clickOnSaveProfile();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		dashPage.clickOnProfileThumb();
		dashPage.clickOnSignOut();
	}
	
	@Test(priority = 1)
	public void changePasswordFromClientMyProfile() throws InterruptedException
	{
		loginPage login = new loginPage(driver);
		login.enterUsername("rushiclient");
		login.enterPassword("Rushikesh@123");
		login.clickOnLoginButton();
		
		ClientDashboardPage dashPage = new ClientDashboardPage(driver);
		dashPage.clickOnLater();
		dashPage.clickOnProfileThumb1();
		dashPage.clickOnMyProfile();
		
		MyProfilePage profilePage = new MyProfilePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		profilePage.enterPassword("Rushikesh@123");
		profilePage.enterConfirmPassword("Rushikesh@123");
		profilePage.clickOnSaveProfile();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		dashPage.clickOnProfileThumb1();
		dashPage.clickOnSignOut();
		
		login.enterUsername("rushiclient");
		login.enterPassword("Rushikesh@123");
		login.clickOnLoginButton();
		
	}
}
