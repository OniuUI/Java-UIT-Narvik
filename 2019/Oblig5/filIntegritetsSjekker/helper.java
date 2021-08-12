package filIntegritetsSjekker;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;


public class helper {
    /**
     * Recursively searches through targeted directory and
     * returns an arraylist containing these paths.
     *
     * @param path
     * @return
     */
    public static ArrayList<String> getDirectoryAsList(File path) {
        if (path == null) return null;
        ArrayList<String> list = new ArrayList<>();

        for (File file : Objects.requireNonNull(path.listFiles())) {
            if (file.isDirectory()) {
                list.addAll(getDirectoryAsList(file));
                System.out.println("Starting search of directory " + file.getAbsolutePath());
            } else //if (filetypeExecutable(file))
                list.add(file.getAbsolutePath());
        }
        return list;
    }

    /**
     * HashFileToHashMap hashes the value in a <K,V>-map where K represents the
     * path and V the executable file
     *
     * @param list
     * @return
     * @throws IOException
     */
    public static HashMap<String, String> createHashMap(ArrayList<String> list) throws IOException {
        HashMap<String, String> map = new HashMap<>();

        for (String line : list) {
            InputStream inputStream = new FileInputStream(new File(line));
            map.put(line, DigestUtils.sha256Hex(inputStream));
        }
        return map;
    }

    /**
     * Prints the content of the current HashMap to screen.
     * @param map
     */
    public static void printMap(HashMap<String, String> map){
        System.out.println("Writing contents of map: ");
        for (String line : map.keySet()) {
            System.out.println(line + " ; " + map.get(line));
            }
    }

    /**
     * Verifies if the updated map has been changed,
     * compares hashes in map with hashes in file.
     *
     * @param map
     * @param writtenFile
     * @return
     */
    public static boolean verifyHashMapWithFile(HashMap<String, String> map, File writtenFile) { //Must be able to write to file first.
        HashMap postMap = readFileToHashMap(writtenFile);
        boolean trueFalse = true;
        for (String line : map.keySet()) {
            if (!map.get(line).equals(postMap.get(line))) {
                System.out.printf("File that was modified: %s, New Hash: %s%n", line, map.get(line));
                trueFalse = false;
            }
        }
        return trueFalse;
    }

    /**
     * Takes in the filepath of the file to be written, and the hashmap to write to file.
     * Then itterates through the Hashmap and writes the path and hash with a semicolon as a delimiter.
     *
     * @param fileToWrite
     * @param map
     */
    public static void writeHashMapToFile(File fileToWrite, HashMap<String, String> map) throws IOException {
        BufferedWriter writeToFile = new BufferedWriter(new FileWriter(fileToWrite));
        for (String line : map.keySet()) {
            writeToFile.write(line + ";" + map.get(line) + "\n");
        }
        writeToFile.close();
    }

    /**
     * Takes in the filepath of a file that stores previously hashed files,
     * then writes it to a map that lastly is returned.
     *
     * @param path
     * @return
     */
    public static HashMap<String, String> readFileToHashMap(File path) {
        String hash;
        Scanner fileScan = null, hashScan;
        HashMap<String, String> map = new HashMap<>();
        try {
            fileScan = new Scanner(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Read and process each line of the file
        System.out.println("File content: ");
        while (fileScan.hasNext()) {
            hash = fileScan.nextLine();
            System.out.println("Hash: " + hash);

            hashScan = new Scanner(hash);
            hashScan.useDelimiter(";");

            //  Print each hash
            String[] data = new String[2];
            while (hashScan.hasNext()) {
                data[0] = hashScan.next();
                if (hashScan.hasNext())
                    data[1] = hashScan.next();

                map.put(data[0], data[1]);
            }
        }
        System.out.println();
        return map;
    }

    /**
     * Takes in a list of paths and hashes and writes them to a hashmap,
     * then using the *writeHashMaptoFile* the map is written to a file -
     * that is specified by the user. lastly the file is returned.
     * @param list
     * @return
     * @throws IOException
     */
    public static File directoryToHash(ArrayList<String> list) throws IOException {
        // Look for .java files in directory specified by user
      
        HashMap<String, String> map = createHashMap(list);

        System.out.printf("Where would you like to save the hashfile? %n");
        Scanner createHashfile = new Scanner(System.in);
        File path = new File(createHashfile.nextLine());
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        writeHashMapToFile(path, map);
        writer.close();

        return path;
    }

    /**
     * Generates a signature based on the file t hat is created in directoryToHash,
     * the signature file is written to the location specified by the user.
     * @param fileToSign
     */
    public static void genSig(File fileToSign) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter directory for your keystore (Will only work with RSA private keys):");
//        String ksName = scanner.nextLine();
        String ksName = "src\\filIntegritetsSjekker\\keystore";
        System.out.println("Enter password for this keystore:");
        String spass = scanner.next();
        System.out.println("Enter alias for this keystore:");
        String alias = scanner.next();

        try {
            // Open KeyStore
            KeyStore ks = KeyStore.getInstance("JKS");
            FileInputStream ksfis = new FileInputStream(ksName);
            BufferedInputStream ksbufin = new BufferedInputStream(ksfis);
            ks.load(ksbufin, spass.toCharArray());

            // Get Private key
            PrivateKey priv = (PrivateKey) ks.getKey(alias, spass.toCharArray());

            /* Create a Signature object and initialize it with the private key */
            Signature sig = Signature.getInstance("SHA1withRSA", "SunRsaSign");
            sig.initSign(priv);

            /* Update and sign the data */
//            updateData(fileToSign);
            try {
                FileInputStream fis = new FileInputStream(fileToSign);
                BufferedInputStream bufin = new BufferedInputStream(fis);
                byte[] buffer = new byte[1024];
                int len;

                while (bufin.available() != 0) {
                    len = bufin.read(buffer);
                    sig.update(buffer, 0, len);
                }
                bufin.close();
            } catch (Exception e) {
                System.err.println("Caught exception " + e.toString());
            }

            //Sign data
            byte[] realSig = sig.sign();

            /* Save the signature in a file */
            System.out.println("Where do you want to save the signature?");
            String signatureDirectory = scanner.next();
//            String signatureDirectory = "C:\\Users\\Martin\\test\\sig";
            FileOutputStream sigfos = new FileOutputStream(signatureDirectory);
            sigfos.write(realSig);
            sigfos.close();
            System.out.println("Signature created!");

        } catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
        }
    }

    /**
     * Verifies the signature file to see if it's valid,
     * and returns a boolean based if it's valid or not.
     * @param fileToVerify
     * @return
     */
    public static boolean verSig(File fileToVerify) {
        boolean verifies = false;
        try {
            Scanner scanner = new Scanner(System.in);
            String directory = "src\\filIntegritetsSjekker\\MM.cer";
            FileInputStream certfis = new FileInputStream(directory);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            Certificate cert = cf.generateCertificate(certfis);
            PublicKey pub = cert.getPublicKey();

            /* input the signature bytes */
            System.out.println("Enter directory for signature file:");
            String signature = scanner.next();
            FileInputStream sigfis = new FileInputStream(signature);
            byte[] sigToVerify = new byte[sigfis.available()];
            sigfis.read(sigToVerify);
            sigfis.close();

            /* create a Signature object and initialize it with the public key */
            Signature sig = Signature.getInstance("SHA1withRSA", "SunRsaSign");
            sig.initVerify(pub);


            /* Update and verify the data */
            try {
                FileInputStream fis = new FileInputStream(fileToVerify);
                BufferedInputStream bufin = new BufferedInputStream(fis);
                byte[] buffer = new byte[1024];
                int len;

                while (bufin.available() != 0) {
                    len = bufin.read(buffer);
                    sig.update(buffer, 0, len);
                }
                bufin.close();
            } catch (Exception e) {
                System.err.println("Caught exception " + e.toString());
            }

            // Verify signature
            verifies = sig.verify(sigToVerify);
            System.out.println("signature verifies: " + verifies);

        } catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
        }
        return verifies;
    }
}