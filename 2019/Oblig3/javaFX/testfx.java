package javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class testfx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btOK = new Button("OK");
        Button btCancel = new Button("Cancel");

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("The OK button is clicked");
            }
        };

        btCancel.setOnAction(handler);
        btOK.setOnAction(e -> {System.out.println("Handle the event");});

        HBox pane = new HBox(5);
        pane.getChildren().addAll(btOK, btCancel);

        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("Test"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}


