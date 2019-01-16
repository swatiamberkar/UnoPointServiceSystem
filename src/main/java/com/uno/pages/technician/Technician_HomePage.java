package com.uno.pages.technician;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.uno.baseClass.BaseCode;

public class Technician_HomePage extends BaseCode {

	// Select Ticket Tab
	/*@FindBy(linkText = "Incident")
	WebElement tab_Incident;
	*/
	@FindBy(xpath = "//a[contains(@href, '#')]")
	WebElement tab_Incident;
	

	// Initializing Page Object
	public Technician_HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Validate Home Page Title
	public String homePageTitle() {
		return driver.getTitle();
	}

	// Click on Ticket Tab
	public Technician_IncidentPage incidentTab() throws Exception {
		Thread.sleep(500);

		highLight(tab_Incident);
		tab_Incident.click();
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(tab_Incident).build();
		seriesOfActions.perform();
		/*Screen s = new Screen();
		Pattern openButton = new Pattern(
				"D:\\UnoPoint\\UnoPointServiceSystem\\Files\\Incident1.PNG");
		s.click(openButton);*/
		
		return new Technician_IncidentPage();
	}

}
