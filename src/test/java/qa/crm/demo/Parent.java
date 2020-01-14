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


public class Parent {

	@BeforeMethod
	public void setup() {		
		
	System.out.println("---Parent----@BeforeMethod----");	
			
		}
	
	@AfterMethod
	public void tearup() {		
		
	System.out.println("---Parent----@AfterMethod---");	
			
		}

@Test
public void test1() {		
		
System.out.println("---Parent----test1----");	
		
	}

@Test
public void test2() {		
		
System.out.println("---Parent----test2----");	
		
	}

}
