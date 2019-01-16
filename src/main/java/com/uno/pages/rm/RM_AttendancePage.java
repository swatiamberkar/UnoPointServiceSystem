package com.uno.pages.rm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;


public class RM_AttendancePage extends BaseCode{
	
	// Select Attendance Tab
	@FindBy(css = "a[href='/erprmwise/ViewEngAvailability.do']")
	WebElement tab_EngineerAvailability;
	

	// Click on My Availability
		@FindBy(css = "a[href='/erprmwise/EngineerAvailability.do']")
		WebElement tabMyAvailability;

	//Click on Engineer Attendance
		@FindBy(css = "a[href='/erprmwise/EngineerAttendance.do']")
		WebElement tabEngineerAttendance;
		
	//Click on Attendance Approval
		@FindBy(css = "a[href='/erprmwise/AttendanceApproval.do']")
		WebElement tabAttendanceApproval;

	// Initializing Page Object
	public RM_AttendancePage() {
		PageFactory.initElements(driver, this);
	}

	// Click on Ticket Tab
	public RM_EngineerAvailabilityPage engineerAvailabilityTab() {
		tab_EngineerAvailability.click();
		return new RM_EngineerAvailabilityPage();
	}
		
	//Validate Home Page Title
	public String attendancePageTitle()
	{
		return driver.getTitle();
	}
	
//Click on My Availability
	public RM_MyAvailabilityPage myAvailabilityTab()
	{
		tabMyAvailability.click();
		return new RM_MyAvailabilityPage();
	}

//Click on Engineer Attendance
	public RM_EngineerAttendancePage engineerAttendanceTab()
	{
		tabEngineerAttendance.click();
		return new RM_EngineerAttendancePage();
	}

//Click on Attendance Approval
	public RM_AttendanceApprovalPage attendanceApprovalTab()
	{
		tabAttendanceApproval.click();
		return new RM_AttendanceApprovalPage();
	}

}
