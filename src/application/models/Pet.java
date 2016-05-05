package application.models;

import application.models.Procedure;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Pet {
	private SimpleStringProperty petName;
	private SimpleStringProperty typeOfAnimal;
	ObservableList<Procedure> procedures =  FXCollections.observableArrayList();


	public ObservableList<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(ObservableList<Procedure> procedures) {
		this.procedures = procedures;
	}

	public Pet(String petName, String typeOfAnimal ){
		this.petName = new SimpleStringProperty(petName);
		this.typeOfAnimal = new SimpleStringProperty(typeOfAnimal);
	}
	public Pet(){

	}

	public void setTypeOfAnimal(String typeOfAnimal2) {
		// TODO Auto-generated method stub
		typeOfAnimal.set(typeOfAnimal2);
	}
	public SimpleStringProperty typeOfAnimalProperty() {
		return this.typeOfAnimal;
	}

	public String getTypeOfAnimalProperty() {
		return typeOfAnimal.get();
	}
	public String getTypeOfAnimal() {
		return typeOfAnimal.get();
	}

	public SimpleStringProperty petNameProperty() {
		return petName;
	}

	public String getPetName(){
		return petName.get();
	}

	public void setPetName(String petName2) {
		petName.set(petName2);
	}

}
