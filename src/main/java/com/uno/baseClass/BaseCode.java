package com.uno.baseClass;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;

import com.uno.excelUtility.WebEventListener;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;


//import com.UnoPoint.Utility.TestUtil;

public class BaseCode extends ObjectPage{

	public static WebDriver driver;
	public static WebDriver driverSwitch = null;
	public static ScreenRecorder screenRecorder;
	public static String currentDir = System.getProperty("user.dir");

	public static Properties properties;
	public static List<WebElement> webElement;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	
	
	public BaseCode() {
		try {
			properties = new Properties();
			FileInputStream pathOfConfigurationProperties = new FileInputStream(
					"D:\\UnoPoint\\UnoPointServiceSystem\\src\\main\\java\\com\\uno\\configuration\\Configuration.Properties");
			properties.load(pathOfConfigurationProperties);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Parameters("browserName")
	public static void initialization() throws Exception {

		String browserName = properties.getProperty("browser");

		if (browserName.equals("Firefox")) {

			/*
			 * System.setProperty("webdriver.gecko.driver",
			 * "D:\\Selenium Setup\\geckodriver-v0.20.1-win64 (1)\\geckodriver.exe"
			 * );
			 */
			driver = new FirefoxDriver();
		}
		/*
		 * if (browserName.equals("firefox")) {
		 * 
		 * System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		 * driver = new FirefoxDriver(); }
		 */
		else if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		/*
		 * e_driver = new EventFiringWebDriver(driver); // Now create object of
		 * EventListerHandler to register it with EventFiringWebDriver
		 * eventListener = new WebEventListener();
		 * e_driver.register(eventListener); driver = e_driver;
		 */

		// driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));

		// driver.get("https://demo.intelli.uno/erprmwise/");
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"w");
		// https://key.intelli.uno:9443/erprmwise/
		// https://dsmuat.intelli.uno/erprmwise/

		// return browserName;

	}

	public static void highLight(WebElement element) throws Exception  {
		String bgcolor  = element.getCssValue("backgroundColor");

		/*for (int i = 0; i <  3; i++) {*/
            
        
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						element);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '"+bgcolor+"'",  element);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '"+bgcolor+"'",  element);

		
		//}
	}
	
	
	
	
	public static void scrollDown(WebElement element) {

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);

	}
	
	public static void changeFileName(String targetFolder, String method) {

		 // creating new folder 
	      File myfolder = new File(targetFolder);
	      File[] file_array = myfolder.listFiles(); 
	      for (int i = 0; i < file_array.length; i++) 
	      { 

	          if (file_array[i].isFile()) 
	          { 

	              File myfile = new File(targetFolder + 
	                       "\\" + file_array[i].getName()); 

	              File newFile = new File(targetFolder+ 
	                      "\\" + method  + ".avi");
	            
	              myfile.renameTo(newFile);
	              
	              
	          }
	      }

	}
	
	
	public static void startRecording(String targetFolder, String method) throws Exception
	{
	GraphicsConfiguration gc = GraphicsEnvironment
	.getLocalGraphicsEnvironment()
	.getDefaultScreenDevice()
	.getDefaultConfiguration();
	
	 screenRecorder = new ScreenRecorder(gc,
	            gc.getBounds(),
	            new Format(MediaTypeKey, MediaType.VIDEO, MimeTypeKey, MIME_AVI),
	            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
	                    QualityKey, 1.0f,
	                    KeyFrameIntervalKey, 15 * 60),
	            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
	            null,
	        //    null);
	            new File(targetFolder));
	screenRecorder.start();
	
	 

     /* // creating new folder 
      File myfolder = new File(targetFolder);
      File[] file_array = myfolder.listFiles(); 
      for (int i = 0; i < file_array.length; i++) 
      { 

          if (file_array[i].isFile()) 
          { 

              File myfile = new File(targetFolder + 
                       "\\" + file_array[i].getName()); 
              String long_file_name = file_array[i].getName(); 
              System.out.println(long_file_name); 
            //  System.out.print(new_file_name); 

              File newFile = new File(targetFolder+ 
                      "\\" + method  + ".mp4");
              System.out.println("newFile: "+newFile);
              
              // file name format: "Snapshot 11 (12-05-2017 11-57).png" 
              // To Shorten it to "11.png", get the substring which 
              // starts after the first space character in the long 
              // _file_name. 
              myfile.renameTo(newFile);
          }
      }*/
	
	}
//ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE
	public static void stopRecording() throws Exception
	{
	screenRecorder.stop();
	}
	
	public static void setMyView() throws Exception {
		
		
		// Click on My View Tab
		tabMyView.click();
				// Get list Of Pop up Column Check box
				List<WebElement> listOfPopupColumnCheckbox = lstChkMyView;
				
				// Check Pop up Column Check box is selected or not
				if (listOfPopupColumnCheckbox.get(0).isSelected()) {
					// Click on Column Check box
					listOfPopupColumnCheckbox.get(0).click();
					// Thread.sleep(500);
					// Click on Column Check box
					listOfPopupColumnCheckbox.get(0).click();
				} else {
					// Click on Column Check box
					listOfPopupColumnCheckbox.get(0).click();
				}
				// Click on Save Button
			btnSave.click();
}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
}
