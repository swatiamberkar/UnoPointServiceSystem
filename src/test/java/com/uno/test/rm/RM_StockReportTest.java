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
import com.uno.pages.rm.RM_StockReportPage;

public class RM_StockReportTest extends BaseCode
{


	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_InventoryPage rm_InventoryPage;
	RM_StockReportPage rm_StockReportPage;

	public RM_StockReportTest()
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
	public void ViewTicket() throws Exception 
	{
		
			rm_HomePage = new RM_HomePage();
			scrollDown(driver.findElement(By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")));
			driver.findElement(By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();
			rm_InventoryPage=rm_HomePage.InventoryTab();
			Thread.sleep(1000);
			rm_StockReportPage =  rm_InventoryPage.StockReportTab();
			Thread.sleep(1000); 
	}
	
	@Test(priority=1, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = " If User select Assign Criteria as 'By Location' then stock report should display where Send Criteria is 'To Location'  (and Location column is showing).")
	@Description(" If User select Assign Criteria as 'By Location' then stock report should display where Send Criteria is 'To Location'  (and Location column is showing).")
	public void checkSelectAssignCriteriaAsLocation() throws Exception
	{
		rm_StockReportPage.checkSelectAssignCriteriaAsLocation();
		
	}
	@Test(priority=2, groups = { "TransactInventory: Filter","Smoke Testing"} ,description = " If User apply Region filter then entries having Region as per applied filter should display in Stock Report")
	@Description(" If User apply Region filter then entries having Region as per applied filter should display in Stock Report")
	public void checkRegionFilter() throws Exception
	{
		rm_StockReportPage.checkRegionFilter();
		
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