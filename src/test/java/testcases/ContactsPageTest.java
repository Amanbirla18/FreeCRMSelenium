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

public class ContactsPageTest extends TestBase{


	HomePage hp;
	LoginPage lp;
	TestUtil tu;
	ContactsPage cp;
	
public ContactsPageTest(){
	super();
}

	@BeforeMethod 
	public void SetUp() throws InterruptedException{
	 initialization();
	 lp = new LoginPage();
	 tu = new TestUtil();
	 cp = new ContactsPage();
	 hp= lp.Login(prop.getProperty("username"), prop.getProperty("password"));
	 tu.switchToFrame();
	 cp= hp.clickOnContactsLink();
	 
}
	@AfterMethod
	public void TearDown(){
	//driver.quit();
}
	@Test
	public void verifyContactLabelTest(){
		Assert.assertTrue(cp.verifyContactslabel());
		}
	@Test
	public void selectContactscheckboxbynameTest(){
		cp.selectContactscheckboxbyname("Aman Test1");
		cp.selectContactscheckboxbyname("Aman Test2");
		}
}