package com.hari.designpatterns.chainofresponsibility.impl;

import com.hari.designpatterns.chainofresponsibility.DispenceChain;
import com.hari.designpatterns.chainofresponsibility.model.Currency;

public class Dollar500Dispencer implements DispenceChain {

	private DispenceChain chain;
	
	@Override
	public void setNextChain(DispenceChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispence(Currency currency) {
		if(currency != null && currency.getAmount() % 100 == 0) {
			if(currency.getAmount() >= 500) {
				Integer numberOfTimes = currency.getAmount() / 500;
				Integer remainder = currency.getAmount() % 500;
				System.out.println("Dispencing 500 * "+numberOfTimes + " = "+(500*numberOfTimes)+" amount!");
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
