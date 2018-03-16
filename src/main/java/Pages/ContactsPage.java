package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath= "//input[@id='btn_cs_search']")
	WebElement textonContactpage;
	
	@FindBy(name="first_name")
	WebElement FirstName;
	
	@FindBy(name= "surname")
	WebElement LastName;
	
	@FindBy(name= "client_lookup")
	WebElement CompanyName;
	
	@FindBy(xpath= "//input[@value= 'Save' and @type ='submit']")
	WebElement savBtn;
	
	
	
	//Initializing the page objects
		public ContactsPage(){
			PageFactory.initElements(driver, this);
		// this is used for current variables of the class
			
		}
		
		public String verifyContactslabel(){
			 return textonContactpage.getText();
			
		}
		
		public void selectContactscheckboxbyname(String name){
			driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']")).click();
		}
		
		public void createNewContact(String title, String FrstName, String LstName, String cmpName){
			Select select = new Select(driver.findElement(By.name("title")));
			select.selectByValue(title);
			FirstName.sendKeys(FrstName);
			LastName.sendKeys(LstName);
			CompanyName.sendKeys(cmpName);
			savBtn.click();
		}
		

}
