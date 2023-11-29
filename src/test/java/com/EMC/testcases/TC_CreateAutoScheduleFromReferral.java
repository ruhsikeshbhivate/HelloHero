package com.EMC.testcases;

import org.testng.annotations.Test;

import com.EMC.PageObject.ReferralPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_CreateAutoScheduleFromReferral extends BaseClass{

	@Test
	public void createScheduleUsingAutoScheduleFromReferral() throws InterruptedException
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
		referralPage.clickOnWithoutOutreach();
		referralPage.selectOrganization("Rushi_TestOrganization");
		referralPage.selectStudent("Luke Wright");
		referralPage.clickOnNext();

		referralPage.selectServiceRequested("Occupational Therapist (OT)");
		referralPage.selectScheduleType("Assessment");
		referralPage.selectScheduleSubType("Standard Assessment");
		referralPage.clickOnAddService();
		referralPage.clickOnSubmit();
		referralPage.searchStudent("Luke Wright");

		referralPage.clickOnSearchReferral();
		referralPage.clickOnAddSchedule();
		referralPage.useAutoSchedule();
		referralPage.scheduleTherapist("Dane Cleaver");
		referralPage.outreachStartDate();
		referralPage.outreachEndDate();
			
		referralPage.outreachStartTime();
		referralPage.outreachEndTime();
		referralPage.outreachSessionLength("20");
		referralPage.intervalInfo("Daily");
		referralPage.sessionPerDay("1");
		referralPage.next_GetTherapist();
		referralPage.selectTimeslot();
		referralPage.clickOnCreateSchedule();
		referralPage.welecomeEmailPopup();
		referralPage.clickOnSearchReferral();
		referralPage.clickOnArchiveReferral();
		referralPage.clickOnYesPlease();
		referralPage.enterArchivedReason("Test");
		referralPage.clickOnSubmitReason();
			
	}
}
