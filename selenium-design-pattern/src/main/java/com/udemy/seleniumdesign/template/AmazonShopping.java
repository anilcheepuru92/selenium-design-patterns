package com.udemy.seleniumdesign.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.udemy.seleniumdesign.template.pages.AmazonProductDescriptionPage;
import com.udemy.seleniumdesign.template.pages.AmazonResultsPage;
import com.udemy.seleniumdesign.template.pages.AmazonSearchPage;

public class AmazonShopping extends ShoppingTemplate{

	private WebDriver driver;
	private String product;
	private AmazonSearchPage amazonSearchPage;
	private AmazonResultsPage amazonResultsPage;
	private AmazonProductDescriptionPage amazonProductDescriptionPage;
	
	public AmazonShopping(final WebDriver driver, String product) {
		this.driver = driver;
		this.product = product;
		this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
		this.amazonResultsPage = PageFactory.initElements(driver, AmazonResultsPage.class);
		this.amazonProductDescriptionPage = PageFactory.initElements(driver, AmazonProductDescriptionPage.class);
	}

	@Override
	public void launchSite() {
		this.amazonSearchPage.goTo();
	}

	@Override
	public void searchForProduct() {
		this.amazonSearchPage.searchForProduct(this.product);
	}

	@Override
	public void selectProduct() {
		this.amazonResultsPage.selectProduct();
	}

	@Override
	public void buy() {
		this.amazonProductDescriptionPage.buy();
	}

}
