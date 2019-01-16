package com.uno.test.superrole;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_AdminPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_ServiceDeskSettingsPage;


public class Super_ServiceDeskSettingsTest extends BaseCode {
	Super_LoginPage loginPageOfSuperRole;
	Super_HomePage homePageOfSuperRole;
	Super_AdminPage adminPageOfSuperRole;
	Super_ServiceDeskSettingsPage serviceDeskSettingsPageOfSuperRole;

	public Super_ServiceDeskSettingsTest()
	{

		super();

	}
	@BeforeClass
	public void driverInitialization() throws Exception
	{
		initialization();
		
	}

	@BeforeMethod
	public void Setup() throws Exception 
	{
	
		loginPageOfSuperRole = new Super_LoginPage();
		homePageOfSuperRole = loginPageOfSuperRole.Login(
				properties.getProperty("loginIdForSuper"),
				properties.getProperty("password"));
		Thread.sleep(3000);
		adminPageOfSuperRole = homePageOfSuperRole.clickAdminLink();
		Thread.sleep(1000);
		serviceDeskSettingsPageOfSuperRole = adminPageOfSuperRole
				.clickOnServiceDeskSettingsLink();
		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void SelectWithInventoryRadioButton() throws InterruptedException 
	{

		serviceDeskSettingsPageOfSuperRole.selectWithInventoryRadioButton();

	}

	@Test(priority = 2)
	public void SelectWithoutInventoryRadioButton() throws InterruptedException 
	{

		serviceDeskSettingsPageOfSuperRole.selectWithoutInventoryRadioButton();

	}

	@Test(priority = 3)
	public void SelectYesOfAttendanceApproveByRm() throws InterruptedException 
	{

		serviceDeskSettingsPageOfSuperRole.selectYesOfAttendanceApproveByRm();

	}
	
	@Test(priority = 4)
	public void SelectNoOfAttendanceApproveByRm() throws InterruptedException 
	{

		serviceDeskSettingsPageOfSuperRole.selectNoOfAttendanceApproveByRm();

	}
	

	@AfterClass
	public void tearDown() 
	{
			
			driver.quit();
		
	}

}
