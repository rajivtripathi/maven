package qa.crm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import baseclass.TestBase;

public class TestUtility extends TestBase{

	
public static void CapatureScreenShot(String testname) throws IOException
	{  
	System.out.println(" CapatureScreenShot called ---");
	TakesScreenshot ts=(TakesScreenshot)driver ;
	File src = ts.getScreenshotAs(OutputType.FILE);	
	FileUtils.copyFile(src, new File("./ScreenShot/"+testname+".jpg"));	
	
	}

static String path= "C:\\Users\\Rajiv\\Desktop\\data.xlsx" ;


static FileInputStream fis=null;	
static XSSFWorkbook wb= null;
static XSSFSheet sheet=null;
	
	public static Object [][] getdata( String sheetname) throws Throwable {
		
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
				
			}				
			
		}
		
		//System.out.println(data);
		return data;			
	}	
}
