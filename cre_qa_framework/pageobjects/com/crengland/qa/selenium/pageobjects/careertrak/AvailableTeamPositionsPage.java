package com.crengland.qa.selenium.pageobjects.careertrak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.crengland.qa.helper.*;


public class AvailableTeamPositionsPage {
	static Properties UI;
	private final WebDriver driver;
	private Helper helper;
	private WebDriverWait wait;
	final String positionTitle = "Selenium Test Position";
	
	@FindBy(id = "managepositions") private WebElement availblePositions;
	@FindBy(id = "newPosition") private WebElement addPosition;
	@FindBy(id = "openPositionsPagedTable") private WebElement positionTable;
	@FindBy(id = "statusSelector") private WebElement statusSelector;
	@FindBy(linkText = "Edit") private WebElement positionEditBtn;

	
	public AvailableTeamPositionsPage(WebDriver myBrowser) throws FileNotFoundException, IOException{    	
	    	driver = myBrowser;
	    	wait = new WebDriverWait(myBrowser, 10);
	}
	
	public int numberOfOpenPositions() {
		
		helper = new Helper();
		return helper.numberOfRowsInTable(driver, "openPositionsPagedTable");
	}
	
	public List<WebElement> getOpenPositionTitles(WebDriver myBrowser) {
		
//		wait = new WebDriverWait(myBrowser, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openPositionsPagedTable")));
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='openPositionsPagedTable']/tbody/tr/td[1]"));
		return list;
	}
	
	public PositionModal clickPostNewPositionBtn() throws FileNotFoundException, IOException {
		addPosition.click();
		return new PositionModal(driver);
	}

	public PositionModal clickEditPositionLink() throws FileNotFoundException, IOException {
		positionEditBtn.click();
		return new PositionModal(driver);
	}

	public PositionDetailsPage selectPosition(WebDriver myBrowser, String position) throws FileNotFoundException, IOException {
		
		wait = new WebDriverWait(myBrowser, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openPositionsContent")));
		
		List <WebElement> positions = getOpenPositionTitles(myBrowser);
		outerloop:
		for (WebElement item : positions) {
//			System.out.printf("%s", positions);
			if (item.getText().equals(position)) {
				item.click();
				break outerloop;
			} 
		}
		return new PositionDetailsPage(driver);
	}
	
}
