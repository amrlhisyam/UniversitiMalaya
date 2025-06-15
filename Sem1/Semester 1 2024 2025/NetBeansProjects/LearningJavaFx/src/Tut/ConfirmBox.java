
package Tut;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
public class ConfirmBox {
    
    static boolean answer;
    
    public static boolean display (String title, String message){
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setWidth(350);
    Label label = new Label ();
    label.setText(message);
    
    // Create two buttons
    Button yesButton = new Button("yes");
    Button noButton = new Button("no");
    
    yesButton.setOnAction(e ->{
            answer = true;
            window.close();
    });
    noButton.setOnAction(e ->{
            answer = false;
            window.close();
    });
    
    
    VBox layout = new VBox(10);
    layout.getChildren().addAll(label,noButton,yesButton);
    layout.setAlignment(Pos.CENTER);
    Scene scene = new Scene(layout,300,250);
    window.setScene(scene);
    window.showAndWait();
    
    return answer;
    }
}

