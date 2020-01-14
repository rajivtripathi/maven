package qa.crm.demo;
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
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseclass.TestBase;
import qa.crm.page.HomePage;
import qa.crm.page.LoginPage;
import qa.crm.utility.TestUtility;


public class Child {
	
	@BeforeTest
	public void setupbeforeTest() {		
		
	System.out.println("---Child >>>---@BeforeTest----");	
			
		}
	
	@AfterTest
	public void tearupAfterTest() {		
		
	System.out.println("--Child >>>----@AfterTest----");	
			
		}
	
@BeforeMethod
public void setup() {		
	
System.out.println("---Child >>>@BeforeMethod----");	
		
	}
	
@Test
	public void test3() {		
			
	System.out.println("---Child >>>test3----");	
			
		}
	
@AfterMethod
	public void tearup() {		
		
	System.out.println("--Child >>>---@AfterMethod----");	
			
		}

}
