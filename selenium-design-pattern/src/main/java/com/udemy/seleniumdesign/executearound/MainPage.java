package com.udemy.seleniumdesign.executearound;

import java.util.function.Consumer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	private final WebDriver driver;
	
	@FindBy(id="a")
	private WebElement a;
	
	@FindBy(id="b")
	private WebElement b;
	
	@FindBy(id="c")
	private WebElement c;
	
	private FrameA frameA;
	private FrameB frameB;
	private FrameC frameC;
	
	public MainPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.frameA = PageFactory.initElements(driver, FrameA.class);
		this.frameB = PageFactory.initElements(driver, FrameB.class);
		this.frameC = PageFactory.initElements(driver, FrameC.class);
	}
	
	public void goTo() {
		this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
	}
	
	public void onFrameA(Consumer<FrameA> consumer) {
		this.driver.switchTo().frame(a);
		consumer.accept(this.frameA);
		this.driver.switchTo().defaultContent();
	}
	
	public void onFrameB(Consumer<FrameB> consumer) {
		this.driver.switchTo().frame(b);
		consumer.accept(this.frameB);
		this.driver.switchTo().defaultContent();
	}
	
	public void onFrameC(Consumer<FrameC> consumer) {
		this.driver.switchTo().frame(c);
		consumer.accept(this.frameC);
		this.driver.switchTo().defaultContent();
	}
	
	/*
	 * Below is the conventional way of dealing with frame switch
	public FrameA getFrameA() {
		this.driver.switchTo().defaultContent();
		this.driver.switchTo().frame(a);
		return frameA;
	}
	
	public FrameB getFrameB() {
		this.driver.switchTo().defaultContent();
		this.driver.switchTo().frame(b);
		return frameB;
	}
	
	public FrameC getFrameC() {
		this.driver.switchTo().defaultContent();
		this.driver.switchTo().frame(c);
		return frameC;
	}
	*/
}
