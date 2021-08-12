package filIntegritetsSjekker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class filIntegritetsSjekker {

    /**
     * Main method for running hasing operations and verifying them.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Scanner userChoice = new Scanner(System.in);
        ArrayList<String> list = null;
        HashMap<String, String> map;
        File dir;


        while (true) {
            System.out.println(".........................Select your choice");
            System.out.println("1.....................Generate new Hashfile");
            System.out.println("2.............Verify hashed and signed file");
            String choice = userChoice.next();
            
            switch (choice) {
                case "1":
                    System.out.println("Enter directory to hash: ");
                    list = helper.getDirectoryAsList(new File(userChoice.next()));
                    dir = helper.directoryToHash(list);
                    helper.genSig(dir);
                    break;
                case "2":
                    if (list == null) {
                        System.out.println("Enter directory to verify: ");
                        list = helper.getDirectoryAsList(new File(userChoice.next()));
                    }
                    map = helper.createHashMap(list);
                    System.out.println("Map updated.");
                    helper.printMap(map);

                    System.out.println("Enter path to file to be verified:");
                    String pathfromuser = userChoice.next();
                    if (helper.verSig(new File(pathfromuser))) {
                        if (!helper.verifyHashMapWithFile(map, new File(pathfromuser))) {
                            System.out.println("File(s) modified, verification failed.");
                        } else
                            System.out.println("File verified! No changes made in file(s)");
                    }
                    System.out.println("Done");
                    break;
                default:
                    System.out.println("Wrong input! Select case 1 or 2.");
            }
        }
    }
}
