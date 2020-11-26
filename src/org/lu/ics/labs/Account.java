package org.lu.ics.labs;

public class Account {
	private String nbr;
	private double balance;
	
	public Account(String nbr) {
		this.nbr=nbr;
		balance=0;
	}
	
	public String getNbr() {
		return nbr;
	}
	public double getBalance() {
		return balance;
		
	}
	public void credit(double amount) {
		balance=balance+amount;
	}
	public void withdraw (double amount) {
		balance=balance-amount;
	}
}

