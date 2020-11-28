package org.lu.ics.labs;

import java.util.ArrayList;
import java.util.List;

import org.lu.ics.labs.Account;

public class Person {
	private String pNbr;
	private String name;
	private List<Account> accounts;
	
	public Person (String name, String pNbr) {
		this.name=name;
		this.pNbr=pNbr;
		accounts=new ArrayList<>();
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public String getpNbr() {
		return pNbr;
	}
	public String getname() {
		return name;
	}
	public void addAccount(Account a) {
		accounts.add(a);
	}
	public Account findAccount(String accountNbr) {
		
		for (int i = 0; i < accounts.size(); i++) {
			if (accountNbr.equals(accounts.get(i).getNbr())) {
				return accounts.get(i);
			}
			
		}
		return null;
	}
	public double totBalance() {
		double sum=0;
		for (int i = 0; i < accounts.size(); i++) {
			sum += accounts.get(i).getBalance();
						
		}
		return sum;
		
	}
	

}
