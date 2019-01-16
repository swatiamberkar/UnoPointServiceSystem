package com.uno.pages.superrole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Super_LoginPage extends BaseCode {
	
	@FindBy(name="m_strLoginId")
	WebElement objectOfSuperLoginId;
	
	@FindBy(name="password")
	WebElement objectOfSuperPassword;
	
	@FindBy(css = ".form-wrap>ul>li:nth-of-type(4)>button:nth-of-type(1)")
	 WebElement objectOfLoginButton;
	
	//initializing page object
	public Super_LoginPage()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	//Action 
	public String superLoginPageTitle(){
		
		return driver.getTitle();
	}
	
	public Super_HomePage Login(String ur1,String pass1) throws Exception
	{
		
		objectOfSuperLoginId.sendKeys(ur1);
		objectOfSuperPassword.sendKeys(pass1);
		Thread.sleep(3000);
		objectOfLoginButton.click();
		return new Super_HomePage();
	}

}
