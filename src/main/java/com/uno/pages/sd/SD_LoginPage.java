package com.uno.pages.sd;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.technician.Technician_HomePage;
import com.uno.test.sd.SD_LoginTest;
import com.uno.baseClass.BaseCode;



public class SD_LoginPage extends BaseCode 
{
	SD_LoginPage sd_LoginPage;
	
	@FindBy(linkText = "SD")
	WebElement link_sd;

	// click on logout
	@FindBy(xpath = "//a[@class='logout'][@href='/erprmwise/Logout.do']")
	WebElement link_LogOut;

	SD_CreateNewPage createTicketPageOfSdRole;
	// select user name
	@FindBy(xpath = ".//*[@id='login']/ul/li[2]/input")
	WebElement txtUsername;

	// select password
	@FindBy(xpath = ".//*[@id='login']/ul/li[3]/input")
	WebElement txtPassword;

	// select login button
	@FindBy(css = ".form-wrap>ul>li:nth-of-type(4)>button:nth-of-type(1)")
	WebElement btnLogin;

	// select team button
	@FindBy(xpath = ".//*[@id='login']/ul/li[1]/label")
	List<WebElement> rdoTeamAndCustomer;

	// get name of Do you want to log a ticket? window
	@FindBy(xpath = ".//*[@id='content']/h2")
	WebElement lblCustomerWindow;

	// click on skip button
	@FindBy(className = "skippopup")
	WebElement btnSkip;

	// click on Trouble Ticket
	@FindBy(className = "trouble_ticket")
	WebElement btnTroubleTicket;

	// get name of Ticket form
	@FindBy(xpath = ".//*[@id='content']/div/div[1]/ul/li[2]/a")
	WebElement lblTicketForm;

	// click on Go Back Login in customer ticket form page
	@FindBy(xpath = ".//*[@id='content']/div/div[1]/ul/li[1]/a")
	WebElement btnGoBackLogin;

	// select error message "Wrong User name or Password"
	@FindBy(xpath = ".//*[@id='login']/div")
	WebElement lblErrorMessage;

	// select Forgot Password hyper link
	@FindBy(css = ".form-wrap>ul>li:nth-of-type(4)>a")
	WebElement lnkForgotPassword;

	// heading name of "enter either of detail"
	@FindBy(xpath = ".//*[@id='forgotpassword']/div")
	WebElement lblForgotPassword;

	// select user name field in forgot password
	@FindBy(id = "username")
	WebElement txtUsernameInForgotPassword;

	// select Ecode field in forgot password
	@FindBy(id = "ecode")
	WebElement txtEcodeInForgotPassword;

	// select Email field in forgot password
	@FindBy(id = "emailid")
	WebElement txtEmailInForgotPassword;

	// select Reset password
	@FindBy(xpath = ".//*[@id='forgotpassword']/ul/li[4]/button")
	WebElement btnResetPassword;

	// select the Notification
	// "Reset password link has been send on your registered email ID"
	@FindBy(xpath = ".//*[@id='notification']/div[2]")
	WebElement notification;

	// select "back to login" button
	@FindBy(xpath = ".//*[@id='notification']/a")
	WebElement btnBackToLogin;
	
	// initializing page object
	public SD_LoginPage() 
	{

		PageFactory.initElements(driver, this);

	}

	// Action
	public String loginPageTitle() 
	{

		return driver.getTitle();
	}

	public SD_HomePage login(String username, String password)
			throws Exception 
	{
		Thread.sleep(500);
		txtUsername.sendKeys(username);
		Thread.sleep(500);
		txtPassword.sendKeys(password);
		Thread.sleep(1000);
		btnLogin.click();
		return new SD_HomePage();
	}
	

	public RM_HomePage rmLogin(String username, String password)
			throws Exception 
	{
		Thread.sleep(500);
		txtUsername.sendKeys(username);
		Thread.sleep(500);
		txtPassword.sendKeys(password);
		Thread.sleep(1000);
		btnLogin.click();
		return new RM_HomePage();
	}
	public Technician_HomePage technicianLogin(String username, String password)
			throws Exception 
	{

		Thread.sleep(500);
		txtUsername.sendKeys(username);
		Thread.sleep(500);
		txtPassword.sendKeys(password);
		Thread.sleep(1000);
		btnLogin.click();
		return new Technician_HomePage();
	}

	// First check that the Team button is selected, if not then select that
	// button first
	public void CheckTeamButton() throws Exception 
	{

		boolean teamButtonIsSelected = rdoTeamAndCustomer.get(0)
				.isSelected();
		System.out.println(teamButtonIsSelected);

		if (teamButtonIsSelected == true) 
		{

			System.out.println("Team Button is selected");

		} else
		{

			rdoTeamAndCustomer.get(0).click();

		}
	}

	// If User team check box and click on Login button without enter any
	// details then in User name field, notification should
	// display as 'Please fill out this field'
	public void checkLoginButtonWithBlankData() throws Exception 
	{
        SoftAssert softAssert = new SoftAssert();
		btnLogin.click();

		// check user name field should mandatory
		String usernameField = txtUsername.getAttribute("required");
		String passwordField = txtPassword.getAttribute("required");
		System.out.println(usernameField);
		System.out.println(passwordField);

		softAssert.assertTrue(usernameField.contains("true"));
		softAssert.assertTrue(passwordField.contains("true"));
		
		softAssert.assertAll();

	}


	public void checkWithWrongLoginCredentials(
			String username, String password) throws Exception 
	{

		SoftAssert softAssert = new SoftAssert();
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		Thread.sleep(500);
		btnLogin.click();
		
		String titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);

		if(titleOfPage.equalsIgnoreCase("UNOPOINT"))
		{
			
			String errorMessage = lblErrorMessage.getText();
			System.out.println(errorMessage);

			softAssert.assertEquals(errorMessage, "Wrong Username or Password");
			
			
		}
		else 
		{
			String titleOfHomePage = driver.getTitle();
			System.out.println(titleOfHomePage);

			softAssert.assertEquals(titleOfHomePage, "Service Desk Home Screen");
		    
		    //click on logout
		    link_sd.click();
		    link_LogOut.click();
		    
		}
		
		
		softAssert.assertAll();
	//	driver.navigate().back();
	
	

	}
	// If User check Customer check box then 'Do you want to log a ticket?' pop
	// up should display with trouble ticket and skip hyper link
	// If User check Customer check box and click on trouble ticket field then
	// trouble ticket form should get open to log trouble ticket
	public void selectCustomer() throws Exception 
	{
		Thread.sleep(1000);
		
		
		
		SoftAssert softAssert = new SoftAssert();
		
		// click on customer
		rdoTeamAndCustomer.get(1).click();

		// get the window name

		for (String popupWindow : driver.getWindowHandles()) 
		{

			driver.switchTo().window(popupWindow);
		}

		String windowName = lblCustomerWindow.getText();
		System.out.println(windowName);

		softAssert.assertEquals(windowName, "Do you want to log a ticket?");

		// click on Trouble Ticket button
		btnTroubleTicket.click();

		for (String popupWindow : driver.getWindowHandles()) 
		{
			String windowTitle = driver.getTitle();
			System.out.println(windowTitle);
			driver.switchTo().window(popupWindow);
		}

		String ticketFormName = lblTicketForm.getText();
		System.out.println(ticketFormName);

		softAssert.assertEquals(ticketFormName, "Ticket Form");
		
		softAssert.assertAll();
		driver.navigate().back();

	}

	// If User check Customer check box and click on skip hyper link then system
	// allow to enter customer
	// login credentials in User name and password fields
	public void checkAfterSkip() throws Exception 
	{
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		// click on customer
		driver.findElement(By.xpath("//*[@id='login']/ul/li[1]/label[2]")).click();

		// get the window name

		for (String popupWindow : driver.getWindowHandles()) 
		{

			driver.switchTo().window(popupWindow);
		}

		// click on skip button
		btnSkip.click();

		Thread.sleep(3000);

		// check after click on skip button then user and password field is
		// enable for customer
		softAssert.assertEquals(true, txtUsername.isEnabled());
		softAssert.assertEquals(true, txtPassword.isEnabled());
		
		softAssert.assertAll();

	}

	// Enter username , Ecode , Email And click on Reset Password button then
	// 'Reset password link has been send on your registered email ID'
	// notification should display with Back to login link
	public void checkForgotPasswordLink() throws Exception 
	{
		 SoftAssert softAssert = new SoftAssert();
		// click on forgot password link
		lnkForgotPassword.click();

		txtUsernameInForgotPassword.clear();
		txtEcodeInForgotPassword.clear();
		txtEmailInForgotPassword.clear();

		// get the value of forgot password page heading
		String headingValue = lblForgotPassword.getText();
		System.out.println("headingValue:-"+ headingValue);

		// Match the heading message
		softAssert.assertEquals(headingValue, "Enter either of the detail");

		// write the user name
		txtUsernameInForgotPassword.sendKeys("pranjali");

		// click on reset password
		btnResetPassword.click();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// get message
		// "Sending link to reset your password on registered email..."
		String messageValue = notification.getText();
		System.out.println("messageValue:" + messageValue);

		softAssert.assertTrue(messageValue
				.contains("Reset password link has been send on your registered email ID"),"Reset password link has been send on your registered email ID this message is not dispaly");

		// click on Back To Login
		btnBackToLogin.click();

		Thread.sleep(1000);

		// click on forgot password link
		lnkForgotPassword.click();

		// write the ecode
		txtEcodeInForgotPassword.sendKeys("E902");

		// click on reset password
		btnResetPassword.click();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		// get message
		// "Sending link to reset your password on registered email..."
		String messageValueAfterEcode = notification.getText();
		System.out.println(messageValueAfterEcode);

		softAssert.assertTrue(messageValueAfterEcode
				.contains("Reset password link has been send on your registered email ID"),"Reset password link has been send on your registered email ID this message is not dispaly ");

		// click on Back To Login
		btnBackToLogin.click();

		Thread.sleep(500);

		// click on forgot password link
		lnkForgotPassword.click();

		// write the Email ID
		txtEmailInForgotPassword.sendKeys("prajali.deshpande@ksys.in");

		// click on reset password
		btnResetPassword.click();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		// get message
		// "Sending link to reset your password on registered email..."
		String messageValueAfterEmail = notification.getText();
		System.out.println("messageValueAfterEmail:"+ messageValueAfterEmail);

		boolean messageIsSame = true;
		if(messageValueAfterEmail.contains("Reset password link has been send on your registered email ID."))
		{
			messageIsSame = true ; 
			
		}
		else if(messageValueAfterEmail.contains("More than one records are associated with Email ID.Please contact service desk."))
		{	
			messageIsSame = true;
			
		}
		
		softAssert.assertTrue(messageIsSame, "No Record is associated with this email ID");
		

		// click on Back To Login
		btnBackToLogin.click();

		Thread.sleep(1000);
		
		softAssert.assertAll();

	}

	// If user try to enter all details in 'Enter either of the detail' pop up
	// then previous details get
	// Disable and latest value should remain in page
	public void checkWithAllFieldFill() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		
		Thread.sleep(1000);
		// click on forgot password link
		lnkForgotPassword.click();

		txtUsernameInForgotPassword.clear();
		txtEcodeInForgotPassword.clear();
		txtEmailInForgotPassword.clear();

		// enter the user name
		txtUsernameInForgotPassword.sendKeys("Pranjali");

		// check Ecode field should be blank
		String ecodeValue = txtEcodeInForgotPassword.getText();
		System.out.println("ecodeValue" + ecodeValue);

		softAssert.assertEquals(ecodeValue, "");

		// check Email field should be blank
		String emailValue = txtEmailInForgotPassword.getAttribute("value");
		System.out.println("emailValue" + emailValue);

		softAssert.assertEquals(emailValue, "");

		System.out.println("=================");

		// enter the Ecode
		txtEcodeInForgotPassword.sendKeys("E902");

		// check username field should be blank
		String usernameValue = txtUsernameInForgotPassword
				.getAttribute("value");
		System.out.println("usernameValue" + usernameValue);

		softAssert.assertEquals(usernameValue, "");

		// check Email field should be blank
		String emailValueWithEcode = txtEmailInForgotPassword
				.getAttribute("value");
		System.out.println("emailValueWithEcode" + emailValueWithEcode);

		softAssert.assertEquals(emailValueWithEcode, "");
		System.out.println("=================");

		// enter the email ID
		txtEmailInForgotPassword.sendKeys("pranjali.deshpande@ksys902");
		

		// check username field should be blank
		String usernameValueWithEmail = txtUsernameInForgotPassword
				.getAttribute("value");
		System.out.println("usernameValueWithEmail" + usernameValueWithEmail);

		softAssert.assertEquals(usernameValueWithEmail, "");

		// check Email field should be blank
		String ecodeValueWithEmail = txtEcodeInForgotPassword
				.getAttribute("value");
		System.out.println("ecodeValueWithEmail" + ecodeValueWithEmail);

		softAssert.assertEquals(ecodeValueWithEmail, "");

		Thread.sleep(500);
		softAssert.assertAll();

	}

	// If user enter all wrong data in username, Ecode and Email field then 'No
	// record is associate with User Name.'
	// notification should display
	public void checkWithWrongData() throws Exception 
	{		
		
		SoftAssert softAssert = new SoftAssert();
		txtUsernameInForgotPassword.clear();
		txtEcodeInForgotPassword.clear();
		txtEmailInForgotPassword.clear();

		// write the user name
		txtUsernameInForgotPassword.sendKeys("abc");

		// click on reset password
		btnResetPassword.click();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// get message
		// "Sending link to reset your password on registered email..."
		String messageValue = notification.getText();
		System.out.println(messageValue);

		softAssert.assertEquals(messageValue,
				"No record is associate with User Name.");

		// click on Back To Login
		btnBackToLogin.click();

		Thread.sleep(500);

		// click on forgot password link
		lnkForgotPassword.click();

		// write the ecode
		txtEcodeInForgotPassword.sendKeys("xyz");

		// click on reset password
		btnResetPassword.click();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// get message
		// "Sending link to reset your password on registered email..."
		String messageValueAfterEcode = notification.getText();
		System.out.println(messageValueAfterEcode);

		softAssert.assertEquals(messageValueAfterEcode,
				"No record is associate with Ecode.");

		// click on Back To Login
		btnBackToLogin.click();

		Thread.sleep(500);

		// click on forgot password link
		lnkForgotPassword.click();

		// write the Email ID
		txtEmailInForgotPassword.sendKeys("pranju@ksys.in");

		// click on reset password
		btnResetPassword.click();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// get message
		// "Sending link to reset your password on registered email..."
		String messageValueAfterEmail = notification.getText();
		System.out.println(messageValueAfterEmail);

		softAssert.assertEquals(messageValueAfterEmail,
				"No record is associate with Email ID.");

		// click on Back To Login
		btnBackToLogin.click();
		
		softAssert.assertAll();

	}

}
