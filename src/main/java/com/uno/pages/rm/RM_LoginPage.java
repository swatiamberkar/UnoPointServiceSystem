package com.uno.pages.rm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




import com.uno.baseClass.BaseCode;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.technician.Technician_HomePage;



public class RM_LoginPage extends BaseCode {
	
	@FindBy(name="m_strLoginId")
	WebElement lblUserName;
	
	@FindBy(name="password")
	WebElement lblPassword;
	
	@FindBy(css = ".form-wrap>ul>li:nth-of-type(4)>button:nth-of-type(1)")
	 WebElement btnLogin;
	
	//initializing page object
	public RM_LoginPage()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	//Action 
	public String superLoginPageTitle(){
		
		return driver.getTitle();
	}
	
	public RM_HomePage Login(String ur1,String pass1) throws Exception
	{
		
		lblUserName.sendKeys(ur1);
		lblPassword.sendKeys(pass1);
		Thread.sleep(3000);
		btnLogin.click();
		return new RM_HomePage();
	}

	public Technician_HomePage technicianLogin(String username, String password)
			throws InterruptedException 
	{

		lblUserName.sendKeys(username);
		lblPassword.sendKeys(password);
		Thread.sleep(3000);
		btnLogin.click();
		return new Technician_HomePage();
	}
	
	public SD_HomePage sdLogin(String us, String pass)
			throws Exception 
	{

		lblUserName.sendKeys(us);
		lblUserName.sendKeys(pass);
		Thread.sleep(3000);
		btnLogin.click();
		return new SD_HomePage();
		
	}
	



}
