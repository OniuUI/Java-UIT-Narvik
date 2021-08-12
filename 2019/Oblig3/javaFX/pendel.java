package javaFX;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

public class pendel extends Application {
    private double index = 0;

    @Override
    public void start(Stage primaryStage) {
        pendelPane pane = new pendelPane();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Oppgave Modul 04: Simulere en pendel"); // Title
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(100), e -> {
                    pane.next();
                }));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        pane.setOnMouseClicked(e -> {                           // Pause on Click
            if (animation.getStatus() == Animation.Status.PAUSED)
                animation.play();
            else
                animation.pause();
        });

        pane.requestFocus();
            pane.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.UP)
                    animation.setRate(animation.getRate() + 1); // Speed up on button press Up.

                if (e.getCode() == KeyCode.DOWN)
                    animation.setRate(animation.getRate() - 1); // Speed Down on button press Down.
            });
    }
}



