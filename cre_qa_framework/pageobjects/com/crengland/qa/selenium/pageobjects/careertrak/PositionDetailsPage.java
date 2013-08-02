package com.crengland.qa.selenium.pageobjects.careertrak;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PositionDetailsPage {

	private final WebDriver driver;
	private WebDriverWait wait;
	final String positionTitle = "Western Regional";
	
	@FindBy(linkText = "edit") private WebElement editBtn;
	@FindBy(partialLinkText = "Eligible Drivers") private WebElement eligibleDrivers;
	@FindBy(id = "addDriver") private WebElement addDriver;
	@FindBy(id = "sendPosition") private WebElement sendPositionBtn;
	
	public PositionDetailsPage(WebDriver myBrowser){    	
    	driver = myBrowser;
    	wait = new WebDriverWait(myBrowser, 10);
	}

	// Clicks edit button and returns control for modal
	public PositionModal clickEditBtn() throws FileNotFoundException, IOException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("view-position-parent")));
		editBtn.click();
		return new PositionModal(driver);
	}

	// Clicks Add Driver button and returns control for modal
	public AddDriverModal clickAddDriver() throws FileNotFoundException, IOException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentApps")));
		addDriver.click();
		return new AddDriverModal(driver);
	}

	public List<WebElement> getAllEligibleDrivers(WebDriver browser){
		this.clickElgibileDriversTab();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eligibleDrivers")));
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='eligibleDriversTable']/tbody/tr/td/a[@class='link-action-button']"));
		return list;
	}
	
	private void clickElgibileDriversTab(){
		
		eligibleDrivers.click();
	}
}
