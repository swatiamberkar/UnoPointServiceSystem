package com.uno.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;











import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.uno.baseClass.BaseCode;

public class DSMPage extends BaseCode{
	
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
		
		@FindBy(linkText = "Edit")
		WebElement btnEdit;
		
		@FindBy(xpath = ".//*[@id='incidentTypeDetails']/div[1]/table/tbody/tr[2]/td[2]/img")
		WebElement btnPrimaryPerson;
		
		@FindBy(xpath = ".//*[@id='right']/div/table/tbody/tr[2]/td[3]/a")
		WebElement lnkPersonName;
		
		@FindBy(xpath = ".//*[@id='Technician-Assign']/div[1]/div/table/tbody/tr[1]/td[2]")
		WebElement lblPrimaryPerson;
		
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
	public DSMPage() {
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
		activityName.selectByValue("Link shifting");
		Thread.sleep(1000);*/
		
		
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
			if(activity.equalsIgnoreCase("Feasibility Check"))
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
				break;
				
			}
			
		}
		//lnkTaskID.click();
		
	//WebElement link = driver.findElement(By.cssSelector("a[href='/uppmv3/ViewSingleIncident.do?action=First&m_strIncidentID=14&SO=Amritsar&LOT=Phase 1&PONumber=&PODate=&POCompletionPeriod=&DateOfPOReceived=&DO=&PinCode=&randomid=0.8151871292777377']"));
	/* highLight(lnkTaskID);
	 lnkTaskID.click();*/
	// Thread.sleep(2000);
	 /*Actions action = new Actions(driver);
	 WebElement element = driver.findElement(By.xpath(".//*[@id='right']/div[4]/div/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/a"));
	 action.contextClick(element).build().perform();
	 
	Action act = new Action(driver);
		((Object) act).contextClick(lnkTaskID).perform();
		act.sendkey("t").perform(); 
		Thread.sleep(500);*/
		/* Actions action = new Actions(driver);
		 By locator = By.xpath(".//*[@id='right']/div[4]/div/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/a");
		               
	
		 //Wait for the element. Used Explicit wait
		                WebDriverWait wait = new WebDriverWait(driver, 5);
		                wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
		                WebElement rightClickElement=driver.findElement(locator);
		                //contextClick() method to do right click on the element
		                action.contextClick(rightClickElement).build().perform();
		                
		            	Thread.sleep(1000); */        
		       btnPersonDetails.click();
		       String name = lblPrimaryPerson.getText();
		       System.out.println("name: "+name);
		       if(!name.isEmpty())
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
		       lnkPersonName.click();
		       driver.switchTo().window(technicianWindow); 
		       btnUpdateDetails.click();
		       
		        
		       
		       
		       }
		       
		       
		       btnTimingAndStatus.click();
		       btnEdit.click();
		  
		       
		    // Get System Date
				Calendar mydate = new GregorianCalendar();
				int dayOfMonth = mydate.get(Calendar.DAY_OF_MONTH);
				System.out.println(dayOfMonth);
				String currentDay = Integer.toString(dayOfMonth);

			     btnASDCalendar.click();
				// select Date in Calendar

				for (WebElement day : dtpASDCalendar) {

					String dayInCalender = day.getText();

					if (dayInCalender.equalsIgnoreCase(currentDay)) {

						Thread.sleep(1000);
						day.click();
						String getDateValue = day.getText();
						System.out.println("Select the date:-" + getDateValue);

						break;
					}

				}

				Calendar calendar = Calendar.getInstance();
				String currentHrs = new SimpleDateFormat("HH").format(calendar
						.getTime());
				System.out.println(currentHrs);
				
				
				// Get System Date
				Calendar hrs = new GregorianCalendar();
				int hrs1 = hrs.get(Calendar.HOUR) + 1;
				System.out.println(hrs1);
			
				
				
				// Get System Date
				Calendar min1 = new GregorianCalendar();
				int min2 = min1.get(Calendar.MINUTE) + 1;
				System.out.println(min2);
				String min3 = Integer.toString(min2);

				if (min3.length() == 1) {
					min3 = "0" + min3;
					System.out.println("min3: " + min3);
				}

				

				
				// select Hrs in Drop down

				for (WebElement hrsofSystem : ddlTimeHour) {

					String hrsInDropdown = hrsofSystem.getText();

					if (hrsInDropdown.equalsIgnoreCase(currentHrs)) {

						Thread.sleep(1000);
						hrsofSystem.click();
						String getDateValue = hrsofSystem.getText();
						System.out.println("Select the hrs:-" + getDateValue);

						break;
					}

				}

				/*// select Min in Drop down

				for (WebElement minOfSystem : ddl) {

					String minInDropdown = minOfSystem.getText();

					if (minInDropdown.equalsIgnoreCase(min3)) {

						Thread.sleep(1000);
						minOfSystem.click();
						String getDateValue = minOfSystem.getText();
						System.out.println("Select the min:-" + getDateValue);
						break;
					}

				}*/

				driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
				btnUpdateDetails.click();
				
				btnActivity.click();
				btnEdit.click();
				
				
				Select feasibilityStatus = new Select(ddlFeasibilityStatus);
				//feasibilityStatus.selectByValue("Feasible");
				feasibilityStatus.selectByValue("Not Feasible");
				
				Thread.sleep(1000);
				
				Select feasibilityType = new Select(ddlFeasibilityType);
				//feasibilityType.selectByValue("MLLN ");
				feasibilityType.selectByValue("Non MLLN");
				
				
				Select nonFeasibleType = new Select(ddlNONFeasibleType);
				nonFeasibleType.selectByValue("NA");
				
				Select serverRoomReadinesStatus = new Select(ddlServerRoomReadinesStatus);
				serverRoomReadinesStatus.selectByValue("Yes");
				
				Select uPSEarthingStatus = new Select(ddlUPSEarthingStatus);
				uPSEarthingStatus.selectByValue("Yes");
				
				Select fesibilityStatusReport = new Select(ddlFesibilityStatusReport);
				fesibilityStatusReport.selectByValue("Yes");
				
				Thread.sleep(500);
				scrollDown(btnSaveActivity);
				btnSaveActivity.click();
				
				Alert alert = driver.switchTo().alert();
				Thread.sleep(1000);
				// Get Alert message
				String alertMsg = alert.getText();
				System.out.println(alertMsg);
				alert.accept();
				
				driver.switchTo().defaultContent();
				
				btnClosure.click();
				
				Select closeType = new Select(ddlCloseType);
				closeType.selectByValue("Close");
				Thread.sleep(500);
				
				txaClosureDescription.sendKeys("Close");
				btnClose.click();
				Thread.sleep(500);
				driver.findElement(By.linkText("Back")).click();
				Thread.sleep(500);
		       }
		
	}
}
