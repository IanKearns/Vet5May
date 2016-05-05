package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.ControlledScreen;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import application.models.Customer;

public class CustomerListController implements Initializable, ControlledScreen {
	ScreensController myController;
	@FXML
	public TableView<Customer> tableView;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	setData();
    }

    private void setData() {
		// TODO Auto-generated method stub
		tableView.setItems(Main.customers);
	}

	public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void addCustomer(ActionEvent event){
       myController.loadScreen(Main.screen2ID, Main.screen2File);
       myController.setScreen(Main.screen2ID);
    }
    @FXML
    private void editCustomer(ActionEvent event){
    	if(tableView.getSelectionModel().getSelectedIndex() != -1){
    	Main.selectedCustomer = tableView.getSelectionModel().getSelectedItem();
    	Main.selectedCustomerIndex = tableView.getSelectionModel().getSelectedIndex();
    	myController.loadScreen(Main.screen2ID, Main.screen2File);
    	myController.setScreen(Main.screen2ID);
    	}else{
			showAlertWarningMessage("You did not Select a Customer");
    	}
    }
    @FXML
    private void deleteCustomer(ActionEvent event){
    	if(tableView.getSelectionModel().getSelectedIndex() != -1){
    	Main.selectedCustomer = tableView.getSelectionModel().getSelectedItem();
    	Main.selectedCustomerIndex = -1;
    	Main.customers.remove(Main.selectedCustomer);
    	}else{
    		showAlertWarningMessage("No Customers record to Select, or none exist");
    	}

    }
    @FXML
    private void invoiceCustomer(ActionEvent event){
    	if(tableView.getSelectionModel().getSelectedIndex() != -1){


    	Main.selectedCustomer = tableView.getSelectionModel().getSelectedItem();
    	Main.selectedCustomerIndex = tableView.getSelectionModel().getSelectedIndex();
    	if(isCustomerInvoiceData()){
    		myController.loadScreen(Main.screen5ID, Main.screen5File);
    		myController.setScreen(Main.screen5ID);
    	}else{
    		showAlertWarningMessage("No Invoices for Customer");
    	}
    	}else{
    		showAlertWarningMessage("No Customers record to Select, or none exist to invoice");
    	}

    }
    private void showAlertWarningMessage(String messageText){
    	Alert a = new Alert(AlertType.WARNING);
		a.setResult(ButtonType.OK);
		a.setHeaderText(messageText);
		a.showAndWait();
    }
    private boolean isCustomerInvoiceData(){
    	// add loop to check pets and their procedures
    	return true;
    }
}
