package application.models;

import javafx.beans.property.SimpleStringProperty;

public class Invoice {

	private SimpleStringProperty petName;
	private SimpleStringProperty typeOfAnimal;
	private  SimpleStringProperty type;
	private  SimpleStringProperty price;
	private SimpleStringProperty notes;
	private SimpleStringProperty paid;

	public Invoice(){

	}
	public Invoice(String petName,String typeOfAnimal,String type, String price, String paid,String notes){
		this.type = new SimpleStringProperty(type);
		this.price = new SimpleStringProperty(price);
		this.notes = new SimpleStringProperty(notes);
		this.paid = new SimpleStringProperty(paid);
		this.typeOfAnimal = new SimpleStringProperty(typeOfAnimal);
		this.petName = new SimpleStringProperty(petName);
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


	public SimpleStringProperty petNameProperty() {
		return petName;
	}

	public String getPetName(){
		return petName.get();
	}

	public void setPetName(String petName2) {
		petName.set(petName2);
	}

	public SimpleStringProperty priceProperty(){
		return price;
	}

	public String getPrice(){
		return price.get();
	}

	public void setPrice(String price2){
		price.set(price2);
	}


	public SimpleStringProperty typeProperty(){
		return type;
	}

	public String getType(){
		return type.get();
	}

	public void setType(String type2){
		type.set(type2);
	}

	public SimpleStringProperty notesProperty(){
		return notes;
	}

	public String getNotes(){
		return notes.get();
	}

	public void setNotes(String notes2){
		notes.set(notes2);
	}

	public SimpleStringProperty paidProperty(){
		return paid;
	}

	public String getPaid(){
		return paid.get();
	}

	public void setPaid(String paid2){
		price.set(paid2);
	}
}
