package com.crengland.qa.selenium.pageobjects.careertrak;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class AddDriverModal {
	
	static Properties UI;
	private final WebDriver driver;

	public AddDriverModal(WebDriver myBrowser) throws FileNotFoundException, IOException{    	
    	UI = new Properties();
    	UI.load(new FileInputStream("/Users/Trever/Development/CRE Automation/cre_qa_framework/testdata/UI.properties"));
    	driver = myBrowser;
	}

}
