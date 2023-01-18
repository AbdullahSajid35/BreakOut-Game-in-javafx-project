package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Lab15 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// making the interface using label and textfield
		Label lblName = new Label("User Name:");
		TextField txtName = new TextField();		
		
		Label lblPassword = new Label("Password:");
		PasswordField txtPassword = new PasswordField();
		
		Label lblEmail = new Label("Email:");
		TextField txtEmail = new TextField();
		
		Label lblAdress = new Label("Adress");
		TextField txtAdress = new TextField();
		
		// making the checkbox 
		Label lblSubjects = new Label("Subjects:");
		CheckBox one = new CheckBox("OOP");
		CheckBox two = new CheckBox("DB");
		CheckBox three = new CheckBox("Web");
		CheckBox four = new CheckBox("Android");
		HBox checkbox = new HBox(lblSubjects,one , two , three , four);
		checkbox.setSpacing(15);
		
		// making the radio button
		Label lblGender = new Label("Gender:");
		ToggleGroup tg = new ToggleGroup();
		RadioButton r1 = new RadioButton("Male");
		RadioButton r2 = new RadioButton("Female");
		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		HBox gender = new HBox(lblGender,r1 , r2);
		gender.setSpacing(20);
		
		// making the choice box
		Label lblCity = new Label("City");
		ChoiceBox<String> c = new ChoiceBox<String>(FXCollections.observableArrayList("Pindi", "Islamabad", "Lahore", "Attock","Peshawar"));
		
		Button addbtn = new Button("Add User");

		// making the gridpane for initial interface named (root)
		GridPane root = new GridPane();
		
		// adding constraints for the expansion of text fields
		ColumnConstraints cons1 = new ColumnConstraints();
		 cons1.setHgrow(Priority.NEVER);
		 ColumnConstraints cons2 = new ColumnConstraints();
		 cons2.setHgrow(Priority.ALWAYS);
		root.getColumnConstraints().addAll(cons1 , cons2);
		root.setPadding(new Insets(30));
		root.setHgap(10);
		root.setVgap(10);
		
		// adding all the nodes(elements) to the root (initial interface)
		root.add(lblName , 0 , 0);
		root.add(txtName , 1 , 0);
//		
		root.add(lblPassword , 0 , 1);
		root.add(txtPassword , 1 , 1);
//		
		root.add(lblEmail , 0 , 2);
		root.add(txtEmail , 1 , 2);
//		
		root.add(lblAdress , 0 , 3);
		root.add(txtAdress , 1 , 3);
		
		
		// making the gridpane named root2, also for initial interface but for elements other than textfields
		VBox root2 = new VBox();
		root2.setSpacing(10);
		root2.setPadding(new Insets(10 , 0 , 0 , 120));
		
		HBox HCity = new HBox(lblCity , c);
		
		
		
		// adding all the nodes(elements) to the second gridpane
		addbtn.setTranslateX(300);
		root2.getChildren().addAll(checkbox,gender,HCity,addbtn);
		
		
		
		// event handling after clicking the button
		addbtn.setOnAction(e -> {
			// initializing all the variables for printing after the button
			String selectedName = "";
			String selectedPassword = "";
			String selectedEmail = "";
			String selectedAdress = "";
			String selectedSubjects = "";
			String selectedCity = "";
			String selectedGender = "";
			
			// getting the value from the checkbox
			if (one.isSelected())
			{
			selectedSubjects += "OOP ";
			}
			   
			if (two.isSelected())
			{
			selectedSubjects += "DB ";
			}
			    
			if (three.isSelected())
			{
			selectedSubjects += "Web ";
			}
			     
			if (four.isSelected())
			{
			selectedSubjects += "Android ";
			}    
			
			// getting all the value from the text fields and others
			selectedName = txtName.getText();
			selectedPassword = txtPassword.getText();
			selectedEmail = txtEmail.getText();
			selectedAdress = txtAdress.getText();
			selectedCity = c.getValue();
			RadioButton rb = (RadioButton) tg.getSelectedToggle(); 
			selectedGender = rb.getText();

			// Printing all the labels after clicking on button
			Label confirmationButton = new Label("Add User Button pressed");
			confirmationButton.setTextFill(Color.RED);
			Label lblNamePrint = new Label("user name: " + selectedName);
			Label lblPasswordPrint = new Label("password: " + selectedPassword);
			Label lblEmailPrint = new Label("email: " + selectedEmail);
			Label lblAdressPrint = new Label("Adress: " + selectedAdress);
			Label lblSubjectsPrint = new Label("You selected " + selectedSubjects + " as Subjects");
			Label lblCityPrint = new Label("you choose " + selectedCity);
			Label lblGenderPrint = new Label(selectedGender + " selected");
			
			
			// Labeling error and designing them
			Label err = new Label("error. Please fill all the fields.");
			err.setTextFill(Color.RED);
			err.setFont(new Font("Arial", 30));
			Label noerr = new Label("");
			noerr.setTextFill(Color.RED);
			
			// Checking the conditions for error message
			VBox Vdetails = new VBox( (selectedName.equals("") || selectedPassword.equals(""))
									|| selectedEmail.equals("") || selectedAdress.equals("") 
									? err :noerr ,
									confirmationButton , lblNamePrint , lblPasswordPrint , lblEmailPrint , 
									lblAdressPrint , lblSubjectsPrint , lblCityPrint , lblGenderPrint);
			Vdetails.setSpacing(10);
			root2.getChildren().add(Vdetails );
		});
		
		VBox finalVBox = new VBox(root , root2);
		
		Scene scene = new Scene(finalVBox , 600 , 800);
		

		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
 public static void main(String[]args) {
	 launch(args);
 }
}