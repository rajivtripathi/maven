package qa.crm.utility;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CallData {

	
	
	@DataProvider
	public Object getdata() throws Throwable {
			
			Object [][] data=TestUtility.getdata("Sheet1");
			return data;
			
		}

@Test(dataProvider="getdata")
		public void demo(String fname, String lname, String address, String empid, String month) {
			
	System.out.println(" dataprovided working -------- "+ fname + lname + address + empid + month );
			
		
		
	}

}
