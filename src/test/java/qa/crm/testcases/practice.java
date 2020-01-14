package qa.crm.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseclass.TestBase;



public class practice extends TestBase{

@Parameters("mybrowser")
@BeforeSuite
public static void demobeforesuite(String mybrowser) throws InterruptedException {
	
	initialization(mybrowser);
	System.out.println("--before suite----");
}

@BeforeTest
	public static void ExtentReportsetup() {
	
	System.out.println("--before test----");
}
			

@Test(priority=1)
public void demotest1() {
	System.out.println("-----test 1-----" );
	
	}

@Test(priority=2)
public void demotest2() {
	System.out.println("-----test 2-----" );
	
	}


@Test(priority=3)
public void demotest3() {
	System.out.println("-----test 3-----" );
	
	}

@Test(priority=4)
public void demotest4(){
	System.out.println("-----test 4-----" );
	 
	}

@AfterTest
public void closeTest() {
	
	System.out.println("----test closed---");	
}


@AfterSuite
public static void demoAfteresuite() {

System.out.println("--after suite----");
}
}
