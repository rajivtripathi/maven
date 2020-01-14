package baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import qa.crm.page.HomePage;
import qa.crm.page.LoginPage;
import qa.crm.testcases.LoginPageTest;
import qa.crm.utility.WebEventListener;


public class TestBase {	
	public static Properties prop;
	public static WebDriver driver;		
	public ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test ;
	public static Logger log ;
	

	 
	/*public static EventFiringWebDriver edriver;
	public static WebEventListener eventListener;
	
	
	edriver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	edriver.register(eventListener);
	driver = edriver;*/

public TestBase(){
try{

System.out.println(" ---test base Constructor initiaized ---");	
File src = new File("./src/main/resources/config.properties");
FileInputStream fs = new FileInputStream(src);	
prop = new Properties();
prop.load(fs); 
}
catch(Exception e) {
	System.out.println(e.getMessage());
	System.out.println(e.getStackTrace());
	
	
}	
} 


public static void openBrowser(String mybrowser) throws InterruptedException {

mybrowser= prop.getProperty("browser");
System.out.println(prop.getProperty("browser"));
//if (browsername.equalsIgnoreCase("chrome"))

	if (mybrowser.equalsIgnoreCase("chrome"))
	
{ 	 
		System.out.println(" ---chrome Launching----");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	    driver = new ChromeDriver(); 	   
	    
} 

else if (mybrowser.equalsIgnoreCase("firefox"))
	
{ System.out.println(" ---firefox Launching----");
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rajiv\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	driver= new FirefoxDriver();
 
}
driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
System.out.println(" ----browser lanched-----");
driver.get(prop.getProperty("url"));
System.out.println(" browser maximized");

} 

@BeforeMethod
@Parameters("mybrowser")
public void setup() throws InterruptedException  {

	System.out.println("----@BeforeMethod >>>LoginPage---- called---");
	reporter = new ExtentHtmlReporter("./ExtentReports/Result.html");
	reporter.setAppendExisting(true);
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	log = Logger.getLogger(LoginPageTest.class);
log.info(" ------browser initialization started ----");
openBrowser("mybrowser");
log.info(" ------browser initialization done ----");

	}

@AfterMethod()
public static void setup(ITestResult result) throws Throwable  {

	extent.flush();
	System.out.println("---Repor Flush has been done---");
	
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


if(driver!=null)
{
	driver.quit();
}

log.info(" ------|||| browser closed |||||----");
	}

	


}