package com.uno.test.superrole;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_FileCategoryPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_SDMasterPage;
import com.uno.pages.superrole.Super_TicketMasterPage;


public class Super_SDMasterTest extends BaseCode {
	Super_LoginPage loginPageOfSuperRole;
	Super_HomePage homePageOfSuperRole;
	Super_SDMasterPage sDMasterPageOfSuperRole;
	Super_TicketMasterPage ticketMasterPageOfSuperRole;
	Super_FileCategoryPage  fileCategoryPageOfSuperRole;

	public Super_SDMasterTest() {

		super();

	}
	@BeforeClass
	public void driverInitialization() throws Exception
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
	}

	@Test(priority = 1)
	public void ClickItemMasterLink() throws Exception {
		Thread.sleep(1000);
		ticketMasterPageOfSuperRole = sDMasterPageOfSuperRole
				.clickOnTicketMasterLink();

	}

	@Test(priority = 2)
	public void clickOnFileCategoryLink() throws Exception {
		Thread.sleep(1000);
		fileCategoryPageOfSuperRole = sDMasterPageOfSuperRole
				.clickOnFileCategoryLink();

	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
