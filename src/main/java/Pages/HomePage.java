package Pages;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class HomePage extends TestBase{
	@FindBy(xpath ="//td[contains(text(),'User: Aman Birla')]")
	WebElement  usernameLabel;
	
	@FindBy(xpath ="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath ="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath ="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath ="//a[@title='New Contact']")
	WebElement newContactLink;
	
	
	
	//Initializing the page objects
		public HomePage(){
			PageFactory.initElements(driver, this);
		// this is used for current variables of the class
			
		}
		
		public String ValidateHomePageTitle(){
			return driver.getTitle();
		}
		
		public ContactsPage clickOnContactsLink(){
			
			contactsLink.click();
			return new ContactsPage();
		}
		public DealsPage clickOnDealsLink(){
			dealsLink.click();
			return new DealsPage();
		}
		
		public TasksPage clickOnTasksLink(){
			dealsLink.click();
			return new TasksPage();
		}
		
		public boolean verifyUserName(){
			return usernameLabel.isDisplayed();
		}
		public void clickOnNewContact(){
		Actions actions = new Actions(driver);	
		actions.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		}
}
