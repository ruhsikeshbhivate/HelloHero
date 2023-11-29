
package com.EMC.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver driver;

	//constructor
	public loginPage(WebDriver driver)
	{
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"login\"]")
	WebElement userName;

	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement passWord;

	@FindBy(xpath = "(//button[@type=\"submit\"])[1]")
	WebElement LoginButton;

	public void enterUsername(String USERNAME)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		userName.sendKeys(USERNAME);
	}

	public void enterPassword(String pass)
	{
		passWord.sendKeys(pass);
	}

	public void clickOnLoginButton()
	{
		LoginButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
}

