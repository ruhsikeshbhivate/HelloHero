package com.EMC.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpeechTherapyScreeningReport {

	WebDriver ldriver;

	public SpeechTherapyScreeningReport(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//textarea[@name=\"reason_for_screen\"]")
	WebElement ReasonForScreening;
	
	public void enterReasonForScreening(String Text)
	{
		ReasonForScreening.sendKeys(Text);
	}
	
	@FindBy(xpath = "//textarea[@name=\"caregiver_comments\"]")
	WebElement TeacherComments;
	
	public void enterTeacherComments(String Text)
	{
		TeacherComments.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@value=\"Reading Passage\"]")
	WebElement ReadingPassage;
	
	
	@FindBy(xpath = "//input[@value=\"Informal Observation\"]")
	WebElement InformalObservation;
	
	public void selectToolsUsed()
	{
		ReadingPassage.click();
		InformalObservation.click();
	}
	
	@FindBy(xpath = "//textarea[@id=\"articulation\"]")
	WebElement Articulation;
	
	public void enterArticulation(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",ReceptiveLanguage);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Articulation.sendKeys(Text);
	}
	
	@FindBy(xpath = "//textarea[@id=\"fluency\"]")
	WebElement Fluency;
	
	public void enterFluency(String Text)
	{
		Fluency.sendKeys(Text);
	}
	
	@FindBy(xpath = "//textarea[@id=\"expressive_language\"]")
	WebElement ExpressiveLanguage;
	
	public void enterExpressiveLanguage(String Text)
	{
		ExpressiveLanguage.sendKeys(Text);
	}
	
	@FindBy(xpath = "//textarea[@id=\"receptive_language\"]")
	WebElement ReceptiveLanguage;
	
	public void enterReceptiveLanguage(String Text)
	{
		ReceptiveLanguage.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"criteriaChkBox\"]")
	WebElement CriteriaCheckbox;
	
	public void clickOnCriteriaCheckbox()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",SubmitDocument);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		CriteriaCheckbox.click();
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
	
	@FindBy(xpath = "//button[@id=\"edit_speechtherapy_form_btn\"]")
	WebElement SumbitDocumentFormExternalLink;
	
	public void clickOnSumbitDocumentFormExternalLink() throws InterruptedException
	{
		SumbitDocumentFormExternalLink.click();
		Thread.sleep(2000);
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(0));
		Thread.sleep(2000);
	
	}
	
}
