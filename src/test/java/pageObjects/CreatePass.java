package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePass extends BasePage{
	
public CreatePass(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath="//span[normalize-space()='Create New Pass']")
WebElement createPass;

@FindBy(xpath="//input[@id='photoInput']")
WebElement imageUp;

//@FindBy(xpath="//input[@placeholder='Enter password']")
//WebElement Password;
//@FindBy(xpath="//button[@type='submit']")
//WebElement submitButton;
public void setcreatePassBtnclick( ) {
	createPass.click();;	
}
public void set_imageUp( String image) throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(100, document.body.scrollHeight)");
	Thread.sleep(3000);
	imageUp.sendKeys(image);	
}
//public void setpassWord( String password) {
//	Password.sendKeys(password);	
//}
//public void setSubmit() {
//	submitButton.click();	
//}
}
