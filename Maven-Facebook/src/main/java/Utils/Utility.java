package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
			
	public static void captureScreenShot(WebDriver driver,int TestID) throws IOException {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE); 
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
	String timestamp = sdf.format(d);
	File dest = new File ("G:\\Husain\\Velocity Software Testing Course\\Automation\\New folder\\screenshot\\TestID- "+ TestID + "  "+timestamp+".jpg");
	FileHandler.copy(src, dest);
}
	
	public static String excelData(String shName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	  {
	    String strData;
	    double numData;
	    
	    String path = "G:\\Husain\\Velocity Software Testing Course\\Automation\\New folder\\Test.xlsx";
	    FileInputStream file = new FileInputStream(path);
	    Workbook wb = WorkbookFactory.create(file);
	    try 
	    {
	      strData = wb.getSheet(shName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	    }    
	    
	    catch(IllegalStateException e)
	    {
	      numData = wb.getSheet(shName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	      strData = String.valueOf(numData);
	    }
	    return strData;
	  }
	}



