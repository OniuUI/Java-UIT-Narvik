package Oblig4;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.PublicKey;
import java.security.Signature;

public class VerSig {

    public static void main(String[] args) {
        //Verify a DSA signature
        try {
            FileInputStream certfis = new FileInputStream("C:\\Program Files\\Java\\jdk1.8.0_144\\bin\\marius.cer");
            java.security.cert.CertificateFactory cf =
                    java.security.cert.CertificateFactory.getInstance("X.509");
            java.security.cert.Certificate cert = cf.generateCertificate(certfis);
            PublicKey pub = cert.getPublicKey();

            /* Input the signature bytes into a byte array named sigToVerify */
            FileInputStream sigfis = new FileInputStream("C:\\Users\\marius\\sig");
            byte[] sigToVerify = new byte[sigfis.available()];
            sigfis.read(sigToVerify);
            sigfis.close();

            /* Verify the signature */
            /* Initialize the signature object for verification */
            /* Sjekk at det er samme algoritme som sender laget den med */
            Signature sig = Signature.getInstance("SHA256withRSA");
            sig.initVerify(pub);

            /* Supply the signature object with the data to be verified */
            /*read in the data one buffer at a time, and supply it to the Signature object by calling the update method.*/
            FileInputStream datafis = new FileInputStream("C:\\Users\\marius\\Document.txt");
            BufferedInputStream bufin = new BufferedInputStream(datafis);

            byte[] buffer = new byte[1024];
            int len;
            while (bufin.available() != 0) {
                len = bufin.read(buffer);
                sig.update(buffer, 0, len);
            }
            bufin.close();

            /* Verify the signature */
            boolean verifies = sig.verify(sigToVerify);
            System.out.println("Signature verifies: " + verifies);

        } catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
            e.printStackTrace();
        }
    }
}
