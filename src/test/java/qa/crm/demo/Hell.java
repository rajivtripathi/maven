package qa.crm.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hell {
	
	@BeforeMethod
	public void setup() {		
		
	System.out.println("---@BeforeMethod----");	
			
		}

@Test
public void test4() {		
		
System.out.println("---test1----");	
		
	}

}
