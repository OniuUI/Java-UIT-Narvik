package vehicle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class Car extends Vehicle {

    private int power;
    private Calendar productionDate;


    public Car() {
    }

    public Car(String name, String color, int price, int model, String serialNr, int power, int direction) {

        super(name, color, price, model, serialNr, direction);
        this.power = power;
    }

    public void setAllFields() {
        super.setAllFields();
        System.out.println("Power: ");
        this.power = inn.nextInt();
    }

    public void turnRight(int degrees) {

        if (degrees <= 360) {
            direction += degrees;
            if (direction > 360)
                direction -= 360;
        }

    }

    public void turnLeft(int degrees) {

        if (degrees <= 360) {
            direction -= degrees;
            if (direction < 0)
                direction += 360;
        }
    }

    // Getter
    public int getPower() {
        return power;
    }

    public Calendar getProductionDate() {
        productionDate = Calendar.getInstance();
        return productionDate;
    }

    public void setProductionDate() {
    }

    // Setter
    public void setPower(int power) {
        this.power = power;
    }




    public String toString() {
        return String.format("%s Power: %dHP Date: %tF.", super.toString(), this.power, this.getProductionDate());
    }

    @Override
    public void accelerate(int speedFactor) {
        if(speed == 0) speed = 0.5*speedFactor;
        else speed *= 0.5*speedFactor;
        if((speed) > Driveable.MAX_SPEED_BIKE) speed = Driveable.MAX_SPEED_BIKE;

    }
    public void breaks(int speedFactor){
        speed = speed / speedFactor;

    }
    @Override
    public void writeData(PrintWriter out) throws IOException {
        super.writeData(out);
        out.print(power);
        out.print(",");
    }
    @Override
    public void readData(Scanner in) throws IOException {
        super.readData(in);
        power = in.nextInt();

    }
}
