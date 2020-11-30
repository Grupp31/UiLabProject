package org.lu.ics.labs;

import java.util.ArrayList;
import java.util.List;

public class PersonRegister {
	private List<Person> persons = new ArrayList<>();
	


	
	public void addPerson(Person p) {
		persons.add(p);
	}
	public Person findPerson(String pNbr) {
		for (int i = 0; i < persons.size(); i++) {
			if (pNbr.equals(persons.get(i).getpNbr())) {
				return persons.get(i);
			}
		}
		return null;
	}
	public Person removePerson(String pNbr) {
		for (int i = 0; i < persons.size(); i++) {
			if (pNbr.equals(persons.get(i).getpNbr())) {
				Person temp=persons.get(i);
				persons.remove(i);
				return temp;
			}
		}
		return null;
			
	}
	
	public Account findAccount(String pNbr, String accountNbr) {
		for (int i = 0; i < persons.size(); i++) {
			if (pNbr.equals(persons.get(i).getpNbr())) {
				return persons.get(i).findAccount(accountNbr);
				
			}
		}
		return null;
	}
	public double totBalancePerson(String pNbr) {
		for (int i = 0; i < persons.size(); i++) {
			if (pNbr.equals(persons.get(i).getpNbr())) {
				return persons.get(i).totBalance();
				
			}
		}
		return (Double) null;
		
	}
	
}
