package com.uno.pages.superrole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Super_SDMasterPage extends Super_HomePage {
	
	
	
	public Super_SDMasterPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public Super_BusinessUnitMasterPage clickOnBusinessUnitMasterLink()
	{
		tabBusinessUnitMasterLink.click();
		return new Super_BusinessUnitMasterPage();
		
	}
	public Super_TicketMasterPage clickOnTicketMasterLink()
	{
		tabTicketMasterLink.click();
		return new Super_TicketMasterPage();
		
	}
	
	public Super_FileCategoryPage clickOnFileCategoryLink()
	{
		tabFileCategoryLink.click();
		return new Super_FileCategoryPage();
		
	}
	
	public Super_TicketCategoryMasterPage clickOnTicketCategoryMaster()
	{
		tabTicketCategoryMaster.click();
		return new Super_TicketCategoryMasterPage();
		
	}
	
	
	


}
