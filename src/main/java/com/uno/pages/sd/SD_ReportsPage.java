package com.uno.pages.sd;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;













import org.apache.poi.hssf.record.ScenarioProtectRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;

public class SD_ReportsPage extends BaseCode {

	private static String downloadPath = "C:\\Users\\Admin\\Downloads";
	private static XSSFSheet s =null;
	private static XSSFWorkbook book =null;
	
	private static int rowcount =0;
	private static int cellcount =0;

	
	SD_ReportsPage sd_ReportsPage;

	// Link Daily Report
	@FindBy(linkText = "Daily Report")
	WebElement linkDailyReport;

	// Calendar Start Date
	@FindBy(css = "a[id='fd-but-dp-1']")
	WebElement calStartDate;

	// Date Picker Start Date
	@FindBy(css = "div[id='fd-dp-1']>table>tbody>tr>td")
	List<WebElement> dtpStartDate;

	// Calendar End Date
	@FindBy(css = "a[id='fd-but-dp-2']")
	WebElement calEndDate;

	// Date Picker Start Date
	@FindBy(css = "div[id='fd-dp-2']>table>tbody>tr>td")
	List<WebElement> dtpEndDate;

	// Text box Start Date
	@FindBy(css = "input[name='m_strStartDate']")
	WebElement txtStartDate;

	// Text box End Date
	@FindBy(css = "input[name='m_strEndDate']")
	WebElement txtEndDate;

	// Button Generate Report
	@FindBy(css = "a[onclick='submitCallExcel();']")
	WebElement btnGenerateReport;
	
	// Button My View
	@FindBy(css = "a[class='topLnk'][onclick='fireMyPopup()']")
	WebElement btnMyView;
	
	// lstPopupColumn
	@FindBy(css = "#view_property>ul>li")
	List<WebElement> lstPopupColumn;
	
	// Button Save
	@FindBy(css = "input[onclick='Save()']")
	WebElement btnSave;
	
	// Get list Of Table Column
	@FindBy(css = "table[class='fht-table fht-table-init']>thead>tr>th")
	List<WebElement> lstTableColumn;
	
	// Get listOfPopupColumnCheckbox
	@FindBy(css = "#view_property>ul>li>input")
	List<WebElement> lstPopupColumnCheckbox;
	
	// Get list Of Pop up Column Check box Name
	@FindBy(css = "#view_property>ul>li")
	List<WebElement> lstPopupColumnCheckboxName;
	
	// Get list Of Table Column Name
	@FindBy(css = "table[class='fht-table fht-table-init']>thead>tr>th")
	List<WebElement> lstTableColumnName;
	
	
				
	

				
	
	
	
	
	
	 
	

	public SD_ReportsPage() {
		PageFactory.initElements(driver, this);
	}

	public static FirefoxProfile firefoxProfile() throws Exception {

		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference(
				"browser.download.manager.showWhenStarting", false);
		firefoxProfile.setPreference("browser.download.dir", downloadPath);
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/zip");

		return firefoxProfile;

	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	private File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	public void selectStartEndDate() throws Exception
	{
		calStartDate.click();
		for (WebElement ele : dtpStartDate) {

			String date = ele.getText();

			if (date.equalsIgnoreCase("1")) {
				Thread.sleep(1000);
				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ele);
				ele.click();
				String getDateValue = ele.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}
		}

		Thread.sleep(2000);
		calEndDate.click();
		for (WebElement ele : dtpEndDate) {

			String date = ele.getText();

			if (date.equalsIgnoreCase("1")) {
				Thread.sleep(1000);
				((JavascriptExecutor) driver)
						.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ele);
				ele.click();
				String getDateValue = ele.getText();
				System.out.println("Select the date:-" + getDateValue);

				break;
			}

		}
	}
	
	public void downloadFileAndClickOnIcon() throws Exception
	{
		Robot robot = new Robot();
		Thread.sleep(2000);
		// robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);

		Screen screen = new Screen();
		Pattern downloadIcon = new Pattern("IconDownload.PNG");
		screen.wait(downloadIcon, 2000);
		screen.click();
	}
	public void getExcelFile() throws Exception
	{
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		System.out.println("fileName :" + fileName);
		String path = downloadPath + "\\" + fileName;
		System.out.println("path: " + path);
		FileInputStream stream = new FileInputStream(path);

		// load the workbook

	
		 book = new XSSFWorkbook(stream);

		// get the sheet which you want to modify or create
		 s = book.getSheet("SD_Reports");

	
		 rowcount = s.getLastRowNum();
		System.out.println("rowcount: " + rowcount);
		Thread.sleep(1000);
		 cellcount = s.getRow(0).getLastCellNum();
		System.out.println("cellcount: " + cellcount);
		}
	
	
	public void verifyDateByDownloadDailyReports() throws Exception {
		linkDailyReport.click();
		
		selectStartEndDate();
	
		String startDate = txtStartDate.getAttribute("value");
		System.out.println("startDate: " + startDate);

		String endDate = txtEndDate.getAttribute("value");
		System.out.println("EndDate: " + endDate);

		driver.manage().timeouts()
		.pageLoadTimeout(120, TimeUnit.SECONDS);
		btnGenerateReport.click();
	
		downloadFileAndClickOnIcon();

		getExcelFile();


		String date=null;
		Row r1 = s.getRow(0);
		for (int k = 0; k < cellcount; k++) {

			Cell c = r1.getCell(k);
			CellStyle style = book.createCellStyle(); // Create new style
			style.setWrapText(true); // Set wordwrap
			c.setCellStyle(style);

			if (c.getCellType() == Cell.CELL_TYPE_STRING) {
				String data1 = c.getStringCellValue();
				System.out.println("data1: " + data1);
				if (data1.equals("Incident Date Time")) 
				{

					for (int i = 0; i < rowcount; i++) 
					{
						Row r = s.getRow(i+1);
						Cell c1 = r.getCell(k);
						System.out.println("Incident Date Time : "+c1);
						String dateValue=c1.getStringCellValue();
						 date =dateValue.split(" ")[0];
						System.out.println("date: "+date);
				
					}
					break;
					}
				}
		}
	Assert.assertEquals(date, startDate,"Date is not Same");

	
	}
	public void myView() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		
		linkDailyReport.click();
		btnMyView.click();
		// Get list Of Pop up Column
		
		// Get size of Pop up Column
		int sizeOfPopupColumn = lstPopupColumn.size();
		
		// Print size of Pop up Column
		System.out.println("Size Of Popup Column: " + sizeOfPopupColumn);
		
		// Check Pop up Column Check box is selected or not
		if (lstPopupColumnCheckbox.get(0).isSelected()) {
			// Click on Column Check box
			lstPopupColumnCheckbox.get(0).click();
			// Thread.sleep(500);
			// Click on Column Check box
			lstPopupColumnCheckbox.get(0).click();
		} else {
			// Click on Column Check box
			lstPopupColumnCheckbox.get(0).click();
		}
		
		
		// Click on Save Button
		btnSave.click();
		
		
		selectStartEndDate();

		driver.manage().timeouts()
		.pageLoadTimeout(120, TimeUnit.SECONDS);
		btnGenerateReport.click();
	
		downloadFileAndClickOnIcon();

		getExcelFile();


		int columnCount=cellcount-1;
		System.out.println("cellcount: "+cellcount);
		
	Assert.assertEquals(columnCount,sizeOfPopupColumn,"Column Size is not Same");

	
	}
}
