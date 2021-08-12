package Oblig4;

import java.io.*;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;

public class GenSig {
    public static void main(String[] args) throws FileNotFoundException {
        String ksName = "C:\\Program Files\\Java\\jdk1.8.0_144\\bin\\keystore";
        char[] spass = {'m','m','a','2','1','2'};

        try {
            //Åpne keystore
            KeyStore ks = KeyStore.getInstance("JKS");
            FileInputStream ksfis = new FileInputStream(ksName);
            BufferedInputStream ksbufin = new BufferedInputStream(ksfis);
            ks.load(ksbufin, spass);

            //Hent ut privat nøkkel
            PrivateKey priv = (PrivateKey) ks.getKey("marius", spass);

            //Hent ut sertifikat og offentliig nøkkel
            Certificate cert = ks.getCertificate("mariuscert");
            PublicKey pubKey = cert.getPublicKey();

            //Lage et signatur-objekt og initialiser det med privatnøkkelen
            Signature dsa = Signature.getInstance("SHA1withRSA");
            dsa.initSign(priv);

            //Oppdater og signer
            File file = new File("C:\\Users\\marius\\Document.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bufin = new BufferedInputStream(fis);
            byte[] buffer = new byte[1024];
            int len;
            while (bufin.available() != 0) {
                len = bufin.read(buffer);
                dsa.update(buffer, 0, len);
            }
            bufin.close();

            //Signer dataen
            byte[] realSig = dsa.sign();
            //lagre signaturen
            FileOutputStream sigfos = new FileOutputStream("C:\\Users\\marius\\sig");
            sigfos.write(realSig);

        } catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
            e.printStackTrace();
        }
    }
}
