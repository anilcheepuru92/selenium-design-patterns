package com.udemy.seleniumdesign.test.executearound;

import java.util.function.Consumer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.udemy.seleniumdesign.executearound.FrameA;
import com.udemy.seleniumdesign.executearound.MainPage;
import com.udemy.seleniumdesign.test.BaseTest;

public class FrameTest extends BaseTest{
	private MainPage mainPage;
	
	@BeforeTest
	public void setMainPage() {
		this.mainPage = new MainPage(driver);
	}
	
	@Test
	public void frameTest() {
		this.mainPage.goTo();
		this.mainPage.onFrameA((x) -> x.setMessage("Mission Accomplished"));
		this.mainPage.onFrameB((y) -> y.setAddress("LIG-1-15"));
		this.mainPage.onFrameC((z) -> {
			z.setFirstName("Divya");
			z.setLastName("Athyala");
		});
	}
	
	
	
	/*
	 * Below is the conventional way of dealing with frame switch
	@Test
	public void frameTest() {
		this.mainPage.goTo();
		this.mainPage.getFrameA().setFirstName("Anil");
		this.mainPage.getFrameB().setFirstName("Narendra");
		this.mainPage.getFrameA().setAddress("APHB colony");
		this.mainPage.getFrameC().setMessage("Important");
		this.mainPage.getFrameB().setLastName("Cheepuru");
	}
	*/
}
