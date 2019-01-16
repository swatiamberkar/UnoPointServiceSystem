package com.uno.excelUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;

import com.uno.baseClass.BaseCode;



	public class WebEventListener extends BaseCode implements WebDriverEventListener {
		ITestResult result;
		public static WebDriver driver;


		public void onException(Throwable error,  WebDriver driver){
			System.out.println("Exception occured: " + error);
			
		}
		public void beforeScript(String script, WebDriver driver) {
		}

		public void afterScript(String script, WebDriver driver) {
		}

		public void beforeAlertAccept(WebDriver driver) {
			

		}

		public void afterAlertAccept(WebDriver driver) {
			
		}

		public void afterAlertDismiss(WebDriver driver) {
			

		}

		public void beforeAlertDismiss(WebDriver driver) {
			
		}

		public void beforeNavigateRefresh(WebDriver driver) {
			
		}

		public void afterNavigateRefresh(WebDriver driver) {
			

		}

		public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			

		}

		public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			

		}

		@Override
		public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
			
			
		}

		@Override
		public void afterClickOn(WebElement arg0, WebDriver arg1) {
			
			
		}

		@Override
		public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
			
		}

		@Override
		public void afterNavigateBack(WebDriver arg0) {
			
			
		}

		@Override
		public void afterNavigateForward(WebDriver arg0) {
			
			
		}

		@Override
		public void afterNavigateTo(String arg0, WebDriver arg1) {
			
			
		}

		@Override
		public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
			
			
		}

		@Override
		public void beforeClickOn(WebElement arg0, WebDriver arg1) {
			
			
		}

		@Override
		public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
			
			
		}

		@Override
		public void beforeNavigateBack(WebDriver arg0) {
			
			
		}

		@Override
		public void beforeNavigateForward(WebDriver arg0) {
			
			
		}

		@Override
		public void beforeNavigateTo(String arg0, WebDriver arg1) {
			
			
		}

		@Override
		public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
			
			
		}

		@Override
		public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
			
			
		}

		@Override
		public void afterSwitchToWindow(String arg0, WebDriver arg1) {
			
			
		}

		@Override
		public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
			
			
		}

		@Override
		public void beforeGetText(WebElement arg0, WebDriver arg1) {
			
			
		}

		@Override
		public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
			
			
		}



	}


