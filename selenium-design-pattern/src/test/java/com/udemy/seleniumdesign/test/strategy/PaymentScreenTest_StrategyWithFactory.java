package com.udemy.seleniumdesign.test.strategy;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import com.udemy.seleniumdesign.strategy.CreditCard;
import com.udemy.seleniumdesign.strategy.NetBanking;
import com.udemy.seleniumdesign.strategy.PaymentOption;
import com.udemy.seleniumdesign.strategy.PaymentOptionFactory;
import com.udemy.seleniumdesign.strategy.PaymentScreen;
import com.udemy.seleniumdesign.test.BaseTest;

public class PaymentScreenTest_StrategyWithFactory extends BaseTest{
	
	private PaymentScreen paymentScreen;
	
	@BeforeTest
	public void setPaymentScreen() {
		this.paymentScreen = new PaymentScreen(this.driver);
	}
	
	@Test(dataProvider = "getData")
	public void paymentTest(String option, Map<String, String> paymentDetails) {
		this.paymentScreen.goTo();
		this.paymentScreen.getUserInformation().enterDetails("Anil", "Kumar", "anil@gmail.com");
		
		this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
		this.paymentScreen.pay(paymentDetails);
		String orderNumber = this.paymentScreen.getOrder().placeOrder();
		System.out.println("Order Number: "+orderNumber);
	}
	
	@DataProvider
	public Object[][] getData() {
		Map<String, String> cc = Maps.newHashMap();
		cc.put("cc", "123456789");
		cc.put("year", "2029");
		cc.put("pin", "123");
		
		Map<String, String> nb = Maps.newHashMap();
		nb.put("bank", "WELLS FARGO");
		nb.put("account", "Myaccount2029");
		nb.put("pin", "342");
		
		return new Object[][] {{"CC", cc}, {"NB", nb}};
	}
}
