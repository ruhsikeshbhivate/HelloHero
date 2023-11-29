package com.EMC.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_LoginTest extends BaseClass {

	@Test
	public void verifyLogin() throws IOException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();
	}
}
