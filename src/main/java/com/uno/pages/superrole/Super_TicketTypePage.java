package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Super_TicketTypePage extends Super_TicketMasterPage
{

	// Get list of Ticket Type
		@FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(2)")
		public
		List<WebElement> lstTicketType;
		

		// select Ticket Type In Table
		@FindBy(xpath = ".//*[@id='right']/div/div/div[2]/table/tbody/tr/td[2]")
		public
		List<WebElement> list_TicketTypeInSuper;
		

		// Initializing Page Object
		public Super_TicketTypePage() {
			PageFactory.initElements(driver, this);
		}
}
