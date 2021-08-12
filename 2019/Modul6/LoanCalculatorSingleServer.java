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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class LoanCalculatorSingleServer extends Application {
    private TextArea ta = new TextArea();
    @Override

    public void start(Stage primaryStage) {

        startStage(primaryStage);
        new Thread(this::connectToClient).start();


    }

    private void startStage(Stage primaryStage){
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("The Server"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void connectToClient() {

        try{
            ServerSocket serverSocket = new ServerSocket(8000);
            ta.appendText("Server started at " + new Date() + '\n');
            Socket connectToClient = serverSocket.accept();
            ta.appendText("Connected to a LoanCalculatorClient at " + new Date() + '\n');

            DataInputStream fromClient = new DataInputStream(connectToClient.getInputStream());
            DataOutputStream tooClient = new DataOutputStream(connectToClient.getOutputStream());

            //Transaction Logic
            while(true){
                double ANIR = fromClient.readDouble();
                double LAMT = fromClient.readDouble();
                int NOY = fromClient.readInt();

                Modul6.Loan Calculation = new Loan(ANIR,NOY,LAMT);
                double MohPayment = Calculation.getMonthlyPayment();
                double TotalPayment = Calculation.getTotalPayment();

                tooClient.writeDouble(MohPayment);
                tooClient.writeDouble(TotalPayment);
                tooClient.flush();

                Platform.runLater(() -> ta.appendText(String.format("Annual Interest Rate: %2f %nYears of Payment: %d%nLoan Amount: %2f%n", ANIR,NOY,LAMT)));
                Platform.runLater(() -> ta.appendText(String.format("Monthly payment: %2f%nTotal paryment:  %2f%n", MohPayment, TotalPayment)));


            }
        } catch (IOException ex) {
            ta.appendText('\n' + ex.toString());
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