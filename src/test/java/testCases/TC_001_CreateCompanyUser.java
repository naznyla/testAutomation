package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CreateCompanyUserPage;
import pageObjects.CreatePass;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_CreateCompanyUser extends BaseClass{


	
	@Test
	public void create_company_user() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setuserName(p.getProperty("username"));
		lp.setpassWord(p.getProperty("password"));
		lp.setSubmit();
		CreateCompanyUserPage cp= new CreateCompanyUserPage(driver);
		cp.ClickGoToCompanyUser();
		cp.ClickCreateCompanyUser();
		cp.setUserName("maya");
		cp.setPassword("Company@123");
		cp.setConfirmPassword("Company@123");
		cp.setContactName("Maya");
		cp.setEmailId("maya@getnada.com");
		cp.setAltEmail("maya@getnada.com");
		cp.setContactNum("9898677890");

	}
}
