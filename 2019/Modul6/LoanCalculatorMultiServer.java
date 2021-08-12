package Modul6;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class LoanCalculatorMultiServer extends Application {
    private TextArea ta = new TextArea();
    private int clientNo = 1;
    @Override

    public void start(Stage primaryStage) {

        startStage(primaryStage);
        new Thread(this::connectToClient).start();


    }

    private void startStage(Stage primaryStage){
        Scene scene = new Scene(new ScrollPane(ta), 475, 200);
        primaryStage.setTitle("The Server"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void connectToClient() {

        try{
            ServerSocket serverSocket = new ServerSocket(8500);
            ta.appendText("Server started at " + new Date() + '\n');

            //CONNECTION LOGIC
            while (true) {
                Socket connectToClient = serverSocket.accept();

                final int number = clientNo;
                ta.appendText("\nStarting thread for LoanCalculatorClient " + number + " at " + new Date());

                InetAddress ClientIP = connectToClient.getInetAddress();
                ta.appendText("Client " + number + "'s host name is " + ClientIP.getHostName());
                ta.appendText("Client " + number + "'s IP Address is " + ClientIP.getHostAddress() + "\n");
                new LoanCalculatorMultiServer.HandleClient(connectToClient).start();
                clientNo++;

            }
        } catch (IOException ex) {
            ta.appendText('\n' + ex.toString());
        }
    }

    class HandleClient extends Thread{
        private Socket connectToClient;

        private HandleClient(Socket socket){
            connectToClient = socket;
        }
        public void run(){

            //TRANSACTION LOGIC
            try {
                DataInputStream fromClient = new DataInputStream(connectToClient.getInputStream());
                DataOutputStream tooClient = new DataOutputStream(connectToClient.getOutputStream());

                do {
                    double ANIR = fromClient.readDouble();
                    double LAMT = fromClient.readDouble();
                    int NOY = fromClient.readInt();

                    Loan Calculation = new Loan(ANIR, NOY, LAMT);
                    double MohPayment = Calculation.getMonthlyPayment();
                    double TotalPayment = Calculation.getTotalPayment();

                    tooClient.writeDouble(MohPayment);
                    tooClient.writeDouble(TotalPayment);
                    tooClient.flush();

                    Platform.runLater(() -> ta.appendText(String.format("Annual Interest Rate: %2f %nYears of Payment: %d%nLoan Amount: %2f%n", ANIR, NOY, LAMT)));
                    Platform.runLater(() -> ta.appendText(String.format("Monthly payment: %2f%nTotal paryment:  %2f%n", MohPayment, TotalPayment)));
                } while (true);
                } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}