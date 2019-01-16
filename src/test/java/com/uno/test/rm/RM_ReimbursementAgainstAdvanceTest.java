
	
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
import com.uno.pages.rm.RM_ReimbursementAgainstAdvancePage;


	public class RM_ReimbursementAgainstAdvanceTest extends BaseCode {

		
		RM_LoginPage rm_LoginPage;
		RM_HomePage rm_HomePage;
		RM_ClaimPage rm_ClaimPage;
		RM_CreateNewClaimPage rm_CreateNewClaimPage;
		RM_ReimbursementAgainstAdvancePage rm_ReimbursementAgainstAdvancePage;
		ATUTestRecorder recorder ;
		public static String methodName= null;
		String currentDir = System.getProperty("user.dir");
		
		public RM_ReimbursementAgainstAdvanceTest() {
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
				/*rm_HomePage = new RM_HomePage();
				rm_ClaimPage = rm_HomePage.ClaimTab();
				Thread.sleep(1000);
				rm_CreateNewClaimPage = rm_ClaimPage.CreateNewTab();
				Thread.sleep(1000);*/
				
			} 
		
		
		@BeforeMethod(alwaysRun = true)
		public void Claim(Method method) throws Exception {
			String path= currentDir + "/Recording/"+ method.getName();
			startRecording(path,method.getName());
			rm_HomePage = new RM_HomePage();
				rm_ClaimPage = rm_HomePage.ClaimTab();
				Thread.sleep(1000);
				rm_ReimbursementAgainstAdvancePage = rm_ClaimPage.ReimbursementAgainstAdvanceTab();
				Thread.sleep(1000);
				
				
			}



		

		// Table in View Ticket //
		
		
		@Feature("")
		@Test(priority = 1, groups = { "Smoke Testing" }, 
		description = "In table format if user click on Expence type field then all expence type should display as present in system")
		@Description("In table format if user click on Expence type field then all expence type should display as present in system")
		public void varifyExpenseTypeWithSuperRole() throws Exception {
			rm_ReimbursementAgainstAdvancePage.varifyExpenseTypeWithSuperRole();
		}
		
		
		@Feature("")
		@Test(priority = 2, groups = { "Smoke Testing" }, 
		description = "If user select particular Non periodic claim then From and To Date field should get dissable and if user select Periodic claim then Ticket ID field should get dissable")
		@Description("If user select particular Non periodic claim then From and To Date field should get dissable and if user select Periodic claim then Ticket ID field should get dissable")
		public void varifyColumnBySelectingPeriodicWiseClaim() throws Exception {
			rm_ReimbursementAgainstAdvancePage.varifyColumnBySelectingPeriodicWiseClaim();
		}
		
		
		
		@Feature("")
		@Test(priority = 3, groups = { "Smoke Testing" }, 
		description = "1. If User click on plus (+) symbol showing above table then new row should get added below present claim row"
				+ "2. If User click on Minus (-) symbol showing above table then last row should get deleted from table ")
		@Description("1. If User click on plus (+) symbol showing above table then new row should get added below present claim row"
				+ "2. If User click on Minus (-) symbol showing above table then last row should get deleted from table ")
		public void CheckRowSizeByApplyingPlusMinusSymbol() throws Exception {
			rm_ReimbursementAgainstAdvancePage.checkRowSizeByApplyingPlusMinusSymbol();
		}
		
		
		@Feature("")
		@Test(priority = 4, groups = { "Smoke Testing" }, 
		description = "1. If user click on Submit button without Expence type selected then notification should display as 'Please Select Expense Type for SR.NO. '"
				+ "2. If user click on Submit button without enter Ticket ID then notification should display as 'Please Enter Ticket Id for SR.NO. ' (for non periodic claim)"
				+ "3. If user click on Submit button without select  from date and To date then notification should display as 'Please Enter From Bill Date for SR.NO.' (for periodic claim)"
				+ "4. If user click on Submit button without select  To date then notification should display as 'Please Enter To Bill Date for SR.NO. ' (for periodic claim)"
				+ "5. If user click on Submit button without enter Bill No. then notification should display as 'Please Enter Bill No. for SR.NO. ' "
				+ "6. If user click on Submit button without select Bill Date then notification should display as 'Please Select Bill Date for SR.NO' "
				+ "7. If user click on Submit button with keep bill amount as 0 then notification should display as 'Please Enter Bill Amount for SR.NO' "
				+ "8. If user click on Submit button without description enter in Description field then notification should display as 'Please Enter Description for SR.NO.'"
				+ "9. If User click on Submit button with bill amount less than advance claim amount then notification should display as 'Your Total Bill Amount Is Less Than Advance Claim Amount. Do You Want To Submit?' "
				+ "10. If User click on Submit button with bill amount greater than advance claim amount then notification should display as 'Your Total Bill Amount Is Greater Than Advance Claim Amount. Please Adjust Total Bill Amount Against Advance Amount. Then Create Payable Claim.'"
				+ "11. If user click on submit button with correct bill amount then claim should get created and notification should display as 'Claim Submitted Successfully'")
		@Description("1. If user click on Submit button without Expence type selected then notification should display as 'Please Select Expense Type for SR.NO. '"
				+ "2. If user click on Submit button without enter Ticket ID then notification should display as 'Please Enter Ticket Id for SR.NO. ' (for non periodic claim)"
				+ "3. If user click on Submit button without select  from date and To date then notification should display as 'Please Enter From Bill Date for SR.NO.' (for periodic claim)"
				+ "4. If user click on Submit button without select  To date then notification should display as 'Please Enter To Bill Date for SR.NO. ' (for periodic claim)"
				+ "5. If user click on Submit button without enter Bill No. then notification should display as 'Please Enter Bill No. for SR.NO. ' "
				+ "6. If user click on Submit button without select Bill Date then notification should display as 'Please Select Bill Date for SR.NO' "
				+ "7. If user click on Submit button with keep bill amount as 0 then notification should display as 'Please Enter Bill Amount for SR.NO' "
				+ "8. If user click on Submit button without description enter in Description field then notification should display as 'Please Enter Description for SR.NO.' "
				+ "9. If User click on Submit button with bill amount less than advance claim amount then notification should display as 'Your Total Bill Amount Is Less Than Advance Claim Amount. Do You Want To Submit?'"
				+ "10. If User click on Submit button with bill amount greater than advance claim amount then notification should display as 'Your Total Bill Amount Is Greater Than Advance Claim Amount. Please Adjust Total Bill Amount Against Advance Amount. Then Create Payable Claim.'"
				+ "11. If user click on submit button with correct bill amount then claim should get created and notification should display as 'Claim Submitted Successfully'")
		public void CheckSubmitButtonWithoutSelection() throws Exception {
			rm_ReimbursementAgainstAdvancePage.checkSubmitButtonWithoutSelection();
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
				rm_ReimbursementAgainstAdvancePage = rm_ClaimPage.ReimbursementAgainstAdvanceTab();
				Thread.sleep(1000);
				
			}

		}

		@AfterTest
		public void TearDown() {
			driver.quit();
		}

	


}
