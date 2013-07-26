package com.crengland.qa.selenium.tests;

import org.openqa.selenium.*;
//import org.openqa.selenium.example.GoogleSearchPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
		public void setup() throws InterruptedException{
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.cache.disk.enable", false);
        	myBrowser = new FirefoxDriver(profile);
	        page = PageFactory.initElements(myBrowser, LoginPage.class);
	        page.LogMeIn("trevorpehr", "charie9");
	        atp = PageFactory.initElements(myBrowser, AvailableTeamPositionsPage.class);
        }

		@Test
        public void testCanLogin() throws Exception {
			atp.postNewPosition(myBrowser);
            
        }

        @AfterTest
        public void tearDown() throws Exception {
//        	page.logout();
//        	myBrowser.quit();
        }
}

