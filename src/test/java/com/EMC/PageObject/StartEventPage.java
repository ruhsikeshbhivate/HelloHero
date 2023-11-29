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
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

public class StartEventPage {
	
	WebDriver ldriver;

	public StartEventPage(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//select[@name=\"event_status_id[]\"]")
	WebElement selectEventStatus;
	
	@FindBy(xpath = "//button[text()='Yes, please!']")
	WebElement confirmStatusPopup;
	
	@FindBy(xpath = "//a[@title=\"View Profile\"]")
	WebElement viewProfile;
	
	@FindBy(xpath = "//i[@class=\"fas fa-link name\"]")
	WebElement documentInternalLink;
	
	@FindBy(xpath = "//textarea[@id=\"reason_for_screen\"]")
	WebElement reasonForScreen;
	
	@FindBy(xpath = "//textarea[@id=\"caregiver_comments\"]")
	WebElement teacherComments;
	
	@FindBy(xpath = "//input[@value=\"Informal Observation\"]")
	WebElement toolsUsed;
	
	@FindBy(xpath = "(//div[@role=\"textbox\"])[1]")
	WebElement fineMotor;
	
	@FindBy(xpath = "(//div[@role=\"textbox\"])[2]")
	WebElement grossMotor;
	
	@FindBy(xpath = "(//input[@name=\"recommendations[]\"])[1]")
	WebElement recomendations;
	
	@FindBy(xpath = "//canvas[@name=\"signature-pad\"]")
	WebElement signature;
	
	@FindBy(xpath = "//button[@id=\"save_form_btn\"]")
	WebElement submitDocument;
	
	@FindBy(xpath = "//a[text()='change']")
	WebElement changeDocument;
	
	@FindBy(xpath = "//i[@class=\"fas fa-external-link-alt\"]")
	WebElement documentExternalLink;
	
	@FindBy(xpath = "//button[@id=\"edit_digital_form\"]")
	WebElement Edit;
	
	@FindBy(xpath = "//i[@class=\"fas fa-download\"]")
	WebElement downloadDocument;
	
	@FindBy(xpath = "//button[@id=\"edit_occupationaltherapy_form_btn\"]")
	WebElement submitDocument1;
	
	@FindBy(xpath = "//input[@name=\"session_length[]\"]")
	WebElement sessionLength;
	
	@FindBy(xpath = "//button[text()='Yes, please!']")
	WebElement yesPlease;
	
	@FindBy(xpath = "//input[@name=\"school_logging\"]")
	WebElement SchoolLoggingCheckbox;
	
	@FindBy(xpath = "(//input[@type=\"radio\"])[1]")
	WebElement eventStatusYes;
	
	@FindBy(xpath = "//select[@id=\"status-options\"]")
	WebElement SelectStatus;
	
	@FindBy(xpath = "//button[@id=\"status_submit\"]")
	WebElement StatusSubmit;
	
	@FindBy(xpath = "//input[@name=\"session_length[]\"]")
	WebElement TimeSpent;
	 
	@FindBy(xpath = "//select[@id=\"status-options\"]")
	WebElement SelectStatus1;
	
	public void selectStatus1(String STATUS) throws InterruptedException
	{
		Select select = new Select(SelectStatus1);
		select.selectByVisibleText(STATUS);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void enterTimeSpent(String time)
	{
		TimeSpent.sendKeys(time);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	public void clickOnStatusSubmit() throws InterruptedException
	{
		StatusSubmit.click();
		Thread.sleep(2000);
	}
	public void selectStatus(String STATUS)
	{
		Select select = new Select(SelectStatus);
		select.selectByVisibleText(STATUS);
	}
	public void clickOnYes() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",eventStatusYes);
		
		Thread.sleep(3000);
	}
	public void clickOnSchoolLoggingCheckbox()
	{
		SchoolLoggingCheckbox.click();
	}
	public void SelectEventStatus(String eventstatus) throws InterruptedException
	{
		Select status = new Select(selectEventStatus);
		status.selectByVisibleText(eventstatus);
		Thread.sleep(2000);
	}
	
	public void clickOnConfirmPopup() throws InterruptedException
	{
		confirmStatusPopup.click();
		Thread.sleep(4000);
		ldriver.navigate().refresh();
	}
	
	public void clickOnViewProfile()
	{
		viewProfile.click();
	}
	
	public void clickOnDocumentInternalLink() throws InterruptedException
	{
		documentInternalLink.click();
		Thread.sleep(3000);
	}
	
	public void enterReasonForScreen(String reason)
	{
		reasonForScreen.sendKeys(reason);
	}
	
	public void enterTeacherComments(String comments)
	{
		teacherComments.sendKeys(comments);
	}
	
	public void enterFineMotor(String reason)
	{
		fineMotor.sendKeys(reason);
	}
	
	public void clickOnRecommendations()
	{
		recomendations.click();
	}
	
	public void clickOnToolsUsed() throws InterruptedException
	{
		toolsUsed.click();
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",grossMotor);
		Thread.sleep(1000);
		executor.executeScript("arguments[0].scrollIntoView();",submitDocument);
		Thread.sleep(1000);
	}
	
	public void enterGrossMotor(String reason)
	{
		grossMotor.sendKeys(reason);
	}
	
	public void clickOnSignature()
	{
		signature.click();
		signature.click();
	}
	
	public void clickOnSubmitDocument() throws InterruptedException
	{
		submitDocument.click();
		Thread.sleep(4000);
	}
	
	public void clickOnChangeDoucment() throws InterruptedException
	{
		changeDocument.click();
		Thread.sleep(2000);
	}
	
	public void clickOnExternalDocumentLinks() throws InterruptedException
	{
		documentExternalLink.click();
		Thread.sleep(2000);
		
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
		ldriver.manage().window().maximize();
	}
	
	public void clickOnEdit() throws InterruptedException
	{
		Edit.click();
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}
	
	public void clickSubmitDocument1() throws InterruptedException
	{
		submitDocument1.click();
		Thread.sleep(3000);
	}
	public void clickOnDocumentDownload()
	{
		downloadDocument.click();
	}
	
	public void clickOnSelectStatus() throws InterruptedException
	{
		selectEventStatus.click();
		Thread.sleep(3000);
	}
	
	public void enterSessionLength(String length) throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		sessionLength.sendKeys(length);
		Thread.sleep(1000);
	}
	
	public void clickOnYesPlease() throws InterruptedException
	{
		yesPlease.click();
		Thread.sleep(2000);
		ldriver.switchTo().newWindow(WindowType.TAB);
		ldriver.get("https://stage.hellohero.com/timesheets");
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(2));
		Thread.sleep(2000);

	}
	
	public void goToStartEventPage()
	{
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
	}
	
	public void refreshStartEventPage() throws InterruptedException
	{
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
		ldriver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "(//button[@onclick=\"closeDocumentModal('edit_casenote_modal')\"])[1]")
	WebElement closeForm;
	
	public void clickOnCloseForm()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		closeForm.click();
	}
	
	@FindBy(xpath = "//button[text()=\"OK\"]")
	WebElement Ok;
	
	public void clickOnOk() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Ok.click();
		Thread.sleep(1000);
		ldriver.navigate().back();
		Thread.sleep(6000);
	}
	
	@FindBy(xpath = "//a[@title=\"View Profile\"]")
	WebElement ViewUserProfile;
	
	public void viewUserProfile() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		executor.executeScript("arguments[0].click();", ViewUserProfile);
		Thread.sleep(1000);
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
		Thread.sleep(3000);
	}
	public void clickOnExternalDocumentLinks1() throws InterruptedException
	{
		documentExternalLink.click();
		Thread.sleep(2000);
		
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(2));
		ldriver.manage().window().maximize();
	}
		
	public void tab1() throws InterruptedException
	{
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(0));
		Thread.sleep(1000);
		ldriver.navigate().refresh();
		Thread.sleep(3000);
	}
	
	public void tab2() throws InterruptedException
	{
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
		Thread.sleep(1000);
	}
	
	public void clickOnYesPlease1() throws InterruptedException
	{
		yesPlease.click();
		Thread.sleep(3000);
		
	}
}

