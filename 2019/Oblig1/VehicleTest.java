package vehicle;

import java.util.*;
import java.io.*;

public class VehicleTest {
    private static ArrayList<Vehicle> arr=new ArrayList<>();
    public static void main(String[] args) {
        File readFile = new File("vehicles.txt");
        if (readFile.exists()) {
            try (Scanner fileRead = new Scanner(readFile).useLocale(Locale.US)) {
                while (fileRead.hasNext()) {
                    fileRead.useDelimiter(",");
                    String vehClass = fileRead.next();             //reads class name as string
                    Class vehicl = Class.forName(vehClass);        //translates string to class name
                    Vehicle veh = (Vehicle) vehicl.newInstance();  //creates vehicle object from class name
                    veh.readData(fileRead);                        //reads field input from file
                    arr.add(veh);                                  //adds vehicle object to list
                    System.out.printf("Read from file: %s\n", veh);
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found exception");
            } catch (IllegalAccessException e) {
                System.out.println("Illegal access exception");
            } catch (InstantiationException e) {
                System.out.println("Instantiation exception");
            } catch (IOException e) {
                System.out.println("IO Exception");
            }

        }

        VehicleTest vtest = new VehicleTest();
        try {
            vtest.menuLoop();
        } catch (IOException e) {
            System.out.println("IO Exception!");
            System.exit(1);
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException");
            System.exit(1);
        }
    }



    private void menuLoop() throws IOException, CloneNotSupportedException {
        Scanner inn = new Scanner(System.in);
        ArrayList<Vehicle> arr = new ArrayList<Vehicle>();
        Vehicle vehicle;

        Vehicle veh1 = new Car("Veh1","Red",85000,2014,"1010-1101",220,180);
        Vehicle bike1 = new Bicycle("Bike1","Blue",5400,2018,"9382-1101",10,0);

        arr.add(new Car("Volvo", "Black", 85000, 2010, "1010-11", 120, 0));
        arr.add(new Bicycle("Diamant", "yellow", 4000, 1993, "BC100", 10, 0));
        arr.add(new Car("Ferrari Testarossa", "red", 1200000, 1996, "A112", 350, 0));
        arr.add(new Bicycle("DBS", "pink", 5000, 1994, "42", 10, 0));
        arr.add(veh1);arr.add(bike1);

        while (true) {
            System.out.println("1...................................New car");
            System.out.println("2...............................New bicycle");
            System.out.println("3......................Find vehicle by name");
            System.out.println("4..............Show data about all vehicles");
            System.out.println("5.......Change direction of a given vehicle");
            System.out.println("6.......................Test Cloning Method");
            System.out.println("7................Testing Drivable Interface");
            System.out.println("8.................Write array data too file");
            System.out.println("9..............................Exit program");
            System.out.println(".............................Your choice?");
            int choice = inn.nextInt();

            switch (choice) {
                case 1:
                    vehicle = new Car();
                    vehicle.setAllFields();
                    arr.add(vehicle);
                    break;
                case 2:
                    vehicle = new Bicycle();
                    vehicle.setAllFields();
                    arr.add(vehicle);
                    break;
                case 3:
                    System.out.println("Name of vehicle.Vehicle: ");
                    String navn = inn.next();
                    for (int i = 0; i < arr.size(); i++) {
                        Vehicle veh = (Vehicle) arr.get(i);
                        if (veh.getName().equals(navn))
                            System.out.println(veh);
                    }
                    break;
                case 4:
                    for (int i = 0; i < arr.size(); i++) {
                        Vehicle veh = (Vehicle) arr.get(i);
                        System.out.printf("%s%n", veh);
                    }
                    break;
                case 5:
                    System.out.println("Name of vehicle.Vehicle: ");
                    navn = inn.next();
                    System.out.println("Direction [R/L]: ");
                    String leftorRight = inn.next();
                    System.out.println("Degrees of movement [0-360]: ");
                    int degrees = inn.nextInt();
                    for (int i = 0; i < arr.size(); i++) {
                        Vehicle veh = (Vehicle) arr.get(i);
                        if (veh.getName().equalsIgnoreCase(navn)) {
                            if (leftorRight.charAt(0) == 'R')
                                veh.turnRight(degrees);
                            else if (leftorRight.charAt(0) == 'L')
                                veh.turnLeft(degrees);
                            else
                                System.out.println("L or R!");
                            System.out.printf("The direction for %s is %d%n", veh.getName(), veh.direction);
                        }
                    }
                    break;
                case 6:

                    Vehicle veh2 = (Vehicle)veh1.clone();
                    // Testing if method worked.
                   if (veh1.getbuyingDate().equals(veh2.getbuyingDate())) {
                    System.out.printf("The date is identical, the cloning has worked\n");
                   }
                   else if (veh1.getbuyingDate().equals(veh2.getbuyingDate())){
                       System.out.println("The date is not identical, the cloning has failed\n");
                   }
                   System.out.printf("Printing the date for the original object Veh1: %s.%nPrinting the date for the cloned object Veh2: %s%nAdding the object to Arraylist.%n", veh1.getbuyingDate(), veh2.getbuyingDate());
                   veh2.setName("Veh2");
                   arr.add(veh2);
                    break;
                case 7:
                    //Car
                    System.out.println("Testing Drivable interface on Veh1 and Bike1.");
                    System.out.printf("Car Accelerated to: %.2f Km/h.%n",veh1.getSpeed());
                    veh1.accelerate(3); // 0.5 m/s
                    System.out.printf("Car Accelerated to: %.2f Km/h.%n",veh1.getSpeed());
                    veh1.accelerate(100); //m/s
                    System.out.printf("Car Accelerated to: %.2f Km/h.%n",veh1.getSpeed());
                    veh1.breaks(5);
                    System.out.printf("Car breaks to speed: %.2f Km/h.%n",veh1.getSpeed());
                    veh1.stop();
                    System.out.printf("Car stops speed: %.2f Km/h.%n",veh1.getSpeed());
                    //Bike
                    System.out.printf("Bike Accelerated to: %.2f Km/h.%n",bike1.getSpeed());
                    bike1.accelerate(3); // 0.5 m/s
                    System.out.printf("Bike Accelerated to: %.2f Km/h.%n",bike1.getSpeed());
                    bike1.accelerate(100); //m/s
                    System.out.printf("Bike Accelerated to: %.2f Km/h.%n",bike1.getSpeed());
                    bike1.breaks(5);
                    System.out.printf("Bike breaks to speed: %.2f Km/h.%n",bike1.getSpeed());
                    bike1.stop();
                    System.out.printf("Bike stops speed: %.2f Km/h.%n",bike1.getSpeed());
                    break;
                case 8:
                    inn.close();
                    java.util.Collections.sort(arr);
                    java.io.File file = new java.io.File("vehicles.txt");

                    // Create file
                    java.io.PrintWriter out = new java.io.PrintWriter(file);
                    for (int i=0; i<arr.size(); i++) {
                        Vehicle veh = (Vehicle)arr.get(i);

                        // Write to file
                        out.print(veh.getClass().getName() + ",");
                        veh.writeData(out);
                        System.out.printf("Written to file: %s%n", veh);
                    }
                    // Close file
                    out.close();
                    System.exit(0);
                     break;

                case 9:
                    inn.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}
