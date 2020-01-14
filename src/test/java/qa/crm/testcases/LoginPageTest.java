package qa.crm.testcases;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
import qa.crm.utility.TestUtility;


public class LoginPageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;	
	
	
@BeforeTest
	public void ExtentReportsetup() {	
/*	reporter = new ExtentHtmlReporter("./Result.html");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	log = Logger.getLogger(LoginPageTest.class);*/
	
		
	}

@BeforeMethod
public void PageSetup() throws InterruptedException  {

loginpage = new LoginPage();
	}

@Test(priority=1, enabled = true)
public void validateLoginImage() {
		
	log.info(" ------Test 1 started ----");	
	Boolean value=loginpage.validateCRMImage();	
	test=extent.createTest("----validateLoginImage----");	
	Assert.assertTrue(value);
	log.info(" ------Test 1 completed ----rajiv seen it---");	
	
	}

@Test(priority=2, enabled = true)
public void validateLoginPageTitle(){
	 String name1=loginpage.validateloginTitle();
	 log.info(" ------Test 2 started ----");
	 test=extent.createTest("----validateLoginPageTitle----");
	 Assert.assertEquals(name1,"CRMPRO Log In Screen");
	 log.info(" ------Test 2 completed ----");
	 
	}

@Test(priority=3, enabled = false)
public void LoginTest(){
	log.info(" ------Test 3 started ----");
 //homePage=loginPage.login("joyrajiv42", "rajiv7605");
	homepage=loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));
	test=extent.createTest("-----LoginTest-----");
	log.info(" ------Test 3 done before assertion ----");
Assert.assertTrue(true);
log.info(" ------Test 3 After assertion... ----");

	 } 

@DataProvider(name="datafromObject")
public Object [][] getdata() throws Throwable {
	
	Object [][] data=TestUtility.getdata("Sheet1");
	return data;
	
}

@Test(priority=4,dataProvider="datafromObject")
public void demo(String fname, String lname, String address, String empid, String month) {
	
	System.out.println(" dataprovided working -------- "+ fname + lname + address + empid + month );
	
} }

/*@AfterMethod()
public static void setup(ITestResult result) throws Throwable  {

	System.out.println("----@AfterMethod() >>>LoginPage---- called---");
if(result.getStatus()==ITestResult.FAILURE) {
	
	
test.fail("test is failed" , MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Rajiv\\maven\\POM_Project\\ScreenShot\\LoginTest.jpg").build());
	
}

else if (result.getStatus()==ITestResult.SUCCESS) {
	test.pass(" test is passed " , MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Rajiv\\maven\\POM_Project\\ScreenShot\\LoginTest.jpg").build());
	}

else if (result.getStatus()==ITestResult.SKIP) {
	test.skip("Test is skipped" , MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Rajiv\\maven\\POM_Project\\ScreenShot\\LoginTest.jpg").build());	
	
			}

extent.flush();
System.out.println("---Repor Flush has been done---");
if(driver!=null)
{
	driver.quit();
}

log.info(" ------|||| browser closed |||||----");
	}

	
}*/

/*@AfterTest
public void closeTest() {
	extent.flush();
	if(driver!=null)
	{
		driver.quit();
	}
	
	log.info(" ------|||| browser closed |||||----");
	
		}*/

/*@AfterTest
public static void CloseReport() {

	extent.flush();
}*/

