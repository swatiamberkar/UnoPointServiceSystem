package com.uno.test.superrole;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_SDMasterPage;
import com.uno.pages.superrole.Super_TicketLevelPage;
import com.uno.pages.superrole.Super_TicketMasterPage;
import com.uno.pages.superrole.Super_TicketTypePage;


public class Super_TicketMasterTest extends BaseCode {
	
	Super_LoginPage loginPageOfSuperRole;
	Super_HomePage homePageOfSuperRole;
	Super_SDMasterPage sDMasterPageOfSuperRole;
	Super_TicketMasterPage ticketMasterPageOfSuperRole;
	Super_TicketTypePage ticketTypePageOfSuperRole;
	Super_TicketLevelPage ticketLevelPageOfSuperRole;
	
	public Super_TicketMasterTest() {

		super();

	}
	
	@org.testng.annotations.BeforeClass
	public void DriverInitialization() throws Exception
	{
		initialization();
		
	}

	@BeforeMethod
	public void Setup() throws Exception {
		loginPageOfSuperRole = new Super_LoginPage();
		homePageOfSuperRole = loginPageOfSuperRole.Login(
				properties.getProperty("loginIdForSuper"),
				properties.getProperty("password"));
		Thread.sleep(3000);
		sDMasterPageOfSuperRole = homePageOfSuperRole.clickSdMasterlink();
		Thread.sleep(1000);
		ticketMasterPageOfSuperRole = sDMasterPageOfSuperRole
				.clickOnTicketMasterLink();

		
	}

	@Test(priority = 1)
	public void clickOnTicketTypeLink() throws Exception {
		Thread.sleep(1000);
		ticketMasterPageOfSuperRole.clickOnTicketTypeLink();

	}
	@Test(priority = 2)
	public void clickOnTicketModeLink() throws Exception {
		Thread.sleep(1000);
		ticketMasterPageOfSuperRole.clickOnTicketModeLink();

	}
	
	@Test(priority = 3)
	public void clickOnTicketLevelLink() throws Exception {
		Thread.sleep(1000);
		ticketMasterPageOfSuperRole.clickOnTicketLevelLink();

	}


	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
