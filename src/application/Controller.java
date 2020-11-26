package application;


	import java.net.URL;
	import java.util.ResourceBundle;
	
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
		private TextField txtCardType;
		@FXML
		private TextField txtCardNbr;
		@FXML
		private Label lblResponse;
		@FXML
		private RadioButton rbtnHasCard;
		@FXML
		private RadioButton rbtnNoCard;
	
		@FXML
		public void btnAdd_Click(ActionEvent event) {
			String name = txtName.getText();
			String pNbr = txtPNbr.getText();
			Person tmpPerson = new Person (name, pNbr);
			lblResponse.setText("Response:");
			if (rbtnHasCard.isSelected()) {
				String cardType = txtCardType.getText();
				int cardNumber;
				try {
					cardNumber = Integer.parseInt(txtCardNbr.getText());
					Creditcard creditCard = new Creditcard(cardNumber, cardType);
					tmpCustomer.setCreditcard(creditCard);
					creditCard.setHolder(tmpCustomer);
				}catch (Exception e1) {
					lblResponse.setText("Response: Error, Card Number.");				
				}
						
			}else {
				lblResponse.setText("Response:");
			}
			reg.addCustomer(tmpCustomer);
			}
		
		@FXML
		public void btnFind_Click(ActionEvent event) {
			String cNumber = txtCustNbr.getText();
			Customer tmpCustomer = reg.findCustomer(cNumber);
			if (tmpCustomer != null) {
				
				lblResponse.setText("Response:");
				txtCustNbr.setText(tmpCustomer.getCNumber());
				txtCustName.setText(tmpCustomer.getCName());
				if (tmpCustomer.getCreditcard() != null) {
					Creditcard card = tmpCustomer.getCreditcard();
					txtCardType.setText(card.getType());
					txtCardNbr.setText(Integer.toString(card.getCardNumber()));
					rbtnHasCard.setSelected(true);
				}
				}else {
					lblResponse.setText("Response: Customer not found");
				}
			}
			
			@FXML
			public void btnDelete_Click(ActionEvent event) {
				String cNumber = txtCustNbr.getText();
				reg.removeCustomer(cNumber);
				lblResponse.setText("Response:");
			}
				
				@FXML
				public void btnNewName_Click(ActionEvent event) {
					String cNumber = txtCustNbr.getText();
					Customer tmpCustomer = reg.findCustomer(cNumber);
					if (tmpCustomer != null) {
					lblResponse.setText("Response:");
					String newName = txtCustName.getText();
						reg.setCustomerName(cNumber, newName);
				}else {
					lblResponse.setText("Response: Customer not found");
				}
				
			}	
	
}
