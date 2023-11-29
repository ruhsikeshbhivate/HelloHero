package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProviderManagerPage {


	WebDriver ldriver;
	
	public ProviderManagerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/provider-manager\"]")
	WebElement providerManager;
	
	@FindBy(xpath = "//button[@id=\"create_event\"]")
	WebElement newManager;
	
	@FindBy(xpath = "//select[@id=\"therapists\"]")
	WebElement selectTherapist;
	
	@FindBy(xpath = "(//input[@role=\"searchbox\"])[2]")
	WebElement searchTherapist;
	
	@FindBy(xpath = "//button[@id=\"addManager\"]")
	WebElement addProviderManager;
	
	@FindBy(xpath = "//div[@id=\"managerProviderTab\"]")
	WebElement managers_ProvidersTab;
	
	@FindBy(xpath = "//button[@id=\"create_event\"]")
	WebElement attachManager;
	
	@FindBy(xpath = "//select[@id=\"managers\"]")
	WebElement select_ProviderManager;
	
	@FindBy(xpath = "//select[@id=\"therapists\"]")
	WebElement attachTherapist;
	
	@FindBy(xpath = "//button[@id=\"attachManager\"]")
	WebElement add;
	
	@FindBy(xpath = "//select[@id=\"userSearchManagerSelect\"]")
	WebElement SearchProviderManager;
	
	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement search;
	
	public void clickOnSearch() throws InterruptedException
	{
		search.click();
		Thread.sleep(2000);
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/users");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
	}
	
	public void searchProviderManager(String text)
	{
		Select select = new Select(SearchProviderManager);
		select.selectByVisibleText(text);
	}
	
	public void clickOnAdd()
	{
		add.click();
	}
	public void selectAttachTherapist(String text)
	{
		Select select = new Select(attachTherapist);
		select.selectByVisibleText(text);
	}
	
	public void selectProviderManager(String text) throws InterruptedException
	{
		Select select = new Select(select_ProviderManager);
		select.selectByVisibleText(text);
		Thread.sleep(2000);
	}
	
	public void clickOnAttachManager() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
        js.executeScript("arguments[0].click();", attachManager);
		Thread.sleep(3000);
	}
	
	public void clickOnManagers_ProvidersTab() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
	    js.executeScript("arguments[0].click();", managers_ProvidersTab);
Thread.sleep(5000);
	}
	
	public void clickOnAddProviderManager()
	{
		addProviderManager.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	public void SelectTherapist()
	{
		selectTherapist.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		searchTherapist.click();
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(0));
	}
	
	public void SelectTherapist(String text) throws InterruptedException
	{
		Select select = new Select(selectTherapist);
		select.selectByVisibleText(text);
		Thread.sleep(1000);
	}
	
	public void SearchTherapist(Keys control)
	{
		searchTherapist.sendKeys(control);
	}
	
	public void SearchTherapist1(String control)
	{
		searchTherapist.sendKeys(control);
				
	}
	
	public void clickOnProviderManager()
	{
		providerManager.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	public void clickOnNewManager() throws InterruptedException
	{
		newManager.click();
		Thread.sleep(4000);

	}
}
