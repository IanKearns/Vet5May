package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.ControlledScreen;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import application.Main;
import application.models.Customer;
import application.models.Invoice;
import application.utils.Utils;


public class CustomerInvoiceController implements Initializable, ControlledScreen{
	ScreensController myController;
	ObservableList<Invoice> invoiceData =  FXCollections.observableArrayList();
	@FXML
	public TableView<Invoice> tableView;
	public Label customerName;
	public Label invoiceTotal;
	@Override
	public void setScreenParent(ScreensController screenParent) {
		// TODO Auto-generated method stub
		myController = screenParent;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setData();
	}

	private void setData() {
		// TODO Auto-generated method stub
		invoiceData = Main.selectedCustomer.getInvoiceData();
		customerName.setText("Customer Invoice for :"
					+ Main.selectedCustomer.getFirstName() + " "
					+ Main.selectedCustomer.getLastName());
		invoiceTotal.setText(this.getInvoiceTotal());
		tableView.setItems(invoiceData);
		//tableView.setItems(Main.customers);

	}
	private String getInvoiceTotal() {
		// TODO Auto-generated method stub
		String returnTotal = "Invoice Total: ";
		Utils util  = new application.utils.Utils();
		int price = 0;
		int paid = 0;
		int total = 0;
		for(Invoice iv : invoiceData){
			if(iv.getPrice().length() > 0 && util.isStringFieldInteger(iv.getPrice())){
				price = Integer.parseInt(iv.getPrice());
			}else{
				price =0;
			}
			if(iv.getPaid().length() > 0 && util.isStringFieldInteger(iv.getPaid())){
				paid = Integer.parseInt(iv.getPaid());
			}else{
				paid =0;
			}
			total += (price - paid);

		}
		returnTotal += String.valueOf(total);
		return returnTotal;
	}

	@FXML
    private void screenBack(ActionEvent event){
	if(Main.selectedCustomer != null){
		Main.selectedCustomer = null;
		Main.selectedCustomerIndex  = -1;
	}
	myController.unloadScreen(Main.screen5ID);
    myController.setScreen(Main.screen1ID);
    }


}
