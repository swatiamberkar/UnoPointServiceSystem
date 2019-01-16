package com.uno.pages.rm;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.uno.baseClass.BaseCode;

public class RM_ViewMyClaimPage extends BaseCode {

	// Claim Approval Tab
	@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr/td[12]")
	List<WebElement> lstClaimedBy;
	
	@FindBy(xpath = ".//*[@id='main']/div[3]/div[2]/div/ul/li[10]/a")
	WebElement lblLogin;

	public RM_ViewMyClaimPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLoginUser() throws Exception
	{
		String loginUser = lblLogin.getText();
		System.out.println("loginUser: "+loginUser);
		int SizeOfclaimedBy = lstClaimedBy.size();
		System.out.println("SizeOfclaimedBy: "+SizeOfclaimedBy);
		for (int i = 0; i < SizeOfclaimedBy; i++) {
			scrollDown(lstClaimedBy.get(i));
			highLight(lstClaimedBy.get(i));
			String claimedBy=lstClaimedBy.get(i).getText();
			System.out.println("claimedBy: "+claimedBy);
			String claimedByText =claimedBy.split(" ")[0];
			System.out.println("claimedByText: "+claimedByText);
			Assert.assertEquals(claimedByText, loginUser, "Login User And Claimed By is not Same.");
			
		}
	}

}
