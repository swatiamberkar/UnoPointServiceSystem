package com.uno.pages.technician;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uno.baseClass.BaseCode;

public class Technician_IncidentPage extends BaseCode
{
	
		@FindBy(xpath = "//div[@id='main']/div[2]/div[2]/div/ul/li[2]/div/div/ul/li/a/span")
		WebElement tab_ViewIncident;
	
	/*@FindBy(linkText = "View Incident")
	WebElement tab_ViewIncident;*/
		
		// select view sub ticket
		@FindBy(css = "a[href='/erprmwise/ViewSubRequests.do?MainAction=ViewSubTicket']")
		WebElement tabViewSubTicket;

		// select My Availability
		@FindBy(css = "a[href='/erprmwise/EngineerAvailability.do']")
		WebElement tabMyAvailability;

		
		
	//Initializing Page Object
		public Technician_IncidentPage()
		{
			PageFactory.initElements(driver, this);
		}
		
	//Click on Incident Tab
		public Technician_ViewIncidentPage ViewIncidentTab()
		{
			tab_ViewIncident.click();
			return new Technician_ViewIncidentPage();
		}
		
		public Technician_EditIncidentPage EditIncidentTab()
		{
			//scrollDown(tab_ViewIncident);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main']/div[2]/div[2]/div/ul/li[2]/div/div/ul/li/a/span")));
			//tab_ViewIncident.click();
			driver.findElement(By.xpath("//div[@id='main']/div[2]/div[2]/div/ul/li[2]/div/div/ul/li/a/span")).click();
			return new Technician_EditIncidentPage();
		}

		// Click on Incident Tab
		public Technician_MyAvailabilityPage MyAvailabilityTab() {
			tabMyAvailability.click();
			return new Technician_MyAvailabilityPage();
		}
		
		
				

}
