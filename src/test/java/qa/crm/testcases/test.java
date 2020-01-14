package qa.crm.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.crm.page.LoginPage;




public class test {
	
	static LoginPage loginPage;	

@BeforeTest
public void demo () {
	
	loginPage = new LoginPage();
	loginPage.login("acd", "rajiv");
	System.out.println(" doneee");

	}
}