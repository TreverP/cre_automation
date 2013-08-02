package com.crengland.qa.selenium.pageobjects.careertrak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverProfileModal {

	private final WebDriver driver;
	private WebDriverWait wait;
	
	public DriverProfileModal(WebDriver browser){
		driver = browser;
    	wait = new WebDriverWait(browser, 10);
	}
}
