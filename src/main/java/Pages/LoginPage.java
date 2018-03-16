package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import testutils.TestUtil;

public class LoginPage extends TestBase {

	TestUtil tu;
	//PageFactory - Object Repository 
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement Loginbtn;
	
	@FindBy(xpath = "//button[contains(text(), 'Sign Up')]")
	WebElement SignUpbtn;
	
	@FindBy(xpath = "(//img[@class ='img-responsive'])[1]")
	WebElement FreeCRMLogo;
	
	//Initializing the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	// this is used for current variables of the class
		
	}
	
	
	
	public String ValidateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public SignUpPage ClickonSignUp(){
		SignUpbtn.click();
		return new SignUpPage();
		
	}
	public boolean ValidateCRMImage(){
		return FreeCRMLogo.isDisplayed();
	}
	
	public HomePage Login(String un, String pwd) throws InterruptedException  {
		username.sendKeys(un);
		password.sendKeys(pwd);
		//clickOn(driver, Loginbtn, 5000);
		Thread.sleep(5000);
	    Loginbtn.click();
		return new HomePage();
		
	}
}
