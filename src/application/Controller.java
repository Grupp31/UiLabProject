package application;


	import java.net.URL;
	import java.util.ResourceBundle;

import org.lu.ics.labs.Account;
import org.lu.ics.labs.Creditcard;
	import org.lu.ics.labs.Customer;
	
	import org.lu.ics.labs.CustomerRegister;
import org.lu.ics.labs.Person;
import org.lu.ics.labs.PersonRegister;

import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Label;
	import javafx.scene.control.RadioButton;
	import javafx.scene.control.TextField;
	
	public class Controller {
		
	PersonRegister reg = new PersonRegister();
			
		@FXML
		private TextField txtName;
		@FXML
		private TextField txtPNbr;
		@FXML
		private TextField txtNbr;
		@FXML
		private TextField txtAmount;
		
		@FXML
		private Label lblResponse;
	
	
		@FXML
		public void btnAdd_Click(ActionEvent event) {
			String name = txtName.getText();
			String pNbr = txtPNbr.getText();
			Person tmpPerson = new Person (name, pNbr);
			lblResponse.setText("Response:");
			reg.addPerson(tmpPerson);
		}
		
	
			
		@FXML
		public void btnDelete_Click(ActionEvent event) {
				String pNbr = txtPNbr.getText();
				reg.removePerson(pNbr);
		}
					
		@FXML
		public void btnFindPerson_Click(ActionEvent event) {
			String name = txtName.getText();
			String pNbr = txtPNbr.getText();
			Person findPerson(name, pNbr) {
				for (Person tmp: persons) {
					if (tmp.getPNbr().equals(pNbr)) {
						return tmp; 
					}
				}
			}
			
	
			
			@FXML
			public void btnFindAccount_Click(ActionEvent event) {
				String name = txtName.getText();
				String pNbr = txtPNbr.getText();
				public Account findAccount(name, pNbr) {
					for (int i = 0; i < persons.size(); i++) {
						if (pNbr.equals(persons.get(i).getpNbr())) {
							return persons.get(i).findAccount(accountNbr);
				}
			}
					
				
			@FXML
			public void btnTotBalance_Click(ActionEvent event) {
				String name = txtName.getText();
				String pNbr = txtPNbr.getText();
				public double totBalancePerson(String pNbr) {
					for (int i = 0; i < persons.size(); i++) {
						if (pNbr.equals(persons.get(i).getpNbr())) {
							return persons.get(i).totBalance();
						}
					}
					return (Double) null;
					lblResponse.setText("Response:");
				
			@FXML
			public void btnAddAccount_Click(ActionEvent event) {
				String nbr = txtName.getText();
				String pNbr = txtPNbr.getText();
				Account addAccount(Account a) {
				accounts.add(a); 
				}
						}
					}
				}
				lblResponse.setText("Response:");
			
				
				
		@FXML
		public void btnCredit_Click(ActionEvent event) {
				String nbr = txtName.getText();
				String pNbr = txtPNbr.getText();
				public void credit(double amount) {
					balance=balance+amount;
					lblResponse.setText("Response:");
				
				
					
			@FXML
			public void btnWithdraw_Click(ActionEvent event) {
				String nbr = txtName.getText();
				String pNbr = txtPNbr.getText();
					public void withdraw (double amount) {
					balance=balance-amount;
					lblResponse.setText("Response:");
			
				
				
			
		
		
	}	
	
