package com.uno.pages.sd;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class SD_EmployeePage extends BaseCode{
	
	// Employee Details tab
		@FindBy(css="a[href='/erprmwise/AddItStaffAction.do?']")
		WebElement tabEmployeeDetails;
		

		
	//Initializing Page Object
		public SD_EmployeePage()
		{
			PageFactory.initElements(driver, this);
		}
		
	//Click on Create New Tab
		public SD_EmployeeDetailsPage EmployeeDetailsTab()
		{
			tabEmployeeDetails.click();
			return new SD_EmployeeDetailsPage();
		}

}
