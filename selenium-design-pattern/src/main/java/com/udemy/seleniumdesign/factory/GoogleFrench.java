package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleFrench extends GoogleEnglish{

	public GoogleFrench(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="div#gws-output-pages-elements-homepage_additional_languages__als a")
	private WebElement language;
	
	@Override
	public void launchSite() {
		this.driver.get("https://www.google.fr");
		this.language.click();
	}

}
