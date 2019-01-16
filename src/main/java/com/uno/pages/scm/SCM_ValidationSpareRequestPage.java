package com.uno.pages.scm;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;
import com.uno.pages.BasicFlowPage;

public class SCM_ValidationSpareRequestPage extends BaseCode {
 
 public static String spareRequestIdInSCM;
 public static int countValue;
 public static int countValueOfValidSpareRequests;
 public static int countValueOfInvalidSpareRequests;
 BasicFlowPage demo;

 //take the variable in SCM spare request summary tab 
 @FindBy(xpath = ".//*[@id='Incidents-Summary']/div/div/ul/li[1]/ul/li[1]/a/span")
 WebElement count_SpareRequestsOpen;
 
 @FindBy(xpath = ".//*[@id='Incidents-Summary']/div/div/ul/li[1]/ul/li[2]/a/span")
 WebElement count_ValidSpareRequests;
 
 @FindBy(xpath = ".//*[@id='Incidents-Summary']/div/div/ul/li[1]/ul/li[3]/a/span")
public
 WebElement count_InvalidSpareRequests;
 
 // select spare request status
 @FindBy(name = "m_strFilterSpareRequestStatus")
 WebElement dropdown_SpareRequestStatus;

 // click on view button
 @FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr[2]/td[17]/a/span")
 WebElement button_View;

 // get the list of spare request ID
 @FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[1]")
 List<WebElement> list_SpareRequestID;

 // get the list of spare Request Status
 @FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[12]")
 List<WebElement> list_SpareRequestStatus;

 // select Approve button in SCM test status
 @FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[16]/a[1]")
 List<WebElement> button_Approve;

 // select Approve button in SCM test status
 @FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[16]/a[2]")
 List<WebElement> button_Reject;
 
 // select Approve button in SCM test status
 @FindBy(xpath = ".//*[@id='departmentForm']/table/tbody/tr/td[16]")
 List<WebElement> list_TestStatus;

 // click on reject button
 @FindBy(name = "m_strReason")
 WebElement textbox_ReasonForRejectSpare;

 // click on reject button
 @FindBy(xpath = ".//*[@id='boxa']/div/a[1]/span")
 WebElement button_RejectInReasonPopUp;

 // Notification of View Ticket Page
 @FindBy(css = "#dialogBoxSuccess")
 WebElement notification;

 public SCM_ValidationSpareRequestPage() {
  PageFactory.initElements(driver, this);

 }

 public void checkDescendingOrderOfSpareRequestIdInSCM() throws Exception {

  Thread.sleep(1000);
  int sizeOfSpareRequestId = list_SpareRequestID.size();
  System.out.println(sizeOfSpareRequestId);

  for (int i = 0; i < sizeOfSpareRequestId - 1; i++) {

   ((JavascriptExecutor) driver).executeScript(
     "arguments[0].scrollIntoView(true);",
     list_SpareRequestID.get(i));

   String getSpareRequestID1 = list_SpareRequestID.get(i).getText();
   System.out.println(getSpareRequestID1);
   Matcher m = Pattern.compile("\\d+").matcher(getSpareRequestID1);
   m.find();
   String textOfFirstID = m.group(0);
   System.out.println(textOfFirstID);
   int firstID = Integer.parseInt(textOfFirstID);
   System.out.println(firstID);

   String getSpareRequestID2 = list_SpareRequestID.get(i + 1)
     .getText();
   System.out.println(getSpareRequestID2);
   Matcher m2 = Pattern.compile("\\d+").matcher(getSpareRequestID2);
   m2.find();
   String textOfSecondID = m2.group(0);
   System.out.println(textOfSecondID);
   int secondID = Integer.parseInt(textOfSecondID);
   System.out.println(secondID);

   try {
    if (firstID < secondID) 
    {
     System.out.println("Pass");
    }

   }

   catch (Exception e)
   {
    System.out.println("Fail");
   }

   if (sizeOfSpareRequestId - 1 == i) {
    Assert.assertTrue(false, "spare request Id is not available");
   }
  }
 }

 // if the spare is approve by RM then in SCM it should showing the status is
 // open with Approve and Reject button is enable
 public void matchSpareRequestIdAndCheckApproveAndRejectButtonInSCM() throws Exception {


  Robot robot = new Robot();
  robot.keyPress(KeyEvent.VK_CONTROL);
  robot.keyPress(KeyEvent.VK_MINUS);
 // robot.keyPress(KeyEvent.VK_MINUS);

  //click on home tab
   driver.findElement(
        By.cssSelector("a[href='/erprmwise/LogisticExecutive.do']")).click();
      Thread.sleep(1000);
      
  //count Of Spare Request Open 
     String  countOfSpareRequestOpen = count_SpareRequestsOpen.getText();
     System.out.println("countOfSpareRequestOpen:-"+countOfSpareRequestOpen);
     countValue = Integer.parseInt(countOfSpareRequestOpen);
     System.out.println(countValue);
    
     //count Of Valid Spare Requests
     String  countOfValidSpareRequests = count_ValidSpareRequests.getText();
     System.out.println("countOfValidSpareRequests:-"+countOfValidSpareRequests);
     countValueOfValidSpareRequests = Integer.parseInt(countOfValidSpareRequests);
     System.out.println(countValueOfValidSpareRequests);
     
     
     count_SpareRequestsOpen.click();
     
  String latestSpareRequestIDInSD = BasicFlowPage.lastSpareRequestIDInSD;
  System.out.println("lastSpareRequestIDInSD: "
    + latestSpareRequestIDInSD);

     int sizeSpareRequestID = list_SpareRequestID.size();
  System.out.println(sizeSpareRequestID);
  for (int i = 0; i < sizeSpareRequestID; i++) {

      spareRequestIdInSCM = list_SpareRequestID.get(i).getText();
   System.out.println("sizeOfSpareRequestId: " + spareRequestIdInSCM);

   String statusValue = list_SpareRequestStatus.get(i).getText();
   System.out.println("status of Approved Request ID by RM"
     + statusValue);

   if (latestSpareRequestIDInSD.equalsIgnoreCase(spareRequestIdInSCM)
     && statusValue.contains("Open")) {

    String testStatusApprove = button_Approve.get(i).getText();
    System.out.println(testStatusApprove);

    String testStatusReject = button_Reject.get(i).getText();
    System.out.println(testStatusReject);

    boolean approveRejectIsPresent;
    if (testStatusApprove.equalsIgnoreCase("Approve")
      && testStatusReject.equalsIgnoreCase("Reject"))
    {

     System.out
       .println("The Approve and Reject button is present");
     approveRejectIsPresent = true;
            button_Approve.get(i).click();
            Assert.assertTrue(approveRejectIsPresent,
        "The Approve and Reject button is not present");

            break;
     

    }
   
   }
  }

 }
 
 // if click on Approve button then the test status is change to valid
 public void checkStatusOfSpareRequestAfterApproveInSCM() throws Exception {
	 SoftAssert softAssert = new SoftAssert();
	
  int sizeSpareRequestID = list_SpareRequestID.size();
  System.out.println(sizeSpareRequestID);

  for (int i = 0; i < sizeSpareRequestID; i++) 
  {
   String spareRequestId = list_SpareRequestID.get(i).getText();
   System.out.println("sizeOfSpareRequestId: " + spareRequestId);

   if (spareRequestIdInSCM.equalsIgnoreCase(spareRequestId))
   {

    String testStatusValue = list_TestStatus.get(i).getText();
    System.out.println("status of Approved Request ID by RM:-"
      + testStatusValue);

    softAssert.assertEquals(testStatusValue, "Valid");

    driver.findElement(
      By.cssSelector("a[href='/erprmwise/LogisticExecutive.do']"))
      .click();
    Thread.sleep(1000);

    String countOfSpareRequestOpen = count_SpareRequestsOpen
      .getText();
    System.out.println("countOfSpareRequestOpen:-"
      + countOfSpareRequestOpen);
                int countValueAfterApprove = Integer.parseInt(countOfSpareRequestOpen);
    System.out.println(countValueAfterApprove);
    
    String countOfValidSpareRequests = count_ValidSpareRequests
      .getText();
    System.out.println("countOfValidSpareRequests:-"
      + countOfValidSpareRequests);
                int countAfterApprove = Integer.parseInt(countOfValidSpareRequests);
    System.out.println(countAfterApprove);
    
    int decreaseCount = countValue-1;
    System.out.println(decreaseCount);
    
    int increaseCount = countValueOfValidSpareRequests+1;
    System.out.println(increaseCount);
    
    //check the count of spare request open , it should decrease by one
    softAssert.assertEquals(countValueAfterApprove, decreaseCount);
    
    //check the count of valid spare request , it should increase by one
    softAssert.assertEquals(countAfterApprove, increaseCount);
    
	WebElement html = driver.findElement(By.tagName("html"));
	html.sendKeys(Keys.chord(Keys.CONTROL, "0"));

	   softAssert.assertAll();
    break;
 
        
    
   }

  }
 }
 
 public void checkRejectButton() throws Exception
 {

  Robot robot = new Robot();
  robot.keyPress(KeyEvent.VK_CONTROL);
  robot.keyPress(KeyEvent.VK_MINUS);
 // robot.keyPress(KeyEvent.VK_MINUS);

  //click on home tab
   driver.findElement(
        By.cssSelector("a[href='/erprmwise/LogisticExecutive.do']")).click();
      Thread.sleep(1000);
      
  //count Of Spare Request Open 
     String  countOfSpareRequestOpen = count_SpareRequestsOpen.getText();
     System.out.println("countOfSpareRequestOpen:-"+countOfSpareRequestOpen);
     countValue = Integer.parseInt(countOfSpareRequestOpen);
     System.out.println(countValue);
    
     //count Of Valid Spare Requests
     String  countOfInvalidSpareRequests = count_InvalidSpareRequests.getText();
     System.out.println("countOfInvalidSpareRequests:-"+countOfInvalidSpareRequests);
     countValueOfInvalidSpareRequests = Integer.parseInt(countOfInvalidSpareRequests);
     System.out.println(countValueOfInvalidSpareRequests);
     
     
     count_SpareRequestsOpen.click();
     
  String secondLastSpareRequestIDInSD = BasicFlowPage.secondLastSpareRequestIDInSD;
  System.out.println("secondLastSpareRequestIDInSD: "
    + secondLastSpareRequestIDInSD);

     int sizeSpareRequestID = list_SpareRequestID.size();
  System.out.println(sizeSpareRequestID);
  for (int i = 0; i < sizeSpareRequestID; i++) {

      spareRequestIdInSCM = list_SpareRequestID.get(i).getText();
   System.out.println("sizeOfSpareRequestId: " + spareRequestIdInSCM);

   String statusValue = list_SpareRequestStatus.get(i).getText();
   System.out.println("status of Approved Request ID by RM"
     + statusValue);

   if (secondLastSpareRequestIDInSD.equalsIgnoreCase(spareRequestIdInSCM)
     && statusValue.contains("Open")) {

    String testStatusApprove = button_Approve.get(i).getText();
    System.out.println(testStatusApprove);

    String testStatusReject = button_Reject.get(i).getText();
    System.out.println(testStatusReject);

    boolean approveRejectIsPresent;
    if (testStatusApprove.equalsIgnoreCase("Approve")
      && testStatusReject.equalsIgnoreCase("Reject"))
    {

     System.out
       .println("The Approve and Reject button is present");
     approveRejectIsPresent = true;
     
            button_Reject.get(i).click();
            
            String reason = "Test";
      
     textbox_ReasonForRejectSpare.sendKeys(reason);

     button_RejectInReasonPopUp.click();
            
            Assert.assertTrue(approveRejectIsPresent,
        "The Approve and Reject button is not present");

            break;
     

    }
   
   }
  }

 }
 
 public void checkInvalidSpareCountAndTestStatus() throws Exception
 {
	 SoftAssert softAssert = new SoftAssert();
  int sizeSpareRequestID = list_SpareRequestID.size();
  System.out.println(sizeSpareRequestID);

  for (int i = 0; i < sizeSpareRequestID; i++) 
  {
   String spareRequestId = list_SpareRequestID.get(i).getText();
   System.out.println("sizeOfSpareRequestId: " + spareRequestId);

   if (spareRequestIdInSCM.equalsIgnoreCase(spareRequestId))
   {

    String testStatusValue = list_TestStatus.get(i).getText();
    System.out.println("status of Approved Request ID by RM:-"
      + testStatusValue);

    Assert.assertEquals(testStatusValue, "InValid");

    driver.findElement(
      By.cssSelector("a[href='/erprmwise/LogisticExecutive.do']"))
      .click();
    Thread.sleep(1000);

    String countOfSpareRequestOpen = count_SpareRequestsOpen
      .getText();
    System.out.println("countOfSpareRequestOpen:-"
      + countOfSpareRequestOpen);
                int countValueAfterApprove = Integer.parseInt(countOfSpareRequestOpen);
    System.out.println(countValueAfterApprove);
    
    String countOfInvalidSpareRequests = count_InvalidSpareRequests
      .getText();
    System.out.println("count_InvalidSpareRequests:-"
      + countOfInvalidSpareRequests);
                int countAfterApprove = Integer.parseInt(countOfInvalidSpareRequests);
    System.out.println(countAfterApprove);
    
    int decreaseCount = countValue-1;
    System.out.println(decreaseCount);
    
    int increaseCount = countValueOfInvalidSpareRequests+1;
    System.out.println(increaseCount);
    
    //check the count of spare request open , it should decrease by one
    softAssert.assertEquals(countValueAfterApprove, decreaseCount);
    
    //check the count of valid spare request , it should increase by one
    softAssert.assertEquals(countAfterApprove, increaseCount);
    
    softAssert.assertAll();
    
    break;
        
    
   }

  }
  
 }
 

}
 


