package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Super_TicketLevelPage  extends Super_TicketMasterPage {

	// select ticket mode
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[2]")
	public
	List<WebElement> list_TicketLevelInSuper;
	


	public Super_TicketLevelPage() 
	{
		PageFactory.initElements(driver, this);

	}
}
