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

public class DigitalHearingScreeningReport {

	WebDriver ldriver;

	public DigitalHearingScreeningReport(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//textarea[@name=\"observations\"]")
	WebElement Observations;
	
	public void enterObservations(String Text)
	{
		Observations.sendKeys(Text);
	}
	
	@FindBy(xpath = "(//input[@name=\"right_ear\"])[1]")
	WebElement RightEarPass;
	
	public void clickOnRightEarPass()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",SubmitDocument);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		RightEarPass.click();
	}
	
	@FindBy(xpath = "(//input[@name=\"left_ear\"])[1]")
	WebElement LeftEarPass;
	
	public void clickOnLeftEarPass()
	{
		LeftEarPass.click();
	}
	
	@FindBy(xpath = "//input[@value=\"Within Normal Limits\"]")
	WebElement Results;
	
	public void clickOnResults()
	{
		Results.click();
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
	
	@FindBy(xpath = "(//input[@name=\"right_ear\"])[2]")
	WebElement RightEarFail;
	public void clickOnRightEarFail()
	{
		RightEarFail.click();
	}
	@FindBy(xpath = "//button[@id=\"edit_digitalhearingscreening_form_btn\"]")
	WebElement SubmitDocumentFromExternalLink;
	
	public void clickOnSubmitDocumentFromExternalLink() throws InterruptedException
	{
		SubmitDocumentFromExternalLink.click();
		Thread.sleep(2000);
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(0));
		Thread.sleep(2000);
	}
	
	
}
