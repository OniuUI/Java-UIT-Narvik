package vehicle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public abstract class Vehicle implements Comparable<Vehicle>,Driveable, Cloneable, Fileable {
    private String color, name, serialNr;
    private int model, price;
    protected int direction;
    protected double speed;
    private GregorianCalendar buyingDate;

    protected Scanner inn = new Scanner(System.in);

    public Vehicle() {
    }

    public Vehicle(String name, String color, int price, int model, String serialNr, int direction) {
        this.color = color;
        this.name = name;
        this.model = model;
        this.price = price;
        this.serialNr = serialNr;
        this.direction = direction;
        this.buyingDate = new GregorianCalendar();
    }

    public void setAllFields() {
        System.out.println("Navn:");
        this.name = inn.next();
        System.out.println("Farge:");
        this.color = inn.next();
        System.out.println("pris:");
        this.price = inn.nextInt();
        System.out.println("model:");
        this.model = inn.nextInt();
        System.out.println("serie nr:");
        this.serialNr = inn.next();
        this.direction = 0;
        this.buyingDate = new GregorianCalendar();

    }

    public void stop(){
        System.out.println("Method stop");
        speed = 0;
    }
    public void breaks(int factor){
        System.out.printf("Method breaks with factor = %d", factor);
    }

    public abstract void turnLeft(int degrees);

    public abstract void turnRight(int degrees);


    // Getter
    public String getName() {
        return name;
    }

    public String getbuyingDate() {
        return buyingDate.getTime().toString();
    }

    public String getColor() {

        return color;
    }

    public String getSerialNr() {

        return serialNr;
    }

    public int getPrice() {

        return price;
    }

    public int getModel() {

        return model;
    }

    public int getDirection() {

        return direction;
    }

    public double getSpeed() {

        return speed * 3.6; //Converted to kilomiters/hour
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public void setModel(int model) {

        this.model = model;
    }

    public void setSerialNr(String serialNr) {

        this.serialNr = serialNr;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setSpeed(double speed) {

        this.speed = speed;
    }

    public int compareTo(Vehicle v){
        if(price > v.price) return 1;
        else if(price < v.price) return -1;
        else return 0;
    }

    public Object clone() throws CloneNotSupportedException {
        Vehicle vehClone = (Vehicle)super.clone();
        vehClone.buyingDate = (GregorianCalendar)this.buyingDate.clone();
        return vehClone;
    }

    public void writeData(PrintWriter out) throws IOException {
        out.print(color);
        out.print(",");
        out.print(name);
        out.print(",");
        out.print(serialNr);
        out.print(",");
        out.print(model);
        out.print(",");
        out.print(price);
        out.print(",");
        out.print(direction);
        out.print(",");
        out.print(speed);
        out.print(",");
        out.print(buyingDate.get(Calendar.YEAR));
        out.print(",");
        out.print(buyingDate.get(Calendar.MONTH));
        out.print(",");
        out.print(buyingDate.get(Calendar.DAY_OF_MONTH));
        out.print(",");
    }

    public void readData(Scanner in) throws IOException {
        color = in.next();
        name = in.next();
        serialNr = in.next();
        model = in.nextInt();
        price = in.nextInt();
        direction = in.nextInt();
        speed = in.nextDouble();
        this.buyingDate = new GregorianCalendar(in.nextInt(), in.nextInt(), in.nextInt());
    }

    @Override
    public String toString() {
        return String.format("Name: %s. Color: %s. Price: %d. Model %s. Serial Nr: %s. Direction: %d. Speed: %.2f. Buying date: %tF",
                this.name, this.color, this.price, this.model, this.serialNr, this.direction, this.speed, this.buyingDate);
    }



}
