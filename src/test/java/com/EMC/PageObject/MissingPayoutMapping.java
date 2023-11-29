package com.EMC.PageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MissingPayoutMapping {
	WebDriver ldriver;

	public MissingPayoutMapping(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//select[@id=\"rate\"]")
	WebElement rate;
	
	public void selectRate(String Rate)
	{
		Select select = new Select(rate);
		select.selectByVisibleText(Rate);
	}
	
	@FindBy(xpath = "//button[@id=\"payoutbtn_Add\"]")
	WebElement Add;
	
	public void AddPayout() throws InterruptedException
	{
		Add.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//select[@id=\"minutes\"]")
	WebElement SELECTMinute;
	
	public void selectMinute(String Text)
	{
		Select select = new Select(SELECTMinute);
		select.selectByVisibleText(Text);
	}
	
	@FindBy(xpath = "//input[@type=\"search\"]")
	WebElement searchPayout;
	
	public void SearchPayout(String Text) throws InterruptedException
	{
		ldriver.navigate().refresh();
		Thread.sleep(5000);
		searchPayout.sendKeys(Text);
		Thread.sleep(6000);
		
	}
	
	public void refreshPayoutPage() throws InterruptedException
	{		
		
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
			
	}
	
	public void refreshTimeSheetsPage() throws InterruptedException
	{		
		
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(0));
		ldriver.navigate().refresh();
		Thread.sleep(3000);
			
	}
	
	@FindBy(xpath = "//button[@id=\"getDeleteId\"]")
	WebElement DeletePayout;
	
	@FindBy(xpath = "//button[text()=\"Yes, delete it!\"]")
	WebElement YesDeleteIt;
	
	public void deletePayout() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", DeletePayout);
		Thread.sleep(1000);
		executor.executeScript("arguments[0].click();", YesDeleteIt);

	}
	
}
