package com.udemy.seleniumdesign.strategy;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Supplier;

public class PaymentOptionFactory {
	private static final Supplier<PaymentOption> CC = () -> new CreditCard();
	private static final Supplier<PaymentOption> NB = () -> new NetBanking();
	
	private static final Map<String, Supplier<PaymentOption>> MAP = new HashMap<String, Supplier<PaymentOption>>();
	
	static {
		MAP.put("CC", CC);
		MAP.put("NB", NB);
	}
	
	public static PaymentOption get(String option) {
		return MAP.get(option).get();
	}
}
