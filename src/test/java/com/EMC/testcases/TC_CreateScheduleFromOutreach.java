package com.EMC.testcases;

import org.testng.annotations.Test;

import com.EMC.PageObject.ReferralPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;


public class TC_CreateScheduleFromOutreach extends BaseClass {

	@Test(priority = 0)
	public void createOutreachScheduleForWeekly() throws InterruptedException
	{
		driver.manage().window().maximize();
		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();

		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
		dashPage.clickOnUsers();
		dashPage.clickOnReferral();

		ReferralPage referralPage = new ReferralPage(driver);
		referralPage.clickOnAddReferral();
		
		///
		referralPage.selectOrganization("Acceleration_orgTest");
		referralPage.selectStudent("Morne Morkel");
		referralPage.clickOnNext();
		
		referralPage.selectServiceRequested("Occupational Therapist (OT)");
		referralPage.selectScheduleType("Assessment");
		referralPage.selectScheduleSubType("Eligibility Evaluation");
		referralPage.clickOnAddService();
		referralPage.clickOnSubmit();
		referralPage.searchStudent("Morne Morkel");

		referralPage.clickOnSearch();
		referralPage.clickOnOutreach();
		referralPage.clickOnStartDate();
		referralPage.clickEndDate();
		referralPage.enterSessionLength("20");
		referralPage.selectInterval("Weekly");
		referralPage.enterNumberOfTimes("1");
		referralPage.selectStartOutreach("Now");
		referralPage.clickOnSave();
		referralPage.clickOnOutreachLink();

		referralPage.enterStudentFirstName("Morne");
		referralPage.enterStudentLasttName("Morkel");
		referralPage.clickOnEnter();
		referralPage.clickOnConfirm();
		referralPage.clickOnNext1();
		referralPage.clickOnOption();
		referralPage.clickOnTimeslot();
		referralPage.clickOnSchedule();

		referralPage.searchStudent("Morne Morkel");
		referralPage.clickOnSearch();
		referralPage.clickOnArchiveReferral();
		referralPage.clickOnYesPlease();
		referralPage.enterArchivedReason("Test");
		referralPage.clickOnSubmitReason();

	}
	
	@Test(priority = 1)
	public void createOutreachScheduleForDaily() throws InterruptedException
	{
		ReferralPage referralPage = new ReferralPage(driver);

		referralPage.clickOnAddReferral();
		referralPage.selectOrganization("Acceleration_orgTest");
		referralPage.selectStudent("Morne Morkel");

		referralPage.clickOnNext();
		referralPage.selectServiceRequested("Occupational Therapist (OT)");
		referralPage.selectScheduleType("Assessment");
		referralPage.selectScheduleSubType("Eligibility Evaluation");
		referralPage.clickOnAddService();
		referralPage.clickOnSubmit();
		referralPage.searchStudent("Morne Morkel");

		referralPage.clickOnSearch();
		referralPage.clickOnOutreach();
		referralPage.clickOnStartDate();
		referralPage.clickEndDate();
		referralPage.enterSessionLength("20");
		referralPage.selectInterval("Daily");
		referralPage.enterNumberOfTimes("1");
		referralPage.selectStartOutreach("Now");
		referralPage.clickOnSave();
		referralPage.clickOnOutreachLink();

		referralPage.enterStudentFirstName("Morne");
		referralPage.enterStudentLasttName("Morkel");
		referralPage.clickOnEnter();
		referralPage.clickOnConfirm();
		referralPage.clickOnNext1();
		referralPage.clickOnOption();
		referralPage.selectTimeslot();
		referralPage.clickOnSchedule();

		referralPage.searchStudent("Morne Morkel");
		referralPage.clickOnSearch();
		referralPage.clickOnArchiveReferral();
		referralPage.clickOnYesPlease();
		referralPage.enterArchivedReason("Test");
		referralPage.clickOnSubmitReason();
	}
	
}
