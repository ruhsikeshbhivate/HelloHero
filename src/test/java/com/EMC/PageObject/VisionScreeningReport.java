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

public class VisionScreeningReport {

	WebDriver ldriver;

	public VisionScreeningReport(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"not_available\"]")
	WebElement RecentEyeExam;
	
	public void clickOnRecentEyeExam()
	{
		RecentEyeExam.click();
	}
	
	@FindBy(xpath = "(//input[@name=\"wears_glasses\"])[1]")
	WebElement WearGlasses;
	
	public void clickOnWearGlasses()
	{
		WearGlasses.click();
	}
	
	
	@FindBy(xpath = "//textarea[@name=\"observations\"]")
	WebElement Observations;
	
	public void enterObservations(String Text)
	{
		Observations.sendKeys(Text);
	}
	
	@FindBy(xpath = "(//input[@name=\"eyes_in_alignment\"])[1]")
	WebElement EyesInAllignment;
	
	public void clickOnEyesInAllignment()
	{
		EyesInAllignment.click();
	}
	
	@FindBy(xpath = "(//input[@name=\"horizontal\"])[1]")
	WebElement HorizontalFull;
	
	public void clickOnHorizontalFull()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",EyeChartResults);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		HorizontalFull.click();
	}
	
	@FindBy(xpath = "(//input[@name=\"vertical\"])[2]")
	WebElement VerticalLimited;
	
	public void clickOnVerticalLimited()
	{
		VerticalLimited.click();
	}
	
	@FindBy(xpath = "(//input[@name=\"convergent_present[]\"])[1]")
	WebElement ConvergentPresent;
	
	public void clickOnConvergentPresent()
	{
		ConvergentPresent.click();
	}
	
	@FindBy(xpath = "(//input[@name=\"divergent_present[]\"])[2]")
	WebElement DivergentPresent;
	
	public void clickOnDivergentPresent()
	{
		DivergentPresent.click();
	}
	
	@FindBy(xpath = "(//input[@name=\"eye_chart_results\"])[2]")
	WebElement EyeChartResults;
	
	public void clickOnEyeChartResults()
	{
		EyeChartResults.click();
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
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",EyeChartResults);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SubmitDocument.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "(//input[@name=\"divergent_present[]\"])[3]")
	WebElement DivergentPresentJumps;
	
	public void clickOnDivergentPresentJumps()
	{
		DivergentPresentJumps.click();
	}
	@FindBy(xpath = "//button[@id=\"edit_visionscreening_form_btn\"]")
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
