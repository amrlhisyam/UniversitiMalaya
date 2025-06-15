package Tut1.newpackage;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class NewClass extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Labels and TextFields for user information
        Label firstNameLabel = new Label("First Name:");
        TextField firstNameField = new TextField();
        
        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameField = new TextField();
        
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        
        // Set prompt text for better UX
        firstNameField.setPromptText("Enter your first name");
        lastNameField.setPromptText("Enter your last name");
        emailField.setPromptText("Enter your email address");
        
        // Submit button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            // Handle form submission
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            
            // Validate the email
            if (EmailValidator.isValidEmail(email)) {
                // Show confirmation page
                ConfirmationPage.display(firstName, lastName, email, () -> {
                    System.out.println("Information confirmed:");
                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("Email: " + email);
                }, () -> {
                    // Handle back action (if needed, do nothing here)
                });
            } else {
                // Show an alert if the email is invalid
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Email");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid email address.");
                alert.showAndWait();
            }
        });

        // HBoxes for each row
        HBox firstNameBox = new HBox(10, firstNameLabel, firstNameField);
        HBox lastNameBox = new HBox(10, lastNameLabel, lastNameField);
        HBox emailBox = new HBox(10, emailLabel, emailField);

        // Set alignment for HBoxes
        firstNameBox.setAlignment(Pos.CENTER_LEFT);
        lastNameBox.setAlignment(Pos.CENTER_LEFT);
        emailBox.setAlignment(Pos.CENTER_LEFT);

        // VBox for vertical alignment of HBoxes
        VBox layout = new VBox(15, firstNameBox, lastNameBox, emailBox, submitButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        
        // Scene and stage setup
        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setTitle("Information Entry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


