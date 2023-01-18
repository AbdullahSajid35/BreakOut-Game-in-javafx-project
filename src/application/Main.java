package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class Main extends Application 
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) 
    {
    	
        
        primaryStage.setTitle("MyJavaFX"); // Set the stage title
        primaryStage.setScene(new Scene(new Button("OK"), 200, 250));   
        primaryStage.show();    // Display the stage// Put the scene in the stage
                 // Display the stage

//        Stage stage = new Stage();      // Create a new stage
//        stage.setTitle("Second Stage"); // Set the stage title
//        // Set a scene with a button in the stage
//        stage.setScene(new Scene(new Button("New Stage"), 100, 100));
        primaryStage.setResizable(false);
//        stage.show();  
       
    }
}
//public class Main {
//public static void main(String[]args) {
//	Application.launch(args);
//}
//}
