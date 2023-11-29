package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

public class Schedule_SubtypesPage {
	WebDriver ldriver;
	public Schedule_SubtypesPage(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	public void openSchedule_SubtypesPage() throws InterruptedException
	{
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/schedule-subtypes");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
		Thread.sleep(2000);
	}
	
	public void schedule_SubtypesTab() throws InterruptedException
	{
		ldriver.get("https://stage.hellohero.com/schedule-subtypes");
		Thread.sleep(3000);
	}
	@FindBy(xpath = "//*[@id=\"data-table_filter\"]/label/input[@type=\"search\"]")
	WebElement SearchScheduleSubtypes;
	
	public void searchSchedule_Subtypes(String Type) throws InterruptedException
	{
		SearchScheduleSubtypes.sendKeys(Type);
		Thread.sleep(4000);
	}
	
	@FindBy(xpath = "//a[text()=\"Update\"]")
	WebElement Update;
	
	public void update() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();", Update);
		Thread.sleep(1000);
		executor.executeScript("arguments[0].click();", Update);
	}
	
	@FindBy(xpath = "//input[@id=\"is_non_billable\"]")
	WebElement ExcludeFromBillingCheckbox;
	
	public void excludeFromBillingCheckbox() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ExcludeFromBillingCheckbox.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//input[@id=\"exclude_from_timesheets\"]")
	WebElement ExcludeFromTimesheetsCheckbox;
	
	public void excludeFromTimesheetsCheckbox() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ExcludeFromTimesheetsCheckbox.click();
		Thread.sleep(1000);

	}
	
	@FindBy(xpath = "(//button[@id=\"card-button\"])[2]")
	WebElement Submit;
	
	public void submit() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();", Submit);
		Thread.sleep(1000);
		executor.executeScript("arguments[0].click();", Submit);
		Thread.sleep(3000);
	}
	
	public void tab1() throws InterruptedException
	{
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(0));
		Thread.sleep(2000);
	}
	
	public void tab2() throws InterruptedException
	{
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
		Thread.sleep(1000);
		ldriver.navigate().refresh();
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//input[@id=\"allow_bulk_creation\"]")
	WebElement AddBulkCreationCheckbox;
	
	
	public void addBulkCreationCheckbox()
	{
		AddBulkCreationCheckbox.isSelected();
		System.out.println("Add Bulk Creation Checkbox is Check : " + AddBulkCreationCheckbox.isSelected());
	}
}
