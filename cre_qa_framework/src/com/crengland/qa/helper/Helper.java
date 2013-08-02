package com.crengland.qa.helper;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
	
	public int numberOfRowsInTable (WebDriver driver, String tableId){
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='"+tableId+"']/tbody/tr"));
		return ele.size();
	}

	//returns all data in a table for specified column
	public List <WebElement> getTableData(WebDriver driver, String tableID, int columnNumber){
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='"+tableID+"']/tbody/tr/td["+columnNumber+"]"));
		return list;
	}
	
	//returns all data for first column in table
	public List <WebElement> getTableData(WebDriver driver, String tableID){
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='"+tableID+"']/tbody/tr/td[1]"));
		return list;
	}
}
