package com.uno.test.rm;

import java.io.File;
import java.lang.reflect.Method;

import io.qameta.allure.Description;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_InventoryPage;
import com.uno.pages.rm.RM_LoginPage;
import com.uno.pages.rm.RM_TransactInventoryPage;

public class RM_TransactInventoryTest extends BaseCode 
{
	String currentDir = System.getProperty("user.dir");
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_InventoryPage rm_InventoryPage;
	RM_TransactInventoryPage rm_TransactInventoryPage;

	public RM_TransactInventoryTest()
	{
		super();
	}
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {

			initialization();

			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			

	}

	@BeforeMethod(alwaysRun = true)
	public void ViewTicket(Method method) throws Exception {
		   String path= currentDir + "/Recording/"+ method.getName();
	    	startRecording(path,method.getName());
		
		   Thread.sleep(500);
			rm_HomePage = new RM_HomePage();
			scrollDown(driver.findElement(By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
			driver.findElement(By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();
			rm_InventoryPage=rm_HomePage.InventoryTab();
			Thread.sleep(1000);
			rm_TransactInventoryPage =  rm_InventoryPage.TransactInventoryTab();
			Thread.sleep(1000); 
		
	}
	


	@Test(priority=1, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If User select particular inventory location and click on Go button then spare entries which are assign to same invemtory location (same as logistic login having same inventory" )
	@Description("If User select particular inventory location and click on Go button then spare entries which are assign to same invemtory location (same as logistic login having same inventory")
	public void CheckLocation() throws Exception
	{
		rm_TransactInventoryPage.checkLocation();
		
	}
	
	@Test(priority=2, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If User select particular part name in filter and click on Go button then entries having part name as per applied filter should display in table" )
	@Description("If User select particular part name in filter and click on Go button then entries having part name as per applied filter should display in table")
	public void CheckPartName() throws Exception
	{
		rm_TransactInventoryPage.checkPartName();
		
	}
	
	@Test(priority=3, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If user apply transaction type filter and click on Go button then entries"
			+ " having same transaction type should display in table" )
	@Description("If user apply transaction type filter and click on Go button then entries"
			+ "having same transaction type should display in table")
	public void CheckTransactionType() throws Exception
	{
		rm_TransactInventoryPage.checkTransactionType();
		
	}
	@Test(priority=4, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If user apply part status filter and click on Go button then entries"
			+ " having same part status should display in table" )
	@Description("If user apply part status filter and click on Go button then entries"
			+ "having same part status should display in table")
	public void CheckPartStatus() throws Exception
	{
		rm_TransactInventoryPage.checkPartStatus();
		
	}
	@Test(priority=5, groups = { "TransactInventory","Smoke Testing"} ,description = "If user enter serial number and click on Go button then entry with same serial number should display in table " )
	@Description("If user enter serial number and click on Go button then entry with same serial number should display in table ")
	public void CheckSerialNumberField() throws Exception
	{
		rm_TransactInventoryPage.checkSerialNumberField();
		
	}
	
	@Test(priority=6, groups = { "TransactInventory :","Smoke Testing"} ,description = "count of pagination" )
	@Description("count of pagination")
	public void CountOfPagination() throws Exception
	{
		rm_TransactInventoryPage.countOfPagination();
		
	}

	@Test(priority=7, groups = { "TransactInventory :pagination","Smoke Testing"} ,description = "1.If user click on leftmost arrow then control should transfer on first page in  page transact inventory page"
			+ "2.If user click on left arrow then control should transfer on Previous page of current page showing  in transact inventory page"
			+ "3.If user click on rightmost arrow then control should transfer on Last page in transact inventory page"
			+ "4.If user click on right arrow then control should transfer on next page of current page showing in transact inventory page" )
	@Description("1.If user click on leftmost arrow then control should transfer on first page in  page transact inventory page"
			+ "2.If user click on left arrow then control should transfer on Previous page of current page showing  in transact inventory page"
			+ "3.If user click on rightmost arrow then control should transfer on Last page in transact inventory page"
			+ "4.If user click on right arrow then control should transfer on next page of current page showing in transact inventory page")
	public void DisplayAsPerArrowsOfPagination() throws Exception
	{
		rm_TransactInventoryPage.displayAsPerArrowsOfPagination();
		
	}
	
	@Test(priority=8, groups = { "TransactInventory","Smoke Testing"} ,description = "1.If User checked check box in Accept/Reject column and click on Accept Selected button then 'Part Accept Remark' popup should display"
			+ "2.If User enter remark in 'Part Accept Remark' pop up and click on Add button then transaction type should become Stock for same entry " )
	@Description("1.If User checked check box in Accept/Reject column and click on Accept Selected button then 'Part Accept Remark' popup should display"
			+ "2.If User enter remark in 'Part Accept Remark' pop up and click on Add button then transaction type should become Stock for same entry ")
	public void CheckAcceptAndRejectFunctionaliy() throws Exception
	{
		rm_TransactInventoryPage.checkAcceptSelectedFunctionaliy();
		
	}
	
	@Test(priority=9, groups = { "TransactInventory","Smoke Testing"} ,description = "1.If User checked checkbox in Accept/Reject column and click on Reject Selected button then 'Part Reject Remark' popup should display"
			+ "2.If User enter remark in 'Part Accept Remark' pop up and click on Add button then transaction type should become Stock for same entry " )
	@Description("1.If User checked checkbox in Accept/Reject column and click on Reject Selected button then 'Part Reject Remark' popup should display"
			+ "2.If User enter remark in 'Part Reject Remark' popup and click on Stock Received button then transaction type should become Stock for same entry")
	public void CheckRejectSelectedFunctionality() throws Exception
	{
		rm_TransactInventoryPage.checkRejectSelectedFunctionality();
		
	}

	@Test(priority=10, groups = { "TransactInventory","Smoke Testing"} ,description = "1.If User click on Check box in transact column and click on Transact Selected button then Outward page should display with same part details" )
	@Description("1.If User click on Check box in transact column and click on Transact Selected button then Outward page should display with same part details")
	public void CheckTransactSelectedFunctionality() throws Exception
	{
		rm_TransactInventoryPage.checkTransactSelectedFunctionality();
		
	}
	
	@Test(priority=11, groups = { "TransactInventory","Smoke Testing"} ,description = "1.If User enter remark in 'Part Reject Remark' popup and click on Stock Not Received button then same spare entry is getting removed and getting added into source login" )
	@Description("1.If User enter remark in 'Part Reject Remark' popup and click on Stock Not Received button then same spare entry is getting removed and getting added into source login")
	public void checkStockNotReceive() throws Exception
	{
		rm_TransactInventoryPage.checkStockNotReceive();
		
	}
	@Test(priority=12, groups = { "TransactInventory","Regression Testing"} ,description = "1.If user enter serial number which is not present in table and click on Go button then blank table should display" )
	@Description("1.If user enter serial number which is not present in table and click on Go button then blank table should display")
	public void checkWithDifferentSerialNumber() throws Exception
	{
		rm_TransactInventoryPage.checkWithDifferentSerialNumber();
		
	}
	
	@Test(priority=13, groups = { "TransactInventory","Testing With Super"} ,description = "1.In transact Inventory-> Location tab, system should display Inventory locations which are assigned to login RM" )
	@Description("1.In transact Inventory-> Location tab, system should display Inventory locations which are assigned to login RM")
	public void checkWithAssignedLocation() throws Exception
	{
		rm_TransactInventoryPage.checkWithAssignedLocation();
		
	}
	
	
	
	
	
	
	@AfterMethod
	public void writeResult(ITestResult result,Method method) throws Exception {
		
		stopRecording();
		String path= currentDir + "/Recording/"+method.getName();
		changeFileName(path,method.getName());

		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======PASS======");
		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======FAIL======");

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			String currentDir = System.getProperty("user.dir");

			FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
					+ result.getMethod().getMethodName() + ".jpg"));
			
			
			scrollDown(driver.findElement(By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
			driver.findElement(By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();

		
           
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======Skip======");
			driver.quit();
			initialization();

			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			// System.out.println("Log Message::@AfterMethod: Method-"+methodName+"- has Skipped");

		}

	}

	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}

	
