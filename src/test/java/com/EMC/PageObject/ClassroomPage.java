package com.EMC.PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v112.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClassroomPage {

	WebDriver driver;

	public ClassroomPage(WebDriver driver)
	{
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@id=\"orgSearchTitleSelect\"]")
	WebElement Organization;
	
	public void SelectOrganization(String org)
	{
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(Organization);
		select.selectByVisibleText(org);
	}
	
		
	@FindBy(xpath = "//b[@role=\"presentation\"]")
	WebElement owner;
	
	@FindBy(xpath = "//select[@id=\"ownerSearchSelect\"]")
	WebElement SelectOwner;
	
	public void selectOwner(String Text) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SelectOwner);
		select.selectByVisibleText(Text);
	}
	
	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement Search;
	
	public void search() throws InterruptedException
	{
		Search.click();
		Thread.sleep(4000);
	}
	
	@FindBy(xpath = "//span[@title=\"Manage student\"]")
	WebElement ManageStudent;
	
	public void ManageStudent() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",ManageStudent);
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "(//span[@title=\"Archive\"])[1]")
	WebElement ArchiveStudent;
	
	public void archiveStudent() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",ArchiveStudent);
		Thread.sleep(4000);
	}
	
	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement ArchiveReason;
	
	public void archiveReason(String text) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ArchiveReason.sendKeys(text);
	}
	
	@FindBy(xpath = "//button[@id=\"SubmitDeleteForm\"]")
	WebElement SubmitReason;
	
	public void submitReason() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SubmitReason.click();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//a[@id=\"-tab\"]")
	WebElement ArchiveStudentlist;
	
	public void archiveStudentlist() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",ArchiveStudentlist);
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//button[@title=\"Archive\"]")
	WebElement Unarchive;
	
	public void unarchive() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",Unarchive);
	}
}
