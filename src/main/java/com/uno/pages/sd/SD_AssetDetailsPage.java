package com.uno.pages.sd;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.BasicFlowPage;

public class SD_AssetDetailsPage extends BaseCode {

	public static String serialNumber = null;
	BasicFlowPage basicFlowPage;

	// Filter
	// Text box Asset Id
	@FindBy(css = "#m_strSearchByAssetID")
	WebElement txtAssetId;

	// Text box Serial Number
	@FindBy(css = "#m_strSearchBySerialNumber")
	WebElement txtSerialNumber;

	// Text box Customer
	@FindBy(css = "#m_strCustomerName")
	WebElement txtCustomer;

	// Drop down Business Unit
	@FindBy(css = "select[name='m_strBusinessUnit']")
	WebElement ddlBusinessUnit;

	// Drop down Principle Customer
	@FindBy(css = "#m_strPrincipalCust")
	WebElement ddlPrincipleCustomer;

	// Drop down Site Code
	@FindBy(css = "select[name='m_strFilterSiteCode']")
	WebElement ddlSiteCode;

	@FindBy(linkText = "Search Asset")
	WebElement btnSearchAssert;

	// Drop down Product Category
	@FindBy(css = "select[name='m_strFilterProductCategory']")
	WebElement ddlProductCategory;

	// Drop down Product Sub Category
	@FindBy(css = "select[name='m_strFilterProductSubCategory']")
	WebElement ddlProductSubCategory;

	// Drop down Make
	@FindBy(css = "select[name='m_strFilterMake']")
	WebElement ddlMake;

	// Drop down Product Model No
	@FindBy(css = "select[name='m_strFilterProductModelNo']")
	WebElement ddlProductModelNo;

	// Drop down Pop Location
	@FindBy(css = "select[name='m_strFilterPopLocation']")
	WebElement ddlPopLocation;

	// Drop down City
	@FindBy(css = "select[name='m_strFilterCity']")
	WebElement ddlCity;

	// Button Reset
	@FindBy(css = "a[onclick='resetFilter()']")
	WebElement btnReset;

	// Button Go
	@FindBy(css = "a[class='btn marTp10']")
	WebElement btnGo;

	// Table
	// List of Site Code
	@FindBy(css = ".rectagleBox_a>table>tbody>tr[class='trHover']>td:nth-of-type(1)")
	WebElement lstSiteCode;

	// List of Asset Id
	@FindBy(css = ".rectagleBox_a>table>tbody>tr[class='trHover']>td:nth-of-type(2)")
	WebElement lstAssetId;

	// List of Product Category
	@FindBy(css = ".rectagleBox_a>table>tbody>tr[class='trHover']>td:nth-of-type(3)")
	WebElement lstProductCategory;

	// List of Product Sub Category
	@FindBy(css = ".rectagleBox_a>table>tbody>tr[class='trHover']>td:nth-of-type(4)")
	WebElement lstProductSubCategory;

	// List of Make
	@FindBy(css = ".rectagleBox_a>table>tbody>tr[class='trHover']>td:nth-of-type(5)")
	WebElement lstMake;

	// List of Product Model No
	@FindBy(css = ".rectagleBox_a>table>tbody>tr[class='trHover']>td:nth-of-type(6)")
	WebElement lstProductModelNo;

	// List of Serial No
	@FindBy(css = ".rectagleBox_a>table>tbody>tr[class='trHover']>td:nth-of-type(7)")
	WebElement lstSerialNo;

	// List of Pop Location
	@FindBy(css = ".rectagleBox_a>table>tbody>tr[class='trHover']>td:nth-of-type(8)")
	WebElement lstPopLocation;

	// List of City
	@FindBy(css = ".rectagleBox_a>table>tbody>tr[class='trHover']>td:nth-of-type(9)")
	WebElement lstCity;

	// List of Address
	@FindBy(css = ".rectagleBox_a>table>tbody>tr[class='trHover']>td:nth-of-type(10)")
	WebElement lstAddress;

	// Geographical Information

	// Text box Site Code
	@FindBy(css = "input[name='m_strSiteCode']")
	WebElement txtSiteCode;

	// Text box Customer Contact Name
	@FindBy(css = "input[name='m_strCustomerContactName']")
	WebElement txtCustomerContactName;

	// Text box Customer Contact No
	@FindBy(css = "input[name='m_strCustomerContactNo']")
	WebElement txtCustomerContactNo;

	// Text box Customer Contact Email ID
	@FindBy(css = "input[name='m_strCustomerContactEmailID']")
	WebElement txtCustomerContactEmailID;

	// Text box Customer Address
	@FindBy(css = "#m_strCustomerAddress")
	WebElement txtCustomerAddress;

	// Text box Distance
	@FindBy(css = "input[name='m_strDistance']")
	WebElement txtDistance;

	// Text box Average Travel Time
	@FindBy(css = "input[name='m_strAvgTravelTime']")
	WebElement txtAverageTravelTime;

	// Drop down Region
	@FindBy(css = "select[name='m_strRegion']")
	WebElement ddlRegion;

	// Drop down State
	@FindBy(css = "select[name='m_strState']")
	WebElement ddlState;

	// Drop down Pop Location
	@FindBy(css = "select[name='m_strPopLocation']")
	WebElement ddlPopLocationInGeo;

	// Drop down City
	@FindBy(css = "select[name='m_strCity']")
	WebElement ddlCityInGeo;

	// SLA
	// Text box Customer SLA
	@FindBy(css = "input[name='m_strHCILSla']")
	WebElement txtCustomerSLA;

	// Text box Our SLA
	@FindBy(css = "input[name='m_strKSYSSla']")
	WebElement txtOurSLA;

	// Text box Response Time
	@FindBy(css = "input[name='m_strAssetSLAResolutionTime']")
	WebElement txtResponseTime;

	// Drop down Work Profile
	@FindBy(css = "select[name='m_strWorkProfile']")
	WebElement ddlWorkProfile;

	// Product

	// Drop down Product Category
	@FindBy(css = "select[name='m_strProductCategory']")
	WebElement ddlProductCategoryInProduct;

	// Drop down Product Sub-Category
	@FindBy(css = "select[name='m_strProductSubCategory']")
	WebElement ddlProductSubCategoryInProduct;

	// Text box Serial No
	@FindBy(css = "input[name='m_strSerialNo']")
	WebElement txtSerialNo;

	// Text box Asset Id
	@FindBy(css = "input[name='m_strAssetID']")
	WebElement txtAssetIdInProduct;

	// Text box Make
	@FindBy(css = "input[name='m_strMake']")
	WebElement txtMakeInProduct;

	// Text box Product Model No
	@FindBy(css = "input[name='m_strProductModelNo']")
	WebElement txtProductModelNo;

	// Team
	// Drop down Engineer Grade
	@FindBy(css = "select[name='m_strEngineerGrade']")
	WebElement ddlEngineerGrade;

	// Drop down Engineer
	@FindBy(css = "select[name='m_strEngineer']")
	WebElement ddlEngineer;

	// Drop down Manager
	@FindBy(css = "select[name='m_strTM']")
	WebElement ddlManager;

	// Text box Engineer Code
	@FindBy(css = "input[name='m_strEcode']")
	WebElement txtEngineerCode;

	// Text box Engineer Contact
	@FindBy(css = "input[name='m_strEngineercontact']")
	WebElement txtEngineerContact;

	// Text box Manager Contact
	@FindBy(css = "input[name='m_strTMContact']")
	WebElement txtManagerContact;

	// Text box Engineer Email
	@FindBy(css = "input[name='m_strEngineeremail']")
	WebElement txtEngineerEmail;

	// Text box Manager Email
	@FindBy(css = "input[name='m_strTMEmail']")
	WebElement txtManagerEmail;

	// Contract

	// Drop down Contract Reference Available
	@FindBy(css = "select[name='m_strContractRefAvilable']")
	WebElement ddlContractReferenceAvailable;

	// Text box Principle Warranty Start Date
	@FindBy(css = "input[name='m_strPrincipleWarantyStartDate']")
	WebElement txtPrincipleWarrantyStartDate;

	// Calendar Principle Warranty Start Date
	@FindBy(css = "a[id='fd-but-dp-6']")
	WebElement calPrincipleWarrantyStartDate;

	// Drop down Contract Ref No
	@FindBy(css = "select[name='m_strContractRefNo']")
	WebElement ddlContractRefNo;

	// Drop down PM Frequency
	@FindBy(css = "select[name='m_strPmSchedule']")
	WebElement ddlPMFrequency;

	// Text box Contract Start Date
	@FindBy(css = "input[name='m_strContractStartDate']")
	WebElement txtContractStartDate;

	// Text box Contract End Date
	@FindBy(css = "input[name='m_strContractEndDate']")
	WebElement txtContractEndDate;

	// Text box Principle Warranty End Date
	@FindBy(css = "input[name='m_strPrincipleWarantyEndDate']")
	WebElement txtPrincipleWarrantyEndDate;

	// Calendar Contract Start Date
	@FindBy(css = "a[id='fd-but-dp-1']")
	WebElement calContractStartDate;

	// Calendar Contract End Date
	@FindBy(css = "a[id='fd-but-dp-2']")
	WebElement calContractEndDate;

	// Calendar Principle Warranty End Date
	@FindBy(css = "a[id='fd-but-dp-4']")
	WebElement calPrincipleWarrantyEndDate;

	// Dates Contract Start Date
	@FindBy(css = "#fd-dp-1>.datePickerTable>tbody>tr>td")
	List<WebElement> datesContractStartDate;

	// Dates Contract End Date
	@FindBy(css = "#fd-dp-2>.datePickerTable>tbody>tr>td")
	List<WebElement> datesContractEndDate;

	// Dates Principle Warranty Start Date
	@FindBy(css = "#fd-dp-6>.datePickerTable>tbody>tr>td")
	List<WebElement> datesPrincipleWarrantyStartDate;

	// Dates Principle Warranty End Date
	@FindBy(css = "#fd-dp-4>.datePickerTable>tbody>tr>td")
	List<WebElement> datesPrincipleWarrantyEndDate;

	// Calendar Installation Date
	@FindBy(css = "a[id='fd-but-dp-5']")
	WebElement calInstallationDate;

	// Text box Installation Date
	@FindBy(css = "input[name='m_strInstallationDate']")
	WebElement txtInstallationDate;

	// Dates Installation Date
	@FindBy(css = "#fd-dp-5>.datePickerTable>tbody>tr>td")
	List<WebElement> datesInstallationDate;

	// Text box IP Address
	@FindBy(css = "input[name='m_strAdditionalFieldValue1']")
	WebElement txtIPAddress;

	// Text box Address Code
	@FindBy(css = "input[name='m_strAdditionalFieldValue2']")
	WebElement txtAddressCode;

	// Text box Address1
	@FindBy(css = "input[name='m_strAdditionalFieldValue3']")
	WebElement txtAddress1;

	// Initializing Page Object
	public SD_AssetDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public void createAsset() throws Exception {

		// int count=0;

		// Geographical Information
		ddlSiteCode.click();
		Select siteCode = new Select(ddlSiteCode);
		Thread.sleep(1000);
		siteCode.selectByValue("dem-Mum-0023");

		txtCustomerContactName.sendKeys("Pranjali");
		txtCustomerContactNo.sendKeys("8934680926");
		txtCustomerContactEmailID.sendKeys("pranjali.deshpande@ksys.in");
		// txtCustomerAddress.clear();
		// txtCustomerAddress.sendKeys("Vashi,Mumbai");

		// ddlRegion.click();
		Select region = new Select(ddlRegion);
		Thread.sleep(1000);
		region.selectByValue("West");
		Thread.sleep(2000);
		// ddlState.click();
		Select state = new Select(ddlState);
		Thread.sleep(1000);
		state.selectByVisibleText("Maharashtra");
		Thread.sleep(1000);
		// ddlPopLocationInGeo.click();
		Select popLocation = new Select(ddlPopLocationInGeo);
		Thread.sleep(1000);
		popLocation.selectByValue("Mumbai");
		Thread.sleep(1000);
		// ddlCityInGeo.click();
		Select city = new Select(ddlCityInGeo);
		Thread.sleep(1000);
		city.selectByValue("Mumbai");

		txtDistance.sendKeys("20Km");
		txtAverageTravelTime.sendKeys("2hrs");

		// SLA

		txtCustomerSLA.sendKeys("2hrs");
		txtOurSLA.sendKeys("1hrs");
		txtResponseTime.sendKeys("1hrs");

		// ddlProductCategoryInProduct.click();
		Select productCategoryInProduct = new Select(
				ddlProductCategoryInProduct);
		productCategoryInProduct.selectByValue("CD");
		Thread.sleep(1000);
		// ddlProductSubCategoryInProduct.click();
		Select productSubCategoryInProduct = new Select(
				ddlProductSubCategoryInProduct);
		productSubCategoryInProduct.selectByValue("CD");

		String serialno = "Demo_";

		/*
		 * int count = BasicFlowTest.count; count++;
		 * System.out.println("count:  " + count); String number =
		 * String.valueOf(count);
		 */

		// Get System Date
		Calendar min1 = new GregorianCalendar();
		int min2 = min1.get(Calendar.MINUTE);
		System.out.println(min2);
		String min3 = Integer.toString(min2);

		// Get System Date
		Calendar sec1 = new GregorianCalendar();
		int sec2 = sec1.get(Calendar.SECOND);
		System.out.println(sec2);
		String sec3 = Integer.toString(sec2);

		String value = min3.concat(sec3);
		System.out.println("Dynamic Value: " + value);

		serialNumber = serialno.concat(value);
		System.out.println("serialNumber: " + serialNumber);
		txtSerialNo.sendKeys(serialNumber);

		txtMakeInProduct.sendKeys("Dell");
		txtProductModelNo.sendKeys("Dell123");

		// ddlEngineerGrade.click();
		Select engineerGrade = new Select(ddlEngineerGrade);
		engineerGrade.selectByVisibleText("E4");

		// ddlEngineer.click();
		Select engineer = new Select(ddlEngineer);
		engineer.selectByVisibleText("Pranjali Deshpande");

		// ddlContractReferenceAvailable.click();
		Select contractReferenceAvailable = new Select(
				ddlContractReferenceAvailable);
		contractReferenceAvailable.selectByVisibleText("Yes");
		Thread.sleep(1000);
		// ddlContractRefNo.click();
		Select contractRefNo = new Select(ddlContractRefNo);
		contractRefNo.selectByIndex(2);

		// ddlPMFrequency.click();
		Select pmFrequency = new Select(ddlPMFrequency);
		pmFrequency.selectByValue("Yearly");

		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		int preDay = Integer.parseInt(currentDay);
		String previousDay = Integer.toString(preDay);

		calPrincipleWarrantyStartDate.click();

		// select close date and time

		// select Date
		String getDateValue = null;

		for (WebElement ele : datesPrincipleWarrantyStartDate) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(previousDay)) {
				Thread.sleep(1000);
				/*
				 * ((JavascriptExecutor) driver) .executeScript(
				 * "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');"
				 * , ele);
				 */
				highLight(ele);
				ele.click();
				getDateValue = ele.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}

		String getCloseDateValue = txtPrincipleWarrantyStartDate
				.getAttribute("value");

		System.out.println(getCloseDateValue);
		Thread.sleep(2000);
		calPrincipleWarrantyEndDate.click();
		driver.findElement(By.xpath(".//*[@id='dp-4-next-year-but']")).click();

		// select Date
		String getDateValue1 = null;

		for (WebElement ele : datesPrincipleWarrantyEndDate) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(previousDay)) {
				Thread.sleep(1000);
				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ele);
				ele.click();
				getDateValue1 = ele.getText();
				System.out.println("Select the date:-" + getDateValue1);

				break;
			}

		}

		String getCloseDateValue1 = txtPrincipleWarrantyEndDate
				.getAttribute("value");

		System.out.println(getCloseDateValue1);

		// }
		calInstallationDate.click();

		// select close date and time

		// select Date
		String getDateValue2 = null;

		for (WebElement ele : datesInstallationDate) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(previousDay)) {
				Thread.sleep(1000);
				highLight(ele);
				ele.click();
				getDateValue2 = ele.getText();
				System.out.println("Select the date:-" + getDateValue2);

				break;
			}

		}

		String getCloseDateValue2 = txtInstallationDate.getAttribute("value");

		System.out.println(getCloseDateValue2);

		txtIPAddress.sendKeys("127.0.0.1");

		scrollDown(btnGo);
		btnGo.click();

	}

	public void createAssetByExcel(String siteCodetxt,String customerContactNametxt,
			String customerContactNotxt, String customerContactEmailIDtxt,
			String customerAddressTxt, String regionTxt, String stateTxt,
			String popLocationTxt, String cityTxt, String distancetxt,
			String averageTravelTimeTxt, String customerSLATxt,
			String ourSLATxt, String responseTimeTxt,
			String productCategoryInProductTxt,
			String productSubCategoryInProductTxt, 
			String assetIdTxt, String makeInProductTxt,
			String productModelNoTxt, String engineerGradeTxt,
			String engineerTxt, String pmFrequencyTxt,
			String contractReferenceAvailableTxt, String contractRefNoTxt)
			throws Exception {

		// Geographical Information
		// Geographical Information
		//ddlSiteCode.click();
		Select siteCode = new Select(ddlSiteCode);
		Thread.sleep(1000);
		siteCode.selectByValue(siteCodetxt);
		// txtSiteCode.sendKeys(siteCodetxt);
		txtCustomerContactName.sendKeys(customerContactNametxt);
		txtCustomerContactNo.sendKeys(customerContactNotxt);
		txtCustomerContactEmailID.sendKeys(customerContactEmailIDtxt);
		//txtCustomerAddress.sendKeys(customerAddressTxt);

		Select region = new Select(ddlRegion);
		region.selectByVisibleText(regionTxt);
		Thread.sleep(2000);
		Select state = new Select(ddlState);
		state.selectByVisibleText(stateTxt);
		Thread.sleep(1000);
		Select popLocation = new Select(ddlPopLocationInGeo);
		popLocation.selectByVisibleText(popLocationTxt);
		Thread.sleep(2000);
		Select city = new Select(ddlCityInGeo);
		city.selectByVisibleText(cityTxt);

		txtDistance.sendKeys(distancetxt);
		txtAverageTravelTime.sendKeys(averageTravelTimeTxt);

		// SLA

		txtCustomerSLA.sendKeys(customerSLATxt);
		txtOurSLA.sendKeys(ourSLATxt);
		txtResponseTime.sendKeys(responseTimeTxt);

		// Product
		Select productCategoryInProduct = new Select(
				ddlProductCategoryInProduct);
		productCategoryInProduct
				.selectByVisibleText(productCategoryInProductTxt);
		Thread.sleep(2000);
		Select productSubCategoryInProduct = new Select(
				ddlProductSubCategoryInProduct);
		productSubCategoryInProduct
				.selectByVisibleText(productSubCategoryInProductTxt);

		String serialno = "Demo_";
		// Get System Date
		Calendar min1 = new GregorianCalendar();
		int min2 = min1.get(Calendar.MINUTE);
		System.out.println(min2);
		String min3 = Integer.toString(min2);

		// Get System Date
		Calendar hrs1 = new GregorianCalendar();
		int hrs2 = hrs1.get(Calendar.HOUR);
		System.out.println(hrs2);
		String hrs3 = Integer.toString(hrs2);

		String value = min3.concat(hrs3);
		System.out.println("Dynamic Value: " + value);

		serialNumber = serialno.concat(value);
		System.out.println("serialNumber: " + serialNumber);
		txtSerialNo.sendKeys(serialNumber);
		
		//txtSerialNo.sendKeys(SerialNoTxt);
		txtAssetId.sendKeys(assetIdTxt);
		txtMakeInProduct.sendKeys(makeInProductTxt);
		txtProductModelNo.sendKeys(productModelNoTxt);
		// Team

		Select engineerGrade = new Select(ddlEngineerGrade);
		engineerGrade.selectByVisibleText(engineerGradeTxt);
		Thread.sleep(3000);
		Select engineer = new Select(ddlEngineer);
		engineer.selectByVisibleText(engineerTxt);

		// Contract

		// Get System Date
		Calendar mydate = new GregorianCalendar();
		int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String currentDay = Integer.toString(dayOfMonth);

		int preDay = Integer.parseInt(currentDay);
		String previousDay = Integer.toString(preDay);

		Select contractReferenceAvailable = new Select(
				ddlContractReferenceAvailable);
		contractReferenceAvailable
				.selectByVisibleText(contractReferenceAvailableTxt);

		Thread.sleep(5000);
		//ddlContractRefNo.click();
		Select contractRefNo = new Select(ddlContractRefNo);

		contractRefNo.selectByValue(contractRefNoTxt);

		
		  WebElement contractReferenceAvailableValue =
		  contractReferenceAvailable .getFirstSelectedOption();
		  System.out.println("contractReferenceAvailableValue: " +
		  contractReferenceAvailableValue);
		  if
		  (contractReferenceAvailableValue.equals("Yes")) {
		 
		
		  Select pmFrequency = new Select(ddlPMFrequency);
		  pmFrequency.selectByVisibleText(pmFrequencyTxt);
		  
		  calPrincipleWarrantyStartDate.click();
		  
		  // select close date and time
		  
		  // select Date 
		  String getDateValue = null;
		  
		  for (WebElement ele : datesPrincipleWarrantyStartDate) {
		  
		  String date = ele.getText();
		  
		  if (date.equalsIgnoreCase(previousDay)) { Thread.sleep(1000);
		  ele.click();
		  getDateValue = ele.getText();
		  System.out.println("Select the date:-" + getDateValue);
		  
		  break; }
		  
		  }
		  
		  String getCloseDateValue = txtPrincipleWarrantyStartDate
		  .getAttribute("value");
		  
		  System.out.println(getCloseDateValue); Thread.sleep(2000);
		  calPrincipleWarrantyEndDate.click();
		  driver.findElement(By.xpath(".//[@id='dp-4-next-year-but']"))
		  .click();
		  
		  // select Date 
		  String getDateValue1 = null;
		  
		  for (WebElement ele : datesPrincipleWarrantyEndDate) {
		  
		  String date = ele.getText();
		  
		  if (date.equalsIgnoreCase(previousDay)) { Thread.sleep(1000);
		  ele.click(); getDateValue1 = ele.getText();
		  System.out.println("Select the date:-" + getDateValue1);
		  
		  break; 
		  }
		  
		  }
		  
		  String getCloseDateValue1 = txtPrincipleWarrantyEndDate
		  .getAttribute("value");
		  
		  System.out.println(getCloseDateValue1);
		 
		// }
		calInstallationDate.click();

		// select close date and time

		// select Date
		String getDateValue2 = null;

		for (WebElement ele : datesInstallationDate) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(previousDay)) {
				Thread.sleep(1000);
				ele.click();
				getDateValue2 = ele.getText();
				System.out.println("Select the date:-" + getDateValue2);

				break;
			}

		}

		String getCloseDateValue2 = txtInstallationDate.getAttribute("value");

		System.out.println(getCloseDateValue2);
		  }
		/*
		 * txtIPAddress.sendKeys(ipAddressTxt);
		 * txtAddressCode.sendKeys(addressCodeTxt);
		 * txtAddress1.sendKeys(address1Txt);
		 */
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", btnGo);
		btnGo.click();

		  
	}

	public void checkCustomerAddress() throws Exception {

		/*
		 * // Geographical Information ddlSiteCode.click(); Select siteCode =
		 * new Select(ddlSiteCode); Thread.sleep(1000);
		 * siteCode.selectByValue("dem-Mum-0023")
		 */;
		scrollDown(ddlBusinessUnit);
		Thread.sleep(1000);
		txtCustomerAddress.clear();
		driver.navigate().refresh();
		scrollDown(ddlBusinessUnit);
		String value = txtCustomerAddress.getText();
		Thread.sleep(1000);
		Assert.assertEquals(value, "", "Customer Address not get Clear.");
		// txtCustomerAddress.sendKeys("Vashi,Mumbai");

	}

}
