package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Super_BusinessUnitMasterPage extends BaseCode {
	// Get list of Business Unit
	@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(2)")
	public
	List<WebElement> list_BusinessUnit;

	// Initializing Page Object
	public Super_BusinessUnitMasterPage() {
		PageFactory.initElements(driver, this);
	}

}
