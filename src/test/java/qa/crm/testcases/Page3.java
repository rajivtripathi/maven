package qa.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Page3 {
	
	
@BeforeTest
	public void beforeTest() {
		
	System.out.println("-----BeforeTest Page 3------");
	}

@BeforeMethod
public void beforeMethod () {
	
System.out.println("-----BeforeMethod Page 3------");
}


	
@Test
public void  Page3() {
	
System.out.println("------Page 3 Mehod----");
}

@AfterMethod
public void aftermthods() {
	
System.out.println("-----@AfterMethodPage Mathods------");
}

@AfterTest
public void afterTest() {
	
System.out.println("-----@AfterTest Methods------");
}

}
