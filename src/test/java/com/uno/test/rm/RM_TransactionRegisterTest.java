package com.uno.test.rm;

import java.io.File;

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
import com.uno.pages.rm.RM_TransactionRegisterPage;

public class RM_TransactionRegisterTest extends BaseCode
{

	
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_InventoryPage rm_InventoryPage;
	RM_TransactionRegisterPage rm_TransactionRegisterPage;

	public RM_TransactionRegisterTest()
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
	public void ViewTicket() throws Exception {
		
			rm_HomePage = new RM_HomePage();
			scrollDown(driver.findElement(By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
			driver.findElement(By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();
			rm_InventoryPage=rm_HomePage.InventoryTab();
			Thread.sleep(1000);
			rm_TransactionRegisterPage =  rm_InventoryPage.TransactionRegisterTab();
			Thread.sleep(1000); 
		}
	@Test(priority=1, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If User apply Region filter and click on Go button then entries having same Region as per applied filter, should display in transaction register")
	@Description("If User apply Region filter and click on Go button then entries having same Region as per applied filter, should display in transaction register")
	public void CheckRegion() throws Exception
	{
		rm_TransactionRegisterPage.checkRegion();
		
	}
	
	
	@Test(priority=2, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = " If User apply Business Unit Filter and click on Go button then entries having same BU as per applied filter, should display in transaction register")
	@Description("If User apply Business Unit Filter and click on Go button then entries having same BU as per applied filter, should display in transaction register")
	public void CheckBusinessUnit() throws Exception
	{
		rm_TransactionRegisterPage.checkBusinessUnit();
		
	}
	
	@Test(priority=3, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If User apply Send To Filter and click on Go button then entries having same data in Send To field as per applied filter, should display in transaction register")
	@Description("If User apply Send To Filter and click on Go button then entries having same data in Send To field as per applied filter, should display in transaction register")
	public void checkSendTo() throws Exception
	{
		rm_TransactionRegisterPage.checkSendTo();
		
	}
	
	@Test(priority=4, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If User apply Received From Filter and click on Go button then entries having same data in Received From field as per applied filter, should display in transaction register")
	@Description("If User apply Received From Filter and click on Go button then entries having same data in Received From field as per applied filter, should display in transaction register")
	public void checkReceivedFrom() throws Exception
	{
		rm_TransactionRegisterPage.checkReceivedFrom();
		
	}
	
	@Test(priority=5, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If User apply Part Code Filter and click on Go button then entries having same data in Part Code field as per applied filter, should display in transaction register. in transaction register")
	@Description("If User apply Part Code Filter and click on Go button then entries having same data in Part Code field as per applied filter, should display in transaction register.")
	public void checkPartCode() throws Exception
	{
		rm_TransactionRegisterPage.checkPartCode();
		
	}
	
	@Test(priority=6, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If User apply Transaction Type Filter and click on Go button then entries having same transaction type as per applied filter, should display in transaction register")
	@Description("If User apply Transaction Type Filter and click on Go button then entries having same transaction type as per applied filter, should display in transaction register")
	public void checkTransactionType() throws Exception
	{
		rm_TransactionRegisterPage.checkTransactionType();
		
	}
	
	@Test(priority=7, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If User apply Ordered By Filter with CMDB ID option and click on Click on Go button then entries should display as per CMDB ID in descending Order")
	@Description("If User apply Ordered By Filter with CMDB ID option and click on Click on Go button then entries should display as per CMDB ID in descending Order")
	public void checkOrderedByType() throws Exception
	{
		rm_TransactionRegisterPage.checkOrderedByCMDBID();
		
	}
	
	@Test(priority=8, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If User apply Ordered By Filter with Transaction Date option and click on Click on Go button then entries should display as per Transaction Date in descending Order (Current date entry should display first)")
	@Description("If User apply Ordered By Filter with Transaction Date option and click on Click on Go button then entries should display as per Transaction Date in descending Order(Current date entry should display first)")
	public void checkOrderedByTransactionDate() throws Exception
	{
		rm_TransactionRegisterPage.checkOrderedByTransactionDate();
		
	}
	
	@Test(priority=9, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If User enter correct Serial number and click on Go button then entries having same serial number as per applied filter should display in table.")
	@Description("If User enter correct Serial number and click on Go button then entries having same serial number as per applied filter should display in table.")
	public void checkSerialNumber() throws Exception
	{
		rm_TransactionRegisterPage.checkSerialNumber();
		
	}
	@Test(priority=10, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = "If User apply multiple filters and click on Go button then entries should display as per all applied filters in table")
	@Description("If User apply multiple filters and click on Go button then entries should display as per all applied filters in table")
	public void checkWithAllFilters() throws Exception
	{
		rm_TransactionRegisterPage.checkWithAllFilters();
		
	}
	@Test(priority=6, groups = { "TransactInventory : Pagination","Smoke Testing"} ,description = "count of pagination" )
	@Description("count of pagination")
	public void CountOfPagination() throws Exception
	{
		rm_TransactionRegisterPage.countOfPagination();
		
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
		rm_TransactionRegisterPage.displayAsPerArrowsOfPagination();
		
	}
	@Test(priority=8, groups = { "TransactInventory : Table","Smoke Testing"} ,description = "If User click on CMDB ID hyper link then Item Details page should display with" )
	@Description("If User click on CMDB ID hyper link then Item Details page should display with")
	public void checkCMDB() throws Exception
	{
		rm_TransactionRegisterPage.checkCMDB();
		
	}
	
	@Test(priority=9, groups = { "TransactInventory : Table","Smoke Testing"} ,description = "If User click on View Symbol then Item Details page should display with Part Details, File Upload, Received Details, Send Details, Courier Details, Transact details"
			+ "If user click on Inventory life Cycle button then Life Cycle pop up should display for life cycle of same part" )
	@Description("If User click on View Symbol then Item Details page should display with Part Details, File Upload, Received Details, Send Details, Courier Details, Transact details"
			+ "If user click on Inventory life Cycle button then Life Cycle pop up should display for life cycle of same part")
	public void checkViewSymbol() throws Exception
	{
		rm_TransactionRegisterPage.checkViewSymbol();
		
	}
	
	@Test(priority=10, groups = { "TransactInventory : DownloadExcel","Smoke Testing"} ,description = "If User click on Download Excel button then Excel should get download with number of entries showing as per Total count" )
	@Description("If User click on Download Excel button then Excel should get download with number of entries showing as per Total count.")
	public void verifyDownloadExcel() throws Exception
	{
		rm_TransactionRegisterPage.verifyDownloadExcel();
		
	}
	
	
	
	
	
	
	@AfterMethod
	public void writeResult(ITestResult result) throws Exception {

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
	
