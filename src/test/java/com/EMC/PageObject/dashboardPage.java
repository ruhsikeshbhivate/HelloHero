package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import scala.compiletime.ops.string;

public class dashboardPage {


	WebDriver ldriver;

	//constructor
	public dashboardPage(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

		
	@FindBy(xpath = "(//button[text()='Run Tech Check'])[1]")
	WebElement profileName;
	
	@FindBy(xpath = "//span[text()='Scheduling']")
	WebElement Scheduling;
	
	@FindBy(xpath = "(//a[@href=\"https://stage.hellohero.com/schedule-list\"])[1]")
	WebElement Schedules;
	
	@FindBy(xpath = "(//a[@href=\"https://stage.hellohero.com/event-list\"])[1]")
	WebElement Events;
	
	@FindBy(xpath = "//a[@onclick=\"addReferral()\"]")
	WebElement AddReferral;
	
	@FindBy(xpath = "//span[text()='Finance']")
	WebElement Finance;
			
	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/user-eligibility\"]")
	WebElement Eligibility;
	
	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/event\"]")
	WebElement Calendar;
	
	@FindBy(xpath = "//span[text()=\"Users\"]")
	WebElement Users;
	
	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/users\"]")
	WebElement UserSearch;
	
	@FindBy(xpath = "(//a[@id=\"navbarDropdown\"])[4]")
	WebElement profileThumb;
	
	@FindBy(xpath = "(//a[@onclick=\"resetLocalValue()\"])[2]")
	WebElement signOut;
	
	@FindBy(xpath = "//span[text()='Administration']")
	WebElement Administration;
	
	@FindBy(xpath = "//span[text()='Organizations']")
	WebElement organizations;
	
	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/organizations\"]")
	WebElement organization;
	
	@FindBy(xpath = "//a[@class=\"phpdebugbar-close-btn\"]")
	WebElement closeButton;
	
	@FindBy(xpath = "(//a[@href=\"https://stage.hellohero.com/logging/missing\"])[2]")
	WebElement loggingNotCompleted;
	
	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/referrals\"]")
	WebElement Referral;
	
	public void clickOnReferral() throws InterruptedException
	{
		ldriver.get("https://stage.hellohero.com/referrals");
		Thread.sleep(2000);
	}
	public void clickOnCloseButton()
	{
		closeButton.click();
	}
	
		public void clickOnCalendar()
	{
		Calendar.click();
	}
	
	public void clickOnUserSearch() throws InterruptedException
	{		
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",UserSearch);

	}
	
	public void clickOnUsers()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",Users);

	}
	
	public void clickOnAdministration()
	{
		
		Administration.click();
	}
	
	public String getProfileName()
	{
		String text = profileName.getText();
		return text;
	}
	
	public void clickOnScheduling()
	{
		Scheduling.click();
	}
	
	public void clickOnProfileThumb() throws InterruptedException
	{
		profileThumb.click();
		Thread.sleep(2000);
	}
	
	public void clickOnSignOut() throws InterruptedException
	{

		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",signOut);
		Thread.sleep(1000);
		ldriver.navigate().refresh();
		Thread.sleep(2000);

	}
	
	public void clickOnSchedules()
	{
		Schedules.click();
	}
	
	public void clickOnEvents() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",Events);
		Thread.sleep(2000);
	}
	
	public void clickOnAddReferral()
	{
		AddReferral.click();
	}
	
	public void clickOnFinance() throws InterruptedException
	{
		Finance.click();
		Thread.sleep(2000);
	}
	
	public void clickOnOrganization() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",organizations);
		Thread.sleep(1000);
		organization.click();

	}
	
	public void clickOnEligibilty() throws InterruptedException
	{
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/user-eligibility");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
	}
	
	public void loggingNotCompleted() throws InterruptedException
	{
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(3));
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		loggingNotCompleted.click();
		Thread.sleep(2000);
		ldriver.switchTo().window(handles.get(1));

	}
	
	@FindBy(xpath = "(//img[@class=\"hellohero_profile_thumb header-icon\"])[5]")
	WebElement ProfileName;
	
	public void clickONprofile()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",ProfileName);
	}
	
	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/timesheets\"]")
	WebElement TimeSheets;
	
	public void timesheets() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",TimeSheets);
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "(//button[text()=\"Dismiss\"])[2]")
	WebElement Dismiss;
	
	public void dismiss()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",Dismiss);
	}
	
	@FindBy(xpath = "(//a[@href=\"https://stage.hellohero.com/detach_user_request\"])[2]")
	WebElement DetachUserRequestTab;
	
	public void deatchUserRequestTab()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",DetachUserRequestTab);
	}
	
	@FindBy(xpath = "//select[@id=\"therapistSearchSelect\"]")
	WebElement SearchUserByTherapist;
	
	public void searchUserBytherapist(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(SearchUserByTherapist);
		select.selectByVisibleText(Text);
	}
	
	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement SearchUserRequest;
	
	public void searchUserRequest() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",SearchUserRequest);
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "(//b[@role=\"presentation\"])[2]")
	WebElement ClickDrop;
	
	@FindBy(xpath = "//input[@role=\"searchbox\"]")
	WebElement SearchStudent;
	
	public void searchStudent(String ID) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ClickDrop.click();
		Thread.sleep(1000);
		SearchStudent.sendKeys(ID);
		SearchStudent.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

	}
	
	@FindBy(xpath = "//button[text()=\"Approve\"]")
	WebElement ApproveRequest;
	
	public void approveRequest() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",ApproveRequest);
		Thread.sleep(4000);
	}
	
	@FindBy(xpath = "//button[text()=\"Deny\"]")
	WebElement DenyRequest;
	
	public void denyRequest() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",DenyRequest);
		Thread.sleep(4000);
	}
	
	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/organization-classroom\"]")
	WebElement Classroom;
	
	public void classroom() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ldriver.get("https://stage.hellohero.com/organization-classroom");
		Thread.sleep(2000);
	}
}
