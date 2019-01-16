package com.uno.pages.rm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class RM_HomePage extends BaseCode {
	// Inventory Tab
	@FindBy(linkText = "Inventory")
	WebElement link_Inventory;

	// Dash board Tab
	@FindBy(linkText = "Dashboard")
	WebElement tabDashboard;

	// Incident Tab
	@FindBy(linkText = "Incident")
	WebElement tabIncident;

	// Attendance Tab
	@FindBy(linkText = "Attendance")
	WebElement tabAttendance;

	// Inventory Tab
	@FindBy(linkText = "Inventory")
	WebElement tabInventory;

	// Geo-Location Tab
	@FindBy(linkText = "Geo-Location")
	WebElement tabGeo_Location;

	// Claim Tab
	@FindBy(linkText = "Claim")
	WebElement tabClaim;

	// Bhagyashree Tab
	@FindBy(linkText = "Bhagyashree")
	WebElement tabBhagyashree;

	public RM_HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Validate Home Page Title
	public String homePageTitle() {
		return driver.getTitle();
	}

	// Click on Inventory link
	public RM_IncidentPage IncidentTab() {
		tabIncident.click();
		return new RM_IncidentPage();
	}

	// Click on Inventory link
	public RM_InventoryPage InventoryTab() {
		link_Inventory.click();
		return new RM_InventoryPage();
	}

	// Click on AttendanceTab
	public RM_AttendancePage AttendanceTab() {
		tabAttendance.click();
		return new RM_AttendancePage();
	}

	// Click on AttendanceTab
	public RM_ClaimPage ClaimTab() {
		tabClaim.click();
		return new RM_ClaimPage();
	}

}
