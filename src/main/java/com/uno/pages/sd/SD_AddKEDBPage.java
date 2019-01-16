package com.uno.pages.sd;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;

public class SD_AddKEDBPage extends BaseCode {

	// Drop down of Product Category
	@FindBy(css = "select[name='m_strProductCategory']")
	WebElement ddlProductCategory;

	// Drop down of sub Product Category
	@FindBy(css = "select[name='m_strSubProductCategory']")
	WebElement ddlSubProductCategory;

	// Text box of Known Error
	@FindBy(css = ".textarea[name='m_strDescription']")
	WebElement txtKnownError;

	// Text box of Work Around Details
	@FindBy(css = ".textarea[name='m_strDetail']")
	WebElement txtWorkAroundDetails;

	// Text box of Solution
	@FindBy(css = ".textarea[name='m_strSolution']")
	WebElement txtSolution;

	// Button of Add KEDB
	@FindBy(linkText = "Add KEDB")
	WebElement btnAddKEDB;

	// Notification of View Ticket Page
	@FindBy(css = "#dialogBoxSuccess")
	WebElement notification;

	// List of Known Error
	@FindBy(css = ".pad5:nth-of-type(1)")
	List<WebElement> lstKnownError;

	// List of Work Around Details
	@FindBy(css = ".pad5:nth-of-type(2)")
	List<WebElement> lstWorkAroundDetails;

	// List of Solution
	@FindBy(css = ".pad5:nth-of-type(3)")
	List<WebElement> lstSolution;

	// List of Product Category
	@FindBy(css = ".pad5:nth-of-type(5)")
	List<WebElement> lstProductCategory;

	// List of Sub Product Category
	@FindBy(css = ".pad5:nth-of-type(6)")
	List<WebElement> lstSubProductCategory;

	// Initializing Page Object
	public SD_AddKEDBPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkAlertWithoutEnteringDataOfKEDB() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		//Click on KEDB button
		btnAddKEDB.click();

		// get the message from that alert box
		Alert alert = driver.switchTo().alert();
		String alertMessageWithoutProductCategory = alert.getText();
		System.out.println("Alert Text:" + alertMessageWithoutProductCategory);
		Thread.sleep(2000);
		alert.accept();
		driver.switchTo().defaultContent();

		// verify that alert message
		softAssert.assertEquals(alertMessageWithoutProductCategory,
				"Please Select Product Category","Alert massage is not correct to select Product Category.");
		System.out.println("Both the message is equal");

		// Select Product Category
		Select productCategory = new Select(ddlProductCategory);
		ddlProductCategory.click();

		productCategory.selectByVisibleText("Demo");

		Thread.sleep(1000);

		// Click on Add KEDB
		btnAddKEDB.click();

		// get the message from that alert box
		String alertMessageWithoutSubProductCategory = alert.getText();
		System.out.println("Alert Text:"
				+ alertMessageWithoutSubProductCategory);
		Thread.sleep(2000);

		alert.accept();
		driver.switchTo().defaultContent();

		// verify that alert message
		softAssert.assertEquals(alertMessageWithoutSubProductCategory,
				"Please Select Sub Product Category", "Alert massage is not correct to select Sub  Product Category.");
		System.out.println("Both the message is equal");

		// Select sub Product Category

		Select subProductCategory = new Select(ddlSubProductCategory);
		Thread.sleep(1000);
		// dropdown_SubProductCategory.click();
		Thread.sleep(1000);
		subProductCategory.selectByValue("Test");

		Thread.sleep(2000);
		// Click on Add KEDB
		btnAddKEDB.click();

		// get the message from that alert box
		String alertMessageWithoutKnownError = alert.getText();
		System.out.println("Alert Text:" + alertMessageWithoutKnownError);
		Thread.sleep(2000);
		alert.accept();
		driver.switchTo().defaultContent();

		// verify that alert message
		softAssert.assertEquals(alertMessageWithoutKnownError,
				"Please Enter The Known Error", "Alert massage is not correct to Enter The Known Error");
		System.out.println("Both the message is equal");

		// Enter Known Error
		String knownError = "Abc";
		txtKnownError.sendKeys(knownError);

		Thread.sleep(1000);
		// Click on Add KEDB
		btnAddKEDB.click();
		// get the message from that alert box

		String alertMessageWithoutWorkAroundDetails = alert.getText();
		System.out
				.println("Alert Text:" + alertMessageWithoutWorkAroundDetails);
		Thread.sleep(2000);
		alert.accept();
		driver.switchTo().defaultContent();

		// verify that alert message
		softAssert.assertEquals(alertMessageWithoutWorkAroundDetails,
				"Please Enter Work Around Details", "Alert massage is not correct to Enter Work Around Details");
		System.out.println("Both the message is equal");

		// Enter Work Around Details
		String workAroundDetails = "Abc";
		txtWorkAroundDetails.sendKeys(workAroundDetails);

		Thread.sleep(1000);
		// Click on Add KEDB
		btnAddKEDB.click();

		// get the message from that alert box
		String alertMessageWithoutSolution = alert.getText();
		System.out.println("Alert Text:" + alertMessageWithoutSolution);
		Thread.sleep(2000);
		alert.accept();
		driver.switchTo().defaultContent();

		// verify that alert message
		softAssert.assertEquals(alertMessageWithoutSolution,
				"Please Enter The Solution", "Alert massage is not correct to Enter Solution.");
		System.out.println("Both the message is equal");
		softAssert.assertAll();

	}

	public void checkNotificationfterAddKEDBAndVerifyDataInKEDBTable() {
		SoftAssert softAssert = new SoftAssert();
		// Select Product Category
		Select productCategory = new Select(ddlProductCategory);
		ddlProductCategory.click();
		productCategory.selectByVisibleText("ATM");

		// Select sub Product Category
		Select subProductCategory = new Select(ddlSubProductCategory);
		// dropdown_SubProductCategory.click();
		subProductCategory.selectByVisibleText("ATM");

		// Enter Known Error
		String knownError = "Abc";
		txtKnownError.sendKeys(knownError);

		// Enter Work Around Details
		String workAroundDetails = "Abc";
		txtWorkAroundDetails.sendKeys(workAroundDetails);

		// Enter Solution
		String solution = "Abc";
		txtSolution.sendKeys(solution);

		// Click on Add KEDB
		btnAddKEDB.click();

		// Get notification
		String notificationText = notification.getText();
		System.out.println(notificationText);

		// Verify notification
		softAssert.assertEquals(notificationText, "KEDB added successfully.!",
				"Notification is not Match");
		
		// Get Known Error
		String KnownErrorText = lstKnownError.get(0).getText();
		System.out.println("KnownErrorText: " + KnownErrorText);

		// Get Work Around Details
		String workAroundDetailsText = lstWorkAroundDetails.get(0).getText();
		System.out.println("WorkAroundDetails: " + workAroundDetailsText);

		// Get solution Text
		String solutionText = lstSolution.get(0).getText();
		System.out.println("solutionText: " + solutionText);

		// Get Product Category Text
		String productCategoryText = lstProductCategory.get(0).getText();
		System.out.println("productCategoryText: " + productCategoryText);

		// Get Sub Product Category Text
		String subProductCategoryText = lstSubProductCategory.get(0)
				.getText();
		System.out.println("subProductCategoryText: " + subProductCategoryText);

		// Verify Known Error
		softAssert.assertEquals(KnownErrorText, knownError,
				"Known Error is not Same.");
		// Verify Work Around Details
		softAssert.assertEquals(workAroundDetailsText, workAroundDetails,
				"Work Around Details is not Same.");
		// Verify solution
		softAssert.assertEquals(solutionText, solution, "solution is not Same.");
		// Verify Product Category
		softAssert.assertEquals(productCategoryText, "ATM",
				"Product Category is not Same.");
		// Verify Sub Product Category
		softAssert.assertEquals(subProductCategoryText, "ATM",
				"Sub Product Category is not Same.");

	}

}
