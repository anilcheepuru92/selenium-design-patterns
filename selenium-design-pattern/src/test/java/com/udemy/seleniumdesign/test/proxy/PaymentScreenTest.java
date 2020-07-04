package com.udemy.seleniumdesign.test.proxy;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import com.udemy.seleniumdesign.proxy.CreditCard;
import com.udemy.seleniumdesign.proxy.NetBanking;
import com.udemy.seleniumdesign.proxy.PaymentOption;
import com.udemy.seleniumdesign.proxy.PaymentScreen;
import com.udemy.seleniumdesign.test.BaseTest;

public class PaymentScreenTest extends BaseTest{
	
	private PaymentScreen paymentScreen;
	
	@BeforeTest
	public void setPaymentScreen() {
		System.setProperty("env", "PROD");
		this.paymentScreen = new PaymentScreen(this.driver);
	}
	
	@Test(dataProvider = "getData")
	public void paymentTest(PaymentOption paymentOption, Map<String, String> paymentDetails) {
		this.paymentScreen.goTo();
		this.paymentScreen.getUserInformation().enterDetails("Anil", "Kumar", "anil@gmail.com");
		this.paymentScreen.setPaymentOption(paymentOption);
		this.paymentScreen.pay(paymentDetails);
		String orderNumber = this.paymentScreen.getOrder().placeOrder();
		System.out.println("Order Number: "+orderNumber);
		System.out.println("Test ended");
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
		
		return new Object[][] {{new CreditCard(), cc}, {new NetBanking(), nb}};
	}
}
