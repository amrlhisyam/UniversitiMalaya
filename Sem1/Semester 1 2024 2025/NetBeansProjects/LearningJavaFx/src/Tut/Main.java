
package Tut;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    
    Stage window ; 
    Button button;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("thenewboston");
        
        button = new Button("click me");
        button.setOnAction(e -> {
        boolean result = ConfirmBox.display("Title of window" , " Are ypu sure want to send naked pic");
            System.out.println(result);
        });
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene (layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
