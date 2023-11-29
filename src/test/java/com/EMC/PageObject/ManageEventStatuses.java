package com.EMC.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageEventStatuses {

	WebDriver ldriver;
	
	public ManageEventStatuses(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/manage_event_statuses/create\"]")
	WebElement addEventStatuses;
	
	@FindBy(xpath = "//select[@id=\"schedule_type_id\"]")
	WebElement scheduleType;
	
	@FindBy(xpath = "//select[@id=\"schedule_subtype_id\"]")
	WebElement scheduleSubType;
	
	@FindBy(xpath = "//select[@id=\"event_status_id\"]")
	WebElement eventStatuses;
	
	@FindBy(xpath = "(//button[@id=\"card-button\"])[2]")
	WebElement submit;
	
	public void clickOnAddEventStatuses()
	{
		addEventStatuses.click();
	}
	
	public  void selectScheduleType(String type) throws InterruptedException
	{
		Select select = new Select(scheduleType);
		select.selectByVisibleText(type);
		Thread.sleep(2000);
	}
	
	public  void selectEventStatuses(String status)
	{
		Select select = new Select(eventStatuses);
		select.selectByVisibleText(status);
		
	}
	
	public  void selectScheduleSubType(String type)
	{
		Select select = new Select(scheduleSubType);
		select.selectByVisibleText(type);
	}
	
	public void clickOnsubmit() throws InterruptedException
	{
		submit.click();
		Thread.sleep(3000);
	}
}
