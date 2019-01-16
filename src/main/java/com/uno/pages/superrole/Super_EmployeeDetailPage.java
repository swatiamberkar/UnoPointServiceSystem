package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.uno.baseClass.BaseCode;



public class Super_EmployeeDetailPage extends BaseCode  
{

	   @FindBy(linkText="Filter")
	   public
	   WebElement tabFilter;
	   
	   @FindBy(name="m_strRole")
	   public
	   WebElement ddlSearchByRole;
	   

		// Select list of Id in Table
		@FindBy(xpath = ".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr/td[3]")
		public
		List<WebElement> lstNameInTable;
		
		// Select list of Id in Table
		@FindBy(xpath = ".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr/td[19]")
		public
		List<WebElement> lstReportingManager;
		
		public static String assignLocationValue = null;
		
		// Select SD tab for logout tab
		@FindBy(linkText = "Test")
		WebElement tabTest;

		// Click on logout
		
		@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
		WebElement tabLogOut;


		@FindBy(name = "m_strRole")
		public
		WebElement txtSearchByRole;
		
		@FindBy(name = "m_strFilterCustomerName")
		WebElement ddlCustomerFilter;

		@FindBy(xpath = ".//*[@id='right']/div[1]/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr/td[3]/a")
		WebElement btnUpdateTotalLeave;
		
		@FindBy(name = "m_strTotalLeaves")
		WebElement txtTotalLeave;
		
		@FindBy(xpath = ".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr/td[3]")
		public
		List<WebElement> lstFirstName;
		
		@FindBy(xpath = ".//*[@id='right']/div[1]/table/tbody/tr[7]/td[1]/table/tbody/tr/td/table/tbody/tr[5]/td[5]/select")
		WebElement ddlLocation;
		
		

		public static String totalLeave = null;
		public static String firstName = null;
		
		// Select SD tab for logout tab
		@FindBy(linkText = "Test")
		WebElement link_Test;

		// Click on logout
		
		@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
		WebElement link_LogOut;

		@FindBy(linkText = "Filter")
		public
		WebElement objectOfFilteTab;

		
		
		@FindBy(name = "m_strFilterCustomerName")
		WebElement dropdown_CustomerFilter;

		@FindBy(xpath = ".//*[@id='right']/div[1]/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr/td[3]/a")
		WebElement button_UpdateTotalLeave;
		
		@FindBy(name = "m_strTotalLeaves")
		WebElement textbox_TotalLeave;
		
		@FindBy(xpath = ".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr/td[3]")
		public
		List<WebElement> list_FirstName;
		
		

	   
	   
	   public Super_EmployeeDetailPage() {
			PageFactory.initElements(driver, this);
		}
	
	   public void clickOnUpdateInSD() throws Exception 
		{
			//click on filter tab
			objectOfFilteTab.click();
			
			Select role = new Select(ddlSearchByRole);
			role.selectByVisibleText("SD");
			
			Thread.sleep(1000);

			// for table
			List<WebElement> rowElement = driver.findElements(By
					.xpath(".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr"));
			System.out.println("NUMBER OF ROWS IN THIS TABLE = "
					+ rowElement.size());

			for (int i = 0; i < rowElement.size(); i++) {

				List<WebElement> listOfLoginIdcolumn = driver
						.findElements(By
								.xpath(".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr/td[33]"));
				String loginIdcolumn = listOfLoginIdcolumn.get(i).getText();
				System.out.println(loginIdcolumn);

				if (loginIdcolumn.contains("sd"))
				{
					System.out.println("Both the ticket Id is equal ");

					List<WebElement> listOfUpdateColumn = driver
							.findElements(By
									.cssSelector(".fht-table.fht-table-init>tbody>tr>td:nth-of-type(34)>a"));
					WebElement updateColumn = listOfUpdateColumn.get(i);
					System.out.println(updateColumn.getText());

					updateColumn.click();
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							button_UpdateTotalLeave);

				  
				  //click on Update Leave button
				  button_UpdateTotalLeave.click();
				  
				  //get the total leave count from update leave pop up
				  totalLeave = textbox_TotalLeave.getAttribute("value");
				  System.out.println("totalLeave: "+totalLeave);
					break;

				}
			}

		}
		
		//used in Engineer Attendance Page
		public void selectSdInFilter() {
			// Click on filter
			objectOfFilteTab.click();

			// select search by role
			Select searchByRole = new Select(ddlSearchByRole);
			searchByRole.selectByVisibleText("SD");

		}
		
		//used in Engineer Attendance Page
		
		public void selectCustomerInFilterInSD() {
			// Click on filter
			objectOfFilteTab.click();
			
			// select search by role
			Select searchByRole = new Select(dropdown_CustomerFilter);
			searchByRole.selectByVisibleText("demo_Customer");
				
		}	
		
		//use in engineer attendance in RM
			public void clickOnUpdateInRM() throws Exception 
			{
				//click on filter tab
				tabFilter.click();
				
				Select role = new Select(txtSearchByRole);
				role.selectByVisibleText("ReportingManager");
				
				Thread.sleep(1000);

				// for table
				List<WebElement> columnValue = driver.findElements(By
						.xpath(".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/a"));
				
				System.out.println("NUMBER OF ROWS IN THIS TABLE = "
						+ columnValue.size());

				for (int i = 0; i < columnValue.size(); i++) 
				{

					String firstNameValue = columnValue.get(i).getText();
					System.out.println(firstNameValue);

					if (firstNameValue.contains("NewRM1"))
					{
						
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								columnValue.get(i));

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
								columnValue.get(i));
					  
						columnValue.get(i).click();
						Thread.sleep(1000);
					
					  //click on Update Leave button
					  btnUpdateTotalLeave.click();
					  
					  //get the total leave count from update leave pop up
					  totalLeave = txtTotalLeave.getAttribute("value");
					  System.out.println("totalLeave: "+totalLeave);
						break;

					}
				}

			}
			
			//used in Engineer Attendance Page
			public void selectRMInFilter() {
				// Click on filter
				tabFilter.click();

				// select search by role
				Select searchByRole = new Select(txtSearchByRole);
				searchByRole.selectByVisibleText("ReportingManager");

			}
			
			//used in Engineer Attendance Page
			
			public void selectCustomerInFilter() {
				// Click on filter
				tabFilter.click();
				
				// select search by role
				Select searchByRole = new Select(ddlCustomerFilter);
				searchByRole.selectByVisibleText("demo_Customer");
					
			}	
			
			//get value of location
			//used in Transact Inventory Page 
			public void location() throws Exception
			{
				
				//click on filter tab
				tabFilter.click();
				
				Select role = new Select(txtSearchByRole);
				role.selectByVisibleText("ReportingManager");
				
				Thread.sleep(1000);

				// for table
				List<WebElement> columnValue = driver.findElements(By
						.xpath(".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/a"));
				
				System.out.println("NUMBER OF ROWS IN THIS TABLE = "
						+ columnValue.size());

				for (int i = 0; i < columnValue.size(); i++) 
				{

					String firstNameValue = columnValue.get(i).getText();
					System.out.println(firstNameValue);

					if (firstNameValue.contains("NewRM1"))
					{
						scrollDown(columnValue.get(i));
						
						highLight(columnValue.get(i));
					  
						columnValue.get(i).click();
						Thread.sleep(1000);
						
		                scrollDown(ddlLocation);
						
						highLight(ddlLocation);
						
						assignLocationValue = ddlLocation.getText();
						System.out.println("assignLocationValue: "+assignLocationValue);
						
							
					
					}
					break;
					
				}	
				
			}
			//use in My Availability in Technician
			public void clickOnUpdateInTechnician() throws Exception 
			{
				//click on filter tab
				tabFilter.click();
				
				Select role = new Select(txtSearchByRole);
				role.selectByVisibleText("Technician");
				
				Thread.sleep(1000);

				// for table
				List<WebElement> columnValue = driver.findElements(By
						.xpath(".//*[@id='right']/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/a"));
				
				System.out.println("NUMBER OF ROWS IN THIS TABLE = "
						+ columnValue.size());

				for (int i = 0; i < columnValue.size(); i++) 
				{

					String firstNameValue = columnValue.get(i).getText();
					System.out.println(firstNameValue);

					if (firstNameValue.contains("kavita"))
					{
						
						((JavascriptExecutor) driver).executeScript(
								"arguments[0].scrollIntoView(true);",
								columnValue.get(i));

						((JavascriptExecutor) driver).executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
								columnValue.get(i));
					  
						columnValue.get(i).click();
						Thread.sleep(1000);
					
					  //click on Update Leave button
					  btnUpdateTotalLeave.click();
					  
					  //get the total leave count from update leave pop up
					  totalLeave = txtTotalLeave.getAttribute("value");
					  System.out.println("totalLeave: "+totalLeave);
						break;

					}
				}

			}

}
