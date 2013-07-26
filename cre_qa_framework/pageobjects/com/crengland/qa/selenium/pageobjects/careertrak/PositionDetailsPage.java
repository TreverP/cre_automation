package com.crengland.qa.selenium.pageobjects.careertrak;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crengland.qa.helper.Helper;

public class PositionDetailsPage {

	private AvailableTeamPositionsPage atp;
	static Properties UI;
	private final WebDriver driver;
//	private Helper helper;
//	private WebDriverWait wait;
	final String positionTitle = "Selenium Test Position";
	@FindBy(linkText = "edit") private WebElement editBtn;
	
	public PositionDetailsPage(WebDriver myBrowser) throws FileNotFoundException, IOException{    	
    	UI = new Properties();
    	UI.load(new FileInputStream("/Users/Trever/Development/CRE Automation/cre_qa_framework/testdata/UI.properties"));
    	driver = myBrowser;
}
	
	public void editPosition(String position) throws FileNotFoundException, IOException{
		atp = new AvailableTeamPositionsPage(driver);
		atp.selectPosition(position);
		
	}
}


//else {
//	System.out.printf("%S doesn't exists\n", position);
//}