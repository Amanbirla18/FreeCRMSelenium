package testutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "\\C:\\Selenium_Workspace\\FreeCRM\\src\\main\\java\\testdata\\Pom_Data.xlsx";
	static Xls_Reader reader;

	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	 public void scrollPagedown( WebDriver driver){
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	 }
	 
	 public void scrollIntoView(WebElement element ,WebDriver driver){
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
			
	 }
	 public static ArrayList<Object[]> getTestData() {
		 
	 ArrayList<Object[]> mydata = new  ArrayList<Object[]>();
	 
		 reader = new Xls_Reader(TESTDATA_SHEET_PATH);
		 for(int rowNum = 2; rowNum<=reader.getRowCount("Contacts"); rowNum++){
			 String title = reader.getCellData("Contacts", "Title", rowNum);
			 String firstname = reader.getCellData("Contacts", "FirstName", rowNum);
			 String lastname = reader.getCellData("Contacts", "LastName", rowNum);
			 String company = reader.getCellData("Contacts", "Company", rowNum);
			
			Object obj[] = {title, firstname,lastname,company};
			mydata.add(obj);
}
		 return mydata;
		 
		 
	 }
	 
	 public static Object[][] getTestData(String sheetName) {
			
			FileInputStream file = null;
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				Workbook book = null;
				try {
					book = WorkbookFactory.create(file);
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			Sheet sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					// System.out.println(data[i][k]);
				}
			}
			return data;
		}
	 public static String takeSnapShot(WebDriver driver,String testmethodname) throws Exception {
		 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot ts =(TakesScreenshot)driver;
	        
	        File Source=ts.getScreenshotAs(OutputType.FILE);
	        
	        String dest = "C:/ExtentReports/SC1/" + testmethodname + "_"+ dateName+ ".png";
	        System.out.println("");
	        File Destination =new File(dest);
			FileUtils.copyFile(Source, Destination);
	        System.out.println("");
	        System.out.println("Screenshot taken");
	        return dest;
	                               

	    }

	}
	
	 
