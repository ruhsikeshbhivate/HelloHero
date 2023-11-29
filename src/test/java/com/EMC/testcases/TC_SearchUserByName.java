package com.EMC.testcases;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_SearchUserByName extends BaseClass {
	
	@Test
	public void verfiySearchUserByName() throws InterruptedException
	{
		
		driver.manage().window().maximize();		
		
		// Login By Administrator....
		
		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();
		
		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		
		// Create User.....
		
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnSearch();
		//usersPage.usersDataTablefilter("Rushikeshbhivate");
		
		WebElement DataTableLength = driver.findElement(By.xpath("//select[@name=\"data-table_length\"]"));
		Select select = new Select(DataTableLength);
		select.selectByVisibleText("1,000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
				
		WebElement UsersDataTableFilter = driver.findElement(By.xpath("//*[@id=\"data-table_filter\"]/label/input"));
		UsersDataTableFilter.sendKeys("Ketan");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id=\"data-table\"]//tbody//tr"));
		int NoOfRows = rowCount.size();
		System.out.println(NoOfRows);
		
		List<WebElement> columnCount = driver.findElements(By.xpath("//table[@id=\"data-table\"]//tbody//tr[1]//td[2]"));
		int NoOfColumns = columnCount.size();
		System.out.println("Number of Columns: " +NoOfColumns); 
		
		for(int i=1;i<=NoOfRows;i++)
		{
			System.out.print(i+" : ");
			
			
			for(int j=1;j<=NoOfColumns;j++)
			{
				WebElement Value =driver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[2]"));
				String Name = Value.getText();
				System.out.println(Name);		

								
				if (Name.contains("Ketan") == true) {
					
					System.out.println("Result is getting correct.....");
				}
				
				else {
					System.out.println("Result is getting wrong.....");
				}
			}
			
		}
	}

		
}
