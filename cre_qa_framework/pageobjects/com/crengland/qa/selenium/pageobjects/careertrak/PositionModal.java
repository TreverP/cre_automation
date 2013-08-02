package com.crengland.qa.selenium.pageobjects.careertrak;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PositionModal {

	static Properties CareerTrak;
	private final WebDriver driver;
	private WebDriverWait wait;
	final String positionTitle = "Selenium Test Position";
	
	//Modal Buttons
	@FindBy(id = "mappingUtil") private WebElement postPositionBtn;
	@FindBy(id = "closeeditPosition") private WebElement modalCancelBtn;
	//Modal Top Data
	@FindBy(id = "positionTitle") private WebElement title;
	@FindBy(id = "divisionAbbr") private WebElement division;
	@FindBy(id = "acctMan") private WebElement managerName;
	@FindBy(id = "acctPhone") private WebElement phoneNumber;
	@FindBy(id = "acctEmail") private WebElement email;
	//Modal Position Details
	@FindBy(id = "numOpenings") private WebElement openings;
	@FindBy(id = "numPositions") private WebElement totalPositions;
	@FindBy(id = "numPosMonth") private WebElement positionsMonth;
	@FindBy(id = "controlDispatchCityState") private WebElement cDispatch;
	@FindBy(id = "daysRoad") private WebElement daysRoad;
	@FindBy(id = "daysHome") private WebElement daysHome;
	@FindBy(id = "expectedMiles") private WebElement milage;
	@FindBy(id = "expectedComp") private WebElement compensation;
	@FindBy(id = "expectedAnnInc") private WebElement income;
	@FindBy(id = "salaryInc") private WebElement salaryTextField;
	@FindBy(id = "compensationDetails") private WebElement detailTextField;
	//Modal Minimum Requirements
	@FindBy(id = "totalExp") private WebElement experience;
	@FindBy(id = "creExp") private WebElement creExperience;
	@FindBy(id = "reqService") private WebElement servicePercent;
	@FindBy(id = "accident") private WebElement accident;
	@FindBy(id = "logLevel") private WebElement logLevel;
	@FindBy(linkText = "Minimum Requirements") private WebElement minReqAccordion;
	
	public PositionModal(WebDriver myBrowser) throws FileNotFoundException, IOException{    	
    	CareerTrak = new Properties();
    	CareerTrak.load(new FileInputStream("/Users/Trever/Development/CRE Automation/cre_qa_framework/testdata/CareerTrak.properties"));
    	driver = myBrowser;
    	wait = new WebDriverWait(myBrowser, 10);
}
	
	// Click Post Position button on modal and returns control to position page
	public AvailableTeamPositionsPage clickPostPositionBtn() throws FileNotFoundException, IOException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-dialog-title-editJobPositionDialog")));
		postPositionBtn.click();
		return new AvailableTeamPositionsPage(driver);
	}
	
	// Click Cancel button on modal and returns control to position page
	public AvailableTeamPositionsPage cancelNewPositionModal() throws FileNotFoundException, IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-dialog-title-editJobPositionDialog")));
		modalCancelBtn.click();
		return new AvailableTeamPositionsPage(driver);
	}
	
	// Inputs dummy data for testing; Must pass compensation type (salary, details, or mileage)
		public void inputPositionDummyDataSalaryDriver(WebDriver myBrowser, String CompensationType) throws FileNotFoundException, IOException {
		
			//top portion
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("positionTitle")));
			driver.switchTo().activeElement();
			title.sendKeys(CareerTrak.getProperty("POSITION_TITLE"));
			division.sendKeys(CareerTrak.getProperty("DIVISION"));
			managerName.sendKeys(CareerTrak.getProperty("MANAGER_NAME"));
			phoneNumber.click();
			phoneNumber.sendKeys(CareerTrak.getProperty("PHONE_NUMBER"));
			email.sendKeys(CareerTrak.getProperty("EMAIL"));
			// Position Details
			openings.sendKeys(CareerTrak.getProperty("NUM_OF_OPENINGS"));
			totalPositions.sendKeys(CareerTrak.getProperty("NUM_TOTAL_POSITIONS"));
			positionsMonth.sendKeys(CareerTrak.getProperty("NUM_POSITIONS_MONTH"));
			cDispatch.click();
			cDispatch.sendKeys(CareerTrak.getProperty("DISPATCH"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-autocomplete")));
			cDispatch.sendKeys(Keys.ARROW_DOWN);
			cDispatch.sendKeys(Keys.TAB);
			daysRoad.sendKeys(CareerTrak.getProperty("DAYS_ON_ROAD"));
			daysHome.sendKeys(CareerTrak.getProperty("DAYS_AT_HOME"));
			milage.sendKeys(CareerTrak.getProperty("MILAGE"));
			compensationType(CompensationType);
			//Minimum Req.
			minReqAccordion.click();
			experience.sendKeys(CareerTrak.getProperty("EXPERIENCE"));
			creExperience.sendKeys(CareerTrak.getProperty("CRE_EXPERIENCE"));
			accident.sendKeys(CareerTrak.getProperty("ACCIDENT"));
			logLevel.sendKeys(CareerTrak.getProperty("LOG_LEVEL"));
		
		}
		
		private void compensationType(String type){
		
			if(type == "salary") {
				salaryTextField.sendKeys(CareerTrak.getProperty("COMP_SALARY"));
			} else if (type == "detail") {
				detailTextField.sendKeys(CareerTrak.getProperty("COMP_DETAILS"));
			} else if (type == "mileage") {
				compensation.sendKeys(CareerTrak.getProperty("EXPECTED_COMP"));
			} else
				System.out.print("Invalid compensation type");
			
		}
		

	
}
