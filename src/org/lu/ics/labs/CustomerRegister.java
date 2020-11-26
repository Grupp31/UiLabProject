package org.lu.ics.labs;

import java.util.ArrayList;

public class CustomerRegister {

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public ArrayList<Customer> getCustomers() {
		return this.getCustomers();
	}

	public void setCustomers(ArrayList<Customer> value) {
		this.customers = value;
	}
	
	
	public void addCustomer(Customer newCustomer) {
		this.customers.add(newCustomer);
	}
	
	public void removeCustomer(String cNumber) {
	Customer c = this.findCustomer(cNumber);
		if (c != null) {
			this.customers.remove(c);
		}	
	
	}	
	
	public Customer findCustomer(String cNumber) {
		for (Customer c : this.customers) {
			if (c.getCNumber().contentEquals(cNumber)) {
				return c;
			}
		}
		return null;
	}	
		
	public void setCustomerName(String cNumber, String newName) {
		Customer c = this.findCustomer(cNumber);
		if (c != null ) {
			c.setCName(newName);			
		}
		
	}
	
	public void addCreditcard(String customerNbr, Creditcard creditCard) {
		Customer c = this.findCustomer(customerNbr);
		if (c != null) {
			c.addCreditcard(creditCard);
			
		}
		
	}
	
}
