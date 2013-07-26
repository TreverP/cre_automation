package com.crengland.qa.selenium.tests;

import java.util.List;

import org.openqa.selenium.*;
//import org.openqa.selenium.example.GoogleSearchPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.*;
//import com.crengland.qa.selenium.helper.LoginLogout;
import com.crengland.qa.selenium.pageobjects.LoginPage;
import com.crengland.qa.selenium.pageobjects.careertrak.*;
//import org.openqa.selenium.support.PageFactory;

public class SomeTest {
	
		private WebDriver myBrowser;
		LoginPage page; 
		AvailableTeamPositionsPage atp;
		
        @BeforeTest
		public void setup() {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.cache.disk.enable", false);
        	myBrowser = new FirefoxDriver(profile);
	        page = PageFactory.initElements(myBrowser, LoginPage.class);
	        page.LogMeIn("trevorpehr", "charie9");
	        atp = PageFactory.initElements(myBrowser, AvailableTeamPositionsPage.class);
        }

		@Test
		//Test if a specific position exists 
		public void testDoesPositionExists() {
			
			
			List <WebElement> pos = atp.getOpenPositionTitles();
			
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
			
			Assert.assertEquals(found, true);
			
		}

        @AfterTest
        public void tearDown() throws Exception {
//        	page.logout();
//        	myBrowser.quit();
        }
}

