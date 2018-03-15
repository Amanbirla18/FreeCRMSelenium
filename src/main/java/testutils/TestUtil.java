package testutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	 public static void scrollPagedown( WebDriver driver){
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	 }
	 
	 public static void scrollIntoView(WebElement element ,WebDriver driver){
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
	 }
}
