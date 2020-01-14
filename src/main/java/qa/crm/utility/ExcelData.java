package qa.crm.utility;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
 static String path= "C:\\Users\\Rajiv\\Desktop\\data.xlsx" ;
	static FileInputStream fis=null;	
	static XSSFWorkbook wb= null;
	static XSSFSheet sheet=null;
		
		public static Object [][]getdata( String sheetname) throws Throwable {
			
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);		
		sheet=wb.getSheet(sheetname);		
			Object [][] data=new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				for (int j=0;j<sheet.getRow(1).getLastCellNum();j++) 
				{
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();	
		//System.out.println(data[i][j]);					
				}			}			
			//System.out.println(data);
			return data;			
		}	
		
	}		
		
	


