package examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	WebDriver driver;

	@BeforeTest
	public void initialize() throws InterruptedException {

		WebDriverManager.chromedriver().setup();      						//WebDriver Initializaton
		ChromeOptions co = new ChromeOptions();								//initializes a new object of the ChromeOptions class 
		co.addArguments("--remote-allow-origins=*");						//set a browser option
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://epassqa.pearlglobalsolutions.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Enter username']")).sendKeys("aarbee");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Company@1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[normalize-space()='Create New Pass']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[normalize-space()='Create Company User']")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Enter username for company user login']")).sendKeys("teena");
//		driver.findElement(By.xpath("//input[@placeholder='Enter password for company user login']")).sendKeys("Qwerty@123");
//		driver.findElement(By.xpath("//input[@placeholder='Re-enter password for company user login']")).sendKeys("Qwerty@123");
//		driver.findElement(By.xpath("//input[@placeholder='Enter contact name for company user']")).sendKeys("Teena Thomas");
//		driver.findElement(By.xpath("//input[@placeholder='Enter email id for company user contact']")).sendKeys("teena@getnada.com");
//		driver.findElement(By.xpath("//input[@placeholder='Enter alternate email id for company user contact']")).sendKeys("teena@getnada.com");
//		driver.findElement(By.xpath("//input[@placeholder='Enter contact number for company user']")).sendKeys("9995308925");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollTo(100, document.body.scrollHeight)");
		 Thread.sleep(5000);
		 
		 driver.findElement (By.xpath("//input[contains(@placeholder,'Select the date and time')]")).click();
		 Thread.sleep(5000);
		 String actMonth=driver.findElement(By.xpath("//div[contains(@class,'rdt rdtOpen')]//th[contains(@class,'rdtSwitch')][normalize-space()='September 2024']")).getText();
		 System.out.println(actMonth);
		 while(!actMonth.equals("December 2024")){
			 driver.findElement(By.xpath("//div[contains(@class,'rdt rdtOpen')]//span[contains(text(),'›')]")).click();
			 
		 }
//	
		String projectpath=System.getProperty("user.dir")	;
		WebElement upload_file = driver.findElement(By.xpath("//input[@id='photoInput']"));
		 upload_file.sendKeys(projectpath+"\\image\\photo.jpg");
	
//		//Validation message display
//		// Locate the validation message
//        WebElement validationMessage = driver.findElement(By.xpath("//div[normalize-space()='Username is required']"));
//       // Assert the validation message
//        String expectedMessage = "Username is required";
//        String actualMessage = validationMessage.getText();
//        Assert.assertEquals(actualMessage, expectedMessage, "Validation message does not match");
//        
//        WebElement passwordValidation = driver.findElement(By.xpath("//div[contains(@class,'text-danger mb-3')]"));
//        // Assert the validation message
//         String expectedMessage1 = "Password is required";
//         String actualMessage1 = passwordValidation.getText();
//         Assert.assertEquals(actualMessage1, expectedMessage1, "Validation message does not match");
//         
//         WebElement confirmpasswordValidation = driver.findElement(By.xpath("//form[1]//div[1]//div[1]//div[2]//div[3]//div[1]"));
//         // Assert the validation message
//          String expectedMessage2 = "Password is required";
//          String actualMessage2 = confirmpasswordValidation.getText();
//          Assert.assertEquals(actualMessage2, expectedMessage2, "Validation message does not match");
//         
//          WebElement contactName = driver.findElement(By.xpath("//div[normalize-space()='Contact name is required']"));
//          // Assert the validation message
//           String expectedMessage4 = "Contact name is required";
//           String actualMessage4 = contactName.getText();
//           Assert.assertEquals(actualMessage4, expectedMessage4, "Validation message does not match");
//         
//           WebElement hrEmail = driver.findElement(By.xpath("//div[normalize-space()='HR email id is required']"));
//           // Assert the validation message
//            String expectedMessage5 = "HR email id is required";
//            String actualMessage5 = hrEmail.getText();
//            Assert.assertEquals(actualMessage5, expectedMessage5, "Validation message does not match");
//            
//            JavascriptExecutor js1 = (JavascriptExecutor) driver;
//   	     js1.executeScript("window.scrollTo(50, document.body.scrollHeight)");
//            WebElement contactNumber = driver.findElement(By.xpath("//div[normalize-space()='Contact number is required']"));
//            // Assert the validation message
//             String expectedMessage6 = "Contact number is required";
//             String actualMessage6 = contactNumber.getText();
//             Assert.assertEquals(actualMessage6, expectedMessage6, "Validation message does not match");
//
	}

	private void While(String string) {
		// TODO Auto-generated method stub
		
	}
//   
}
