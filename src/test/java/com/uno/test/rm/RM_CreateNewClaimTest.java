package com.uno.test.rm;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;

import com.relevantcodes.extentreports.ExtentTest;
import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.WebEventListener;
import com.uno.pages.rm.RM_ClaimPage;
import com.uno.pages.rm.RM_CreateNewClaimPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_LoginPage;


public class RM_CreateNewClaimTest extends BaseCode {

	
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_ClaimPage rm_ClaimPage;
	RM_CreateNewClaimPage rm_CreateNewClaimPage;
	ATUTestRecorder recorder ;
	public static String methodName= null;
	String currentDir = System.getProperty("user.dir");
	
	public RM_CreateNewClaimTest() {
		super();
	}
	
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {

			initialization();

			rm_LoginPage = new RM_LoginPage();
			Thread.sleep(1000);
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM2"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			rm_HomePage = new RM_HomePage();
			rm_ClaimPage = rm_HomePage.ClaimTab();
			Thread.sleep(1000);
			rm_CreateNewClaimPage = rm_ClaimPage.CreateNewTab();
			Thread.sleep(1000);
			
		} 
	
	
	@BeforeMethod(alwaysRun = true)
	public void Claim(Method method) throws Exception {
		String path= currentDir + "/Recording/"+ method.getName();
		startRecording(path,method.getName());
	//	recorder = new ATUTestRecorder("D:\\UnoPoint\\UnoPointServiceSystem\\Recording",method.getName(),false);
	//	recorder.start();
		
		
		
			/*rm_HomePage = new RM_HomePage();
			rm_ClaimPage = rm_HomePage.ClaimTab();
			Thread.sleep(1000);
			rm_CreateNewClaimPage = rm_ClaimPage.CreateNewTab();
			Thread.sleep(1000);
			*/
			
		}



	

	// Table in View Ticket //
	
	
	@Feature("")
	@Test(priority = 1, groups = { "Smoke Testing" }, 
	description = "1. If User click on Add button with attach file then entry should display in file attachment table with file name"
			+ "2. If User click on File name hyperlink then same file should get download"
			+ "3. After entering all details, notifiation should display as 'Claim Submitted Successfully'"
			+ "4. If User click on Claim Id hyperlink then Single view of same claim should display "
			+ "5. If User click on Attachment View button in Claim single view then List of File Popup should display with attached files")
	@Description("")
	public void checkSubmitButtonWithSelection() throws Exception {
		rm_CreateNewClaimPage.checkSubmitButtonWithSelection();
	}
	
	


	@Feature("")
	@Test(priority = 2, groups = { "Regression Testing" }, 
	description = "1. If user click on Submit button without enter any details then alert box should display as 'Please Select Expense Type.'"
			+ "2. If user click on Submit button without Bill No details then alert box should display as 'Please Enter Bill No.'"
			+ "3. If User click on Submit button without Bill date details then alert box should display as 'Please Enter Bill Date.'"
			+ "4. If User click on Submit button without Bill Period form date, then alert box should display as 'Please Enter Bill Period From.' "
			+ "5. If User click on Submit button without Bill Period To date, then alert box should display as 'Please Enter Bill Period To.' "
			+ "6. If User click on Submit button without Claim amount details then alert box should display as 'Please Enter Claim Amount.'"
			+ "7. If user enter alphabets in Claim amount field and click Submit button then alert box should display with alert box as 'Please Enter Numeric Digit For Claim Amount'"
			+ "8. If User try to enter special characters in Claim amount field then alert box should display as 'Please Enter Numeric Value'"
			+ "9. If User keep description field as blank and try to submit details then alert box should display as 'Please Enter Description.'"
			+ "10. If User click on Add button without attach file then alert box should display as 'Please Select File First.'")
	@Description("")
	public void CheckSubmitButtonWithoutSelection() throws Exception {
		rm_CreateNewClaimPage.checkSubmitButtonWithoutSelection();
	
	}
	
	

	@Feature("")
	@Test(priority = 3, groups = { "Smoke Testing" }, 
	description = "If User click on Expence type, it should display as per Expence type master in Super login")
	@Description("")
	public void VarifyExpenseTypeWithSuperRole() throws Exception {
		rm_CreateNewClaimPage.varifyExpenseTypeWithSuperRole();
		
	}
	
	@Feature("")
	@Test(priority = 4, groups = { "Smoke Testing" }, 
	description = "1.If user select  Expence type as 'Advance claim' then only ticket ID, Claim amount  and description should display"
			+ "2. If user click on Submit button without ticket ID then still alert box should display as 'Are You Sure Want To Submit?'"
			+ "3. Aftre click on Ok button notification should display as 'Claim Submitted Successfully'")
	@Description("")
	public void varifyColumnBySelectingAdvanceClaim() throws Exception {
		rm_CreateNewClaimPage.varifyColumnBySelectingAdvanceClaim();
		
	}
	
	@Feature("")
	@Test(priority = 5, groups = { "Smoke Testing" }, 
	description = "1. If User keep Ticket ID field blank and try to submit details then alert box should display as 'Please Enter Ticket ID.'"
			+ "2. If user enter wrong Ticket ID and submit details then notification should display as 'Please enter valid Ticket ID. Ticket ID : (Ticket ID) is not present in system.'")
	@Description("")
	public void checkNotificationWithAndWithoutTicketID() throws Exception {
		rm_CreateNewClaimPage.checkNotificationWithAndWithoutTicketID();
		
	}
	
	
	


	
	
	@AfterMethod
	public void writeResult(ITestResult result, Method method) throws Exception {
		stopRecording();
		String path= currentDir + "/Recording/"+method.getName();
		changeFileName(path,method.getName());
	
		
		
		
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======PASS======");
			}

			else if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======FAIL======");

			
				// TestUtil.takeScreenshotAtEndOfTest();
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);

				//String currentDir = System.getProperty("user.dir");

				FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
						+ result.getMethod().getMethodName() + ".jpg"));

				/*try {
					rm_HomePage = new RM_HomePage();
					rm_ClaimPage = rm_HomePage.ClaimTab();
					Thread.sleep(1000);
					rm_CreateNewClaimPage = rm_ClaimPage.CreateNewTab();
					Thread.sleep(1000);
					
				} catch (Exception e) {
					
					driver.close();
					initialization();


					rm_LoginPage = new RM_LoginPage();
					Thread.sleep(1000);
					rm_HomePage = rm_LoginPage.Login(
							properties.getProperty("loginIdForRM2"),
							properties.getProperty("password"));
					Thread.sleep(1000);
					rm_HomePage = new RM_HomePage();
					rm_ClaimPage = rm_HomePage.ClaimTab();
					Thread.sleep(1000);
					rm_CreateNewClaimPage = rm_ClaimPage.CreateNewTab();
					Thread.sleep(1000);
				}		
*/
			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
		
			}
		} catch (Exception e) {
			driver.close();
			initialization();


			rm_LoginPage = new RM_LoginPage();
			Thread.sleep(1000);
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM2"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			rm_HomePage = new RM_HomePage();
			rm_ClaimPage = rm_HomePage.ClaimTab();
			Thread.sleep(1000);
			rm_CreateNewClaimPage = rm_ClaimPage.CreateNewTab();
			Thread.sleep(1000);
			
		}

	}

	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
