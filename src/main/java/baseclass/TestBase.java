package baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import qa.crm.page.HomePage;
import qa.crm.page.LoginPage;
import qa.crm.testcases.LoginPageTest;



public class TestBase {	
	public static Properties prop;
	public static WebDriver driver;

public TestBase(){
try{

System.out.println(" ---test base Constructor initiaized ---");	
File src = new File("./src/main/resources/config.properties");
FileInputStream fs = new FileInputStream(src);	
prop = new Properties();
prop.load(fs); 
}
catch(Exception e) {
	
	
	
}	
} 


public static void openBrowser() throws InterruptedException {

	String mybrowser;
mybrowser= prop.getProperty("browser");
System.out.println("------browser----"+ mybrowser);
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






}