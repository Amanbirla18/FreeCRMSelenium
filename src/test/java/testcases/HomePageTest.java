package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.ContactsPage;
import Pages.HomePage;
import Pages.LoginPage;
import testutils.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage hp;
	LoginPage lp;
	TestUtil tu;
	ContactsPage cp;
	
	
	public HomePageTest(){
		super();
	// super keyword first calls the constructor of the parent call (Test Base) which will initialize the
	// 	the properties in the parent class constructor  
	// when we calling the  initialization(); method it is must to initilize the property 
	}

	@BeforeMethod 
	  public void SetUp() throws InterruptedException{
		 initialization();
		 lp = new LoginPage();
		 tu = new TestUtil();
		 cp = new ContactsPage();
		 hp= lp.Login(prop.getProperty("username"), prop.getProperty("password"));
		 
	  }
	  @AfterMethod
	  public void TearDown(){
	  driver.quit();
	  }
	  
	  @Test(priority = 1)
	  public void verifyHomePageTitleTest(){
		String homepagetitle =  hp.ValidateHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO");
	  }
	  
	  @Test(priority = 2)
	  public void verifyUserNameTest(){
		  tu.switchToFrame();
		  Assert.assertTrue(hp.verifyUserName());
		
	  }  
	  @Test(priority = 3)
	  public void verifyContactsLinkTest(){
		  tu.switchToFrame();
		  cp= hp.clickOnContactsLink();
		 
		  
		  
	  } 
}
