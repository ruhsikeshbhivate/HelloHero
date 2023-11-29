package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DailyTeachingTaskDocument {

	WebDriver ldriver;
	
	public DailyTeachingTaskDocument(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@value=\"IEP Meeting\"]")
	WebElement IepMeeting;
	
	public void clickOnIepMeeting()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();", SubmitDocument);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		IepMeeting.click();
	}
	
	@FindBy(xpath = "//input[@value=\"Classroom Material Prep\"]")
	WebElement ClassrromMaterialPrep;
	
	public void clickOnClassrromMaterialPrep()
	{
		ClassrromMaterialPrep.click();
	}
	
	@FindBy(xpath = "//input[@value=\"Documentation For School\"]")
	WebElement DocumentationForSchool;
	
	public void clickOnDocumentationForSchool()
	{
		DocumentationForSchool.click();
	}
	
	@FindBy(xpath = "//input[@value=\"Lesson Planning\"]")
	WebElement LessionPlanning;
	
	public void clickOnLessionPlanning()
	{
		LessionPlanning.click();
	}
	
	@FindBy(xpath = "//textarea[@name=\"other_information\"]")
	WebElement OtherInformation;
	
	public void enterOtherInformation(String Text)
	{
		OtherInformation.sendKeys(Text);
	}
	
	@FindBy(xpath = "//canvas[@name=\"signature-pad\"]")
	WebElement Signature;
	
	public void enterSignature()
	{
		Signature.click();
	}
	
	@FindBy(xpath = "//button[@id=\"save_form_btn\"]")
	WebElement SubmitDocument;
	
	public void clickOnSubmitDocument() throws InterruptedException
	{
		SubmitDocument.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//button[@id=\"edit_daily_teaching_form_btn\"]")
	WebElement submitDocumentFromExternalLink;
	
	public void clickOnsubmitDocumentFromExternalLink() throws InterruptedException
	{
		submitDocumentFromExternalLink.click();
		Thread.sleep(2000);
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(0));
		Thread.sleep(2000);
	}
}
