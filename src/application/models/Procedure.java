package application.models;


	import javafx.beans.property.SimpleStringProperty;
	//import javafx.collections.FXCollections;



	public class Procedure {

		private  SimpleStringProperty type;
		private  SimpleStringProperty price;
		private SimpleStringProperty notes;
		private SimpleStringProperty paid;

		public Procedure(){

		}

		public Procedure(String type, String price, String notes,String paid){
			this.type = new SimpleStringProperty(type);
			this.price = new SimpleStringProperty(price);
			this.notes = new SimpleStringProperty(notes);
			this.paid = new SimpleStringProperty(paid);

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


