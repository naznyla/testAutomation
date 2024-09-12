package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginPage extends BaseClass {
	@Test
	public void login_page() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setuserName(p.getProperty("username"));
		lp.setpassWord(p.getProperty("password"));
		lp.setSubmit();
//		CreatePass cp=new CreatePass(driver);
//		cp.setcreatePassBtnclick();
//		cp.set_imageUp("C:\\Users\\Pearl Soft\\eclipse-workspace\\testAutomation\\image\\photo.jpg");
		
		}
		
}
