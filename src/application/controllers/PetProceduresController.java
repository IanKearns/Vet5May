package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Action;

import application.ControlledScreen;
import application.Main;
import application.models.Customer;
import application.models.Procedure;
import application.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PetProceduresController implements Initializable, ControlledScreen{
	ScreensController myController;
	ObservableList<Procedure> procedures = FXCollections.observableArrayList();
	Procedure p;
	@FXML
	public TableView<Procedure> tableView;
	public TextField typeField;
	public TextField priceField;
	public TextField notesField;
	public TextField paidField;
	public Button saveProcedure;
    /**
     *
     */
	@Override
	public void setScreenParent(ScreensController screenParent) {
		// TODO Auto-generated method stub
		 myController = screenParent;

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setData();
	}

	private void setData() {
		//procedures = Customer.selectedPet.getProcedures();
		procedures = Main.selectedPet.getProcedures();
		tableView.setItems(procedures);
		//saveProcedure.setVisible(false);
	}


	// add a customer pet
	@FXML
	public void addPetProcedure(ActionEvent Event){
	if(this.isValidProcedureData()){
		if(tableView.getSelectionModel().getSelectedIndex() == -1){
			procedures.add(new Procedure(typeField.getText(),priceField.getText(),notesField.getText(),paidField.getText()));
			//Customer.getSelectedPet().setProcedures(procedures);
			Main.selectedPet.setProcedures(procedures);
		}else{
			p.setType(typeField.getText());
			p.setPrice(priceField.getText());
			p.setNotes(notesField.getText());
			p.setPaid(paidField.getText());
		}
		typeField.setText("");
		priceField.setText("");
		notesField.setText("");
		paidField.setText("");
	}
	}
	// edit a pet's procedure
	@FXML
	public void editPetProcedure(ActionEvent Event){

		if(tableView.getSelectionModel().getSelectedIndex() != -1){
		p = tableView.getSelectionModel().getSelectedItem();
		typeField.setText(p.getType());
		priceField.setText(p.getPrice());
		notesField.setText(p.getNotes());
		paidField.setText(p.getPaid());

		//savePet.setVisible(true);
		}else{

			Alert a = new Alert(AlertType.WARNING);
			a.setResult(ButtonType.OK);
			a.setHeaderText("You did not Select a Procedure");
			a.showAndWait();
		}

	}
	@FXML
	public void deletePetProcedure(ActionEvent e){
		procedures.removeAll(tableView.getSelectionModel().getSelectedItem());
	}

	// go back to pets
	@FXML
	public void backToPetList(ActionEvent e){
		myController.loadScreen(Main.screen3ID, Main.screen3File);
        myController.setScreen(Main.screen3ID);
	}
	@FXML
    private void savePetProcedure(ActionEvent event){
		if(tableView.getSelectionModel().getSelectedIndex() != -1){
		p = tableView.getSelectionModel().getSelectedItem();
		p.setNotes(notesField.getText());
		p.setPaid(paidField.getText());
		p.setPrice(priceField.getText());
		p.setType(typeField.getText());
		tableView.getSelectionModel().clearSelection();
		}
	}
    private void showAlertWarningMessage(String messageText){
    	Alert a = new Alert(AlertType.WARNING);
		a.setResult(ButtonType.OK);
		a.setHeaderText(messageText);
		a.showAndWait();
    }
    private boolean isValidProcedureData(){

    	String messageText = new String("");
    	Utils u = new application.utils.Utils();

        if(notesField.getText().equalsIgnoreCase("")) messageText = "No notes entered";
        if(paidField.getText().length() > 0 &&
        		!u.isStringFieldInteger(paidField.getText())) messageText = "Paid value must be numeric";
        if(priceField.getText().length() > 0 &&
        		!u.isStringFieldInteger(priceField.getText())) messageText = "Price value must be numeric";
        if(typeField.getText().equalsIgnoreCase("")) messageText = "Procedure type must be entered";

        if(messageText.length() > 0){
        		showAlertWarningMessage(messageText);
        		return false;
        }
        return true;
     }

}