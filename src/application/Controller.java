package application;

import java.util.ArrayList;
import java.util.List;
import org.lu.ics.labs.Account;
import org.lu.ics.labs.Person;
import org.lu.ics.labs.PersonRegister;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class Controller {

	PersonRegister reg = new PersonRegister();

	@FXML
	private TextField txtName;
	@FXML
	private TextField txtPNbr1;
	@FXML
	private TextField txtPNbr2;
	@FXML
	private TextField txtPNbr3;
	@FXML
	private TextField txtNbr1;
	@FXML
	private TextField txtNbr2;
	@FXML
	private TextField txtAmount;
	@FXML
	private TextField txtPersonBalance;
	@FXML
	private TextArea txtResponse;

	@FXML
	public void btnAdd_Click(ActionEvent event) {
		String name = txtName.getText();
		String pNbr = txtPNbr1.getText();
		Person p = new Person(name, pNbr);
		reg.addPerson(p);
		txtResponse.setText("Person tillagd");
		
		clearAllText();
	}

	@FXML
	public void btnDelete_Click(ActionEvent event) {
		String pNbr = txtPNbr1.getText();
		Person p = reg.findPerson(pNbr);
		if (p != null) {
		reg.removePerson(pNbr);
		txtResponse.setText("Person: " + p.getname() + " borttagen");
		}else {
			txtResponse.setText("Ingen person hittad");
		}
		clearAllText();
	}

	@FXML
	public void btnFindPerson_Click(ActionEvent event) {
		String pNbr = txtPNbr1.getText();
		Person p = reg.findPerson(pNbr);
		if (p != null) {
			String balanceText = String.valueOf(p.totBalance());
			txtResponse.setText( p.getname() + " " + p.getpNbr() + "\n" + "Totala saldo: " + balanceText + "kr");
		} else {
			txtResponse.setText("Ingen person hittad");
		}
		clearAllText();
	}

	@FXML
	public void btnShowAccounts_Click (ActionEvent event) {
		String pNbr = txtPNbr1.getText();
		Person p = reg.findPerson(pNbr);
		if (p != null) {
			List<Account> list = new ArrayList<>();
			list = p.getAccounts();
			txtResponse.setText("");
			for (int i = 0; i<list.size(); i++) {
				txtResponse.appendText("Account: " + list.get(i).getNbr() + " Saldo: " + list.get(i).getBalance() + "\n"  );
			}		
			clearAllText();			
		}
	
	}
	
	@FXML
	public void btnAddAccount_Click(ActionEvent event) {
		String nbr = txtNbr1.getText();
		String pNbr = txtPNbr2.getText();
		Account a = new Account(nbr);
		if (reg.findPerson(pNbr) != null) {
			reg.findPerson(pNbr).addAccount(a);
			txtResponse.setText("Konto tillagd");
		} else {
			txtResponse.setText("Ingen person hittad");
		}
		clearAllText();
	}
	
	@FXML
	public void btnCredit_Click(ActionEvent event) {
		String nbr = txtNbr2.getText();
		String pNbr = txtPNbr3.getText();
		double amount = Double.parseDouble(txtAmount.getText());
		Person p = reg.findPerson(pNbr);
		if (p != null && p.findAccount(nbr) != null ) {
			reg.findPerson(pNbr).findAccount(nbr).credit(amount);
			String balanceText = String.valueOf(reg.findPerson(pNbr).findAccount(nbr).getBalance());
			txtResponse.setText("Saldo: " + balanceText);
		}else {
			txtResponse.setText("Inget konto eller person hittades");
		}
		clearAllText();	
	}

	@FXML
	public void btnWithdraw_Click(ActionEvent event) {
		String nbr = txtNbr2.getText();
		String pNbr = txtPNbr3.getText();
		double amount = Double.parseDouble(txtAmount.getText());
		Person p = reg.findPerson(pNbr);
		if (p != null && p.findAccount(nbr) != null ) {
			reg.findPerson(pNbr).findAccount(nbr).withdraw(amount);
			String balanceText = String.valueOf(reg.findPerson(pNbr).findAccount(nbr).getBalance());
			txtResponse.setText("Saldo: " + balanceText);
		}else {
			txtResponse.setText("Inget konto eller person hittades");
		}
		clearAllText();		
	}
	
	public void clearAllText() {
		txtPNbr1.setText("");
		txtPNbr2.setText("");
		txtPNbr3.setText("");
		txtNbr1.setText("");
		txtNbr2.setText("");
		txtName.setText("");
		txtAmount.setText("");
	}

}
