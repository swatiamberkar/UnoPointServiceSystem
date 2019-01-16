package com.uno.test.sd;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_TicketSummaryPage;




public class SD_HomeTest extends BaseCode {
	SD_LoginPage loginpage;
	SD_HomePage homepage;
	SD_TicketPage ticketpage;
	SD_TicketSummaryPage ticketsummerypage;
	
	public SD_HomeTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		
		 loginpage= new SD_LoginPage();
		 homepage = loginpage.login(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@Test(priority=1)
	public void testHomePageTitle()
	{
		String title= homepage.homePageTitle();
		Assert.assertEquals(title, "Service Desk Home Screen","Home page not match");
	}
	
	
	@Test(priority=2)
	public void testTicket()
	{
		ticketpage=homepage.ticketTab();
	}
	@Test(priority=1)
	public void testTicketSummary()
	{
		ticketsummerypage=homepage.ticketSummaryTab();
	}
	
	
	
	

	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
}
