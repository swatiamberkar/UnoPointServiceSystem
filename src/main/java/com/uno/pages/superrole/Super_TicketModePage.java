package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Super_TicketModePage extends BaseCode {
	// Get list of Ticket Type
	@FindBy(css = "#departmentForm>table>tbody>tr[class='trHover f2f2f2']>td:nth-of-type(2)")
	public
	List<WebElement> lstTicketMode;
	
	// select ticket mode
		@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[2]")
		public
		List<WebElement> list_TicketModeInSuper;

	

	// Initializing Page Object
	public Super_TicketModePage() {
		PageFactory.initElements(driver, this);
	}

}
