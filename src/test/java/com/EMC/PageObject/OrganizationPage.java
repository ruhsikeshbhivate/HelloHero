package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {

	WebDriver ldriver;
	public OrganizationPage(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//select[@id=\"orgSearchTitleSelect\"]")
	WebElement searchOrganization;

	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement searchButton;

	@FindBy(xpath = "//button[@id=\"CopyLinkButton-343\"]")
	WebElement copyLandingPageUrl;

	@FindBy(xpath = "//a[@class=\"phpdebugbar-close-btn\"]")
	WebElement cancel;

	@FindBy(xpath = "//*[@id=\"data-table\"]/tbody/tr/td[12]/ul/li[1]/a")
	WebElement UpdateOrg;
	
	@FindBy(xpath = "//*[@id=\"school_logging_require\"]")
	WebElement LoggingRequiredCheckBox;
	
	@FindBy(xpath = "//button[@id=\"sumbit-btn\"]")
	WebElement SubmitButton;
	
	@FindBy(xpath = "//input[@id=\"hq_sessions\"]")
	WebElement requiredCpt;
	
	public void clickOnLoggingRequiredCheckBox() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",requiredCpt);
		LoggingRequiredCheckBox.click();
		Thread.sleep(2000);
	
	}
	
		public void clickOnSubmitButton() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",SubmitButton);
		SubmitButton.click();
		Thread.sleep(1000);
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/event-list");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
	}
	
	public void clickOnUpdate()
	{
		UpdateOrg.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void selectOrganization(String Org) throws InterruptedException
	{
		Select select = new Select(searchOrganization);
		select.selectByVisibleText(Org);
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(2000);
		JavascriptExecutor executor7 = (JavascriptExecutor)ldriver;
		executor7.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		cancel.click();
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",copyLandingPageUrl);

	}

	public void selectOrganization1(String Org) throws InterruptedException
	{
		Select select = new Select(searchOrganization);
		select.selectByVisibleText(Org);
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(2000);
		JavascriptExecutor executor7 = (JavascriptExecutor)ldriver;
		executor7.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",UpdateOrg);
		
	}
	public void CopyLandingPageUrl() throws InterruptedException
	{

		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",copyLandingPageUrl);
		String openLandingPageUrl = Keys.chord(Keys.CONTROL, Keys.ENTER);
		ldriver.findElement(By.xpath("//button[@id=\"CopyLinkButton-343\"]")).sendKeys(openLandingPageUrl);
		
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/schools/landingpage?token=GNYX35uJOzqs3yBLvLJjWDPc52dJo7pvndWIMOh6TW7P4AZKUaIECY1gkVFK4FY6cS2MF8bJEYTn7vzPRgOnNRyGVFMPIcbJmS40");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
		
	}
	
	public void refreshDashboardPage() throws InterruptedException
	{
			Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(0));
		ldriver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//input[@id=\"doc_require\"]")
	WebElement DocumentRequired;
	
	@FindBy(xpath = "//select[@name=\"indirect_pay_tier\"]")
	WebElement Tier;
	
	public void selectTier(String text) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",DocumentRequired);
		Thread.sleep(1000);
		Select select = new Select(Tier);
		select.selectByVisibleText(text);
		Thread.sleep(2000);
	}
	
	public void SubmitButton() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",SubmitButton);
		SubmitButton.click();
		Thread.sleep(3000);
	}
}
