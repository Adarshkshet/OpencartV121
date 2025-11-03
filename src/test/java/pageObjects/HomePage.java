package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//Constructor
	public HomePage(WebDriver driver) {
		
		super(driver);
		
	}
	
	//Locators
	
	@FindBy(xpath="//ul[@class='list-inline']//li[2]//span[1]")
	WebElement lnkMyaccount;											//MyAccount link
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//li[1]//a") //Register link
	WebElement lnkRegister;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//li[2]//a") //Login link
	WebElement linkLogin;
	
	//ActionMethods

	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	public void clickLogin() {
		linkLogin.click();
	}
}
