package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	//Constructor
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//div[@id='content']//h2[1]")	//My Account Page Heading
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")		//added instep 6
	WebElement lnkLogout;

	
	//verify my acc page exists or not (this not validation through return type will validate in Testcases class)
	public boolean isMyAccountPageExists()
	{
		try {
			
		return (msgHeading.isDisplayed());
		
		}catch(Exception e) 
		{
			return false;
		}
	}
	//Action methods
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
