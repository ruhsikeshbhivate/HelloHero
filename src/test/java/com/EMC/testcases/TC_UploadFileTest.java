package com.EMC.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;


public class TC_UploadFileTest extends BaseClass{

	@Test
	public void uploadFileForUser() throws InterruptedException
	{
		driver.manage().window().maximize();
		loginPage page = new loginPage(driver);
		page.enterUsername("sagar_admin");
		page.enterPassword("SagarAdmin@123");
		page.clickOnLoginButton();
		 
		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		UsersPage userpage = new UsersPage(driver);
	
		userpage.enterSearchName("Manish Test");
		userpage.clickOnSearch();
		userpage.clickOnViewProfile();
		userpage.clickOnDocuments();
		userpage.clickOnClinical();
		userpage.clickOnUpload();

		userpage.enterFolderName("Rushi7");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	    
	    
		userpage.clickOnChooseFile("C:\\Users\\sanke\\Downloads\\UploadFileForUser.png");
		userpage.clickOnUploadButton();
		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
		Thread.sleep(2000);
		userpage.clickOnRushikeshFiles();
		
	}
}
