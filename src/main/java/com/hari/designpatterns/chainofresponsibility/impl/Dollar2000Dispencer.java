package com.hari.designpatterns.chainofresponsibility.impl;

import com.hari.designpatterns.chainofresponsibility.DispenceChain;
import com.hari.designpatterns.chainofresponsibility.model.Currency;

public class Dollar2000Dispencer implements DispenceChain {

	private DispenceChain chain;
	
	@Override
	public void setNextChain(DispenceChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispence(Currency currency) {
		if(currency != null && currency.getAmount() % 100 == 0) {
			if(currency.getAmount() >= 2000) {
				Integer numberOfTimes = currency.getAmount() / 2000;
				Integer remainder = currency.getAmount() % 2000;
				System.out.println("Dispencing 2000 * "+numberOfTimes + " = "+(2000*numberOfTimes)+" amount!");
				if(remainder != 0 ) {
					this.chain.dispence(new Currency(remainder));
				}
			}else {
				this.chain.dispence(currency);
			}
		}else {
			System.out.println("Please enter valid amount !");
		}
	}

}
