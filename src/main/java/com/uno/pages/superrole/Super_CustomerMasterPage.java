package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Super_CustomerMasterPage extends Super_CustomerDetailsPage {
	
	// Get list of Customer
	@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(2)")
	public
	List<WebElement> list_Customer;
	
	// Pagination
	@FindBy(css = "select[name='m_strPaginateCustomer']>option")
	public
	List<WebElement> dropdown_Pagination;

	// Initializing Page Object
	public Super_CustomerMasterPage() {
		PageFactory.initElements(driver, this);
	}

}
