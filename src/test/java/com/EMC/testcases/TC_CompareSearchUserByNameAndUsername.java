package com.EMC.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_CompareSearchUserByNameAndUsername extends BaseClass{

	@Test
	public void compareSearchUserByNameAndUsername() throws InterruptedException
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

	
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnSearch();

		WebElement DataTableLength = driver.findElement(By.xpath("//select[@name=\"data-table_length\"]"));
		Select select = new Select(DataTableLength);
		select.selectByVisibleText("1,000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	

		WebElement UsersDataTableFilter = driver.findElement(By.xpath("//*[@id=\"data-table_filter\"]/label/input"));
		UsersDataTableFilter.sendKeys("RushikeshBhivate");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id=\"data-table\"]//tbody//tr"));
		int NoOfRows = rowCount.size();
		System.out.println("Total Rows: " + NoOfRows);

			
		for(int i=1;i<=NoOfRows;i++)
		{
						
			System.out.println(i+" : ");
		
				WebElement Value =driver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr/td[2]"));
				String Name = Value.getText();
				System.out.println("Name: " + Name);		

				WebElement Value1 =driver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr/td[3]"));
				String Username = Value1.getText();
				System.out.println("Username: " + Username);	
				
				if (Name.contains("RushikeshBhivate") == true || Username.contains("RushikeshBhivate")==true) {

					System.out.println("=> Result is getting correct.....");
				}

				else {
					System.out.println("=> Result is getting wrong.....");
				}
				
				System.out.println("----------------------------------------------------------------");

		}
	}
}
