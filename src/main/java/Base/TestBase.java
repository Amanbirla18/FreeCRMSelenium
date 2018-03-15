package Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import testutils.TestUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testutils.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){  //Constructor 
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Selenium_Workspace/FreeCRM/src/main/java/config/config.properties");
				prop.load(ip);	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e)	{
			e.printStackTrace();
		}	
	}
	
	

	 public static void initialization(){
		 String browserName = prop.getProperty("browser");
		 if(browserName.equals("chrome")){
		 System.setProperty("webdriver.chrome.driver", "C:\\NewGeckoDriver\\chromedriver.exe"); 
		 driver = new ChromeDriver();
	 } else if (browserName.equals("firefox")){
		 System.setProperty("webdriver.gecko.driver", "C:\\NewGeckoDriver\\geckodriver.exe");
	     driver = new FirefoxDriver();
		 
	 }
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	 }
	 public static void clickOn(WebDriver driver, WebElement locator, int timeout){
			new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
		}
}

	

