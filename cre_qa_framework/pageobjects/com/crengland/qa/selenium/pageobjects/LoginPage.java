package com.crengland.qa.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;


public class LoginPage {
	
    static Properties UI;
    @FindBy(name = "username") private WebElement username;
    @FindBy(name = "password") private WebElement password;
    @FindBy(className = "loginButton") private WebElement loginButton;
    @FindBy(linkText = "LOGOUT") private WebElement logout;    

    public LoginPage(WebDriver myBrowser) throws FileNotFoundException, IOException{
    	
    	UI = new Properties();
    	UI.load(new FileInputStream("/Users/Trever/Development/CRE Automation/cre_qa_framework/testdata/UI.properties"));
//    	myBrowser.get(UI.getProperty("TEST_SERVER"));
    	myBrowser.navigate().to(UI.getProperty("TEST_SERVER") + "/cre_webapp_etools/rest/career/admin/managepositions");
    }

    public void logout(){
    	
    	logout.click();
    }
    
    // default
    public void LogMeIn(){
    	
    	username.sendKeys("Trevorpehr");
    	password.sendKeys("charie9");
    	loginButton.click();
    	
    }
    
    // passing parameters
    public void LogMeIn(String xusername, String xpassword){
//    	wait(15000);
    	username.sendKeys(xusername);
    	password.sendKeys(xpassword);
    	loginButton.click();
    }
 
}


