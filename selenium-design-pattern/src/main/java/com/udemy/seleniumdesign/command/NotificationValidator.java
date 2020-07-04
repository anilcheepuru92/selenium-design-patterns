package com.udemy.seleniumdesign.command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

public class NotificationValidator extends ElementValidator{

	private WebElement button;
	private WebElement notification;
	
	public NotificationValidator(final WebElement button, final WebElement notification) {
		this.button = button;
		this.notification = notification;
	}
	
	@Override
	public boolean validate() {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		this.button.click();
		boolean appearanceState = this.notification.isDisplayed();
		Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
		boolean disappearanceState = this.notification.isDisplayed();
		return (appearanceState && (!disappearanceState));
	}
	
}
