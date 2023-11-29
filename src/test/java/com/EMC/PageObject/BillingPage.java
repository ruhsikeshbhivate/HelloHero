package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.bouncycastle.asn1.mozilla.PublicKeyAndChallenge;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillingPage{

	WebDriver ldriver;

	public BillingPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@href=\"https://stage.hellohero.com/billing\"]")
	WebElement Billing;

	@FindBy(xpath = "//select[@name=\"billing_category\"]")
	WebElement BillingCategory;

	@FindBy(xpath = "//a[@href=\"#nav-invoice\"]")
	WebElement ReadyForInvoice;

	@FindBy(xpath = "//select[@id=\"organization_id\"]")
	WebElement OrganizationDrop;

	public void clickOnBilling()
	{	
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", Billing);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	public void selectBillingCategory(String type)
	{
		Select Category = new Select(BillingCategory);
		Category.selectByVisibleText(type);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void clickOnReadyForInvoice() throws InterruptedException
	{
		ReadyForInvoice.click();
		Thread.sleep(3000);
	}

	public void clickOnOrganizationDrop(String org) throws InterruptedException
	{
		Select organization = new Select(OrganizationDrop);
		organization.selectByVisibleText(org);
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement Search;

	public void search() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Search.click();
		Thread.sleep(4000);
	}

	@FindBy(xpath = "(//span[@title=\"Adjustment\"])[1]")
	WebElement Adjustment;

	@FindBy(xpath = "//*[@id=\"billingAdjustmentDetailsModal\"]/div/div/div[1]/button")
	WebElement closeAdjustment;

	public void adjustments() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollBy(0, 200)", "");
		Thread.sleep(1000);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		executor.executeScript("arguments[0].scrollIntoView();", Adjustment);
		Adjustment.click();
		Thread.sleep(4000);
		closeAdjustment.click();

	}

	@FindBy(xpath = "(//a[text()=\"Missing Digital Form\"])[1]")
	WebElement missingDocument;
	
	@FindBy(xpath = "//i[@id=\"getParticipantId\"]")
	WebElement uploadManualFile;
	
	@FindBy(xpath = "//input[@name=\"upload_file\"]")
	WebElement chooseFile;
	
	@FindBy(xpath = "//button[@id=\"import_button\"]")
	WebElement UploadButton;
			
	public void MissingDigitalDocument(String text) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		boolean text2 = missingDocument.isDisplayed();
		
		if (text2 == true) 
		{
			Thread.sleep(2000);
			executor.executeScript("arguments[0].click();", missingDocument);
			Set<String> windowHandles = ldriver.getWindowHandles();
			List<String> handles = new ArrayList<String>();
			handles.addAll(windowHandles);
			ldriver.switchTo().window(handles.get(1));
			ldriver.navigate().refresh();
			Thread.sleep(2000);
			uploadManualFile.click();
			ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		    chooseFile.sendKeys(text);
			ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			UploadButton.click();
			ldriver.switchTo().window(handles.get(0));
			ldriver.navigate().refresh();
			Thread.sleep(4000);
   

		}
		else
		{
			System.out.println("No missing document Isuue");
		}
	}

	private void selectFile() {
		// TODO Auto-generated method stub
		
	}

	@FindBy(xpath = "//table[@id=\"review_table\"]//tbody//tr[1]//td[3]")
	WebElement FirstRow;
	
	public void search2() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Search.click();
		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();", FirstRow);
	}
	
	public void VerifyUser()
	{
		String ClientName = FirstRow.getText();
		System.out.println("Billing Page-Client Name : " + ClientName);
		
	}
	
	@FindBy(xpath = "(//a[text()=\"Missing Payer Page\"])[1]")
	WebElement Missing_Payer_Page;
	
		
	public void missing_Payer_Page() throws InterruptedException
	{
		Thread.sleep(1000);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", Missing_Payer_Page);
		
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
		ldriver.navigate().refresh();
		Thread.sleep(2000);

	}
	
	@FindBy(xpath = "//select[@id=\"payment_type_id\"]")
	WebElement PaymentType;
	
	public void paymentType(String Type)
	{
		Select select = new Select(PaymentType);
		select.selectByVisibleText(Type);
	}
	
	@FindBy(xpath = "//select[@id=\"rate\"]")
	WebElement Rate;
	
	public void selectRate(String Type) throws InterruptedException
	{
		Select select = new Select(Rate);
		select.selectByVisibleText(Type);
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//select[@id=\"minutes\"]")
	WebElement Minutes;
	
	public void selectMinutes(String Type) throws InterruptedException
	{
		Select select = new Select(Minutes);
		select.selectByVisibleText(Type);
		
	}
	
	@FindBy(xpath = "//input[@id=\"amount\"]")
	WebElement Amount;
	
	@FindBy(xpath = "//button[@id=\"payerbtn_Add\"]")
	WebElement AddPayerPage;
	
	public void addPayerPage() throws InterruptedException
	{
		
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		AddPayerPage.click();	
		Thread.sleep(6000);
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(0));
		ldriver.navigate().refresh();
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//select[@id=\"search_type_id\"]")
	WebElement SearchType;
	
	public void search_Type(String Type) throws InterruptedException
	{
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(1));
		ldriver.navigate().refresh();
		Thread.sleep(4000);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Select select = new Select(SearchType);
		select.selectByVisibleText(Type);
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//select[@id=\"search_subtype_id\"]")
	WebElement SearchSubType;
	
	public void search_SubType(String Type) throws InterruptedException
	{
		Select select = new Select(SearchSubType);
		select.selectByVisibleText(Type);
	}
	
	@FindBy(xpath = "//select[@id=\"search_therapy_id\"]")
	WebElement SearchTherapy;
	
	public void search_Therapy(String Type) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Select select = new Select(SearchTherapy);
		select.selectByVisibleText(Type);
	}
	
	@FindBy(xpath = "//select[@id=\"search_event_status_id\"]")
	WebElement SearchStatus;
	
	public void search_Status(String Type) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Select select = new Select(SearchStatus);
		select.selectByVisibleText(Type);
	}
		
	@FindBy(xpath = "//select[@id=\"search_event_status_id\"]")
	WebElement SearchRate;
	
	public void search_Rate(String Type) throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Select select = new Select(SearchRate);
		select.selectByVisibleText(Type);
	}
	
	@FindBy(xpath = "//button[@id=\"btnFiterSubmitSearch\"]")
	WebElement FilterPayerPage;
	
	public void filterPayerPage() throws InterruptedException
	{
		FilterPayerPage.click();	
		Thread.sleep(7000);
	}
	
	@FindBy(xpath = "(//button[@id=\"getDeleteId\"])[1]")
	WebElement DeletePayerPage;
	
	@FindBy(xpath = "//button[text()=\"Yes, delete it!\"]")
	WebElement YesDeleteIt;
	
	public void deletePayerPage() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();", DeletePayerPage);
		Thread.sleep(2000);

		executor.executeScript("arguments[0].click();", DeletePayerPage);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		executor.executeScript("arguments[0].click();", YesDeleteIt);
	}
	
	public void search3() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Search.click();
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollBy(0, 400)","");
		Thread.sleep(2000);
	}
	
}
