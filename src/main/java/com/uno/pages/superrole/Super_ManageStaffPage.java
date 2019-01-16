package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Super_ManageStaffPage  extends Super_EmployeeMasterPage{
	
	
	
	// Select SD tab for logout tab
		@FindBy(linkText = "Test")
		WebElement link_Test;

		// Click on logout
		
		@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
		WebElement link_LogOut;


		@FindBy(xpath = ".//*[@id='right']/div[1]/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr/td[3]/a")
		WebElement button_UpdateTotalLeave;
		
		@FindBy(name = "m_strTotalLeaves")
		WebElement textbox_TotalLeave;
		
		@FindBy(xpath = ".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr/td[3]")
		public
		List<WebElement> list_FirstName;
		
		@FindBy(css = "select[name='locSelectedBusinessUnitAdd']")
		public
		WebElement ddlBusinessUnit;
		
		@FindBy(css = "select[name='locSelectedProductCategoryAdd']")
		public
		WebElement ddlProductCategory;
		
		
	public Super_ManageStaffPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	


}
