package com.crengland.qa.selenium.pageobjects.careertrak;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperationsSummaryPage {
	
	private final WebDriver driver;
	private WebDriverWait wait;

	public OperationsSummaryPage(WebDriver myBrowser){    	
    	driver = myBrowser;
    	wait = new WebDriverWait(myBrowser, 10);
	}
}
