package com.uno.pages.logistics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Logistic_SpareDetailsReportPage extends BaseCode 
{
    //click on spare approval
  @FindBy(css = "a[href='/erprmwise/SparesInvRequired.do?action=setdate&range=Today']")
  WebElement tab_InventoryRequired;
 
 //Initializing Page Object
  public Logistic_SpareDetailsReportPage()
  {
   PageFactory.initElements(driver, this);
  }
  
 //Click on Spare Approval Tab
  public Logistic_InventoryRequiredPage InventoryRequiredTab()
  {
   tab_InventoryRequired.click();
   return new Logistic_InventoryRequiredPage();
   
  }


}


