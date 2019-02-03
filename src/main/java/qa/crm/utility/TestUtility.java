package qa.crm.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import baseclass.TestBase;

public class TestUtility extends TestBase{

	
public static void CapatureScreenShot(String testname) throws IOException
	{  
	System.out.println(" CapatureScreenShot called ---");
	TakesScreenshot ts=(TakesScreenshot)driver ;
	File src = ts.getScreenshotAs(OutputType.FILE);	
	FileUtils.copyFile(src, new File("./ScreenShot/"+testname+".jpg"));	
	
	}
}
