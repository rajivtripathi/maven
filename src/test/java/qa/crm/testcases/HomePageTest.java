package qa.crm.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import baseclass.TestBase;
import qa.crm.page.HomePage;
import qa.crm.page.LoginPage;


public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	//Logger log = Logger.getLogger(LoginPageTest.class);

	
/*@BeforeMethod
public void setup1(String mybrowser) throws InterruptedException  {
	

	}*/
	
@Test(priority=2)
public void homePageTitle() {		
	
	loginpage = new LoginPage();
	System.out.println("---inside---HomePage---");
	homepage=loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));
	homepage = new HomePage();
	String name=homepage.verifyHomePageTitle();
	//Assert.assertEquals(name, arg1);
	test=extent.createTest("----homePageTitle----");
	Assert.assertTrue(true);
	 log.info("----Home Page test case done--");	
	
}


/*@AfterMethod()
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

extent.flush();
if(driver!=null)
{
	driver.quit();
}

log.info(" ------|||| browser closed |||||----");
	
}*/

}
