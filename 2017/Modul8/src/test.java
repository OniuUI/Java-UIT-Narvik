import java.util.*;
import java.io.*;
public class test {
    public final int NUMBER_OF_LETTERS = 26;

    private double[] knownFrequencies = new double[NUMBER_OF_LETTERS];

    public double[] getKnownFrequencies() {
        return knownFrequencies;
    }

    public void setKnownFrequencies(double[] knownFrequencies) {

        this.knownFrequencies = knownFrequencies;
    }

    /**
     * Method reads in a file with a lot of text in it and
     * then use that to figure out the frequencies of each character
     *
     * @param trainingFileName
     */
    public void train(String trainingFileName) {
        try {
            Scanner fileIO = new Scanner(new File(trainingFileName));

            int total = 0;
            String temp = "";

            while (fileIO.hasNext()) {
                //reading into file and storing it into a string called temp
                temp += fileIO.next().toLowerCase().replaceAll("[ -,!?';:.]+", "");
                //converting temp string into a char array
            }

            char[] c = temp.toCharArray();
            total += c.length; // how many characters are in text
            int k = (int) 'a'; // int value of lowercase letter 'a'
            int[] counter = new int[NUMBER_OF_LETTERS];

            for (int j = 0; j < total; j++) {
                for (int i = k - k; i < knownFrequencies.length; i++) {

                    char[] d = new char[knownFrequencies.length];

                    d[i] = (char) (k + i);

                    if (c[j] == d[i]) {//checking to see if char in text equals char in d array

                        counter[i]++;

                        knownFrequencies[i] = (double) counter[i] / total;
                    }
                }
            }

            fileIO.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println(e);
            System.exit(0);
        }
    }


    /**
     * Main decryption method used to take coded text from a file, figure out the positions in the CaesarCipher
     * and then decode it onto another file.
     *
     * @param cipherTextFileName
     * @param outputFileName
     * @return
     */
    public int decrypt(String cipherTextFileName, String outputFileName) {
        Scanner fileIO;
        int numberOfPositions = 0;
        double distance = 0.000000;

        try {
            fileIO = new Scanner(new File(cipherTextFileName));

            PrintWriter writer = new PrintWriter(new File(outputFileName));

            String temp = "";

            while (fileIO.hasNext()) {
                //reading into file and storing it into a string called temp
                temp += fileIO.next().toLowerCase().replaceAll(" ", "");
            }

            fileIO.close();

            do {
                distance = 0.0;
                int total = 0;
                double[] observedFreq = new double[NUMBER_OF_LETTERS];
                temp = decrypt(temp, numberOfPositions);
                char[] c = temp.toCharArray(); //store decrypted chars into an array
                total += c.length; // how many characters are in text

                int k = (int) 'a'; // int value of lowercase letter 'a'
                int[] counter = new int[NUMBER_OF_LETTERS]; //use to count the number of characters in text

                for (int j = 0; j < total; j++) {
                    for (int i = k - k; i < observedFreq.length; i++) {
                        char[] d = new char[observedFreq.length];
                        d[i] = (char) (k + i);
                        if (c[j] == d[i]) { //checking to see if char in text equals char in d array
                            counter[i]++;
                            observedFreq[i] = (double) counter[i] / total;
                        }
                    }
                }

                //Formula for finding distance that will determine the numberOfPositions in CaesarCipher
                for (int j = 0; j < knownFrequencies.length; j++) {
                    distance += Math.abs(knownFrequencies[j] - observedFreq[j]); //This is the part of the code I am having trouble with
                }

                numberOfPositions = numberOfPositions + 1;

            } while (distance > 0.6); //This is the part of the code I am having trouble with

            Scanner fileIO2 = new Scanner(new File(cipherTextFileName));

            while (fileIO2.hasNextLine()) {

                //reading into file and storing it into a string called temp
                temp = fileIO2.nextLine();

                writer.println(decrypt(temp, numberOfPositions));

            }
            writer.close();
            fileIO2.close();
            System.out.println(distance);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println(e);
            System.exit(0);
        }
        return numberOfPositions;

    }

    /**
     * CaesarCipher decrypt and encrypt methods
     *
     * @param ciphertext
     * @param numberOfPositions
     * @return
     */
    public String decrypt(String ciphertext, int numberOfPositions) {
        // TODO Auto-generated method stub
        return encrypt(ciphertext, -numberOfPositions);
    }

    public String encrypt(String msg, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : msg.toCharArray()) {
            if (Character.isLowerCase(i)) {
                int j = (i - 'a' + offset) % 26;
                encoded.append((char) (j + 'a'));
            } else if (Character.isUpperCase(i)) {
                int h = (i - 'A' + offset) % 26;
                encoded.append((char) (h + 'A'));
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

    // barebones main method to test your code
    public static void main(String[] args) {
        // args[0] contains the filename of the training file
        // args[1] contains the filename of the cipher text file
        // args[2] contains the filename of the output file
        test cb = new test();
        cb.train(args[0]);
        System.out.println(cb.decrypt(args[1], args[2]));

    }
}