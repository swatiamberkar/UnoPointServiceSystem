package com.uno.pages.rm;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.BasicFlowPage;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_ViewTicketPage;

public class RM_SpareApprovalPage extends BaseCode {
	
	
	public static String lastSpareRemarkInRM = null;

	BasicFlowPage demo;

	RM_HomePage homePageOfReportingManagerRole;
	RM_InventoryPage inventoryPageOfReportingManagerRole;
	RM_SpareApprovalPage spareApprovalPageInReportingManagerRole;
	// Call method from RM login
		RM_LoginPage rm_LoginPage;
		RM_HomePage rm_HomePage;
		SD_TicketPage sd_TicketPage;
		SD_ViewTicketPage Sd_ViewTicketPage;
		SD_HomePage sd__HomePage;
		private static String downloadPath = "C:\\Users\\Admin\\Downloads";
		public static String spareRequestId = null;
		public static String ticketId = null;
		public static String spareRemark = null;

	// Select tab for logout tab
	@FindBy(linkText = "Bhagyashree")
	WebElement link_RM;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement link_LogOut;

	@FindBy(name = "m_strIncidentID")
	WebElement textbox_IncidentID;

	@FindBy(xpath = ".//*[@id='Search_Incident']/tbody/tr[2]/td[2]/img")
	WebElement button_IncidentIdGo;

	@FindBy(name = "m_strFromDate1")
	WebElement textbox_FromDate;

	@FindBy(name = "m_strToDate1")
	WebElement textbox_ToDate;

	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr[1]/th")
	List<WebElement> list_ColumnHeadingInTable;

	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr[@class='trHover f2f2f2']/td[1]")
	List<WebElement> list_SpareRequestId;

	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr[@class='trHover f2f2f2']/td")
	List<WebElement> list_ColumnInTable;

	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr[@class='trHover f2f2f2']/td[13]")
	List<WebElement> list_SpareRemark;
	
	
	
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr[@class='trHover f2f2f2']/td[14]/a")
	List<WebElement> list_EditSpareRemark;

	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr[@class='trHover f2f2f2']/td[16]/a/span")
	List<WebElement> list_ApproveButton;

	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr[@class='trHover f2f2f2']/td[17]/a/span")
	List<WebElement> list_RejectButton;

	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr[@class='trHover f2f2f2']")
	List<WebElement> list_RowInTable;
	
	// Text box of Spare Remark in Update Spare Remark Page
	@FindBy(css = "input[name='m_strRemark']")
	WebElement textbox_SpareRemarkInUpdateSpareRemarkPopup;
	
	// Update Button in Update Spare Remark Page
	@FindBy(css = "a[onclick='UpdateSpareRemark()']")
	WebElement button_UpdateInUpdateSpareRemarkPopup;

	// Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option")
	List<WebElement> dropdown_Pagination;

	// select reject pop up window name
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[17]/a/span")
	WebElement label_ReasonForRejectSpare;

	// click on reject button
	@FindBy(name = "m_strReason")
	WebElement textbox_ReasonForRejectSpare;

	// click on reject button
	@FindBy(xpath = ".//*[@id='boxa']/div/a[1]/span")
	WebElement button_RejectInReasonPopUp;

	// Notification of View Ticket Page
	@FindBy(css = "#dialogBoxSuccess")
	WebElement notification;
	
	// Select home tab symbol
	@FindBy(css = "a[href='/erprmwise/SDHomeScreen.do']")
	WebElement tabHomeSD;

	@FindBy(css = "a[href='/erprmwise/RMHomeScreen.do']")
	WebElement tabHomeRM;

	// Select SD tab for logout tab
	@FindBy(linkText = "NewRM1")
	WebElement tabRM;

	// Select SD tab for logout tab
	@FindBy(linkText = "SD")
	WebElement tabSd;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement tabLogOut;

	// Select heading of page
	@FindBy(xpath = ".//*[@id='headingText']/span")
	WebElement heading;

	// Select Incident ID
	@FindBy(name = "m_strIncidentID")
	WebElement txtIncidentID;

	// Select Part Code
	@FindBy(name = "m_strPartCode")
	WebElement txtPartCode;

	// Select Part Name
	@FindBy(name = "m_strPartName")
	WebElement txtPartName;

	// Select From Date
	@FindBy(name = "m_strFromDate1")
	WebElement txtFromDate;

	// Select To Date
	@FindBy(name = "m_strToDate1")
	WebElement txtToDate;

	// Select from Date calendar
	@FindBy(xpath = ".//*[@id='fd-but-dp-1']/span[1]")
	WebElement lblFromCalendar;

	@FindBy(xpath = ".//*[@id='fd-dp-1']/table/tbody/tr/td")
	List<WebElement> dtpFromCalendar;

	@FindBy(xpath = ".//*[@id='fd-dp-2']/table/tbody/tr/td")
	List<WebElement> dtpToCalendar;

	// Select To Date calendar
	@FindBy(xpath = ".//*[@id='fd-but-dp-2']/span[1]")
	WebElement lblToCalendar;

	// Select Go Button Incident ID
	@FindBy(css = "img[onclick='SearchByIncId()']")
	WebElement btnGoIncidentId;

	// Select Go Button Part Code
	@FindBy(css = "img[onclick='SearchByPartCode();']")
	WebElement btnGoPartCode;

	// Select Go Button Part Name
	@FindBy(css = "img[onclick='SearchByPartName()']")
	WebElement btnGoPartName;

	// Select Go Button Date
	@FindBy(css = "img[onclick='SearchByDate()']")
	WebElement btnGoDate;


	// select Spare Request ID
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[1]")
	List<WebElement> lstSpareRequestID;

	// select Incident Id
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[2]")
	List<WebElement> lstIncidentId;

	//select Part Code
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[6]")
	List<WebElement> lstPartCode;

	//select Part Name
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[7]")
	List<WebElement> lstPartName;

	//select Date Of Request
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[5]")
	List<WebElement> lstDateOfRequest;

	// select Ticket Id
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[10]")
	List<WebElement> lstTicketId;

	// select Spare Remark
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[13]")
	List<WebElement> lstSpareRemark;
		
	// select Edit Spare Remark
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[14]/a")
	List<WebElement> lstEditSpareRemark;

	// select Engineer Stock
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[15]/a")
	List<WebElement> lstEngineerStock;

	// select Approved
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[16]/a")
	List<WebElement> lstApproved;

	// select Reject
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[17]/a")
	List<WebElement> lstReject;

	// Select Spare Remark
	@FindBy(name = "m_strRemark")
	WebElement txtSpareRemark;

	// Select Reject Reason
	@FindBy(name = "m_strReason")
	WebElement txtRejectReason;
		
	// Select Reject Reason
	@FindBy(linkText = "Reject")
	WebElement btnReject;

	// Select update Button 
	@FindBy(xpath = ".//*[@id='boxsr']/div/table/tbody/tr[3]/td[3]/a")
	WebElement btnUpdate;

	// Notification of View Ticket Page
	@FindBy(css = "#dialogBoxSuccess")
	WebElement lblNotification;

	// Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option")
	List<WebElement> ddlPagination;

	// Left Most Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(1)")
	WebElement btnLeftmostArrowOfPagination;

	// Right Most Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(4)")
	WebElement btnRightmostArrowOfPagination;

	// Right Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(3)")
	WebElement btnRightArrowOfPagination;

	// Left Arrow Of Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>a:nth-of-type(2)")
	WebElement btnLeftArrowOfPagination;

	// Selected Page in Pagination
	@FindBy(css = "div[id='pagination']:nth-of-type(2)>select>option[selected='selected']")
	WebElement pageSelectedInPagination;

	// List of Row in Table
	@FindBy(css = "table[class='fht-table fht-table-init']>tbody>tr[class = 'odd']")
	List<WebElement> lstRowInTable;

	// click on download button
	@FindBy(linkText = "Download Excel")
		WebElement btnDownload;

	public RM_SpareApprovalPage() {
		PageFactory.initElements(driver, this);

	}

	public void matchSpareRequestIdInRM() throws Exception {
		

	//	 String lastSpareRequestIDInSD = Demonstration.lastSpareRequestIDInSD;
		String lastSpareRequestIDInSD = BasicFlowPage.lastSpareRequestIDInSD;

	//	 String incidentIDInSD = Demonstration.incidentID;
		String incidentIDInSD = BasicFlowPage.incidentID;

		System.out.println("incidentIDInSD: " + incidentIDInSD);
		textbox_IncidentID.clear();
		textbox_IncidentID.sendKeys(incidentIDInSD);

		button_IncidentIdGo.click();

		Thread.sleep(1000);

		int sizeOfSpareRequestId = list_SpareRequestId.size();
		System.out.println(sizeOfSpareRequestId);

		String lastSpareRequestIDInRM = list_SpareRequestId.get(
				sizeOfSpareRequestId - 1).getText();
		System.out.println(lastSpareRequestIDInRM);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				list_SpareRequestId.get(sizeOfSpareRequestId - 1));

		Assert.assertEquals(lastSpareRequestIDInRM, lastSpareRequestIDInSD,
				"Spare ID is not match.");

	}

	public void checkAscendingOrderOfSpareRequestIdInRM() throws Exception {

		int sizeOfSpareRequestId = list_SpareRequestId.size();
		System.out.println(sizeOfSpareRequestId);

		for (int i = 0; i < sizeOfSpareRequestId - 1; i++) {

			String getSpareRequestID1 = list_SpareRequestId.get(i).getText();
			System.out.println(getSpareRequestID1);
			Matcher m = Pattern.compile("\\d+").matcher(getSpareRequestID1);
			m.find();
			String textOfFirstID = m.group(0);
			System.out.println(textOfFirstID);
			int firstID = Integer.parseInt(textOfFirstID);
			System.out.println(firstID);

			String getSpareRequestID2 = list_SpareRequestId.get(i + 1)
					.getText();
			System.out.println(getSpareRequestID2);
			Matcher m2 = Pattern.compile("\\d+").matcher(getSpareRequestID2);
			m2.find();
			String textOfSecondID = m2.group(0);
			System.out.println(textOfSecondID);
			int secondID = Integer.parseInt(textOfSecondID);
			System.out.println(secondID);

			try {
				if (firstID < secondID) {
					System.out.println("Pass");
				}

			}

			catch (Exception e) {
				System.out.println("Fail");
			}

			if (sizeOfSpareRequestId - 1 == i) {
				Assert.assertTrue(false, "spare request Id is not available");
			}
		}
	}

	public void checkApproveButtonOfSpareRequestInRM() throws Exception {

		spareApprovalPageInReportingManagerRole = new RM_SpareApprovalPage();

		driver.findElement(
				By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Inventory")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/SpareApproval.do?action=View']"))
				.click();

		// String lastSpareRequestIDInSD = Demonstration.lastSpareRequestIDInSD;
		String lastSpareRequestIDInSD = BasicFlowPage.lastSpareRequestIDInSD;

		System.out.println("lastSpareRequestIDInSD: " + lastSpareRequestIDInSD);
		
		// String lastSpareRequestIDInSD = Demonstration.lastSpareRequestIDInSD;
				String secondLastSpareRequestIDInSD = BasicFlowPage.secondLastSpareRequestIDInSD;

				System.out.println("secondLastSpareRequestIDInSD: " + secondLastSpareRequestIDInSD);

		int sizePagination = dropdown_Pagination.size();
		System.out.println(sizePagination);

		dropdown_Pagination.get(sizePagination - 1).click();

		int sizeOfSpareRequestId = list_SpareRequestId.size();
		System.out.println("sizeOfSpareRequestId: " + sizeOfSpareRequestId);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				list_SpareRequestId.get(sizeOfSpareRequestId - 1));

		String lastSpareRequestIdInRM = list_SpareRequestId.get(
				sizeOfSpareRequestId - 1).getText();
		System.out.println("lastSpareRequestIdInRM: " + lastSpareRequestIdInRM);

		if (lastSpareRequestIDInSD.equalsIgnoreCase(lastSpareRequestIdInRM)) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					list_SpareRequestId.get(sizeOfSpareRequestId - 1));

			System.out.println("lastSpareRequestIdInRM: "
					+ lastSpareRequestIdInRM);


			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					list_ApproveButton.get(sizeOfSpareRequestId - 1));

			Thread.sleep(1000);

			list_ApproveButton.get(sizeOfSpareRequestId - 1).click();

			System.out.println("Click on Approve button");
			Thread.sleep(3000);
			
			int sizePagination1 = dropdown_Pagination.size();
			System.out.println(sizePagination1);

			dropdown_Pagination.get(sizePagination1 - 1).click();

			int sizeOfSpareRequestIdAfterApprove = list_SpareRequestId.size();
			System.out.println("sizeOfSpareRequestIdAfterApprove: "
					+ sizeOfSpareRequestIdAfterApprove);

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", list_SpareRequestId
							.get(sizeOfSpareRequestIdAfterApprove - 1));

			String lastSpareRequestIdInRMAfterApprove = list_SpareRequestId
					.get(sizeOfSpareRequestIdAfterApprove - 1).getText();
			System.out.println("lastSpareRequestIdInRMAfterApprove: "
					+ lastSpareRequestIdInRMAfterApprove);

			Assert.assertFalse(lastSpareRequestIDInSD
					.equalsIgnoreCase(lastSpareRequestIdInRMAfterApprove),
					"Spare Request is not get Remove.");
			System.out.println("Spare Request is get Remove.");

		}
		else if (secondLastSpareRequestIDInSD.equalsIgnoreCase(lastSpareRequestIdInRM)) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					list_SpareRequestId.get(sizeOfSpareRequestId - 1));

			System.out.println("lastSpareRequestIdInRM: "
					+ lastSpareRequestIdInRM);


			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					list_ApproveButton.get(sizeOfSpareRequestId - 1));

			Thread.sleep(1000);

			list_ApproveButton.get(sizeOfSpareRequestId - 1).click();

			System.out.println("Click on Approve button");
			Thread.sleep(3000);
			
			int sizePagination1 = dropdown_Pagination.size();
			System.out.println(sizePagination1);

			dropdown_Pagination.get(sizePagination1 - 1).click();

			int sizeOfSpareRequestIdAfterApprove = list_SpareRequestId.size();
			System.out.println("sizeOfSpareRequestIdAfterApprove: "
					+ sizeOfSpareRequestIdAfterApprove);

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", list_SpareRequestId
							.get(sizeOfSpareRequestIdAfterApprove - 1));

			String lastSpareRequestIdInRMAfterApprove = list_SpareRequestId
					.get(sizeOfSpareRequestIdAfterApprove - 1).getText();
			System.out.println("lastSpareRequestIdInRMAfterApprove: "
					+ lastSpareRequestIdInRMAfterApprove);

			Assert.assertFalse(secondLastSpareRequestIDInSD
					.equalsIgnoreCase(lastSpareRequestIdInRMAfterApprove),
					"Spare Request is not get Remove.");
			System.out.println("Spare Request is get Remove.");

		}


	}

	public void checkRejectButtonOfSpareRequestInRM() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		spareApprovalPageInReportingManagerRole = new RM_SpareApprovalPage();

		driver.findElement(
				By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Inventory")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.cssSelector("a[href='/erprmwise/SpareApproval.do?action=View']"))
				.click();

		// Get Second Last Spare Request ID From SD
	//	String secondLastSpareRequestIDInSD = Demonstration.secondLastSpareRequestIDInSD;
		String thirdLastSpareRequestIDInSD = BasicFlowPage.thirdLastSpareRequestIDInSD;

		System.out.println("thirdLastSpareRequestIDInSD: "
				+ thirdLastSpareRequestIDInSD);

		int sizePagination = dropdown_Pagination.size();
		System.out.println(sizePagination);

		dropdown_Pagination.get(sizePagination - 1).click();

		int sizeOfSpareRequestId = list_SpareRequestId.size();
		System.out.println("sizeOfSpareRequestId: " + sizeOfSpareRequestId);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				list_SpareRequestId.get(sizeOfSpareRequestId - 1));

		String lastSpareRequestIdInRM = list_SpareRequestId.get(
				sizeOfSpareRequestId - 1).getText();
		System.out.println("lastSpareRequestIdInRM: " + lastSpareRequestIdInRM);

		if (thirdLastSpareRequestIDInSD
				.equalsIgnoreCase(lastSpareRequestIdInRM)) {
			
			
			
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					list_SpareRequestId.get(sizeOfSpareRequestId - 1));

			System.out.println("lastSpareRequestIdInRM: "
					+ lastSpareRequestIdInRM);

			/*String secondLastSpareRemarkInSpareTabInSd = Demonstration.secondLastSpareRemarkInSpareTab;
		//	String secondLastSpareRemarkInSpareTabInSd = Demo.secondLastSpareRemarkInSpareTab;
			System.out.println("secondLastSpareRemarkInSpareTabInSd: "
					+ secondLastSpareRemarkInSpareTabInSd);

			String lastSpareRemarkInRM = list_SpareRemark.get(
					sizeOfSpareRequestId - 1).getText();
			System.out.println("lastSpareRemarkInRM: " + lastSpareRemarkInRM);

			Assert.assertEquals(lastSpareRemarkInRM,
					secondLastSpareRemarkInSpareTabInSd, "Spare Remark is not same.");
			System.out.println("Spare Remark is same.");*/


			

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					list_RejectButton.get(sizeOfSpareRequestId - 1));

			list_RejectButton.get(sizeOfSpareRequestId - 1).click();
			System.out.println("Click on Reject button");
			Thread.sleep(1000);

			String reason = "Test";

			textbox_ReasonForRejectSpare.sendKeys(reason);

			button_RejectInReasonPopUp.click();

			String notificationInRM = notification.getText();
			System.out.println("notificationInRM: " + notificationInRM);

			Matcher m2 = Pattern.compile("\\d+")
					.matcher(lastSpareRequestIdInRM);
			m2.find();

			String textOfRejectID = m2.group(0);
			System.out.println(textOfRejectID);
			int rejectID = Integer.parseInt(textOfRejectID);
			System.out.println("rejectID: " + rejectID);

			String notificationAfterReject = ("Spare " + rejectID
					+ " Reject Reason is " + reason);
			System.out.println("notificationAfterReject: "
					+ notificationAfterReject);

			softAssert.assertEquals(notificationInRM, notificationAfterReject,
					"Notofication is not match.");

			Thread.sleep(2000);
			
			
			int sizePagination1 = dropdown_Pagination.size();
			System.out.println(sizePagination1);
			dropdown_Pagination.get(sizePagination1 - 1).click();

			int sizeOfSpareRequestIdAfterReject = list_SpareRequestId.size();
			System.out.println("sizeOfSpareRequestIdAfterReject: "
					+ sizeOfSpareRequestIdAfterReject);

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", list_SpareRequestId
							.get(sizeOfSpareRequestIdAfterReject - 1));

			String lastSpareRequestIdInRMAfterReject = list_SpareRequestId.get(
					sizeOfSpareRequestIdAfterReject - 1).getText();
			System.out.println("lastSpareRequestIdInRMAfterReject: "
					+ lastSpareRequestIdInRMAfterReject);

			softAssert.assertFalse(thirdLastSpareRequestIDInSD
					.equalsIgnoreCase(lastSpareRequestIdInRMAfterReject),
					"Spare Request is not get Remove.");
			System.out.println("Spare Request is get Remove.");
			softAssert.assertAll();

		}

	}
	
	public void checkSpareRemarkGivenBySDInRM()
	
	{
	
		
	//	String lastSpareRemarkInSpareTabInSd = Demonstration.lastSpareRemarkInSD;
		String lastSpareRemarkInSpareTabInSd = BasicFlowPage.lastSpareRemarkInSD;
		
		
		System.out.println("lastSpareRemarkInSpareTabInSd: "
				+ lastSpareRemarkInSpareTabInSd);
		
		

			// String incidentIDInSD = Demonstration.incidentID;
			String incidentIDInSD = BasicFlowPage.incidentID;

			System.out.println("incidentIDInSD: " + incidentIDInSD);
			textbox_IncidentID.clear();

			textbox_IncidentID.sendKeys(incidentIDInSD);

			button_IncidentIdGo.click();

			
			
		
			
	
			
			/*int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);

			dropdown_Pagination.get(sizePagination - 1).click();*/
			
			int sizeOfSpareRemark = list_SpareRemark.size();

			String lastSpareRemarkInRM = list_SpareRemark.get(
					sizeOfSpareRemark - 1).getText();
			System.out.println("lastSpareRemarkInRM: " + lastSpareRemarkInRM);

			Assert.assertEquals(lastSpareRemarkInRM,
					lastSpareRemarkInSpareTabInSd, "Spare Remark is not same.");
			System.out.println("Spare Remark is same.");

	}
	
public void updateSpareRemarkInRM()
	
	{
	
		
			//String lastSpareRemarkInSpareTabInSd = Demonstration.lastSpareRemarkInSD;
			String lastSpareRemarkInSpareTabInSd = BasicFlowPage.lastSpareRemarkInSD;
			
			
			System.out.println("lastSpareRemarkInSpareTabInSd: "
					+ lastSpareRemarkInSpareTabInSd);
			
			//String incidentIDInSD = Demonstration.incidentID;
			String incidentIDInSD = BasicFlowPage.incidentID;

			System.out.println("incidentIDInSD: " + incidentIDInSD);
			textbox_IncidentID.clear();

			textbox_IncidentID.sendKeys(incidentIDInSD);

			button_IncidentIdGo.click();

			
			/*int sizePagination = dropdown_Pagination.size();
			System.out.println(sizePagination);

			dropdown_Pagination.get(sizePagination - 1).click();*/
			
			int sizeOfSpareRemark = list_SpareRemark.size();
			

			
			list_EditSpareRemark.get(sizeOfSpareRemark - 1).click();
			

			for (String sdWindow : driver.getWindowHandles()) {
				driver.switchTo().window(sdWindow);
			}
			// Thread.sleep(1000);

			String remarkByRM="Done by RM" ;
			textbox_SpareRemarkInUpdateSpareRemarkPopup.clear();
			textbox_SpareRemarkInUpdateSpareRemarkPopup.sendKeys(remarkByRM);
			button_UpdateInUpdateSpareRemarkPopup.click();
  
			textbox_IncidentID.clear();
			textbox_IncidentID.sendKeys(incidentIDInSD);
			

			button_IncidentIdGo.click();
			
			
			
			lastSpareRemarkInRM = list_SpareRemark.get(
					sizeOfSpareRemark - 1).getText();
			System.out.println("lastSpareRemarkInRM: " + lastSpareRemarkInRM);

			Assert.assertEquals(lastSpareRemarkInRM,
					remarkByRM, "Spare Remark is not same.");
			System.out.println("Spare Remark is same.");

	
	}
	
	


	


// In Search-> Incident ID field, user should able to search Spare request
// by Incident ID
public void checkIncidentID() throws Exception 
{
	SoftAssert softAssert = new SoftAssert();
	
	String incidentId = "6219";
	// Enter Incident ID
	txtIncidentID.sendKeys(incidentId);
	
	//click on Go button 
	btnGoIncidentId.click();
	
	//Check Incident Id in table
	
	int size = lstIncidentId.size();
	System.out.println("size: " + size);

	for (int i = 0; i < size; i++) {
		
		scrollDown(lstIncidentId.get(i));

		Thread.sleep(200);
		highLight(lstIncidentId.get(i));

		String incidentIdInList = lstIncidentId.get(i).getText();
		System.out.println(incidentIdInList);
		
				
		softAssert.assertEquals(incidentIdInList, incidentId,
				"Incident Id Value is not same");
		     
	}

	softAssert.assertAll();

}

// If User enter Part code in Search-> part code field and click on Go button then in outcomes, part code should be display as per searched value
	public void checkPartCode() throws Exception 
	{
	
		SoftAssert softAssert = new SoftAssert();
		
		String partCode = "DH0015";
		// Enter Incident ID
		txtPartCode.sendKeys(partCode);
		
		//click on Go button 
		btnGoPartCode.click();
		
		scrollDown(lstPartCode.get(0));

		Thread.sleep(200);
		highLight(lstPartCode.get(0));

		String partCodeInTable = lstPartCode.get(0).getText();
		System.out.println(partCodeInTable);
		
		softAssert.assertEquals(partCodeInTable, partCode,
				"Incident Id Value is not same");

		
		
	}

// If User enter Part name in Search-> part name field and click on Go button then in outcomes, part name should be display as per searched value
public void checkPartName() throws Exception 
{
    SoftAssert softAssert = new SoftAssert();
	
	String partName = "IX Power Supply";
	// Enter Incident ID
	txtPartName.sendKeys(partName);
	
	//click on Go button 
	btnGoPartName.click();
	
	//Check Incident Id in table
	
	int size = lstPartName.size();
	System.out.println("size: " + size);

	for (int i = 0; i < size; i++) {
		
		scrollDown(lstPartName.get(i));

		Thread.sleep(200);
		highLight(lstPartName.get(i));

		String partNameInList = lstPartName.get(i).getText();
		System.out.println(partNameInList);
		
				
		softAssert.assertEquals(partNameInList, partName,
				"Incident Id Value is not same");
		     
	}

	softAssert.assertAll();
	
	
}
//If User search by from and to date then, in all outcomes DateOfRequest should display same and between the from and To date values

public void checkFromAndToDateAccordingSelectedDateRange() throws Exception 
{
	SoftAssert softAssert = new SoftAssert();
	// Get the Today system date
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();

	String todayDate = dateFormat.format(date);
	System.out.println("Today Date: " + todayDate);

	Calendar calendar = Calendar.getInstance();
	// Move calendar to yesterday
	calendar.add(Calendar.DATE, -1);
	// Get current date of calendar which point to the yesterday now
	Date lastDay = calendar.getTime();
	String lastDayValue = dateFormat.format(lastDay).toString();
	// print Date
	System.out.println("last Day Value: " + lastDayValue);
	Date yesterdayDate = (Date) dateFormat.parse(lastDayValue);
	System.out.println("yesterday date: " + yesterdayDate);

	int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	System.out.println(dayOfMonth);
	String yesterdayDateValue = Integer.toString(dayOfMonth);
	// String yesterdayDate = dateFormat.format(yesterday).toString();
	System.out.println("Yesterday Date Value: " + yesterdayDateValue);

	Calendar calendar1 = Calendar.getInstance();
	// Move calendar to 7 days before
	calendar1.add(Calendar.DATE, -7);
	// Get current date of calendar which point to the yesterday now
	Date lastSevenDays = calendar1.getTime();
	String lastSevenDaysDay = dateFormat.format(lastSevenDays).toString();
	// print Date
	System.out.println("last Seven Days Date: " + lastSevenDaysDay);
	Date lastSevenDate = (Date) dateFormat.parse(lastSevenDaysDay);
	System.out.println("lastSevenDayDate: " + lastSevenDate);

	int lastSevenDaysInMonth = calendar1.get(Calendar.DAY_OF_MONTH);
	System.out.println(lastSevenDaysInMonth);
	String lastSevenDaysDate = Integer.toString(lastSevenDaysInMonth);

	lblFromCalendar.click();

	// select Date in Calendar

	for (WebElement day : dtpFromCalendar) {

		String dayInCalender = day.getText();

		if (dayInCalender.equalsIgnoreCase(lastSevenDaysDate)) {

			Thread.sleep(1000);
			day.click();
			String getDateValue = day.getText();
			System.out.println("Select the date:-" + getDateValue);

			break;
		}

	}
	Thread.sleep(1000);

	lblToCalendar.click();

	for (WebElement day : dtpToCalendar) {

		String dayInCalender = day.getText();

		if (dayInCalender.equalsIgnoreCase(yesterdayDateValue)) {

			Thread.sleep(1000);
			day.click();
			String getDateValue = day.getText();
			System.out.println("Select the date:-" + getDateValue);

			break;
		}

	}

	// click on Go button
	btnGoDate.click();

	int size = lstDateOfRequest.size();
	System.out.println("size: " + size);

	for (int i = 0; i < size; i++) {

		scrollDown(lstDateOfRequest.get(i));

		Thread.sleep(200);
		highLight(lstDateOfRequest.get(i));
		String DateOfRequest = lstDateOfRequest.get(i).getText();
		System.out.println("DateOfRequest: " + DateOfRequest);

		Date dateInList = (Date) dateFormat.parse(DateOfRequest);
		System.out.println("lastThirtyDayDate: " + lastSevenDate);

		boolean dateIsPresent = true ;
		if (dateInList.compareTo(lastSevenDate) >= 0
				&& dateInList.compareTo(yesterdayDate) <= 0) {
			dateIsPresent = true;

		} else {
			dateIsPresent = false;
		}
		// Verify Date
		softAssert.assertTrue(dateIsPresent,
				"Log Date And Time is not between Seven Days.");

	}

	softAssert.assertAll();

}

//User able to update/add  Spare remark by clicking on Update symbol in Edit spare remark column
public void checkUpdateSpareRemark() throws Exception
{
	scrollDown(lstEditSpareRemark.get(1));

	highLight(lstEngineerStock.get(1));
	
	//click on Edit Spare Remark for update 
	lstEditSpareRemark.get(1).click();
	
	txtSpareRemark.clear();
	
	String spareRemark = "Spare is update";
	//Add Remark 
	txtSpareRemark.sendKeys(spareRemark);
	
	//click on update button
	btnUpdate.click();
	
	Thread.sleep(200);
	scrollDown(lstSpareRemark.get(1));

	Thread.sleep(200);
	highLight(lstSpareRemark.get(1));
	
    String updateSpareRemark = lstSpareRemark.get(1).getText();
    System.out.println("updateSpareRemark: "+updateSpareRemark);
    
    assertEquals(updateSpareRemark, spareRemark ,"Spare is not update");
	
	
}
//after click on view button then View Engineer Stock should display 
//If user click on View button of same spare request ID, then view engineer stock page should display with all spare entries present in engineer stock with same part name and part code.
public void checkViewFunctionality() throws Exception
{
	SoftAssert softAssert = new SoftAssert();
	String firstWindow = driver.getWindowHandle();
	scrollDown(lstEngineerStock.get(1));
	Thread.sleep(200);
	highLight(lstEngineerStock.get(1));
	
	//click on view button
	lstEngineerStock.get(1).click();
	
	Thread.sleep(2000);
	for (String windowName : driver.getWindowHandles()) 
	{
		driver.switchTo().window(windowName);

	}

	String windowName = driver.getTitle();
	System.out.println("windowName: "+windowName);
	
	softAssert.assertEquals(windowName, "Engineer Stock" ,"window name is different");
	
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	//click on Back button
	driver.findElement(By.linkText("Back")).click();

	
	Thread.sleep(2000);
	String firstWindowName = driver.getTitle();
	System.out.println("firstWindowName: "+firstWindowName);
	
	softAssert.assertEquals(firstWindowName, "Welcome To Uno Point" ,"window name is different");
	softAssert.assertAll();
	driver.switchTo().window(firstWindow);
	
}
//If RM Click on Approve button of spare request then, spare request entry should get remove from Dash board 
public void checkApproveButtonFunctionality() throws Exception
{
	SoftAssert softAssert = new SoftAssert();
	//click on Approve button
	scrollDown(lstSpareRequestID.get(1));
	Thread.sleep(200);
	highLight(lstSpareRequestID.get(1));
	
	String incidentId = lstSpareRequestID.get(1).getText();
	System.out.println("spareRequestId: "+incidentId);
	
	Thread.sleep(500);
	//click on view button
	lstApproved.get(1).click();
	
	Thread.sleep(500);
	//check spare request entry should get remove from Dash board 
	
	int size = lstSpareRequestID.size();
	boolean incidentIdIsPresent = true;
	for(int i = 0; i<size; i++)
	{
		
		String incidentIdAfterApproved = lstSpareRequestID.get(i).getText();
		System.out.println("incident Id AfterApproved: "+incidentIdAfterApproved);
		
		
		if(incidentIdAfterApproved.contains(incidentId))
		{
			System.out.println("==========");
			incidentIdIsPresent = false;
			break;
			
		}
		
		
	}
	softAssert.assertTrue(incidentIdIsPresent);
	
	
	softAssert.assertAll();
	
}
//If RM Click on Reject button of spare request then, Reason For Reject Spare pop up should display 
public void checkRejectButtonFunctionality() throws Exception
{
	
	SoftAssert softAssert = new SoftAssert();
	//click on Approve button
	scrollDown(lstSpareRequestID.get(1));
	Thread.sleep(200);
	highLight(lstSpareRequestID.get(1));
	
	String incidentId = lstSpareRequestID.get(1).getText();
	System.out.println("spareRequestId: "+incidentId);
	
	Matcher m = Pattern.compile("\\d+").matcher(incidentId);
	m.find();
	String textOfFirstID = m.group(0);
	System.out.println(textOfFirstID);
	int firstID = Integer.parseInt(textOfFirstID);
	System.out.println(firstID);

	//Spare 180 Reject Reason is spare is not available
	
	Thread.sleep(500);
	//click on view button
	lstReject.get(1).click();
	Thread.sleep(500);
	
	String rejectReson = "Spare is not available";
	txtRejectReason.sendKeys(rejectReson);
	
	//click on reject button
	btnReject.click();	
	
	//notification message 
	String messageNotification = lblNotification.getText();
	System.out.println("messageNotification: "+messageNotification);
	
	//check the notifications
	softAssert.assertEquals(messageNotification, "Spare "+firstID+" Reject Reason is "+rejectReson, rejectReson);
	
	//check spare request entry should get remove from Dash board 
		
	int size = lstSpareRequestID.size();
	boolean incidentIdIsPresent = true;
	for(int i = 0; i<size; i++)
	{
		
		String incidentIdAfterApproved = lstSpareRequestID.get(i).getText();
		System.out.println("incident Id AfterApproved: "+incidentIdAfterApproved);
		
		
		if(incidentIdAfterApproved.contains(incidentId))
		{
			System.out.println("==========");
			incidentIdIsPresent = false;
			break;
			
		}
		
		
	}
	softAssert.assertTrue(incidentIdIsPresent);
	
	
	softAssert.assertAll();
	
}

//As per RM approve or Reject spare request then it should display in SD login-> ticket ID-> spare tab-> respective spare request ->status as Approve or Reject 
public void checkStatusInSD() throws Exception
{
	
	//click on Approve button
	scrollDown(lstSpareRequestID.get(1));
	Thread.sleep(200);
	highLight(lstSpareRequestID.get(1));
	
    spareRequestId = lstSpareRequestID.get(1).getText();
	System.out.println("spareRequestId: "+spareRequestId);
	
	ticketId = lstTicketId.get(1).getText();
	System.out.println("ticketId: "+ticketId);
	
	Thread.sleep(500);
	//click on view button
	lstApproved.get(1).click();
	
	Thread.sleep(1000);
	scrollDown(tabHomeRM);
	tabHomeRM.click();
	tabRM.click();
	
	Thread.sleep(500);
	tabLogOut.click();
	

	rm_LoginPage = new RM_LoginPage();
	sd__HomePage = rm_LoginPage.sdLogin(
			properties.getProperty("loginIdForSd"),
			properties.getProperty("password"));
	sd_TicketPage=sd__HomePage.ticketTab();
	Thread.sleep(1000);
	Sd_ViewTicketPage =  sd_TicketPage.viewTicketTab();
	Sd_ViewTicketPage.checkStatusInSD();
	
	Thread.sleep(1000);
	
	Thread.sleep(500);
	scrollDown(tabHomeSD);
	tabHomeSD.click();
	
	tabSd.click();
	
	Thread.sleep(500);
	tabLogOut.click();
	
	rm_LoginPage = new RM_LoginPage();
	rm_HomePage = rm_LoginPage.Login(
			properties.getProperty("loginIdForRM"),
			properties.getProperty("password"));
		
}

//As per RM update remark for spare request and click on approve or Reject spare request then same remark should display in SD login-> ticket ID-> spare tab-> respective spare request entry-> Spare remark field 
public void checkRemarkInSD() throws Exception {

	// click on Approve button
	scrollDown(lstSpareRequestID.get(1));
	Thread.sleep(200);
	highLight(lstSpareRequestID.get(1));

	spareRequestId = lstSpareRequestID.get(1).getText();
	System.out.println("spareRequestId: " + spareRequestId);

	ticketId = lstTicketId.get(1).getText();
	System.out.println("ticketId: " + ticketId);

	// click on Edit Spare Remark for update
	lstEditSpareRemark.get(1).click();

	txtSpareRemark.clear();

	spareRemark = "Spare is update";
	// Add Remark
	txtSpareRemark.sendKeys(spareRemark);

	// click on update button
	btnUpdate.click();

	Thread.sleep(500);
	// click on view button
	lstApproved.get(1).click();

	Thread.sleep(1000);
	scrollDown(tabHomeRM);
	tabHomeRM.click();
	tabRM.click();

	Thread.sleep(500);
	tabLogOut.click();

	rm_LoginPage = new RM_LoginPage();
	sd__HomePage = rm_LoginPage.sdLogin(
			properties.getProperty("loginIdForSd"),
			properties.getProperty("password"));
	sd_TicketPage = sd__HomePage.ticketTab();
	Thread.sleep(1000);
	Sd_ViewTicketPage = sd_TicketPage.viewTicketTab();
	Sd_ViewTicketPage.checkRemarkInSD();

	Thread.sleep(1000);

	Thread.sleep(500);
	scrollDown(tabHomeSD);
	tabHomeSD.click();

	tabSd.click();

	Thread.sleep(500);
	tabLogOut.click();

	rm_LoginPage = new RM_LoginPage();
	rm_HomePage = rm_LoginPage.Login(
			properties.getProperty("loginIdForRM"),
			properties.getProperty("password"));

}
// Count Of Pagination
public void countOfPagination() throws Exception 
{
	SoftAssert softAssert = new SoftAssert();
	int size = ddlPagination.size();
	System.out.println("Pagination Pages: "+size);

	
	int count=20*(size-1);
	System.out.println(count);
	ddlPagination.get(size-1).click();
	Thread.sleep(1000);
	int lastPageCount = lstRowInTable.size();
	System.out.println("last Page Count: "+lastPageCount);
	int totalCountTicket = count + lastPageCount;
	System.out.println("Total Count: "+totalCountTicket);
	
	String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
	System.out.println(textOfTotalCount);
	String totalCount  = textOfTotalCount.split("Total Count: ")[1];
	System.out.println("totalCount:"+totalCount);
	
	int actualTotalCount = Integer.parseInt(totalCount);
	System.out.println("number of Total Ticket: "+actualTotalCount);
	
	softAssert.assertEquals(totalCountTicket,actualTotalCount,"Count is not match");
	softAssert.assertAll();

}

//If user click on leftmost arrow then control should transfer on first page in  page transact inventory page
//If user click on left arrow then control should transfer on Previous page of current page showing  in transact inventory page
//If user click on rightmost arrow then control should transfer on Last page in transact inventory page
//If user click on right arrow then control should transfer on next page of current page showing in transact inventory page

public void displayAsPerArrowsOfPagination() throws Exception 
{
	SoftAssert softAssert = new SoftAssert();
	// Click on leftmost arrow
	int size = ddlPagination.size();
	System.out.println("size" + size);

	btnLeftmostArrowOfPagination.click();
	String leftMostPage = pageSelectedInPagination.getAttribute("value");
	System.out.println("leftMostPage " + leftMostPage);
	softAssert.assertEquals("1", leftMostPage, "Page not Same");

	// Click on Rightmost arrow
	// Thread.sleep(500);
	btnRightmostArrowOfPagination.click();
	String page = pageSelectedInPagination.getAttribute("value");
	System.out.println("rightMostPage " + page);
	int rightMostPage = Integer.parseInt(page);
	softAssert.assertEquals(size, rightMostPage, "Page not Same");

	// Click on RightArrow
	// Thread.sleep(500);
	btnLeftmostArrowOfPagination.click();
	String firstPageValue = pageSelectedInPagination.getAttribute("value");
	int firstPage = Integer.parseInt(firstPageValue);
	System.out.println("firstPage" + firstPage);

	btnRightArrowOfPagination.click();
	String nextPageValue = pageSelectedInPagination.getAttribute("value");
	int nextPage = Integer.parseInt(nextPageValue);
	System.out.println("nextPage" + nextPage);

	int rightArrowPage = firstPage + 1;
	softAssert.assertEquals(nextPage, rightArrowPage);

	// Click on LeftArrow
	// Thread.sleep(500);
	String lastPageValue = pageSelectedInPagination.getAttribute("value");
	int lastPage = Integer.parseInt(lastPageValue);
	System.out.println("lastPage" + lastPage);

	btnLeftArrowOfPagination.click();
	String previousPageValue = pageSelectedInPagination
			.getAttribute("value");
	int previousPage = Integer.parseInt(previousPageValue);
	System.out.println("previousPage" + previousPage);

	int leftArrowPage = lastPage - 1;
	softAssert.assertEquals(previousPage, leftArrowPage);
	softAssert.assertAll();

}

//If User click on Download Excel button then Excel should get download with number of entries showing as per Total count 
	public void verifyDownloadExcel() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		
		// click on download button
		btnDownload.click();

		Robot robot = new Robot();
		Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(700);
		robot.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(20000);
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		System.out.println("fileName: "+fileName);
		softAssert.assertTrue(fileName.contains("SpareApprovalExcelReport"),
				"Downloaded file name is not matching with expected file name");
		
		FileInputStream stream = new FileInputStream(downloadPath+"\\"+fileName);
		File file = new File(downloadPath+"\\"+fileName);
		
		Workbook workbook = WorkbookFactory.create(stream);
		
		Sheet s = workbook.getSheet("SpareApprovalExcelReport");
		
		int rowcount = s.getLastRowNum();
		System.out.println(rowcount);
		int cellcount = s.getRow(0).getLastCellNum();
		System.out.println(cellcount);
		
		file.delete();
		
		Thread.sleep(500);
		softAssert.assertAll();
		
		
	}
	
	private File getLatestFilefromDir(String dirPath) 
	{
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}


}
	


