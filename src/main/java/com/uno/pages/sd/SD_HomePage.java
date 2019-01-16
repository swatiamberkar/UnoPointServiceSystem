package com.uno.pages.sd;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class SD_HomePage extends BaseCode {

	// Select Ticket Tab
	@FindBy(linkText = "Ticket")
	WebElement objectOfTicketTab;

	// Select Ticket Summary Tab
	@FindBy(linkText = "Ticket Summary")
	WebElement objectOfTicketSummaryTab;

	// Select Ticket Tab
	@FindBy(linkText = "KEDB")
	WebElement tab_KEDB;

	// Select Attendance Tab
	@FindBy(linkText = "Attendance")
	WebElement tab_Attendance;
	
	// Select Attendance Tab
	@FindBy(linkText = "Employee")
	WebElement tab_Employee;

	// Initializing Page Object
	public SD_HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Validate Home Page Title
	public String homePageTitle() {
		return driver.getTitle();
	}

	// Click on Ticket Tab
	public SD_TicketPage ticketTab() {
		objectOfTicketTab.click();
		return new SD_TicketPage();
	}

	// Click on Ticket Summary
	public SD_TicketSummaryPage ticketSummaryTab() {
		objectOfTicketSummaryTab.click();
		return new SD_TicketSummaryPage();
	}

	// Click on KEDB Page
	public SD_KEDBPage KEDBab() {
		tab_KEDB.click();
		return new SD_KEDBPage();
	}

	// Click on Attendance Tab
	public SD_AttendancePage attendanceTab() {
		tab_Attendance.click();
		return new SD_AttendancePage();

	}
	
	// Click on Attendance Tab
	public SD_EmployeePage EmployeeTab() {
		tab_Employee.click();
		return new SD_EmployeePage();

	}
}
