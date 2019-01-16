package com.uno.test.superrole;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_InventoryMastersPage;
import com.uno.pages.superrole.Super_ItemMasterPage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_SpareInventoryLocationPage;



public class Super_InventoryMastersTest extends Super_InventoryMastersPage{
	Super_LoginPage loginPageOfSuperRole;
	Super_HomePage homePageOfSuperRole;
	Super_InventoryMastersPage inventoryMastersPageOfSuperRole;
	Super_ItemMasterPage itemMasterPageOfSuperRole;
	Super_SpareInventoryLocationPage spareInventoryLocationPageOfSuperRole;
	

	public Super_InventoryMastersTest() 
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
		inventoryMastersPageOfSuperRole = homePageOfSuperRole.clickInventoryMastersLink();
	}

	@Test(priority = 1)
	public void ClickItemMasterLink() throws Exception
	{
		Thread.sleep(1000);
		itemMasterPageOfSuperRole = inventoryMastersPageOfSuperRole
				.clickItemMasterLink();

	}
	@Test(priority = 2)
	public void ClickSpareInventoryLocationLink() throws Exception
	{
		Thread.sleep(1000);
		spareInventoryLocationPageOfSuperRole = inventoryMastersPageOfSuperRole.clickSpareInventoryLocationLink();

	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	



}
