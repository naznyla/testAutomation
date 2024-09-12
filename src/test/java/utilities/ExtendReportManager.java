package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtendReportManager implements ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repName;

	public void onStart (ITestContext testcontext) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName= "Test-report-"+timeStamp+".html";

		sparkReporter =new ExtentSparkReporter(".\\reports\\"+repName);
		sparkReporter.config().setDocumentTitle("My Reports");
		sparkReporter.config().setReportName("Functionality testing");
		sparkReporter.config().setTheme(Theme.DARK);


		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Epass");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");

		String os= testcontext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating system", "os");

		String browser= testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

		List<String>includedGroups=testcontext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());	
		}
	}

	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+"got successfully executed");
	}

	public void onTestFailure(ITestResult result) {
		// Create a test entry for the failed test case in the Extent Report
		test = extent.createTest(result.getTestClass().getName());

		// Assign categories/groups to the test
		test.assignCategory(result.getMethod().getGroups());

		// Log failure status with the test name
		test.log(Status.FAIL, result.getName() + " got failed");

		// Log the failure reason (exception or error)
		if (result.getThrowable() != null) {
			test.log(Status.INFO, result.getThrowable().getMessage());
		}

		// Capture a screenshot and attach it to the report
		try {
			String imgPath = new BaseClass() .captureScreen(result.getName());
			if (imgPath != null && !imgPath.isEmpty()) {
				test.addScreenCaptureFromPath(imgPath);
			} else {
				test.log(Status.WARNING, "Screenshot could not be captured.");
			}
		} catch (Exception e) {
			// Catching generic exception if captureScreen throws any other type of exception
			test.log(Status.FAIL, "Error capturing screenshot: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+"got skipped");
		test.log(Status.INFO,result.getThrowable().getMessage());
	}
	public void onFinish(ITestContext testContex) {
		extent.flush();

		String pathofExtentReport= System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathofExtentReport);

		try {
			Desktop.getDesktop().browse(extentReport.toURI());	
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}







