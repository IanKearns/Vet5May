package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Action;

import application.ControlledScreen;
import application.Main;
import application.models.Pet;
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

public class PetListController implements Initializable, ControlledScreen{
	ScreensController myController;
	ObservableList<Pet> pets = FXCollections.observableArrayList();
	Pet p;
	@FXML
	public TableView<Pet> tableView;
	public TextField petNameField;
	public TextField typeOfAnimalField;
	public Button savePet;

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
		pets = Main.selectedCustomer.getPets();
		tableView.setItems(pets);
		savePet.setVisible(false);
	}


	// add a customer pet
	@FXML
	public void addCustomerPet(ActionEvent Event){
		if(tableView.getSelectionModel().getSelectedIndex() == -1){
			pets.add(new Pet(petNameField.getText(),typeOfAnimalField.getText()));
			Main.selectedCustomer.setPets(pets);
		}else{
			p.setPetName(petNameField.getText());
			p.setTypeOfAnimal(typeOfAnimalField.getText());
			tableView.getSelectionModel().clearSelection();
		}
		petNameField.setText("");
		typeOfAnimalField.setText("");

	}
	// edit a customer pet
	@FXML
	public void editCustomerPet(ActionEvent Event){
		if(tableView.getSelectionModel().getSelectedIndex() != -1){
		p = tableView.getSelectionModel().getSelectedItem();
		petNameField.setText(p.getPetName());
		typeOfAnimalField.setText(p.getTypeOfAnimalProperty());
		Main.selectedPet= p;
		//savePet.setVisible(true);
		}else{

			Alert a = new Alert(AlertType.WARNING);
			a.setResult(ButtonType.OK);
			a.setHeaderText("You did not Select a Pet");
			a.showAndWait();
		}
	}
	@FXML
	public void deleteCustomerPet(ActionEvent e){
		pets.removeAll(tableView.getSelectionModel().getSelectedItem());
	}

	// go back to customers
	@FXML
	public void backToCustomer(ActionEvent e){
		  myController.unloadScreen(Main.screen3ID);
	      myController.setScreen(Main.screen2ID);
	}
	@FXML
    public void addProcedure(ActionEvent e){
		if(tableView.getSelectionModel().getSelectedIndex() != -1){
			p = tableView.getSelectionModel().getSelectedItem();
			petNameField.setText(p.getPetName());
			typeOfAnimalField.setText(p.getTypeOfAnimalProperty());
			Main.selectedPet= p;
			myController.loadScreen(Main.screen4ID, Main.screen4File);
	        myController.setScreen(Main.screen4ID);
			//savePet.setVisible(true);
			}else{

				Alert a = new Alert(AlertType.WARNING);
				a.setResult(ButtonType.OK);
				a.setHeaderText("You did not Select a Pet");
				a.showAndWait();
			}


	}
}

