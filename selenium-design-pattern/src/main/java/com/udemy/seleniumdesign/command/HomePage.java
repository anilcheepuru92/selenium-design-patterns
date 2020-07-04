package com.udemy.seleniumdesign.command;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private final WebDriver driver;
	
	//buttons
	@FindBy(css="div.button-box button.btn-info")
	private WebElement infoBtn;
	
	@FindBy(css="div.button-box button.btn-warning")
	private WebElement warnBtn;
	
	@FindBy(css="div.button-box button.btn-success")
	private WebElement successBtn;
	
	@FindBy(css="div.button-box button.btn-danger")
	private WebElement dangerBtn;
	
	//notifications	
	@FindBy(css="div.jq-icon-info")
	private WebElement infoAlert;
	
	@FindBy(css="div.jq-icon-warning")
	private WebElement warnAlert;
	
	@FindBy(css="div.jq-icon-success")
	private WebElement successAlert;
	
	@FindBy(css="div.jq-icon-error")
	private WebElement dangerAlert;
	
	//dismissal alert
	@FindBy(css="div.card-body div.row div:nth-child(2) div.alert-info")
	//@FindBy(xpath="//div[@class='col-lg-4 col-md-12'][2]//div[@class='alert alert-info']")
	private WebElement dismissInfoAlert;
	
	@FindBy(css="div.card-body div.row div:nth-child(2) div.alert-warning")
	//@FindBy(xpath="//div[@class='col-lg-4 col-md-12'][2]//div[@class='alert alert-warning']")
	private WebElement dismissWarnAlert;
	
	@FindBy(css="div.card-body div.row div:nth-child(2) div.alert-success")
	//@FindBy(xpath="//div[@class='col-lg-4 col-md-12'][2]//div[@class='alert alert-success']")
	private WebElement dismissSuccessAlert;
	
	@FindBy(css="div.card-body div.row div:nth-child(2) div.alert-danger")
	//@FindBy(xpath="//div[@class='col-lg-4 col-md-12'][2]//div[@class='alert alert-danger']")
	private WebElement dismissDangerAlert;
	
	public HomePage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goTo() {
		this.driver.get("https://www.wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
	}
	
	public List<ElementValidator> getElementValidators(){
		return Arrays.asList(
				//for notification validation
				new NotificationValidator(infoBtn, infoAlert),
				new NotificationValidator(successBtn, successAlert),
				new NotificationValidator(warnBtn, warnAlert),
				new NotificationValidator(dangerBtn, dangerAlert),
				//for dismiss validation
				new DismissalAlertValidator(dismissInfoAlert),
				new DismissalAlertValidator(dismissSuccessAlert),
				new DismissalAlertValidator(dismissWarnAlert),
				new DismissalAlertValidator(dismissDangerAlert)
				);
	}
}