package com.uno.pages.scm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class SCM_LoginPage extends BaseCode {
	

	@FindBy(name="m_strLoginId")
	WebElement objectOfLoginId;
	
	@FindBy(name="password")
	WebElement objectOfPassword;
	
	@FindBy(css = ".form-wrap>ul>li:nth-of-type(4)>button:nth-of-type(1)")
	 WebElement objectOfLoginButton;
	
	//initializing page object
	public SCM_LoginPage()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	//Action 
	public String superLoginPageTitle(){
		
		return driver.getTitle();
	}
	
	public SCM_HomePage Login(String ur1,String pass1) throws Exception
	{
		
		objectOfLoginId.sendKeys(ur1);
		objectOfPassword.sendKeys(pass1);
		Thread.sleep(3000);
		objectOfLoginButton.click();
		return new SCM_HomePage();
	}

}
