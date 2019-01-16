package com.uno.pages.superrole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Super_AdminPage extends BaseCode
{

	@FindBy(xpath = ".//*[@id='main']/form/div[2]/div[2]/div/ul/li[9]/div/div/div/ul/li[10]/a")
	WebElement ObjectOfServiceDeskSettingTab;
	
	
	public Super_AdminPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public Super_ServiceDeskSettingsPage clickOnServiceDeskSettingsLink()
	{
		ObjectOfServiceDeskSettingTab.click();
		return new Super_ServiceDeskSettingsPage();
		
	}
	
}
