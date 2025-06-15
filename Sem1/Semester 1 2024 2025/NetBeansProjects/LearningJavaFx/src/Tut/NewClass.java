package Tut ; 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewClass extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Email Registration");

        // Create a GridPane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Create the email label and text field
        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 0);

        TextField emailInput = new TextField();
        GridPane.setConstraints(emailInput, 1, 0);

        // Create the submit button
        Button submitButton = new Button("Register");
        GridPane.setConstraints(submitButton, 1, 1);

        // Add action to the button
        submitButton.setOnAction(e -> {
            String email = emailInput.getText();
            // Here you can add your registration logic (e.g., validation, storing, etc.)
            System.out.println("Registered email: " + email);
            emailInput.clear(); // Clear the input field after submission
        });

        // Add all components to the grid
        grid.getChildren().addAll(emailLabel, emailInput, submitButton);

        // Create a scene and set the stage
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}