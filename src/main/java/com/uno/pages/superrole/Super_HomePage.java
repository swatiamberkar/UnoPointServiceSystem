package com.uno.pages.superrole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Super_HomePage extends Super_LoginPage 
{

	public Super_HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String homePageTitle() {
		return driver.getTitle();

	}

	public Super_EmployeeMasterPage clickEmpolyeeMasterlink() {
		tabEmployeeMaster.click();
		return new Super_EmployeeMasterPage();
	}

	public Super_SDMasterPage clickSdMasterlink() {
		tabSDMaster.click();
		return new Super_SDMasterPage();
	}

	public Super_AdminPage clickAdminLink() {
		tabAdmin.click();
		return new Super_AdminPage();
	}

	public Super_InventoryMastersPage clickInventoryMastersLink() {
		tabInventoryMasters.click();
		return new Super_InventoryMastersPage();
	}

}
