package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages.GoogleDoc;
public class GoogleDocTest extends TestBase {
	

	GoogleDoc gd;
	
	
	public GoogleDocTest(){
		super();
	// super keyword first calls the constructor of the parent call (Test Base) which will initialize the
	// 	the properties in the parent class constructor  
	// when we calling the  initialization(); method it is must to initilize the property 
	}
	@BeforeMethod 
	  public void SetUp() throws InterruptedException{
		 initialization();
		 gd = new GoogleDoc();
		 
	  }
	  @AfterMethod
	  public void TearDown(){
//	  driver.quit();
	  }
	  @Test
	  public void selectRadioButton() throws InterruptedException{
		  gd.selectDogRadiobutton();
		  gd.selectDropdown();
		  gd.enterAnimalName();
		  gd.enterDate();
		  gd.submitForm();
}
	  
}
