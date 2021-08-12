package Modul6;

import Helper.Helper;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LoanCalculatorClient extends Application {
    private DataOutputStream toServer = null;
    private DataInputStream fromServer = null;
    private TextArea ta = new TextArea();
    private TextField tfLoanAmount = new TextField();
    private TextField tfNumOfYears = new TextField();
    private TextField tfAnnualInterestRate = new TextField();
    private Button btSubmit = new Button("Submit");


    @Override
    public void start(Stage primaryStage) {


        initializeTextFields();
        setUpAndDisplayPrimaryStage(primaryStage);
        connectToServer();
        btSubmit.setOnAction(e -> ContactServerForResult());


    }
        private GridPane getGridPane() {
            GridPane GrdPane = new GridPane();

            Label Annual = new Label("Annual Interest rate: ");
            GrdPane.add(Annual,0,1);
            GrdPane.add(tfAnnualInterestRate,1,1);

            Label LoanLB = new Label("Loan Amount amount: ");
            GrdPane.add(LoanLB,0,2);
            GrdPane.add(tfLoanAmount,1,2);

            Label YearsLB = new Label("Years of payment: ");
            GrdPane.add(tfNumOfYears,1,3);
            GrdPane.add(YearsLB,0,3);

            GrdPane.add(btSubmit,2, 2 );

            return GrdPane;
        }

      private void initializeTextFields(){
          tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
          tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
          tfNumOfYears.setAlignment(Pos.BOTTOM_RIGHT);
      }

      private void setUpAndDisplayPrimaryStage(Stage primaryStage){

          BorderPane mainPane = new BorderPane();
          mainPane.setCenter(new ScrollPane(ta));
          mainPane.setTop(getGridPane());

          Scene scene = new Scene(mainPane, 450, 200);
          primaryStage.setTitle("The Client");
          primaryStage.setScene(scene);
          primaryStage.show();

      }

      private void connectToServer(){
          try {
              // Create a socket to connect to the LoanCalculatorSingleServer
              Socket socket = new Socket("localhost", 8500);
              // Socket socket = new Socket("130.254.204.36", 8000);
              // Socket socket = new Socket("drake.Armstrong.edu", 8000);

              // Create an input stream to receive data from the LoanCalculatorSingleServer
              fromServer = new DataInputStream(socket.getInputStream());

              // Create an output stream to send data to the LoanCalculatorSingleServer
              toServer = new DataOutputStream(socket.getOutputStream());
              ta.appendText("Connected to LoanCalculatorSingleServer!" + '\n');
          }
          catch (IOException ex) {
              ta.appendText(ex.toString() + '\n' + "Failed to connect to LoanCalculatorSingleServer, make sure LoanCalculatorSingleServer is running." + '\n');
          }
      }
      private void ContactServerForResult(){
        double ANIR = Helper.getDoubleFromTextField(tfAnnualInterestRate);
        double LAMT = Helper.getDoubleFromTextField(tfLoanAmount);
        int NOY = Helper.getIntegerFromTextField(tfNumOfYears);

          try {
              toServer.writeDouble(ANIR);
              toServer.writeDouble(LAMT);
              toServer.writeInt(NOY);
              toServer.flush();
              double MohPayment = fromServer.readDouble();
              double TotalPayment = fromServer.readDouble();
             Platform.runLater(() -> ta.appendText(String.format("Annual Interest Rate: %2f %nYears of Payment: %d%nLoan Amount: %2f%n", ANIR,NOY,LAMT)));
             Platform.runLater(() -> ta.appendText(String.format("Monthly payment: %2f%nTotal paryment:  %2f%n", MohPayment, TotalPayment)));


          } catch (IOException e) {
              e.printStackTrace();
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