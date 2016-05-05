package application.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer {

	private SimpleStringProperty firstName = new SimpleStringProperty("");;
	private SimpleStringProperty lastName = new SimpleStringProperty("");;
	private SimpleStringProperty phoneNumber = new SimpleStringProperty("");;
	private SimpleStringProperty customerAddress = new SimpleStringProperty("");;
	ObservableList<Pet> pets = FXCollections.observableArrayList();


	private static Pet selectedPet;
	public static int selectedPetIndex = -1;

	public ObservableList<Pet> getPets() {
	 return pets;
	}

	 public void setPets(ObservableList<Pet> pets) {
		 this.pets = pets;
	 }

	public Customer() {
		//this("", "", "", "");
	}

	public Customer(String firstName, String lastName, String phoneNumber, String customerAddress) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.customerAddress = new SimpleStringProperty(customerAddress);

	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String fName) {
		firstName.set(fName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String fName) {
		lastName.set(fName);
	}

	public String getCustomerAddress() {
		return customerAddress.get();
	}

	public void setCustomerAddress(String cAddress) {
		this.customerAddress.set(cAddress);
	}

	public String getPhoneNumber() {
		return phoneNumber.get();
	}

	public void setPhoneNumber(String fName) {
		phoneNumber.set(fName);
	}

	public static Pet getSelectedPet() {
		return selectedPet;
	}

	public static void setSelectedPet(Pet selectedPet) {
		Customer.selectedPet = selectedPet;
	}

	public ObservableList<Invoice> getInvoiceData() {
		ObservableList<Invoice> InvoiceData = FXCollections.observableArrayList();
		//ObservableList<Pet> pets = this.getPets();
		for(Pet pt : this.getPets()){
			//ObservableList<Procedure> procs = pt.getProcedures();
			// Invoice(String petName,String typeOfAnimal,String type, String price, String paid,String notes){
			for(Procedure pc : pt.getProcedures()){
				//Invoice iv = new Invoice();
				Invoice iv = new Invoice(pt.getPetName(),
						pt.getTypeOfAnimal(),
						pc.getType(),
						pc.getPrice(),
						pc.getPaid(),
						pc.getNotes()
						);

				InvoiceData.add(iv);
			}

		}

		 return InvoiceData;
		}
}