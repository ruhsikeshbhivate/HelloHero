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

public class CaseNotDocument {

	WebDriver ldriver;
	
	public CaseNotDocument(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@value=\"Individual\"]")
	WebElement Individual;
	
	public void clickOnIndividual()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();", SubmitDocuement);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Individual.click();
	}
	
	@FindBy(xpath = "(//div[@class=\"note-editable\"])[1]")
	WebElement AdditionalInformation;
	
	public void enterAdditionalInformation(String text)
	{
		AdditionalInformation.sendKeys(text);
	}
	
	@FindBy(xpath = "//canvas[@name=\"signature-pad\"]")
	WebElement Signature;
	
	public void enterSignature()
	{
		Signature.click();
	}
	
	@FindBy(xpath = "//button[@id=\"save_casenote_btn\"]")
	WebElement SubmitDocuement;
	
	public void clickOnSubmitDocuement() throws InterruptedException
	{
		SubmitDocuement.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//button[text()=\"Not Right Now\"]")
	WebElement NotRightNow;
	
	public void clickOnNotRightNow() throws InterruptedException
	{
		NotRightNow.click();
		Thread.sleep(3000);

	}
	
	@FindBy(xpath = "//button[@id=\"edit_casenote_btn\"]")
	WebElement EditCaseNoteButton;
	
	public void submitDocumentFromExternalLink()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		EditCaseNoteButton.click();
	}
}
