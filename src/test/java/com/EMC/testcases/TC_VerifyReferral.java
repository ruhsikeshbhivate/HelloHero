package com.EMC.testcases;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.EMC.PageObject.ReferralPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_VerifyReferral extends BaseClass{

	Faker faker = new Faker(new Locale("en-US"));

	@Test
	public void verifyReferral() throws InterruptedException
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
		referralPage.selectStudent("Add New Student");
		referralPage.clickOnNext();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement StudentFirstName=driver.findElement(By.xpath("//input[@name=\"student_first_name\"]"));
		StudentFirstName.sendKeys(faker.name().firstName());
		String StudentName = StudentFirstName.getAttribute("value");
		System.out.println("Student First Name : " + StudentName);
		
		
		WebElement StudentLastName=driver.findElement(By.xpath("//input[@name=\"student_last_name\"]"));
		StudentLastName.sendKeys(faker.name().lastName());

		WebElement StudentDob=driver.findElement(By.xpath("//input[@id=\"student_dob\"]"));
		StudentDob.click();

		WebElement SchoolId=driver.findElement(By.xpath("//input[@id=\"student_school_id\"]"));
		SchoolId.sendKeys("803883");

		WebElement StudentsAddress=driver.findElement(By.xpath("//input[@name=\"student_address1\"]"));
		StudentsAddress.sendKeys(faker.address().streetAddress());

		Thread.sleep(1000);
		WebElement city=driver.findElement(By.xpath("//input[@id=\"student_city\"]"));
		city.sendKeys("NewYork");

		WebElement ZipCode=driver.findElement(By.xpath("//input[@id=\"student_zipcode\"]"));
		ZipCode.sendKeys("10005");

		WebElement Next=driver.findElement(By.xpath("(//button[@id=\"goToContactInfo\"])[1]"));
		Next.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement ContactFirstName=driver.findElement(By.xpath("//input[@id=\"main_contact_first_name\"]"));
		ContactFirstName.sendKeys(faker.name().lastName());

		WebElement ContactLatName=driver.findElement(By.xpath("//input[@id=\"main_contact_last_name\"]"));
		ContactLatName.sendKeys(faker.name().lastName());

		WebElement ContactPhone=driver.findElement(By.xpath("//input[@id=\"main_contact_phone\"]"));
		ContactPhone.sendKeys("8077988803");

		WebElement MailConatctEmail=driver.findElement(By.xpath("//input[@id=\"main_contact_email\"]"));
		MailConatctEmail.sendKeys("rushikesh.bhivate@gmail.com");

		WebElement Relationship=driver.findElement(By.xpath("//select[@id=\"main_contact_relationship\"]"));
		Select select = new Select(Relationship);
		select.selectByVisibleText("Guardian");

		WebElement Next1=driver.findElement(By.xpath("(//button[@id=\"goToTherapyInfo\"])"));
		Next1.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement ServiceRequested=driver.findElement(By.xpath("//select[@id=\"service_requested\"]"));
		Select select1 = new Select(ServiceRequested);
		select1.selectByVisibleText("Occupational Therapist (OT)");
		
		String Discipline = ServiceRequested.getAttribute("value");
		System.out.println("Discipline : " + Discipline);
		
		WebElement ScheduleType=driver.findElement(By.xpath("//select[@id=\"schedule_type\"]"));
		Select select2 = new Select(ScheduleType);
		select2.selectByVisibleText("Session");

		Thread.sleep(3000);
		WebElement ScheduleSubType=driver.findElement(By.xpath("//select[@id=\"schedule_subtype\"]"));
		Select select3 = new Select(ScheduleSubType);
		select3.selectByVisibleText("General");

		WebElement SessionLength=driver.findElement(By.xpath("//input[@id=\"session_length\"]"));
		SessionLength.sendKeys("10");

		WebElement StartDate=driver.findElement(By.xpath("//input[@id=\"service_start_date\"]"));
		StartDate.click();

		WebElement EndDate=driver.findElement(By.xpath("//input[@id=\"service_end_date\"]"));
		EndDate.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement Date=driver.findElement(By.xpath("(//td[text()=\"4\"])[8]"));
		Date.click();

		WebElement Frequency=driver.findElement(By.xpath("//select[@id=\"intervalInfo\"]"));
		Select select4 = new Select(Frequency);
		select4.selectByVisibleText("Daily");

		WebElement NoOfTimes=driver.findElement(By.xpath("//input[@id=\"numOfTime\"]"));
		NoOfTimes.sendKeys("1");

		WebElement AddService=driver.findElement(By.xpath("(//button[@id=\"btn_service_add\"])"));
		AddService.click();
		Thread.sleep(4000);
		
		WebElement Submit=driver.findElement(By.xpath("(//button[@id=\"goToContactInfo\"])[3]"));
		Submit.click();
		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement search=driver.findElement(By.xpath("(//button[@id=\"btnFiterSubmitSearch\"])"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", search);
		//search.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		int NoOfRows = 1;
		int totalColumns = 1;

		for(int i=1;i<=NoOfRows;i++)
		{

			System.out.print(i+" : ");

			for(int j=1;j<=totalColumns;j++)
			{
				WebElement Value =driver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[5]"));
				String Student = Value.getText();
				System.out.println(Student);		

				WebElement Value1 =driver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[6]"));
				String Organization = Value1.getText();
				System.out.println(Organization);	

				WebElement Value2 =driver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[8]"));
				String Discipline1 = Value2.getText();
				System.out.println(Discipline1);

				WebElement Value3 =driver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[9]"));
				String Service = Value3.getText();
				System.out.println(Service);

				WebElement Value4 =driver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[10]"));
				String Subtype = Value4.getText();
				System.out.println(Subtype);

				WebElement Value5 =driver.findElement(By.xpath("//table[@id=\"data-table\"]/tbody/tr["+i+"]/td[12]"));
				String SessionLength1 = Value5.getText();
				System.out.println(SessionLength1);

				if (Student.contains(StudentName) == true  && Organization.contentEquals("Rushi_TestOrganization")==true
						&& Discipline.contentEquals(Discipline) && Service.contentEquals("Session")
						&& Subtype.contentEquals("General") || SessionLength1.contentEquals("10"))  {

					System.out.println("Result is getting correct.....");
				}

				else {
					System.out.println("Result is getting wrong.....");
				}
			}
		}
		
		System.out.println(StudentName);
	}
}
