package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TherapistClientsPage {

	WebDriver driver;
	
	public TherapistClientsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Therapist_ClientsTab() throws InterruptedException
	{
		driver.get("https://stage.hellohero.com/therapist-clients");
		Thread.sleep(2000);
	}
	@FindBy(xpath = "//select[@id=\"userSearchOrgSelect\"]")
	WebElement SearchOrg;
	
	public void searchOrganization(String org) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SearchOrg);
		select.selectByVisibleText(org);
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//select[@id=\"userSearchTherapistSelect\"]")
	WebElement SelectTherapist;
	
	public void selectTherapist(String therapist)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SelectTherapist);
		select.selectByVisibleText(therapist);
	}
	
	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement Search;
	
	public void search() throws InterruptedException
	{
		Search.click();
		Thread.sleep(4000);
	}
	
	public void openTherapist_ClientPage() throws InterruptedException
	{
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://stage.hellohero.com/therapist-clients");
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		driver.switchTo().window(handles.get(1));
		Thread.sleep(2000);
	}
}
