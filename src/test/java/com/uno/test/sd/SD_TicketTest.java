package com.uno.test.sd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.sd.SD_CreateNewPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_ViewTicketPage;




public class SD_TicketTest extends BaseCode{
	
	SD_LoginPage loginPageOfSdRole;
	SD_HomePage homePageOfSdRole;
	SD_TicketPage ticketPageOfSdRole;
	SD_CreateNewPage createNewPageOfSdRole;
	SD_ViewTicketPage viewTicketPageOfSdRole;
	
	public SD_TicketTest ()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		
		 loginPageOfSdRole= new SD_LoginPage();
		 homePageOfSdRole = loginPageOfSdRole.login(properties.getProperty("loginIdForSd"), properties.getProperty("password"));
		 ticketPageOfSdRole=homePageOfSdRole.ticketTab();
		
	}
	
	
	@Test(priority=1)
	public void testCreateNewTab() throws Exception
	{
		createNewPageOfSdRole=ticketPageOfSdRole.createNewTab();
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void testViewTicketTab() throws Exception
	{
		Thread.sleep(3000);
		viewTicketPageOfSdRole=ticketPageOfSdRole.viewTicketTab();
		Thread.sleep(3000);
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
