package com.uno.pages.logistics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Logistic_HomePage extends BaseCode
{
  // Inventory Tab
  @FindBy(linkText = "Spare Details Report")
  WebElement link_SpareDetailsReport;
  
  public Logistic_HomePage()
  {
   PageFactory.initElements(driver, this);
  }
  
//Validate Home Page Title
  public String homePageTitle()
  {
   return driver.getTitle();
  }
  
//Click on Inventory link
  public Logistic_SpareDetailsReportPage SpareDetailsReportTab()
  {
   link_SpareDetailsReport.click();
   return new Logistic_SpareDetailsReportPage();
  }
  
}