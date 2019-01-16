package com.uno.pages.superrole;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Super_ClaimPage extends BaseCode {
	
	//select Expense Type Masters link
	@FindBy(xpath= ".//*[@id='main']/form/div[2]/div[2]/div/ul/li[5]/div/div/ul/li[3]/div/a")
	public
	WebElement linkExpenseTypeMaster;
	
	//list of Expense Type
	@FindBy(xpath= ".//*[@id='right']/div/div/div[2]/table/tbody/tr/td[1]")
	public
	List<WebElement> lstExpenseType;
	
	
	//list of Expense Type
		@FindBy(xpath= ".//*[@id='right']/div/div/div[2]/table/tbody/tr/td[3]")
		public
		List<WebElement> lstPeriodicFlag;
	public Super_ClaimPage()
	{
		PageFactory.initElements(driver, this);
		
	}
}
