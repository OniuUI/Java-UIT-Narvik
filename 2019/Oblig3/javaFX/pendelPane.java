package javaFX;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class pendelPane extends Pane {
    private double w = 500;
    private double angleOffset = 1;
    private double ballRadius = 20;
    private double leftAngle = 128;
    private double rightAngle = 52;
    private double pendelRadius = 365;
    private double tempAngle = leftAngle;

    private Line line = new Line();
    private Circle circle1 = new Circle();
    private Circle circle2 = new Circle();

    public pendelPane() {
        getChildren().addAll(line, circle1, circle2);
        next();
    }

    public void next() {
        double xCeil = w / 2;
        double yCeil = 20;

        if (tempAngle < rightAngle)
            angleOffset = 1;     // Høyre
        else if (tempAngle > leftAngle)
            angleOffset = -1;    // Venstre

        tempAngle += angleOffset;
            double xBall = xCeil + pendelRadius * Math.cos(Math.toRadians(tempAngle));
            double yBall = yCeil + pendelRadius * Math.sin(Math.toRadians(tempAngle));
                line.setStartX(xCeil);
                line.setStartY(yCeil);
                line.setEndX(xBall);
                line.setEndY(yBall);
            circle1.setCenterX(xCeil);
            circle1.setCenterY(yCeil);
            circle1.setRadius(4);
            circle2.setCenterX(xBall);
            circle2.setCenterY(yBall);
            circle2.setRadius(ballRadius);
    }
}

