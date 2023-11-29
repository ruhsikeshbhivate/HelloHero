package com.EMC.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientDashboardPage {

	WebDriver ldriver;
	
	public ClientDashboardPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "(//input[@name=\"consent_input\"])[1]")
	WebElement clientName;
	
	@FindBy(xpath = "(//input[@name=\"consent_input\"])[2]")
	WebElement parentName;
	
	@FindBy(xpath = "(//input[@name=\"consent_input\"])[3]")
	WebElement date;
	
	@FindBy(xpath = "//canvas[@name=\"signature-pad\"]")
	WebElement signature;
	
	@FindBy(xpath = "//input[@name=\"required_agreement\"]")
	WebElement acceptCheckBox;
	
	@FindBy(xpath = "//button[@id=\"agree_button\"]")
	WebElement saveAndNext;
	
	@FindBy(xpath = "(//a[@id=\"navbarDropdown\"])[4]")
	WebElement profileThumb1;
	
	@FindBy(xpath = "(//a[@href=\"https://stage.hellohero.com/my-profile\"])[4]")
	WebElement myProfile;
	
	@FindBy(xpath = "(//a[@onclick=\"resetLocalValue()\"])[2]")
	WebElement signOut;
	
	@FindBy(xpath = "//button[text()='Later']")
	WebElement Later;
	
	public void clickOnProfileThumb1()
	{
		profileThumb1.click();
	}
	
	public void clickOnSignOut() throws InterruptedException
	{
		signOut.click();
		Thread.sleep(4000);
	}
	
	public void clickOnLater() throws InterruptedException
	{
		Thread.sleep(4000);
		Later.click();
		Thread.sleep(2000);
	}
	public void clickOnMyProfile()
	{
		myProfile.click();
	}
	
	public void enterClientName(String CName)
	{
		clientName.sendKeys(CName);
	}
	
	public void enterParentName(String PName)
	{
		parentName.sendKeys(PName);
	}
	
	public void enterDate(String Date)
	{
		date.sendKeys(Date);
	}
	
	public void clickOnSignature()
	{
		signature.click();
		signature.click();
	}
	
	public void clickOnAgreementCheckbox()
	{
		acceptCheckBox.click();
	}
	
	
	public void clickOnSaveAndNext()
	{
		saveAndNext.click();
	}
}
