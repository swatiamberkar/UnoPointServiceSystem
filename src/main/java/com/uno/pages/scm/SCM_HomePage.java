package com.uno.pages.scm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class SCM_HomePage extends BaseCode{
	
	//Select Inventory Tab
			@FindBy(linkText = "Inventory")
			WebElement tab_Inventory;
			
			
	//Initializing Page Object
			public SCM_HomePage()
			{
				PageFactory.initElements(driver, this);
			}
			
	//Validate Home Page Title
			public String homePageTitle()
			{
				return driver.getTitle();
			}
			
	//Click on Ticket Tab
			public SCM_InventoryPage InventoryTab()
			{
				tab_Inventory.click();
				return new SCM_InventoryPage();
			}
			
	

}
