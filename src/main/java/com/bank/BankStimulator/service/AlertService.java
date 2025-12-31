package com.bank.BankStimulator.service;
import java.math.*;

import com.bank.BankStimulator.util.*;

import com.bank.BankStimulator.model.Account;
public class AlertService {

	private final  BigDecimal threshold;
	
	public AlertService(BigDecimal threshold) {
		this.threshold = threshold;
	}
	
	public void checkBalance(Account account) {
		if(account.getBalance().compareTo(threshold)<= 0) {
			String subject = "Low balance alert: " + account.getAccountNumber();
			String message = "Dear :"+account.getHolderName()+" .\n\nYour account balance is Low: "+account.getBalance()+""
					+ "\nPlease maintain minimum balance.";
			EmailUtil.sendEmail(account.getEmail(),subject,message);
			
		}
	}
}
