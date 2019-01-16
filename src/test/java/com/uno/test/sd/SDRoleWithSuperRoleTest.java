package com.uno.test.sd;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SdRoleWithSuperRolePage;

public class SDRoleWithSuperRoleTest extends BaseCode{
	

	SD_LoginPage sd_LoginPage;
	SD_HomePage sd_HomePage;
	SD_TicketPage sd_TicketPage;
	SdRoleWithSuperRolePage sdRoleWithSuperRolePage;
	
	public SDRoleWithSuperRoleTest() {
		super();
	}
	
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
		
			initialization();

			sd_LoginPage = new SD_LoginPage();
			Thread.sleep(1000);
			sd_HomePage = sd_LoginPage.login(
					properties.getProperty("loginIdForSd"),
					properties.getProperty("password"));
			Thread.sleep(1000);
			sd_HomePage = new SD_HomePage();
			sd_TicketPage = sd_HomePage.ticketTab();
			Thread.sleep(1000);
			sdRoleWithSuperRolePage = sd_TicketPage.SdWithSuper();
			Thread.sleep(1000);
			

	}


 	
	// Requestor / Incident Tab //

	@Feature("")
	@Test(priority = 1, groups = { "" }, 
	description = "")
	@Description("")
	public void VerifyTicketType() throws Exception {
		sdRoleWithSuperRolePage.selectTicket();
		sdRoleWithSuperRolePage.verifyTicketType();
	}
	
	@Feature("")
	@Test(priority = 2, groups = { "" }, 
	description = "")
	@Description("")
	public void VerifyTicketMode() throws Exception {
	
		sdRoleWithSuperRolePage.verifyTicketMode();
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}

}
