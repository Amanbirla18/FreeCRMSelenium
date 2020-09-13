package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class GoogleDoc extends TestBase {
	private String dogRadioButtonXpath = "(//div[@class='appsMaterialWizToggleRadiogroupOffRadio exportOuterCircle'])[1]";	
	private String dogDropdownXpath = "(//span[@class='quantumWizMenuPaperselectContent exportContent'])[1]";	
	private String dogValueXpath="(//span[@class='quantumWizMenuPaperselectContent exportContent'])[6]";
	private String textFieldXpath="(//input[@class='quantumWizTextinputPaperinputInput exportInput'])[1]";
	private String dateFieldXpath="(//input[@class='quantumWizTextinputPaperinputInput exportInput'])[2]";
	private String submitXpath ="//span[@class='appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel']";
	//div[@class='quantumWizTextinputPaperinputEl freebirdFormviewerComponentsQuestionTextShort freebirdFormviewerComponentsQuestionTextTextInput freebirdThemedInput modeLight']//input[@class='quantumWizTextinputPaperinputInput exportInput']
	
public GoogleDoc(){
	//	PageFactory.initElements(driver, this);
	// this is used for current variables of the class
		
	}
	public void selectDogRadiobutton() {
		WebElement  dogRadioButton = driver.findElement(By.xpath(dogRadioButtonXpath));
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();", dogRadioButton );
	dogRadioButton.click(); 
		System.out.println("Radio button is selected");
}
	public void selectDropdown() throws InterruptedException {
		WebElement  selectDropdown = driver.findElement(By.xpath(dogDropdownXpath));
		selectDropdown.click();
		
		WebElement dogValueDropdown=driver.findElement(By.xpath(dogValueXpath));
		TestBase.clickOn(driver,dogValueDropdown,20);
		Thread.sleep(2000);
		System.out.println("Radio button is selected");
	}
	
	
 public void enterAnimalName() {
	 WebElement inputText=driver.findElement(By.xpath(textFieldXpath));	
	 inputText.sendKeys("Doggggggggggggggggggg");
	 
	}
 
 public void enterDate() {
	 WebElement inputText=driver.findElement(By.xpath(dateFieldXpath));
	inputText.click();
	 inputText.sendKeys("2019");
	 inputText.sendKeys(Keys.TAB);
	 inputText.sendKeys("10");
	 //inputText.sendKeys(Keys.TAB);
	 inputText.sendKeys("01");
	 
	 
	}
public void submitForm() {
	WebElement submit = driver.findElement(By.xpath(submitXpath));
	submit.click();
}
	}

