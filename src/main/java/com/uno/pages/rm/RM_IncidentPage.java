package com.uno.pages.rm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;



public class RM_IncidentPage extends BaseCode {
	
	// Create New Tab
	@FindBy(css = "a[href='/erprmwise/IncidentAction.do']")
	WebElement  tabCreateNew;
	
	// View Incident Tab
	@FindBy(css = "a[href='/erprmwise/SearchIncidentPage.do?MenuClick=ViewIncident']")
	WebElement tabViewIncident;
	
	// View Sub Ticket Tab
	@FindBy(css = "a[href='/erprmwise/ViewTicketWiseSubTicket.do']")
	WebElement tabViewSubTicket;
	
	// To Do Tab
	@FindBy(css = "a[href='/erprmwise/ToDoList.do']")
	WebElement tabToDo;
	
	// Daily Activity Tab
	@FindBy(css = "a[href='/erprmwise/DailyActivity.do']")
	WebElement tabDailyActivity;
	
	// Engineer Activity Tab
	@FindBy(css = "a[href='/erprmwise/EngineerActivityAddActionNew.do']")
	WebElement tabEngineerActivity;
	
	// Manager Activity Tab
	@FindBy(css = "a[href='/erprmwise/TMActivityAddAction.do']")
	WebElement tabManagerActivity;
	
	// Reports Tab
	@FindBy(css = "a[href='/erprmwise/ReportsLink.do']")
	WebElement tabReports;

		public RM_IncidentPage() {
			PageFactory.initElements(driver, this);
		}

		// Click on ViewIncidentTab
		public RM_ViewIncidentPage ViewIncidentTab() {
			tabViewIncident.click();
			return new RM_ViewIncidentPage();
		}
		
		// Click on EditIncident
				public RM_EditIncidentPage EditIncident() throws Exception {
					highLight(tabViewIncident);
					tabViewIncident.click();
					Actions builder = new Actions(driver);
					Action seriesOfActions = builder
						.moveToElement(tabViewIncident).build();
					seriesOfActions.perform();
				//	tabViewIncident.click();
					return new RM_EditIncidentPage();
				}
				
				// Click on ToDoTab
				public RM_ToDoPage ToDoTab() {
					tabToDo.click();
					return new RM_ToDoPage();
				}
				
				// Click on DailyActivityTab
				public RM_DailyActivityPage DailyActivityTab() {
					tabDailyActivity.click();
					return new RM_DailyActivityPage();
				}
				
				// Click on DailyActivityTab
				public RM_EngineerActivityPage EngineerActivityTab() {
					tabEngineerActivity.click();
					return new RM_EngineerActivityPage();
				}
				
				// Click on DailyActivityTab
				public RM_ManagerActivityPage ManagerActivityTab() {
					tabManagerActivity.click();
					return new RM_ManagerActivityPage();
				}
				
				// Click on Inventory link
				public RM_CreateNewPage createNewTab() throws Exception {
					highLight(tabCreateNew);
					tabCreateNew.click();
					Actions builder = new Actions(driver);
					Action seriesOfActions = builder
						.moveToElement(tabCreateNew).build();
					seriesOfActions.perform();
					
					//tabCreateNew.click();
					return new RM_CreateNewPage();
				}
				
				public RM_ViewSubTicketPage viewSubTicketTab() {
					tabViewSubTicket.click();
					return new RM_ViewSubTicketPage();
				}



}
