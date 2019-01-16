package com.uno.pages.sd;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class SD_AttendancePage extends BaseCode {

	// Select Attendance Tab
	@FindBy(css = "a[href='/erprmwise/ViewEngAvailability.do']")
	WebElement tab_EngineerAvailability;
	
	// Click on My Availability
		@FindBy(css = "a[href='/erprmwise/EngineerAvailability.do']")
		WebElement tabMyAvailability;
		

		//Click on Engineer Attendance
			@FindBy(css = "a[href='/erprmwise/EngineerAttendance.do']")
			WebElement tabEngineerAttendance;
			

	// Initializing Page Object
	public SD_AttendancePage() {
		PageFactory.initElements(driver, this);
	}

	// Click on Ticket Tab
	public SD_EngineerAvailabilityPage engineerAvailabilityTab() {
		tab_EngineerAvailability.click();
		return new SD_EngineerAvailabilityPage();
	}
	
	
//Click on My Availability
	public SD_MyAvailabilityPage myAvailabilityTab()
	{
		tabMyAvailability.click();
		return new SD_MyAvailabilityPage();
	}

//Click on Engineer Attendance
	public SD_EngineerAttendancePage engineerAttendanceTab()
	{
		tabEngineerAttendance.click();
		return new SD_EngineerAttendancePage();
	}

}
