package com.uno.test.superrole;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.pages.superrole.Super_AdminPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_ServiceDeskSettingsPage;


public class Super_AdminTest extends Super_AdminPage
{

	Super_LoginPage loginPageOfSuperRole;
	Super_HomePage homePageOfSuperRole;
	Super_AdminPage adminPageOfSuperRole;
	Super_ServiceDeskSettingsPage serviceDeskSettingsPageOfSuperRole;
	

	public Super_AdminTest() 
	{

		super();

	}

	@BeforeMethod
	public void Setup() throws Exception 
	{
		//initialization();
		loginPageOfSuperRole = new Super_LoginPage();
		homePageOfSuperRole = loginPageOfSuperRole.Login(
				properties.getProperty("loginIdForSuper"),
				properties.getProperty("password"));
		Thread.sleep(3000);
		adminPageOfSuperRole = homePageOfSuperRole.clickAdminLink();
	}

	@Test(priority = 1)
	public void ClickOnServiceDeskSettingsLink() throws InterruptedException
	{
		Thread.sleep(1000);
		serviceDeskSettingsPageOfSuperRole = adminPageOfSuperRole
				.clickOnServiceDeskSettingsLink();

	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
