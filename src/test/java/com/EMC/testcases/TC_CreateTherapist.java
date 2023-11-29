package com.EMC.testcases;

import java.util.Locale;

import org.testng.annotations.Test;

import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_CreateTherapist extends BaseClass{

	Faker faker = new Faker(new Locale("en-US"));

	@Test
	public void createUser() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();
		
		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnAddUser();
		
		driver.findElement(UsersPage.userFirstName).sendKeys(faker.name().firstName());
		driver.findElement(UsersPage.userLastName).sendKeys(faker.name().lastName());
		usersPage.selectOrganization("Rushi_TestOrganization");
		usersPage.selectRole("Therapist");
		driver.findElement(UsersPage.username).sendKeys(faker.name().username());
		usersPage.enterCellPhone("7262957778");
		usersPage.enterUserPassword("RUshikesh@123");
		usersPage.enterConfirmPassword("RUshikesh@123");
		usersPage.clickOnCreateProfile();
		
		
		/*driver.findElement(UsersPage.Address).sendKeys(faker.address().streetAddress());
		usersPage.selectState("Arizona");
		usersPage.enterCity("Safford");
		usersPage.enterZipCode("85546");
		usersPage.selectCredientials("CCC-SLP");
		usersPage.clickOnSaveProfile();*/
		
	}
}
