package com.uno.pages.rm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class RM_ClaimPage extends BaseCode {

	// Create New Tab
	@FindBy(css = "a[href='/erprmwise/Claim.do']")
	WebElement tabCreateNew;

	// Reimbursement Against Advance Tab
	@FindBy(css = "a[href='/erprmwise/Claim.do?action=createAgainstAdvancedClaim']")
	WebElement tabReimbursementAgainstAdvance;

	// View My Claim Tab
	@FindBy(css = "a[href='/erprmwise/Claim.do?action=ClaimView']")
	WebElement tabViewMyClaim;

	// Claim Approval Tab
	@FindBy(css = "a[href='/erprmwise/ClaimForMultiApproval.do']")
	WebElement tabClaimApproval;

	public RM_ClaimPage() {
		PageFactory.initElements(driver, this);
	}

	// Click on Inventory link
	public RM_CreateNewClaimPage CreateNewTab() throws Exception {
		
		highLight(tabCreateNew);
		tabCreateNew.click();
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(tabCreateNew).build();
		seriesOfActions.perform();
		//tabCreateNew.click();
		return new RM_CreateNewClaimPage();
	}

	// Click on Inventory link
	public RM_ReimbursementAgainstAdvancePage ReimbursementAgainstAdvanceTab() {
		tabReimbursementAgainstAdvance.click();
		return new RM_ReimbursementAgainstAdvancePage();
	}

	// Click on Inventory link
	public RM_ClaimApprovalPage ClaimApprovalTab() throws Exception {
		Thread.sleep(1000);
		tabClaimApproval.click();
		return new RM_ClaimApprovalPage();
	}
	
	// Click on Inventory link
		public RM_ViewMyClaimPage ViewMyClaimTab() {
			tabViewMyClaim.click();
			return new RM_ViewMyClaimPage();
		}

}
