package com.hari.designpatterns.chainofresponsibility.main;

import java.util.Scanner;

import com.hari.designpatterns.chainofresponsibility.DispenceChain;
import com.hari.designpatterns.chainofresponsibility.impl.Dollar1000Dispencer;
import com.hari.designpatterns.chainofresponsibility.impl.Dollar100Dispencer;
import com.hari.designpatterns.chainofresponsibility.impl.Dollar2000Dispencer;
import com.hari.designpatterns.chainofresponsibility.impl.Dollar500Dispencer;
import com.hari.designpatterns.chainofresponsibility.model.Currency;

public class ATMMachine {

	private DispenceChain chain;
	
	public ATMMachine() {
		// Initialize dispencer
		this.chain = new Dollar2000Dispencer();
		DispenceChain nextChain = null;
		
		nextChain = new Dollar1000Dispencer();
		chain.setNextChain(nextChain);
		
		nextChain = new Dollar500Dispencer();
		chain.setNextChain(nextChain);
		
		nextChain = new Dollar100Dispencer();
		chain.setNextChain(nextChain);
	}
	
	public static void main(String ... args) {
		ATMMachine atm = new ATMMachine();
		
		while(true) {
			Integer amount = 0 ;
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter amount!");
			amount = scan.nextInt();
			if(amount % 100  != 0 ) {
				System.out.println("Numbers 100,500 or 2000 only!");
				
				System.out.println("Please enter valid amount! Do you want to proceed? (Y/N)");
				String validAmountFlag = scan.next();
				//System.out.println("Agreed to continue ? "+flag);
				if(validAmountFlag.equalsIgnoreCase("y")) {
					continue;
				}
				
				return;
			}
			
			// Process the request
			atm.chain.dispence(new Currency(amount));
			
			System.out.println("Do you want to continue? (Y/N)");
			String continueFlag = scan.next();
			//System.out.println("Agreed to continue ? "+flag);
			if(continueFlag.equalsIgnoreCase("y")) {
				continue;
			}else {
				System.out.println("Thank you !");
				return;
			}
			
		}
		
		
	}

}
