package qa.crm.testcases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class dataproviderdemo {
	
@DataProvider(name="dataproviderdemo2")
public Object data() {	

	Hashtable< String, String > table= new Hashtable< String, String>();
	
	table.put("1", "I");
	table.put("2", "AM");
	table.put("3", "RAJIV");
	table.put("4", "TRIPATHI");	
	
	System.out.println("1sttttttt----"+ table);
	
Object a[][]=new Object[4][1];
a[0][0]=table;
a[1][0]=table;
a[2][0]=table;
a[3][0]=table;

return a;	
	
}

	
	

}
