package com.EMC.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TC_CreateProviderManger_CompareUser extends BaseClass{
	
	public void CreateProviderManger_CompareUser() throws InterruptedException
	{
        driver.manage().window().maximize();
		
		WebElement Username = driver.findElement(By.xpath("//input[@id=\"login\"]"));
		Username.sendKeys("sagar_admin");
		
		WebElement Password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		Password.sendKeys("SagarAdmin@123");
		
		WebElement LoginButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
		LoginButton.click();
		
		WebElement Users = driver.findElement(By.xpath("//span[text()=\"Users\"]"));
		Users.click();
		
		WebElement providerManagertab = driver.findElement(By.xpath("//a[@href=\"https://stage.hellohero.com/provider-manager\"]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", providerManagertab);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		
		WebElement NewManager = driver.findElement(By.xpath("//button[text()=\"+ New Manager\"]"));
		NewManager.click();
		
		Thread.sleep(4000);
		WebElement selectTherapist = driver.findElement(By.xpath("Leoma Towne"));
		selectTherapist.click();
		
		WebElement searchTherapist = driver.findElement(By.xpath("(//input[@role=\"searchbox\"])[2]"));
		searchTherapist.click();
		searchTherapist.sendKeys("");
		
		searchTherapist.sendKeys(Keys.ENTER);
		
		WebElement add = driver.findElement(By.xpath("//button[@id=\"addManager\"]"));
		add.click();
		
		WebElement Manager_Providers = driver.findElement(By.xpath("//div[@id=\"managerProviderTab\"]"));
		Manager_Providers.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		

		
		WebElement AttachManager = driver.findElement(By.xpath("//button[text()=\"Attach Manager\"]"));
		AttachManager.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		
		WebElement searchProviderManger = driver.findElement(By.xpath("(//span[@role=\"presentation\"])[3]"));
		searchProviderManger.click();
		Thread.sleep(1000);
		WebElement selectProviderManger = driver.findElement(By.xpath("(//input[@role=\"searchbox\"])[2]"));
		selectProviderManger.sendKeys("Leoma Towne");
		selectProviderManger.sendKeys(Keys.ENTER);
		
		WebElement TherapistName = driver.findElement(By.xpath("//input[@placeholder=\"Select Therapists\"]"));
		TherapistName.sendKeys("");
		TherapistName.sendKeys(Keys.ENTER);
		
		WebElement AddAttachManger = driver.findElement(By.xpath("//button[@id=\"attachManager\"]"));
		AddAttachManger.click();
	}

}
