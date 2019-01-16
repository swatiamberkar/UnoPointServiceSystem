package com.uno.excelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import com.uno.baseClass.BaseCode;


public class TestUtil extends BaseCode {

	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICIT_WAIT = 60;

	public static String TESTDATA_SHEET_PATH = "";

	static Workbook book;
	static Sheet sheet;
	static ITestResult result;
	
	// Initializing Page Object
		public TestUtil() {
			PageFactory.initElements(driver, this);
		}
		

	public static Object[][] getSheetData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0)
				.getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;

	}
	
	

	@SuppressWarnings("deprecation")
	public String[][] getCellData(String xlFilePath, String sheetName)
			throws InvalidFormatException, IOException
	 {
	  FileInputStream stream = new FileInputStream(xlFilePath);
	  
	  Workbook workbook = WorkbookFactory.create(stream);
	  
	  Sheet s = workbook.getSheet(sheetName);
	  
	  int rowcount = s.getLastRowNum();
	  System.out.println("Rowcount: "+rowcount);
	  int cellcount = s.getRow(0).getLastCellNum();
	  System.out.println("Cellcount: "+cellcount);
	  
	  
	  String data[][] = new String[rowcount][cellcount];
	  
	  for (int i = 0; i < rowcount; i++) 
	  {
	   Row r = s.getRow(i + 1);

	   for (int k = 0; k < cellcount; k++) 
	   {
		  
	    Cell c = r.getCell(k);
	    CellStyle style = workbook.createCellStyle(); //Create new style
        style.setWrapText(true); //Set wordwrap
        c.setCellStyle(style);

	    if (c.getCellType() == Cell.CELL_TYPE_STRING)
	    {
	     data[i][k] = c.getStringCellValue();
	     if((data[i][k]).equalsIgnoreCase("null"))
	     {	
	    	 String nullValue =data[i][k].replace(data[i][k], "");
	    	 data[i][k]= nullValue;
	    	 
	     }
	     System.out.println(data[i][k]);
	    } else 
	    {
	    	  data[i][k]=String.valueOf((int)c.getNumericCellValue());
	    	  System.out.println(data[i][k]);
	     

	    }
	   }

	  }
	  return data;

	 }
	
	@SuppressWarnings("deprecation")
	public String[][] getCellDataWithColumn(String colName,String xlFilePath, String sheetName)
			throws InvalidFormatException, IOException
	 {
	  FileInputStream stream = new FileInputStream(xlFilePath);
	  
	  Workbook workbook = WorkbookFactory.create(stream);
	  
	  Sheet s = workbook.getSheet(sheetName);
	  
	  int rowcount = s.getPhysicalNumberOfRows();
	  
	  System.out.println("Rowcount: "+rowcount);
	  int colCount =0;
	 int cellcount = s.getRow(0).getLastCellNum();
	  System.out.println("Cellcount: "+cellcount);
	  for (int i = 0; i < cellcount; i++) 
	  {
	   String column =s.getRow(0).getCell(i).toString();
	   System.out.println("column: "+column);
	   if(column.equalsIgnoreCase(colName))
	   {
		   int num =1;
		   int col =num+i;
		   System.out.println("column: "+col);
		   colCount=col;
		   System.out.println("I: "+colCount);
		   break;
		}
	   }
	  
	  
	  String data[][] = new String[rowcount][1];
	  
	  for (int j = 0; j < rowcount; j++) 
	  {
		  int i=j+1;
	   Row r = s.getRow(i);

	   /*for (int k = 0; k < colCount; k++) 
	   {*/
		int k= 0;
	    Cell c = r.getCell(colCount-1);
	    System.out.println("c: "+c);
	    /*CellStyle style = workbook.createCellStyle(); //Create new style
        style.setWrapText(true); //Set wordwrap
        c.setCellStyle(style);*/

	    if (c.getCellType() == Cell.CELL_TYPE_STRING)
	    {
	     data[i][k] = c.getStringCellValue();
	     if((data[i][k]).equalsIgnoreCase("null"))
	     {	
	    	 String nullValue =data[i][k].replace(data[i][k], "");
	    	 data[i][k]= nullValue;
	    	 
	     }
	     System.out.println(data[i][k]);
	    } 
	    
	    else 
	    {
	    	  data[i][k]=String.valueOf((int)c.getNumericCellValue());
	    	  System.out.println(data[i][k]);
	     

	    }
	   

	  }
	  return data;

	 }
	
	public void setCellData(String xlFilePath, String sheetName, int row, int column, String value)
			throws Exception
	 {
	  FileInputStream stream = new FileInputStream(xlFilePath);
	  
	  Workbook workbook = WorkbookFactory.create(stream);
	  
	  Sheet sheet = workbook.createSheet(sheetName);
	  
	 
	
	   Row r = sheet.createRow(row);
	   
	   

	    
	    Cell c = r.getCell(column);
	    c.setCellValue(value);
	    CellStyle style = workbook.createCellStyle(); //Create new style
        style.setWrapText(true); //Set wordwrap
        c.setCellStyle(style);

	   

	  
	  return ;

	 }

	public static String takeScreenshotAtEndOfTest(WebDriver driver,
			String screenshotName) throws IOException {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
				+ result.getMethod().getMethodName() + ".png"));

		String screenshotPath = currentDir + "/screenshots/"
				+ result.getMethod().getMethodName() + ".png";
		return screenshotPath;
	}

}
