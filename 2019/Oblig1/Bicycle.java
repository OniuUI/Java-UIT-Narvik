package vehicle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;


public class Bicycle extends Vehicle {
    private int gears;
    private Calendar productionDate;


    public Bicycle() {
    }

    public Bicycle(String name, String color, int price, int model, String serialNr, int gears, int direction) {
        super(name, color, price, model, serialNr, direction);
        this.gears = gears;
    }

    public void setAllFields() {
        super.setAllFields();
        System.out.println("Antall gir: ");
        this.gears = inn.nextInt();
    }

    public void turnLeft(int degrees) {

        if (degrees <= 360) {
            direction += degrees;
            if (direction > 360)
                direction -= 360;
        }
    }

    public void turnRight(int degrees) {
        if (degrees <= 360) {
            direction -= degrees;
            if (direction < 0)
                direction += 360;
        }
    }

    // Getter
    public int getGears() {
        return this.gears;
    }

    public Calendar getProductionDate() {

        productionDate = Calendar.getInstance();
        return productionDate;
    }

    // Setter
    public void setGears(int gears) {
        this.gears = gears;
    }

    public void setProductionDate() {
    }


    public String toString() {
        return String.format("%s Gears: %d Production Date: %tF.", super.toString(), this.gears, this.getProductionDate());
    }


    @Override
    public void accelerate(int speedFactor) {
        if(speed == 0) speed = 0.3*speedFactor;
        else speed *= speedFactor*0.5;
        if((speed) > Driveable.MAX_SPEED_BIKE) speed = Driveable.MAX_SPEED_BIKE;

    }

    public void breaks(int speedFactor){
        speed = speed / speedFactor;
    }
    @Override
    public void writeData(PrintWriter out) throws IOException {
        super.writeData(out);
        out.print(gears);
        out.print(",");
    }
    @Override
    public void readData(Scanner in) throws IOException {
        super.readData(in);
        gears = in.nextInt();
    }
}
