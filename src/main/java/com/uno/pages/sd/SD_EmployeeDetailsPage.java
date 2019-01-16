package com.uno.pages.sd;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.uno.baseClass.BaseCode;

public class SD_EmployeeDetailsPage extends BaseCode {

	public static int region = 1;
	public static int state = 1;
	public static int popLocation = 1;
	public static int city = 1;
	public static int role = 1;
	public static int customer = 1;
	
	

	SD_EmployeeDetailsPage sd_EmployeeDetailsPage;

	// Filter Tab
	@FindBy(css = "#open")
	WebElement tabFilter;

	// Search Staff Tab
	@FindBy(css = "#close")
	WebElement tabSearchStaff;

	// Filter By Region Drop down
	@FindBy(css = "select[name='m_strRegion11']")
	WebElement ddlFilterByRegion;

	// Filter By State Drop down
	@FindBy(css = "select[name='m_strState11']")
	WebElement ddlFilterByState;

	// Filter By Pop Location Drop down
	@FindBy(css = "select[name='m_strPopLoc11']")
	WebElement ddlFilterByPopLocation;

	// Filter By City Drop down
	@FindBy(css = "select[name='m_strCity11']")
	WebElement ddlFilterByCity;

	// Search By Role Drop down
	@FindBy(css = "select[name='m_strRole']")
	WebElement ddlSearchByRole;

	// Search By Business unit Drop down
	@FindBy(css = "select[name='m_strSearchBusinessUnit']")
	WebElement ddlSearchByBusinessUnit;

	// Search By Status Drop down
	@FindBy(css = "select[name='m_strSearchResignedEmp']")
	WebElement ddlSearchByStatus;

	// Filter By Customer Drop down
	@FindBy(css = "select[name='m_strFilterCustomerName']")
	WebElement ddlFilterByCustomer;

	// Filter By Skill Set Drop down
	@FindBy(css = "select[name='m_strFilterSkillSet']")
	WebElement ddlFilterBySkillSet;

	// Reset Filters Button
	@FindBy(css = "a[onclick='callResetFilters();']")
	WebElement btnResetFilters;

	// Search Button
	@FindBy(css = "a[onclick='searchStaff()']")
	WebElement btnSearch;

	// Search Tab
	@FindBy(css = "#open1")
	WebElement tabSearch;

	// Search By Staff Detail Tab
	@FindBy(css = "#close1")
	WebElement tabSearchByStaffDetail;

	// Search By Name Text box
	@FindBy(css = "input[name='m_strSearchName']")
	WebElement txtSearchByName;

	// Search By ECode Text box
	@FindBy(css = "input[name='m_strSearchEcode']")
	WebElement txtSSearchByECode;

	// Region List
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)")
	List<WebElement> lstRegion;

	// State List
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(2)")
	List<WebElement> lstState;

	// Pop Location List
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(14)")
	List<WebElement> lstPopLocation;

	// City List
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(15)")
	List<WebElement> lstCity;

	// Customer List
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(32)")
	List<WebElement> lstCustomer;
	

	// Upsd Role List
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(16)")
	List<WebElement> lstUpsdRole;
	
	// Name List
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)")
	List<WebElement> lstName;
	
	// ECode List
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(5)")
	List<WebElement> lstECode;
	
	// Column List
	@FindBy(css = ".fht-table>thead>tr>th")
	List<WebElement> lstColumn;
 	

	// Initializing Page Object
	public SD_EmployeeDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkDataFilterByRegion() throws Exception {

		// Click on Filter tab
		tabFilter.click();

		// Click on Reset Filter Button
		btnResetFilters.click();

		// Click on Filter tab
		tabFilter.click();

		// Get drop down of Filter By Region
		Select filterByRegion = new Select(ddlFilterByRegion);

		// Get list of Filter By Region
		List<WebElement> listOfFilterByRegion = filterByRegion.getOptions();
		// Get size of Filter By Region
		int sizeOfFilterByRegion = listOfFilterByRegion.size();
		// Print size of Filter By Region
		System.out.println("\nsizeOfRegion: " + sizeOfFilterByRegion);

		// Apply For Loop for Region
		for (; region < sizeOfFilterByRegion; region++) {

			// Get Region
			String regionOptions = listOfFilterByRegion.get(region)
					.getAttribute("value");
			// Print Region
			System.out.println("\nRegionOptions: " + regionOptions);
			Thread.sleep(2000);
			// Select IRegion
			filterByRegion.selectByIndex(region);
			Thread.sleep(1000);

			// Get size of Region
			int sizeOfRegion = lstRegion.size();
			// Print size of Region
			System.out.println("sizeOfRegion: " + sizeOfRegion);

			// Check condition
			if (sizeOfRegion > 0) {
				// Apply For Loop for Region
				for (int j = 0; j < sizeOfRegion; j++) {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstRegion.get(j));
					// Get Region
					String region = lstRegion.get(j).getText();
					// Print Region
					System.out.println("Region: " + region);
					// Verify Region
					Assert.assertEquals(region, regionOptions,
							"Region is not Same");

				}
				// Update Region
				region = region + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataFilterByRegion Method
				sd_EmployeeDetailsPage.checkDataFilterByRegion();
				Thread.sleep(2000);

			} else if (sizeOfRegion == 0) {
				// Update Region
				region = region + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataFilterByRegion Method
				sd_EmployeeDetailsPage.checkDataFilterByRegion();
				Thread.sleep(2000);
			}
		}

	}

	public void checkDataFilterByState() throws Exception {

		// Click on Filter tab
		tabFilter.click();

		// Click on Reset Filter Button
		btnResetFilters.click();

		// Click on Filter tab
		tabFilter.click();

		// Get drop down of Filter By Region
		Select filterByRegion = new Select(ddlFilterByRegion);
		filterByRegion.selectByVisibleText("West");

		// Click on Filter tab
		tabFilter.click();
		
		// Get drop down of Filter By State
		Select filterByState = new Select(ddlFilterByState);

		// Get list of Filter By State
		List<WebElement> listOfFilterByState = filterByState.getOptions();
		// Get size of Filter By State
		int sizeOfFilterByState = listOfFilterByState.size();
		// Print size of Filter By State
		System.out.println("\nsizeOfState: " + sizeOfFilterByState);

		// Apply For Loop for State
		for (; state < sizeOfFilterByState; state++) {

			// Get State
			String stateOptions = listOfFilterByState.get(state).getAttribute(
					"value");
			// Print State
			System.out.println("\nStateOptions: " + stateOptions);
			Thread.sleep(2000);
			// Select State
			filterByState.selectByIndex(state);
			Thread.sleep(1000);

			// Get size of State
			int sizeOfState = lstState.size();
			// Print size of State
			System.out.println("sizeOfState: " + sizeOfState);

			// Check condition
			if (sizeOfState > 0) {
				// Apply For Loop for State
				for (int j = 0; j < sizeOfState; j++) {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstState.get(j));
					// Get State
					String state = lstState.get(j).getText();
					// Print State
					System.out.println("State: " + state);
					// Verify State
					Assert.assertEquals(state, stateOptions,
							"State is not Same");

				}
				// Update State
				state = state + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataFilterByState Method
				sd_EmployeeDetailsPage.checkDataFilterByState();
				Thread.sleep(2000);

			} else if (sizeOfState == 0) {
				// Update State
				state = state + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataFilterByState Method
				sd_EmployeeDetailsPage.checkDataFilterByState();
				Thread.sleep(2000);
			}
		}

	}
	
	public void checkDataFilterByPopLocation() throws Exception {

		// Click on Filter tab
		tabFilter.click();

		// Click on Reset Filter Button
		btnResetFilters.click();

		// Click on Filter tab
		tabFilter.click();

		// Get drop down of Filter By Region
		Select filterByRegion = new Select(ddlFilterByRegion);
		filterByRegion.selectByVisibleText("West");

		// Click on Filter tab
		tabFilter.click();
		
		if(popLocation>1)
		{
			// Get drop down of Filter By State
			Select filterByState = new Select(ddlFilterByState);
			filterByState.selectByVisibleText("Select");
			
			// Click on Filter tab
			tabFilter.click();
		}
		
		// Get drop down of Filter By State
		Select filterByState = new Select(ddlFilterByState);
		filterByState.selectByVisibleText("Goa");
		

		// Click on Filter tab
		tabFilter.click();
		
		// Get drop down of Filter By PopLocation
		Select filterByPopLocation = new Select(ddlFilterByPopLocation);

		// Get list of Filter By PopLocation
		List<WebElement> listOfFilterByPopLocation = filterByPopLocation.getOptions();
		// Get size of Filter By PopLocation
		int sizeOfFilterByPopLocation = listOfFilterByPopLocation.size();
		// Print size of Filter By PopLocation
		System.out.println("\nsizeOfPopLocation: " + sizeOfFilterByPopLocation);

		// Apply For Loop for PopLocation
		for (; popLocation < sizeOfFilterByPopLocation; popLocation++) {

			// Get PopLocation
			String popLocationOptions = listOfFilterByPopLocation.get(popLocation).getAttribute(
					"value");
			// Print PopLocation
			System.out.println("\nPopLocationOptions: " + popLocationOptions);
			Thread.sleep(2000);
			// Select PopLocation
			filterByPopLocation.selectByIndex(popLocation);
			Thread.sleep(1000);

			// Get size of PopLocation
			int sizeOfPopLocation = lstPopLocation.size();
			// Print size of PopLocation
			System.out.println("sizeOfPopLocation: " + sizeOfPopLocation);

			// Check condition
			if (sizeOfPopLocation > 0) {
				// Apply For Loop for PopLocation
				for (int j = 0; j < sizeOfPopLocation; j++) {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstPopLocation.get(j));
					// Get PopLocation
					String popLocation = lstPopLocation.get(j).getText();
					// Print PopLocation
					System.out.println("PopLocation: " + popLocation);
					// Verify PopLocation
					Assert.assertEquals(popLocation, popLocationOptions,
							"PopLocation is not Same");

				}
				// Update PopLocation
				popLocation = popLocation + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataFilterByPopLocation Method
				sd_EmployeeDetailsPage.checkDataFilterByPopLocation();
				Thread.sleep(2000);

			} else if (sizeOfPopLocation == 0) {
				// Update PopLocation
				popLocation = popLocation + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataFilterByPopLocation Method
				sd_EmployeeDetailsPage.checkDataFilterByPopLocation();
				Thread.sleep(2000);
			}
		}

	}
	
	public void checkDataFilterByCity() throws Exception {

		// Click on Filter tab
		tabFilter.click();

		// Click on Reset Filter Button
		btnResetFilters.click();

		// Click on Filter tab
		tabFilter.click();

		// Get drop down of Filter By Region
		Select filterByRegion = new Select(ddlFilterByRegion);
		filterByRegion.selectByVisibleText("West");

		// Click on Filter tab
		tabFilter.click();
		
		if(city>1)
		{
			// Get drop down of Filter By State
			Select filterByState = new Select(ddlFilterByState);
			filterByState.selectByVisibleText("Select");
			
			// Click on Filter tab
			tabFilter.click();
		}
		
		// Get drop down of Filter By State
		Select filterByState = new Select(ddlFilterByState);
		filterByState.selectByVisibleText("Goa");
		

		// Click on Filter tab
		tabFilter.click();
		
		if(city>1)
		{
			// Get drop down of Filter By PopLocation
			Select filterByPopLocation = new Select(ddlFilterByPopLocation);
			filterByPopLocation.selectByVisibleText("Select");
			
			// Click on Filter tab
			tabFilter.click();
		}
		
		
		// Get drop down of Filter By PopLocation
		Select filterByPopLocation = new Select(ddlFilterByPopLocation);
		filterByPopLocation.selectByVisibleText("Goa");
		

		// Click on Filter tab
		tabFilter.click();
		
		// Get drop down of Filter By City
		Select filterByCity = new Select(ddlFilterByCity);

		// Get list of Filter By City
		List<WebElement> listOfFilterByCity = filterByCity.getOptions();
		// Get size of Filter By City
		int sizeOfFilterByCity = listOfFilterByCity.size();
		// Print size of Filter By City
		System.out.println("\nsizeOfCity: " + sizeOfFilterByCity);

		// Apply For Loop for City
		for (; city < sizeOfFilterByCity; city++) {

			// Get City
			String cityOptions = listOfFilterByCity.get(city).getAttribute(
					"value");
			// Print City
			System.out.println("\nCityOptions: " + cityOptions);
			Thread.sleep(2000);
			// Select City
			filterByCity.selectByIndex(city);
			Thread.sleep(1000);

			// Get size of City
			int sizeOfCity = lstCity.size();
			// Print size of City
			System.out.println("sizeOfCity: " + sizeOfCity);

			// Check condition
			if (sizeOfCity > 0) {
				// Apply For Loop for City
				for (int j = 0; j < sizeOfCity; j++) {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstCity.get(j));
					// Get City
					String city = lstCity.get(j).getText();
					// Print PopLocation
					System.out.println("City: " + city);
					// Verify PopLocation
					Assert.assertEquals(city, cityOptions,
							"City is not Same");

				}
				// Update City
				city = city + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataFilterByCity Method
				sd_EmployeeDetailsPage.checkDataFilterByCity();
				Thread.sleep(2000);

			} else if (sizeOfCity == 0) {
				// Update City
				city = city + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataFilterByCity Method
				sd_EmployeeDetailsPage.checkDataFilterByCity();
				Thread.sleep(2000);
			}
		}

	}
	
	public void checkDataSearchByRole() throws Exception {

		// Click on Filter tab
		tabFilter.click();

		// Click on Reset Filter Button
		btnResetFilters.click();

		// Click on Filter tab
		tabFilter.click();

		// Get drop down of Search By Role
		Select searchByRole = new Select(ddlSearchByRole);

		// Get list of SearchByRole
		List<WebElement> listOfSearchByRole = searchByRole.getOptions();
		// Get size of SearchByRole
		int sizeOfSearchByRole = listOfSearchByRole.size();
		// Print size of SearchByRole
		System.out.println("\nsizeOfRole: " + sizeOfSearchByRole);

		// Apply For Loop for SearchByRole
		for (; role < sizeOfSearchByRole; role++) {

			// Get Role
			String roleOptions = listOfSearchByRole.get(role)
					.getAttribute("value");
			// Print Role
			System.out.println("\nRoleOptions: " + roleOptions);
			Thread.sleep(2000);
			// Select Role
			searchByRole.selectByIndex(role);
			Thread.sleep(1000);

			// Get size of Role
			int sizeOfRole = lstUpsdRole.size();
			// Print size of Role
			System.out.println("sizeOfRole: " + sizeOfRole);

			// Check condition
			if (sizeOfRole > 0) {
				// Apply For Loop for Role
				for (int j = 0; j < sizeOfRole; j++) {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstUpsdRole.get(j));
					// Get Role
					String role = lstUpsdRole.get(j).getText();
					// Print Role
					System.out.println("Role: " + role);
					// Verify Role
					Assert.assertEquals(role, roleOptions,
							"Role is not Same");

				}
				// Update Role
				role = role + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataSearchByRole Method
				sd_EmployeeDetailsPage.checkDataSearchByRole();
				Thread.sleep(2000);

			} else if (sizeOfRole == 0) {
				// Update Role
				role = role + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataSearchByRole Method
				sd_EmployeeDetailsPage.checkDataSearchByRole();
				Thread.sleep(2000);
			}
		}

	}
	
	public void checkDataSearchByStatus() throws Exception {

		// Click on Filter tab
		tabFilter.click();


		// Get drop down of Search By Role
		Select searchByStatus = new Select(ddlSearchByStatus);
		searchByStatus.selectByVisibleText("Resigned Employee");

		int size= lstColumn.size();
		System.out.println("size: "+size);

		String allColumn= null;
		for(int i=0; i<size; i++)
		{
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					lstColumn.get(i));
		String column=  lstColumn.get(i).getText();
		//System.out.println("column: "+column);
		allColumn= allColumn +"\n"+ column;
		
		}
		
		
		System.out.println("allColumn: "+allColumn);
		boolean columnIsPresent = true;
		if (allColumn.contains("Resignation Date") && allColumn.contains("Last Working Date") && allColumn.contains("Tools Delivered") && allColumn.contains("Resignation Comment"))
		{
			columnIsPresent = true;
		}
		else
		{
			columnIsPresent = false;
		}
		Assert.assertTrue(columnIsPresent);
	}
	
	public void checkDataFilterByCustomer() throws Exception {

		// Click on Filter tab
		tabFilter.click();

		// Click on Reset Filter Button
		btnResetFilters.click();

		// Click on Filter tab
		tabFilter.click();

		// Get drop down of Filter By Customer
		Select filterByCustomer = new Select(ddlFilterByCustomer);

		// Get list of Filter By Customer
		List<WebElement> listOfFilterByCustomer = filterByCustomer.getOptions();
		// Get size of Filter By Customer
		int sizeOfFilterByCustomer = listOfFilterByCustomer.size();
		// Print size of Filter By Customer
		System.out.println("\nsizeOfCustomer: " + sizeOfFilterByCustomer);

		
		//
		
		
		// Apply For Loop for Customer
		for (; customer < sizeOfFilterByCustomer; customer++) {

			// Get Customer
			String customerOptions = listOfFilterByCustomer.get(customer)
					.getAttribute("value");
			// Print Customer
			System.out.println("\nCustomerOptions: " + customerOptions);
			Thread.sleep(2000);
			// Select Customer
			filterByCustomer.selectByIndex(customer);
			Thread.sleep(1000);

			// Get size of Customer
			int sizeOfCustomer = lstCustomer.size();
			// Print size of Customer
			System.out.println("sizeOfCustomer: " + sizeOfCustomer);

			// Check condition
			if (sizeOfCustomer > 0) {
				// Apply For Loop for Customer
				for (int j = 0; j < sizeOfCustomer; j++) {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							lstCustomer.get(j));
					// Get Customer
					String customer = lstCustomer.get(j).getText();
					// Print Customer
					System.out.println("Region: " + customer);
					// Verify Customer
					Assert.assertEquals(customer, customerOptions,
							"Customer is not Same");
					

				}
	/*			// Update Customer
				customer = customer + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataFilterByCustomer Method
				sd_EmployeeDetailsPage.checkDataFilterByCustomer();
				Thread.sleep(2000);
				

			} else if (sizeOfCustomer == 0) {
				// Update Customer
				customer = customer + 1;
				// Call Employee Details Page Of Sd Role
				sd_EmployeeDetailsPage = new SD_EmployeeDetailsPage();
				// call checkDataFilterByCustomer Method
				sd_EmployeeDetailsPage.checkDataFilterByCustomer();
				Thread.sleep(2000);
				
			}*/
		
				break;
			}
		}

	}

	public void checkDataSearchByName() throws Exception {

		// Click on Filter tab
		tabSearch.click();

		txtSearchByName.sendKeys("Adarsh");
		
		btnSearch.click();
		
		String name= lstName.get(0).getText();
		System.out.println("name: "+name);
		
		Assert.assertEquals(name, "Adarsh", "Name is not Same.");
	}

	
	public void checkDataSearchByEcode() throws Exception {

		// Click on Filter tab
		tabSearch.click();

		txtSSearchByECode.sendKeys("763461");
		
		btnSearch.click();
		
		String ecode= lstECode.get(0).getText();
		System.out.println("name: "+ecode);
		
		Assert.assertEquals(ecode, "763461", "Name is not Same.");
	}

}
