package com.EMC.PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class THOPage {
	WebDriver ldriver;

	public THOPage(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
		
	@FindBy(xpath = "(//a[@href=\"#nav-schedule-groups\"])[1]")
	WebElement THO;
	
	@FindBy(xpath = "//button[@class=\"dt-button buttons-collection btn profile-visibility-btn mr-1\"]")
	WebElement newTHO;
	
	public void newTHO() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		THO.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", newTHO);
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//select[@id=\"organization_id\"]")
	WebElement organization;
	
	public void selectOrganization(String org)
	{	
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(organization);
		select.selectByVisibleText(org);
	}
	
	@FindBy(xpath = "//select[@id=\"type\"]")
	WebElement THOType;
	
	public void selectType(String type)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(THOType);
		select.selectByVisibleText(type);
	}
	
	@FindBy(xpath = "//select[@id=\"speciality\"]")
	WebElement specialty;
	
	public void selectSpecialty(String type)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select select = new Select(specialty);
		select.selectByVisibleText(type);
	}
	
	@FindBy(xpath = "//input[@id=\"search_start_date_tho\"]")
    public	WebElement startDate;
	
	@FindBy(xpath = "(//div[@class=\"datepicker-days\"])[2]//tbody//tr[4]//td[4]")
	WebElement StartDate;
	
	public void thoStartDate() throws InterruptedException
	{
		startDate.click();
		Thread.sleep(3000);
		//StartDate.click();
	}
	
	@FindBy(xpath = "//input[@id=\"search_end_date_tho\"]")
	public WebElement endDate;
	
	@FindBy(xpath = "(//div[@class=\"datepicker-days\"])[3]//tbody//tr[5]//td[4]")
	WebElement ENDDATE;
	
	public void thoEndDate() throws InterruptedException
	{
		endDate.click();
		Thread.sleep(3000);
		//ENDDATE.click();
	}
	
	@FindBy(xpath = "//input[@id=\"number_of_visits\"]")
	public WebElement NoOfVisit;
	
	public void noOfVisits(String text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		NoOfVisit.sendKeys(text);
	}
	
	@FindBy(xpath = "//input[@id=\"units\"]")
	public WebElement Units;
	
	public void units(String text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Units.sendKeys(text);
	}
	
	@FindBy(xpath = "//button[text()=\"+ Save\"]")
	WebElement Save;
	
	public void saveTHO() throws InterruptedException
	{
		Save.click();
		Thread.sleep(5000);
	
	}
	
	@FindBy(xpath = "//a[text()=\"+ Create Schedule\"]")
	WebElement CreateSchedule;
	
	public void createSchedule() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", CreateSchedule);
		Thread.sleep(1000);
	
	}
	//button[text()="Update"]
	@FindBy(xpath = "//*[@id=\"groupedSection\"]/div/div/div/div[1]/div[2]/div/a[1]")
	WebElement EditTHO;
	
	public void editTHO() throws InterruptedException
	{
		EditTHO.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//button[text()=\"Update\"]")
	WebElement UpdateTHO;
	
	public void updateTHO() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", UpdateTHO);
	}
	
	@FindBy(xpath = "(//input[@type=\"search\"])[2]")
	WebElement schedules;
	
	public void addSchedules() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		schedules.click();
		Thread.sleep(1000);
		schedules.sendKeys(Keys.ENTER);

	}
	
	@FindBy(xpath = "//table[@class=\"hellohero-tho-table\"]//tbody//tr[1]//td[5]")
	WebElement DeleteTho;
	
	@FindBy(xpath = "//button[text()=\"Confirm\"]")
	WebElement confirm;
	
	@FindBy(xpath = "(//button[text()=\"No\"])[2]")
	WebElement NO;
	
	public void deleteTHO() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", DeleteTho);
		Thread.sleep(1000);
		confirm.click();
		Thread.sleep(1000);
		NO.click();
	}
}






