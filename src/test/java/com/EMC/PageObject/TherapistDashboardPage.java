package com.EMC.PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

public class TherapistDashboardPage {

	WebDriver ldriver;

	public TherapistDashboardPage(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/add-event/0/meeting\"]")
	WebElement Meeting;
	
	public void clickOnMeeting() throws InterruptedException
	{
		Meeting.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "(//img[@src=\"https://stage.hellohero.com/profile/image/30317\"])[4]")
	WebElement ProfileName;
	
	public void clickOnProfileName()
	{
		ProfileName.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@FindBy(xpath = "(//a[@onclick=\"resetLocalValue()\"])[2]")
	WebElement signOut;
	
	public void clickOnSignOut() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", signOut);
		Thread.sleep(2000);
		ldriver.navigate().refresh();
	}
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div[4]/a")
	WebElement JoinNow;
	
	public void joinNow() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JoinNow.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//span[text()=\"Dashboard\"]")
	WebElement Dashboard;
	
	public void dashboard() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", Dashboard);
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "(//*[@id=\"navbarDropdown\"])[3]")
	WebElement profilName;
	
	public void profilName() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",profilName);
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "(//*[@id=\"navbarDropdown\"])[4]")
	WebElement TherapistProfileThumb;
	
	public void therapistProfileThumb() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",TherapistProfileThumb);
		Thread.sleep(1000);
	}
}
