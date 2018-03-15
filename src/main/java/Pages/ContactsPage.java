package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath= "//td[contains(text(),'contacts']")
	WebElement labelonContactpage;
	
	//Initializing the page objects
		public ContactsPage(){
			PageFactory.initElements(driver, this);
		// this is used for current variables of the class
			
		}
		
		public boolean verifyContactslabel(){
			 return labelonContactpage.isDisplayed();
			
		}
		
		public void selectContactscheckboxbyname(String name){
			driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']")).click();
		}
		

}
