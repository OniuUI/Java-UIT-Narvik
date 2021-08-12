package javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class chess extends Application {
    @Override
    public void start(Stage primaryStage) {
        double widht = 200;
        double height = 200;

        Pane pane = new Pane();
        Rectangle rectangle;

        Scene scene = new Scene(pane, widht, height);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();

        for (int i=0; i<8; i++) {
            boolean isWhite=i%2==0;

            for (int e = 0; e < 8; e++, isWhite = !isWhite) {
                rectangle = new Rectangle(i*widht/8,e*height/8,widht/8,height/8);
                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(isWhite ? Color.WHITE: Color.BLACK);
                pane.getChildren().add(rectangle);
            }
        }
    }
}
