package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.rm.RM_LeaveApprovalPage;

public class Super_LeaveMaster extends BaseCode 
{
	   RM_LeaveApprovalPage rm_LeaveApprovalPage; 
	
	// Select RM tab for logout tab
		@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[1]")
		List<WebElement> lstLeave;

	public Super_LeaveMaster()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void getLeaveName()
	{
		SoftAssert softAssert = new SoftAssert();
		 int size = lstLeave.size();
		 System.out.println(size);
		 
		 for (int i= 0 ; i<size ; i++)
		 {
			 
			
			 String leaveInSuper = lstLeave.get(i).getText();
			 System.out.println("leave: "+leaveInSuper);
			 
			 boolean leaveTypeIsSame = true;
			 if (RM_LeaveApprovalPage.leaveTypeInSd.contains(leaveInSuper))
			 {
				 
			   softAssert.assertTrue(leaveTypeIsSame, "Leave type is different");
			 
			 }
			 	 
		 }
		 
		 softAssert.assertAll();
		
	}
	

}
