package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCompanyUserPage extends BasePage{

	public CreateCompanyUserPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//span[normalize-space()='Go To Company Users']")
	WebElement btngoToCompanyUser;
	@FindBy(xpath="//span[normalize-space()='Create Company User']")
	WebElement btncreateCompanyUser;
	@FindBy(xpath="//input[@placeholder='Enter username for company user login']")
	WebElement txtusername;
	@FindBy(xpath="//input[@placeholder='Enter password for company user login']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@placeholder='Re-enter password for company user login']")
	WebElement txtconfirmpassword;
	@FindBy(xpath="//input[@placeholder='Enter contact name for company user']")
	WebElement txtcontactname;
	@FindBy(xpath="//input[@placeholder='Enter email id for company user contact']")
	WebElement txtemailid;
	@FindBy(xpath="//input[@placeholder='Enter alternate email id for company user contact']")
	WebElement txtaltemailid;
	@FindBy(xpath="//input[@placeholder='Enter contact number for company user']")
	WebElement txtcontactnumber;

	public void setUserName( String username) {
		txtusername.sendKeys(username);	
	}

	public void setPassword( String password) {
		txtpassword.sendKeys(password);	
	}

	public void setConfirmPassword( String cofrmpass) {
		txtconfirmpassword.sendKeys(cofrmpass);	
	}

	public void setContactName( String cntname) {
		txtcontactname.sendKeys(cntname);	
	}
	public void setEmailId( String emailid) {
		txtemailid.sendKeys(emailid);	
	}
	public void setAltEmail( String altemail) throws InterruptedException {
		txtaltemailid.sendKeys(altemail);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(100, document.body.scrollHeight)");
		Thread.sleep(3000);
	}
	public void setContactNum( String phnum) {
		txtcontactnumber.sendKeys(phnum);	
	}


	public void ClickGoToCompanyUser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		btngoToCompanyUser.click();
	}
	public void ClickCreateCompanyUser() {
		btncreateCompanyUser.click();
	}
}
