package com.uno.pages.superrole;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





import com.uno.baseClass.BaseCode;

public class Super_ServiceDeskSettingsPage extends BaseCode
{
	//select technician auto assign 
     @FindBy(xpath = ".//*[@id='serviceDeskSetting']/div/div[2]/div/table/tbody/tr[2]/td/input")
     WebElement button_TechnicianAutoAssign;
     
     //select with inventory
     @FindBy(xpath = ".//*[@id='serviceDeskSetting']/div/div[3]/div/table/tbody/tr[2]/td/input")
	public
     List <WebElement> radioButton_WithInventory;
     
     @FindBy(xpath = ".//*[@id='serviceDeskSetting']/div/div[3]/div/table/tbody/tr[4]/td/input")
	public
     List<WebElement>  radioButton_WithoutInventory;
     
     @FindBy(xpath = ".//*[@id='serviceDeskSetting']/div/div[2]/div/table/tbody/tr[10]/td/input")
     List<WebElement>  radioButton_ApproveByRM;
     
     //select save button
     @FindBy(xpath = ".//*[@id='serviceDeskSetting']/button")
     WebElement button_Save;
     

 	public Super_ServiceDeskSettingsPage() 
 	{
 		PageFactory.initElements(driver, this);

 	}

	public void selectWithInventoryRadioButton() 
	{

		// Create a boolean variable which will hold the value (True/False)
		// This statement will return True, in case of first Radio button is
		// selected

		boolean withInventoryIsYes = radioButton_WithInventory.get(0)
				.isSelected();
		System.out.println(withInventoryIsYes);
		
		boolean withoutInventoryIsNo = radioButton_WithoutInventory.get(0).isSelected();
		System.out.println(withoutInventoryIsNo);

		// This will check that if the bValue is True means if the first radio
		// button is selected

		if (withInventoryIsYes == false && withoutInventoryIsNo == true) 
		{

			radioButton_WithInventory.get(0).click();
			radioButton_WithoutInventory.get(1).click();
			button_Save.click();
			
			
		} else 
		{
			System.out.println("The With Inventory tab is selected");
			
			
		}
		

		
	}
	
	public void selectWithoutInventoryRadioButton() 
	{
		
		boolean withInventoryIsYes = radioButton_WithInventory.get(0)
				.isSelected();
		System.out.println(withInventoryIsYes);
		
		boolean withoutInventoryIsYes = radioButton_WithoutInventory.get(0).isSelected();
		System.out.println(withoutInventoryIsYes);

		// This will check that if the bValue is True means if the first radio
		// button is selected
		
		if (withInventoryIsYes == true && withoutInventoryIsYes== false) 
		{

			// If the first radio button is selected by , then select No button
             radioButton_WithInventory.get(1).click();
             radioButton_WithoutInventory.get(0).click();
             driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
             button_Save.click();

		} else 
		{

			System.out.println("The WithOut Inventory tab is selected");
			
		}

	
	}
	
	//select yes of 'Attendance Approve By RM'
	public void selectYesOfAttendanceApproveByRm() 
	{

		boolean approveByRmIsYes = radioButton_ApproveByRM.get(0)
				.isSelected();
		System.out.println(approveByRmIsYes);
		

		// This will check that if the Value is True means if the radio button is selected
		
		if (approveByRmIsYes == true) 
		{

			// If the first radio button is selected by , then select No button
			System.out.println("The Approve By Rm tab is selected");
            
          

		} else 
		{

			radioButton_ApproveByRM.get(0).click();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		    button_Save.click();
			
		}

	
		
	}
	
	public void selectNoOfAttendanceApproveByRm() 
	{

		boolean approveByRmIsYes = radioButton_ApproveByRM.get(0)
				.isSelected();
		System.out.println(approveByRmIsYes);
		

		// This will check that if the Value is True means if the radio button is selected
		
		if (approveByRmIsYes == false) 
		{

			// If the first radio button is selected by , then select No button
			System.out.println(" No is selected");
            
          

		} else 
		{

			radioButton_ApproveByRM.get(1).click();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		    button_Save.click();
			
		}

	
		
	}
	

}
