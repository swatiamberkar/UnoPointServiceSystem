package com.uno.test.technician;

import io.qameta.allure.Description;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.technician.Technician_HomePage;
import com.uno.pages.technician.Technician_IncidentPage;
import com.uno.pages.technician.Technician_MyAvailabilityPage;

public class Technician_MyAvilabilityTest  extends BaseCode
{
	String currentDir = System.getProperty("user.dir");
	SD_LoginPage loginpage;
	Technician_IncidentPage incidentPageOfTechnicianRole;
	Technician_MyAvailabilityPage myAvailabilityPageOfTechnicianLogin;
	Technician_HomePage technician_HomePage;
	
	public Technician_MyAvilabilityTest()
	{
		super();
	}
	
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
			 initialization();

			 loginpage= new SD_LoginPage();
			 technician_HomePage = loginpage.technicianLogin(properties.getProperty("loginIdForTech"), properties.getProperty("password"));
		
			
		}
		@BeforeMethod(alwaysRun = true)
		public void avilability(Method method) throws Exception {

			String path = currentDir + "/Recording/" + method.getName();
			startRecording(path, method.getName());

			Thread.sleep(1000);
			technician_HomePage = new Technician_HomePage();
			Thread.sleep(1000);
			scrollDown(driver.findElement(By
					.cssSelector("a[href='/erprmwise/TechnicianHomeScreen.do']")));
			driver.findElement(
					By.cssSelector("a[href='/erprmwise/TechnicianHomeScreen.do']"))
					.click();
			 incidentPageOfTechnicianRole=technician_HomePage.incidentTab();
		     Thread.sleep(1000);
		     myAvailabilityPageOfTechnicianLogin =  incidentPageOfTechnicianRole.MyAvailabilityTab();
			 Thread.sleep(1000);
			Thread.sleep(1000);


	}
	@Test(priority=1, groups = { "My Availability"} ,description = "If User click on My Availability tab, then View My Availability page should get open with last login details" )
	@Description("If User click on My Availability tab, then View My Availability page should get open with last login details")
	public void CheckHeadingOfPage() throws Exception
	{
		myAvailabilityPageOfTechnicianLogin.checkHeadingOfPage();
		
	}

	@Test(priority=2, groups = { "My Availability"} , description =  "In Total Opening Balance Of This Month column value should display as per"
			+ " Total leaves assign in employee master -> employee Details for employee login." )
	@Description("In Total Opening Balance Of This Month column value should display as per"
			+ " Total leaves assign in employee master -> employee Details for employee login.")
	public void MatchTotalOpeningBalanceWithSuperRole() throws Exception
	{
		myAvailabilityPageOfTechnicianLogin.matchTotalOpeningBalanceWithSuperRole();
		
	}
	
	
	
	@Test
	public void doTechnicianLogin() throws Exception
	{
		 myAvailabilityPageOfTechnicianLogin.technicianLogin();
	
	}
	@Test
	public void ApplyLeave() throws Exception
	{
		 myAvailabilityPageOfTechnicianLogin.applyLeave();
	
	}
	
	@AfterMethod
	public void writeResult(ITestResult result,Method method) throws Exception 
	{
		stopRecording();
		String path= currentDir + "/Recording/"+method.getName();
		changeFileName(path,method.getName());

		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======PASS======");
			}

			else if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======FAIL======");

				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);

				String currentDir = System.getProperty("user.dir");

				FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
						+ result.getMethod().getMethodName() + ".jpg"));
				
				scrollDown(driver.findElement(By.cssSelector("a[href='/erprmwise/TechnicianHomeScreen.do']")));
				driver.findElement(By.cssSelector("a[href='/erprmwise/TechnicianHomeScreen.do']")).click();

			

			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("================");
				System.out.println(result.getMethod().getMethodName());
				System.out.println("======Skip======");
				
				
				driver.quit();
				initialization();

				loginpage= new SD_LoginPage();
				technician_HomePage = loginpage.technicianLogin(properties.getProperty("loginIdForTechnician"), properties.getProperty("password"));
				 incidentPageOfTechnicianRole=technician_HomePage.incidentTab();
			     Thread.sleep(1000);
			     myAvailabilityPageOfTechnicianLogin =  incidentPageOfTechnicianRole.MyAvailabilityTab();
				 Thread.sleep(1000);

			}
		} catch (Exception e) 
		{
			
			initialization();

			loginpage= new SD_LoginPage();
			technician_HomePage = loginpage.technicianLogin(properties.getProperty("loginIdForTechnician"), properties.getProperty("password"));
			 incidentPageOfTechnicianRole=technician_HomePage.incidentTab();
		     Thread.sleep(1000);
		     myAvailabilityPageOfTechnicianLogin =  incidentPageOfTechnicianRole.MyAvailabilityTab();
			 Thread.sleep(1000);
		
		}

	}

	@AfterClass
	public void TearDown() {
		
		driver.quit();
	}

}
	

