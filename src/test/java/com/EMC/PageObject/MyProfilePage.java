package com.EMC.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {

	WebDriver ldriver ;
	
	public MyProfilePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "(//span[@class=\"ptxt\"])[1]")
	WebElement viewPassword;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath = "(//span[@class=\"ptxt\"])[2]")
	WebElement viewConfirmPassword;
	
	@FindBy(xpath = "//input[@name=\"confirm-password\"]")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//button[text()='Save Profile']")
	WebElement SaveProfile;
	
	public void enterPassword(String pass) throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",password);
		Thread.sleep(2000);
		viewPassword.click();
		password.sendKeys(pass);
		Thread.sleep(1000);
	}
	
	public void enterConfirmPassword(String pass) throws InterruptedException
	{
		viewConfirmPassword.click();
		confirmPassword.sendKeys(pass);
	}
	
	public void clickOnSaveProfile() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		SaveProfile.click();
		Thread.sleep(5000);
	}
}
