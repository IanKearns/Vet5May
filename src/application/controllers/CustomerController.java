package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.ControlledScreen;
import application.Main;
import application.models.Customer;
import application.models.Pet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class CustomerController implements Initializable, ControlledScreen {
	ScreensController myController;
	@FXML
	public TextField firstNameField;
	public TextField lastNameField;
	public TextField phoneNumberField;
	public TextField customerAddressField;
	public Button btnPets;

	/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setData();
    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;

    }

    @FXML
    private void screenBack(ActionEvent event){

		if(Main.selectedCustomer != null){
			Main.selectedCustomer = null;
			Main.selectedCustomerIndex  = -1;
		}
		myController.unloadScreen(Main.screen2ID);
	    myController.setScreen(Main.screen1ID);
    }

	@FXML
	private void saveCustomer(ActionEvent event) {
	if(isValidCustomerData()){
		if (Main.selectedCustomer != null) {

			Main.selectedCustomer.setFirstName(firstNameField.getText());
			Main.selectedCustomer.setLastName(lastNameField.getText());
			Main.selectedCustomer.setPhoneNumber(phoneNumberField.getText());
			Main.selectedCustomer.setCustomerAddress(customerAddressField.getText());

			Main.customers.set(Main.selectedCustomerIndex, Main.selectedCustomer);
			Main.selectedCustomer = null;
			Main.selectedCustomerIndex = -1;
		} else {

			Main.customers.add(

					new Customer(firstNameField.getText(), lastNameField.getText(), phoneNumberField.getText(),
							customerAddressField.getText()));
		}
		myController.unloadScreen(Main.screen2ID);
		myController.setScreen(Main.screen1ID);
	}
	}
    @FXML
    public void addPets(ActionEvent event){
    	myController.loadScreen(Main.screen3ID, Main.screen3File);
        myController.setScreen(Main.screen3ID);
    }
    public void setData(){
    	if(Main.selectedCustomer != null){
    		firstNameField.setText(Main.selectedCustomer.getFirstName());
    		lastNameField.setText(Main.selectedCustomer.getLastName());
    		phoneNumberField.setText(Main.selectedCustomer.getPhoneNumber());
    		customerAddressField.setText(Main.selectedCustomer.getCustomerAddress());

    	}else{
    		btnPets.setVisible(false);
    	}
    }
    private void showAlertWarningMessage(String messageText){
    	Alert a = new Alert(AlertType.WARNING);
		a.setResult(ButtonType.OK);
		a.setHeaderText(messageText);
		a.showAndWait();
    }
    private boolean isValidCustomerData(){
  	String messageText = new String("");

    	if(customerAddressField.getText().equalsIgnoreCase("")) messageText = "Customer Address not entered";
    	if(phoneNumberField.getText().equalsIgnoreCase("")) messageText = "Customer Phone not entered";
    	if(lastNameField.getText().equalsIgnoreCase("")) messageText = "Customer last name not entered";
    	if(firstNameField.getText().equalsIgnoreCase("")) messageText = "Customer first name not entered";

    	if(messageText.length() > 0){
    		showAlertWarningMessage(messageText);
    		return false;
    	}
    	return true;
    }
}
