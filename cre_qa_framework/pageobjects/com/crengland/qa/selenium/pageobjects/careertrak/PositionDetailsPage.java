package com.crengland.qa.selenium.pageobjects.careertrak;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PositionDetailsPage {

	private AvailableTeamPositionsPage atp;
	private PositionModal pm;
	static Properties UI;
	private final WebDriver driver;
	private WebDriverWait wait;
	final String positionTitle = "Western Regional";
	
	@FindBy(linkText = "edit") private WebElement editBtn;
	@FindBy(partialLinkText = "Eligible Drivers") private WebElement eligibleDrivers;
	@FindBy(id = "addDriver") private WebElement addDriver;
	@FindBy(id = "sendPosition") private WebElement sendPositionBtn;
	
	public PositionDetailsPage(WebDriver myBrowser) throws FileNotFoundException, IOException{    	
    	UI = new Properties();
    	UI.load(new FileInputStream("/Users/Trever/Development/CRE Automation/cre_qa_framework/testdata/UI.properties"));
    	driver = myBrowser;
}
	
	public void editPosition(WebDriver myBrowser, String position) throws FileNotFoundException, IOException{
		
		wait = new WebDriverWait(myBrowser, 10);
		
		atp = new AvailableTeamPositionsPage(driver);
		atp.selectPosition(myBrowser, position);
		editBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atp.positionTitle")));
		pm.cancelNewPositionModal();
	}

	public AddDriverModal clickAddDriver() throws FileNotFoundException, IOException{
		addDriver.click();
		return new AddDriverModal(driver);
	}

	public List<WebElement> getAllEligibleDrivers(WebDriver browser){
		
		wait = new WebDriverWait(browser, 10);
		this.clickElgibileDriversTab();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sendPosition")));
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='eligibleDriversTable']/tbody/tr/td/a[@class='link-action-button']"));
		return list;
	}
	
	private void clickElgibileDriversTab(){
		
		eligibleDrivers.click();
	}
}


//else {
//	System.out.printf("%S doesn't exists\n", position);
//}