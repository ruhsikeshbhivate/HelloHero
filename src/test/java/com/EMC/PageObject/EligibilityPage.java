package com.EMC.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EligibilityPage {

	WebDriver ldriver;

	//constructor
	public EligibilityPage(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@href=\"#nav-submitted\"]")
	WebElement Submitted;
	
	@FindBy(xpath = "//select[@id=\"userEligibilitySearchName\"]")
	WebElement SelectUser;
	
	@FindBy(xpath = "//button[@id=\"btnFilterSubmitSearch\"]")
	WebElement search;
	
	public void SelectUser(String user) throws InterruptedException
	{
		Select select = new Select(SelectUser);
		select.selectByVisibleText(user);
		Thread.sleep(4000);
	}
	
	public void clickOnSubmitted()
	{
		Submitted.click();
	}
	
	public void clickOnSearch()
	{
		search.click();
	}
}
