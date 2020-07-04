package com.udemy.seleniumdesign.test.command;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.udemy.seleniumdesign.command.ElementValidator;
import com.udemy.seleniumdesign.command.HomePage;
import com.udemy.seleniumdesign.test.BaseTest;

public class HomePageTest extends BaseTest{
	private HomePage homePage;
	
	@BeforeTest
	public void setHomePage() {
		this.homePage = new HomePage(driver);
	}
	
	@Test
	public void homePageTest() {
		this.homePage.goTo();
		this.homePage.getElementValidators()
		.stream()
		.parallel()	//to create parallel threads for execution at this point
		.map(ev -> ev.validate())
		.forEach(b -> Assert.assertTrue(b));
	}
	
	/*
	//Below approach is to execute tests with TestNG @DataProvider
	
	@Test
	public void goTo(){
		this.homePage.goTo();
	} 
	
	@Test(dataProvider = "getData", dependsOnMethods = "goTo")
	public void homePageTest(ElementValidator elementValidator) {
		Assert.assertTrue(elementValidator.validate());
	}
	
	@DataProvider
	public Object[] getData(){
		return this.homePage.getElementValidators().toArray();
	}  
	*/ 
}
