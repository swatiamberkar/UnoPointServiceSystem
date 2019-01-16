package com.uno.pages.sd;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.uno.baseClass.BaseCode;
import com.uno.test.sd.SD_ViewTicket2Test;

public class SD_ViewTicket2Page extends BaseCode {
	public static int state = 1;
	public static int status = 1;
	public static int ticketType = 1;
	public static int ticketStatus = 1;
	public static int customer = 1;
	
	
	SD_ViewTicket2Test sd_ViewTicket2Test;
	SD_ViewTicket2Page sd_ViewTicket2Page;

	// Tab Search Ticket Open
	@FindBy(css = "#open")
	WebElement tabSearchTicketOpen;
	
	// Text box Id
	@FindBy(css = "input[name='m_strSearchIncId']")
	WebElement txtId;
	
	// button Go Of Id
	@FindBy(css = "img[onclick='submitValuesIncidentID()']")
	WebElement btnGoOfId;
	
	// Text box Asset Id
	@FindBy(css = "input[name='m_strSearchAssetId']")
	WebElement txtAssetId;
	
	// button Go Of Asset Id
	@FindBy(css = "img[onclick='submitValuesAssetID()']")
	WebElement btnGoOfAssetId;
	
	// Text box Ticket ID
	@FindBy(css = "input[name='m_strSearchTicketId']")
	WebElement txtTicketID;
	
	// button Go Of Ticket ID
	@FindBy(css = "img[onclick='submitValuesTicketID()']")
	WebElement btnGoOfTicketID;
	
	// Drop down Filter By State
	@FindBy(css = "select[name='m_strStateFilter']")
	WebElement ddlFilterByState;
	
	// Drop down Filter By Status
	@FindBy(css = "select[name='m_strStatusFilter']")
	WebElement ddlFilterByStatus;
	
	// Drop down Filter By Ticket Type
	@FindBy(css = "select[name='m_strIncidentType']")
	WebElement ddlFilterByTicketType;
	
	// Drop down Ticket Status
	@FindBy(css = "select[name='m_strViewCriteria']")
	WebElement ddlTicketStatus;
	
	// Drop down Filter By Customer
	@FindBy(css = "select[name='m_strCustomerName']")
	WebElement ddlFilterByCustomer;
	
	// List Of Id in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']")
	List<WebElement> lstRow;
	
	// List Of Id in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(1)>div>a")
	List<WebElement> lstId;
	
	// List Of Ticket ID in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(2)")
	List<WebElement> lstTicketID;
	
	// List Of Asset ID in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(3)")
	List<WebElement> lstAssetID;
	
	// List Of Customer in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(4)")
	List<WebElement> lstCustomer;
	
	// List Of Our SLA in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(5)")
	List<WebElement> lstOurSLA;
	
	// List Of STATE in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(6)")
	List<WebElement> lstSTATE;
	
	// List Of Ticket Date Time in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(7)")
	List<WebElement> lstTicketDateTime;
	
	// List Of City in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(8)")
	List<WebElement> lstCity;
	
	// List Of POP in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(9)")
	List<WebElement> lstPOP;
	
	// List Of Manager Reply in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(10)")
	List<WebElement> lstManagerReply;
	
	// List Of Status in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(11)")
	List<WebElement> lstStatus;
	
	// List Of Engg. Name in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(12)")
	List<WebElement> lstEnggName;
	
	// List Of Title in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(13)")
	List<WebElement> lstTitle;
	
	// List Of Description in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(14)")
	List<WebElement> lstDescription;
	
	// List Of Address in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(15)")
	List<WebElement> lstAddress;
	
	// List Of LC Name in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(16)")
	List<WebElement> lstLCName;
	
	// List Of LC Contact in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(17)")
	List<WebElement> lstLCContact;
	
	// List Of Call Logged By in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(18)")
	List<WebElement> lstCallLoggedBy;
	
	// List Of ETA Date Time in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(19)")
	List<WebElement> lstETADateTime;
	
	// List Of ATA Date Time in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(20)")
	List<WebElement> lstATADateTime;
	
	// List Of TC Date Time in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(21)")
	List<WebElement> lstTCDateTime;
	
	// List Of Paused Date Time in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(22)")
	List<WebElement> lstPausedDateTime;
	
	// List Of Resume Date Time in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(23)")
	List<WebElement> lstResumeDateTime;
	
	// List Of Paused Reason in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(24)")
	List<WebElement> lstPausedReason;
	
	// List Of Resolution in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(25)")
	List<WebElement> lstResolution;
	
	// List Of Final Status in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(26)")
	List<WebElement> lstFinalStatus;
	
	// List Of Final Closure Date Time in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(27)")
	List<WebElement> lstFinalClosureDateTime;
	
	// List Of TTS in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(28)")
	List<WebElement> lstTTS;
	
	// List Of Final TTS in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(29)")
	List<WebElement> lstFinalTTS;
	
	// List Of Remarks in Table
	@FindBy(css = "div[class='table']>table>tbody>tr[class='trHover']>td:nth-of-type(30)")
	List<WebElement> lstRemarks;
	
	// Pagination
	@FindBy(css = "#pagination>ul>li>strong")
	WebElement lblcount;
	
	
	
	// Initializing Page Object
	public SD_ViewTicket2Page() {
		PageFactory.initElements(driver, this);
	}
	
	public SD_ViewTicket2Test VerifyIDTextBox(String data) throws Exception
	{
		tabSearchTicketOpen.click();
		System.out.println("Input : "+data);
		txtId.sendKeys(data);
		btnGoOfId.click();
		
			try {
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				driver.switchTo().defaultContent();


				Assert.assertEquals(alertMessage,
						"Please Enter The Numeric Value for Incident ID");
				System.out.println("Both the message is equal");
			} 
			catch (Exception e) {
				
		    int rowSize=lstRow.size();
		    if(rowSize==1)
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				Assert.assertEquals(textOfTotalCount,"  Total Ticket Count: 1","Count is not match");
		    }
		    else
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				Assert.assertEquals(textOfTotalCount,"  Total Ticket Count:","Count is not match");	
		    }
		    
		}
		
		
	
		return new SD_ViewTicket2Test();
	}
	
	
	public SD_ViewTicket2Test VerifyAssetIdTextBox(String data) throws Exception
	{
		tabSearchTicketOpen.click();
		System.out.println("Input : "+data);
		txtAssetId.sendKeys(data);
		btnGoOfAssetId.click();
		
		
			try {
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				driver.switchTo().defaultContent();


				Assert.assertEquals(alertMessage,
						"Please Enter The Numeric Value for Incident ID");
				System.out.println("Both the message is equal");
			} 
			catch (Exception e) {
				
		    int rowSize=lstRow.size();
		    if(rowSize>=1)
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				Assert.assertEquals(textOfTotalCount,"  Total Ticket Count: "+rowSize,"Count is not match");
		    }
		    else
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				Assert.assertEquals(textOfTotalCount,"  Total Ticket Count: 0","Count is not match");	
		    }
		    
		}
			
	
		return new SD_ViewTicket2Test();
	}
	
	
	public SD_ViewTicket2Test VerifyTicketIdTextBox(String data) throws Exception
	{
		tabSearchTicketOpen.click();
		System.out.println("Input : "+data);
		txtTicketID.sendKeys(data);
		btnGoOfTicketID.click();
		
		
			try {
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				driver.switchTo().defaultContent();


				Assert.assertEquals(alertMessage,
						"Please Enter The Numeric Value for Incident ID");
				System.out.println("Both the message is equal");
			} 
			catch (Exception e) {
				
		    int rowSize=lstRow.size();
		    if(rowSize==1)
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				Assert.assertEquals(textOfTotalCount,"  Total Ticket Count: 1","Count is not match");
		    }
		    else
		    {
		    	String textOfTotalCount= lblcount.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				Assert.assertEquals(textOfTotalCount,"  Total Ticket Count: 0","Count is not match");	
		    }
		    
		}
			
	
		return new SD_ViewTicket2Test();
	}
	
	
	public void checkDataFilterByState() throws Exception
	{

	


				// Click on SearchTicketOpen tab
				tabSearchTicketOpen.click();

				
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
					int sizeOfState = lstSTATE.size();
					// Print size of State
					System.out.println("sizeOfState: " + sizeOfState);

					// Check condition
					if (sizeOfState > 0) {
						// Apply For Loop for State
						for (int j = 0; j < sizeOfState; j++) {
							((JavascriptExecutor) driver).executeScript(
									"arguments[0].scrollIntoView(true);",
									lstSTATE.get(j));
							// Get State
							String state = lstSTATE.get(j).getText();
							// Print State
							System.out.println("State: " + state);
							// Verify State
							Assert.assertEquals(state, stateOptions,
									"State is not Same");
// Optional
							break;
						}
				/*		// Update State
						state = state + 1;
						// Call Employee Details Page Of Sd Role
						sd_ViewTicket2Page = new SD_ViewTicket2Page();
						// call checkDataFilterByState Method
						sd_ViewTicket2Page.checkDataFilterByState();
						Thread.sleep(2000);

					} else if (sizeOfState == 0) {
						// Update State
						state = state + 1;
						// Call Employee Details Page Of Sd Role
						sd_ViewTicket2Page = new SD_ViewTicket2Page();
						// call checkDataFilterByState Method
						sd_ViewTicket2Page.checkDataFilterByState();
						Thread.sleep(2000);
					}*/
						
						
					}
					// Optional
					break;
				}
	}
	

	public void checkDataFilterByStatus() throws Exception
	{

	


				// Click on SearchTicketOpen tab
				tabSearchTicketOpen.click();

				
				// Get drop down of Filter By Status
				Select filterByStatus = new Select(ddlFilterByStatus);

				// Get list of Filter By Status
				List<WebElement> listOfFilterByStatus = filterByStatus.getOptions();
				// Get size of Filter By Status
				int sizeOfFilterByStatus = listOfFilterByStatus.size();
				// Print size of Filter By Status
				System.out.println("\nsizeOfStatus: " + sizeOfFilterByStatus);

				// Apply For Loop for Status
				for (; status < sizeOfFilterByStatus; status++) {

					// Get Status
					String statusOptions = listOfFilterByStatus.get(status).getAttribute(
							"value");
					// Print Status
					System.out.println("\nStatusOptions: " + statusOptions);
					Thread.sleep(2000);
					// Select Status
					filterByStatus.selectByIndex(status);
					Thread.sleep(1000);

					// Get size of Status
					int sizeOfStatus = lstSTATE.size();
					// Print size of Status
					System.out.println("sizeOfStatus: " + sizeOfStatus);

					// Check condition
					if (sizeOfStatus > 0) {
						// Apply For Loop for Status
						for (int j = 0; j < sizeOfStatus; j++) {
							((JavascriptExecutor) driver).executeScript(
									"arguments[0].scrollIntoView(true);",
									lstStatus.get(j));
				
					       
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							lstStatus.get(j));
					 
							// Get Status
							String status = lstStatus.get(j).getText();
							// Print Status
							System.out.println("Status: " + status);
							// Verify Status
							Assert.assertEquals(status, statusOptions,
									"Status is not Same");

					
						}
						// Update Status
						status = status + 1;
						// Call Employee Details Page Of Sd Role
						sd_ViewTicket2Page = new SD_ViewTicket2Page();
						// call checkDataFilterByStatus Method
						sd_ViewTicket2Page.checkDataFilterByStatus();
						Thread.sleep(2000);

					} else if (sizeOfStatus == 0) {
						// Update Status
						status = status + 1;
						// Call Employee Details Page Of Sd Role
						sd_ViewTicket2Page = new SD_ViewTicket2Page();
						// call checkDataFilterByStatus Method
						sd_ViewTicket2Page.checkDataFilterByStatus();
						Thread.sleep(2000);
					}
			
					
				}
	}
	
	public void checkDataFilterByCustomer() throws Exception {

		// Click on SearchTicketOpen tab
		tabSearchTicketOpen.click();

	

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
	
}
