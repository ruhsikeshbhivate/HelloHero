package EMC;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.v112.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.EMC.PageObject.TherapistDashboardPage;
import com.EMC.PageObject.UsersPage;
import com.EMC.PageObject.dashboardPage;
import com.EMC.PageObject.loginPage;
import com.EMC.testcases.BaseClass;
import com.github.javafaker.Faker;

import net.bytebuddy.asm.Advice.OffsetMapping.Target.AbstractReadOnlyAdapter;

public class TC_CreateProviderManager1 extends BaseClass{
	Faker faker = new Faker(new Locale("en-US"));

	@Test
	public void create_ProviderManager() throws InterruptedException
	{
		driver.manage().window().maximize();

		loginPage login = new loginPage(driver);
		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();
		
		driver.get("https://stage.hellohero.com/provider-manager");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	

		dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickOnCloseButton();
		dashPage.clickOnUsers();
		dashPage.clickOnUserSearch();
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnAddUser();
		
		driver.findElement(UsersPage.userFirstName).sendKeys(faker.name().firstName());
		driver.findElement(UsersPage.userLastName).sendKeys(faker.name().lastName());
		usersPage.selectOrganization("Acceleration_orgTest");
		usersPage.selectRole("Therapist");
		driver.findElement(UsersPage.username).sendKeys(faker.name().username());
		usersPage.enterCellPhone("7262957778");
		usersPage.enterUserPassword("RUshikesh@123");
		usersPage.enterConfirmPassword("RUshikesh@123");

		WebElement createProfile = driver.findElement(By.xpath("//button[@id=\"create_profile\"]"));

		JavascriptExecutor executor = ((JavascriptExecutor) driver);
		executor.executeScript("arguments[0].click();", createProfile);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		WebElement search = driver.findElement(By.xpath("//button[@id=\"btnFiterSubmitSearch\"]"));
		search.click();
		Thread.sleep(3000);

		WebElement viewProfile = driver.findElement(By.xpath("//a[text()=\"View Profile\"]"));
		viewProfile.click();

		WebElement FirstName = driver.findElement(By.xpath("//input[@name=\"first_name\"]"));
		FirstName.sendKeys(Keys.CONTROL, "A");
		FirstName.sendKeys(Keys.CONTROL, "C");

		driver.navigate().refresh();
		driver.get("https://stage.hellohero.com/provider-manager");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement NewManager = driver.findElement(By.xpath("//button[text()=\"+ New Manager\"]"));
		NewManager.click();

		Thread.sleep(4000);
		WebElement selectTherapist = driver.findElement(By.xpath("(//span[@role=\"presentation\"])[3]"));
		selectTherapist.click();

		WebElement searchTherapist = driver.findElement(By.xpath("(//input[@role=\"searchbox\"])[2]"));
		searchTherapist.click();
		searchTherapist.sendKeys(Keys.CONTROL, "V");

		searchTherapist.sendKeys(Keys.ENTER);

		WebElement add = driver.findElement(By.xpath("//button[@id=\"addManager\"]"));
		add.click();
		Thread.sleep(3000);

		WebElement Manager_Providers = driver.findElement(By.xpath("//div[@id=\"managerProviderTab\"]"));
		executor.executeScript("arguments[0].click();", Manager_Providers);

		Thread.sleep(2000);
		WebElement AttachManager = driver.findElement(By.xpath("//button[@id=\"create_event\"]"));
		executor.executeScript("arguments[0].click();", AttachManager);

		Thread.sleep(4000);
		WebElement searchProviderManger = driver.findElement(By.xpath("(//b[@role=\"presentation\"])[3]"));
		searchProviderManger.click();
		Thread.sleep(1000);
		WebElement selectProviderManger = driver.findElement(By.xpath("(//input[@role=\"searchbox\"])[3]"));
		selectProviderManger.sendKeys(Keys.CONTROL, "V");
		selectProviderManger.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		WebElement TherapistName = driver.findElement(By.xpath("//input[@placeholder=\"Select Therapists\"]"));
		TherapistName.sendKeys("Alfredia Heller");
		TherapistName.sendKeys(Keys.ENTER);
		WebElement AddAttachManger = driver.findElement(By.xpath("//button[@id=\"attachManager\"]"));
		AddAttachManger.click();
		Thread.sleep(2000);

		driver.get("https://stage.hellohero.com/users");
		Thread.sleep(2000);
		usersPage.SearchOranization("Acceleration_orgTest");
		usersPage.clickOnSearch();
		
		WebElement LoginAs = driver.findElement(By.xpath("(//a[text()=\"login as\"])[1]"));
		executor.executeScript("arguments[0].click();", LoginAs);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		/*dashboardPage dashPage = new dashboardPage(driver);
		dashPage.clickONprofile();
		dashPage.clickOnSignOut();

		// Login by Therapist....
		loginPage login = new loginPage(driver);
		login.enterUsername(USERNAME);
		login.enterPassword("RUshikesh@123");
		login.clickOnLoginButton();*/
		TherapistDashboardPage dashpage = new TherapistDashboardPage(driver);
		Thread.sleep(3000);
		driver.get("https://stage.hellohero.com/users");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
		Thread.sleep(1000);
		WebElement SearchRole = driver.findElement(By.xpath("//select[@id=\"userSearchRolesSelect\"]"));
		Select select = new Select(SearchRole);
		select.selectByVisibleText("Client");
		Thread.sleep(1000);
		WebElement Search =driver.findElement(By.xpath("//button[@id=\"btnFiterSubmitSearch\"]"));
		executor.executeScript("arguments[0].click();", Search);

		Thread.sleep(3000);
		
		System.out.println(".............Provider Manager Login...........");
		WebElement Firstusername = driver.findElement(By.xpath("//table//tbody//tr[1]//td[3]"));
		String GetFirstUser = Firstusername.getText();
		System.out.println(GetFirstUser);

		WebElement Secondusername =driver.findElement(By.xpath("//table//tbody//tr[2]//td[3]"));
		String GetSecondUser = Secondusername.getText();
		System.out.println(GetSecondUser);

		WebElement profilename =driver.findElement(By.xpath("(//*[@id=\"navbarDropdown\"])[3]"));
		executor.executeScript("arguments[0].click();", profilename);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	

		dashpage.clickOnSignOut();

		login.enterUsername("wm.goodwin");
		login.enterPassword("RUshikesh@123");
		login.clickOnLoginButton();
		driver.get("https://stage.hellohero.com/users");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		WebElement Search1 =driver.findElement(By.xpath("//button[@id=\"btnFiterSubmitSearch\"]"));
		executor.executeScript("arguments[0].click();", Search1);

		Thread.sleep(2000);
		System.out.println(".............Therapist Login...........");

		WebElement Value =driver.findElement(By.xpath("//table//tbody//tr[1]//td[3]"));
		String User1 = Value.getText();
		System.out.println(User1);	

		WebElement Value1 =driver.findElement(By.xpath("//table//tbody//tr[2]//td[3]"));
		String User2 = Value1.getText();
		System.out.println(User2);

		if (GetFirstUser.contentEquals(User1)==true && GetSecondUser.contentEquals(User2)==true) {

			System.out.println("Result is getting correct.....");

		}
		else {
			System.out.println("Result is getting wrong.....");
		}

		WebElement profilename1 =driver.findElement(By.xpath("(//*[@id=\"navbarDropdown\"])[3]"));
		executor.executeScript("arguments[0].click();", profilename1);
		dashpage.clickOnSignOut();

		login.enterUsername("sagar_admin");
		login.enterPassword("Sagar_Admin@123");
		login.clickOnLoginButton();
		Thread.sleep(2000);
		driver.get("https://stage.hellohero.com/provider-manager");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	

		WebElement Manager_Providers1 = driver.findElement(By.xpath("//div[@id=\"managerProviderTab\"]"));

		executor.executeScript("arguments[0].click();", Manager_Providers1);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		
		WebElement searchtherapist = driver.findElement(By.xpath("//input[@id=\"userSearchNameInput\"]"));
		searchtherapist.sendKeys("Alfredia Heller");
		searchtherapist.sendKeys(Keys.ENTER);
		Thread.sleep(4000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	

		WebElement Detach = driver.findElement(By.xpath("//table//tbody//tr[1]//td[5]"));
		Detach.click();

		WebElement Yes = driver.findElement(By.xpath("//button[text()=\"Yes\"]"));
		executor.executeScript("arguments[0].click();", Yes);
		Thread.sleep(3000);
		
		// Login by Provider Manager.....
		driver.get("https://stage.hellohero.com/users");
		Thread.sleep(2000);
		usersPage.SearchOranization("Acceleration_orgTest");
		usersPage.clickOnSearch();
		
		WebElement LoginAs1 = driver.findElement(By.xpath("(//a[text()=\"login as\"])[1]"));
		executor.executeScript("arguments[0].click();", LoginAs1);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://stage.hellohero.com/users");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Thread.sleep(1000);
		WebElement SearchRole1 = driver.findElement(By.xpath("//select[@id=\"userSearchRolesSelect\"]"));
		Select select3 = new Select(SearchRole1);
		select3.selectByVisibleText("Client");
		Thread.sleep(1000);
		WebElement Search2 =driver.findElement(By.xpath("//button[@id=\"btnFiterSubmitSearch\"]"));
		executor.executeScript("arguments[0].click();", Search2);

		Thread.sleep(2000);

		String str = "No data available in table";

		WebElement Value3 = driver.findElement(By.xpath("//td[@class=\"dataTables_empty\"]"));
		String TableValue = Value3.getAttribute("innerText");
		System.out.println(TableValue);

		if (TableValue.contentEquals(str)==true) {

			System.out.println("Users are not found after detach therapist.....");

		}
		else {
			System.out.println("Users are found after detach therapist.....");
		}

	}
}
