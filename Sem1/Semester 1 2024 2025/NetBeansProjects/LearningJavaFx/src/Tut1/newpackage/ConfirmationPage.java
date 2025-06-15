/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tut1.newpackage;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmationPage {
    
    public static void display(String firstName, String lastName, String email, Runnable onConfirm, Runnable onBack) {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Confirm Information");
        window.setWidth(400);
        
        Label label = new Label("Please confirm your information:");
        Label firstNameLabel = new Label("First Name: " + firstName);
        Label lastNameLabel = new Label("Last Name: " + lastName);
        Label emailLabel = new Label("Email: " + email);
        
        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e -> {
            onConfirm.run();
            window.close();
        });
        
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            onBack.run();
            window.close();
        });
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, firstNameLabel, lastNameLabel, emailLabel, confirmButton, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}


