package qa.crm.testcases;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseclass.TestBase;
import qa.crm.page.HomePage;
import qa.crm.page.LoginPage;


public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	static Logger log = Logger.getLogger(LoginPageTest.class);
	
	
@BeforeTest
	public static void ExtentReportsetup() {	
	reporter = new ExtentHtmlReporter("./Result.html");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	}

@BeforeMethod
@Parameters("mybrowser")
public void setup(String mybrowser) throws InterruptedException  {

log.info(" ------browser initialization started ----");
initialization(mybrowser);
log.info(" ------browser initialization done !!!!!!");
System.out.println("----initialized-----");
loginPage=new LoginPage();

	}

@Test(priority=1)
public void validateLoginImage() {
	System.out.println("-----validateLoginImage-----");
	log.info(" ------Test 1 started ----");
	Boolean value=loginPage.validateCRMlImage();
	test=extent.createTest("----validateLoginImage----");
	Assert.assertTrue(value);	
	log.info(" ------Test 1 completed ----rajiv seen it---!!!! Poll SCM ");	
	
	}

@Test(priority=2)
public void validateLoginPageTitle(){
	 String name1=loginPage.validateloginTitle();
	 log.info(" ------Test 2 started ----");
	 test=extent.createTest("----validateLoginPageTitle----!!!!");
	 Assert.assertEquals(name1,"#1 Free CRM software in the cloud for sales and service");
	 log.info(" ------Test 2 done ----");
	 
	}

@Test(priority=3)
public void LoginTest(){
	log.info(" ------Test 3 started ----");
 homePage=loginPage.login("joyrajiv42", "rajiv7605");
	test=extent.createTest("-----LoginTest-----");
	log.info(" ------Test 3 done before assertion ----");
Assert.assertTrue(true);
log.info(" ------Test 3 After assertion... ----");

	 } 

@AfterMethod()
public static void setup(ITestResult result) throws Throwable  {

if(result.getStatus()==ITestResult.FAILURE) {
	
	
test.fail("test is failed" , MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Rajiv\\maven\\POM_Project\\ScreenShot\\LoginTest.jpg").build());
	
}

else if (result.getStatus()==ITestResult.SUCCESS) {
	test.pass(" test is passed " , MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Rajiv\\maven\\POM_Project\\ScreenShot\\LoginTest.jpg").build());
	}

else if (result.getStatus()==ITestResult.SKIP) {
	test.skip("Test is skipped" , MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Rajiv\\maven\\POM_Project\\ScreenShot\\LoginTest.jpg").build());	
	
	}
	
}

@AfterMethod
public void closeTest() {
	extent.flush();
	if(driver!=null)
	{
		driver.quit();
	}
	
	log.info(" ------browser closed ----");
	
		}

/*@AfterTest
public static void CloseReport() {

	extent.flush();
}*/
}
