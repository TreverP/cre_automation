package com.crengland.qa.selenium.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit.*;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import com.crengland.qa.selenium.pageobjects.LoginPage;
import com.crengland.qa.selenium.pageobjects.careertrak.*;

public class SomeTest {
	
		private WebDriver myBrowser;
		LoginPage page; 
		AvailableTeamPositionsPage atp;
		PositionDetailsPage pdp;
		
        @BeforeTest
		public void setup() {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.cache.disk.enable", false);
        	myBrowser = new FirefoxDriver(profile);
	        page = PageFactory.initElements(myBrowser, LoginPage.class);
	        page.LogMeIn("trevorpehr", "charie9");
	        atp = PageFactory.initElements(myBrowser, AvailableTeamPositionsPage.class);
//	        pdp = PageFactory.initElements(myBrowser, PositionDetailsPage.class);
        }

        
		@Test
		//Test if a specific position exists 
		public void testDoesPositionExists() {
			
//			atp.postNewPosition(myBrowser);
			
			
			List <WebElement> pos = atp.getOpenPositionTitles(myBrowser);
			
			String position = "Selenium Test Position";
			boolean found = false;
			for (WebElement item : pos) {
				if (item.getText().equals(position)) {
					found = true;
					return;
				} else {
					found = false;
				}
			}
			
			Assert.assertTrue(found);
			
			
		}

        @AfterMethod
		@AfterTest
        public void tearDown() throws Exception {
//        	page.logout();
//        	myBrowser.quit();
        }
}

