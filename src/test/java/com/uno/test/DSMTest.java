package com.uno.test;

import io.qameta.allure.Description;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.excelUtility.TestUtil;
import com.uno.pages.DSMPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;

public class DSMTest extends BaseCode {
	
	SD_LoginPage sd_LoginPage;
	SD_HomePage sd_HomePage;
	DSMPage dsmPage;
	
	String xlFilePath = "D:\\UnoPoint\\UnoPointServiceSystem\\src\\main\\java\\com\\uno\\excelFile\\all fs nonMLLn.xlsx";
	String sheetId = "Sheet1";
	String sheetAssetId = "Asset Id";
	String sheetTicketId = "Ticket ID";
	
	
	
	public DSMTest() {

		super();

	}
	
	
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://key.intelli.uno:1243/uppmv3/");
		
		Thread.sleep(1000);
		driver.findElement(By.name("m_strLoginId")).sendKeys("Vishal Shinde");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[onclick='validate_login();']")).click();
	
		
		dsmPage = new DSMPage();
		dsmPage.applyFilter();		
			
	
	}
	

	@DataProvider
	 public String[][] idData() throws Exception{
	  TestUtil data= new TestUtil();
	  //Object data[][] = TestUtility.getSheetdata(sheetName);
	  return data.getCellData(xlFilePath, sheetId);
	  
	  
	  }
	
	@Test(priority = 1, dataProvider= "idData", description = "")
	@Description("")
	public void VerifyIDTextBox(String siteCode) throws Exception {
		Thread.sleep(500);

		dsmPage.updateActivity(siteCode);

	}
	
	

}
