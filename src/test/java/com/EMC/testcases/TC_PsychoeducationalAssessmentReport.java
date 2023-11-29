package com.EMC.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.EMC.PageObject.CalendarPage;
import com.EMC.PageObject.EventListPage;
import com.EMC.PageObject.PsychoeducationalAssessmentReport;
import com.EMC.PageObject.StartEventPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;

public class TC_PsychoeducationalAssessmentReport extends BaseClass {


	@Test
	public void submitPsychoeducationalAssessmentReport() throws InterruptedException
	{
		driver.manage().window().maximize();
		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("SagarAdmin@123");
		login.clickOnLoginButton();

		dashboardPage dashpage = new dashboardPage(driver);
		dashpage.clickOnScheduling();
		dashpage.clickOnEvents();

		EventListPage eventPage = new EventListPage(driver);
		eventPage.clickOnAddEventButton();
		eventPage.clickOnBuildSchedule();
		eventPage.selectOrganization("Rushi_TestOrganization");

		eventPage.selectscheduleTypes("Assessment");
		eventPage.selectScheduleSubTypes("Eligibility Evaluation");
		eventPage.selectSpecialty("Occupational Therapist (OT)");
		eventPage.selectVideoPlatform("HelloHERO Video");
		eventPage.selectParticipant("Dawson Ragle");
		eventPage.clickOnAddParticipant();
		eventPage.selectOwner("Dane Cleaver");
		eventPage.clickOnAddOwnerButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		eventPage.clickOnEventStartDate();
		eventPage.clickOnEventStartTime();
		eventPage.clickOnIncreaseStartTime();
		
		eventPage.enterSessionLength("2");
		eventPage.enterGeneralNotes("This event is created by automation");
		eventPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		eventPage.clickOnSubmit1();
		
		CalendarPage calendar = new CalendarPage(driver);
		calendar.clickOnEventInfo3();
		calendar.clickOnStartButton();

		StartEventPage startPage = new StartEventPage(driver);
		startPage.clickOnDocumentInternalLink();
		
		PsychoeducationalAssessmentReport assessmentReport = new PsychoeducationalAssessmentReport(driver);
		assessmentReport.enterGrade("3");
		assessmentReport.enterCurrentEligibility("Test");
		
		assessmentReport.clickOnAssessmentDate();
		assessmentReport.clickOnDueDate();
		
		assessmentReport.enterDevelopmentalHistory("Test");
		assessmentReport.entersocialEmotionalHistory("Test");
		assessmentReport.clickOnFamilyStructure();
		assessmentReport.enterbackgroundInformationElement("3");
		assessmentReport.clickOnReading();
		assessmentReport.enterareaOfConcern("Behaviour");
		assessmentReport.clickOnAcademicAssessments();
		assessmentReport.clickOnWISC();
		assessmentReport.enterFSQIScore("50");
		assessmentReport.enterFSQIPercent("55");
		assessmentReport.enterFSQIClassification("Test");
		assessmentReport.enterVerbalScore("70");
		assessmentReport.enterVerbalPercent("60");
		assessmentReport.enterVerbalClassification("Test");
		assessmentReport.enterFluidScore("70");
		assessmentReport.enterFluidPercent("60");
		assessmentReport.enterFliudClassification("Test");
		assessmentReport.enterMemoryScore("55");
		assessmentReport.enterMemoryPercent("60");
		assessmentReport.enterMemoryClassification("Test");
		assessmentReport.enterSpeedScore("60");
		assessmentReport.enterSpeedPercent("75");
		assessmentReport.enterSpeedClassification("Test");
		
		assessmentReport.clickAcademicFunctioning1("Reading");
		
		assessmentReport.enterPictureSpan("68");
		assessmentReport.enterSimilaritiesScore("50");
		assessmentReport.enterMatrixScore("70");
		assessmentReport.enterDigitScore("60");
		assessmentReport.enterCodingScore("50");
		assessmentReport.enterVocabularyScore("55");
		assessmentReport.enterFigureScore("70");
		assessmentReport.enterPuzzleScore("60");
		assessmentReport.enterSymbolScore("60");
		
		assessmentReport.enterComposite("Test");
		assessmentReport.enterStandardScore("60");
		assessmentReport.enterPercentile("65");
		assessmentReport.enterClassification("Formative Evaluation");
		assessmentReport.enterEvaluationInstrument("Observations");
		assessmentReport.enterSubTest("Verbal");
		assessmentReport.enterScaledScore("70");
		assessmentReport.clickOnWechslerIndividualCheckbox();
		assessmentReport.enterSubtest("Curriculam Test");
		assessmentReport.enterAssessmentStandardScore("50");
		assessmentReport.entersubtestPercentile("40");
		assessmentReport.enterSubtestDescription("Test");
		assessmentReport.enterstudentStandardScore("55");
		assessmentReport.enterAreaOfWeakness("Writing");
		assessmentReport.enterProcessingSpeed("Medium");
		assessmentReport.enterverbelComprenhension("Analytical");
		assessmentReport.enterAnswerQuestion("Any psychiatric treatment you've had");
		assessmentReport.enterspeedOfProcessing("Medium");
		assessmentReport.enterComprehensionAbilities("Slow");
		assessmentReport.enterMathProbledmSolving("Slow");
		assessmentReport.enterRangeInSpelling("Medium");
		assessmentReport.enteroralDiscourse("Test");
		assessmentReport.enterNumericalOperations("Medium");
		assessmentReport.enterListeningComprehension("Medium");
		assessmentReport.enterReadingComprehension("Fast");
		assessmentReport.enterReceptiveListening("Fast");
		assessmentReport.enterBehaviourRatingScales("55");
		assessmentReport.enterScoreOnDepression("60");
		assessmentReport.entersignificantBehavioural("Pessimistic");
		assessmentReport.enterRecommendations("Learing Problems");
		assessmentReport.clickOnValidityStatement();
		assessmentReport.enterSignature();
		assessmentReport.clickSubmitDocument();
		
		startPage.clickOnChangeDoucment();
		startPage.clickOnExternalDocumentLinks();
		startPage.clickOnEdit();
		
		assessmentReport.enterSignature();
		assessmentReport.clickSubmitExternalDocumentt();
		startPage.clickOnDocumentDownload();
		
		
	}
}