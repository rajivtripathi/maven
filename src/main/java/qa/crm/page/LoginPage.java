package qa.crm.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.TestBase;

public class LoginPage extends TestBase {


@FindBy(xpath="//*[@name='username']")
WebElement username;

@FindBy(xpath="//*[@name='password']")
WebElement password;

@FindBy(xpath="//img[@class='img-responsive']")
WebElement image;

@FindBy(xpath="//*[@type='submit']")
WebElement loginbtn;

               

public LoginPage(){
	
	this.driver=driver;
	System.out.println(" ---- its Login Page Constructor---");
	PageFactory.initElements(driver, this);
}

public String validateloginTitle(){
	
	String title= driver.getTitle();
	return title;
}

public boolean validateCRMImage(){
	
	return image.isDisplayed();
	
}

public HomePage login(String uid,String pwd) {
	username.sendKeys(uid);
	password.sendKeys(pwd);
	loginbtn.submit();
	return new HomePage();
	
}

public HomePage login1(String un, String pwd) {
  username.sendKeys(un);
  password.sendKeys(pwd);
  JavascriptExecutor js = (JavascriptExecutor)driver;
  js.executeScript("arguments[0].click();", loginbtn);
  return new HomePage();

}
}
