package qa.crm.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

public class demo {
	
@Test(dataProvider="dataproviderdemo2", dataProviderClass=dataproviderdemo.class)

public static void getdata(Hashtable<String, String> t) {
	

System.out.println(" hashtable----"+ t);
	
} 

} 
