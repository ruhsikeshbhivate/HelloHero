package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicVerificationKey;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TimesheetsPage {

	WebDriver ldriver;
	public TimesheetsPage(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement search;
	
	@FindBy(xpath = "(//a[text()=\"Missing Payout Mapping\"])[1]")
	WebElement missinngPayoutMapping;
	
	@FindBy(xpath = "//input[@placeholder=\"Organization\"]")
	WebElement SelectOrg;
	
	//@FindBy(xpath = "//select[@name=\"search_therapist_id\"]")
	@FindBy(xpath = "//span[@title=\"Search Therapist\"]")
	WebElement SearchThearapist;
	
	public void SearchTherapist()
	{
	
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",SearchThearapist);
		//SearchThearapist.click();
		//Select select = new Select(SearchThearapist);
		//select.selectByVisibleText(therpaist);
	}
	public void selectOrganization(String org) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SelectOrg.sendKeys(org);
		Thread.sleep(2000);
		Actions actions = new Actions(ldriver);
		actions.sendKeys(SelectOrg,Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

	}
	
	@FindBy(xpath = "//*[@id=\"search_form\"]/div[3]/div[10]/div/span/span[1]/span/span[2]/b")
	WebElement SelectStudent;
	
	@FindBy(xpath = "/html/body/span/span/span[1]/input[@role=\"searchbox\"]")
	WebElement enterClientName;
		
	public void selectStudent(String student) throws InterruptedException
	{	
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SelectStudent.click();
		enterClientName.sendKeys(student);
		Thread.sleep(4000);
		enterClientName.sendKeys(Keys.ENTER);
		
	}
	
	public void clickOnSearch() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		search.click();
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		executor.executeScript("arguments[0].scrollIntoView();",Adjustment);
		executor.executeScript("window.scrollBy(0,-350)", "");
				
	}
	
	public void missing_Payout_Mapping() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",missinngPayoutMapping);
		Thread.sleep(2000);
		executor.executeScript("arguments[0].click();",missinngPayoutMapping);
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
		Thread.sleep(2000);
	}
	public void refreshTimesheetPage() throws InterruptedException
	{
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(2));
		ldriver.navigate().refresh();
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "(//span[@title=\"Adjustment\"])[1]")
	WebElement Adjustment;
	
	@FindBy(xpath = "//*[@id=\"timesheetAdjustmentDetailsModal\"]/div/div/div[1]/button")
	WebElement closeAdjustment;
	
	
	public void clickOnSearchEvent() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		search.click();

		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		executor.executeScript("arguments[0].scrollIntoView();",Adjustment);
		executor.executeScript("window.scrollBy(0,-350)", "");
		Thread.sleep(1000);
		Adjustment.click();		
		Thread.sleep(4000);
		closeAdjustment.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//select[@name=\"search_therapy_id\"]")
	WebElement SearchTherapy;
	
	public void searchTherapy(String Therapy)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SearchTherapy);
		select.selectByVisibleText(Therapy);
	}
}
