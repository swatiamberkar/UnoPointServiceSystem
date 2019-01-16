package com.uno.pages.rm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class RM_InventoryPage extends BaseCode 
{
	  
	//click on Transact Inventory
	  @FindBy(css = "a[href='/erprmwise/PartsAction.do?action=viewInvPart']")
	  WebElement tabTransactInventory; 
	  
	//click on Transaction Register
	  @FindBy(css = "a[href='/erprmwise/PartsAction.do?action=viewAllInvPart']")
	  WebElement tabTransactionRegister;  
	    
	//click on Stock Report
	  @FindBy(css = "a[href='/erprmwise/ViewStockReportForAll2.do']")
	  WebElement tabStockReport; 
	
	//click on spare approval
	 @FindBy(css = "a[href='/erprmwise/SpareApproval.do?action=View']")
     WebElement tabSpareApproval;
		 
		 
	//Initializing Page Object
		public RM_InventoryPage()
		{
			PageFactory.initElements(driver, this);
		}
		
	
	// Click on Transact Inventory Tab
	   public RM_TransactInventoryPage TransactInventoryTab()
	   {
		   tabTransactInventory.click();
		   return new RM_TransactInventoryPage();

	   }
	// Click on Transaction Register Tab
	   public RM_TransactionRegisterPage TransactionRegisterTab()
	   {
		 tabTransactionRegister.click();
		 return new RM_TransactionRegisterPage();
        }
	   
	// Click on Transaction Register Tab
	   public RM_StockReportPage StockReportTab()
	   {
		   tabStockReport.click();
		 return new RM_StockReportPage();
        }  
	   
	   
	   //Click on Spare Approval Tab
		public RM_SpareApprovalPage SpareApprovalTab()
		{
			tabSpareApproval.click();
			return new RM_SpareApprovalPage();
			
		}

	/*	 //Click on Spare Approval Tab
		public RM_SpareApprovalPage SpareApprovalTab()
		{
			tabSpareApproval.click();
			return new RM_SpareApprovalPage();
			
		}
	   */
	   
	
}
