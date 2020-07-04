package com.udemy.seleniumdesign.test.factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.udemy.seleniumdesign.factory.GoogleFactory;
import com.udemy.seleniumdesign.factory.GooglePage;
import com.udemy.seleniumdesign.test.BaseTest;

public class GoogleSearchTest extends BaseTest{
	
	private GooglePage googlePage;
	
	@Test(dataProvider ="getData")
	public void searchTest(String language, String keyword) {
		
		this.googlePage = GoogleFactory.get(language, driver);		
		this.googlePage.launchSite();
		this.googlePage.search(keyword);
		int resultCount = this.googlePage.getResultsCount();
		
		System.out.println("Results Count:"+ resultCount);
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] {{"ENG","Selenium"}, {"FR","Appium"}, {"SA","Jenkins"}, {"ES","Docker"}};
	}
}
