package com.uno.pages.sd;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;

public class SD_TicketSummaryPage extends BaseCode{
	
	public static List<WebElement> webElement;
	
	JavascriptExecutor javascript = (JavascriptExecutor) driver; 
	SD_TicketSummaryPage sd_TicketSummaryPage;
	SD_ViewTicketPage sd_ViewTicketPage;
	
//Select Open Tab
	@FindBy(linkText="Open")
	WebElement objectOfOpenTab;
	
//Select Work In Progress Tab
	@FindBy(linkText="Work In Progress")
	WebElement objectOfWorkInProgressTab;
	
//Select SLA Tab
	@FindBy(linkText="SLA")
	WebElement objectOfSLATab;
	
 //Select Resolved Tap
	@FindBy(linkText="Resolved")
	WebElement objectOfResolvedTab;
		
//Initializing Page Object
	public SD_TicketSummaryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
//Click on Ticket Summary Tab
	public void ticketSummaryTab()
	{
		boolean isOpenTab= objectOfOpenTab.isDisplayed();
		System.out.println("Open Tap is display with Blue Color: "+isOpenTab);
		
		boolean isWorkInProgressTab= objectOfWorkInProgressTab.isDisplayed();
		System.out.println("Work In Progress Tap is display with Yellow Color:"+isWorkInProgressTab);
		
		boolean isSLATab= objectOfSLATab.isDisplayed();
		System.out.println("SLA Tap is display with Pink Color:"+isSLATab);
		
		boolean isResolvedTab= objectOfResolvedTab.isDisplayed();
		System.out.println("Resolved Tap is display with Green Color:"+isResolvedTab);
		
	}

//Count of Requests Open Tap
	public void countOfRequestsOpenTab()
	{
		driver.findElement(By.cssSelector("a[onclick='submitOpen();']")).click();
		
		List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows=listOfRows.size();
		System.out.println("Number of Ticket: "+countOfRows);
		
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount  = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: "+actualTotalCount);
		Assert.assertEquals("countOfRows","actualTotalCount","Count is not match");
		
	}
	
//Total Count of Requests Open Tab
	public void totalCountOfRequestsOpenTab() throws Exception  
	{
		
		String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitOpen();']>span[class='badge']")).getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("Number of Request open "+count);
		
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(By.cssSelector("a[onclick='submitOpen();']")));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
				driver.findElement(By.cssSelector("a[onclick='submitOpen();']")));
		
		driver.findElement(By.cssSelector("a[onclick='submitOpen();']")).click();
	
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount  = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("Number of Total Ticket: "+actualTotalCount);
		
		Assert.assertEquals(count,actualTotalCount,"Count is not match");
		
		
	}
	
//Status of Requests Open Tab
	public void statusOfRequestsOpenTab()
	{
		driver.findElement(By.cssSelector("a[onclick='submitOpen();']")).click();
		
		List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows =listOfRows.size();
		for(int i=0;i<countOfRows;i++)
		{
			List<WebElement> listOfStatus =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(8)"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					listOfStatus.get(i));
			String status=listOfStatus.get(i).getText();
			Assert.assertEquals( status, "Open");
			System.out.println("Status of Request Open: "+status);
			
		}
	}	

//Count of UnAssigned Tab
	public void countOfUnAssignedTab() 
	{
		driver.findElement(By.cssSelector("a[onclick='submitunassigned();']")).click();
		
		List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows=listOfRows.size();
		System.out.println("Number of Ticket: "+countOfRows);
		
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText(); 
		String totalCount  = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("Number of Total Ticket: "+actualTotalCount);
		Assert.assertEquals("countOfRows","actualTotalCount","Count is not match");
		//Assert.assertNotEquals("countOfRows","actualTotalCount","Count is Not Match");
	}
	
//Total Count of UnAssigned Tab
	public void totalCountOfUnAssignedTab() 
	{
		String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitunassigned();']>span[class='badge']")).getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request UnAssigned "+count);
		
		
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(By.cssSelector("a[onclick='submitunassigned();']")));
		
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
				driver.findElement(By.cssSelector("a[onclick='submitunassigned();']")));
		
		driver.findElement(By.cssSelector("a[onclick='submitunassigned();']")).click();
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount  = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: "+actualTotalCount);
		Assert.assertEquals(count,actualTotalCount,"Count is not match");
		//Assert.assertNotEquals("count","actualTotalCount"," Not Match");
		
	}
	
//Status of UnAssigned Tab
	public void statusOfUnAssignedTab()
	{
		driver.findElement(By.cssSelector("a[onclick='submitunassigned();']")).click();
		
		List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows =listOfRows.size();
		
		for(int i=0;i<countOfRows;i++)
		{
			List<WebElement> listOfStatus =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(8)"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					listOfStatus.get(i));
			
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
					listOfStatus.get(i));
			String status=listOfStatus.get(i).getText();
			Assert.assertEquals("Open", status);
			System.out.println("Status of Request UnAssigned: "+status);
			
		}
	}
	
//Engineer of UnAssigned Tab
	public void engineerOfUnAssignedTab() 
	{
		driver.findElement(By.cssSelector("a[onclick='submitunassigned();']")).click();
		
		List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows =listOfRows.size();
		
		for(int i=0;i<countOfRows;i++)
		{
			List<WebElement> listOfEngineer =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(26)"));
			String engineer=listOfEngineer.get(i).getText();
			Assert.assertEquals("", engineer);
			System.out.println(engineer);
			
		}
	}	
	
//Count of Assigned But No ETA Tab
	public void countOfAssignedButNoETATab()     
	{
		driver.findElement(By.cssSelector("a[onclick='submitETAassing();']")).click();
		
		List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows=listOfRows.size();
		System.out.println("number of Ticket: "+countOfRows);
		
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount  = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: "+actualTotalCount);
		Assert.assertEquals("countOfRows","actualTotalCount","Count is not match");
		
	}
	
//Total Count of Assigned But No ETA Tab
	public void totalCountofAssignedButNoETATab() // count   
	{
		
		String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitETAassing();']>span[class='badge']")).getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request Assigned But No ETA "+count);
		
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(By.cssSelector("a[onclick='submitETAassing();']")));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
				driver.findElement(By.cssSelector("a[onclick='submitETAassing();']")));
		
		driver.findElement(By.cssSelector("a[onclick='submitETAassing();']")).click();
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount  = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: "+actualTotalCount);
		Assert.assertEquals(count,actualTotalCount,"Count is not match");
		
		
	}
	
//Status of Assigned But No ETA Tab
		public void statusOfAssignedButNoETATab() 
		{
			driver.findElement(By.cssSelector("a[onclick='submitETAassing();']")).click();
			
			List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
			Integer countOfRows =listOfRows.size();
			
			for(int i=0;i<countOfRows;i++)
			{
				List<WebElement> listOfStatus =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(8)"));
				String status=listOfStatus.get(i).getText();
				Assert.assertEquals("Open", status);
				System.out.println(status);
				
			}
		}
		
//Engineer of Assigned But No ETA Tab
		public void engineerOfAssignedButNoETATab() 
		{
			driver.findElement(By.cssSelector("a[onclick='submitETAassing();']")).click();
			
			List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
			Integer countOfRows =listOfRows.size();
			
			for(int i=0;i<countOfRows;i++)
			{
				List<WebElement> listOfEngineer =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(26)"));
				String engineer=listOfEngineer.get(i).getText();
				Assert.assertNotNull(engineer);
				System.out.println(engineer);
				
			}
		}	
		
//ETA Date of Assigned But No ETA Tab
		public void eTADateOfAssignedButNoETATab() throws Exception
		{
			driver.findElement(By.cssSelector("a[onclick='submitETAassing();']")).click();
			Thread.sleep(1000);		
			List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
			Integer countOfRows =listOfRows.size();
					
			for(int i=0;i<countOfRows;i++)
			{
			List<WebElement> listOfETADate =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)"));
			String eTADate=listOfETADate.get(i).getText();
			//Assert.assertNull(ETADate);
			Assert.assertEquals("", eTADate);
			System.out.println(eTADate);
						
			}
		}
		
//ETA Time of Assigned But No ETA Tab
		public void eTATimeOfAssignedButNoETATab()
		{
			driver.findElement(By.cssSelector("a[onclick='submitETAassing();']")).click();
					
			List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
			Integer countOfRows =listOfRows.size();
			for(int i=0;i<countOfRows;i++)
			{
			List<WebElement> listOfETATime =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(28)"));
			String eTATime=listOfETATime.get(i).getText();
			//Assert.assertNull(ETADate);
			Assert.assertEquals("00:00", eTATime);
			System.out.println(eTATime);
						
						
			}
		}
				
	
//Count of ETA Expired And No ATA Tab
	public void countOfETAExpiredAndNoATATab()     
	{
		driver.findElement(By.cssSelector("a[onclick='submitopenetaviolated();']")).click();
		
		List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows=listOfRows.size();
		System.out.println("number of Ticket: "+countOfRows);
		
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount  = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: "+actualTotalCount);
		Assert.assertEquals("countOfRows","actualTotalCount","Count is not match");
		
	}
	
//Total Count of ETA Expired And No ATA Tab
	public void totalCountOfETAExpiredAndNoATATab() 
	{
		
		String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitopenetaviolated();']>span[class='badge']")).getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request open "+count);
		
		
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(By.cssSelector("a[onclick='submitopenetaviolated();']")));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
				driver.findElement(By.cssSelector("a[onclick='submitopenetaviolated();']")));
		
		driver.findElement(By.cssSelector("a[onclick='submitopenetaviolated();']")).click();
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount  = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: "+actualTotalCount);
		Assert.assertEquals(count,actualTotalCount,"Count is not match");

		
	}
	
//Status of ETA Expired And No ATA Tab
			public void statusOfETAExpiredAndNoATATab() 
			{
				driver.findElement(By.cssSelector("a[onclick='submitopenetaviolated();']")).click();
				
				List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
				Integer countOfRows =listOfRows.size();
				//System.out.println("number of Request open "+totalRows);
				for(int i=0;i<countOfRows;i++)
				{
					List<WebElement> listOfStatus =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(8)"));
					String status=listOfStatus.get(i).getText();
					Assert.assertEquals("Open", status);
					System.out.println(status);
					
				}
			}
			
//Compare Time of ETA in ETA Expired And No ATA Tab
			public void compareTimeOfETAInETAExpiredAndNoATATab() throws Exception
			{
				driver.findElement(By.cssSelector("a[onclick='submitopenetaviolated();']")).click();
				
				List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
				int countOfRows =listOfRows.size();
				for(int i=0;i<countOfRows;i++)
				{
				
					String textOfDateFormat = "yyyy-MM-dd"; 
					SimpleDateFormat dateFormat = new SimpleDateFormat(textOfDateFormat);
					List<WebElement> listOfDate =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)"));
					String textOfDate=listOfDate.get(i).getText();
					Date dateOfETA = dateFormat.parse(textOfDate);
					String dateFormatOfETA= dateFormat.format(dateOfETA);
					Date date=dateFormat.parse(dateFormatOfETA);
					//System.out.println(date);
					
					String textOfTimeFormat = "HH:mm"; 
					SimpleDateFormat timeFormat = new SimpleDateFormat(textOfTimeFormat);
					List<WebElement> listOfTime =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(32)"));
					String textOfTime=listOfTime.get(i).getText();
					Date timeOfETA = timeFormat.parse(textOfTime);
					String timeFormatOfETA= timeFormat.format(timeOfETA);
					Date time=timeFormat.parse(timeFormatOfETA);
					//System.out.println(time);
					
					System.out.println("ETA Date & Time:"+dateFormatOfETA+"\n"+timeFormatOfETA+"\n");
					
					//get current date time with Date()
					 Date dateSystem = new Date();
				
					 String dateFormatOfSystem= dateFormat.format(dateSystem);
					 Date currentDate = dateFormat.parse(dateFormatOfSystem);
					 //System.out.println(dateFormatOfSystem);
					 //System.out.println(currentDate);
					 
					 String timeFormatOfSystem= timeFormat.format(dateSystem);
					 Date currentTime = timeFormat.parse(timeFormatOfSystem);
					 //System.out.println(timeFormatOfSystem);
					 //System.out.println(currentTime);
					  
					 System.out.println("System Date & Time:"+dateFormatOfSystem+"\n"+timeFormatOfSystem+"\n");
					  //if(date.compareTo(currentDate)>0 || time.compareTo(currentTime)>0)
					 
					  if(date.compareTo(currentDate)>0){
					    System.out.println("ETA Date & Time is After System Date & Time\n");
					  }
					  else if(date.compareTo(currentDate)<=0){
					    System.out.println("ETA Date & Time is Before System Date & Time\n");
					  }
					  else{
					    System.out.println("Something is Wrong");
					  }
				}
					 
				}
			
//ATA of ETA Expired And No ATA Tab
			public void aTAOfETAExpiredAndNoATATab()
			{
				driver.findElement(By.cssSelector("a[onclick='submitopenetaviolated();']")).click();
				
				List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
				Integer countOfRows =listOfRows.size();
				for(int i=0;i<countOfRows;i++)
				{
					List<WebElement> listOfATADate =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(33)"));
					String aTADate=listOfATADate.get(i).getText();
					Assert.assertEquals("", aTADate);
					System.out.println(aTADate);
				}
			}			
		



//Count of Work In Progress Tab
	public void countOfWorkInProgressTab() //     
	{
		driver.findElement(By.cssSelector("a[onclick='submitETAorATAassign();']")).click();
		
		List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows=listOfRows.size();
		System.out.println("number of Ticket: "+countOfRows);
		
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount  = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: "+actualTotalCount);
		Assert.assertEquals("countOfRows","actualTotalCount","Count is not match");
		
	}
	
//Total Count of Work In Progress Tab
	public void totalCountOfWorkInProgressTab() // count   
	{
		
		String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitETAorATAassign();']>span[class='badge']")).getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request  "+count);
		
		
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(By.cssSelector("a[onclick='submitETAorATAassign();']")));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
				driver.findElement(By.cssSelector("a[onclick='submitETAorATAassign();']")));
		
		driver.findElement(By.cssSelector("a[onclick='submitETAorATAassign();']")).click();
		String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount  = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: "+actualTotalCount);
		Assert.assertEquals(count,actualTotalCount,"Count is not match");
		
		
	}
	
	
//Status of Work In Progress Tab
	public void statusOfWorkInProgressTab() 
	{
		driver.findElement(By.cssSelector("a[onclick='submitETAorATAassign();']")).click();
		
		List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows =listOfRows.size();
		
		for(int i=0;i<countOfRows;i++)
		{
			List<WebElement> listOfStatus =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(8)"));
			String status=listOfStatus.get(i).getText();
			Assert.assertEquals("Open", status);
			System.out.println(status);
			
		}
	}
//ATA of Work In Progress Tab	
	public void aTAOfWorkInProgressTab() throws Exception
	{
		driver.findElement(By.cssSelector("a[onclick='submitETAorATAassign();']")).click();
		
		sd_ViewTicketPage = new SD_ViewTicketPage();
		sd_ViewTicketPage.setMyView();
		
		List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows =listOfRows.size();
		
		for(int i=0;i<countOfRows;i++)
		{
			List<WebElement> listOfATADate =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(33)"));
			String aTADate=listOfATADate.get(i).getText();
			Assert.assertNotNull(aTADate);
			System.out.println(aTADate);
			
		}
	}	
	
//Count of Requests Paused Tab
		public void countOfRequestsPausedTab()      
		{
			driver.findElement(By.cssSelector("a[onclick='submitPaused();']")).click();
			
			List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
			Integer countOfRows=listOfRows.size();
			System.out.println("number of Ticket: "+countOfRows);
			
			String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
			String totalCount  = textOfTotalCount.split(" ")[5];
			Integer actualTotalCount = Integer.parseInt(totalCount);
			System.out.println("number of Total Ticket: "+actualTotalCount);
			Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
			
		}
		
//Total Count of Requests Paused Tab
		public void totalCountOfRequestsPausedTab()   
		{
			
			String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitPaused();']>span[class='badge']")).getText();
			int count = Integer.parseInt(textOfCount);
			System.out.println("number of Request "+count);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);",
					driver.findElement(By.cssSelector("a[onclick='submitPaused();']")));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
					driver.findElement(By.cssSelector("a[onclick='submitPaused();']")));
			
			driver.findElement(By.cssSelector("a[onclick='submitPaused();']")).click();
			String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
			String totalCount  = textOfTotalCount.split(" ")[5];
			int actualTotalCount = Integer.parseInt(totalCount);
			System.out.println("number of Total Ticket: "+actualTotalCount);
			Assert.assertEquals(count,actualTotalCount,"Count is not match");
			
		}
		
//Status of Requests Paused Tab
		public void statusOfRequestsPausedTab() 
		{
			driver.findElement(By.cssSelector("a[onclick='submitPaused();']")).click();
			
			List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
			Integer countOfRows =listOfRows.size();
			//System.out.println("number of Request open "+totalRows);
			for(int i=0;i<countOfRows;i++)
			{
				List<WebElement> listOfStatus =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(5)"));
				String status=listOfStatus.get(i).getText();
				Assert.assertEquals("Paused", status);
				System.out.println(status);
				
			}
		}
	
//Count of Pending For Spares Tab
				public void countOfPendingForSparesTab() //     
				{
					driver.findElement(By.cssSelector("a[onclick='submitpendingforspares();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows=listOfRows.size();
					System.out.println("number of Ticket: "+countOfRows);
					
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
					
				}
				
//Total Count of Pending for spares Tab
				public void totalCountOfPendingForSparesTab() // count textOfTotalCount  
				{
					
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitpendingforspares();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request "+count);
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							driver.findElement(By.cssSelector("a[onclick='submitpendingforspares();']")));
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							driver.findElement(By.cssSelector("a[onclick='submitpendingforspares();']")));
					
					driver.findElement(By.cssSelector("a[onclick='submitpendingforspares();']")).click();
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(count,actualTotalCount,"Count is not match");
					
				}
			
//Count of Request SLA Cold Tab
				public void countOfRequestSLAColdTab()     
				{
					driver.findElement(By.cssSelector("a[onclick='submitslaCold();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows=listOfRows.size();
					System.out.println("number of Ticket: "+countOfRows);
						
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
					
				}
				
//Total Count of Request SLA Cold Tab
				public void totalCountOfRequestSLAColdTab() // count   
				{
					
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitslaCold();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request open "+count);
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							driver.findElement(By.cssSelector("a[onclick='submitslaCold();']")));
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							driver.findElement(By.cssSelector("a[onclick='submitslaCold();']")));
					
					driver.findElement(By.cssSelector("a[onclick='submitslaCold();']")).click();
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					System.out.println("textOfTotalCount: "+textOfTotalCount);
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(count,actualTotalCount,"Count is not match");
				
					
					
				}
				
//Compare Cold SLA Image of Request SLA Cold Tab
				public void compareColdSLAImageOfRequestSLAColdTab() throws Exception
				{
					driver.findElement(By.cssSelector("a[onclick='submitslaCold();']")).click();
				
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows =listOfRows.size();
					for(int i=0;i<countOfRows;i++)
					{  
						   String coldSLAImage = driver.findElements(By.cssSelector(".tdspan>img:nth-of-type(1)[title='Resolution(Cold)']")).get(i).getAttribute("alt");
						   System.out.println(coldSLAImage);
						   Assert.assertEquals(coldSLAImage, "Cold");
					}
								
				}

//Count of Request SLA Hot Tab
				public void countOfRequestSLAHotTab()     
				{
					driver.findElement(By.cssSelector("a[onclick='submitslaHot();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows=listOfRows.size();
					
					System.out.println("number of Ticket: "+countOfRows);	
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
					
				}
				
//Total Count of Request SLA Hot Tab
				public void totalCountOfRequestSLAHotTab()  
				{
					
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitslaHot();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request"+count);
					
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							driver.findElement(By.cssSelector("a[onclick='submitslaHot();']")));
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							driver.findElement(By.cssSelector("a[onclick='submitslaHot();']")));
					
					
					driver.findElement(By.cssSelector("a[onclick='submitslaHot();']")).click();
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(count,actualTotalCount,"Count is not match");
					
				}
	
//Compare Hot SLA Image of Request SLA Hot Tab
				public void compareHotSLAImageOfRequestSLAHotTab() throws Exception
				{
				
					driver.findElement(By.cssSelector("a[onclick='submitslaHot();']")).click();
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows =listOfRows.size();
					
					for(int i=0;i<countOfRows;i++)
					{	
						     String hotSLAImage = driver.findElements(By.cssSelector(".tdspan>img:nth-of-type(1)[title='Resolution(Hot)']")).get(i).getAttribute("alt");
						     System.out.println(hotSLAImage);
						     Assert.assertEquals(hotSLAImage, "Hot");
					}
				
			
				}

//Count of Request SLA Warm Tab
				public void countOfRequestSLAWarmTab()    
				{
					driver.findElement(By.cssSelector("a[onclick='submitslaWarm();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows=listOfRows.size();
					System.out.println("number of Ticket: "+countOfRows);
					
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
					
				}
				
//Total Count of Request SLA Warm Tab
				public void totalCountOfRequestSLAWarmTab()    
				{
					
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitslaWarm();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request"+count);
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							driver.findElement(By.cssSelector("a[onclick='submitslaWarm();']")));
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							driver.findElement(By.cssSelector("a[onclick='submitslaWarm();']")));
					
					driver.findElement(By.cssSelector("a[onclick='submitslaWarm();']")).click();
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(count,actualTotalCount,"Count is not match");	
				}
				
//Compare Warm SLA Image of Request SLA Warm Tab
				public void compareWarmSLAImageOfRequestSLAWarmTab() throws Exception
				{
					driver.findElement(By.cssSelector("a[onclick='submitslaWarm();']")).click();
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows =listOfRows.size();
					
					for(int i=0;i<countOfRows;i++)
					{	
						     String WarmSLA = driver.findElements(By.cssSelector(".tdspan>img:nth-of-type(1)[title='Resolution(Warm)']")).get(i).getAttribute("alt");
						     System.out.println(WarmSLA);
						     Assert.assertEquals(WarmSLA, "Warm");
					}
				
			
				}

	
//Count of Request SLA Near To Violation Tab
				public void countOfRequestSLANearToViolationTab()     
				{
					driver.findElement(By.cssSelector("a[onclick='submitslaNV();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows=listOfRows.size();
					System.out.println("number of Ticket: "+countOfRows);
					
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
					
				}
				
//Total Count of Request SLA Near To Violation Tab
				public void totalCountOfRequestSLANearToViolationTab() 
				{
					
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitslaNV();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request "+count);
					
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							driver.findElement(By.cssSelector("a[onclick='submitslaNV();']")));
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							driver.findElement(By.cssSelector("a[onclick='submitslaNV();']")));
					
					driver.findElement(By.cssSelector("a[onclick='submitslaNV();']")).click();
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(count,actualTotalCount,"Count is not match");	
				
				}
//Compare Warm Near To Violation Image of Request SLA Near To Violation Tab
				public void compareWarmNearToViolationImageOfRequestSLANearToViolationTab() throws Exception 
				{
				
					driver.findElement(By.cssSelector("a[onclick='submitslaNV();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows =listOfRows.size();
					
					for(int i=0;i<countOfRows;i++)
					{	
						String nearToViolationImage = driver.findElements(By.cssSelector(".tdspan>img:nth-of-type(1)[title='Resolution(Near to Violate)']")).get(i).getAttribute("alt");
						     System.out.println(nearToViolationImage);
						     Assert.assertEquals(nearToViolationImage, "Violated");
					}
				
			
				}

				
//Count of Request SLA Violated Tab
				public void countOfRequestSLAViolatedTab()      
				{
					driver.findElement(By.cssSelector("a[onclick='submitslaviolated();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows=listOfRows.size();
					System.out.println("number of Ticket: "+countOfRows);
					
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
					
				}
//Total Count of Request SLA Violated Tab
				public void totalCountOfRequestSLAViolatedTab() 
				{
					
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitslaviolated();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request "+count);
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							driver.findElement(By.cssSelector("a[onclick='submitslaviolated();']")));
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							driver.findElement(By.cssSelector("a[onclick='submitslaviolated();']")));
					
					driver.findElement(By.cssSelector("a[onclick='submitslaviolated();']")).click();
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(count,actualTotalCount,"Count is not match");
				
				}
//Compare Violated SLA Image of Request SLA Violated Tab
				public void compareViolatedSLAImageOfRequestSLAViolatedTab() throws Exception 
				{
				
					driver.findElement(By.cssSelector("a[onclick='submitslaviolated();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows =listOfRows.size();
				
					for(int i=0;i<countOfRows;i++)
					{	
						     String violatedImage = driver.findElements(By.cssSelector(".tdspan>img:nth-of-type(1)[title='Resolution(Violate)']")).get(i).getAttribute("alt");
						     System.out.println(violatedImage);
						     Assert.assertEquals(violatedImage, "Violated");
					}
				
			
				}
	
	
//Count of Consumed With Spares Tab
				public void countOfConsumedWithSparesTab() //     
				{
					driver.findElement(By.cssSelector("a[onclick='submitconsumedwithspares();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows=listOfRows.size();
					System.out.println("number of Ticket: "+countOfRows);
					
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
					
				}
				
//Total Count of Consumed With Spares Tab
				public void totalCountOfConsumedWithSparesTab() 
				{
					
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitconsumedwithspares();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request "+count);
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							driver.findElement(By.cssSelector("a[onclick='submitconsumedwithspares();']")));
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							driver.findElement(By.cssSelector("a[onclick='submitconsumedwithspares();']")));
					
					driver.findElement(By.cssSelector("a[onclick='submitconsumedwithspares();']")).click();
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(count,actualTotalCount,"Count is not match");
					
				}
				
//Count of Requests Cancel Tab
				public void countOfRequestsCancelTab()    
				{
					driver.findElement(By.cssSelector("a[onclick='submitCancel();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows=listOfRows.size();
					System.out.println("number of Ticket: "+countOfRows);
					
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
			
				}
				
//Total Count of Requests Cancel Tab
				public void totalCountOfRequestsCancelTab() 
				{
					
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitCancel();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request "+count);
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							driver.findElement(By.cssSelector("a[onclick='submitCancel();']")));
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							driver.findElement(By.cssSelector("a[onclick='submitCancel();']")));
					
					driver.findElement(By.cssSelector("a[onclick='submitCancel();']")).click();
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(count,actualTotalCount,"Count is not match");
					
					
				}
	
//Count of Requests Closed by Technician Tab
				public void countOfRequestsClosedByTechnicianTab()     
				{
					driver.findElement(By.cssSelector("a[onclick='submitTechClosed();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows=listOfRows.size();
					System.out.println("number of Ticket: "+countOfRows);
					
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
				
				}
				
//Total Count of Requests Closed by Technician Tab
				public void totalCountOfRequestsClosedByTechnicianTab() throws Exception 
				{
					
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitTechClosed();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request"+count);
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							driver.findElement(By.cssSelector("a[onclick='submitTechClosed();']")));
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							driver.findElement(By.cssSelector("a[onclick='submitTechClosed();']")));
					
					driver.findElement(By.cssSelector("a[onclick='submitTechClosed();']")).click();
					Thread.sleep(500);
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(count,actualTotalCount,"Count is not match");
					
				}
	
//Count of Requests Final Closed Tab
				public void countOfRequestsFinalClosedTab()      
				{
					driver.findElement(By.cssSelector("a[onclick='submitClosed();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows=listOfRows.size();
					System.out.println("number of Ticket: "+countOfRows);
					
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
					
				}
				
//Total Count of Requests Final Closed Tab
				public void totalCountOfRequestsFinalClosedTab() //textOfCount count textOfTotalCount totalCount 
				{
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitClosed();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request "+count);
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							driver.findElement(By.cssSelector("a[onclick='submitClosed();']")));
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							driver.findElement(By.cssSelector("a[onclick='submitClosed();']")));
					
					driver.findElement(By.cssSelector("a[onclick='submitClosed();']")).click();
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(count,actualTotalCount,"Count is not match");
					
					
				}
	
	
//Count of All Requests Tab
				public void countOfAllRequestsTab() //     
				{
					driver.findElement(By.cssSelector("a[onclick='submitAll();']")).click();
					
					List<WebElement> listOfRows =driver.findElements(By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
					Integer countOfRows=listOfRows.size();
					System.out.println("number of Ticket: "+countOfRows);
				
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(listOfRows.size(),Integer.parseInt(totalCount),"Count is not match");
					
				}
				
//Total Count of All Requests Tab
				public void totalCountOfAllRequestsTab() //textOfCount count textOfTotalCount totalCount actualTotalCount
				{
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitAll();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request "+count);
					
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView(true);",
							driver.findElement(By.cssSelector("a[onclick='submitAll();']")));
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", 
							driver.findElement(By.cssSelector("a[onclick='submitAll();']")));
					
					driver.findElement(By.cssSelector("a[onclick='submitAll();']")).click();
					String textOfTotalCount= driver.findElement(By.cssSelector("div[id='pagination']>strong")).getText();
					String totalCount  = textOfTotalCount.split(" ")[5];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: "+actualTotalCount);
					Assert.assertEquals(count,actualTotalCount,"Count is not match");
				
					
					
				}
//Total Count of All Request Tab
				public void sumOfAllRequestTab() 
				{
					String textOfCountOfOpenRequests= driver.findElement(By.cssSelector("a[onclick='submitOpen();']>span[class='badge']")).getText();
					int countOfOpenRequests = Integer.parseInt(textOfCountOfOpenRequests);
					System.out.println("number of Request open "+countOfOpenRequests);
					
					String textOfCountOfPausedRequests= driver.findElement(By.cssSelector("a[onclick='submitPaused();']>span[class='badge']")).getText();
					int countOfPausedRequests = Integer.parseInt(textOfCountOfPausedRequests);
					System.out.println("number of Request Paused "+countOfPausedRequests);
					
					String textOfCountOfCancelRequests= driver.findElement(By.cssSelector("a[onclick='submitCancel();']>span[class='badge']")).getText();
					int countOfCancelRequests = Integer.parseInt(textOfCountOfCancelRequests);
					System.out.println("number of Request Cancel "+countOfCancelRequests);
					
					String textOfCountOfTechnicianClosedRequests= driver.findElement(By.cssSelector("a[onclick='submitTechClosed();']>span[class='badge']")).getText();
					int countOfTechnicianClosedRequests = Integer.parseInt(textOfCountOfTechnicianClosedRequests);
					System.out.println("number of Request open "+countOfTechnicianClosedRequests);
					
					String textOfCountOfClosedRequests= driver.findElement(By.cssSelector("a[onclick='submitClosed();']>span[class='badge']")).getText();
					int countOfClosedRequests = Integer.parseInt(textOfCountOfClosedRequests);
					System.out.println("number of Request open "+countOfClosedRequests);
					
					int Sum=countOfOpenRequests+countOfPausedRequests+countOfCancelRequests+countOfTechnicianClosedRequests+countOfClosedRequests;
					System.out.println("Sum of all Request: "+Sum);
					
					String textOfCount= driver.findElement(By.cssSelector("a[onclick='submitAll();']>span[class='badge']")).getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request open "+count);
					
					Assert.assertEquals(count, Sum,"Count is not match");
					
				}
	
	
	
	

}
