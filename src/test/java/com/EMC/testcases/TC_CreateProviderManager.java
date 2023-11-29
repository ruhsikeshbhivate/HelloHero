package com.EMC.testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.EMC.PageObject.ProviderManagerPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_CreateProviderManager extends BaseClass{

	Faker faker = new Faker(new Locale("en-US"));

	@Test
	public void createProviderManager() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
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
		
		ProviderManagerPage providerManagerPage = new ProviderManagerPage(driver);
		providerManagerPage.clickOnProviderManager();
				
		providerManagerPage.clickOnNewManager();
		providerManagerPage.SelectTherapist();
		
		usersPage.enterUserFirstName(Keys.CONTROL);
		usersPage.enterUserFirstName1("A");
		usersPage.enterUserFirstName(Keys.CONTROL);
		usersPage.enterUserFirstName1("C");
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		driver.switchTo().window(handles.get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		providerManagerPage.SearchTherapist(Keys.CONTROL);
		providerManagerPage.SearchTherapist1("V");
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).perform();
	}
}
