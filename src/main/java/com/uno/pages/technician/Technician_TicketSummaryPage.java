package com.uno.pages.technician;

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

public class Technician_TicketSummaryPage extends BaseCode {

	// Initializing Page Object
	public Technician_TicketSummaryPage() {
		PageFactory.initElements(driver, this);
	}

	// Click on Ticket Summary Tab
	public void ticketSummaryTab() throws Exception {
		highLight(tabOpenInTicketSummary);
		boolean isOpenTab = tabOpenInTicketSummary.isDisplayed();
		System.out.println("Open Tap is display with Blue Color: " + isOpenTab);

		highLight(tabWorkInProgressInTicketSummary);
		boolean isWorkInProgressTab = tabWorkInProgressInTicketSummary
				.isDisplayed();
		System.out.println("Work In Progress Tap is display with Yellow Color:"
				+ isWorkInProgressTab);

		highLight(tabSLAInTicketSummary);
		boolean isSLATab = tabSLAInTicketSummary.isDisplayed();
		System.out.println("SLA Tap is display with Pink Color:" + isSLATab);

		highLight(tabResolvedInTicketSummary);
		boolean isResolvedTab = tabResolvedInTicketSummary.isDisplayed();
		System.out.println("Resolved Tap is display with Green Color:"
				+ isResolvedTab);

	}

	// Total Count of Requests Open Tab
	public void verifyTotalCountAndStatusOfRequestsOpenTab() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		highLight(tabRequestsOpenInTicketSummary);
		Thread.sleep(500);
		highLight(lblCountOfRequestOpenTab);

		String textOfCount = lblCountOfRequestOpenTab.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("Number of Request open " + count);

		Thread.sleep(500);
		tabRequestsOpenInTicketSummary.click();

		scrollDown(lblTicketCountInTicketTable);
		Thread.sleep(500);
		highLight(lblTicketCountInTicketTable);
		String textOfTotalCount = lblTicketCountInTicketTable.getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("Number of Total Ticket: " + actualTotalCount);

		softAssert.assertEquals(count, actualTotalCount, "Count is not match");

		setMyView();
		List<WebElement> listOfRows = lstRowInTicketTable;
		Integer countOfRows = listOfRows.size();
		for (int i = 0; i < countOfRows; i++) {
			List<WebElement> listOfStatus = lstStatusInTicketTable;
			scrollDown(lstStatusInTicketTable.get(i));
			highLight(lstStatusInTicketTable.get(i));
			String status = listOfStatus.get(i).getText();
			System.out.println("Status of Request Open: " + status);
			softAssert.assertEquals(status, "Open", "Status is not Same");

		}

		softAssert.assertAll();

	}

	// Total Count of Assigned But No ETA Tab
	public void totalCountofAssignedButNoETATab() throws Exception // count
	{
		SoftAssert softAssert = new SoftAssert();
		highLight(tabAssignedButNoETA);
		Thread.sleep(500);
		highLight(lblCountOfAssignedButNoETA);
		String textOfCount = lblCountOfAssignedButNoETA.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request Assigned But No ETA " + count);

		tabAssignedButNoETA.click();
		scrollDown(lblTicketCountInTicketTable);
		Thread.sleep(500);
		highLight(lblTicketCountInTicketTable);
		String textOfTotalCount = lblTicketCountInTicketTable.getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		softAssert.assertEquals(count, actualTotalCount, "Count is not match");

		setMyView();
		Integer countOfRows = lstRowInTicketTable.size();

		for (int i = 0; i < countOfRows; i++) {
			scrollDown(lstStatusInTicketTable.get(i));
			highLight(lstStatusInTicketTable.get(i));
			String status = lstStatusInTicketTable.get(i).getText();
			System.out.println("status:" + status);
			softAssert.assertEquals("Open", status);

		}

		for (int i = 0; i < countOfRows; i++) {
			scrollDown(lstEngineerInTicketTable.get(i));
			highLight(lstEngineerInTicketTable.get(i));
			String engineer = lstEngineerInTicketTable.get(i).getText();
			System.out.println("engineer:" + engineer);
			softAssert.assertNotNull(engineer);

		}

		for (int i = 0; i < countOfRows; i++) {
			scrollDown(lstETADateInTicketTable.get(i));
			highLight(lstETADateInTicketTable.get(i));
			String eTADate = lstETADateInTicketTable.get(i).getText();
			System.out.println(eTADate);
			Assert.assertEquals("", eTADate);

		}
		softAssert.assertAll();

	}

	



	// Total Count of ETA Expired And No ATA Tab
	public void totalCountOfETAExpiredAndNoATATab() throws Exception {

		String textOfCount = lblCountOfETAExpiredAndNoATAETA.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request open " + count);

		scrollDown(tabETAExpiredAndNoATA);
		highLight(tabETAExpiredAndNoATA);
	
		tabETAExpiredAndNoATA.click();
		String textOfTotalCount =lblTotalTicketCount.getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}

	// Status of ETA Expired And No ATA Tab
	public void statusOfETAExpiredAndNoATATab() throws Exception {
		
		highLight(tabETAExpiredAndNoATA);
		tabETAExpiredAndNoATA.click();

		setMyView();
		
		Integer countOfRows = lstRowInTable.size();
		// System.out.println("number of Request open "+totalRows);
		for (int i = 0; i < countOfRows; i++) {
			scrollDown(lstStatusInTable.get(i));
			highLight(lstStatusInTable.get(i));
			String status = lstStatusInTable.get(i).getText();
			Assert.assertEquals("Open", status);
			System.out.println(status);
		}
	}

	// Compare Time of ETA in ETA Expired And No ATA Tab
	public void compareTimeOfETAInETAExpiredAndNoATATab() throws Exception {
		/*driver.findElement(
				By.cssSelector("a[onclick='submitopenetaviolated();']"))
				.click();

		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		int countOfRows = listOfRows.size();
		for (int i = 0; i < countOfRows; i++) {

			String textOfDateFormat = "yyyy-MM-dd";
			SimpleDateFormat dateFormat = new SimpleDateFormat(textOfDateFormat);
			List<WebElement> listOfDate = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)"));
			String textOfDate = listOfDate.get(i).getText();
			Date dateOfETA = dateFormat.parse(textOfDate);
			String dateFormatOfETA = dateFormat.format(dateOfETA);
			Date date = dateFormat.parse(dateFormatOfETA);
			// System.out.println(date);

			String textOfTimeFormat = "HH:mm";
			SimpleDateFormat timeFormat = new SimpleDateFormat(textOfTimeFormat);
			List<WebElement> listOfTime = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(32)"));
			String textOfTime = listOfTime.get(i).getText();
			Date timeOfETA = timeFormat.parse(textOfTime);
			String timeFormatOfETA = timeFormat.format(timeOfETA);
			Date time = timeFormat.parse(timeFormatOfETA);
			// System.out.println(time);

			System.out.println("ETA Date & Time:" + dateFormatOfETA + "\n"
					+ timeFormatOfETA + "\n");

			// get current date time with Date()
			Date dateSystem = new Date();

			String dateFormatOfSystem = dateFormat.format(dateSystem);
			Date currentDate = dateFormat.parse(dateFormatOfSystem);
			// System.out.println(dateFormatOfSystem);
			// System.out.println(currentDate);

			String timeFormatOfSystem = timeFormat.format(dateSystem);
			Date currentTime = timeFormat.parse(timeFormatOfSystem);
			// System.out.println(timeFormatOfSystem);
			// System.out.println(currentTime);

			System.out.println("System Date & Time:" + dateFormatOfSystem
					+ "\n" + timeFormatOfSystem + "\n");
			// if(date.compareTo(currentDate)>0 ||
			// time.compareTo(currentTime)>0)

			if (date.compareTo(currentDate) > 0) {
				System.out
						.println("ETA Date & Time is After System Date & Time\n");
			} else if (date.compareTo(currentDate) <= 0) {
				System.out
						.println("ETA Date & Time is Before System Date & Time\n");
			} else {
				System.out.println("Something is Wrong");
			}
		}*/
		
		driver.findElement(
				By.cssSelector("a[onclick='submitopenetaviolated();']"))
				.click();

		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		int countOfRows = listOfRows.size();
		for (int i = 0; i < countOfRows; i++) {

			String textOfDateFormat = "yyyy-MM-dd";
			SimpleDateFormat dateFormat = new SimpleDateFormat(textOfDateFormat);
			List<WebElement> listOfDate = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(31)"));
			String textOfDate = listOfDate.get(i).getText();
			Date dateOfETA = dateFormat.parse(textOfDate);
			String dateFormatOfETA = dateFormat.format(dateOfETA);
			Date date = dateFormat.parse(dateFormatOfETA);
			// System.out.println(date);

			String textOfTimeFormat = "HH:mm";
			SimpleDateFormat timeFormat = new SimpleDateFormat(textOfTimeFormat);
			List<WebElement> listOfTime = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(32)"));
			String textOfTime = listOfTime.get(i).getText();
			Date timeOfETA = timeFormat.parse(textOfTime);
			String timeFormatOfETA = timeFormat.format(timeOfETA);
			Date time = timeFormat.parse(timeFormatOfETA);
			// System.out.println(time);

			System.out.println("ETA Date & Time:" + dateFormatOfETA + "\n"
					+ timeFormatOfETA + "\n");

			// get current date time with Date()
			Date dateSystem = new Date();

			String dateFormatOfSystem = dateFormat.format(dateSystem);
			Date currentDate = dateFormat.parse(dateFormatOfSystem);
			// System.out.println(dateFormatOfSystem);
			// System.out.println(currentDate);

			String timeFormatOfSystem = timeFormat.format(dateSystem);
			Date currentTime = timeFormat.parse(timeFormatOfSystem);
			// System.out.println(timeFormatOfSystem);
			// System.out.println(currentTime);

			System.out.println("System Date & Time:" + dateFormatOfSystem
					+ "\n" + timeFormatOfSystem + "\n");
			// if(date.compareTo(currentDate)>0 ||
			// time.compareTo(currentTime)>0)

			if (date.compareTo(currentDate) > 0) {
				System.out
						.println("ETA Date & Time is After System Date & Time\n");
			} else if (date.compareTo(currentDate) <= 0) {
				System.out
						.println("ETA Date & Time is Before System Date & Time\n");
			} else {
				System.out.println("Something is Wrong");
			}
		}

	}

	// ATA of ETA Expired And No ATA Tab
	public void aTAOfETAExpiredAndNoATATab() {
		driver.findElement(
				By.cssSelector("a[onclick='submitopenetaviolated();']"))
				.click();

		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows = listOfRows.size();
		for (int i = 0; i < countOfRows; i++) {
			List<WebElement> listOfATADate = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(33)"));
			String aTADate = listOfATADate.get(i).getText();
			Assert.assertEquals("", aTADate);
			System.out.println(aTADate);
		}
	}


	// Total Count of Work In Progress Tab
	public void totalCountOfWorkInProgressTab() // count
	{

		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitETAorATAassign();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request  " + count);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[onclick='submitETAorATAassign();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitETAorATAassign();']")));

		driver.findElement(
				By.cssSelector("a[onclick='submitETAorATAassign();']")).click();
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}

	// Status of Work In Progress Tab
	public void statusOfWorkInProgressTab() {
		driver.findElement(
				By.cssSelector("a[onclick='submitETAorATAassign();']")).click();

		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows = listOfRows.size();

		for (int i = 0; i < countOfRows; i++) {
			List<WebElement> listOfStatus = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(8)"));
			String status = listOfStatus.get(i).getText();
			Assert.assertEquals("Open", status);
			System.out.println(status);

		}
	}

	// ATA of Work In Progress Tab
	public void aTAOfWorkInProgressTab() throws Exception {
		driver.findElement(
				By.cssSelector("a[onclick='submitETAorATAassign();']")).click();

		technician_ViewIncidentPage = new Technician_ViewIncidentPage();
		setMyView();

		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows = listOfRows.size();

		for (int i = 0; i < countOfRows; i++) {
			List<WebElement> listOfATADate = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(33)"));
			String aTADate = listOfATADate.get(i).getText();
			Assert.assertNotNull(aTADate);
			System.out.println(aTADate);

		}
	}


	// Total Count of Requests Paused Tab
	public void totalCountOfRequestsPausedTab() {

		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitPaused();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request " + count);
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[onclick='submitPaused();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitPaused();']")));

		driver.findElement(By.cssSelector("a[onclick='submitPaused();']"))
				.click();
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}

	// Status of Requests Paused Tab
	public void statusOfRequestsPausedTab() {
		driver.findElement(By.cssSelector("a[onclick='submitPaused();']"))
				.click();

		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows = listOfRows.size();
		// System.out.println("number of Request open "+totalRows);
		for (int i = 0; i < countOfRows; i++) {
			List<WebElement> listOfStatus = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(5)"));
			String status = listOfStatus.get(i).getText();
			Assert.assertEquals("Paused", status);
			System.out.println(status);

		}
	}

	// Total Count of Pending for spares Tab
	public void totalCountOfPendingForSparesTab() // count textOfTotalCount
	{

		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitpendingforspares();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request " + count);

		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].scrollIntoView(true);",
						driver.findElement(By
								.cssSelector("a[onclick='submitpendingforspares();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitpendingforspares();']")));

		driver.findElement(
				By.cssSelector("a[onclick='submitpendingforspares();']"))
				.click();
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}

	// Total Count of Request SLA Cold Tab
	public void totalCountOfRequestSLAColdTab() // count
	{

		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitslaCold();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request open " + count);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[onclick='submitslaCold();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitslaCold();']")));

		driver.findElement(By.cssSelector("a[onclick='submitslaCold();']"))
				.click();
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		System.out.println("textOfTotalCount: " + textOfTotalCount);
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}

	// Compare Cold SLA Image of Request SLA Cold Tab
	public void compareColdSLAImageOfRequestSLAColdTab() throws Exception {
		driver.findElement(By.cssSelector("a[onclick='submitslaCold();']"))
				.click();

		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows = listOfRows.size();
		for (int i = 0; i < countOfRows; i++) {
			String coldSLAImage = driver
					.findElements(
							By.cssSelector(".tdspan>img:nth-of-type(1)[title='Resolution(Cold)']"))
					.get(i).getAttribute("alt");
			System.out.println(coldSLAImage);
			Assert.assertEquals(coldSLAImage, "Cold");
		}

	}

	// Total Count of Request SLA Hot Tab
	public void totalCountOfRequestSLAHotTab() {

		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitslaHot();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request" + count);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[onclick='submitslaHot();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitslaHot();']")));

		driver.findElement(By.cssSelector("a[onclick='submitslaHot();']"))
				.click();
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}

	// Compare Hot SLA Image of Request SLA Hot Tab
	public void compareHotSLAImageOfRequestSLAHotTab() throws Exception {

		driver.findElement(By.cssSelector("a[onclick='submitslaHot();']"))
				.click();
		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows = listOfRows.size();

		for (int i = 0; i < countOfRows; i++) {
			String hotSLAImage = driver
					.findElements(
							By.cssSelector(".tdspan>img:nth-of-type(1)[title='Resolution(Hot)']"))
					.get(i).getAttribute("alt");
			System.out.println(hotSLAImage);
			Assert.assertEquals(hotSLAImage, "Hot");
		}

	}


	// Total Count of Request SLA Warm Tab
	public void totalCountOfRequestSLAWarmTab() {

		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitslaWarm();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request" + count);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[onclick='submitslaWarm();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitslaWarm();']")));

		driver.findElement(By.cssSelector("a[onclick='submitslaWarm();']"))
				.click();
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");
	}

	// Compare Warm SLA Image of Request SLA Warm Tab
	public void compareWarmSLAImageOfRequestSLAWarmTab() throws Exception {
		driver.findElement(By.cssSelector("a[onclick='submitslaWarm();']"))
				.click();
		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows = listOfRows.size();

		for (int i = 0; i < countOfRows; i++) {
			String WarmSLA = driver
					.findElements(
							By.cssSelector(".tdspan>img:nth-of-type(1)[title='Resolution(Warm)']"))
					.get(i).getAttribute("alt");
			System.out.println(WarmSLA);
			Assert.assertEquals(WarmSLA, "Warm");
		}

	}


	// Total Count of Request SLA Near To Violation Tab
	public void totalCountOfRequestSLANearToViolationTab() {

		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitslaNV();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request " + count);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[onclick='submitslaNV();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitslaNV();']")));

		driver.findElement(By.cssSelector("a[onclick='submitslaNV();']"))
				.click();
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}

	// Compare Warm Near To Violation Image of Request SLA Near To Violation Tab
	public void compareWarmNearToViolationImageOfRequestSLANearToViolationTab()
			throws Exception {

		driver.findElement(By.cssSelector("a[onclick='submitslaNV();']"))
				.click();

		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows = listOfRows.size();

		for (int i = 0; i < countOfRows; i++) {
			String nearToViolationImage = driver
					.findElements(
							By.cssSelector(".tdspan>img:nth-of-type(1)[title='Resolution(Near to Violate)']"))
					.get(i).getAttribute("alt");
			System.out.println(nearToViolationImage);
			Assert.assertEquals(nearToViolationImage, "Violated");
		}

	}


	// Total Count of Request SLA Violated Tab
	public void totalCountOfRequestSLAViolatedTab() {

		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitslaviolated();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request " + count);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[onclick='submitslaviolated();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitslaviolated();']")));

		driver.findElement(By.cssSelector("a[onclick='submitslaviolated();']"))
				.click();
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}

	// Compare Violated SLA Image of Request SLA Violated Tab
	public void compareViolatedSLAImageOfRequestSLAViolatedTab()
			throws Exception {

		driver.findElement(By.cssSelector("a[onclick='submitslaviolated();']"))
				.click();

		List<WebElement> listOfRows = driver
				.findElements(By
						.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
		Integer countOfRows = listOfRows.size();

		for (int i = 0; i < countOfRows; i++) {
			String violatedImage = driver
					.findElements(
							By.cssSelector(".tdspan>img:nth-of-type(1)[title='Resolution(Violate)']"))
					.get(i).getAttribute("alt");
			System.out.println(violatedImage);
			Assert.assertEquals(violatedImage, "Violated");
		}

	}

	// Total Count of Consumed With Spares Tab
	public void totalCountOfConsumedWithSparesTab() {

		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitconsumedwithspares();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request " + count);

		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].scrollIntoView(true);",
						driver.findElement(By
								.cssSelector("a[onclick='submitconsumedwithspares();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitconsumedwithspares();']")));

		driver.findElement(
				By.cssSelector("a[onclick='submitconsumedwithspares();']"))
				.click();
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}


	// Total Count of Requests Closed by Technician Tab
	public void totalCountOfRequestsClosedByTechnicianTab() throws Exception {

		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitTechClosed();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request" + count);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[onclick='submitTechClosed();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitTechClosed();']")));

		driver.findElement(By.cssSelector("a[onclick='submitTechClosed();']"))
				.click();
		Thread.sleep(500);
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}
	
	// Total Count of Requests Final Closed Tab
	public void totalCountOfRequestsFinalClosedTab() // textOfCount count
														// textOfTotalCount
														// totalCount
	{
		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitClosed();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request " + count);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", driver.findElement(By
						.cssSelector("a[onclick='submitClosed();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitClosed();']")));

		driver.findElement(By.cssSelector("a[onclick='submitClosed();']"))
				.click();
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}

	
	// Total Count of All Requests Tab
	public void totalCountOfAllRequestsTab() // textOfCount count
												// textOfTotalCount totalCount
												// actualTotalCount
	{
		String textOfCount = driver
				.findElement(
						By.cssSelector("a[onclick='submitAll();']>span[class='badge']"))
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request " + count);

		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView(true);", driver
						.findElement(By
								.cssSelector("a[onclick='submitAll();']")));
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						driver.findElement(By
								.cssSelector("a[onclick='submitAll();']")));

		driver.findElement(By.cssSelector("a[onclick='submitAll();']")).click();
		String textOfTotalCount = driver.findElement(
				By.cssSelector("div[id='pagination']>strong")).getText();
		String totalCount = textOfTotalCount.split(" ")[5];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		Assert.assertEquals(count, actualTotalCount, "Count is not match");

	}

	

}
