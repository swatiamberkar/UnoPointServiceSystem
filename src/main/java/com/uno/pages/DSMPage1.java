package com.uno.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.uno.baseClass.BaseCode;

public class DSMPage1 extends BaseCode{
	
	//DSM
	
	@FindBy(css = "div[id='header']>button>span")
	WebElement btnHome;
	
	@FindBy(css = "div[class='nano-content']>ul>li:nth-of-type(2)>a")
	WebElement btnTask;
	
	@FindBy(css = "div[class='nano-content']>ul>li:nth-of-type(2)>ul>li:nth-of-type(2)>a")
	WebElement btnViewTask;
	 
		@FindBy(xpath = ".//*[@id='headingText']/ul/li[4]/a")
		WebElement btnSearchTask;
		
		
		@FindBy(name = "m_strSearchAssetId")
		WebElement txtSiteCode;
		
		
		@FindBy(xpath = ".//*[@id='headingText']/ul/li[4]/div/table/tbody/tr[5]/td[3]/a")
		WebElement btnSiteCodeGo;
		
		@FindBy(css = "select[name='m_strProjectName']")
		WebElement ddlProject;
		
		@FindBy(css = "select[name='m_strFillterCustomerName']")
		WebElement ddlSubProject;
		
		@FindBy(css = "select[name='m_strActivityNameForFilter']")
		WebElement ddlActivityName;
		
		@FindBy(css = "div[class='fht-tbody']>table>tbody>tr:nth-of-type(1)>td:nth-of-type(1)>div>a")
		WebElement lnkTaskID;
		
		@FindBy(xpath = ".//*[@id='right']/div[4]/div/div[2]/div[2]/table/tbody/tr/td[12]")
		List<WebElement> lstActivityName;
		
		@FindBy(xpath = ".//*[@id='right']/div[4]/div/div[1]/div[2]/table/tbody/tr/td[1]/div/a")
		List<WebElement> lstTaskID;
		
		@FindBy(xpath = ".//*[@id='right']/div[4]/div/div[1]/div[2]/table/tbody/tr/td[1]/a")
		List<WebElement> lstTaskID1;

		
		
		@FindBy(linkText = "Person Details")
		WebElement btnPersonDetails;
		
		@FindBy(xpath = ".//*[@id='Technician-Assign']/div[1]/div/table/tbody/tr[1]/td[2]")
		WebElement lblPrimaryPerson;
		
		
		@FindBy(linkText = "Edit")
		WebElement btnEdit;
		
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div[1]/table/tbody/tr[2]/td[2]/img")
		WebElement btnPrimaryPerson;
		
		@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr[2]/td[3]/a")
		WebElement lnkPersonName1;
		
		@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr[3]/td[3]/a")
		WebElement lnkPersonName2;
		
		@FindBy(linkText = "Update Details")
		WebElement btnUpdateDetails;
		
		@FindBy(linkText = "Timings & Status")
		WebElement btnTimingAndStatus;
		
		@FindBy(xpath = ".//*[@id='fd-but-dp-8']/span[1]")
		WebElement btnASDCalendar;
		
		@FindBy(css = "table[class='datePickerTable']>tbody>tr>td")
		List<WebElement> dtpASDCalendar;
		
		@FindBy(css = "select[name='m_strResponseTimeHour']>option")
		List<WebElement> ddlTimeHour;
		
		@FindBy(css = "select[name='m_strResponseTimeMin']>option")
		List<WebElement> ddlTimeMin;
		
		@FindBy(linkText = "Activity")
		WebElement btnActivity;
		
		@FindBy(xpath = ".//*[@id='m_strDropDown1']")
		WebElement ddlFeasibilityStatus;

		@FindBy(xpath = ".//*[@id='m_strDropDown2']")
		WebElement ddlFeasibilityType;
		
		@FindBy(xpath = ".//*[@id='m_strDropDown3']")
		WebElement ddlNONFeasibleType ;
		
		@FindBy(xpath = ".//*[@id='m_strDropDown4']")
		WebElement ddlServerRoomReadinesStatus;
		
		@FindBy(xpath = ".//*[@id='m_strDropDown7']")
		WebElement ddlFesibilityStatusReport;
		
		@FindBy(xpath = ".//*[@id='m_strDropDown5']")
		WebElement ddlUPSEarthingStatus;
		
		@FindBy(css = "input[class='btn btn-success btn-block' ]")
		WebElement btnSaveActivity;
		
		@FindBy(linkText = "Closure")
		WebElement btnClosure;
		
		@FindBy(name = "m_strClosureType")
		WebElement ddlCloseType;
		
		@FindBy(name = "m_strClosureDescription")
		WebElement txaClosureDescription;
		
		@FindBy(linkText = "Close")
		WebElement btnClose;
	public DSMPage1() {
		PageFactory.initElements(driver, this);
	}

	
	
	public void applyFilter() throws Exception
	{
		btnHome.click();
		Thread.sleep(500);
		btnTask.click();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		btnViewTask.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='right']/div[2]/span")).click();
		Select project = new Select(ddlProject);
		project.selectByValue("BOI-P1 Implementation");
		Thread.sleep(1000);
		
/*		Select subProject = new Select(ddlSubProject);
		subProject.selectByValue("Vadodara");
		Thread.sleep(1000);
		
		Select activityName = new Select(ddlActivityName);
		activityName.selectByValue("Hardware Supply");
		Thread.sleep(1000);
		*/
		
		
	}
	public void updateActivity(String siteCode) throws Exception
	{
		
		btnSearchTask.click();
		Thread.sleep(200);
		txtSiteCode.clear();
		System.out.println("siteCode: "+siteCode);
		txtSiteCode.sendKeys(siteCode);
		btnSiteCodeGo.click();
		
		Thread.sleep(500);
		
		int size =lstActivityName.size();
		for (int i = 0; i < size; i++) {
			scrollDown(lstActivityName.get(i));
			String activity =lstActivityName.get(i).getText();
			System.out.println("activity: "+activity);
			if(activity.equalsIgnoreCase("Hardware Supply"))
			{
				System.out.println("I "+i);
				String activity1 =lstActivityName.get(i).getText();
				System.out.println("activity: "+activity1);
				highLight(lstActivityName.get(i));
				
				try {
					scrollDown(lstTaskID1.get(i));
					Thread.sleep(500);
					highLight(lstTaskID1.get(i));
					String id =lstTaskID1.get(i).getText();
					System.out.println("id: "+id);
					driver.findElement(By.linkText(id)).click();
					
					
				} catch (Exception e) {
					scrollDown(lstTaskID.get(i));
					Thread.sleep(500);
					highLight(lstTaskID.get(i));
					String id =lstTaskID.get(i).getText();
					System.out.println("id: "+id);
					driver.findElement(By.linkText(id)).click();
					
				}
				//lstTaskID.get(i).click();
				break;
				
			}
			
		}
		       
		       btnPersonDetails.click();
		       
		       String name = lblPrimaryPerson.getText();
		       System.out.println("name: "+name);
		       if(name.equalsIgnoreCase("Vaishali"))
		       {
		    	   Thread.sleep(500);
					driver.findElement(By.linkText("Back")).click();
					Thread.sleep(500);
		       }
		       else
		       {
		       btnEdit.click();
		       for (String technicianWindow : driver.getWindowHandles()) {

					driver.switchTo().window(technicianWindow);

				Thread.sleep(1000);
		       btnPrimaryPerson.click();
		       for (String technicianWindow1 : driver.getWindowHandles()) {

					driver.switchTo().window(technicianWindow1);

				}
		       Thread.sleep(500);
		       lnkPersonName2.click();
		       driver.switchTo().window(technicianWindow); 
		       btnUpdateDetails.click();
		       
		        
		       
		       
		       }
		       
		       
		     
				Thread.sleep(500);
				driver.findElement(By.linkText("Back")).click();
				Thread.sleep(500);

				
		       }
	
		
		
	}
}
