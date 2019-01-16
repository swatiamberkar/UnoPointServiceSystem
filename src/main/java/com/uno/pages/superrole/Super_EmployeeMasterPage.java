package com.uno.pages.superrole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Super_EmployeeMasterPage extends Super_HomePage {
	//select customer detail link
	@FindBy(xpath= ".//*[@id='main']/form/div[2]/div[2]/div/ul/li[5]/div/div/ul/li[2]/a")
	WebElement objectOfCustomerDetailLink;
	
	//select employee detail page
	  @FindBy(linkText="Employee Details")
	  WebElement objectOfEmployeeDetailLink;
	
		@FindBy(linkText= "Claim")
		WebElement linkClaim;
		
		// select customer detail link
		@FindBy(xpath = ".//*[@id='main']/form/div[2]/div[2]/div/ul/li[5]/div/div/ul/li[2]/a")
		WebElement tabCustomerDetail;

		// select employee detail page
		@FindBy(linkText = "Employee Details")
		WebElement tabEmployeeDetail;

		// select employee detail page
		@FindBy(xpath = ".//*[@id='main']/form/div[2]/div[2]/div/ul/li[5]/div/div/ul/li[5]/a")
		WebElement tabLeaveMaster;
		
	public Super_EmployeeMasterPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public Super_CustomerDetailsPage clickOnCustomerDetailLink()
	{
		objectOfCustomerDetailLink.click();
		return new Super_CustomerDetailsPage();
		
	}
	
	public Super_EmployeeDetailPage clickOnEmpolyeeDetailLink()
	 {
		
	  objectOfEmployeeDetailLink.click();
	  return new Super_EmployeeDetailPage();
	  
	 }
	
	public Super_ClaimPage clickOnClaimLink()
	 {
		scrollDown(linkClaim);
		linkClaim.click();
	  return new Super_ClaimPage();
	  
	 }
	
	

	public Super_LeaveMaster clickOnLeaveMasterLink() 
	{
		tabLeaveMaster.click();
		return new Super_LeaveMaster();

	}
	
	public Super_EmployeeDetailPage clickOnEmployeeDetailLink() 
	{
		tabEmployeeDetail.click();
		return new Super_EmployeeDetailPage();

	}
}



