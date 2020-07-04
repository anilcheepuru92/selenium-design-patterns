package com.udemy.seleniumdesign.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.util.concurrent.Uninterruptibles;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeTest
	public void setupDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\Automation Softwares\\Selenium\\Drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		this.driver = new FirefoxDriver();
	}
	
	@AfterTest
	public void quitDriver() {
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		this.driver.quit();
	}
	
	public static void main(String[] args) {
		System.out.println("Anil" == "Anil");
	}
}
