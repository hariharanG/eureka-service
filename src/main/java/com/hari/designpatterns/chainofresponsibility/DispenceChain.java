package com.hari.designpatterns.chainofresponsibility;

import com.hari.designpatterns.chainofresponsibility.model.Currency;

public interface DispenceChain {
	
	void setNextChain(DispenceChain nextChain);
	
	void dispence(Currency currency);
}
