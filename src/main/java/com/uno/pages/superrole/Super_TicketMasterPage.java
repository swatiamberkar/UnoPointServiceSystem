package com.uno.pages.superrole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class Super_TicketMasterPage extends Super_SDMasterPage {


		
		
		
		public Super_TicketMasterPage()
		{
			PageFactory.initElements(driver, this);
			
		}
		
		
		public Super_TicketTypePage ticketTypeTab()
		{
			tabTicketType.click();
			return new Super_TicketTypePage();
			
		}
		
		public Super_TicketModePage ticketModeTab()
		{
			tabTicketMode.click();
			return new Super_TicketModePage();
			
		}
		
		public Super_TicketTypePage clickOnTicketTypeLink()
		{
			tabTicketType.click();
			return new Super_TicketTypePage();
			
		}
		

		public Super_TicketModePage clickOnTicketModeLink()
		{
			tabTicketMode.click();
			return new Super_TicketModePage();
			
		}
		
		public Super_TicketLevelPage clickOnTicketLevelLink()
		{
			tabTicketLevel.click();
			return new Super_TicketLevelPage();
			
		}
		
		public Super_CTSStatusPage clickOnCTSStatusLink()
		{
			tabCTSStatus.click();
			return new Super_CTSStatusPage();
			
		}
		
		public Super_PauseReasonPage clickOnPauseReasonLink()
		{
			tabPauseReason.click();
			return new Super_PauseReasonPage();
			
		}
		


}
