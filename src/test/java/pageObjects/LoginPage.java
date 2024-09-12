package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@placeholder='Enter username']")
	WebElement userName;
	@FindBy(xpath="//input[@placeholder='Enter password']")
	WebElement Password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	public void setuserName( String username) {
		userName.sendKeys(username);	
	}
	public void setpassWord( String password) {
		Password.sendKeys(password);	
	}
	public void setSubmit() {
		submitButton.click();	
	}
}
