package com.uno.test.sd;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.TestUtil;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_ViewTicket2Page;

public class SD_ViewTicket2Test extends BaseCode{
	
	SD_LoginPage sd_LoginPage;
	SD_HomePage sd_HomePage;
	SD_TicketPage sd_TicketPage;
	SD_ViewTicket2Page sd_ViewTicket2Page;
	
	String xlFilePath = "D:\\UnoPoint\\UnoPointServiceSystem\\src\\main\\java\\com\\uno\\excelFile\\ViewTicket2.xlsx";
	String sheetId = "Id";
	String sheetAssetId = "Asset Id";
	String sheetTicketId = "Ticket ID";
	String currentDir = System.getProperty("user.dir");


	
	
	public SD_ViewTicket2Test()
	 {
	  
	  super();
	  
	 }
	
	
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
		
		
			initialization();

			sd_LoginPage = new SD_LoginPage();
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			
			
		
					
			
	
	}

	@BeforeMethod(alwaysRun = true)
	public void ViewTicket(Method method) throws Exception {
	
		String path= currentDir + "/Recording/"+ method.getName();
		startRecording(path,method.getName());
		
			sd_HomePage = new SD_HomePage();
			sd_TicketPage = sd_HomePage.ticketTab();
			Thread.sleep(1000);
			sd_ViewTicket2Page = sd_TicketPage.ViewTicket_2();
			Thread.sleep(1000);
		

	}

	
	

	@DataProvider
	 public String[][] idData() throws Exception{
	  TestUtil data= new TestUtil();
	  //Object data[][] = TestUtility.getSheetdata(sheetName);
	  return data.getCellData(xlFilePath, sheetId);
	  
	  
	  }

	@Test(priority = 1, dataProvider= "idData", description = "")
	@Description("")
	public void VerifyIDTextBox(String id) throws Exception {
		
		sd_ViewTicket2Page.VerifyIDTextBox(id);

	}
	
	
	@DataProvider
	 public String[][] assetIdData() throws Exception{
	  TestUtil data= new TestUtil();
	  //Object data[][] = TestUtility.getSheetdata(sheetName);
	  return data.getCellData(xlFilePath, sheetAssetId);
	  
	  
	  }
	@Test(priority = 2, dataProvider= "assetIdData", description = "")
	@Description("")
	public void VerifyAssetIdTextBox(String id) throws Exception {
		
		sd_ViewTicket2Page.VerifyAssetIdTextBox(id);

	}
	
	@DataProvider
	 public String[][] ticketIdData() throws Exception{
	  TestUtil data= new TestUtil();
	  //Object data[][] = TestUtility.getSheetdata(sheetName);
	  return data.getCellData(xlFilePath, sheetTicketId);
	  
	  
	  }
	@Test(priority = 3, dataProvider= "ticketIdData", description = "")
	@Description("")
	public void VerifyTicketIdTextBox(String id) throws Exception {
		
		sd_ViewTicket2Page.VerifyTicketIdTextBox(id);

	}
	
	@Test(priority = 4, description = "")
	@Description("")
	public void checkDataFilterByState() throws Exception {
		
		sd_ViewTicket2Page.checkDataFilterByState();
		sd_HomePage = new SD_HomePage();
		sd_TicketPage = sd_HomePage.ticketTab();

	}
	
	@Test(priority = 5, description = "")
	@Description("")
	public void checkDataFilterByStatus() throws Exception {
		
		sd_ViewTicket2Page.checkDataFilterByStatus();
		sd_HomePage = new SD_HomePage();
		sd_TicketPage = sd_HomePage.ticketTab();
		Thread.sleep(1000);
		/*sd_ViewTicket2Page = sd_TicketPage.ViewTicket_2();
		Thread.sleep(1000);*/

	}
	
	@Test(priority = 6, groups = { "Employee Details Page" }, description = "If User apply Filter By Customer filter then, employee entries having same customer assigned should display in list")
	@Description("If User apply Filter By Customer filter then, employee entries having same customer assigned should display in list")
	public void checkDataFilterByCustomer() throws Exception {

		sd_ViewTicket2Page.checkDataFilterByCustomer();

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

				String currentDir = System.getProperty("user.dir");

				FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
						+ result.getMethod().getMethodName() + ".jpg"));

				/*driver.quit();
				initialization();

				loginPageOfSdRole = new SD_LoginPage();
				homePageOfSdRole = loginPageOfSdRole.login(
						properties.getProperty("loginIdForSd"),
						properties.getProperty("password"));
				Thread.sleep(1000);*/

				// takeScreenshot(dateTimeStamp,driver,methodName);
				// System.out.println("Log Message:: @AfterMethod: Method-"+methodName+"- has Failed");
				// Do your excel writing stuff here

			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
				/*driver.quit();
				initialization();

				loginPageOfSdRole = new SD_LoginPage();
				homePageOfSdRole = loginPageOfSdRole.login(
						properties.getProperty("loginIdForSd"),
						properties.getProperty("password"));
				Thread.sleep(1000);*/
				// System.out.println("Log Message::@AfterMethod: Method-"+methodName+"- has Skipped");

			}
		} catch (Exception e) {
			driver.close();
			initialization();

			sd_LoginPage = new SD_LoginPage();
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			
		}

	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}

	 

	
	

}
