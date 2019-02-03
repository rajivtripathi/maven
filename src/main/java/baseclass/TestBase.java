package baseclass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;



import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import qa.crm.utility.WebEventListener;


public class TestBase {	
	public static Properties prop;
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentHtmlReporter reporter ;
	public static ExtentReports extent ;
	/*public static EventFiringWebDriver edriver;
	public static WebEventListener eventListener;
	
	
	edriver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	edriver.register(eventListener);
	driver = edriver;*/

public TestBase(){
try{

System.out.println(" ---test base initiaized ---");	
FileInputStream fs = new FileInputStream("C:\\Users\\Rajiv\\maven\\POM_Project\\config.properties");	
prop = new Properties();
prop.load(fs); 
}
catch(Exception e) {
	System.out.println(e.getMessage());
	System.out.println(e.getStackTrace());
}	
} 


public static void initialization( String mybrowser ) throws InterruptedException {

/*String browsername= prop.getProperty("browser");
System.out.println(prop.getProperty("browser"));*/
//if (browsername.equalsIgnoreCase("chrome"))

	if (mybrowser.equalsIgnoreCase("chrome"))
	
{ 	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajiv\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	    driver = new ChromeDriver(); 
	    driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
	   
	    
} 
//else if (browsername.equalsIgnoreCase("firefox"))
else if (mybrowser.equalsIgnoreCase("firefox"))
	
{
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rajiv\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
driver = new FirefoxDriver(); 
driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);


}

driver.manage().window().maximize();
driver.manage().deleteAllCookies();
System.out.println(" ----browser lanched-----");
driver.get("https://www.freecrm.com");
Thread.sleep(8000);
System.out.println(" browser maximized");
} 

}