package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Super_ItemMasterPage extends BaseCode {
	
	 // Part Name of Item Master Page
    @FindBy(css = "select[name='m_strPartNameFillter']>option")
    @CacheLookup
    List<WebElement> dropdown_ListOfPartNameOfItemMasterPage;
    
    // Part Name of Item Master Page
    @FindBy(css = "select[name='m_strPartNameFillter']")
    WebElement dropdown_PartNameOfItemMasterPage;
    
    // List of Part Code In Table of Item Master Page
    @FindBy(css = ".fht-table.fht-table-init>tbody>tr>td:nth-of-type(2)")
    List<WebElement> list_PartCodeInTableOfItemMasterPage;
    
    public Super_ItemMasterPage()
	{
		PageFactory.initElements(driver, this);
		
	}

}
