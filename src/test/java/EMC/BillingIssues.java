package EMC;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.EMC.PageObject.BillingPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.testcases.BaseClass;

public class BillingIssues extends BaseClass {

	@Test
	public void billingIssues() throws InterruptedException
	{

		driver.manage().window().maximize();

		WebElement Username = driver.findElement(By.xpath("//input[@id=\"login\"]"));
		Username.sendKeys("sagar_admin");

		WebElement Password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		Password.sendKeys("SagarAdmin@123");

		WebElement LoginButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
		LoginButton.click();

		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnFinance();
		
		BillingPage billingPage = new BillingPage(driver);
		billingPage.clickOnBilling();
		billingPage.selectBillingCategory("Direct Pay");
		billingPage.clickOnOrganizationDrop("Acceleration_orgTest");
		billingPage.search();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");


		// Missing Digital Document.....

		try {

			WebElement missingDocument = driver.findElement(By.xpath("(//a[text()=\"Missing Digital Form\"])[1]"));

			boolean display = missingDocument.isDisplayed();

			if(display)
			{
				Thread.sleep(2000);
				executor.executeScript("arguments[0].click();", missingDocument);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

				Set<String> windowHandles = driver.getWindowHandles();
				List<String> handles = new ArrayList<String>();
				handles.addAll(windowHandles);
				driver.switchTo().window(handles.get(1));
				driver.navigate().refresh();
				Thread.sleep(2000);

				WebElement uploadManualFile = driver.findElement(By.xpath("//i[@id=\"getParticipantId\"]"));
				executor.executeScript("arguments[0].click();", uploadManualFile);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				WebElement chooseFile = driver.findElement(By.xpath("//input[@name=\"upload_file\"]"));
				chooseFile.sendKeys("C:\\Users\\sanke\\Desktop\\Digital_Document.png");

				Thread.sleep(1000);
				WebElement uploadButton = driver.findElement(By.xpath("//button[@id=\"import_button\"]"));
				uploadButton.click();
				Thread.sleep(2000);
				System.out.println(".....Missing Digital form issue has resolved successfully....");
				driver.close();
				driver.switchTo().window(handles.get(0));

				WebElement search = driver.findElement(By.xpath("//button[@id=\"btnFiterSubmitSearch\"]"));
				executor.executeScript("arguments[0].click();", search);
				Thread.sleep(2000);
			} 
		} 
		catch (NoSuchElementException e) {

			System.out.println(".....missing document issue is not present.....");
		}

		// Missing Payer Page.....

		try {

			WebElement Missing_Payer_Page = driver.findElement(By.xpath("(//a[text()=\"Missing Payer Page\"])[1]"));
			boolean DISPLAY = Missing_Payer_Page.isDisplayed();

			if (DISPLAY) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				executor.executeScript("arguments[0].click();", Missing_Payer_Page);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


				Set<String> windowHandles = driver.getWindowHandles();
				List<String> handles = new ArrayList<String>();
				handles.addAll(windowHandles);
				driver.switchTo().window(handles.get(1));
				driver.navigate().refresh();
				Thread.sleep(2000);

				WebElement paymentType = driver.findElement(By.xpath("//select[@id=\"payment_type_id\"]"));
				Select select = new Select(paymentType);
				select.selectByVisibleText("Direct Pay");


				WebElement SelectRate = driver.findElement(By.xpath("//select[@id=\"rate\"]"));
				Select select2 = new Select(SelectRate);
				select2.selectByVisibleText("By Minute");

				WebElement SelectMinutes = driver.findElement(By.xpath("//select[@id=\"minutes\"]"));
				Select select1 = new Select(SelectMinutes);
				select1.selectByVisibleText("1");

				WebElement Amount = driver.findElement(By.xpath("//input[@id=\"amount\"]"));
				Amount.sendKeys("1");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				WebElement AddPayerPage = driver.findElement(By.xpath("//button[@id=\"payerbtn_Add\"]"));
				AddPayerPage.click();
				
				Thread.sleep(2000);
				driver.close();
				driver.switchTo().window(handles.get(0));
				System.out.println("....Missing Payer Page Issue has resolved Successfully....");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

				WebElement search = driver.findElement(By.xpath("//button[@id=\"btnFiterSubmitSearch\"]"));
				executor.executeScript("arguments[0].click();", search);

			}

		} catch (NoSuchElementException e) {

			System.out.println("....Missing Payer Page issue is not present....");
		}

		
		// Missing Mileage.....
		
		try {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement Missing_Mileage = driver.findElement(By.xpath("(//a[text()=\"Missing Mileage\"])[1]"));
			boolean DisplayMileage = Missing_Mileage.isDisplayed();

			if (DisplayMileage) {

				executor.executeScript("arguments[0].click();", Missing_Mileage);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> handles = new ArrayList<String>();
				handles.addAll(windowHandles);
				driver.switchTo().window(handles.get(1));
				
				driver.navigate().refresh();
				Thread.sleep(2000);
				WebElement Mileage = driver.findElement(By.xpath("//input[@id=\"mileage\"]"));
			    Mileage.sendKeys("20");
			    Thread.sleep(3000);
			    
			    System.out.println("....Missng Mileage Issue has resolved Successfully");
				driver.switchTo().window(handles.get(0));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				WebElement search1 = driver.findElement(By.xpath("//button[@id=\"btnFiterSubmitSearch\"]"));
				executor.executeScript("arguments[0].click();", search1);
				
				Thread.sleep(3000);
				executor.executeScript("window.scrollBy(0,400)", "");
			    
			}
			
		} catch (NoSuchElementException e) {
			
			System.out.println("....Missing Mileage issue is not present....");
		}

		//Missing CPT Code.......

		try {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement missing_CPTC_ode = driver.findElement(By.xpath("(//a[text()=\"Missing CPT Code\"])[1]"));
			boolean Display = missing_CPTC_ode.isDisplayed();

			if (Display) {

				executor.executeScript("arguments[0].click();", missing_CPTC_ode);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				WebElement noCptCodeRequired = driver.findElement(By.xpath("//input[@id=\"cpt_required\"]"));
				executor.executeScript("arguments[0].click();", noCptCodeRequired);

				WebElement SaveCptCode = driver.findElement(By.xpath("//button[text()=\"Save CPT codes\"]"));
				SaveCptCode.click();
				Thread.sleep(5000);
				System.out.println(".....Missing CPT Code issue has resolved successfully.....");
				WebElement search1 = driver.findElement(By.xpath("//button[@id=\"btnFiterSubmitSearch\"]"));
				executor.executeScript("arguments[0].click();", search1);
				executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			}
		} catch (NoSuchElementException e) {

			System.out.println(".....Missing CPT Code issue is not present.....");
		}

		

	}

}
