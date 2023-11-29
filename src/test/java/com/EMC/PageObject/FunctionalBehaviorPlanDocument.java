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

public class FunctionalBehaviorPlanDocument {
	
	WebDriver ldriver;

	public FunctionalBehaviorPlanDocument(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@id=\"age_of_student\"]")
	WebElement AgeOfStudent;
	
	public void enterAgeOfStudent(String Age)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		AgeOfStudent.sendKeys(Age);
	}
	
	@FindBy(xpath = "//input[@id=\"grade\"]")
	WebElement Grade;
	
	public void enterGrade(String grade)
	{
		Grade.sendKeys(grade);
	}
	
	@FindBy(xpath = "//input[@id=\"functionalbehaviorstatement\"]")
	WebElement functionalBehaviorStatement;
	
	public void enterfunctionalBehaviorStatement(String grade)
	{
		functionalBehaviorStatement.sendKeys(grade);
	}
	
	@FindBy(xpath = "//input[@value=\"Request help\"]")
	WebElement RequestHelp;
	
	public void clICKOnRequestHelp()
	{
		RequestHelp.click();
	}
	
	@FindBy(xpath = "//input[@value=\"Request an item\"]")
	WebElement requestAnItem;
	
	public void clICKOnrequestAnItem()
	{
		requestAnItem.click();
	}
	
	@FindBy(xpath = "//input[@value=\"Greet others\"]")
	WebElement greetOthers;
	
	public void clICKOnGreetOthers()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();", greetOthers);
		greetOthers.click();
	}
	
	@FindBy(xpath = "//input[@value=\"Choice making\"]")
	WebElement ChoiceMaking;
	
	public void clICKOnChoiceMaking()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();", SubmitDocument);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ChoiceMaking.click();
	}
	
	@FindBy(xpath = "//textarea[@id=\"summary\"]")
	WebElement Summary;
	
	public void enterSummary(String summary)
	{
		Summary.sendKeys(summary);
	}
	
	@FindBy(xpath = "//canvas[@name=\"signature-pad\"]")
	WebElement signature;
	
	public void enterSignature()
	{
		signature.click();
	}
	
	@FindBy(xpath = "//button[@id=\"save_form_btn\"]")
	WebElement SubmitDocument;
	
	public void clickOnSubmitDocument() throws InterruptedException
	{
		SubmitDocument.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//button[@id=\"edit_functionalbehaviorplan_form_btn\"]")
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
