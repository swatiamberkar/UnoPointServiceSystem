package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Super_InventoryMastersPage extends BaseCode {
	
	
    
    // Item Master Link
    @FindBy(css = "a[href='/erprmwise/PartsAction.do?action=viewPart']")
    WebElement link_ItemMaster;
    
    // Spare Inventory Location Link
    @FindBy(css = "a[href='/erprmwise/SpareInventoryLocation.do?']")
    WebElement link_SpareInventoryLocation;
    
    // Courier Name Link
    @FindBy(css = "a[href='/erprmwise/CourierNameAction.do']")
    WebElement link_CourierName;
    
    // Courier Medium Link
    @FindBy(css = "a[href='/erprmwise/CourierMediumAction.do']")
    WebElement link_CourierMedium;
    
    
    
 
    
    public Super_InventoryMastersPage()
	{
		PageFactory.initElements(driver, this);
		
	}
    public Super_ItemMasterPage clickItemMasterLink() 
	 {
    	link_ItemMaster.click();
	  return new Super_ItemMasterPage();
	 }

    public Super_SpareInventoryLocationPage clickSpareInventoryLocationLink() 
  	 {
    	link_SpareInventoryLocation.click();
  	  return new Super_SpareInventoryLocationPage();
  	 }
    
    public Super_CourierNamePage clickCourierNameLink() 
 	 {
   	link_CourierName.click();
 	  return new Super_CourierNamePage();
 	 }
    
    public Super_CourierMediumPage clickCourierMediumLink() 
 	 {
   	link_CourierMedium.click();
 	  return new Super_CourierMediumPage();
 	 }

}
