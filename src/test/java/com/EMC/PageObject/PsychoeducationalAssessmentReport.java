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

public class PsychoeducationalAssessmentReport {

	WebDriver ldriver;
	
	public PsychoeducationalAssessmentReport(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"student_grade\"]")
	WebElement Grade;
	
	public void enterGrade(String grade)
	{
		Grade.sendKeys(grade);
	}
	
	@FindBy(xpath = "//input[@name=\"student_eligibility\"]")
	WebElement CurrentEligibility;
	
	public void enterCurrentEligibility(String grade)
	{
		CurrentEligibility.sendKeys(grade);
	}
	
	@FindBy(xpath = "//input[@name=\"due_date\"]")
	WebElement TriennialDueDate;
	
	public void clickOnDueDate()
	{
		TriennialDueDate.click();
	}
	
	@FindBy(xpath = "//input[@name=\"assessment_date[]\"]")
	WebElement AssessmentDate;
	
	public void clickOnAssessmentDate()
	{
		AssessmentDate.click();
	}
	
	@FindBy(xpath = "//textarea[@name=\"health_history\"]")
	WebElement DevelopmentalHistory;
	
	public void enterDevelopmentalHistory(String grade)
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",Strengths);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		DevelopmentalHistory.sendKeys(grade);
	}
	
	@FindBy(xpath = "//textarea[@name=\"emotional_history\"]")
	WebElement socialEmotionalHistory;
	
	public void entersocialEmotionalHistory(String grade)
	{
		socialEmotionalHistory.sendKeys(grade);
	}
	
	@FindBy(xpath = "//input[@value=\"Mom\"]")
	WebElement FamilyStructure;
	
	@FindBy(xpath = "//input[@value=\"Visual memory\"]")
	WebElement Strengths;
	
	@FindBy(xpath = "//input[@value=\"Active\"]")
	WebElement EvaluationBehavioralObservations;
	
	public void clickOnFamilyStructure()
	{
		FamilyStructure.click();
		Strengths.click();
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",areaOfConcern);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		EvaluationBehavioralObservations.click();
	}
	
	@FindBy(xpath = "//input[@name=\"bg_age\"]")
	WebElement backgroundInformationElement;
	
	public void enterbackgroundInformationElement(String grade)
	{
		backgroundInformationElement.sendKeys(grade);
	}
	
	@FindBy(xpath = "//input[@value=\"reading\"]")
	WebElement reading;
	
	public void clickOnReading()
	{
		reading.click();
	}
	
	@FindBy(xpath = "//textarea[@name=\"or_areas_concern\"]")
	WebElement areaOfConcern;
	
	public void enterareaOfConcern(String grade)
	{
		areaOfConcern.sendKeys(grade);
	}
	
	@FindBy(xpath = "(//input[@value=\"WIAT\"])[1]")
	WebElement AcademicAssessments;
	
	@FindBy(xpath = "//input[@name=\"academic_assessment_date\"]")
	WebElement accademicAssessmentDate;
	
	public void clickOnAcademicAssessments() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",AcademicAssessments);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		AcademicAssessments.click();
		Thread.sleep(2000);
		accademicAssessmentDate.click();
	}
	
	@FindBy(xpath = "//input[@id=\"wisc_v_main_checked\"]")
	WebElement WISC;
	
	public void clickOnWISC()
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",WISC);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WISC.click();
	}
	
	@FindBy(xpath = "//input[@id=\"v_image_1_checked\"]")
	WebElement academicFunctioning;
	
	@FindBy(xpath = "//textarea[@name=\"v_image_file_1_other\"]")
	WebElement AcademicFunctioning1;
	
	public void clickAcademicFunctioning1(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",AcademicFunctioning1);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		AcademicFunctioning1.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ss_composite_1\"]")
	WebElement composite;
	
	public void enterComposite(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",ScaledScore);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		composite.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ss_score_1\"]")
	WebElement StandardScore;
	
	public void enterStandardScore(String Text)
	{
		StandardScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ss_percent_1\"]")
	WebElement Percentile;
	
	public void enterPercentile(String Text)
	{
		Percentile.sendKeys(Text);
	}
	
	@FindBy(xpath = "//textarea[@id=\"ss_classification_1\"]")
	WebElement Classification;
	
	public void enterClassification(String Text)
	{
		Classification.sendKeys(Text);
	}
	
	@FindBy(xpath = "//textarea[@id=\"ss_instrument_1\"]")
	WebElement EvaluationInstrument;
	
	public void enterEvaluationInstrument(String Text)
	{
		EvaluationInstrument.sendKeys(Text);
	}
	
	@FindBy(xpath = "//textarea[@id=\"sub_subtest_1\"]")
	WebElement SubTest;
	
	public void enterSubTest(String Text)
	{
		SubTest.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"sub_score_1\"]")
	WebElement ScaledScore;
	
	public void enterScaledScore(String Text)
	{
		ScaledScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"wiat_iv_main_checked\"]")
	WebElement WechslerIndividualCheckbox;
	
	public void clickOnWechslerIndividualCheckbox() throws InterruptedException
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",WechslerIndividualCheckbox);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WechslerIndividualCheckbox.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//input[@name=\"fsqi_score\"]")
	WebElement FSQIScore;
	
	public void enterFSQIScore(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",SpeedClassification);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		FSQIScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"fsqi_percent\"]")
	WebElement FSQIPercent;
	
	public void enterFSQIPercent(String Text)
	{
		FSQIPercent.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"fsqi_classification\"]")
	WebElement FSQIClassification;
	
	public void enterFSQIClassification(String Text)
	{
		FSQIClassification.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"verbal_score\"]")
	WebElement VerbalScore;
	
	public void enterVerbalScore(String Text)
	{
		VerbalScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"verbal_percent\"]")
	WebElement VerbalPercent;
	
	public void enterVerbalPercent(String Text)
	{
		VerbalPercent.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"verbal_classification\"]")
	WebElement VerbalClassification;
	
	public void enterVerbalClassification(String Text)
	{
		VerbalClassification.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"fluid_score\"]")
	WebElement FluidScore;
	
	public void enterFluidScore(String Text)
	{
		FluidScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"fluid_percent\"]")
	WebElement FliudPercent;
	
	public void enterFluidPercent(String Text)
	{
		FliudPercent.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"fluid_classification\"]")
	WebElement FliudClassification;
	
	public void enterFliudClassification(String Text)
	{
		FliudClassification.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"memory_score\"]")
	WebElement MemoryScore;
	
	public void enterMemoryScore(String Text)
	{
		MemoryScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"memory_percent\"]")
	WebElement MemoryPercent;
	
	public void enterMemoryPercent(String Text)
	{
		MemoryPercent.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"memory_classification\"]")
	WebElement MemoryClassification;
	
	public void enterMemoryClassification(String Text)
	{
		MemoryClassification.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"speed_score\"]")
	WebElement SpeedScore;
	
	public void enterSpeedScore(String Text)
	{
		SpeedScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"speed_percent\"]")
	WebElement SpeedPercent;
	
	public void enterSpeedPercent(String Text)
	{
		SpeedPercent.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"speed_classification\"]")
	WebElement SpeedClassification;
	
	public void enterSpeedClassification(String Text)
	{
		SpeedClassification.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"picture_score\"]")
	WebElement PictureSpan;
	
	public void enterPictureSpan(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",FigureScore);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		PictureSpan.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"similarities_score\"]")
	WebElement SimilaritiesScore;
	
	public void enterSimilaritiesScore(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SimilaritiesScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"matrix_score\"]")
	WebElement MatrixScore;
	
	public void enterMatrixScore(String Text)
	{
		MatrixScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"digit_score\"]")
	WebElement DigitScore;
	
	public void enterDigitScore(String Text)
	{
		DigitScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"coding_score\"]")
	WebElement CodingScore;
	
	public void enterCodingScore(String Text)
	{
		CodingScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"vocabulary_score\"]")
	WebElement VocabularyScore;
	
	public void enterVocabularyScore(String Text)
	{
		VocabularyScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"figure_score\"]")
	WebElement FigureScore;
	
	public void enterFigureScore(String Text)
	{
		FigureScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"puzzle_score\"]")
	WebElement PuzzleScore;
	
	public void enterPuzzleScore(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",SymbolScore);
		PuzzleScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@name=\"symbol_score\"]")
	WebElement SymbolScore;
		
	public void enterSymbolScore(String Text)
	{
		SymbolScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"wiat_iv_composite_1\"]")
	WebElement Subtest;
	
	public void enterSubtest(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Subtest.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"wiat_iv_score_1\"]")
	WebElement AssessmentStandardScore;
	
	public void enterAssessmentStandardScore(String Text)
	{
		AssessmentStandardScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"wiat_iv_percent_1\"]")
	WebElement subtestPercentile;
	
	public void entersubtestPercentile(String Text)
	{
		subtestPercentile.sendKeys(Text);
	}
	
	@FindBy(xpath = "//textarea[@id=\"wiat_iv_description_1\"]")
	WebElement SubtestDescription;
	
	public void enterSubtestDescription(String Text)
	{
		SubtestDescription.sendKeys(Text);
	}
	
	//Current Evaluation Results
	
	@FindBy(xpath = "//input[@id=\"cer_score_range_id\"]")
	WebElement studentStandardScore;
	
	public void enterstudentStandardScore(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",RangeInSpelli2);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		studentStandardScore.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"cer_weakness_id\"]")
	WebElement AreaOfWeakness;
	
	public void enterAreaOfWeakness(String Text)
	{
		AreaOfWeakness.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_verbal_skill_id\"]")
	WebElement ProcessingSpeed;
	
	public void enterProcessingSpeed(String Text)
	{
		ProcessingSpeed.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_answer_id\"]")
	WebElement verbelComprenhension;
	
	public void enterverbelComprenhension(String Text)
	{
		verbelComprenhension.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_ideas_id\"]")
	WebElement AnswerQuestion;
	
	public void enterAnswerQuestion(String Text)
	{
		AnswerQuestion.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_verbal_speed_id\"]")
	WebElement speedOfProcessing;
	
	public void enterspeedOfProcessing(String Text)
	{
		speedOfProcessing.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_math_solving_id\"]")
	WebElement ComprehensionAbilities;
	
	public void enterComprehensionAbilities(String Text)
	{
		ComprehensionAbilities.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_spelling_id\"]")
	WebElement MathProbledmSolving;
	
	public void enterMathProbledmSolving(String Text)
	{
		MathProbledmSolving.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_oral_discourse_id\"]")
	WebElement RangeInSpelli2;
	
	public void enterRangeInSpelling(String Text)
	{
		RangeInSpelli2.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_numerical_range_id\"]")
	WebElement oralDiscourse;
	
	public void enteroralDiscourse(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",significantBehavioural);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		oralDiscourse.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_listening_range_id\"]")
	WebElement NumericalOperations;
	
	public void enterNumericalOperations(String Text)
	{
		NumericalOperations.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_reading_range_id\"]")
	WebElement ListeningComprehension;
	
	public void enterListeningComprehension(String Text)
	{
		ListeningComprehension.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_receptive_listen_id\"]")
	WebElement ReadingComprehension;
	
	public void enterReadingComprehension(String Text)
	{
		ReadingComprehension.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_confidential_id\"]")
	WebElement ReceptiveListening;
	
	public void enterReceptiveListening(String Text)
	{
		ReceptiveListening.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_enxiety_id\"]")
	WebElement BehaviourRatingScales;
	
	public void enterBehaviourRatingScales(String Text)
	{
		BehaviourRatingScales.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_depression_id\"]")
	WebElement ScoreOnDepression;
	
	public void enterScoreOnDepression(String Text)
	{
		ScoreOnDepression.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"ps_problem_id\"]")
	WebElement significantBehavioural;
	
	public void entersignificantBehavioural(String Text)
	{
		significantBehavioural.sendKeys(Text);
	}
	
	@FindBy(xpath = "//textarea[@id=\"recommendations_main\"]")
	WebElement Recommendations;
	
	public void enterRecommendations(String Text)
	{
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].scrollIntoView();",significantBehavioural);
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Recommendations.sendKeys(Text);
	}
	
	@FindBy(xpath = "//input[@id=\"validity_true_result\"]")
	WebElement ValidityStatement;
	
	public void clickOnValidityStatement()
	{
		ValidityStatement.click();
	}
	
	@FindBy(xpath = "//canvas[@name=\"signature-pad\"]")
	WebElement Signature;
	
	public void enterSignature()
	{
		Signature.click();
	} 
	
	@FindBy(xpath = "//button[@id=\"save_etr_btn\"]")
	WebElement SubmitDocument;
	
	public void clickSubmitDocument() throws InterruptedException
	{
		SubmitDocument.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//button[@id=\"edit_etr_btn\"]")
	WebElement SubmitExternalDocument;
	
	
	public void clickSubmitExternalDocumentt() throws InterruptedException
	{
		SubmitExternalDocument.click();
		Thread.sleep(2000);
		Set<String> windowHandles = ldriver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		ldriver.switchTo().window(handles.get(0));
		Thread.sleep(2000);
	}
}
