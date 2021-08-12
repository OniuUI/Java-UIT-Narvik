package javaFX;

import javafx.application.Application;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;


public class circleandSquare extends Application {
    private Rectangle rectangle = new Rectangle();
    private Circle circle = new Circle();
    private Pane centerPane = new Pane();
    private Node last = rectangle;
    private Label status = new Label();
    private Rotate rot = new Rotate(0);
    private double angle = 0;

    @Override
    public void start(Stage primaryStage) {

            Button btnRectangle = new Button("Rectangle"); //New Button Rectangle.Object
            Button btnCircle = new Button("Circle"); //New Button Circle.Object
            Button btnRed = new Button("Red"); //New Button Red
            Button btnBlue = new Button("Blue"); //New Button Blue
            Button btnRotate = new Button("Rotate"); //New Button Rotate

        HBox hBoxBottom = new HBox();
        hBoxBottom.setAlignment(Pos.CENTER);
        hBoxBottom.getChildren().addAll(btnRectangle, btnCircle);

        StackPane stackPaneTop = new StackPane();
        stackPaneTop.getChildren().add(status);

        VBox vBoxLeft = new VBox();
        vBoxLeft.setAlignment(Pos.CENTER);
        vBoxLeft.getChildren().addAll(btnRed, btnBlue);

        VBox vBoxRight = new VBox();
        vBoxRight.setAlignment(Pos.CENTER);
        vBoxRight.getChildren().add(btnRotate);

        centerPane.setStyle("-fx-border-color: grey");

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(centerPane);
        borderPane.setBottom(hBoxBottom);
        borderPane.setTop(stackPaneTop);
        borderPane.setLeft(vBoxLeft);
        borderPane.setRight(vBoxRight);

        btnRectangle.setOnAction(e -> createRectangle());
        btnCircle.setOnAction(e -> createCircle());
        btnRed.setOnAction(e -> last.setStyle("-fx-fill: red")); //Color for Button 1
        btnBlue.setOnAction(e -> last.setStyle("-fx-fill: blue")); //Color for Button 2
        btnRotate.setOnAction(e -> {
            angle += 45;
            last.setRotate(angle);
        });
        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setTitle("Oppgave Modul 04: Tegne sirkel og firkant"); //Title
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createCircle() {
        circle = new Circle(getX(30), getY(30), 30);
        circle.setStyle("-fx-stroke: grey;-fx-fill: white");
        centerPane.getChildren().clear();
        centerPane.getChildren().add(rectangle);
        centerPane.getChildren().add(circle);
        circle.setOnMouseClicked(e -> last = circle);
        last = circle;
        setText();
    }

    private void createRectangle() {
        rectangle = new Rectangle(getX(60), getY(60), 60, 60);
        rectangle.setStyle("-fx-stroke: grey;-fx-fill: white");
        centerPane.getChildren().clear();
        centerPane.getChildren().add(rectangle);
        centerPane.getChildren().add(circle);
        rectangle.setOnMouseClicked(e -> last = rectangle);
        last = rectangle;
        setText();
    }

    private void setText() {
        status.setText("Square on " + "X: " + (int) rectangle.getX() + ", " + "Y: " +(int) rectangle.getY() +
                ", Circle on " + "X: " +(int) circle.getCenterX() + ", " + "Y: " +(int) circle.getCenterY());
    }

    private int getX(int size) {
        Random rand = new Random();
        int paneWidth = (int) centerPane.getWidth();
        int x = rand.nextInt(paneWidth);
        if (x + size > paneWidth) x -= size;
        if (x - size < 0) x += size;
        return x;
    }

    private int getY(int size) {
        Random rand = new Random();
        int paneHeight = (int) centerPane.getHeight();
        int y = rand.nextInt(paneHeight);
        if (y + size > paneHeight) y -= size;
        if (y - size < 0) y += size;
        return y;
    }
}

