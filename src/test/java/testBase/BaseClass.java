package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public Properties p;
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os ,String br) throws IOException {

		switch(br.toLowerCase())
		{
		case "chrome" :
			WebDriverManager.chromedriver().setup();      						//WebDriver Initializaton
			ChromeOptions co = new ChromeOptions();								//initializes a new object of the ChromeOptions class 
			co.addArguments("--remote-allow-origins=*");						//set a browser option
			driver = new ChromeDriver(co);break;
		case "edge" :
			driver= new EdgeDriver();break;
		case "firefox" :
			driver= new FirefoxDriver();break;
		default :System.out.println(" Invalid browser name..");return;
		}
		driver.manage().window().maximize();
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		driver.get(p.getProperty("baseurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//	@AfterClass
		//	public void tearDown() {
		//		driver.quit();
	}

	public String captureScreen(String tname) {
		String timeStamp =new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot= (TakesScreenshot)driver;
		File sourceFile= takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\"+tname + "_"+ timeStamp+ ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}