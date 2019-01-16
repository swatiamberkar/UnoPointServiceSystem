package com.uno.pages.superrole;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;

public class Super_FileCategoryPage extends BaseCode{
	
	// call the method from super role
	Super_LoginPage loginPageOfSuperRole;
	Super_HomePage homePageOfSuperRole;
	Super_SDMasterPage sDmasterPageOfSuperRole;
	Super_TicketMasterPage ticketMasterPageOfSuperRole;
	Super_TicketTypePage ticketTypePageOfSuperRole;
	Super_EmployeeMasterPage empolyeeMasterPageOfSuperRole;
	Super_ManageStaffPage manageStaffPageOfSuperRole;
	Super_TeamMasterPage teamMasterPageOfSuperRole;
	
	// Row in Table
	@FindBy(css = "#FileCategoryForm>table>tbody>tr")
	List<WebElement> objectOfRowInTable;

	// File Category Column in Table
	@FindBy(css = "#FileCategoryForm>table>tbody>tr>td:nth-of-type(1)")
	List<WebElement> objectOfFileCategoryColumn;

	// File Category Column in Table
	@FindBy(css = "#FileCategoryForm>table>tbody>tr>td:nth-of-type(1)")
	public
	List<WebElement> list_FileCategory;
	public Super_FileCategoryPage() {
		PageFactory.initElements(driver, this);

	}
	
	

}
