package com.crengland.qa.selenium.tests;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Mymain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { SomeTest.class });
		testng.addListener(tla);
		testng.run();

	}

}
