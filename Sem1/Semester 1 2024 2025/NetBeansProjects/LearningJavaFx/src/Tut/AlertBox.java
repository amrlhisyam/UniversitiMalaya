
package Tut;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
public class AlertBox {
    
    public static void display (String title, String message){
    Stage window = new Stage();
    
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("alert box");
    window.setWidth(350);
    
    Label label = new Label ();
    label.setText(message);
    Button closeButton = new Button("Close the window");
    closeButton.setOnAction(e -> window.close());
    
    VBox layout = new VBox(10);
    layout.getChildren().addAll(label, closeButton);
    layout.setAlignment(Pos.CENTER);
    
    Scene scene = new Scene(layout,300,250);
    window.setScene(scene);
    window.showAndWait();
    }
}
