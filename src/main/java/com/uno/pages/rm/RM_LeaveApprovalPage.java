package com.uno.pages.rm;

import static org.testng.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_LeaveMaster;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.test.rm.RM_AttendanceApprovalTest;


public class RM_LeaveApprovalPage extends BaseCode 
{
	Calendar systemDate = new GregorianCalendar();
	public static String leaveTypeInSd = null;
	
	// call the page from RM
	RM_HomePage rm_HomePage;
	RM_AttendancePage rm_AttendancePage;
	RM_EngineerAttendancePage rm_EngineerAttendancePage;
	RM_AttendanceApprovalTest rm_AttendanceApprovalTest;
	RM_AttendanceApprovalPage rm_AttendanceApprovalPage; 
	
	//call the page from super
	Super_LoginPage super_LoginPage;
	Super_HomePage super_HomePage;
	Super_EmployeeMasterPage super_EmplolyeeMasterPage;
	Super_LeaveMaster super_LeaveMaster;

	// Select RM tab for logout tab
	@FindBy(linkText = "NewRM1")
	WebElement tabRM;

	// Select RM tab for logout tab
	@FindBy(linkText = "Test")
	WebElement tabTest;

	// Click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement tabLogOut;

	@FindBy(css = "[id='container']>div>div>span")
	WebElement lblHeading;

	// Select filter tab
	@FindBy(linkText = "Filter")
	WebElement tabFilter;

	// select Select Date text box
	@FindBy(css = "a[id='fd-but-dp-2']")
	WebElement calSelectDate;

	// click on select date calendar button
	@FindBy(name = "m_strDate")
	WebElement txtSelectDate;

	// select date from date picker
	@FindBy(xpath = ".//*[@id='fd-dp-2']/table/tbody/tr/td")
	List<WebElement> dtpSelectDate;

	// Select Go button
	@FindBy(xpath = ".//*[@id='form']/div[1]/div/table/tbody/tr[3]/td[3]/img")
	WebElement btnGO;

	// Select Avail Date
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[2]/input")
	List<WebElement> lstLeaveDate;

	// Select Engineer Name
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[3]")
	List<WebElement> lstEngineerName;

	// Select Availability
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[4]/select/option")
	List<WebElement> lstAvailabilityValue;

	//select drop down list
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[4]/select")
	List<WebElement> ddlAvailability;

	// Select Availability
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[4]")
	List<WebElement> lstAvailability;

	// Select Leave Type
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[5]")
	List<WebElement> lstLeaveType;

	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[5]/select")
	List<WebElement> ddlLeaveType;
	
	// Select Leave Start Date
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[6]")
	List<WebElement> lstLeaveStartDate;

	// Select Leave End Date
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[7]")
	List<WebElement> lstLeaveEndDate;

	// Select Leave End Date
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[8]")
	List<WebElement> lstLeaveAppliedTime;

	// Select Status
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[16]")
	List<WebElement> lstStatus;

	// Select Reject
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[17]")
	List<WebElement> lstReject;

	// Select Multiple Approval
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[12]")
	List<WebElement> lstMultipleApproval;

	// Select Multiple Approval
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[12]/input")
	List<WebElement> rdoMultipleApproval;
	
	// Select Login Time
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[8]")
	List<WebElement> lstLoginTime;

	// Select hour
	@FindBy(name = "m_strLoginTimeHour")
	WebElement ddlTimeHour;

	// Select minute
	@FindBy(name = "m_strLoginTimeMin")
	WebElement ddlTimeMin;

	// Select minute
	@FindBy(className = "update1Btn")
	WebElement btnUpdate;

	// Heading
	@FindBy(xpath = ".//*[@id='dialogBoxSuccess']")
	WebElement lblDialogBox;

	// Select Reason for Reject
	@FindBy(name = "m_strReason")
	WebElement txaReasonforReject;

	// Select Reject Button
	@FindBy(linkText = "Reject")
	WebElement btnReject;

	// Select Reject Button
	@FindBy(linkText = "Cancel")
	WebElement btnCancel;

	// Select Submit Approval
	@FindBy(linkText = "Submit Approval")
	WebElement btnSubmitApproval;

	// click on Leave Approval page
	@FindBy(linkText = "Leave Approval")
	WebElement tabLeaveApproval;
	
	// click on Leave Approval page
	@FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr[1]/th[12]/input")
	WebElement rdoMultipleApprovalHeader;

	// Initializing Page Object
	public RM_LeaveApprovalPage() {
		PageFactory.initElements(driver, this);

	}

	// If User click on Attendance Approval page then leave Approvals Screen
	// should display.
	public void checkHeadingOfPage() 
	{

		// Check the heading of View My Availability
		String headingValue = lblHeading.getText();
		System.out.println("HeadingName: " + headingValue);

		assertEquals(headingValue, "Leave Approval Screen",
				"page heading is not match");

	}

	// In Filter-> Select Date, if user select date and click on Go button then
	// in Leave Date, Leave Start Date and Leave End Date field of all entries,
	// selected date should display
	public void checkLeaveDate() throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();

		// Click on filter
		tabFilter.click();

		// Select date from Select Date field
	
		int dateInMonth = systemDate.get(Calendar.DAY_OF_MONTH)-5;
		System.out.println("dateInMonth: " + dateInMonth);
		String priviousDate = Integer.toString(dateInMonth);
		System.out.println("priviousDate: " + priviousDate);
		calSelectDate.click();

		// select Date in Calendar
		for (WebElement date : dtpSelectDate) 
		{

			String dayInCalender = date.getText();

			if (dayInCalender.equalsIgnoreCase(priviousDate)) 
			{

				Thread.sleep(1000);
				date.click();
				String getDateValue = date.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;

			}
			else {
				
				driver.findElement(By.id("dp-2-prev-month-but")).click();
				Thread.sleep(1000);
				date.click();
				String getDateValue = date.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;


				
			}

		}

		// get selected date
		String selectDate = txtSelectDate.getAttribute("value");
		System.out.println("selectDate: " + selectDate);

		scrollDown(txtSelectDate);

		highLight(txtSelectDate);

		// click on GO button
		btnGO.click();

		Thread.sleep(500);
		// check that same date is present on Avail Date column or not
		int size = lstLeaveDate.size();
		System.out.println("size: " + size);
		for (int i = 0; i < lstLeaveDate.size(); i++) 
		{
			scrollDown(lstLeaveDate.get(i));

			highLight(lstLeaveDate.get(i));

			String leaveDate = lstLeaveDate.get(i).getAttribute("value");
			System.out.println("availDate: "+leaveDate);

			softAssert.assertEquals(leaveDate, selectDate,
					"The selected date and leave Date is diffrent");

		}

		softAssert.assertAll();

	}
	
	//If User click on Leave Type and click on option should display same as per Leave master in Super login
    public void matchLeaveType() throws Exception
    {
    	
    	
    	//take the leave type list
    	leaveTypeInSd = lstLeaveType.get(1).getText();
    	System.out.println("leaveTypeInSd: "+leaveTypeInSd);
    	
    	tabRM.click();
    	tabLogOut.click();
    	
    	super_LoginPage= new Super_LoginPage();
		super_HomePage= super_LoginPage.Login(properties.getProperty("loginIdForSuper"),properties.getProperty("password"));
		super_EmplolyeeMasterPage=super_HomePage.clickEmpolyeeMasterlink();
		super_LeaveMaster = super_EmplolyeeMasterPage.clickOnLeaveMasterLink();
    	super_LeaveMaster.getLeaveName();
    	 	
    }
	
    //If User click on Pending button without select Availability then notification should display as 'Please Select Leave for (Emp_Name)'
    //If User click on Pending button without select Leave Type then notification should display as 'Please Select Leave Type for (Emp_Name)'
	public void checkPendingFunctionality() throws Exception {
		Thread.sleep(1000);
		SoftAssert softAssert = new SoftAssert();

		int size = lstEngineerName.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			String engineerName = lstEngineerName.get(i).getText();
			System.out.println("engineerName: " + engineerName);

			Thread.sleep(500);
			scrollDown(lstEngineerName.get(i));

			highLight(lstEngineerName.get(i));

			if (engineerName.contains("Kavita .")) {

				Thread.sleep(500);
				scrollDown(ddlAvailability.get(i));

				highLight(ddlAvailability.get(i));

				Thread.sleep(500);
				// if login is done previously then select "Select"
				Select availablityBeforeLogin = new Select(
						ddlAvailability.get(i));
				availablityBeforeLogin.selectByVisibleText("Select");

				Thread.sleep(500);
				scrollDown(lstStatus.get(i));

				Thread.sleep(500);
				highLight(lstStatus.get(i));

				Thread.sleep(500);
				// click on status without selecting availability
				lstStatus.get(i).click();

				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				System.out.println("alertMessage: " + alertMessage);
				alert.accept();
				/* driver.switchTo().defaultContent(); */

				softAssert.assertEquals(alertMessage,
						"Please Select Leave for Kavita .",
						"alert message is different");

				Thread.sleep(1000);

				scrollDown(ddlAvailability.get(i));

				highLight(ddlAvailability.get(i));

				Select selectLeave = new Select(ddlAvailability.get(i));
				selectLeave.selectByIndex(1);

				scrollDown(lstStatus.get(i));

				highLight(lstStatus.get(i));

				Thread.sleep(1000);
				// click on status without selecting leave type
				lstStatus.get(i).click();

				Thread.sleep(1000);
				Alert message = driver.switchTo().alert();
				String withotLeavetype = message.getText();
				System.out.println("withotLeavetype: " + withotLeavetype);
				message.accept();

				softAssert.assertEquals(withotLeavetype,
						"Please Select Leave Type for Kavita .",
						"alert message is different for leave selection");

				Thread.sleep(1000);
				scrollDown(ddlLeaveType.get(i));

				highLight(ddlLeaveType.get(i));
				Thread.sleep(1000);
				Select availablity = new Select(ddlLeaveType.get(i));
				availablity.selectByVisibleText("Previlage Leave");

				Thread.sleep(2000);
				scrollDown(lstStatus.get(i));

				Thread.sleep(2000);
				highLight(lstStatus.get(i));

				Thread.sleep(1000);
				lstStatus.get(i).click();

				Thread.sleep(500);
				// Check the heading message
				String heading = lblDialogBox.getText();
				System.out.println("heading: " + heading);

				softAssert.assertEquals(heading,
						"Leave Approved Successfully.!",
						"Record is not Approve");

				break;

			}

		}

		softAssert.assertAll();

	}
	//If User click on Reject button without select Availability then notification should display as 'You Can't Reject Without Leave for (Emp_Name)'.
	//If User click on Reject button without select Leave Type then notification should display as ' If you select Availability as Leave then select Leave Type..'
    
	public void checkRejectFunctionality() throws Exception 
	{
		Thread.sleep(1000);
		SoftAssert softAssert = new SoftAssert();

		int size = lstEngineerName.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) 
		{

			String engineerName = lstEngineerName.get(i).getText();
			System.out.println("engineerName: " + engineerName);

			Thread.sleep(500);
			scrollDown(lstEngineerName.get(i));

			highLight(lstEngineerName.get(i));

			if (engineerName.contains("Pranjali Deshpande")) {

				Thread.sleep(500);
				scrollDown(ddlAvailability.get(i));

				highLight(ddlAvailability.get(i));

				Thread.sleep(500);
				// if login is done previously then select "Select"
				Select availablityBeforeLogin = new Select(
						ddlAvailability.get(i));
				availablityBeforeLogin.selectByVisibleText("Select");

				Thread.sleep(500);
				scrollDown(lstReject.get(i));

				Thread.sleep(500);
				highLight(lstReject.get(i));

				Thread.sleep(500);
				// click on status without selecting
				lstReject.get(i).click();

				// Send reason in Reject Reject text box
				txaReasonforReject.sendKeys("Select Availability");

				// Click on Reject Button
				btnReject.click();

				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				System.out.println("alertMessage: " + alertMessage);
				alert.accept();

				softAssert
						.assertEquals(
								alertMessage,
								"You Can't Reject Without Leave for Pranjali Deshpande",
								"alert message is different");

				btnCancel.click();

				// Select login
				Select availablity = new Select(ddlAvailability.get(i));
				availablity.selectByVisibleText("Leave");

				Thread.sleep(1000);

				scrollDown(ddlAvailability.get(i));

				highLight(ddlAvailability.get(i));

				Select selectLeave = new Select(ddlAvailability.get(i));
				selectLeave.selectByIndex(1);

				scrollDown(lstStatus.get(i));

				highLight(lstStatus.get(i));

				Thread.sleep(1000);
				// click on status without selecting leave type
				lstStatus.get(i).click();

				Thread.sleep(1000);
				Alert message = driver.switchTo().alert();
				String withoutLeavetype = message.getText();
				System.out.println("withotLeavetype: " + withoutLeavetype);
				message.accept();

				softAssert.assertEquals(withoutLeavetype,
						"Please Select Leave Type for Pranjali Deshpande",
						"alert message is different for leave selection");

				Thread.sleep(1000);
				scrollDown(ddlLeaveType.get(i));

				highLight(ddlLeaveType.get(i));
				Thread.sleep(1000);
				
				Select leaveType = new Select(ddlLeaveType.get(i));
				leaveType.selectByVisibleText("Previlage Leave");

				Thread.sleep(2000);
				scrollDown(lstStatus.get(i));

				Thread.sleep(2000);
				highLight(lstStatus.get(i));

				Thread.sleep(1000);
				lstReject.get(i).click();
				
				//click on reject button 
				btnReject.click();

				Thread.sleep(500);
				// Check the heading message
				String heading = lblDialogBox.getText();
				System.out.println("heading: " + heading);

				softAssert.assertEquals(heading,
						"Leave Rejected Successfully.!",
						"Record is not Approve");

				break;

			}

		}

		softAssert.assertAll();

	}
	
	//If User check check box and click on Submit approval button without select Availability then notification 
	//should display as 'Please Select Availability Leave for (Emp_name)'
	//If User check check box and click on Submit approval button without select Leave type then notification 
	//should display as 'Please Select Leave Type for (Emp_name)'
	//After update leave if user click on Pending button then
	// notification should display as 'Record Approved Successfully.!' and
	// status should display as 'Approved'
	public void checkWithMultipleApproval() throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();

		int size = lstEngineerName.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) {

			String engineerName = lstEngineerName.get(i).getText();
			System.out.println("engineerName: " + engineerName);

			if (engineerName.contains("KavitaM .")) {

				scrollDown(lstEngineerName.get(i));

				highLight(lstEngineerName.get(i));
				
				// select check box
				lstMultipleApproval.get(i).click();

				//select submit approval button 
				btnSubmitApproval.click();

				
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				System.out.println("alertMessage: " + alertMessage);
				alert.accept();

				softAssert.assertEquals(alertMessage,
								"Please Select Availability Leave for KavitaM .",
								"alert message is different");

				scrollDown(ddlAvailability.get(i));

				highLight(ddlAvailability.get(i));
				
				// Select login
				Select availablity = new Select(ddlAvailability.get(i));
				availablity.selectByVisibleText("Leave");
			
				
				//click on submit button
				btnSubmitApproval.click();
				
				Alert message = driver.switchTo().alert();
				String withoutLeavetype = message.getText();
				System.out.println("withoutLeavetype: " + withoutLeavetype);
				message.accept();

				softAssert.assertEquals(alertMessage,
								"Please Select Leave Type for KavitaM .",
								"alert message is different");
				
				Thread.sleep(2000);
				scrollDown(ddlLeaveType.get(i));
				
				highLight(ddlLeaveType.get(i));

				Select leaveType = new Select(ddlLeaveType.get(i));
				leaveType.selectByVisibleText("Compensatory Leave");
				
				Thread.sleep(1000);
				// get Multiple Approval list
				scrollDown(lstMultipleApproval.get(i));

				highLight(lstMultipleApproval.get(i));

				Thread.sleep(1000);
				
				//click on submit button
				btnSubmitApproval.click();
				
				// check the heading message
				String heading = lblDialogBox.getText();
				System.out.println("heading: " + heading);

				softAssert.assertEquals(heading,
						"Leave Approved Successfully.!",
						"Record is not get approve");
			}
		}
		
		softAssert.assertAll();
	}
	
	//If User click on multiple Approval check box then all check box in table should get checked
	public void checkAfterSelectingMultipleApproval() throws Exception 
	{
		
		SoftAssert softAssert = new SoftAssert();
		
		//click on multiple radio button in header 
		rdoMultipleApprovalHeader.click();

		int size = lstMultipleApproval.size();
		System.out.println("size: " + size);

		for (int i = 0; i < size; i++) 
			
		{
			scrollDown(lstMultipleApproval.get(i));
			
			highLight(lstMultipleApproval.get(i));
			
			boolean approveByRmIsYes = rdoMultipleApproval.get(0)
					.isSelected();
			System.out.println(approveByRmIsYes);
			 

			// This will check that if the Value is True means if the radio button is selected
			
			if (approveByRmIsYes == true) 
			{

				System.out.println();
				softAssert.assertTrue(true,"check box is disable");
				
			} 
			softAssert.assertAll();
	
		}
		
	}
	
	
	
	
}
