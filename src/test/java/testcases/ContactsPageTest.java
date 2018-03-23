package testcases;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	String sheetName = "Contacts";
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
	driver.quit();
}
	@Test(priority = 1)
	public void verifyContactLabelTest(){
		String contactpagelabel = cp.verifyContactslabel();
		Assert.assertEquals(contactpagelabel, "");
		}
	@Test(priority = 2)
	public void selectContactscheckboxbynameTest(){
		cp.selectContactscheckboxbyname("Aman Test1");
		cp.selectContactscheckboxbyname("Aman Test2");
		}
	
	/*	@DataProvider
	public Iterator<Object[]> getCRMTestData() {
		ArrayList<Object[]> testdata =TestUtil.getTestData();
		return testdata.iterator();
	}
	
	@DataProvider
	public Object[][] getCRMTestData1() {
		Object data[][] =TestUtil.getTestData(sheetName);
		return data;
	
	}
	@Test(priority = 3 , dataProvider = "getCRMTestData")
	public void validateNewContact(String title, String firstname,String lastname,String company) throws InterruptedException{
		Thread.sleep(5000);
		hp.clickOnNewContact();
		Thread.sleep(5000);
		cp.createNewContact(title, firstname, lastname, company);
		} 
	
	@Test(priority = 3 , dataProvider = "getCRMTestData1")
	public void validateNewContact1(String title, String firstname,String lastname,String company) throws InterruptedException{
		Thread.sleep(5000);
		hp.clickOnNewContact();
		Thread.sleep(5000);
		cp.createNewContact(title, firstname, lastname, company);
		} */
}
