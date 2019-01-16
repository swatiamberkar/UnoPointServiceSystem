package com.uno.pages.sd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;
import com.uno.pages.BasicFlowPage;



public class SD_TicketPage extends BaseCode {
//Select create new Tab
	@FindBy(css="a[href='/erprmwise/IncidentAction.do']")
	WebElement tab_CreateNew;
	
	@FindBy(xpath="//a[@href='/erprmwise/SearchIncidentPage.do?MenuClick=ViewIncident']")
	WebElement tab_ViewTicket;
	
	@FindBy(css="a[href='/erprmwise/ViewTicketWiseSubTicket.do?MenuClick=ViewIncident']")
	WebElement tab_ViewSubTicket;
	
	@FindBy(css="a[href='/erprmwise/ViewRequests2.do']")
	WebElement tab_ViewTicket_2;
	
	@FindBy(css="a[href='/erprmwise/DailyActivity.do']")
	WebElement tab_DailyActivity;
	
	@FindBy(css="a[href='/erprmwise/ToDoList.do']")
	WebElement tab_ToDo;
	
	@FindBy(css="a[href='/erprmwise/EngineerActivityAddActionNew.do']")
	WebElement tab_EngineerActivity;
	
	// SD Activity tab
	@FindBy(css="a[href='/erprmwise/TMActivityAddAction.do']")
	WebElement tab_SDActivity;
	
	// Reports tab
	@FindBy(css="a[href='/erprmwise/ReportsLink.do']")
	WebElement tab_Reports;
	
	// SD Activity tab
	@FindBy(css="a[href='/erprmwise/TMActivityAddAction.do']")
	WebElement tab_TechnicianBulkAssigned;
	

	
//Initializing Page Object
	public SD_TicketPage()
	{
		PageFactory.initElements(driver, this);
	}
	
//Click on Create New Tab
	public SD_CreateNewPage createNewTab()
	{
		tab_CreateNew.click();
		return new SD_CreateNewPage();
	}
	
//Click on View Ticket Tab
	public SD_ViewTicketPage viewTicketTab()
	{
		
		tab_ViewTicket.click();
	 return new SD_ViewTicketPage();
	}

	public SD_EditTicketPage EditTicket()
	{
		
		tab_ViewTicket.click();
	 return new SD_EditTicketPage();
	}
	
	public SdRoleWithSuperRolePage SdWithSuper()
	{
		
		tab_ViewTicket.click();
	 return new SdRoleWithSuperRolePage();
	}
	
	
	public SD_ViewSubTicketPage viewSubTicketTab()
	{
		tab_ViewSubTicket.click();
		return new SD_ViewSubTicketPage();
	}
	
	public BasicFlowPage demoPage()
	{
		tab_CreateNew.click();
		return new BasicFlowPage();
	}
	
	
	public BasicFlowPage demoFlow()
	{
		driver.findElement(By.xpath("//a[@href='/erprmwise/SearchIncidentPage.do?MenuClick=ViewIncident']")).click();
		return new BasicFlowPage();
		
	}
	
	public SD_ViewTicket2Page ViewTicket_2()
	{
		tab_ViewTicket_2.click();
		return new SD_ViewTicket2Page();
	}
	
	public SD_DailyActivityPage dailyActivity()
	{
		tab_DailyActivity.click();
		return new SD_DailyActivityPage();
	}
	
	public SD_ToDoPage toDo()
	{
		tab_ToDo.click();
		return new SD_ToDoPage();
	}
	
	public SD_EngineerActivityPage EngineerActivityTab()
	{
		tab_EngineerActivity.click();
		return new SD_EngineerActivityPage();
	}
	
	public SD_SDActivityPage SDActivityTab()
	{
		tab_SDActivity.click();
		return new SD_SDActivityPage();
	}
	
	public SD_ReportsPage reportsTab()
	{
		tab_Reports.click();
		return new SD_ReportsPage();
	}
	
	

}
