package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Super_SpareInventoryLocationPage extends BaseCode {
	
	// List of Spare Inventory Location In Table of Spare Inventory Location Page
    @FindBy(xpath = ".//*[@id='right']/div/div/div[2]/table/tbody/tr/td[2]")
    @CacheLookup
    List<WebElement> list_SpareInventoryLocation;
    
    public Super_SpareInventoryLocationPage()
	{
		PageFactory.initElements(driver, this);
		
	}

}
