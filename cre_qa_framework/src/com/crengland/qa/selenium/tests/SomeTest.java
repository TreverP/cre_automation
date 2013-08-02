package com.crengland.qa.selenium.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
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
		PositionModal pm;
		AddDriverModal adm;
		
        @BeforeTest
		public void setup() {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.cache.disk.enable", false);
        	myBrowser = new FirefoxDriver(profile);
	        page = PageFactory.initElements(myBrowser, LoginPage.class);
	        page.LogMeIn("trevorpehr", "charie9");
	        atp = PageFactory.initElements(myBrowser, AvailableTeamPositionsPage.class);
	        pdp = PageFactory.initElements(myBrowser, PositionDetailsPage.class);
	        pm = PageFactory.initElements(myBrowser, PositionModal.class);
	        adm = PageFactory.initElements(myBrowser, AddDriverModal.class);
	        
        }

        // Would like to change this to add the driver to position and then validate that they dont show in the eligible list
        @Test
        public void testDriverIsEligibleForPosition() throws FileNotFoundException, IOException {
        	atp.selectPosition(myBrowser, "Test");
        	List <WebElement> list = pdp.getAllEligibleDrivers(myBrowser);
        	String driver = "ATHRO";
        	boolean found = false;
        	for (WebElement l : list) {
				if (l.getText().equals(driver)) {
					found = true;
					return;
				} 
        	}
        	Assert.assertTrue(found);
        }
        
		@Test
		//Test if a specific position exists 
		public void testDoesPositionExists() throws FileNotFoundException, IOException {
			
			pm.postNewPosition(myBrowser);
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

		@Test
		public void Test() throws FileNotFoundException, IOException {
			atp.selectPosition(myBrowser, "Test");
			pdp.clickAddDriver();
			adm.addCompanyDriverToPosition(myBrowser, "AHM");
			pdp.clickAddDriver();
		}
        
		
		@AfterTest
        public void tearDown() throws Exception {
//        	page.logout();
//        	myBrowser.quit();
        }
}

