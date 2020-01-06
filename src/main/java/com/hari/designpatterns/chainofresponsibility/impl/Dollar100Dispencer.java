package com.hari.designpatterns.chainofresponsibility.impl;

import com.hari.designpatterns.chainofresponsibility.DispenceChain;
import com.hari.designpatterns.chainofresponsibility.model.Currency;

public class Dollar100Dispencer implements DispenceChain {

	private DispenceChain chain;
	
	@Override
	public void setNextChain(DispenceChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispence(Currency currency) {
		if(currency != null) {
			if(currency.getAmount() >= 100) {
				Integer numberOfTimes = currency.getAmount() / 100;
				Integer remainder = currency.getAmount() % 100;
				System.out.println("Dispencing 100 * "+numberOfTimes + " = "+(100*numberOfTimes)+" amount!");
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
