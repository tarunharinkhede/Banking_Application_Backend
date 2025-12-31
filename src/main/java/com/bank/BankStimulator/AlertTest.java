package com.bank.BankStimulator;
import java.math.BigDecimal;

import com.bank.BankStimulator.repository.AccountRepository;
import com.bank.BankStimulator.repository.TransactionRepository;
import com.bank.BankStimulator.exceptions.AccountNotFoundException;
import com.bank.BankStimulator.exceptions.InsufficientBalanceException;
import com.bank.BankStimulator.exceptions.InvalidAmountException;
import com.bank.BankStimulator.model.Account;
import com.bank.BankStimulator.service.AccountService;
import com.bank.BankStimulator.service.AlertService;
import com.bank.BankStimulator.service.TransactionService;
public class AlertTest {
	public static void main(String[] args) {
		AccountRepository accountRepository = new AccountRepository();
		AccountService accountService = new AccountService(accountRepository);
		TransactionRepository trxRepo = new TransactionRepository();
		AlertService alertService = new AlertService(new BigDecimal("1000"));
		
		TransactionService trxService = new TransactionService(accountService,trxRepo,alertService);
	/*try {
		accountService.createAccount("tarun", "harinkhedetarun282@gmail.com", new BigDecimal("500"));
	trxService.deposite(account.getAccountNumber(), new BigDecimal("200"));
	System.out.println("Amount is deposited Successfully...");
	System.out.println("Total Balance :"+ account.getBalance)
	}catch(InvalidAmountException e){
		e.printStackTrace();
		
	}*/
	try {
		Account account = accountService.createAccount("tarun", "harinkhedetarun282@gmail.com", new BigDecimal("5000"));
	trxService.withdraw(account.getAccountNumber(), new BigDecimal("4500"));
	System.out.println("Amount is withdraw Successfully...");
	System.out.println("Toatal Balance :"+ account.getBalance());
	}catch(InvalidAmountException | AccountNotFoundException | InsufficientBalanceException e){
		e.printStackTrace();
		
	}
	}
	
}
