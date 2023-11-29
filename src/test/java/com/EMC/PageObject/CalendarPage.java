
package com.EMC.PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

	WebDriver ldriver;

	public CalendarPage(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
		
	@FindBy(xpath = "//a[@onclick=\"start_event(this.id)\"]")
	WebElement StartButton;
	
	@FindBy(xpath = "//span[@class=\"fc-title\"]")
	WebElement eventInfo;
	
	@FindBy(xpath = "//span[text()='Eligibility Evaluation with Dawson Ragle, Dane Cleaver']")
	WebElement eventInfo3;
	
	@FindBy(xpath = "//button[@id=\"create_event\"]")
	WebElement createEventButton;

	@FindBy(xpath = "//span[text()='Physical Therapy Screening with Pawan TestUser, Pawan Therapist']")
	WebElement eventInfo1;
	
	@FindBy(xpath = "//span[text()='Intake Meeting with Jack Will, Jack Therapist01']")
	WebElement eventInfo2;
	
	@FindBy(xpath = "//span[text()='Speech Therapy Screening with Dawson Ragle, Dane Cleaver']")
	WebElement speechTherapyEventInfo;
	
	@FindBy(xpath = "//span[text()='Hearing Screening with Dominic Young, Jason Henry']")
	WebElement HearingScreeningEventInfo;
	
	@FindBy(xpath = "//span[text()='Vision Screening with Dawson Ragle, Dane Cleaver']")
	WebElement VisionScreeningEventInfo;
	
	public void clickOnCreateEventButton()
	{
		createEventButton.click();
	}
	
	public void clickOnVisionScreeningEventInfo() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",VisionScreeningEventInfo);
		
		Thread.sleep(2000);
	}
	
	public void clickOnEventInfo() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",eventInfo);
		
		Thread.sleep(2000);
	}
	
	public void clickOnHearingScreeningEventInfo() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",HearingScreeningEventInfo);
		
		Thread.sleep(2000);
	}
	
	public void clickOnStartButton() throws InterruptedException
	{
		StartButton.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
	}
	
	public void clickOnStartButton1() throws InterruptedException
	{
		StartButton.click();
		Thread.sleep(2000);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollBy(0, 600)");
		Thread.sleep(2000);
	}
	
	public void clickOnEventInfo1() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",eventInfo1);
		Thread.sleep(2000);
		eventInfo1.click();
	}
	
	public void clickOnEventInfo2() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",eventInfo2);
		Thread.sleep(2000);
		eventInfo1.click();
	}
	
	public void clickOnEventInfo3() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",eventInfo3);
		
		Thread.sleep(1000);
	}
	
	public void clickOnSpeechTherapyEventInfo() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",speechTherapyEventInfo);
		
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//span[@class=\"fc-title\"]")
	WebElement dailyTeachingEventInfo;
	
	public void clickOnDailyTeachinfEventInfo() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",dailyTeachingEventInfo);
		
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//span[@class=\"fc-title\"]")
	WebElement speechTherapyScreeningEventInfo;
	
	public void clickOnspeechTherapyScreeningEventInfo() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",speechTherapyScreeningEventInfo);
		
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//span[text()=\"Behavior Plan with Drake Wisler, Jason Henry\"]")
	WebElement BehaviorPlanDocument;
	
	public void clickOnBehaviorPlanDocumentEventInfo() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",BehaviorPlanDocument);
		
		Thread.sleep(2000);
	}
}
