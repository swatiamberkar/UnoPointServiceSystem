package com.uno.pages.sd;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.superrole.Super_AdminPage;
import com.uno.pages.superrole.Super_EmployeeDetailPage;
import com.uno.pages.superrole.Super_EmployeeMasterPage;
import com.uno.pages.superrole.Super_FileCategoryPage;
import com.uno.pages.superrole.Super_HomePage;
import com.uno.pages.superrole.Super_ItemMasterPage;
import com.uno.pages.superrole.Super_LoginPage;
import com.uno.pages.superrole.Super_ManageStaffPage;
import com.uno.pages.superrole.Super_SDMasterPage;
import com.uno.pages.superrole.Super_ServiceDeskSettingsPage;
import com.uno.pages.superrole.Super_SpareInventoryLocationPage;
import com.uno.pages.superrole.Super_TeamMasterPage;
import com.uno.pages.superrole.Super_TicketMasterPage;
import com.uno.pages.superrole.Super_TicketModePage;
import com.uno.pages.superrole.Super_TicketTypePage;
import com.uno.test.sd.SD_ViewTicketTest;
import com.uno.test.superrole.Super_AdminTest;
import com.uno.test.superrole.Super_InventoryMastersTest;
import com.uno.test.superrole.Super_ServiceDeskSettingsTest;

public class SdRoleWithSuperRolePage extends BaseCode{
SD_EditTicketPage sd_EditTicketPage;
Super_LoginPage super_LoginPage;
Super_HomePage super_HomePage;
Super_SDMasterPage super_SDMasterPage;
Super_TicketMasterPage super_TicketMasterPage;
Super_TicketTypePage super_TicketTypePage;
Super_TicketModePage super_TicketModePage;
Super_EmployeeMasterPage super_EmpolyeeMasterPage;
Super_EmployeeDetailPage super_EmployeeDetailPage;
Super_ManageStaffPage super_ManageStaffPage;
Super_TeamMasterPage super_TeamMasterPage;
Super_FileCategoryPage super_FileCategoryPage;
Super_AdminPage super_AdminPage;
Super_AdminTest super_AdminTest;
Super_ServiceDeskSettingsPage super_ServiceDeskSettingsPage;
Super_ServiceDeskSettingsTest super_ServiceDeskSettingsTest;
Super_InventoryMastersTest super_InventoryMastersTest;
Super_ItemMasterPage super_ItemMasterPage;
Super_SpareInventoryLocationPage super_SpareInventoryLocationPage;
SD_ViewTicketTest sd_ViewTicketTest;
SD_CreateNewPage sd_CreateNewPage;
	

//Initializing Page Object
	public SdRoleWithSuperRolePage() {
		PageFactory.initElements(driver, this);
	}

	// Display Request/ Incident Tab
	public void selectTicket() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		sd_EditTicketPage = new SD_EditTicketPage();
		int sizePagination = sd_EditTicketPage.dropdown_Pagination.size();
		System.out.println(sizePagination);
		loop: for (int p = 0; p < sizePagination; p++) {

			sd_EditTicketPage.dropdown_Pagination.get(p).click();

			List<WebElement> status = sd_EditTicketPage.lstStatusInTable;
			int size = status.size();
			System.out.println(size);

			for (int i = 0; i < status.size(); i++) {
				String statusValue = status.get(i).getText();
				System.out.println(statusValue);

				String ETA = sd_EditTicketPage.lstETADateInTable.get(i).getText();
				System.out.println(ETA);

				String ATA = sd_EditTicketPage.lstATADateInTable.get(i).getText();
				System.out.println(ATA);

				String flag = sd_EditTicketPage.lstFlagOfIncorrectCustomerAddressInTable.get(i)
						.getAttribute("alt");
				System.out.println("Flag:" + flag);

				if (statusValue.equalsIgnoreCase("Open")
						&& flag.equalsIgnoreCase("Violated") && !ETA.equals("")
						&& !ATA.equals(""))

				{

					String idValue = sd_EditTicketPage.lstIDInTable.get(i).getText();
					System.out.println(idValue);
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							sd_EditTicketPage.lstIDInTable.get(i));

					sd_EditTicketPage.lstIDInTable.get(i).click();

					// Get text of Request/ Incident Tab
					String requestOrIncidentTab = driver.findElement(
							By.cssSelector(" .tab1.active>a>span")).getText();

					// Print text of Request/ Incident Tab
					System.out.println("Tab Name: " + requestOrIncidentTab);

					// Check text of Request/ Incident Tab is match or not
					softAssert.assertEquals(requestOrIncidentTab,
							"Requestor / Incident", "Tab is not correct");

					break loop;

				}
			}
			if (sizePagination - 1 == p) {
				Assert.assertTrue(false, " Ticket is not Available");
			}
		}
		softAssert.assertAll();
	}

	public void verifyTicketType() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		sd_EditTicketPage = new SD_EditTicketPage();
		
		sd_EditTicketPage.btnEditInIncidentDetailsTab.click();
		// Select Ticket Type
		
		 String ticketType=	 sd_EditTicketPage.ddlTicketTypeInTicketDetailsPopup.getText();	
		System.out.println("All Ticket Type: "+ticketType);
		
		
		Select valueOfTicketType = new Select(sd_EditTicketPage.ddlTicketTypeInTicketDetailsPopup);
		int sizeOfTicketType =valueOfTicketType.getOptions().size()-1;
		System.out.println("sizeOfTicketType: "+sizeOfTicketType);
		
		// Change the Tab
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
				// Enter url
				driver.get(properties.getProperty("url"));
				// click on account
				sd_EditTicketPage.link_sd.click();
				Thread.sleep(2000);

				// click on logout
				sd_EditTicketPage.link_LogOut.click();
				Thread.sleep(1000);

				// login as super ,call it from super Role customer detail page
				super_LoginPage = new Super_LoginPage();
				super_HomePage = super_LoginPage.Login(
						properties.getProperty("loginIdForSuper"),
						properties.getProperty("password"));
				// homePageOfSuperRole = new HomePageOfSuperRole();

				// Thread.sleep(3000);
				super_SDMasterPage = super_HomePage.clickSdMasterlink();

				Thread.sleep(1000);
				super_TicketMasterPage = super_SDMasterPage
						.clickOnTicketMasterLink();

				Thread.sleep(1000);
				super_TicketTypePage = super_TicketMasterPage
						.ticketTypeTab();

				// Thread.sleep(3000);

				/*// for table
				List<WebElement> rowElement = driver.findElements(By
						.xpath(".//*[@id='right']/div/div/div[2]/table/tbody/tr"));
				System.out.println("NUMBER OF ROWS IN THIS TABLE = "
						+ rowElement.size());*/

				int sizeOfTicketTypeInSuper=super_TicketTypePage.lstTicketType.size();
				System.out.println("sizeOfTicketTypeInSuper: "+sizeOfTicketTypeInSuper);
				Assert.assertEquals(sizeOfTicketType, sizeOfTicketTypeInSuper, "'Ticket Type size is not Same.'");
				
				for (int i = 0; i < sizeOfTicketTypeInSuper; i++) {

				
					String element = super_TicketTypePage.lstTicketType.get(i).getText();
					System.out.println("All Value Ticket Type In super Role:-"
							+ element);

					boolean ticketTypeIsPresent= true;
					if (ticketType.contains(element))

					{
						ticketTypeIsPresent= true;
						System.out.println("Pass");

					}

					else 
					{
						ticketTypeIsPresent= false;
						System.out.println("fails");
					}

					Assert.assertTrue(ticketTypeIsPresent, "'Ticket Type size is not Same.'");
		
		
	}
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
	}
	
	public void verifyTicketMode() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		sd_EditTicketPage = new SD_EditTicketPage();
		
		//sd_EditTicketPage.btnEditInIncidentDetailsTab.click();
		
		// Select Ticket Type
		sd_EditTicketPage.ddlModeInTicketDetailsPopup.click();
		 String ticketMode=	 sd_EditTicketPage.ddlModeInTicketDetailsPopup.getText();	
		System.out.println("All Ticket Mode: "+ticketMode);
		
		
		Select valueOfTicketMode = new Select(sd_EditTicketPage.ddlModeInTicketDetailsPopup);
		int sizeOfTicketMode =valueOfTicketMode.getOptions().size()-1;
		System.out.println("sizeOfTicketMode: "+sizeOfTicketMode);
		
		// Change the Tab
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
				// Enter url
				driver.get(properties.getProperty("url"));
				// click on account
				/*sd_EditTicketPage.link_Test.click();
				Thread.sleep(2000);

				// click on logout
				sd_EditTicketPage.link_LogOut.click();
				Thread.sleep(1000);

				// login as super ,call it from super Role customer detail page
				super_LoginPage = new Super_LoginPage();
				super_HomePage = super_LoginPage.Login(
						properties.getProperty("loginIdForSuper"),
						properties.getProperty("password"));
				// homePageOfSuperRole = new HomePageOfSuperRole();
*/
				super_HomePage = new Super_HomePage();
				// Thread.sleep(3000);
				super_SDMasterPage = super_HomePage.clickSdMasterlink();

				Thread.sleep(1000);
				super_TicketMasterPage = super_SDMasterPage
						.clickOnTicketMasterLink();

				Thread.sleep(1000);
				super_TicketModePage = super_TicketMasterPage
						.ticketModeTab();

				// Thread.sleep(3000);

				/*// for table
				List<WebElement> rowElement = driver.findElements(By
						.xpath(".//*[@id='right']/div/div/div[2]/table/tbody/tr"));
				System.out.println("NUMBER OF ROWS IN THIS TABLE = "
						+ rowElement.size());*/

				int sizeOfTicketModeInSuper=super_TicketModePage.lstTicketMode.size();
				System.out.println("sizeOfTicketModeInSuper: "+sizeOfTicketModeInSuper);
				Assert.assertEquals(sizeOfTicketMode, sizeOfTicketModeInSuper, "'Ticket Mode size is not Same.'");
				
				for (int i = 0; i < sizeOfTicketModeInSuper; i++) {

				
					String element = super_TicketModePage.lstTicketMode.get(i).getText();
					System.out.println("All Value Ticket Type In super Role:-"
							+ element);

					boolean ticketModeIsPresent= true;
					if (ticketMode.contains(element))

					{
						ticketModeIsPresent= true;
						System.out.println("Pass");

					}

					else 
					{
						ticketModeIsPresent= false;
						System.out.println("fails");
					}

					Assert.assertTrue(ticketModeIsPresent, "'Ticket Mode size is not Same.'");
		
		
	}
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
	}
	
	
	}



