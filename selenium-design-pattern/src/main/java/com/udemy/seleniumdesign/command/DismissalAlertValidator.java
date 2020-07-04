package com.udemy.seleniumdesign.command;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

public class DismissalAlertValidator extends ElementValidator{

	private List<WebElement> dismissalAlert = new ArrayList();
	private WebElement dismissalAlertEle;
	
	public DismissalAlertValidator(final WebElement dismissalAlert) {
		this.dismissalAlertEle = dismissalAlert;
		this.dismissalAlert.add(this.dismissalAlertEle);
	}
	
	@Override
	public boolean validate() {
		boolean result1 = this.dismissalAlertEle.isDisplayed();//true
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		this.dismissalAlertEle.findElement(By.cssSelector("button.close")).click();
		boolean result2 = this.dismissalAlert.size()>1;//false
		//boolean result2 = this.dismissalAlertEle.isDisplayed();//false
		return result1 &&(!result2);
	}
	
}
