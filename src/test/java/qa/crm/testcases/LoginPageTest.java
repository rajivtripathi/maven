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
import org.testng.xml.LaunchSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseclass.TestBase;
import qa.crm.page.HomePage;
import qa.crm.page.LoginPage;



public class LoginPageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;	
	


@BeforeMethod
public void PageSetup() throws InterruptedException  {

	openBrowser();
	System.out.println("----openBrowser()----");
loginpage = new LoginPage();

	}

@Test(priority=1, enabled = true)
public void validateLoginImage() {
		
	
	Boolean value=loginpage.validateCRMImage();	
	Assert.assertTrue(value);
	
	
	}

@Test(priority=2, enabled = false)
public void validateLoginPageTitle(){
	 String name1=loginpage.validateloginTitle();
	
	 Assert.assertEquals(name1,"CRMPRO Log In Screen");
	 
	 
	}

@Test(priority=3, enabled = false)
public void LoginTest(){
	
 //homePage=loginPage.login("joyrajiv42", "rajiv7605");
	homepage=loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));	
Assert.assertTrue(true);


	 } 


@AfterMethod()
public void setup()  {

driver.quit();


}

}