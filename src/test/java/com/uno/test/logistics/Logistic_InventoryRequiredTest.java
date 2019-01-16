package com.uno.test.logistics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.pages.logistics.Logistic_HomePage;
import com.uno.pages.logistics.Logistic_InventoryRequiredPage;
import com.uno.pages.logistics.Logistic_LoginPage;
import com.uno.pages.logistics.Logistic_SpareDetailsReportPage;



public class Logistic_InventoryRequiredTest extends
		Logistic_InventoryRequiredPage {
	Logistic_LoginPage loginPageOfLogisticRole;
	Logistic_HomePage homePageOfLogisticRole;
	Logistic_SpareDetailsReportPage spareDetailsReportPageOfLogisticRole;
	Logistic_InventoryRequiredPage inventoryRequiredPageOfLogisticRole;

	@BeforeClass
	public void loginIntoLogistic() throws Exception {
		initialization();
		// Maximize the Window to 100%.
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, "0"));

		// Call Login Page Of Logistic Role
		loginPageOfLogisticRole = new Logistic_LoginPage();
		// Login into Logistic Role
		homePageOfLogisticRole = loginPageOfLogisticRole.Login(
				properties.getProperty("loginIdForLogistic"),
				properties.getProperty("password"));
	}

	@BeforeMethod
	public void OpenInventoryRequiredPage() throws Exception {

		// Click on Spare Details Report Tab
		spareDetailsReportPageOfLogisticRole = homePageOfLogisticRole
				.SpareDetailsReportTab();
		Thread.sleep(1000);

		// Click on Inventory Required Tab
		inventoryRequiredPageOfLogisticRole = spareDetailsReportPageOfLogisticRole
				.InventoryRequiredTab();
		Thread.sleep(1000);

	}

@Test(priority=1)
	public void checkFromAndToDateAccordingSelectedDateRange() throws Exception {
		inventoryRequiredPageOfLogisticRole
				.checkFromAndToDateAccordingSelectedDateRange();

	}
	

	@Test(priority=2)
	public void checkDateOfRequestAccordingSelectedDateRange() throws Exception {
		inventoryRequiredPageOfLogisticRole
				.checkDateOfRequestAccordingSelectedDateRange();

	}
	/*	
	@Test(priority=3)
	public void checkRegionAccordingSelectedRegionFilter() throws Exception {
		inventoryRequiredPageOfLogisticRole
				.checkRegionAccordingSelectedRegionFilter();

	}
	
	@Test(priority=4)
	public void checkStateAccordingSelectedStateFilter() throws Exception {
		inventoryRequiredPageOfLogisticRole
				.checkStateAccordingSelectedStateFilter();

	}
	
	@Test(priority=5)
	public void checkPendingRemarkAccordingSelectedPendingRemarkFilter() throws Exception {
		inventoryRequiredPageOfLogisticRole
				.checkPendingRemarkAccordingSelectedPendingRemarkFilter();

	}
	
	@Test(priority=6)
	public void checkStatusAccordingSelectedStatusFilter() throws Exception {
		inventoryRequiredPageOfLogisticRole
				.checkStatusAccordingSelectedStatusFilter();

	}
	
	@Test(priority=7)
	public void checkCourierNameWithMasterInSuperRole() throws Exception {
		inventoryRequiredPageOfLogisticRole
				.checkCourierNameWithMasterInSuperRole();

	}
	
	@Test(priority=8)
	public void checkCourierMediumWithMasterInSuperRole() throws Exception {
		inventoryRequiredPageOfLogisticRole
				.checkCourierMediumWithMasterInSuperRole();

	}
	*/
	
	
	
	
	
	
	

	@AfterClass
	public void tearDown() {

		// Close the Window
		driver.quit();

	}

}
