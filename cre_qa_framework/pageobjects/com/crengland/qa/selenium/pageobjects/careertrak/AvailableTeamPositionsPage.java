package com.crengland.qa.selenium.pageobjects.careertrak;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.crengland.qa.selenium.tests.Mymain;



public class AvailableTeamPositionsPage {
	static Properties UI;
	private final WebDriver driver;
	@FindBy(id = "managepositions") private WebElement availblePositions;
	@FindBy(id = "newPosition") private WebElement addPosition;
	@FindBy(id = "openPositionsPagedTable") private WebElement positionTable;
	@FindBy(id = "statusSelector") private WebElement statusSelector;
    //Post New Position Modal
	@FindBy(id = "editJobPositionDialog") private WebElement modal;
    @FindBy(id = "positionTitle") private WebElement title;
    @FindBy(id = "divisionAbbr") private WebElement division;
    @FindBy(id = "acctMan") private WebElement managerName;
    @FindBy(id = "acctPhone") private WebElement phoneNumber;
    @FindBy(id = "acctEmail") private WebElement email;
    @FindBy(id = "closeeditPosition") private WebElement cancelModal;
    @FindBy(id = "numOpenings") private WebElement openings;
    @FindBy(id = "numPositions") private WebElement totalPositions;
    @FindBy(id = "numPosMonth") private WebElement positionsMonth;
    @FindBy(id = "controlDispatchCityState") private WebElement cDispatch;
    @FindBy(id = "daysRoad") private WebElement daysRoad;
    @FindBy(id = "daysHome") private WebElement daysHome;
    @FindBy(id = "expectedMiles") private WebElement milage;
    @FindBy(id = "expectedComp") private WebElement compensation;
    @FindBy(id = "expectedAnnInc") private WebElement income;
    // Minimum Requirements
    @FindBy(id = "totalExp") private WebElement experience;
    @FindBy(id = "creExp") private WebElement creExperience;
    @FindBy(id = "reqService") private WebElement servicePercent;
    @FindBy(id = "accident") private WebElement accident;
    @FindBy(id = "logLevel") private WebElement logLevel;
    @FindBy(linkText = "Minimum Requirements") private WebElement minReqAccordion;
    @FindBy(id = "mappingUtil") private WebElement postPositionBtn;
    @FindBy(xpath = "//table[@id='openPositionsPagedTable']/tr") private WebElement table;

	
	public AvailableTeamPositionsPage(WebDriver myBrowser) throws FileNotFoundException, IOException{    	
	    	UI = new Properties();
	    	UI.load(new FileInputStream("/Users/Trever/Documents/workspace/cre_qa_framework/testdata/UI.properties"));
	    	driver = myBrowser;
	}
	
	public void postNewPosition(WebDriver myBrowser) {
		
		WebDriverWait wait = new WebDriverWait(myBrowser, 10);
		
		//top portion
		openNewPositionModal(); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("positionTitle")));
		driver.switchTo().activeElement();
		title.sendKeys("Selenium Test Position");
		division.sendKeys("c");
		managerName.sendKeys("Test Test");
		phoneNumber.click();
		phoneNumber.sendKeys("8019996464");
		email.sendKeys("test@test.com");
		// Position Details
		openings.sendKeys("10");
		totalPositions.sendKeys("15");
		positionsMonth.sendKeys("20");
		cDispatch.click();
		cDispatch.sendKeys("salt lake city");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-autocomplete")));
		cDispatch.sendKeys(Keys.ARROW_DOWN);
		cDispatch.sendKeys(Keys.TAB);
		daysRoad.sendKeys("20");
		daysHome.sendKeys("10");
		milage.sendKeys("4000");
		compensation.sendKeys(".32");
		//Minimum Req.
		minReqAccordion.click();
		experience.sendKeys("12");
		creExperience.sendKeys("12");
		accident.sendKeys("6");
		logLevel.sendKeys("3");
		
		postPositionBtn.click();
		
		
	}

	public int numberOfOpenPositions() {
		
		System.out.print(table.getSize());
		
		
		return 0;
	}
	public void openNewPositionModal() {
		addPosition.click();
	}



}
