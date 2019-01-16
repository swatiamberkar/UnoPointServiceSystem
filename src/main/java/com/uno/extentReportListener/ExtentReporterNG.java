package com.uno.extentReportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;
	public static WebDriver driver;
	public static String currentDir = System.getProperty("user.dir");
	
	

	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		extent = new ExtentReports(outputDirectory + File.separator
				+ "Extent Report.html", true);
		
		extent.addSystemInfo("User Name", "Swati Amberkar");
		String currentDir = System.getProperty("user.dir");
		extent.loadConfig(new File(currentDir +"\\Extent-Config.xml"));
		
		
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
	

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				try {
					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) throws Throwable {
		ExtentTest test;
		

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				

				test = extent.startTest(result.getMethod().getMethodName());
				//test = extent.startTest(result.getTestName());
				
				
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				
				
				for (String group : result.getMethod().getGroups())
					
					//test.appendChild(test.assignCategory(group));
					//test.assignCategory(group);
					
				test.assignCategory(group);
				
				test.assignAuthor(result.getInstanceName().split("test.")[1]);
				
					
					test.log(status, result.getMethod().getDescription());
				
				if (result.getStatus() == ITestResult.FAILURE) 
				{
					test.log(status, result.getThrowable());
			

					String currentDir = System.getProperty("user.dir");
					
					

					String path =currentDir + "/Screenshots/" +result.getMethod().getMethodName()+ ".jpg";
					test.log(LogStatus.FAIL, test.addScreenCapture(path));
					String record =currentDir + "\\Recording\\" +result.getMethod().getMethodName()+ "\\"+ result.getMethod().getMethodName()+".avi";
					test.log(LogStatus.FAIL, test.addScreenCapture(record));
					
					
				} else {
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
				}

				extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}