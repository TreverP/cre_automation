package com.crengland.qa.helper;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
	
	public int numberOfRowsInTable (WebDriver driver, String id){
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='"+id+"']/tbody/tr"));
		return ele.size();
	}

}
