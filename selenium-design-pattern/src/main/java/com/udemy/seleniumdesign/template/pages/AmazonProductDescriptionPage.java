package com.udemy.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductDescriptionPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(css="span#priceblock_ourprice")
	private WebElement price;
	
	public AmazonProductDescriptionPage(final WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void buy() {
		this.wait.until((d) -> this.price.isDisplayed());
		System.out.println("Amazon price: "+this.price.getText());
	}
}
