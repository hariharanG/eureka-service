package com.hari.designpatterns.chainofresponsibility.model;

public class Currency {
	private Integer amount;
	
	public Currency(Integer amount) {
		this.amount = amount;
	}
	
	public Integer getAmount() {
		return this.amount;
	}
}
