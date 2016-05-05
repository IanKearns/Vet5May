package application;

import application.controllers.ScreensController;
import application.models.Customer;
import application.models.Pet;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import java.sql.*;


public class Main extends Application {
    public static String screen1ID = "main";
    public static String screen1File = "/application/views/CustomerList.fxml";
    public static String screen2ID = "customer";
    public static String screen2File = "/application/views/Customer.fxml";
    public static String screen3ID = "pets";
    public static String screen3File = "/application/views/PetList.fxml";
    public static String screen4ID = "procedures";
    public static String screen4File = "/application/views/PetProcedures.fxml";
    public static String screen5ID = "invoices";
    public static String screen5File = "/application/views/CustomerInvoice.fxml";


	public static ObservableList<Customer> customers = FXCollections.observableArrayList();
	public static Customer selectedCustomer;
	public static int selectedCustomerIndex = -1;
	public static Pet selectedPet;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/PETCLINIC?autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASS = "password";

	@Override
	public void start(Stage primaryStage) {
		try {
			ScreensController mainContainer = new ScreensController();

			mainContainer.loadScreen(Main.screen1ID, Main.screen1File);
	        mainContainer.setScreen(Main.screen1ID);

	        Group root = new Group();
	        root.getChildren().addAll(mainContainer);
	        Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		if(1 ==0 ){
		Connection conn = null;
		Statement stmt = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM PETS";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		rs.close();
		stmt.close();
		conn.close();

		}catch(SQLException se){
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		launch(args);
	}
}
