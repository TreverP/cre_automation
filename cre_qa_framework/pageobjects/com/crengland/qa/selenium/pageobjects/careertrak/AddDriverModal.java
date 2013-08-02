package com.crengland.qa.selenium.pageobjects.careertrak;


import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddDriverModal {
	
	private final WebDriver driver;
	private WebDriverWait wait; 

	@FindBy(id = "driverType1") private WebElement companyRadioBtn;
	@FindBy(id = "driverType2") private WebElement recruitedRadioBtn;
	@FindBy(id = "driverCodeAutocomplete") private WebElement driverCode;
	@FindBy(id = "submitDriver") private WebElement addDriverBtn;
	@FindBy(id = "closeaddDriver") private WebElement cancelAddDriverBtn;
	@FindBy(id = "recruited") private WebElement recruitedName;
	
	public AddDriverModal(WebDriver myBrowser) throws FileNotFoundException, IOException{    	
    	driver = myBrowser;
	}

	public PositionDetailsPage addCompanyDriverToPosition(WebDriver browser, String driver) throws FileNotFoundException, IOException{
		
		companyRadioBtn.click();
		wait = new WebDriverWait(browser, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-dialog-title-addDriverForm")));
		driverCode.sendKeys(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-autocomplete")));
		driverCode.sendKeys(Keys.ARROW_DOWN);
		driverCode.sendKeys(Keys.TAB);
		addDriverBtn.click();
		
		return new PositionDetailsPage(browser);
		
	}
	
	public PositionDetailsPage addRecruitedDriverToPosition(WebDriver browser, String ssn) {
		
		recruitedRadioBtn.click();
		wait = new WebDriverWait(browser, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-dialog-title-addDriverForm")));
		driverCode.click();
		driverCode.sendKeys(ssn);
		recruitedName.sendKeys("Tester Test"); //Never needs to change so hard coded the value
		
		return null;
	}
	
	public PositionDetailsPage clickAddDriverCancelBtn() throws FileNotFoundException, IOException{
		
		cancelAddDriverBtn.click();
		return new PositionDetailsPage(driver);
	}
}
