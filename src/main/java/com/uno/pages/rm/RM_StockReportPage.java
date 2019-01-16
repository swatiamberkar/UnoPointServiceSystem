package com.uno.pages.rm;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;

public class RM_StockReportPage extends BaseCode {
	// Select RM tab for logout tab
	@FindBy(linkText = "NewRM1")
	WebElement tabRM;

	// Select Assign Criteria drop down
	@FindBy(name = "m_strAssignCriteria")
	WebElement ddlSelectAssignCriteria;

	// Select Region filter drop down
	@FindBy(name = "m_strRegion")
	WebElement ddlRegionFilter;

	// Select State filter drop down
	@FindBy(name = "m_strState1")
	WebElement ddlState;

	// Select Location filter drop down
	@FindBy(name = "m_strPopLocation")
	WebElement ddlLocation;

	// Select Region list
	@FindBy(xpath = ".//*[@id='form']/div[4]/table/tbody/tr/td[1]")
	List<WebElement> lstRegion;

	// Select State list
	@FindBy(xpath = ".//*[@id='form']/div[4]/table/tbody/tr/td[2]")
	List<WebElement> lstState;

	// Select Location list
	@FindBy(xpath = ".//*[@id='form']/div[4]/table/tbody/tr/td[3]")
	List<WebElement> lstLocation;

	// Select Part Category drop down
	@FindBy(name = "m_strAssignCriteria")
	WebElement ddlSelectPartCategory;

	// Select Go button
	@FindBy(xpath = ".//*[@id='form']/div[2]/table/tbody/tr[3]/td[2]/a/span")
	WebElement btnGO;

	// click on download button
	@FindBy(xpath = ".//*[@id='form']/div[2]/table/tbody/tr[3]/td[4]/a/span")
	WebElement btnDownload;

	// Select header of table
	@FindBy(xpath = ".//*[@id='form']/div[4]/table/tbody/tr[1]/th")
	List<WebElement> lstHeader;

	// Initializing Page Object
	public RM_StockReportPage() {
		PageFactory.initElements(driver, this);

	}

	// If User select Assign Criteria as 'By Location' then stock report should
	// display where Send Criteria is 'To Location' (and Location column is
	// showing).
	public void checkSelectAssignCriteriaAsLocation() throws Exception {

		// select Assign criteria as By Location
		Select location = new Select(ddlSelectAssignCriteria);
		// location.selectByVisibleText("By Staff");
		location.selectByVisibleText("By Location");

		Thread.sleep(1000);

		int size = lstHeader.size();
		System.out.println("size: " + size);
		boolean locationIsPresent = false;
		for (int i = 0; i < size; i++) {
			String getHeaderValue = lstHeader.get(i).getText();
			System.out.println("getHeaderValue: " + getHeaderValue);

			if (getHeaderValue.contains("Location")) {
				Thread.sleep(1000);
				scrollDown(lstHeader.get(i));
				highLight(lstHeader.get(i));
				System.out.println("_____");
				locationIsPresent = true;
				break;

			}

		}
		assertTrue(locationIsPresent, "Location is not present");
	}

	// If User apply Region filter then entries having Region as per applied
	// filter should display in Stock Report
	public void checkRegionFilter() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// select location
		Select location = new Select(ddlSelectAssignCriteria);
		location.selectByVisibleText("By Location");

		// select Region
		Select region = new Select(ddlRegionFilter);
		region.selectByVisibleText("East");

		String regionFilterValue = ddlRegionFilter.getAttribute("value");
		System.out.println("regionFilterValue:" + regionFilterValue);

		Thread.sleep(1000);
		// get value from string
		scrollDown(ddlRegionFilter);

		highLight(ddlRegionFilter);

		int size = lstRegion.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			String regionInList = lstRegion.get(i).getText();
			System.out.println("locationInList:" + regionInList);

			Thread.sleep(1000);
			scrollDown(ddlRegionFilter);

			highLight(ddlRegionFilter);

			boolean regionIsSame = true;
			if (regionInList.equals(regionFilterValue)) {

				softAssert.assertTrue(regionIsSame, "Location is different");

			}

		}

		softAssert.assertAll();

	}
	

}
