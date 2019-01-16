package com.uno.test.superrole;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_CustomerDetailsPage;
import com.uno.pages.superrole.Super_EmployeeDetailPage;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_ManageStaffPage;


public class Super_EmployeeMasterTest extends BaseCode  {
	Super_LoginPage loginPageOfSuperRole;
	Super_HomePage homePageOfSuperRole;
	Super_EmployeeMasterPage empolyeeMasterPageOfSuperRole;
	Super_EmployeeDetailPage employeeDetailPageOfSuperRole;
	Super_CustomerDetailsPage customerDetailsPageOfSuperRole;
	Super_ManageStaffPage manageStaffPageOfSuperRole;
	
	public Super_EmployeeMasterTest()
	{
		
		super();
		
	}

	
	@BeforeMethod
	public void Setup() throws Exception
	{
		initialization();
		loginPageOfSuperRole= new Super_LoginPage();
		homePageOfSuperRole= loginPageOfSuperRole.Login(properties.getProperty("loginIdForSuper"),properties.getProperty("password"));
		empolyeeMasterPageOfSuperRole=homePageOfSuperRole.clickEmpolyeeMasterlink();
	}
	

	
	@Test(priority=1)
	public void testClickOnCustomerDetailLink() throws InterruptedException
	{    
		Thread.sleep(3000);
		customerDetailsPageOfSuperRole=empolyeeMasterPageOfSuperRole.clickOnCustomerDetailLink();
		
	}
	
	@Test(priority=2)
	 public void ClickOnEmpolyeeDetailLink() throws InterruptedException
	 {    
	  Thread.sleep(3000);
	  employeeDetailPageOfSuperRole=empolyeeMasterPageOfSuperRole.clickOnEmpolyeeDetailLink();
	  
	 }
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
}

	
	
	
	


