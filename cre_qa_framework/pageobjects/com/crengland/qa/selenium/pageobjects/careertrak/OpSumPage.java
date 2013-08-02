package com.crengland.qa.selenium.pageobjects.careertrak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.crengland.qa.helper.Helper;


public class OpSumPage {
	
	private final WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(id = "opsum") private WebElement opsumTab;
	@FindBy(className = "driverProfile") private WebElement driverCode;

	
	public OpSumPage(WebDriver myBrowser) throws FileNotFoundException, IOException{    	
	    	driver = myBrowser;
	    	wait = new WebDriverWait(myBrowser, 10);
	}
	
	// Needs works!
	public DriverProfileModal selectDriverCode(String code){
		
		Helper help = new Helper();
		List<WebElement> list = help.getTableData(driver, "allApplicantsPagedTable", 4);
		outerloop:
		for (WebElement item : list) {
			if (item.getText().equalsIgnoreCase(code)) {
				item.click();
				
				break outerloop;
			} 
			
		}
		
		return new DriverProfileModal(driver);
	}
	
	public void navigateToOperationsSummary(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openPositionsPagedTable")));
		opsumTab.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("allApplicantsFilter")));
	}

}
