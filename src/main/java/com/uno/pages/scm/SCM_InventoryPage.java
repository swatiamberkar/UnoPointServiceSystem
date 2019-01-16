package com.uno.pages.scm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class SCM_InventoryPage extends BaseCode{
	
	//Select Inventory Tab
	@FindBy(css = "a[href='/erprmwise/SparesRequestValidation.do?action=validationsparerequest']")
	WebElement tab_ValidationSpareRequest;
	
	
//Initializing Page Object
	public SCM_InventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
//Validate Home Page Title
	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
//Click on Ticket Tab
	public SCM_ValidationSpareRequestPage ValidationSpareRequestTab()
	{
		tab_ValidationSpareRequest.click();
		return new SCM_ValidationSpareRequestPage();
	}
	

	
	

}
