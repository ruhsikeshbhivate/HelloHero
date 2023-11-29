package com.EMC.testcases;

import java.util.Locale;

import org.testng.annotations.Test;

import com.EMC.PageObject.LandingPage;
import com.EMC.PageObject.OrganizationPage;
import com.EMC.PageObject.SecureAccessPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_CreateReferralFromLandingAndSecurePage extends BaseClass{

	Faker faker = new Faker(new Locale("en-US"));
	@Test(priority = 0)
	public void createReferralFromLanding() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();

		dashboardPage dashpage = new dashboardPage(driver);
		dashpage.clickOnOrganization();

		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.selectOrganization("Rushi_TestOrganization");
		orgPage.CopyLandingPageUrl();

		LandingPage page = new LandingPage(driver);
		page.clickOnNewReferral();
		page.enterYourEmail("rushikesh.bhivate@anveshak.com");
		driver.findElement(LandingPage.FirstName).sendKeys(faker.name().firstName());
		driver.findElement(LandingPage.LastName).sendKeys(faker.name().lastName());
		page.clickOnDOB();
		
		page.selectState("Arizona");
		page.enterZipCode("85546");
		page.enterContactFirstName("Dewald");
		page.enterContactLastName("Carry");
		page.enterContactPhone("7262957778");
		page.enterContactEmail("rupeshbhivate111@gmail.com");
		page.selectRelationship("Teacher");
		page.selectSpecialty("Mental Health Counselor");
		page.selectScheduleType("Session");
		page.selectScheduleSubType("Consultation");
		page.enterSessionLength("20");
		page.clickOnStartDate();
		page.clickEndDate();
		page.selectStartOutreach("Now");
		page.selectFrequency("Weekly");
		page.enterNoOfTimes("1"); 
		page.clickSubmit();

		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnUsers();
		driver.findElement(UsersPage.Address).sendKeys(faker.address().streetAddress());
		usersPage.enterCity("Safford");
		usersPage.clickOnSaveProfile();
	
	}

	@Test(priority = 1)
	public void uploadMultiStudentReferral() throws InterruptedException
	{
		LandingPage page = new LandingPage(driver);
		page.clickOnMultiStudentReferral();
		
		page.selectcsvFile("C:\\Users\\sanke\\Desktop\\UploadMultiReferral\\ImportMultiReferral2.csv");
		page.clickOnUpload();
	
	}
	
	@Test(priority = 2)
	public void createReferralfromSecurePage() throws InterruptedException
	{
		SecureAccessPage securePage = new SecureAccessPage(driver);
		securePage.openSecureAccessPage();
		securePage.enterFirstName("Test");
		securePage.enterLastName("Orgadmin");
		securePage.clickOnVerify();
		securePage.clickOnNewReferral();

		securePage.enterFirstName1("Mathew");
		securePage.enterLastName1("Markram");
		securePage.clickOnDOB();
		securePage.enterSchoolId("907878");
		securePage.enterContactFirstName("Dewald");
		securePage.enterContactLastName("Carry");
		securePage.enterContactPhone("7262957778");
		securePage.enterContactEmail("rupeshbhivate111@gmail.com");
		securePage.selectRelationship("Guardian");
		securePage.selectSpecialty("Physical Therapist (PT)");
		securePage.selectScheduleType("Session");
		securePage.selectScheduleSubType("Make Up");
		securePage.enterSessionLength("20");
		securePage.clickOnStartDate();
		securePage.clickEndDate();
		securePage.selectStartOutreach("Now");
		securePage.selectFrequency("Weekly");
		securePage.enterNoOfTimes("1");
		securePage.clickSubmit();

	}
}
