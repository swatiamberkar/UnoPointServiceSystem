package com.uno.pages.superrole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Super_CustomerDetailsPage extends Super_EmployeeMasterPage {
	//select principal customer
	@FindBy(xpath=".//*[@id='main']/form/div[2]/div[2]/div/ul/li[5]/div/div/ul/li[2]/div/a[2]")
	WebElement principalcust;
	
	//select customer master
	@FindBy(css="a[href='/erprmwise/CustomerScreen.do']")
	WebElement customerMaster;
	
	
	public Super_CustomerDetailsPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public Super_PrincipalCustomerPage clickOnPrincipalCustomerLink()
	{
		principalcust.click();
		return new Super_PrincipalCustomerPage();
		
	}
	

	public Super_CustomerMasterPage clickOncustMaster()
	{
		scrollDown(customerMaster);
		customerMaster.click();
		return new Super_CustomerMasterPage();
		
	}
	

}
