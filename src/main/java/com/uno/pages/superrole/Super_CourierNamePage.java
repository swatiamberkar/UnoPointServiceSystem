package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Super_CourierNamePage extends BaseCode  {
	
	
    // List of Courier Name
    @FindBy(css = ".fixedHeaderCol.rectagleBox.marBot10>div>div:nth-of-type(2)>table>tbody>tr>td:nth-of-type(2)")
	public
    List<WebElement> list_CourierName;
    
	
	  public Super_CourierNamePage()
		{
			PageFactory.initElements(driver, this);
			
		}

}
