package com.uno.pages.sd;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;


public class SD_KEDBPage extends BaseCode{
	
	// Link of Add KEDB
	@FindBy(css="a[href='/erprmwise/ViewKedbSolutionAction.do?action=Add']")
	WebElement tab_AddKEDB;
	
	// Link of View KEDB
	@FindBy(css="a[href='/erprmwise/ViewKedbSolutionAction.do?action=view']")
	WebElement tab_ViewKEDB;
	
	//Initializing Page Object
		public SD_KEDBPage()
		{
			PageFactory.initElements(driver, this);
		}
		
	//Click on Add KEDB Tab
		public SD_AddKEDBPage addKEDBTab()
		{
			tab_AddKEDB.click();
			return new SD_AddKEDBPage();
		}
		
		
		
		//Click on View KEDB Tab
		public SD_ViewKEDBPage viewKEDBTab()
		{
			tab_ViewKEDB.click();
			return new SD_ViewKEDBPage();
		}
		
}
